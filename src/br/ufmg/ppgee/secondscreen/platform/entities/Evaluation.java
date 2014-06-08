package br.ufmg.ppgee.secondscreen.platform.entities;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;

@Entity
public class Evaluation {

    @Id
    Long id;
    @Index
    @Load
    Ref<Viewer> viewer;
    @Index
    @Load
    Ref<Program> program;
    byte rating;

    public byte getRating() {
	return rating;
    }

    public void setRating(byte rating) {
	this.rating = rating;
    }

    public Evaluation() {

    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Viewer getViewer() {
	return viewer.get();
    }

    public void setViewer(Viewer viewer) {
	this.viewer = Ref.create(Key.create(Viewer.class, viewer.getId()));
    }

    public Program getProgram() {
	return program.get();
    }

    public void setProgram(Program program) {
	this.program = Ref.create(Key.create(Program.class, program.getId()));
    }

}
