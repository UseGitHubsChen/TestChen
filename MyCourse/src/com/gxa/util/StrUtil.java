package com.gxa.util;


public class StrUtil {

	/**
	 * �ж��ַ����Ƿ�Ϊ��
	 */
	public static boolean checkStr(String var){
		boolean flag = true;//�ٶ�û�п��ַ�
		
		if(var==null||"".equals(var)||"null".equals(var)){
			flag = false; //�п�ֵ
		}
		return flag;
	}
	

	
	/**
	 * �ж��ַ����������Ƿ��п�ֵ
	 * @param vars
	 * @return û�п��ַ�����true �пմ�����false
	 */
	public static boolean checkStr(String [] vars){
		boolean flag = true; //�ٶ�û�п��ַ�
		
		for (String string : vars) {
			
			if(!checkStr(string)){
				flag = false;
				break;
			}
		}
		return flag;
		
	}
}
