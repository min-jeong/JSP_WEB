package com.ktds.jmj.member.vo;

public class MemberVO {
	
	private String memberId;
	private String nickName;
	private String password;
	private String email;
	private String isBlock;
	
	
	public String getIsBlock() {
		return isBlock;
	}
	public void setIsBlock(String isBlock) {
		this.isBlock = isBlock;
	}
	
	public boolean isBlock() {
		if ( this.isBlock == null || this.isBlock.equals("N") ) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
