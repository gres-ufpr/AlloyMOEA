package br.ufpr.inf.gres.alloy.algorithm.components.impl.selection;

import java.util.List;
import br.ufpr.inf.gres.alloy.algorithm.components.SelectionImplementation;
import org.uma.jmetal.operator.SelectionOperator;
import org.uma.jmetal.solution.Solution;

public class OnlyArchiveSelection<S extends Solution<?>> implements SelectionImplementation<S> {

    @Override
    public List<S> selection(List<S> population, List<S> archivePopulation, SelectionOperator<List<S>, List<S>> selectionOperator) {
        return selectionOperator.execute(archivePopulation);
    }
    
    @Override
    public String toString() {
        return "Archive";
    }

}
