package br.com.cybereagle.geneticalgorithm.interfaces;

import java.util.List;

import br.com.cybereagle.geneticalgorithm.bean.Individual;

public interface CrossoverOperator<T extends Individual> {

	List<T> crossover(T mother, T father);
	
}
