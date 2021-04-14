package com.my.blogs.utils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.springframework.beans.BeanUtils;

import com.my.blogs.controller.user.vo.EnrollUserVO;
import com.my.blogs.controller.user.vo.UserInfoVO;

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
    	
    public static UserInfoVO haha(Map<String,Object> map,UserInfoVO userInfoVO) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    	Iterator<Entry<String, Object>> it=map.entrySet().iterator();
        while(it.hasNext()){
            Entry<String, Object> entry=it.next();
            Field[] fields = userInfoVO.getClass().getDeclaredFields();  
            for(int i=0; i<fields.length; i++){  
                Field f = fields[i];  
                f.setAccessible(true); 
                String key = entry.getKey();
                String name = f.getName().toString();
                if(key.equals(name)) {
                	String type = f.getType().toString();
                	String methodName = name.substring(0,1).toUpperCase()+name.substring(1);
                	Method setMethod;
                	if(!type.equals("interface java.util.List")) {
		                setMethod = UserInfoVO.class.getMethod("set"+methodName,String.class);
		                setMethod.invoke(userInfoVO,entry.getValue());
	                }
                }
                
            }  
        }
		return userInfoVO;
    }
    
    public static void main (String[] args){
		Map<String,Object> a = new HashMap<String,Object>();
		a.put("username", "zhang");
		List<EnrollUserVO> enrollUserVOList = new ArrayList<EnrollUserVO>();
		EnrollUserVO enrollUserVO = new EnrollUserVO();
		enrollUserVOList.add(enrollUserVO);
		a.put("enrollUserVOList", enrollUserVOList);
		UserInfoVO userInfoVO = new UserInfoVO();
		UserInfoVO userInfoVO1 = new UserInfoVO();
		BeanUtils.copyProperties(userInfoVO, a);
		try {
			userInfoVO = haha(a,userInfoVO1);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("haha");
	}
}
