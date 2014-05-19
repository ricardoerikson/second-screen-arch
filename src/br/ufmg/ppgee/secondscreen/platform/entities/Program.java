package br.ufmg.ppgee.secondscreen.platform.entities;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Program {

	@Id
	Long id;
	String videoCode;
	String title;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVideoCode() {
		return videoCode;
	}

	public void setVideoCode(String programCode) {
		this.videoCode = programCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Program() {
		
	}
}
