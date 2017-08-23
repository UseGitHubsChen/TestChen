function showOp(obj) {
	obj.style.cssText = "background:gray"; //对元素的文本内容设置样式
}

function hiddenOP(obj) {
	obj.style.cssText = "";
}

function tuijianNext() {
	/*
	 * 思路：
	 * 1.先获取UL标签下的LI元素
	 * 2.判断LI是否是显示状态，则把当前LI设置不显示
	 * 3.显示下一个LI标签
	 * 技术：XML DOM操作
	 * 1.hasChildNodes() 判断一个元素是否含有子元素
	 * 2.childNodes 属性 ：获取所有的子元素
	 * 3.nodeName 属性 ：获取元素的标签
	 */
	var list1 = document.getElementById("tuijianList");
	var list2 = []; //存储所有li元素
	if (list1.hasChildNodes()) {
		var list3 = list1.childNodes; //将UL标签下的所有元素放入list3中，可能这里面还有出li标签以外元素
		var j = 0;
		for (i = 1; i < list3.length; i++) { //遍历UL标签下的所有子元素，然后判断子元素是li标签放入list2集合内
			if (list3[i].nodeName == "LI") {
				list2[j] = list3[i];
				j++;
			}
		}
		
		for (i = 0; i < list2.length; i++) {
			if (list2[i].style.display == "block") { //判断当前的li是否是显示状态
				list2[i].style.display = "none"; //立马将当前li设置为不可显示
				if (i == list2.length -1) { //当前的li为最后一个
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
	var list2 = []; //存储所有li元素
	if (list1.hasChildNodes()) {
		var list3 = list1.childNodes; //将UL标签下的所有元素放入list3中，可能这里面还有出li标签以外元素
		var j = 0;
		for (i = 1; i < list3.length; i++) { //遍历UL标签下的所有子元素，然后判断子元素是li标签放入list2集合内
			if (list3[i].nodeName == "LI") {
				list2[j] = list3[i];
				j++;
			}
		}
		
		for (i = 0; i < list2.length; i++) {
			if (list2[i].style.display == "block") { //判断当前的li是否是显示状态
				list2[i].style.display = "none"; //立马将当前li设置为不可显示
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