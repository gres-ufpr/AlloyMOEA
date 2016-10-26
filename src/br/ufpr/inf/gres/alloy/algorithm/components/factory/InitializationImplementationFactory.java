package br.ufpr.inf.gres.alloy.algorithm.components.factory;

import br.ufpr.inf.gres.alloy.algorithm.components.InitializationImplementation;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.initialization.ParallelDiversifiedInitialization;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.initialization.RandomInitialization;

public class InitializationImplementationFactory {

    public static final String RANDOM = "Random";
    public static final String PARALLEL_DIVERSIFIED_INITIALIZATION = "Parallel Diversified Initialization";

    public static InitializationImplementation createInitializationImplementation(String initialization) {
        if (initialization != null) {
            switch (initialization) {
                case RANDOM:
                    return new RandomInitialization();
                case PARALLEL_DIVERSIFIED_INITIALIZATION:
                    return new ParallelDiversifiedInitialization();
            }
        }
        return null;
    }

}
