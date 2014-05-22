package br.ufmg.ppgee.secondscreen.platform.entities;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Evaluation {

	@Id
	Long id;
	Ref<User> user;
	Ref<Program> program;
	byte rating;

	public Evaluation() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ref<User> getUser() {
		return user;
	}

	public void setUser(Ref<User> user) {
		this.user = user;
	}

	public Ref<Program> getProgram() {
		return program;
	}

	public void setProgram(Ref<Program> program) {
		this.program = program;
	}

}
