function showOp(obj) {
	obj.style.cssText="background:gray";
}

function hiddenOP(obj) {
	obj.style.cssText="";
}

function tuijianNext(){
	/*
	 * ˼·��
	 * 1.Ѱ��ָ��id��ul��ǩ
	 * 2.�ж�ul��ǩ�Ƿ���li�ӱ�ǩ
	 * 3.��li�ӱ�ǩ���뵽һ��������
	 * 4.�ж�Ҫ��ʾ����һ��li�ӱ�ǩ
	 * ������
	 * 1.hasChildNodes() �ж�һ����ǩ�Ƿ�����Ԫ��
	 * 2.childNodes���ԣ�ȡ����Ԫ�ط��ؽ����һ������
	 * 3.nodeName���ԣ���ȡԪ�صı�ǩ����
	 */
	var list1 = document.getElementById("tuijianList");
	var list2 = []; //����洢�ӱ�ǩ�ļ���
	if (list1.hasChildNodes()) {
		var list3 = list1.childNodes;
		var j = 0;
		for (i = 1; i < list3.length; i++) {
			if (list3[i].nodeName == "LI") {
				list2[j] = list3[i];
				j++;
			}
		}
		
		for (i = 0; i < list2.length; i++) {
			if (list2[i].style.display=="block") {
				list2[i].style.display="none";
				if (i == list2.length - 1) { //�жϵ�ǰli�Ƿ������һ��li
					i = 0;
					list2[i].style.display="block"; //��ʾ��һ��li
					return;
				} 
				list2[i + 1].style.display="block";
				return;
			}
		}
	}
}

function tuijianPrev() {
	var list1 = document.getElementById("tuijianList");
	var list2 = []; //����洢�ӱ�ǩ�ļ���
	if (list1.hasChildNodes()) {
		var list3 = list1.childNodes;
		var j = 0;
		for (i = 1; i < list3.length; i++) {
			if (list3[i].nodeName == "LI") {
				list2[j] = list3[i];
				j++;
			}
		}
		
		for (i = 0; i < list2.length; i++) {
			if (list2[i].style.display=="block") {
				list2[i].style.display="none";
				if (i == 0) { //�жϵ�ǰli�Ƿ��ǵ�һ��li
					list2[list2.length - 1].style.display="block"; //��ʾ���һ��li
					return;
				} 
				list2[i - 1].style.display="block";
				return;
			}
		}
		
	}
}

$(function() {
	$("#shoubo").load("mvpre.do?v=queryShoubo");
});