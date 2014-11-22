package br.com.cybereagle.geneticalgorithm.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import br.com.cybereagle.geneticalgorithm.comparator.MaximizationComparator;
import br.com.cybereagle.geneticalgorithm.comparator.MinimizationComparator;

public class Population<T extends Individual> implements List<T> {

	private List<T> individuals;
	
	public Population(List<T> individuals) {
		this.individuals = new ArrayList<T>(individuals);
	}
	
	public Population() {
		this.individuals = new ArrayList<T>();
	}

	public void evaluateFitness(){
		for(T individual : individuals){
			individual.setFitness(individual.evaluateFitness());
		}
	}
	
	public T getFittestIndividual(Comparator<Individual> comparator){
		return Collections.max(individuals, comparator);
	}

	public boolean add(T individual) {
		return individuals.add(individual);
	}

	public void add(int index, T individual) {
		individuals.add(index, individual);
	}

	public boolean addAll(Collection<? extends T> collection) {
		return individuals.addAll(collection);
	}

	public boolean addAll(int index, Collection<? extends T> collection) {
		return individuals.addAll(index, collection);
	}

	public void clear() {
		individuals.clear();
	}

	public boolean contains(Object individual) {
		return individuals.contains(individual);
	}

	public boolean containsAll(Collection<?> collection) {
		return individuals.containsAll(collection);
	}

	public T get(int index) {
		return individuals.get(index);
	}

	public int indexOf(Object individual) {
		return individuals.indexOf(individual);
	}

	public boolean isEmpty() {
		return individuals.isEmpty();
	}

	public Iterator<T> iterator() {
		return individuals.iterator();
	}

	public int lastIndexOf(Object individual) {
		return individuals.lastIndexOf(individual);
	}

	public ListIterator<T> listIterator() {
		return individuals.listIterator();
	}

	public ListIterator<T> listIterator(int index) {
		return individuals.listIterator(index);
	}

	public boolean remove(Object individual) {
		return individuals.remove(individual);
	}

	public T remove(int index) {
		return individuals.remove(index);
	}

	public boolean removeAll(Collection<?> collection) {
		return individuals.removeAll(collection);
	}

	public boolean retainAll(Collection<?> collection) {
		return individuals.retainAll(collection);
	}

	public T set(int index, T individual) {
		return individuals.set(index, individual);
	}

	public int size() {
		return individuals.size();
	}

	public List<T> subList(int fromIndex, int toIndex) {
		return individuals.subList(fromIndex, toIndex);
	}

	public Object[] toArray() {
		return individuals.toArray();
	}

	public <E> E[] toArray(E[] array) {
		return individuals.toArray(array);
	}
	
	@Override
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Tamanho da população: " + size() + "\n");
		stringBuilder.append("Indivíduo de maior fitness:\n\n");
		T greatestFitnessIndividual = getFittestIndividual(new MaximizationComparator());
		stringBuilder.append("Fitness: " + greatestFitnessIndividual.getFitness() + "\n");
		stringBuilder.append(greatestFitnessIndividual.toString());
		stringBuilder.append("\n");
		stringBuilder.append("Indivíduo de menor fitness:\n\n");
		T smallestFitnessIndividual = getFittestIndividual(new MinimizationComparator());
		stringBuilder.append("Fitness: " + smallestFitnessIndividual.getFitness() + "\n");
		stringBuilder.append(smallestFitnessIndividual.toString());
		return stringBuilder.toString();
	}
}
