//ԭ��Ajax����
//��д���裺
//1.����Ajax�ĺ��Ķ���XMLHttpRequest�����ֲ�ͬ����������˶���ķ���
//2.����һ���������JavaScript����
//3.��д�����������˷��ص�XML��ʽ����
//4.����JavaScript��ҳ��HTML DOM���в���

$ = function(v) {
	return document.getElementById(v);
}

var XMLHttpReq = false;
//����XMLHttpRequest����       
function createXMLHttpRequest() {
	if (window.XMLHttpRequest) { //Mozilla �����
		XMLHttpReq = new XMLHttpRequest();
	} else if (window.ActiveXObject) { // IE�����
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

function sendRequest(url) { //�Զ���һ������Ajax URL����ķ���
	createXMLHttpRequest(); //����URL����֮ǰ�ȵ��ô���XMLHttpRequest����ķ���
	XMLHttpReq.open("GET",url,true); //��URL����
	XMLHttpReq.onreadystatechange = processResponse; //����������˷��ص���Ӧ���ݣ�processResponse��Ҫ�Զ���ķ���
	XMLHttpReq.send(null);
}

function processResponse() { //�����������Ӧ
	if (XMLHttpReq.readyState == 4) {
		if (XMLHttpReq.status == 200) { //200����������������ݳɹ�
			$("isuser").innerHTML=XMLHttpReq.responseText;
		} else {
			$("isuser").innerHTML="�����쳣";
		}
	}
}

function isuser() {
	username = $("username").value;
	url = "users.do?v=isuser&username="+username;
	sendRequest(url);
}