package br.com.cybereagle.geneticalgorithm.stopcondition;

import br.com.cybereagle.geneticalgorithm.bean.Individual;
import br.com.cybereagle.geneticalgorithm.bean.Population;
import br.com.cybereagle.geneticalgorithm.interfaces.StopCondition;

public class NumberOfGenerationsStopCondition<T extends Individual> implements StopCondition<T> {

	private int numberOfGenerations;
	
	public NumberOfGenerationsStopCondition(int maxNumber) {
		this.numberOfGenerations = maxNumber;
	}

	public boolean mustStop(int generationNumber, Population<T> currentPopulation) {
		return generationNumber >= numberOfGenerations;
	}

}
