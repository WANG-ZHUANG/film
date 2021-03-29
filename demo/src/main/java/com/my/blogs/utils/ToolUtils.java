package com.my.blogs.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

public class ToolUtils {
	
	//字符串是否为空
	public static boolean StringIsEmpty(String str) {
		if(str != null && str.trim().length() > 0) {
			return false;
		}
		return true;
	}
	
	//字符串是否为空
	public static boolean StringIsNotEmpty(String str) {
		if(str == null || str.trim().length() == 0) {
			return true;
		}
		return false;
	}
	
	//判断list集合是否为空
	public static boolean listIsEmpty(List list) {
		if(list != null && !list.isEmpty()) {
			return false;
		}
		return true;
	}
	
	//判断map集合是否为空
	public static boolean mapIsEmpty(Map map) {
		if(map != null && !map.isEmpty()) {
			return false;
		}
		return true;
	}
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
}
