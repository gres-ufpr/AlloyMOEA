package br.ufpr.inf.gres.alloy.algorithm;

import br.ufpr.inf.gres.alloy.algorithm.components.ArchivingImplementation;
import br.ufpr.inf.gres.alloy.algorithm.components.InitializationImplementation;
import br.ufpr.inf.gres.alloy.algorithm.components.ProgressImplementation;
import br.ufpr.inf.gres.alloy.algorithm.components.ReplacementImplementation;
import br.ufpr.inf.gres.alloy.algorithm.components.ReproductionImplementation;
import br.ufpr.inf.gres.alloy.algorithm.components.SelectionImplementation;
import br.ufpr.inf.gres.alloy.algorithm.components.StoppingConditionImplementation;
import br.ufpr.inf.gres.alloy.algorithm.components.TrackingImplementation;
import java.util.ArrayList;
import java.util.List;
import org.uma.jmetal.algorithm.Algorithm;
import org.uma.jmetal.algorithm.impl.AbstractGeneticAlgorithm;
import org.uma.jmetal.operator.CrossoverOperator;
import org.uma.jmetal.operator.MutationOperator;
import org.uma.jmetal.operator.SelectionOperator;
import org.uma.jmetal.problem.Problem;
import org.uma.jmetal.solution.Solution;
import org.uma.jmetal.util.SolutionListUtils;
import org.uma.jmetal.util.evaluator.SolutionListEvaluator;

public abstract class AbstractDynamicGeneticAlgorithm<S extends Solution<?>> extends AbstractGeneticAlgorithm<S, List<S>> implements Algorithm<List<S>> {

    protected Problem<S> problem;
    protected int populationSize;

    // Bridge Implementations
    // These objects will dictate how the algorithm should behave.
    protected ProgressImplementation progressImplementation;
    protected StoppingConditionImplementation stoppingConditionImplementation;
    protected InitializationImplementation<S> populationInitializationImplementation;
    protected SolutionListEvaluator<S> solutionListEvaluator;
    protected SelectionImplementation<S> selectionImplementation;
    protected ReproductionImplementation<S> reproductionImplementation;
    protected ReplacementImplementation<S> replacementImplementation;
    protected ArchivingImplementation<S> archivingImplementation;
    protected SelectionOperator<List<S>, List<S>> selectionOperator;
    protected TrackingImplementation trackingImplementation;

    public AbstractDynamicGeneticAlgorithm(Problem<S> problem, int populationSize, ProgressImplementation progressImplementation, StoppingConditionImplementation stoppingConditionImplementation, InitializationImplementation<S> populationInitializationImplementation, SelectionImplementation<S> selectionImplementation, ReproductionImplementation<S> reproductionImplementation, ReplacementImplementation<S> replacementImplementation, ArchivingImplementation<S> archivingImplementation, SelectionOperator<List<S>, List<S>> selectionOperator, CrossoverOperator<S> crossoverOperator, MutationOperator<S> mutationOperator, SolutionListEvaluator<S> solutionListEvaluator) {
        this(problem, populationSize, progressImplementation, stoppingConditionImplementation, populationInitializationImplementation, selectionImplementation, reproductionImplementation, replacementImplementation, archivingImplementation, selectionOperator, crossoverOperator, mutationOperator, null, solutionListEvaluator);
    }

    public AbstractDynamicGeneticAlgorithm(Problem<S> problem, int populationSize, ProgressImplementation progressImplementation, StoppingConditionImplementation stoppingConditionImplementation, InitializationImplementation<S> populationInitializationImplementation, SelectionImplementation<S> selectionImplementation, ReproductionImplementation<S> reproductionImplementation, ReplacementImplementation<S> replacementImplementation, ArchivingImplementation<S> archivingImplementation, SelectionOperator<List<S>, List<S>> selectionOperator, CrossoverOperator<S> crossoverOperator, MutationOperator<S> mutationOperator, TrackingImplementation trackingImplementation, SolutionListEvaluator<S> solutionListEvaluator) {
        this.problem = problem;
        this.populationSize = populationSize;
        this.progressImplementation = progressImplementation;
        this.stoppingConditionImplementation = stoppingConditionImplementation;
        this.populationInitializationImplementation = populationInitializationImplementation;
        this.solutionListEvaluator = solutionListEvaluator;
        this.selectionImplementation = selectionImplementation;
        this.reproductionImplementation = reproductionImplementation;
        this.replacementImplementation = replacementImplementation;
        this.archivingImplementation = archivingImplementation;
        super.crossoverOperator = crossoverOperator;
        super.mutationOperator = mutationOperator;
        this.selectionOperator = selectionOperator;
        this.trackingImplementation = trackingImplementation;
    }

    public Problem<S> getProblem() {
        return problem;
    }

    public void setProblem(Problem<S> problem) {
        this.problem = problem;
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public void setPopulationSize(int populationSize) {
        this.populationSize = populationSize;
    }

    public ProgressImplementation getProgressImplementation() {
        return progressImplementation;
    }

    public void setProgressImplementation(ProgressImplementation progressImplementation) {
        this.progressImplementation = progressImplementation;
    }

    public StoppingConditionImplementation getStoppingConditionImplementation() {
        return stoppingConditionImplementation;
    }

    public void setStoppingConditionImplementation(StoppingConditionImplementation stoppingConditionImplementation) {
        this.stoppingConditionImplementation = stoppingConditionImplementation;
    }

    public InitializationImplementation<S> getPopulationInitializationImplementation() {
        return populationInitializationImplementation;
    }

    public void setPopulationInitializationImplementation(InitializationImplementation<S> populationInitializationImplementation) {
        this.populationInitializationImplementation = populationInitializationImplementation;
    }

    public SolutionListEvaluator<S> getSolutionListEvaluator() {
        return solutionListEvaluator;
    }

    public void setSolutionListEvaluator(SolutionListEvaluator<S> solutionListEvaluator) {
        this.solutionListEvaluator = solutionListEvaluator;
    }

    public SelectionImplementation<S> getSelectionImplementation() {
        return selectionImplementation;
    }

    public void setSelectionImplementation(SelectionImplementation<S> selectionImplementation) {
        this.selectionImplementation = selectionImplementation;
    }

    public ReproductionImplementation<S> getReproductionImplementation() {
        return reproductionImplementation;
    }

    public void setReproductionImplementation(ReproductionImplementation<S> reproductionImplementation) {
        this.reproductionImplementation = reproductionImplementation;
    }

    public ReplacementImplementation<S> getReplacementImplementation() {
        return replacementImplementation;
    }

    public void setReplacementImplementation(ReplacementImplementation<S> replacementImplementation) {
        this.replacementImplementation = replacementImplementation;
    }

    public ArchivingImplementation<S> getArchivingImplementation() {
        return archivingImplementation;
    }

    public void setArchivingImplementation(ArchivingImplementation<S> archivingImplementation) {
        this.archivingImplementation = archivingImplementation;
    }

    public SelectionOperator<List<S>, List<S>> getSelectionOperator() {
        return selectionOperator;
    }

    public void setSelectionOperator(SelectionOperator<List<S>, List<S>> selectionOperator) {
        this.selectionOperator = selectionOperator;
    }

    public CrossoverOperator<S> getCrossoverOperator() {
        return crossoverOperator;
    }

    public void setCrossoverOperator(CrossoverOperator<S> crossoverOperator) {
        this.crossoverOperator = crossoverOperator;
    }

    public MutationOperator<S> getMutationOperator() {
        return mutationOperator;
    }

    public void setMutationOperator(MutationOperator<S> mutationOperator) {
        this.mutationOperator = mutationOperator;
    }

    public TrackingImplementation getTrackingImplementation() {
        return trackingImplementation;
    }

    public void setTrackingImplementation(TrackingImplementation trackingImplementation) {
        this.trackingImplementation = trackingImplementation;
    }

    @Override
    protected void initProgress() {
        this.initProgress(0);
    }

    protected void initProgress(int state) {
        progressImplementation.initialize(state);
    }

    @Override
    protected void updateProgress() {
        this.updateProgress(populationSize);
    }

    protected void updateProgress(int state) {
        progressImplementation.update(state);
    }

    protected int getCurrentProgress() {
        return progressImplementation.getCurrentProgress();
    }

    public void setCurrentProgress(int state) {
        progressImplementation.setCurrentProgress(state);
    }

    @Override
    protected boolean isStoppingConditionReached() {
        return stoppingConditionImplementation.isStoppingConditionReached(getCurrentProgress());
    }

    @Override
    protected List<S> createInitialPopulation() {
        return populationInitializationImplementation.createInitialPopulation(problem, populationSize);
    }

    @Override
    protected List<S> evaluatePopulation(List<S> population) {
        return solutionListEvaluator.evaluate(population, problem);
    }

    @Override
    protected List<S> selection(List<S> parents) {
        return selectionImplementation.selection(new ArrayList(parents), new ArrayList(getArchive()), selectionOperator);
    }

    @Override
    protected List<S> reproduction(List<S> matingPopulation) {
        return this.reproduction(matingPopulation, populationSize);
    }

    protected List<S> reproduction(List<S> matingPopulation, int offspringSize) {
        return reproductionImplementation.reproduction(new ArrayList(matingPopulation), offspringSize, crossoverOperator, mutationOperator);
    }

    @Override
    protected List<S> replacement(List<S> population, List<S> offspringPopulation) {
        return replacementImplementation.replacement(new ArrayList(population), new ArrayList(offspringPopulation), populationSize);
    }

    protected int archive(List<S> population) {
        if (archivingImplementation != null) {
            return archivingImplementation.updateArchive(population);
        } else {
            return 0;
        }
    }

    protected List<S> getArchive() {
        if (archivingImplementation != null) {
            return archivingImplementation.getArchive();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public List<S> getResult() {
        return SolutionListUtils.getNondominatedSolutions(getResultWithDominatedSolutions());
    }

    public List<S> getResultWithDominatedSolutions() {
        if (archivingImplementation == null || getArchive().isEmpty()) {
            return this.getPopulation();
        } else {
            return getArchive();
        }
    }

    public void trackProgress() {
        if (trackingImplementation != null) {
            trackingImplementation.trackProgress(this);
        }
    }

    @Override
    public abstract void run();

}
