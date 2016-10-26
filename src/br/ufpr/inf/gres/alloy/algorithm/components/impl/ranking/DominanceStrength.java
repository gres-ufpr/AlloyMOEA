package br.ufpr.inf.gres.alloy.algorithm.components.impl.ranking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import br.ufpr.inf.gres.alloy.algorithm.components.Ranking;
import org.uma.jmetal.solution.Solution;
import org.uma.jmetal.util.comparator.DominanceComparator;

public class DominanceStrength<S extends Solution<?>> extends Ranking<S, Integer> {

    private final Comparator<Solution<?>> dominanceComparator;

    public DominanceStrength() {
        this.dominanceComparator = new DominanceComparator<>();
    }

    @Override
    protected List<Integer> getSolutionsRanking(List<S> solutions) {
        int solutionsSize = solutions.size();

        List<Integer> rankings = new ArrayList<>();
        for (int i = 0; i < solutionsSize; i++) {
            rankings.add(0);
        }

        for (int i = 0; i < solutionsSize; i++) {
            for (int j = 0; j < solutionsSize; j++) {
                if (dominanceComparator.compare(solutions.get(i), solutions.get(j)) == -1) {
                    rankings.set(i, rankings.get(i) + 1);
                }
            }
            rankings.set(i, rankings.get(i) * -1);
        }

        return rankings;
    }
    
    @Override
    public String toString() {
        return "DominanceStrength";
    }

}
