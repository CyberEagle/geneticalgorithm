package br.com.cybereagle.geneticalgorithm.interfaces;

import br.com.cybereagle.geneticalgorithm.bean.Individual;
import br.com.cybereagle.geneticalgorithm.bean.Population;

public interface StopCondition<T extends Individual> {

	boolean mustStop(int generationNumber, Population<T> currentPopulation);
	
}
