package br.com.cybereagle.geneticalgorithm.interfaces;

import br.com.cybereagle.geneticalgorithm.bean.Individual;

public interface MutationOperator<T extends Individual> {

	void mutate(T individual, double mutationProbability);
	
}
