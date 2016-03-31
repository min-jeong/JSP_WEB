package com.ktds.pingpong;

public interface Const {
	
	public static final String DB_URL = "jdbc:oracle:thin:@10.225.152.181:1521:XE";
	public static final String DB_USER = "PINGPONG";
	public static final String DB_PASSWORD = "1234";
	
	/**
	 * 자신의 워크스페이스 주소에 맞추고
	 * resource/img 안에 update 폴더를 자신이 만들어줘야
	 * 파일이 써져. 파일 쓸때 프로그램이 안만들어져.
	 * 프로젝트 카피하면 프로젝트 명이 바뀌니까
	 * 그때 프로젝트 폴더명 바꿔줘야 해
	 */
	public static final String PROFILE_PHOTO_PATH = "D:\\";
//	public static final String PROFILE_PHOTO_PATH = "C:\\Users\\206-001\\workspace\\JSP_WEB\\Project-Front\\WebContent\\resource\\img\\update\\";
//	public static final String PROFILE_PHOTO_PATH = "C:\\workspace-sts-3.7.2.RELEASE\\Project-Front\\WebContent\\resource\\img\\update\\";
	
	
}
