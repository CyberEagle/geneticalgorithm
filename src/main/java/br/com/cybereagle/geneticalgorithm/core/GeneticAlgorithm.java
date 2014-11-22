package br.com.cybereagle.geneticalgorithm.core;

import java.util.HashMap;
import java.util.Map;

import br.com.cybereagle.geneticalgorithm.bean.Individual;
import br.com.cybereagle.geneticalgorithm.bean.Population;
import br.com.cybereagle.geneticalgorithm.config.Configuration;
import br.com.cybereagle.geneticalgorithm.config.Operators;
import br.com.cybereagle.geneticalgorithm.interfaces.StopCondition;
import br.com.cybereagle.geneticalgorithm.listener.GeneticAlgorithmListener;
import br.com.cybereagle.geneticalgorithm.stopcondition.NumberOfGenerationsStopCondition;
import br.com.cybereagle.geneticalgorithm.util.ProbabilityUtil;

public class GeneticAlgorithm<T extends Individual> {

	private enum Listener{
		ON_GENERATE_POPULATION, ON_CROSSOVER, ON_MUTATION
	}
	
	private Configuration<T> configuration;
	private Operators<T> operators;
	private StopCondition<T> stopCondition;
	
	private int generationNumber;
	
	private Population<T> currentPopulation;
	private Population<T> children;

	private Map<Listener, GeneticAlgorithmListener<T>> listeners;
	
	private ProbabilityUtil probabilityUtil;
	
	private boolean mustStop;
	
	public GeneticAlgorithm(Configuration<T> configuration, Operators<T> operators, StopCondition<T> stopCondition){
		this.configuration = configuration;
		this.operators = operators;
		this.stopCondition = stopCondition;
		this.generationNumber = 0;
		this.listeners = new HashMap<GeneticAlgorithm.Listener, GeneticAlgorithmListener<T>>();
		this.probabilityUtil = new ProbabilityUtil();
		this.mustStop = false;
	}
	
	public GeneticAlgorithm(Configuration<T> configuration, Operators<T> operators, int numberOfGenerations){
		this(configuration, operators, new NumberOfGenerationsStopCondition<T>(numberOfGenerations));
	}

	public Population<T> execute(){
		resetGeneration();
		do{
			nextGeneration();
		}while(!stopCondition.mustStop(generationNumber, currentPopulation) && !mustStop);
		mustStop = false;
		return currentPopulation;
	}
	
	public Population<T> nextGeneration(){
		if(generationNumber == 0){
			currentPopulation = operators.getPopulationGenerationOperator().generatePopulation(configuration.getPopulationSize());
			currentPopulation.evaluateFitness();
			executeListener(Listener.ON_GENERATE_POPULATION);
			if(mustStop){
				return currentPopulation;
			}
		}
		generationNumber++;
		
		currentPopulation = evolve(currentPopulation);
		
		return currentPopulation;
	}
	
	@SuppressWarnings("unchecked")
	private Population<T> evolve(Population<T> population){
		children = new Population<T>();
		
		// Crossover
		prepareForSelection();
		while(children.size() < configuration.getNumberOfChildren()){
			T mother = getParent();
			T father = getParent();
			while(mother == father){
				father = getParent();
			}
			if(probabilityUtil.roll(configuration.getCrossoverProbability())){
				children.addAll(operators.getCrossoverOperator().crossover(mother, father));
			}
			else{
				children.add((T) mother.createClone());
				children.add((T) father.createClone());
			}
		}
		children.evaluateFitness();
		executeListener(Listener.ON_CROSSOVER);
		if(mustStop){
			return currentPopulation;
		}
		
		// Mutation
		for(T individual : children){
			operators.getMutationOperator().mutate(individual, configuration.getMutationProbability());
		}
		children.evaluateFitness();
		executeListener(Listener.ON_MUTATION);
		if(mustStop){
			return currentPopulation;
		}
		
		return operators.getSurvivalSelectionOperator().selectForSurvival(population, children, configuration.getGoal(), configuration.getPopulationSize());
	}

	private void prepareForSelection() {
		operators.getParentSelectionOperator().prepare(currentPopulation, configuration.getGoal());
	}

	private T getParent() {
		return operators.getParentSelectionOperator().selectParent(configuration.getGoal());
	}
	
	public void resetGeneration(){
		currentPopulation = null;
		generationNumber = 0;
	}
	
	public int getGenerationNumber() {
		return generationNumber;
	}

	public void stop(){
		mustStop = true;
	}
	
	public void stopAndSetCurrentPopulation(Population<T> population){
		currentPopulation = population;
		stop();
	}
	
	public Population<T> getCurrentPopulation() {
		return currentPopulation;
	}

	public Population<T> getChildren() {
		return children;
	}

	public void setCurrentPopulation(Population<T> currentPopulation) {
		this.currentPopulation = currentPopulation;
	}

	public void onGeneratePopulation(GeneticAlgorithmListener<T> listener){
		listeners.put(Listener.ON_GENERATE_POPULATION, listener);
	}
	
	public void onCrossover(GeneticAlgorithmListener<T> listener){
		listeners.put(Listener.ON_CROSSOVER, listener);
	}
	
	public void onMutation(GeneticAlgorithmListener<T> listener){
		listeners.put(Listener.ON_MUTATION, listener);
	}

	private void executeListener(Listener listener){
		GeneticAlgorithmListener<T> geneticAlgorithmListener = listeners.get(listener);
		if(geneticAlgorithmListener != null){
			geneticAlgorithmListener.execute(this);
		}
	}

	public Configuration<T> getConfiguration() {
		return configuration;
	}
	
}
