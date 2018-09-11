//部分界面的返回需要重写，可以直接额调用这个函数,传入需要跳转的页面url
var ReturnChanger={
    //跳转页面
    changeReturn:function (url) {
    this.pushHistory();
    window.addEventListener("popstate", function(e) {
        //alert("我监听到了浏览器的返回按钮事件啦");//根据自己的需求实现自己的功能
        window.location.href= url;
    }, false);

},
    pushHistory:function() {
    var state = {
        title: "title",
        url: "#"
    };
    window.history.pushState(state, "title", state.url);
},
    //关闭页面
    closePage:function () {
        this.pushHistory();
        window.addEventListener("popstate", function(e) {
            //关闭当前浏览器
            window.close()||wx.closeWindow({
                success:function (res) {
                    
                },
                fail:function (res) {
                    wx.closeWindow({
                        fail:function () {
                            wx.closeWindow();
                            
                        }
                    })
                    
                }
                }

            )
            // ||

            // window.history.back();
        }, false);
    },
}