package br.ufpr.inf.gres.alloy.algorithm.impl;

import br.ufpr.inf.gres.alloy.algorithm.components.ArchivingImplementation;
import br.ufpr.inf.gres.alloy.algorithm.components.InitializationImplementation;
import br.ufpr.inf.gres.alloy.algorithm.components.ProgressImplementation;
import br.ufpr.inf.gres.alloy.algorithm.components.ReplacementImplementation;
import br.ufpr.inf.gres.alloy.algorithm.components.ReproductionImplementation;
import br.ufpr.inf.gres.alloy.algorithm.components.SelectionImplementation;
import br.ufpr.inf.gres.alloy.algorithm.components.StoppingConditionImplementation;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.diversity.CrowdingDistance;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.initialization.RandomInitialization;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.progress.EvaluationsCountProgress;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.ranking.DominanceDepth;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.replacement.RankingAndDiversityReplacement;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.reproduction.GenerationalTwoChildrenReproduction;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.selection.OnlyPopulationSelection;
import br.ufpr.inf.gres.alloy.algorithm.components.impl.stoppingcondition.MaxEvaluationsCondition;
import java.util.List;
import org.uma.jmetal.operator.CrossoverOperator;
import org.uma.jmetal.operator.MutationOperator;
import org.uma.jmetal.operator.SelectionOperator;
import org.uma.jmetal.problem.Problem;
import org.uma.jmetal.solution.Solution;
import org.uma.jmetal.util.evaluator.SolutionListEvaluator;

public class DynamicNSGAII<S extends Solution<?>> extends DefaultDynamicGeneticAlgorithm<S> {

    public DynamicNSGAII(Problem<S> problem, int populationSize, ProgressImplementation progressImplementation, StoppingConditionImplementation stoppingConditionImplementation, InitializationImplementation<S> populationInitializationImplementation, SelectionImplementation<S> selectionImplementation, ReproductionImplementation<S> reproductionImplementation, ReplacementImplementation<S> replacementImplementation, ArchivingImplementation<S> archivingImplementation, SelectionOperator<List<S>, List<S>> selectionOperator, CrossoverOperator<S> crossoverOperator, MutationOperator<S> mutationOperator, SolutionListEvaluator<S> solutionListEvaluator) {
        super(problem, populationSize, progressImplementation, stoppingConditionImplementation, populationInitializationImplementation, selectionImplementation, reproductionImplementation, replacementImplementation, archivingImplementation, selectionOperator, crossoverOperator, mutationOperator, solutionListEvaluator);
    }

    public DynamicNSGAII(Problem<S> problem, int maxEvaluations, int populationSize,
            CrossoverOperator<S> crossoverOperator, MutationOperator<S> mutationOperator,
            SelectionOperator<List<S>, List<S>> selectionOperator, SolutionListEvaluator<S> evaluator) {
        super(problem,
                populationSize,
                new EvaluationsCountProgress(),
                new MaxEvaluationsCondition(maxEvaluations),
                new RandomInitialization<>(),
                new OnlyPopulationSelection<>(),
                new GenerationalTwoChildrenReproduction<>(),
                new RankingAndDiversityReplacement<>(new DominanceDepth<S>(), new CrowdingDistance<S>()),
                null,
                selectionOperator,
                crossoverOperator,
                mutationOperator,
                evaluator);
    }

}
