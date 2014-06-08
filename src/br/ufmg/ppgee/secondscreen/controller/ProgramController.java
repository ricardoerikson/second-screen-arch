package br.ufmg.ppgee.secondscreen.controller;

import static br.ufmg.ppgee.secondscreen.platform.objectify.OfyService.ofy;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.ufmg.ppgee.secondscreen.platform.entities.Program;

@Controller
@RequestMapping("/programs")
public class ProgramController {

    @RequestMapping(value = "", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    List<Program> getPrograms() {
	List<Program> programs = ofy().load().type(Program.class).list();
	return programs;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveProgram(Program program) {
	ofy().save().entity(program).now();
	return "saved";
    }

    @RequestMapping("/form")
    public String form() {
	return "program/programForm";
    }

}
