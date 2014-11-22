package br.com.cybereagle.geneticalgorithm.config;

import br.com.cybereagle.geneticalgorithm.bean.Individual;
import br.com.cybereagle.geneticalgorithm.interfaces.CrossoverOperator;
import br.com.cybereagle.geneticalgorithm.interfaces.MutationOperator;
import br.com.cybereagle.geneticalgorithm.interfaces.ParentSelectionOperator;
import br.com.cybereagle.geneticalgorithm.interfaces.PopulationGenerationOperator;
import br.com.cybereagle.geneticalgorithm.interfaces.SurvivalSelectionOperator;

public final class Operators<T extends Individual> {

	private PopulationGenerationOperator<T> populationGenerationOperator;
	private ParentSelectionOperator<T> parentSelectionOperator;
	private CrossoverOperator<T> crossoverOperator;
	private MutationOperator<T> mutationOperator;
	private SurvivalSelectionOperator<T> survivalSelectionOperator;
	
	private Operators(){
		
	}
	
	public PopulationGenerationOperator<T> getPopulationGenerationOperator() {
		return populationGenerationOperator;
	}
	public ParentSelectionOperator<T> getParentSelectionOperator() {
		return parentSelectionOperator;
	}
	public CrossoverOperator<T> getCrossoverOperator() {
		return crossoverOperator;
	}
	public MutationOperator<T> getMutationOperator() {
		return mutationOperator;
	}
	public SurvivalSelectionOperator<T> getSurvivalSelectionOperator() {
		return survivalSelectionOperator;
	}
	
	public static final class Builder<E extends Individual> {
		private PopulationGenerationOperator<E> populationGenerationOperator;
		private ParentSelectionOperator<E> parentSelectionOperator;
		private CrossoverOperator<E> crossoverOperator;
		private MutationOperator<E> mutationOperator;
		private SurvivalSelectionOperator<E> survivalSelectionOperator;
		
		public Operators<E> build(){
			Operators<E> operators = new Operators<E>();
			operators.populationGenerationOperator = populationGenerationOperator;
			operators.parentSelectionOperator = parentSelectionOperator;
			operators.crossoverOperator = crossoverOperator;
			operators.mutationOperator = mutationOperator;
			operators.survivalSelectionOperator = survivalSelectionOperator;
			return operators;
		}
		
		public Builder<E> setPopulationGenerationOperator(
				PopulationGenerationOperator<E> populationGenerationOperator) {
			this.populationGenerationOperator = populationGenerationOperator;
			return this;
		}
		public Builder<E> setParentSelectionOperator(
				ParentSelectionOperator<E> parentSelectionOperator) {
			this.parentSelectionOperator = parentSelectionOperator;
			return this;
		}
		public Builder<E> setCrossoverOperator(CrossoverOperator<E> crossoverOperator) {
			this.crossoverOperator = crossoverOperator;
			return this;
		}
		public Builder<E> setMutationOperator(MutationOperator<E> mutationOperator) {
			this.mutationOperator = mutationOperator;
			return this;
		}
		public Builder<E> setSurvivalSelectionOperator(
				SurvivalSelectionOperator<E> survivalSelectionOperator) {
			this.survivalSelectionOperator = survivalSelectionOperator;
			return this;
		}
		
		
	}
}
