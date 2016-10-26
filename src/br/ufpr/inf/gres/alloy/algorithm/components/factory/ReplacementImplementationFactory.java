package br.ufpr.inf.gres.alloy.algorithm.components.factory;

import br.ufpr.inf.gres.alloy.algorithm.components.Diversity;
import br.ufpr.inf.gres.alloy.algorithm.components.Ranking;
import br.ufpr.inf.gres.alloy.algorithm.components.ReplacementImplementation;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.replacement.GenerationalReplacement;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.replacement.RankingAndDiversityReplacement;

public class ReplacementImplementationFactory {

    public static final String GENERATIONAL = "Generational";
    public static final String RANKING = "Ranking";

    public static ReplacementImplementation createReplacementImplementation(String replacement, int elitismSize, Ranking ranking, Diversity diversity) {
        if (replacement != null) {
            switch (replacement) {
                case GENERATIONAL:
                    return new GenerationalReplacement(elitismSize, ranking, diversity);
                case RANKING:
                    return new RankingAndDiversityReplacement(ranking, diversity);
            }
        }
        return null;
    }

}
