//原生Ajax代码
//编写步骤：
//1.创建Ajax的核心对象XMLHttpRequest，区分不同浏览器创建此对象的方法
//2.创建一个请求处理的JavaScript函数
//3.编写解析服务器端返回的XML格式数据
//4.利用JavaScript对页面HTML DOM进行操作

$ = function(v) {
	return document.getElementById(v);
}

var XMLHttpReq = false;
//创建XMLHttpRequest对象       
function createXMLHttpRequest() {
	if (window.XMLHttpRequest) { //Mozilla 浏览器
		XMLHttpReq = new XMLHttpRequest();
	} else if (window.ActiveXObject) { // IE浏览器
		try {
			XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
			}
		}
	}
}

function sendRequest(url) { //自定义一个处理Ajax URL请求的方法
	createXMLHttpRequest(); //处理URL请求之前先调用创建XMLHttpRequest对象的方法
	XMLHttpReq.open("GET",url,true); //打开URL请求
	XMLHttpReq.onreadystatechange = processResponse; //处理服务器端返回的响应数据，processResponse需要自定义的方法
	XMLHttpReq.send(null);
}

function processResponse() { //处理请求的响应
	if (XMLHttpReq.readyState == 4) {
		if (XMLHttpReq.status == 200) { //200代表服务器返回数据成功
			$("isuser").innerHTML=XMLHttpReq.responseText;
		} else {
			$("isuser").innerHTML="请求异常";
		}
	}
}

function isuser() {
	username = $("username").value;
	url = "users.do?v=isuser&username="+username;
	sendRequest(url);
}