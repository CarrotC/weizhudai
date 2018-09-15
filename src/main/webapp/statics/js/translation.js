$(function() {
	// do something 
	var script = document.createElement("script");
	script.type = "text/javascript";
	script.src = "http://www.microsoftTranslator.com/ajax/v3/WidgetV3.ashx?siteData=ueOIGRSKkd965FeEGM5JtQ**";
	document.getElementsByTagName('head')[0].appendChild(script);

	$("*").hover(function() {
		setTimeout(function() {
			$("#WidgetFloaterPanels").next().remove();
			$(this).attr("style", "");
		}, 700);
	});

	var value = sessionStorage.getItem("language");
	document.onreadystatechange = function() {
		if(document.readyState == 'complete') {
			if(value === "1") {
				Microsoft.Translator.Widget.Translate('zh-CHS', 'en', onProgress, onError, onComplete, onRestoreOriginal, 2000);
				$("#WidgetFloaterPanels").css("opacity", "0");
			}
		}
	}

	function onProgress(value) {
		$("#WidgetFloaterPanels").css("opacity", "0");
		$("#WidgetFloaterPanels").hide();
	}

	function onError(error) {}

	function onComplete() {
		$("#WidgetFloaterPanels").hide();
		$("#language img").attr("src", "static/img/chinese.png");
		$("#BUsername").attr("placeholder", "Please enter the user name.");
		$("#CUsername").attr("placeholder", "Please enter the user name.");
		$("#BPassword").attr("placeholder", "Please enter the password.");
		$("#CPassword").attr("placeholder", "Please enter the password.");
		$("#companyName").attr("placeholder", "Please enter the name of the enterprise to query.");
		$(".navbar-brand").text("Loan Helper");
		$(".lineTitle").text("Loan Helper");
	}

	function onRestoreOriginal() {
		$("#WidgetFloaterPanels").hide();
	}
});

function translate() {
	var value = sessionStorage.getItem("language");
	if(value === "1") {
		sessionStorage.setItem("language", "0");
	} else {
		sessionStorage.setItem("language", "1");
	}
	window.location.reload(); //刷新当前页面.
}