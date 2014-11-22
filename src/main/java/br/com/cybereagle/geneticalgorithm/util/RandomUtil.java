package br.com.cybereagle.geneticalgorithm.util;

import java.util.List;
import java.util.Random;

public class RandomUtil {
	
	private Random random = new Random();
	
	public <T> T getRandomEntry(List<T> list){
		return list.get(getRandomIndex(list.size()));
	}
	
	public int getRandomIndex(int size){
		return random.nextInt(size);
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

}
