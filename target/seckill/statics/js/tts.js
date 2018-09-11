
(function($,sr){
    // debouncing function from John Hann
    // http://unscriptable.com/index.php/2009/03/20/debouncing-javascript-methods/
    var debounce = function (func, threshold, execAsap) {
        var timeout;

        return function debounced () {
            var obj = this, args = arguments;
            function delayed () {
                if (!execAsap)
                    func.apply(obj, args);
                timeout = null;
            }

            if (timeout)
                clearTimeout(timeout);
            else if (execAsap)
                func.apply(obj, args);

            timeout = setTimeout(delayed, threshold || 100);
        };
    };

    // smartresize
    jQuery.fn[sr] = function(fn){  return fn ? this.bind('resize', debounce(fn)) : this.trigger(sr); };

})(jQuery,'smartresize');


var CURRENT_URL = window.location.href.split('#')[0].split('?')[0],
$BODY = $('body'),
    $MENU_TOGGLE = $('#menu_toggle'),
    $SIDEBAR_MENU = $('#sidebar-menu'),
    $SIDEBAR_FOOTER = $('.sidebar-footer'),
    $LEFT_COL = $('.left_col'),
    $RIGHT_COL = $('.right_col'),
    $NAV_MENU = $('.nav_menu'),
    $FOOTER = $('footer');
// Sidebar
function init_sidebar() {
// TODO: This is some kind of easy fix, maybe we can improve this
    var setContentHeight = function () {
        // reset height
        $RIGHT_COL.css('min-height', $(window).height());

        var bodyHeight = $BODY.outerHeight(),
            footerHeight = $BODY.hasClass('footer_fixed') ? -10 : $FOOTER.height(),
            leftColHeight = $LEFT_COL.eq(1).height() + $SIDEBAR_FOOTER.height(),
            contentHeight = bodyHeight < leftColHeight ? leftColHeight : bodyHeight;

        // normalize content
        contentHeight -= $NAV_MENU.height() + footerHeight;

        $RIGHT_COL.css('min-height', contentHeight);
    };

    $SIDEBAR_MENU.find('a').on('click', function(ev) {
        console.log('clicked - sidebar_menu');
        var $li = $(this).parent();

        if ($li.is('.active')) {
            $li.removeClass('active active-sm');
            $('ul:first', $li).slideUp(function() {
                setContentHeight();
            });
        } else {
            // prevent closing menu if we are on child menu
            if (!$li.parent().is('.child_menu')) {
                $SIDEBAR_MENU.find('li').removeClass('active active-sm');
                $SIDEBAR_MENU.find('li ul').slideUp();
            }else
            {
                if ( $BODY.is( ".nav-sm" ) )
                {
                    $SIDEBAR_MENU.find( "li" ).removeClass( "active active-sm" );
                    $SIDEBAR_MENU.find( "li ul" ).slideUp();
                }
            }
            $li.addClass('active');

            $('ul:first', $li).slideDown(function() {
                setContentHeight();
            });
        }
    });

// toggle small or large menu
    $MENU_TOGGLE.on('click', function() {
        console.log('clicked - menu toggle');

        if ($BODY.hasClass('nav-md')) {
            $SIDEBAR_MENU.find('li.active ul').hide();
            $SIDEBAR_MENU.find('li.active').addClass('active-sm').removeClass('active');
        } else {
            $SIDEBAR_MENU.find('li.active-sm ul').show();
            $SIDEBAR_MENU.find('li.active-sm').addClass('active').removeClass('active-sm');
        }

        $BODY.toggleClass('nav-md nav-sm');

        setContentHeight();

        $('.dataTable').each ( function () { $(this).dataTable().fnDraw(); });
    });

    // check active menu
    $SIDEBAR_MENU.find('a[href="' + CURRENT_URL + '"]').parent('li').addClass('current-page');

    $SIDEBAR_MENU.find('a').filter(function () {
        return this.href == CURRENT_URL;
    }).parent('li').addClass('current-page').parents('ul').slideDown(function() {
        setContentHeight();
    }).parent().addClass('active');

    // recompute content when resizing
    $(window).smartresize(function(){
        setContentHeight();
    });

    setContentHeight();

    // fixed sidebar
    if ($.fn.mCustomScrollbar) {
        $('.menu_fixed').mCustomScrollbar({
            autoHideScrollbar: true,
            theme: 'minimal',
            mouseWheel:{ preventDefault: true }
        });
    }
}
$.fn.toJSON = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        var name = this.name;
        var value = this.value;
        var paths = this.name.split(".");
        var len = paths.length;
        var obj = o;
        $.each(paths,function(i,e){
            if(i == len-1){
                if (obj[e]) {
                    if (!obj[e].push) {
                        obj[e] = [obj[e]];
                    }
                    obj[e].push(value || '');
                } else {
                    obj[e] = value || '';
                }
            }else{
                if(!obj[e]){
                    obj[e] = {};
                }
            }
            obj = o[e];
        });
    });
    return o;
};


/**
 * Parse string to integer
 * @param str
 * @param def
 * @returns
 */
function toInt(str, def) {
    var val = parseInt(str, 10);
    return isNaN(val) ? def : val;
}

String.prototype.template=function(data){
    return this.replace(/\{(\w+)\}/g, function(match, key){
        return data[key] ? data[key] : "";
    });
};

function showError(errorFunc, obj, defaultError) {
    if (errorFunc) {
        var func = eval(errorFunc);
        if ($.isFunction(func)) {
            func(obj, defaultError);
            return;
        }
    }
    _showError(obj, defaultError);
}

/**
 * Showing error
 * @param obj
 * @param defaultError
 * @returns {Boolean}
 */
function _showError(obj, defaultError) {
    obj.addClass("has-error").focus();
    var error = obj.data("error");
    if (error) {
        _alert(error);
    }
    else {
        var name = obj.attr("name");
        if (name) {
            defaultError = "字段" + name + "有误," + defaultError;
        }
        _alert(defaultError);
    }
    return false;
}

function _alert() {
    var title = "提示";
    var msg = "";
    var callback = null;
    if (arguments.length == 1) {
        msg = arguments[0];
    }
    else if (arguments.length > 1) {
        title = arguments[0];
        msg = arguments[1];
        if (arguments.length >= 3 && $.isFunction(arguments[2])) {
            callback = arguments[2];
        }
    }
    var html = '<div class="modal fade" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static">';
    html += '<div class="modal-dialog">';
    html += '<div class="modal-content">';

    html += '<div class="modal-header">';
    html += '<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span> </button>';
    html += '<h4 class="modal-title">{title}</h4>';
    html += '</div>';

    html += '<div class="modal-body">{msg}</div>';

    html += '<div class="modal-footer">';
    html += '<button type="button" class="btn btn-primary" data-dismiss="modal">确定</button>';
    html += '</div>';

    html += '</div>';
    html += '</div>';
    html += '</div>';

    html = html.template({title:title, msg:msg});
    try {
        $(html).appendTo(document.body).modal().on('hidden.bs.modal', function() {
            if (callback) {
                callback();
            }
            $(this).remove();
        });
    }
    catch(e) {
        alert(msg);
    }
}

$(document).ajaxStart(function () {
    try {
        //$.AMUI.progress.start();
    }
    catch (e) {
        console.log("Amaze UI is not loaded");
    }
}).ajaxStop(function () {
    try {
        //$.AMUI.progress.done();
    }
    catch (e) {
        console.log("Amaze UI is not loaded");
    }
}).ajaxError(function (e,x,opt) {
    if (x.status == 498) {
        _alert("提示", "会话超时,请重新登录", function () {
            //window.location.href = getContextPath() + "/loginPage";
        });

    }
    //Access is denied
    else if (x.status == 399) {
        _alert("拒绝采访");
    }
});



function getContextPath() {
    $("script").each(function () {
        var s = $(this);
        var context = s.data("context");
        if (context) {
            if (context == '/') {
                context = '';
            }
            return context;
        }
    });
    return '';
}


/**
 * Register events
 * @param elemSelector jquery object,jquery selector or dom
 */
function registerEvent(elemSelector) {
    var elem = !elemSelector ? $(document) : $(elemSelector);
    registerSubmitForm(elem.find(".submit-form"));

    //Ajax link
    elem.find("a.ajax-link").click(function() {
        return ajaxLink($(this));
    });
    //Pagination jump btn
    elem.find(".pagination-btn").click(function(){
        return paginationBtn($(this));
    });
    //Show URL modal
    elem.find(".url-modal-btn").click(function() {
        return _urlModalBtn($(this));
    });
    //Datepicker
    datepicker(elem);
    //Fileupload
    fileupload(elem);
}


function paginationBtn(btn) {
    var input = btn.prev("input");
    var currentPageNo = toInt(input.val(), 0);
    if (currentPageNo <= 0) {
        return _showError(input, "翻页数输入错误");
    }
    var totalPage = toInt(input.data("total-page"), 0);
    if (currentPageNo > totalPage) {
        return _showError(input, "翻页数不能大于"+totalPage);
    }
    var href = btn.attr("href");
    if (href.indexOf("?") == -1) {
        href += "?";
    }
    href += ("&pageNo=" + currentPageNo);
    btn.attr("href", href);
    //return ajaxLink(btn);
    return false;
}

function ajaxLink(link) {
    //var link = $(this);
    var target = link.data("target");
    if (!target) {
        target = link.parents(".ajax-link-ctn:eq(0)");
    }
    else {
        target = $(target);
    }
    if (target.size() == 1) {
        target.load(link.attr("href"), function(response, status, xhr) {
            var cb = link.data("callback");
            if (cb) {
                eval(cb + '(link,target,response)');
            }
            registerEvent(target);
        });
        return false;
    }
    return false;
}

function registerSubmitForm(btns) {
    btns.each(function () {
        var btn = $(this);
        var form = getForm(btn);
        if (!form) {
            return;
        }
        form.submit(function () {
            return submitForm(btn, form);
        });
        btn.click(function () {
            submitForm(btn, form);
            return false;
        });
    })
}
function getForm(btn) {
    var form = btn.data("form");
    if (!form) {
        //FIXME get closest parent
        var forms = btn.parents("form");
        if (forms.size() <= 0) {
            return null;
        }
        return $(forms.get(0));
    }
    else {
        return $(form);
    }
}

/**
 * Submitting form
 * @param btn Trigger jquery btn
 * @returns {Boolean}
 */
function submitForm(btn, form) {

    //TODO Support some routines to create before/after validate method,
    //for example by form id and join some prefix and postfix
    var beforeValidate = btn.data("before-validate");
    var afterValidate = btn.data("after-validate");
    if (beforeValidate && !eval(beforeValidate+"(form,btn)")) {
        return false;
    }
    if (!validateForm(form)) {
        return false;
    }
    if (afterValidate && !eval(afterValidate+"(form,btn)")) {
        return false;
    }
    //Using ajax by default
    var ajaxSubmit = btn.data("ajax-submit")==false ? false : true;
    var ajaxCallback = btn.data("ajax-callback");
    var action = btn.data("action");
    if (!action) {
        action = form.data("action");
    }
    if (!action) {
        action = form.attr("action")
    }
    if (ajaxSubmit) {
        $.post(action, form.serialize()).done(function(data, textStatus, jqXHR){
            if (ajaxCallback) {
                var callback = $(ajaxCallback);
                if (callback.size() > 0) {
                    callback.html(data);
                    registerEvent(callback);
                }
                //FIXME 两个eval是不是可以优化
                else {
                    var cb = eval(ajaxCallback);
                    if ($.isFunction(cb)) {
                        //eval(ajaxCallback + "(form,btn,data,jqXHR)");
                        cb(form, btn, data, jqXHR);
                    }
                }
            }
            else {
                defaultJsonCallback(form, btn, data);
            }
        }).fail(function(jqXHR, textStatus, errorThrown){
            alert("操作失败");
        });
    }
    else {
        //form.submit();
        return true;
    }
    return false;
}

/**
 * Default ajax callback
 * @param form
 * @param me
 * @param data
 */
function defaultJsonCallback(form, btn, data,jqXHR) {
    if (data.resultCode == 0) {
        var label = form.data("ajax-success-mesg");
        alert(label ? label : "操作成功");
    }
    else {
        alert("操作失败,错误为" + data.resultMessage);
    }
}

/**
 * Validate the form
 * @param form A jquery form
 * @returns {Boolean}
 */
function validateForm(form) {
    var inputs = form.find("input,select,textarea");
    var errorFunc = form.data("show-error");
    for (var i = 0; i < inputs.size(); ++i) {
        var item = $(inputs.get(i));
        //Skip disabled one
        if (item.attr("disabled")) {
            continue;
        }
        var val = $.trim(item.val());
        var requiredValue = item.attr("required");
        var required = requiredValue != undefined || requiredValue == "true" || requiredValue == "required";
        var check = required || val.length > 0;
        if (check && val.length <= 0) {
            return showError(errorFunc, item, "必输字段");
        }
        var minlength = toInt(item.attr("minlength"), 0);
        if (minlength > 0 && val.length < minlength) {
            return showError(errorFunc, item, "输入长度最小是" + minlength + "个字符");
        }
        var maxlength = toInt(item.attr("maxlength"), 0);
        if (maxlength > 0 && val.length > maxlength) {
            return showError(errorFunc, item, "输入长度最大是" + minlength + "个字符");
        }
        if (check) {
            var max = parseFloat(item.attr("max"));
            if (check && !isNaN(max)) {
                var intval = parseFloat(val);
                if (isNaN(intval) || intval > max) {
                    return showError(errorFunc, item, "输入值不能大于" + max);
                }
            }
            var min = parseFloat(item.attr("min"));
            if (check && !isNaN(min)) {
                var intval = parseFloat(val);
                if (isNaN(intval) || intval < min) {
                    return showError(errorFunc, item, "输入值不能小于" + min);
                }
            }
            var type = item.data("validate-type");
            var regex = "";
            var defaultError = "";
            if (type == "mobile") {
                regex = /^(13[0-9]|15[0-35-9]|18[0-9]|14[57]|17[0678])\d{8}$/;
                defaultError = "手机号码验证错误";
            }
            else if (type == "email") {
                regex = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
                defaultError = "邮箱验证错误";
            }
            else if (type == "money") {
                regex = /^[1-9]{1}\d*(\.\d{1,2})?$/;
                defaultError = "金额验证错误";
            }
            else if (type == "digit") {
                regex = /^\d+$/;
                defaultError = "数字验证错误";
            }
            var validateRegx = item.data("validate-regex");
            if (validateRegx) {
                regex = new RegExp(validateRegx);
                defaultError = "正则表达式" + validateRegx + "验证错误";
            }
            if (regex && val.length > 0 && !regex.test(val)) {
                return showError(errorFunc, item, defaultError);
            }
        }
    }
    return true;
}

function _urlModalBtn(btn) {
    return _urlModal(btn.data());
}

function _urlModal(options) {
    if (!options.url) {
        console.log("请设置options.url");
        return ;
    }
    var html = '<div class="modal fade" tabindex="-1" role="dialog" aria-hidden="true" data-backdrop="static">';
    html += '<div class="modal-dialog ';
    if (options.dialogClass) {
        html += options.dialogClass;
    }
    html += '" ';
    if (options.style) {
        html += 'style="';
        html += options.style;
        html += '"';
    }
    html += '>';
    html += '</div></div>';
    var dialog = $(html);

    $.get(options.url).done(function (data) {
        dialog.find(".modal-dialog").html(data);
        dialog.appendTo(document.body).modal(options).on('hidden.bs.modal', function() {
            dialog.remove();
        });
        if (shouldRegisterEvent()) {
            registerEvent(dialog);
        }

    }).fail(function () {
        dialog.remove();
        console.log("加载页面失败,请稍后再试");
    }).always(function () {
        //$.AMUI.progress.done();
    });
    return false;
}

var DATE_PICKER_DEFAULT_OPTS = {
    language: 'zh-CN',
    format: 'yyyy-mm-dd',
    autoclose: true,
    todayHighlight: true
};

function datepicker(elem) {
    elem.find('.datepicker').each(function() {
        var bs = $(this);
        var options = $.extend(true, {}, DATE_PICKER_DEFAULT_OPTS, bs.data());
        try {
            bs.datepicker(options);
        }
        catch (e) {
            console.log("datepicker组件js无法调用," + e);
        }
    });
}

function fileupload(elem) {
    elem.find("input[type='file'].fileupload").each(function () {
        var file = $(this);
        var options = file.data();
        if (!options.url) {
            console.log("上传组件url为空");
            return;
        }
        try {
            file.fileupload();
        }
        catch (ex) {
            console.log("上传组件js无法调用," + ex);
            return;
        }
        console.log(options);
        var attrs = ["done", "fail", "add", "progressall"];
        for (var i = 0; i < attrs.length; ++i) {
            _fileuploadCallback(file, options, attrs[i]);
        }
    });
}

function _fileuploadCallback(file, options, attrName) {
    var funcionName = options[attrName];
    if (funcionName) {
        options[attrName] = function (e, data) {
            try {
                eval(funcionName + "(e,data)");
            }
            catch (ex) {
                console.log("函数" + funcionName + "调用失败," + ex);
            }
        };
        file.fileupload('option', attrName, options[attrName]);
    }
}
function shouldRegisterEvent() {
    return $("body").data("register-event") != undefined;
}

$(document).ready(function() {
    init_sidebar();
    if (shouldRegisterEvent()) {
        console.log("=======Register event=========");
        registerEvent();
    }

});
