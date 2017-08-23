function showOp(obj) {
	obj.style.cssText="background:gray";
}

function hiddenOP(obj) {
	obj.style.cssText="";
}

function tuijianNext(){
	/*
	 * 思路：
	 * 1.寻找指定id的ul标签
	 * 2.判断ul标签是否含有li子标签
	 * 3.将li子标签放入到一个集合中
	 * 4.判断要显示的下一个li子标签
	 * 技术：
	 * 1.hasChildNodes() 判断一个标签是否含有子元素
	 * 2.childNodes属性：取出子元素返回结果是一个集合
	 * 3.nodeName属性：获取元素的标签名字
	 */
	var list1 = document.getElementById("tuijianList");
	var list2 = []; //定义存储子标签的集合
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
				if (i == list2.length - 1) { //判断当前li是否是最后一个li
					i = 0;
					list2[i].style.display="block"; //显示第一个li
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
	var list2 = []; //定义存储子标签的集合
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
				if (i == 0) { //判断当前li是否是第一个li
					list2[list2.length - 1].style.display="block"; //显示最后一个li
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