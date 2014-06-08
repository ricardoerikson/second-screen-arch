package br.ufmg.ppgee.secondscreen.platform.objectify;

import br.ufmg.ppgee.secondscreen.platform.entities.Evaluation;
import br.ufmg.ppgee.secondscreen.platform.entities.Program;
import br.ufmg.ppgee.secondscreen.platform.entities.Viewer;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

public class OfyService {

    static {
	factory().register(Viewer.class);
	factory().register(Program.class);
	factory().register(Evaluation.class);
    }

    public static Objectify ofy() {
	return ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
	return ObjectifyService.factory();
    }

}
