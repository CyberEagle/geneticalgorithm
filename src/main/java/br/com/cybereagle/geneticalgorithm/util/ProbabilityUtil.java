package br.com.cybereagle.geneticalgorithm.util;

public class ProbabilityUtil {

	public boolean roll(double probability){
		return Math.random() <= probability;
	}
}
