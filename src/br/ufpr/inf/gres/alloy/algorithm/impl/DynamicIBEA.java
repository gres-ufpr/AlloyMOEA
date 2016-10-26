package br.ufpr.inf.gres.alloy.algorithm.impl;

import br.ufpr.inf.gres.alloy.algorithm.components.impl.diversity.HypervolumeContribution;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.initialization.RandomInitialization;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.operator.selection.KTournamentSelection;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.progress.EvaluationsCountProgress;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.replacement.RankingAndDiversityReplacement;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.reproduction.GenerationalTwoChildrenReproduction;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.selection.OnlyPopulationSelection;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.stoppingcondition.MaxEvaluationsCondition;
import org.uma.jmetal.operator.CrossoverOperator;
import org.uma.jmetal.operator.MutationOperator;
import org.uma.jmetal.problem.Problem;
import org.uma.jmetal.solution.Solution;
import org.uma.jmetal.util.evaluator.SolutionListEvaluator;

public class DynamicIBEA<S extends Solution<?>> extends DefaultDynamicGeneticAlgorithm<S> {

    public DynamicIBEA(Problem<S> problem, int maxEvaluations, int populationSize,
            CrossoverOperator<S> crossoverOperator, MutationOperator<S> mutationOperator,
            SolutionListEvaluator<S> evaluator) {
        super(problem,
                populationSize,
                new EvaluationsCountProgress(),
                new MaxEvaluationsCondition(maxEvaluations),
                new RandomInitialization<>(),
                new OnlyPopulationSelection<>(),
                new GenerationalTwoChildrenReproduction<>(),
                new RankingAndDiversityReplacement<>(null, new HypervolumeContribution<>()),
                null,
                new KTournamentSelection(populationSize, 2, null, new HypervolumeContribution<>()),
                crossoverOperator,
                mutationOperator,
                evaluator);
    }

}
