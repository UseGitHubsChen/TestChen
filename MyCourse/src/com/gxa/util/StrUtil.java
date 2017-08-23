package com.gxa.util;


public class StrUtil {

	/**
	 * 判断字符串是否为空
	 */
	public static boolean checkStr(String var){
		boolean flag = true;//假定没有空字符
		
		if(var==null||"".equals(var)||"null".equals(var)){
			flag = false; //有空值
		}
		return flag;
	}
	

	
	/**
	 * 判断字符串数组中是否有空值
	 * @param vars
	 * @return 没有空字符返回true 有空串返回false
	 */
	public static boolean checkStr(String [] vars){
		boolean flag = true; //假定没有空字符
		
		for (String string : vars) {
			
			if(!checkStr(string)){
				flag = false;
				break;
			}
		}
		return flag;
		
	}
}
