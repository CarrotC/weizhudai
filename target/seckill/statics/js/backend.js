layui.use(['layer','form'], function(){
    let layer = layui.layer;

    $("body").on('click',".modal-btn", function () {
        var url = $(this).data('url');
        var func = $(this).data('confirmCallback');
        layer.open({
            type: 2,
            content: url,
            area: ['700px','620px'],
            btn: ['提交', '取消'],
            yes: function (index, layero) {
                var form = layer.getChildFrame(".ajax-form", index).serializeArray();
                var formJson = {};
                for(var i = 0; i < form.length; i++){
                    formJson[form[i].name] = form[i].value
                }
                console.log('表单提交', formJson);
                var validate = true;
                if(func){
                    eval("var _func = " + func);
                    validate = _func(formJson, layero, index);
                }

                if(validate) {
                    layer.close(index); //如果设定了yes回调，需进行手工关闭
                }
            }
        });
    });

    var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功

    form.render();
});

window.UMEDITOR_HOME_URL = "/statics/vendor/umeditor/";