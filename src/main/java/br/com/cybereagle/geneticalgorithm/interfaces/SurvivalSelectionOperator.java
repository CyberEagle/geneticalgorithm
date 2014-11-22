package br.com.cybereagle.geneticalgorithm.interfaces;

import br.com.cybereagle.geneticalgorithm.bean.Individual;
import br.com.cybereagle.geneticalgorithm.bean.Population;
import br.com.cybereagle.geneticalgorithm.config.Goal;

public interface SurvivalSelectionOperator<T extends Individual> {

	Population<T> selectForSurvival(Population<T> currentPopulation, Population<T> childrenPopulation, Goal goal, int populationSize);
	
}
