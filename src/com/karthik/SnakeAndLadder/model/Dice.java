package com.karthik.SnakeAndLadder.model;

public class Dice
{
	private int minVal;
	private int maxVal;
	private int numberOfDice;

	public Dice(int minVal, int maxVal, int numberOfDice)
	{
		this.minVal = minVal;
		this.maxVal = maxVal;
		this.numberOfDice = numberOfDice;
	}

	public int roll()
	{
		return ((int) (Math.random() * (maxVal * numberOfDice - minVal * numberOfDice))) + 1;
	}

	public int getNumberOfDice()
	{
		return numberOfDice;
	}

	public void setNumberOfDice(int numberOfDice)
	{
		this.numberOfDice = numberOfDice;
	}
}
