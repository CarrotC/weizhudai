	//		切换语言
		$("#language").on("click", function() {
			if($(this).hasClass("chinese")) {
				//换成英文
				$(this).addClass("english");
				$(this).removeClass("chinese");
				$("#language img").attr("src", "/statics/img/english.png")
			} else {
				$(this).removeClass("english");
				$(this).addClass("chinese");
				$("#language img").attr("src", "/statics/img/chinese.png")
			}
		});