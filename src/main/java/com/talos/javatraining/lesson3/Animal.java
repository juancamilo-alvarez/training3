package com.talos.javatraining.lesson3;

import org.apache.commons.lang3.StringUtils;

import java.util.List;


public interface Animal
{

	List<String> getCharacteristics();


	default public String getName()
	{
		return getClass().getSimpleName();
	}

	default public String getFullDescription()
	{
		StringBuilder builder = new StringBuilder();
		String name = getName();
		String lastChr = name.substring(name.length()-1);
		builder.append(name).append(lastChr.equals("s") ? "es" : "s").append(" have these characteristics :");
		for (String characteristic : getCharacteristics())
		{
			builder.append(StringUtils.LF).append(StringUtils.CR).append("- ").append(characteristic);
		}
		return builder.toString();
	}

	static Animal create(String name) {

		Class animalType;
		Animal newAnimal = null;
		try {
			animalType = Class.forName("com.talos.javatraining.lesson3.impl.animals."+name);
			newAnimal = (Animal) animalType.newInstance();
		}
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException e)
		{
			e.printStackTrace();
		}
		finally {
			return newAnimal;
		}
	}

}
