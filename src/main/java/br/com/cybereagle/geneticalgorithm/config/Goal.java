package br.com.cybereagle.geneticalgorithm.config;

import java.util.Comparator;

import br.com.cybereagle.geneticalgorithm.bean.Individual;
import br.com.cybereagle.geneticalgorithm.comparator.MaximizationComparator;
import br.com.cybereagle.geneticalgorithm.comparator.MinimizationComparator;

public enum Goal {
	
	MAXIMIZE_FITNESS(new MaximizationComparator()),
	MINIMIZE_FITNESS(new MinimizationComparator());
	
	private Comparator<Individual> comparator;
	
	Goal(Comparator<Individual> comparator){
		this.comparator = comparator;
	}
	
	public Comparator<Individual> getComparator(){
		return this.comparator;
	}
}
