package com.ktds.pingpong.history.vo;

public class BuildDescription {

	public static String get(String format, String ... args){
		// ... -> 배열 (가변인자)
		
		String desc = String.format(format, args);
		return desc;
		
		
	}
	
}
