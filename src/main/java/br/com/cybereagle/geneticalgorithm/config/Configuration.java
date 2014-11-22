package br.com.cybereagle.geneticalgorithm.config;

import br.com.cybereagle.geneticalgorithm.bean.Individual;

public final class Configuration<T extends Individual> {

	private Goal goal;
	private Double mutationProbability;
	private Double crossoverProbability;
	private Integer numberOfChildren;
	private Integer populationSize;

	private Configuration(){
		
	}
	
	public Goal getGoal() {
		return goal;
	}

	public Double getMutationProbability() {
		return mutationProbability;
	}

	public Double getCrossoverProbability() {
		return crossoverProbability;
	}

	public Integer getNumberOfChildren() {
		return numberOfChildren;
	}

	public Integer getPopulationSize() {
		return populationSize;
	}

	public static final class Builder<E extends Individual> {
		private Goal goal = Goal.MAXIMIZE_FITNESS;
		private Double mutationProbability;
		private Double crossoverProbability;
		private Integer numberOfChildren;
		private Integer populationSize;
		
		public Configuration<E> build(){
			Configuration<E> configuration = new Configuration<E>();
			configuration.goal = this.goal;
			configuration.mutationProbability = mutationProbability;
			configuration.crossoverProbability = crossoverProbability;
			configuration.numberOfChildren = numberOfChildren;
			configuration.populationSize = populationSize;
			return configuration;
		}

		public Builder<E> setGoal(Goal goal) {
			this.goal = goal;
			return this;
		}

		public Builder<E> setMutationProbability(Double mutationProbability) {
			this.mutationProbability = mutationProbability;
			return this;
		}

		public Builder<E> setCrossoverProbability(Double crossoverProbability) {
			this.crossoverProbability = crossoverProbability;
			return this;
		}

		public Builder<E> setNumberOfChildren(Integer numberOfChildren) {
			this.numberOfChildren = numberOfChildren;
			return this;
		}

		public Builder<E> setPopulationSize(Integer populationSize) {
			this.populationSize = populationSize;
			return this;
		}
	}
	
}
