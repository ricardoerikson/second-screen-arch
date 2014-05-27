package br.ufmg.ppgee.secondscreen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/evaluation")
public class EvaluationController {

    public String evaluate(String userId, String movieId, byte evaluation) {
	return "saved";
    }
    
    @RequestMapping("/form")
    public String form(){
	return "evaluation/evaluationForm";
    }
    
	
}
