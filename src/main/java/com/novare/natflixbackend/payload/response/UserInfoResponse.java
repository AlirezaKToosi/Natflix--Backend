package com.novare.natflixbackend.payload.response;

import java.util.List;

public class UserInfoResponse {
	private Long id;
	private String username;
	private String fullName;
	private List<String> roles;
	private Integer type;

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return type;
	}

	public UserInfoResponse(Long id, String username, String fullName, List<String> roles) {
		this.id = id;
		this.username = username;
		this.fullName = fullName;
		this.roles = roles;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}
}
