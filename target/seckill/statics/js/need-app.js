/**
 * Created by jf on 2015/9/11.
 * Modified by bear on 2016/9/7.
 */
$(function () {

    function fastClick(){
        var supportTouch = function(){
            try {
                document.createEvent("TouchEvent");
                return true;
            } catch (e) {
                return false;
            }
        }();
        var _old$On = $.fn.on;

        $.fn.on = function(){
            if(/click/.test(arguments[0]) && typeof arguments[1] == 'function' && supportTouch){ // 只扩展支持touch的当前元素的click事件
                var touchStartY, callback = arguments[1];
                _old$On.apply(this, ['touchstart', function(e){
                    touchStartY = e.changedTouches[0].clientY;
                }]);
                _old$On.apply(this, ['touchend', function(e){
                    if (Math.abs(e.changedTouches[0].clientY - touchStartY) > 10) return;

                    e.preventDefault();
                    callback.apply(this, [e]);
                }]);
            }else{
                _old$On.apply(this, arguments);
            }
            return this;
        };
    }

    // function preload(){
    //     // $(window).on("load", function(){
    //     //     var imgList = [
    //     //         "/statics/img/layers/content.png",
    //     //         "/statics/img/layers/navigation.png",
    //     //         "/statics/img/layers/popout.png",
    //     //         "/statics/img/layers/transparent.gif"
    //     //     ];
    //     //     for (var i = 0, len = imgList.length; i < len; ++i) {
    //     //         new Image().src = imgList[i];
    //     //     }
    //     // });
    // }
    function androidInputBugFix(){
        // .container 设置了 overflow 属性, 导致 Android 手机下输入框获取焦点时, 输入法挡住输入框的 bug
        // 相关 issue: https://github.com/weui/weui/issues/15
        // 解决方法:
        // 0. .container 去掉 overflow 属性, 但此 demo 下会引发别的问题
        // 1. 参考 http://stackoverflow.com/questions/23757345/android-does-not-correctly-scroll-on-input-focus-if-not-body-element
        //    Android 手机下, input 或 textarea 元素聚焦时, 主动滚一把
        if (/Android/gi.test(navigator.userAgent)) {
            window.addEventListener('resize', function () {
                if (document.activeElement.tagName == 'INPUT' || document.activeElement.tagName == 'TEXTAREA') {
                    window.setTimeout(function () {
                        document.activeElement.scrollIntoViewIfNeeded();
                    }, 0);
                }
            })
        }
    }
    function setJSAPI(){
        var option = {
            title: '思播月读',
            desc: '思播月读，提升你的阅读技巧',
            link: "https://test.dxtwangxiao.com/wechat/index",
            imgUrl: 'https://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLA16apETUPXh9Q5GLpSic7lGuiaic0jqMt4UY8P4KHSBpEWgM7uMlbxxnVR7596b3NPjUfwg7cFbfCtA/0',
            success: function (res) {
            }
        };
        $.getJSON('/wechat/validate/sign?url=' + encodeURIComponent(location.href.split('#')[0]), function (res) {
        // $.getJSON('http://90955fe.nat123.cc/wechat/validate/sign?url=' + encodeURIComponent(location.href.split('#')[0]), function (res) {
            wx.config({
                beta: true,
                debug: false, // 关闭调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
                appId: res.appid,
                timestamp: res.timestamp,
                nonceStr: res.nonceStr,
                signature: res.signature,
                jsApiList: [
                    'chooseImage',
                    'previewImage',
                    'uploadImage',
                    'downloadImage',
                    'onMenuShareTimeline',
                    'onMenuShareAppMessage',
                    'onMenuShareQQ',
                    'onMenuShareWeibo',
                    'onMenuShareQZone',
                    'startRecord',
                    'stopRecord',
                    'onVoiceRecordEnd',
                    'translateVoice',
                    // 'setNavigationBarColor',
                    'setBounceBackground',
                    'playVoice',
                    'stopVoice',
                    'uploadVoice',
                    'chooseWXPay',
                    'openAddress',
                    'closeWindow'
                ]
            });
            wx.ready(function () {
                /*
                 wx.invoke('setNavigationBarColor', {
                 color: '#F8F8F8'
                 });
                 */
                wx.invoke('setBounceBackground', {
                    'backgroundColor': '#F8F8F8',
                    'footerBounceColor' : '#F8F8F8'
                });
                // alert(option.success);
                // wx.onMenuShareTimeline(option);
                // wx.onMenuShareQQ(option);
                // wx.onMenuShareAppMessage(option);
            });
        });
    }

    function err_title(msg,code) {
        if(code) {
            console.log(code)
        }
        $("#wrong_msg p").text(msg);
        $('#wrong_msg').fadeIn(100);
        setTimeout(function () {
            $('#wrong_msg').fadeOut(100);
        }, 2000);
    }

    function init(){
        fastClick();
        androidInputBugFix();
        setJSAPI();
        $('body').height($('body')[0].clientHeight);

        // $('body').on('touchmove touchstart', function (event) {
        //     event.preventDefault();
        // });

        window.onerror = function (msg, url, line, col, error) {
            err_title(msg, 500);
        };

        $.ajaxSetup({
            beforeSend: function () {
            },
            complete: function () {

            }
        });

        console.log('=============regist even OK=============')
    }

    init();

    // 解决苹果手机回退不刷新问题
    // var ua = navigator.userAgent;
    // if (ua.indexOf('iPhone') > -1) {//苹果手机
    //     window.onload = function () {
    //         setTimeout(() => {
    //             window.addEventListener("popstate", function (e) {
    //                 // alert("我监听到了浏览器的返回按钮事件啦");
    //                 self.location = document.referrer;
    //             });
    //         }, 500)
    //     }
    // }
    
    

});