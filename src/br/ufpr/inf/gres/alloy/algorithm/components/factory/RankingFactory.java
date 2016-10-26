package br.ufpr.inf.gres.alloy.algorithm.components.factory;

import br.ufpr.inf.gres.alloy.algorithm.components.Ranking;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.ranking.DominanceDepth;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.ranking.DominanceRank;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.ranking.DominanceStrength;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.ranking.RawFitness;

public class RankingFactory {

    public static final String DOMINANCE_RANK = "Dominance Rank";
    public static final String DOMINANCE_STRENGTH = "Dominance Strength";
    public static final String DOMINANCE_DEPTH = "Dominance Depth";
    public static final String RAW_FITNESS = "Raw Fitness";

    public static Ranking createRanking(String ranking) {
        if (ranking != null) {
            switch (ranking) {
                case DOMINANCE_RANK:
                    return new DominanceRank();
                case DOMINANCE_STRENGTH:
                    return new DominanceStrength();
                case DOMINANCE_DEPTH:
                    return new DominanceDepth();
                case RAW_FITNESS:
                    return new RawFitness();
            }
        }
        return null;
    }

}
