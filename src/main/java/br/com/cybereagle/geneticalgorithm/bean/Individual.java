package br.com.cybereagle.geneticalgorithm.bean;

public abstract class Individual {

	protected Double fitness;
	
	public abstract Double evaluateFitness();
	public abstract Individual createClone();

	public Double getFitness() {
		if(fitness == null){
			setFitness(evaluateFitness());
		}
		return fitness;
	}

	public void setFitness(Double fitness) {
		this.fitness = fitness;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fitness == null) ? 0 : fitness.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Individual other = (Individual) obj;
		if (fitness == null) {
			if (other.fitness != null)
				return false;
		} else if (!fitness.equals(other.fitness))
			return false;
		return true;
	}
	
}
