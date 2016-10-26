package br.ufpr.inf.gres.alloy.algorithm.components.factory;

import br.ufpr.inf.gres.alloy.algorithm.components.TrackingImplementation;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.tracking.ResultToFileOutputTracking;

public class TrackingImplementationFactory {

    public static final String RESULT_TO_FILE_OUTPUT = "Result to File Output";

    public static TrackingImplementation createTracking(String tracking, String fileOutputPath) {
        if (tracking != null) {
            switch (tracking) {
                case RESULT_TO_FILE_OUTPUT:
                    return new ResultToFileOutputTracking(fileOutputPath);
            }
        }
        return null;
    }

}
