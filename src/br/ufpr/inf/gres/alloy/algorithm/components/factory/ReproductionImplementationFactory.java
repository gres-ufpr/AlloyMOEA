package br.ufpr.inf.gres.alloy.algorithm.components.factory;

import br.ufpr.inf.gres.alloy.algorithm.components.ReproductionImplementation;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.reproduction.GenerationalOneChildReproduction;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.reproduction.GenerationalTwoChildrenReproduction;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.reproduction.SteadyStateReproduction;

public class ReproductionImplementationFactory {

    public static final String STEADY_STATE = "Steady State";
    public static final String GENERATIONAL_TWO_CHILDREN = "Generational Two Children";
    public static final String GENERATIONAL_ONE_CHILD = "Generational One Child";

    public static ReproductionImplementation createSelectionImplementation(String reproduction) {
        if (reproduction != null) {
            switch (reproduction) {
                case STEADY_STATE:
                    return new SteadyStateReproduction();
                case GENERATIONAL_TWO_CHILDREN:
                    return new GenerationalTwoChildrenReproduction();
                case GENERATIONAL_ONE_CHILD:
                    return new GenerationalOneChildReproduction();
            }
        }
        return null;
    }

}
