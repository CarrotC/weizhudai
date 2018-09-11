/**
 * @Author fin
 * @type {{version: 0.0.1}}
 * @Date 2018-06-02
 */

window.RecorderManager = {

    version: '0.0.1'
};

var util = {
    extend: function (t, s, b) {
        if (s) {
            for (var k in s) {
                if (!b || !t.hasOwnProperty(k)) {
                    t[k] = s[k];
                }
            }
        }
        return t;
    },
    trim: function (str) {
        return str.replace(/(^[ \t\n\r]+)|([ \t\n\r]+$)/g, '');
    },
    /**
     * 深度克隆对象，从source到target
     * @name clone
     * @grammar UM.util.clone(source) => anthorObj 新的对象是完整的source的副本
     * @grammar UM.util.clone(source,target) => target包含了source的所有内容，重名会覆盖
     */
    clone: function (source, target) {
        var tmp;
        target = target || {};
        for (var i in source) {
            if (source.hasOwnProperty(i)) {
                tmp = source[i];
                if (typeof tmp == 'object') {
                    target[i] = util.isArray(tmp) ? [] : {};
                    util.clone(source[i], target[i])
                } else {
                    target[i] = tmp;
                }
            }
        }
        return target;
    }
};

$(function () {

    var _recorders = [];
    var uid = 0;

    var Recorder = RecorderManager.Recorder = function (options) {
        var me = this;
        me.uid = uid++;
        me.options = util.extend(util.clone(options || {}), RECORDER_CONFIG, true);
        me.recording = false;
        me.replaying = false;
        me.replayLocalId = '';
    };
    Recorder.prototype = {

        start: '<a href="javascript:;" class="recorder-start">\n' +
        '<div class="icon record"><img src=\'/statics/img/theme1/record.png\' alt="" class="static"></div>\n' +
        '<div style="width: 100%; text-align: center">开始录音</div>\n' +
        '</a>',

        stop: '<a href="javascript:;" class="recorder-stop">\n' +
        '<div class="icon record"><img src=\'/statics/img/theme1/record-click.png\' alt="" class="active"></div>\n' +
        '<div style="width: 100%; text-align: center">停止录音</div>\n' +
        '</a>',
        replay: '<a href="javascript:;" class="recorder-replay">\n' +
        '<div class="icon playback"><img src=\'/statics/img/theme1/playback.png\' alt="" class="static"></div>\n' +
        '<div style="width: 100%; text-align: center">回放</div>\n' +
        '</a>',
        stopReplay: '<a href="javascript:;" class="recorder-stop-replay">\n' +
        '<div class="icon playback"><img src=\'/statics/img/theme1/playback-click.png\' alt="" class="active"></div>\n' +
        '<div style="width: 100%; text-align: center">停止回放</div>\n' +
        '</a>',

        localId: [],
        serverId: [],
        result: [],

        // onStop: function (opt) {
        //     if(this.recording){
        //
        //     }
        // },
        // _stop: function () {
        //
        // },
        // _start: function () {
        //
        // },
        renderUI: function (tools) {
            this.$container.html('');
            for (var i = 0; i < tools.length; i++) {
                this.$container.append(tools[i]);
            }
        },
        startRecord: function () {
            let that = this;
            // 添加录音状态

            this.localId = [];
            this.serverId = [];
            this.result = "";
            wx.startRecord({
                success: function () {
                    that.recording = true;
                    that.renderUI([recorder.stop, recorder.replay]);
                    // $("#success_msg p").text('正在录音');
                    $('#PFrame').attr("style", "display:flex");
                },
                fail: function () {
                    $("#wrong_msg p").text('开启录音失败，请检查手机是否开启录音权限');
                    $('#wrong_msg').attr("style", "display:flex");
                    // $("#mry-mask").fadeIn();
                    setTimeout(function () {
                        $('#wrong_msg').fadeOut(100);
                        // $("#mry-mask").fadeOut();
                    }, 2000);
                    return false;
                    // alert("打开语音失败");
                }

            });
            var start = Date.now();
            wx.onVoiceRecordEnd({
// 录音时间超过一分钟没有停止的时候会执行 complete 回调
                complete: function (res) {
                    wx.startRecord();
                    var localId = res.localId;
                    that.localId.push(localId);

                    if (that.options.upload) {
                        var serverIndex = that.serverId.length;
                        wx.uploadVoice({
                            localId: localId, // 需要上传的音频的本地ID，由stopRecord接口获得
                            isShowProgressTips: 0, // 默认为1，显示进度提示
                            success: function (res) {
                                that.serverId[serverIndex] = res.serverId; // 返回音频的服务器端ID
                            }
                        });
                    }
                    // FIXME: 此处可能出现翻译进度不一的问题，暂时不考虑
                    if (that.options.translate) {
                        wx.translateVoice({
                            localId: localId, // 需要识别的音频的本地Id，由录音相关接口获得
                            isShowProgressTips: 0, // 不显示进度提示
                            success: function (res) {
                                // alert(res.translateResult); // 语音识别的结果
                                // 添加结果到翻译结果中
                                that.result += res.translateResult;
                            }
                        });
                    }
                }
            });
            var end = Date.now();
            // console.log("一分钟语音上传时间:" + (end - start)+"ms");
        },
        stopRecord: function () {
            let that = this;
            that.recording = false;
            wx.stopRecord({
                success: function (res) {
                    //关闭录音提示
                    var localId = res.localId;
                    that.localId.push(localId);
                    // alert("正在上传的语音Id:" + localId);
                    var start = Date.now();
                    if (that.options.upload) {
                        var serverIndex = that.serverId.length;
                        wx.uploadVoice({
                            localId: localId, // 需要上传的音频的本地ID，由stopRecord接口获得
                            isShowProgressTips: 1, // 默认为1，显示进度提示
                            success: function (res) {
                                that.serverId[serverIndex] = res.serverId; // 返回音频的服务器端ID
                            },
                            fail:function () {
                                $("#wrong_msg p").text('上传语音失败');
                                $('#wrong_msg').attr("style", "display:flex");
                                // $("#mry-mask").fadeIn();
                                setTimeout(function () {
                                    $('#wrong_msg').fadeOut(100);
                                    // $("#mry-mask").fadeOut();
                                }, 2000);
                            }
                        });
                    }
                    // var end = Date.now();
                    // alert("上传时间是：" + (end - start))
                    if (that.options.translate) {
                        wx.translateVoice({
                            localId: localId, // 需要识别的音频的本地Id，由录音相关接口获得
                            isShowProgressTips: 1, // 需要显示提示，禁止用户在未识别结束前进入下一步而导致出错
                            success: function (res) {
                                // alert(res.translateResult); // 语音识别的结果
                                // 添加结果到翻译结果中
                                that.result += res.translateResult;
                                that.fireEvent('finish');
                            },
                            fail:function () {
                                $("#wrong_msg p").text('翻译语音失败');
                                $('#wrong_msg').attr("style", "display:flex");
                                // $("#mry-mask").fadeIn();
                                setTimeout(function () {
                                    $('#wrong_msg').fadeOut(100);
                                    // $("#mry-mask").fadeOut();
                                }, 2000);
                            }
                        });
                    }

                    // end = Date.now();
                    // alert("上传和翻译的时间：" + (end - start)+"ms")
                }
            });
        },
        startReplayVideo: function () {
            let that = this;
            if (that.localId.length == 0) {
                $("#wrong_msg p").text('没有可回放的录音');
                $('#wrong_msg').attr("style", "display:flex");
                // $("#mry-mask").fadeIn();
                setTimeout(function () {
                    $('#wrong_msg').fadeOut(100);
                    // $("#mry-mask").fadeOut();
                }, 2000);
                return false;
                // alert("没有可回放的录音，尚未录音，或录音失败")
                // return;
            }
            that.renderUI([recorder.start, recorder.stopReplay]);
            this.replaying = true;
            that.play(0, that.localId.length);
        },
        stopReplayVideo: function () {
            this.replaying = false;
            wx.stopVoice({
                localId: this.replayLocalId // 需要停止的音频的本地ID，由stopRecord接口获得
            });
        },
        play: function (index, limit) {
            let that = this;
            if (index < limit && this.replaying) {
                wx.playVoice({
                    localId: this.localId[index]// 需要播放的音频的本地ID，由stopRecord接口获得
                });
                this.replayLocalId = this.localId[index];

                wx.onVoicePlayEnd({
                    success: function (res) {
                        // if (index == limit - 1) {
                        //     recorder.renderUI([recorder.start, recorder.replay]);//所有音频播放完成以后，修改界面
                        // }
                        that.play(index + 1, limit);
                    },

                });
            } else {
                that.renderUI([recorder.start, recorder.replay]);
                that.stopReplayVideo();
            }
        },
        getLocalId: function () {
            return this.localId;
        },
        getServerId: function () {
            return this.serverId;
        },
        getResult: function () {
            return this.result;
        },
        getData: function () {
            var data = {};
            data.localId = this.localId;
            data.serverId = this.serverId;
            data.result = this.result;
            return data;
        },

        /**
         * 注册事件监听器
         * @name addListener
         * @grammar editor.addListener(types,fn)  //types为事件名称，多个可用空格分隔
         * @example
         * editor.addListener('selectionchange',function(){
     *      console.log("选区已经变化！");
     * })
         * editor.addListener('beforegetcontent aftergetcontent',function(type){
     *         if(type == 'beforegetcontent'){
     *             //do something
     *         }else{
     *             //do something
     *         }
     *         console.log(this.getContent) // this是注册的事件的编辑器实例
     * })
         */
        addListener: function (types, listener) {
            types = util.trim(types).split(' ');
            for (var i = 0, ti; ti = types[i++];) {
                getListener(this, ti, true).push(listener);
            }
        },
        /**
         * 移除事件监听器
         * @name removeListener
         * @grammar editor.removeListener(types,fn)  //types为事件名称，多个可用空格分隔
         * @example
         * //changeCallback为方法体
         * editor.removeListener("selectionchange",changeCallback);
         */
        removeListener: function (types, listener) {
            types = util.trim(types).split(' ');
            for (var i = 0, ti; ti = types[i++];) {
                util.removeItem(getListener(this, ti) || [], listener);
            }
        },
        /**
         * 触发事件
         * @name fireEvent
         * @grammar editor.fireEvent(types)  //types为事件名称，多个可用空格分隔
         * @example
         * editor.fireEvent("selectionchange");
         */
        fireEvent: function () {
            var types = arguments[0];
            types = util.trim(types).split(' ');
            for (var i = 0, ti; ti = types[i++];) {
                var listeners = getListener(this, ti),
                    r, t, k;
                if (listeners) {
                    k = listeners.length;
                    while (k--) {
                        if (!listeners[k]) continue;
                        t = listeners[k].apply(this, arguments);
                        if (t === true) {
                            return t;
                        }
                        if (t !== undefined) {
                            r = t;
                        }
                    }
                }
                if (t = this['on' + ti.toLowerCase()]) {
                    r = t.apply(this, arguments);
                }
            }
            return r;
        }
    };

    util.extend(RecorderManager, {
        start: '<a href="javascript:;" class="recorder-start">\n' +
        '<div class="icon record"><img src=\'/statics/img/theme1/record.png\' alt="" class="static"></div>\n' +
        '<div  style="width: 100%; text-align: center">开始录音</div>\n' +
        '</a>',

        stop: '<a href="javascript:;" class="recorder-stop">\n' +
        '<div class="icon record"><img src=\'/statics/img/theme1/record-click.png\' alt="" class="active"></div>\n' +
        '<div style="width: 100%; text-align: center">停止录音</div>\n' +
        '</a>',
        replay: '<a href="javascript:;" class="recorder-replay">\n' +
        '<div class="icon playback"><img src=\'/statics/img/theme1/playback.png\' alt="" class="static"></div>\n' +
        '<div style="width: 100%; text-align: center">回放</div>\n' +
        '</a>',
        stopReplay: '<a href="javascript:;" class="recorder-stop-replay">\n' +
        '<div class="icon playback"><img src=\'/statics/img/theme1/playback-click.png\' alt="" class="active"></div>\n' +
        '<div style="width: 100%; text-align: center">停止回放</div>\n' +
        '</a>',

        getRecorder: function (id, opt) {
            var recorder = _recorders[id] || (_recorders[id] = this.createRecorder(id, opt));
            wx.startRecord();
            setTimeout(wx.stopRecord(), 2000);
            return recorder;
        },

        createRecorder: function (id, opt) {
            // alert("开始创建录音界面")
            var recorder = new RecorderManager.Recorder(opt);
            var T = this;
            var $container = this.createUI('#' + id, recorder);
            recorder.$container.on('touchend', '.recorder-start', function () {
                if (recorder.recording) {
                    return;
                }

                recorder.startRecord();
            });
            recorder.$container.on('touchend', '.recorder-stop', function () {
                if (!recorder.recording) {
                    return;
                }
                //把上传语音提示框关闭，设置关闭时间是0
                $("#PFrame").hide();
                recorder.renderUI([recorder.start, recorder.replay]);
                recorder.stopRecord();

            });
            recorder.$container.on('touchend', '.recorder-replay', function () {
                if (recorder.replaying) {
                    return;
                }
                // recorder.renderUI([recorder.start, recorder.stopReplay]);
                recorder.startReplayVideo();
            });
            recorder.$container.on('touchend', '.recorder-stop-replay', function () {
                recorder.renderUI([recorder.start, recorder.replay]);
                if (!recorder.replaying) {
                    return;
                }
                recorder.stopReplayVideo();
            });

            return recorder;
        },


        stopAll: function () {

            for (let i in _recorders) {
                _recorders[i].renderUI([_recorders[i].start, _recorders[i].replay]);
                if (_recorders[i].replaying) {
                    _recorders[i].stopReplayVideo();
                }
                if (_recorders[i].recording) {
                    _recorders[i].stopRecord();
                }
            }

        },

        createUI: function (id, recorder) {
            var $container = $(id);
            $container.addClass('weui-tabbar');
            recorder.$container = $container;
            recorder.container = $container[0];

            this.renderUI($container, [this.start, this.replay]);
            return $container;
        },
        renderUI: function ($container, tools) {
            $container.html('');
            for (var i = 0; i < tools.length; i++) {
                $container.append(tools[i]);
            }
        }
    })

});

/**
 * 获得对象所拥有监听类型的所有监听器
 * @public
 * @function
 * @param {Object} obj  查询监听器的对象
 * @param {String} type 事件类型
 * @param {Boolean} force  为true且当前所有type类型的侦听器不存在时，创建一个空监听器数组
 * @returns {Array} 监听器数组
 */
function getListener(obj, type, force) {
    var allListeners;
    type = type.toLowerCase();
    return ((allListeners = (obj.__allListeners || force && (obj.__allListeners = {})))
        && (allListeners[type] || force && (allListeners[type] = [])));
}

window.RECORDER_CONFIG = {

    // 是否翻译 默认为TRUE
    translate: true,

    // 是否上传微信服务器，默认为TRUE
    upload: true,


};

