package com.mvc.app.model;

import com.mvc.app.entity.RoleEntity;

public class UserModel {

    private  long id;
    private String username;
    private String Fname;
    private String Lname;
    private String email;
    private String password;
    private String phone;
    private Long roleId;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
	public void setPhone(String phone) {
	    this.phone = phone;
	}
	
	
	public String getPhone() {
	    return this.phone;
	}
	
	
	
	public Long getRoleId() {
	    return this.roleId;
	}
	
	
	public void setRoleId(Long roleId) {
	    this.roleId=roleId;
	}
	
}
