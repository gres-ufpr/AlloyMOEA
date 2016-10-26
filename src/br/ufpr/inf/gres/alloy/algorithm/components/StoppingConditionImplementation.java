package br.ufpr.inf.gres.alloy.algorithm.components;

public interface StoppingConditionImplementation {

    public boolean isStoppingConditionReached(long progress);

    public void setStoppingCondition(long maxProgress);

}
