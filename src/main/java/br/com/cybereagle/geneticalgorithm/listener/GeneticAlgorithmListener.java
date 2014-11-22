package br.com.cybereagle.geneticalgorithm.listener;

import br.com.cybereagle.geneticalgorithm.bean.Individual;
import br.com.cybereagle.geneticalgorithm.core.GeneticAlgorithm;

public interface GeneticAlgorithmListener<T extends Individual> {

	void execute(GeneticAlgorithm<T> geneticAlgorithm);
	
}
