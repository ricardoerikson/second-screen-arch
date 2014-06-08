package br.ufmg.ppgee.secondscreen.controller;

import static br.ufmg.ppgee.secondscreen.platform.objectify.OfyService.ofy;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.ufmg.ppgee.secondscreen.platform.entities.Evaluation;
import br.ufmg.ppgee.secondscreen.platform.entities.Program;
import br.ufmg.ppgee.secondscreen.platform.entities.Viewer;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.Query;

@Controller
@RequestMapping("/evaluations")
public class EvaluationsController {

    @RequestMapping(value = "", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    List<Evaluation> getAllEvaluationsJson() {
	List<Evaluation> evaluations = ofy().load().type(Evaluation.class)
		.list();
	return evaluations;
    }

    @RequestMapping(value = "/viewer/{viewerId}", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    List<Evaluation> getViewerEvaluationsJson(@PathVariable Long viewerId) {
	Key<Viewer> viewerKey = Key.create(Viewer.class, viewerId);
	List<Evaluation> evaluations = ofy().load().type(Evaluation.class)
		.filter("viewer", viewerKey).list();
	return evaluations;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String rateProgram(Long viewerId, Long programId, byte rating) {
	Evaluation evaluation = new Evaluation();
	evaluation.setViewer(new Viewer(viewerId));
	evaluation.setProgram(new Program(programId));
	evaluation.setRating(rating);

	ofy().save().entities(evaluation).now();
	
	return "saved";
    }

    @RequestMapping(value = "/viewer/{viewerId}/program/{programId}", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    Evaluation getEvaluationJson(@PathVariable Long viewerId,
	    @PathVariable Long programId) {

	Key<Viewer> viewerKey = Key.create(Viewer.class, viewerId);
	Key<Program> programKey = Key.create(Program.class, programId);

	Query<Evaluation> q = ofy().load().type(Evaluation.class)
		.filter("viewer", viewerKey);
	q = q.filter("program", programKey);
	return q.first().now();
    }

    @RequestMapping("form")
    public String getProgramForm() {
	return "evaluation/evaluationForm";
    }
}
