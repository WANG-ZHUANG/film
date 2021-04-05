package com.my.blogs.utils;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

public class ToolUtils {
	/*
	 * 判断
	 * 	String 字符串是否为空
	 * 	集合是否为空
	 * 	Map是否为空
	 * 	数组是否为空
	 * */
	public static boolean isNullOrEmpty(Object obj) {
		if(obj == null) return true;
		if(obj instanceof String) return (obj.toString().trim()).isEmpty();
		if(obj instanceof Collection)  return ((Collection) obj).isEmpty(); 
		if(obj instanceof Map)  return ((Map)obj).isEmpty(); 
		if(obj instanceof Object[]) {
			Object[] object = (Object[])obj;
			if(object.length == 0) {
				return true;
			}
		}
		return false;
	}
	
	//正则表达式判断是否为数字 不校验非空
	public static boolean isInteger(String strParameter) { 
		if(isNullOrEmpty(strParameter)) return true;
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$"); 
        return pattern.matcher(strParameter).matches(); 
	}
	
	//判断Email合法性  不校验非空
    public static boolean isEmail(String strParameter) {
        if(isNullOrEmpty(strParameter)) return true;
        Pattern pattern = Pattern.compile("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?");
        return pattern.matcher(strParameter).matches();
    }
    
    //字符串长度校验 一个汉字为三个字符 不校验非空
    public static boolean validateStrByLength(String strParameter , int limitMaxLength , int limitMinLength) {
       if(isNullOrEmpty(strParameter)) return true;
       byte[] b = strParameter.getBytes();
       if(b.length < limitMinLength) return false;
       return b.length <= limitMaxLength ? true:false; 
    }
    	
    
    
    public static void main (String[] args) {
		boolean f = isEmail("1243959690@qq.com");
		System.out.println(f);
	}
}
