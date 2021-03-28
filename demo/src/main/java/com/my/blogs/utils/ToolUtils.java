package com.my.blogs.utils;

public class ToolUtils {
	//字符串是否为空
	public static boolean isEmpty(String str) {
		if(str != null && str.trim().length() > 0) {
			return false;
		}
		return true;
	}
	//字符串是否为空
	public static boolean isNotEmpty(String str) {
		if(str == null || str.trim().length() == 0) {
			return true;
		}
		return false;
	}
}
