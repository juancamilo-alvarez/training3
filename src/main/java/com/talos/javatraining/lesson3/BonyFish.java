package com.talos.javatraining.lesson3;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;


public interface BonyFish extends Fish {
	@Override
	default List<String> getCharacteristics()
	{
		List<String> characteristics = new ArrayList<>(Fish.super.getCharacteristics());
		characteristics.add("They have skeletons primarily composed of bone tissue");

		/*

	    List<String> characteristics = asList("They have skeletons primarily composed of bone tissue");
		 characteristics.addAll(Fish.super.getCharacteristics());

		* */

		return characteristics;
	}
}
