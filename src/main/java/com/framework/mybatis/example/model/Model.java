package com.framework.mybatis.example.model;

import java.io.Serializable;
import java.lang.reflect.Method;

public abstract class Model implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public boolean equals(Object obj) {
		
		boolean response = false;
		
		if (obj instanceof Model){
			response = this.toString().trim().equals(obj.toString().trim());
		}//end if
		
		return response;
		
	}//end equals()
	
	public String toString(){
		
		StringBuffer response = new StringBuffer("");
		
		try{
			Class<?> clazz = this.getClass();
			Method[] methods = clazz.getDeclaredMethods();
			response.append(this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1) + " { " );
			
			for(Method method : methods) {
				if(method.getParameterTypes().length == 0 && method.getName().contains("get")) {
					response.append(method.getName() + ": ");
					response.append(method.invoke(this, (Object[]) null) + ", ");
				}//end if
			}//end for
			
			response.replace(response.lastIndexOf(", "), response.length(), " }");
		} catch(Exception ignored){
		}//end try
		
		return response.toString();
		
	}//end toString()

	public abstract void clear();
}