package br.ufpr.inf.gres.alloy.algorithm.components.factory;

import br.ufpr.inf.gres.alloy.algorithm.components.Diversity;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.diversity.AdaptiveGrid;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.diversity.CrowdingDistance;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.diversity.HypervolumeContribution;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.diversity.KthNearestNeighbor;

public class DiversityFactory {

    public static final String CROWDING_DISTANCE = "Crowding Distance";
    public static final String KTH_NEAREST_NEIGHBOR = "K-th Nearest Neighbor";
    public static final String ADAPTIVE_GRID = "Adaptive Grid";
    public static final String HYPERVOLUME_CONTRIBUTION = "Hypervolume Contribution";

    public static Diversity createRanking(String diversity, int populationSize, int archiveSize, int bisections, int numberOfObjectives) {
        if (diversity != null) {
            switch (diversity) {
                case CROWDING_DISTANCE:
                    return new CrowdingDistance();
                case KTH_NEAREST_NEIGHBOR:
                    return new KthNearestNeighbor(populationSize, archiveSize);
                case ADAPTIVE_GRID:
                    return new AdaptiveGrid(bisections, numberOfObjectives);
                case HYPERVOLUME_CONTRIBUTION:
                    return new HypervolumeContribution();
            }
        }
        return null;
    }

}
