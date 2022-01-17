package com.realm.api.model;

public class Response {
	public Response(Integer id, String name, String email,
			Long mobile,Long zip, String city, String type,String state, Integer realId) {
		super();
		this.id = id;
		this.name = name;
		this.zip = zip;
		this.city = city;
		this.state = state;
		this.type = type;
		this.email = email;
		this.mobile = mobile;
		this.realId = realId;
	}

	private Integer id;
	private String name;
	private Long zip;
	private String city;
	private String state;
	private String type;
	
	
	private String email;
	
	private Long mobile;
	
	private Integer realId;

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getZip() {
		return zip;
	}

	public void setZip(Long zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public Integer getRealId() {
		return realId;
	}

	public void setRealId(Integer realId) {
		this.realId = realId;
	}

	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
