package br.ufpr.inf.gres.alloy.algorithm.impl;

import java.util.List;
import br.ufpr.inf.gres.alloy.algorithm.AbstractDynamicGeneticAlgorithm;
import br.ufpr.inf.gres.alloy.algorithm.components.ArchivingImplementation;
import br.ufpr.inf.gres.alloy.algorithm.components.InitializationImplementation;
import br.ufpr.inf.gres.alloy.algorithm.components.ProgressImplementation;
import br.ufpr.inf.gres.alloy.algorithm.components.ReplacementImplementation;
import br.ufpr.inf.gres.alloy.algorithm.components.ReproductionImplementation;
import br.ufpr.inf.gres.alloy.algorithm.components.SelectionImplementation;
import br.ufpr.inf.gres.alloy.algorithm.components.StoppingConditionImplementation;
import org.uma.jmetal.operator.CrossoverOperator;
import org.uma.jmetal.operator.MutationOperator;
import org.uma.jmetal.operator.SelectionOperator;
import org.uma.jmetal.problem.Problem;
import org.uma.jmetal.solution.Solution;
import org.uma.jmetal.util.evaluator.SolutionListEvaluator;

public class DefaultDynamicGeneticAlgorithm<S extends Solution<?>> extends AbstractDynamicGeneticAlgorithm<S> {

    public DefaultDynamicGeneticAlgorithm(Problem<S> problem, int populationSize, ProgressImplementation progressImplementation, StoppingConditionImplementation stoppingConditionImplementation, InitializationImplementation<S> populationInitializationImplementation, SelectionImplementation<S> selectionImplementation, ReproductionImplementation<S> reproductionImplementation, ReplacementImplementation<S> replacementImplementation, ArchivingImplementation<S> archivingImplementation, SelectionOperator<List<S>, List<S>> selectionOperator, CrossoverOperator<S> crossoverOperator, MutationOperator<S> mutationOperator, SolutionListEvaluator<S> solutionListEvaluator) {
        super(problem, populationSize, progressImplementation,
                stoppingConditionImplementation, populationInitializationImplementation, selectionImplementation, reproductionImplementation,
                replacementImplementation, archivingImplementation, selectionOperator,
                crossoverOperator, mutationOperator, solutionListEvaluator);
    }

    @Override
    public void run() {
        List<S> offspringPopulation;
        List<S> matingPopulation;

        initProgress();
        setPopulation(evaluatePopulation(createInitialPopulation()));
        archive(getPopulation());
        updateProgress(getPopulation().size());
        trackProgress();
        while (!isStoppingConditionReached()) {
            matingPopulation = selection(getPopulation());
            offspringPopulation = reproduction(matingPopulation);
            offspringPopulation = evaluatePopulation(offspringPopulation);
            setPopulation(replacement(getPopulation(), offspringPopulation));
            archive(offspringPopulation);
            updateProgress(offspringPopulation.size());
            trackProgress();
        }
    }

}
