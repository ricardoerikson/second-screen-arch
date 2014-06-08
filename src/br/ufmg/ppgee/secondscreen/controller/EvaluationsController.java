package br.ufmg.ppgee.secondscreen.controller;

import static br.ufmg.ppgee.secondscreen.platform.objectify.OfyService.ofy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufmg.ppgee.secondscreen.platform.entities.Program;

@Controller
@RequestMapping("program")
public class ProgramController {

	@RequestMapping("new")
	public String saveProgram(Program program) {
		ofy().save().entity(program).now();
		return "saved";
	}

	@RequestMapping("form")
	public String getProgramForm() {
		return "program/programForm";
	}
}
