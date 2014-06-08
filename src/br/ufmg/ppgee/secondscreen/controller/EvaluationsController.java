package br.ufmg.ppgee.secondscreen.controller;

import static br.ufmg.ppgee.secondscreen.platform.objectify.OfyService.ofy;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.ufmg.ppgee.secondscreen.platform.entities.Evaluation;
import br.ufmg.ppgee.secondscreen.platform.entities.Program;

@Controller
@RequestMapping("/evaluations")
public class EvaluationsController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Evaluation> getPrograms(
	    @RequestParam(value = "viewer", required = true) Long viewerId) {
	List<Evaluation> evaluations = ofy().load().type(Evaluation.class)
		.filter("viewer =", viewerId).list();
	return evaluations;
    }

    @RequestMapping("form")
    public String getProgramForm() {
	return "program/programForm";
    }
}
