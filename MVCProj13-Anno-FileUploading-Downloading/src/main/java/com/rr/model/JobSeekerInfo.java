package com.rr.model;

import org.springframework.web.multipart.MultipartFile;

public class JobSeekerInfo {
	private String jsName;
	private String jsAddrs;
	private Integer jsAge;
	private MultipartFile resume;
	private MultipartFile photo;
	
	public String getJsName() {
		return jsName;
	}
	public void setJsName(String jsName) {
		this.jsName = jsName;
	}
	public String getJsAddrs() {
		return jsAddrs;
	}
	public void setJsAddrs(String jsAddrs) {
		this.jsAddrs = jsAddrs;
	}
	public Integer getJsAge() {
		return jsAge;
	}
	public void setJsAge(Integer jsAge) {
		this.jsAge = jsAge;
	}
	public MultipartFile getResume() {
		return resume;
	}
	public void setResume(MultipartFile resume) {
		this.resume = resume;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "JobSeekerInfo [jsName=" + jsName + ", jsAddrs=" + jsAddrs + ", jsAge=" + jsAge + ", resume=" + resume
				+ ", photo=" + photo + "]";
	}
}
