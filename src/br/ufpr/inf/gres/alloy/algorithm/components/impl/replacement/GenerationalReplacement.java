package br.ufpr.inf.gres.alloy.algorithm.components.impl.replacement;

import br.ufpr.inf.gres.alloy.algorithm.comparator.impl.RankingAndDiversityComparator;
import br.ufpr.inf.gres.alloy.algorithm.components.Diversity;
import br.ufpr.inf.gres.alloy.algorithm.components.Ranking;
import br.ufpr.inf.gres.alloy.algorithm.components.ReplacementImplementation;
import java.util.ArrayList;
import java.util.List;
import org.uma.jmetal.solution.Solution;

public class GenerationalReplacement<S extends Solution<?>> implements ReplacementImplementation<S> {

    private int elitismSize;
    private Ranking ranking;
    private Diversity diversity;

    public GenerationalReplacement() {
        this(0, null, null);
    }

    public GenerationalReplacement(int elitismSize, Ranking ranking, Diversity diversity) {
        this.elitismSize = elitismSize;
        this.ranking = ranking;
        this.diversity = diversity;
    }

    public int getElitismSize() {
        return elitismSize;
    }

    public void setElitismSize(int elitismSize) {
        this.elitismSize = elitismSize;
    }

    public Ranking getRanking() {
        return ranking;
    }

    public void setRanking(Ranking ranking) {
        this.ranking = ranking;
    }

    public Diversity getDiversity() {
        return diversity;
    }

    public void setDiversity(Diversity diversity) {
        this.diversity = diversity;
    }

    @Override
    public List<S> replacement(List<S> population, List<S> offspringPopulation, int populationSize) {
        List<S> replacedPopulation = new ArrayList<>();
        if (elitismSize > 0) {
            if (ranking != null) {
                ranking.computeRanking(population);
                ranking.computeRanking(offspringPopulation);
            }
            if (diversity != null) {
                diversity.computeDiversity(population);
                diversity.computeDiversity(offspringPopulation);
            }
            RankingAndDiversityComparator comparator = new RankingAndDiversityComparator(ranking, diversity);
            population.sort(comparator);
            offspringPopulation.sort(comparator);
        }

        for (int i = 0; i < elitismSize; i++) {
            replacedPopulation.add(population.get(i));
        }

        for (int i = 0; replacedPopulation.size() < populationSize && i < offspringPopulation.size(); i++) {
            replacedPopulation.add(offspringPopulation.get(i));
        }

        if (replacedPopulation.size() < populationSize) {
            for (int i = elitismSize; replacedPopulation.size() < populationSize; i++) {
                replacedPopulation.add(population.get(i));
            }
        }

        return replacedPopulation;
    }

    @Override
    public String toString() {
        return "GenerationalReplacement{" + "elitismSize=" + elitismSize + ", ranking=" + ranking + ", diversity=" + diversity + '}';
    }

}
