package br.com.cybereagle.geneticalgorithm.interfaces;

import br.com.cybereagle.geneticalgorithm.bean.Population;
import br.com.cybereagle.geneticalgorithm.bean.Individual;

public interface PopulationGenerationOperator<T extends Individual> {

	Population<T> generatePopulation(int populationSize);
	
}
