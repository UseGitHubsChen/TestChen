function showOp(obj) {
	obj.style.cssText = "background:gray"; //��Ԫ�ص��ı�����������ʽ
}

function hiddenOP(obj) {
	obj.style.cssText = "";
}

function tuijianNext() {
	/*
	 * ˼·��
	 * 1.�Ȼ�ȡUL��ǩ�µ�LIԪ��
	 * 2.�ж�LI�Ƿ�����ʾ״̬����ѵ�ǰLI���ò���ʾ
	 * 3.��ʾ��һ��LI��ǩ
	 * ������XML DOM����
	 * 1.hasChildNodes() �ж�һ��Ԫ���Ƿ�����Ԫ��
	 * 2.childNodes ���� ����ȡ���е���Ԫ��
	 * 3.nodeName ���� ����ȡԪ�صı�ǩ
	 */
	var list1 = document.getElementById("tuijianList");
	var list2 = []; //�洢����liԪ��
	if (list1.hasChildNodes()) {
		var list3 = list1.childNodes; //��UL��ǩ�µ�����Ԫ�ط���list3�У����������滹�г�li��ǩ����Ԫ��
		var j = 0;
		for (i = 1; i < list3.length; i++) { //����UL��ǩ�µ�������Ԫ�أ�Ȼ���ж���Ԫ����li��ǩ����list2������
			if (list3[i].nodeName == "LI") {
				list2[j] = list3[i];
				j++;
			}
		}
		
		for (i = 0; i < list2.length; i++) {
			if (list2[i].style.display == "block") { //�жϵ�ǰ��li�Ƿ�����ʾ״̬
				list2[i].style.display = "none"; //������ǰli����Ϊ������ʾ
				if (i == list2.length -1) { //��ǰ��liΪ���һ��
					i = 0;
					list2[i].style.display = "block";
					return;
				}
				list2[i+1].style.display = "block";
				return;
			}
		}
	}
}

function tuijianPrev() {
	var list1 = document.getElementById("tuijianList");
	var list2 = []; //�洢����liԪ��
	if (list1.hasChildNodes()) {
		var list3 = list1.childNodes; //��UL��ǩ�µ�����Ԫ�ط���list3�У����������滹�г�li��ǩ����Ԫ��
		var j = 0;
		for (i = 1; i < list3.length; i++) { //����UL��ǩ�µ�������Ԫ�أ�Ȼ���ж���Ԫ����li��ǩ����list2������
			if (list3[i].nodeName == "LI") {
				list2[j] = list3[i];
				j++;
			}
		}
		
		for (i = 0; i < list2.length; i++) {
			if (list2[i].style.display == "block") { //�жϵ�ǰ��li�Ƿ�����ʾ״̬
				list2[i].style.display = "none"; //������ǰli����Ϊ������ʾ
				if (i == 0) {
					list2[list2.length - 1].style.display = "block";
					return;
				}
				list2[i - 1].style.display = "block";
				return;
			}
		}
	}
}