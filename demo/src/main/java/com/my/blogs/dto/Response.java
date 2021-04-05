package com.my.blogs.dto;

import lombok.Data;

@Data
public class Response<M> {
	//0-成功 1-失败 
	private int status;
	//信息
	private String msg;
	//实体数据
	private M data;
	//图片前缀
	private String imgPre;
	//分页
	private Integer nowPage;
	private Integer totalPage;
	
	public static<M> Response success(){
		Response response = new Response();
		response.setStatus(0);
		return response;
	}
	
	public static<M> Response success(String msg){
		Response response = new Response();
		response.setStatus(0);
		response.setMsg(msg);
		return response;
	}
	
	public static<M> Response success(M data){
		Response response = new Response();
		response.setStatus(0);
		response.setData(data);
		return response;
	}
	
	public static<M> Response success(int nowPage,int totalPage,M m){
		Response response = new Response();
		response.setStatus(0);
		response.setData(m);
		response.setTotalPage(totalPage);
		response.setNowPage(nowPage);

        return response;
    }

    public static<M> Response success(int nowPage,int totalPage,String imgPre,M m){
    	Response response = new Response();
    	response.setStatus(0);
    	response.setData(m);
    	response.setImgPre(imgPre);
    	response.setTotalPage(totalPage);
    	response.setNowPage(nowPage);

        return response;
    }

    public static<M> Response success(String imgPre,M m){
    	Response response = new Response();
    	response.setStatus(0);
    	response.setData(m);
    	response.setImgPre(imgPre);

        return response;
    }


    public static<M> Response noLogin(){
    	Response response = new Response();
    	response.setStatus(700);
    	response.setMsg("用户需要登陆");

        return response;
    }

    public static<M> Response serviceFailed(int status,String msg){
    	Response response = new Response();
    	response.setStatus(status);
    	response.setMsg(msg);
        return response;
    }

    public static<M> Response serviceFailed(String msg){
    	Response response = new Response();
    	response.setStatus(1);
    	response.setMsg(msg);
        return response;
    }

    public static<M> Response serviceFailed(String msg,M data){
    	Response response = new Response();
    	response.setStatus(1);
    	response.setMsg(msg);
    	response.setData(data);
        return response;
    }

    public static<M> Response systemError(){
    	Response response = new Response();
    	response.setStatus(999);
    	response.setMsg("系统异常，请联系管理员");
        return response;
    }
}
