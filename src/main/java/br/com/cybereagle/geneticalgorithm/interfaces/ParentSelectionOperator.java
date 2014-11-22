package br.com.cybereagle.geneticalgorithm.interfaces;

import br.com.cybereagle.geneticalgorithm.bean.Individual;
import br.com.cybereagle.geneticalgorithm.bean.Population;
import br.com.cybereagle.geneticalgorithm.config.Goal;

public interface ParentSelectionOperator<T extends Individual> {

	void prepare(Population<T> population, Goal goal);
	T selectParent(Goal goal);
	
}
