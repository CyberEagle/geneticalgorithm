package br.com.cybereagle.geneticalgorithm.comparator;

import java.util.Comparator;

import br.com.cybereagle.geneticalgorithm.bean.Individual;

public class MinimizationComparator implements Comparator<Individual> {

	public int compare(Individual individual1, Individual individual2) {
		return -(individual1.getFitness().compareTo(individual2.getFitness()));
	}

}