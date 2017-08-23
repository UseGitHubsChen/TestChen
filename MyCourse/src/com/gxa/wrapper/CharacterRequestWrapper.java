/*package com.gxa.wrapper;

import java.util.HashMap;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CharacterRequestWrapper  extends HttpServletRequestWrapper {

	public CharacterRequestWrapper(HttpServletRequest request) {
		super(request);
	}
	@Override
	public String getParameter(String name) {
		String value = super.getParameter(name);
		//ͨ�������Ļ�ȡ��Ҫת������Ϣ
		HashMap<String,String> maps = new HashMap<String,String>();
		maps.put("<", "&lt;");
		maps.put(">", "&gt;");
		//�滻�����ַ�
		Set<String> content = maps.keySet();
		for(String cont : content){
			value = value.replaceAll(cont, maps.get(cont));
		}
		return value;
	}
}
*/