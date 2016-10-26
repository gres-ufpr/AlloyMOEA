package br.ufpr.inf.gres.alloy.algorithm.components.factory;

import br.ufpr.inf.gres.alloy.algorithm.components.ArchivingImplementation;
import br.ufpr.inf.gres.alloy.algorithm.components.Diversity;
import br.ufpr.inf.gres.alloy.algorithm.components.Ranking;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.archiving.RankingAndDiversityArchiving;

public class ArchivingImplementationFactory {

    public static ArchivingImplementation createArchivingImplementation(int archiveSize, Ranking ranking, Diversity diversity) {
        if (archiveSize > 0) {
            return new RankingAndDiversityArchiving(archiveSize, ranking, diversity);
        }
        return null;
    }

}
