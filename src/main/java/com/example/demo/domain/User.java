package com.example.demo.domain;

//package com.example.demo.domain;


public class User {
    
    private Long id;
    
    private String userName;
    
    private String userId;
    
    private String userPw;
    
    private String phoneNumber;
    
    private String emailAddress;
    
    private Long userLevel;
   
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }      
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public Long getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(Long userLevel) {
		this.userLevel = userLevel;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

}
