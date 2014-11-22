package br.com.cybereagle.geneticalgorithm.selection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import br.com.cybereagle.geneticalgorithm.bean.Individual;
import br.com.cybereagle.geneticalgorithm.bean.Population;
import br.com.cybereagle.geneticalgorithm.comparator.MaximizationComparator;
import br.com.cybereagle.geneticalgorithm.config.Goal;
import br.com.cybereagle.geneticalgorithm.interfaces.ParentSelectionOperator;

public class RouletteWheelParentSelectionOperator<T extends Individual> implements
		ParentSelectionOperator<T> {

	private Population<T> population;
	private double[] cumulativeFitness;
	private Random random;
	private boolean normalizeFitness;
	
	public RouletteWheelParentSelectionOperator() {
		random = new Random();
	}

	public RouletteWheelParentSelectionOperator(boolean normalizeFitness) {
		this();
		this.normalizeFitness = normalizeFitness;
	}

	public void prepare(Population<T> population, Goal goal) {
		this.population = population;
		cumulativeFitness = new double[population.size()];
		
		double smallestFitness = Collections.min(population, new MaximizationComparator()).getFitness();
		cumulativeFitness[0] = getAdjustedFitness(population.get(0).getFitness(), goal, smallestFitness);
		
		for(int i=1; i<population.size(); i++){
			cumulativeFitness[i] = cumulativeFitness[i-1] + getAdjustedFitness(population.get(0).getFitness(), goal, smallestFitness);
		}
	}

	public T selectParent(Goal goal) {
		double randomFitness = random.nextDouble() * cumulativeFitness[cumulativeFitness.length -1];
		int index = Arrays.binarySearch(cumulativeFitness, randomFitness);
		if(index < 0){
			index = Math.abs(index + 1);
		}
		return population.get(index);
	}
	
	public double getAdjustedFitness(double fitness, Goal goal, double smallestFitness){
		if(normalizeFitness){
			fitness -= (smallestFitness -1);
		}
		return getAdjustedFitness(fitness, goal);
	}

	private double getAdjustedFitness(double fitness, Goal goal) {
		if(goal.equals(Goal.MAXIMIZE_FITNESS)){
			return fitness;
		}
		else{
			return (fitness == 0) ? Double.POSITIVE_INFINITY : 1/fitness;
		}
	}

}

