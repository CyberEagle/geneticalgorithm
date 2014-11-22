package br.com.cybereagle.geneticalgorithm.selection;

import br.com.cybereagle.geneticalgorithm.bean.Individual;
import br.com.cybereagle.geneticalgorithm.bean.Population;
import br.com.cybereagle.geneticalgorithm.config.Goal;
import br.com.cybereagle.geneticalgorithm.interfaces.ParentSelectionOperator;
import br.com.cybereagle.geneticalgorithm.util.ProbabilityUtil;
import br.com.cybereagle.geneticalgorithm.util.RandomUtil;

public class TournamentParentSelectionOperator<T extends Individual> implements
		ParentSelectionOperator<T> {

	private double bestIndividualSelectionProbability;
	private RandomUtil randomUtil;
	private ProbabilityUtil probabilityUtil;
	private Population<T> population;
	
	public TournamentParentSelectionOperator(
			double bestIndividualSelectionProbability) {
		this.bestIndividualSelectionProbability = bestIndividualSelectionProbability;
		this.randomUtil = new RandomUtil();
		this.probabilityUtil = new ProbabilityUtil();
	}

	public void prepare(Population<T> population, Goal goal) {
		this.population = population;
	}

	public T selectParent(Goal goal) {
		T individual1 = randomUtil.getRandomEntry(population);
		T individual2 = randomUtil.getRandomEntry(population);
		
		if(probabilityUtil.roll(bestIndividualSelectionProbability)){
			return (goal.getComparator().compare(individual1, individual2) > 0) ? individual1 : individual2;
		}
		else{
			return (goal.getComparator().compare(individual1, individual2) < 0) ? individual1 : individual2;
		}
	}

}
