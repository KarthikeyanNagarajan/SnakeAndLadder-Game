package com.karthik.SnakeAndLadder.model;

public class Board
{
	private int start;
	private int end;
	private int size;

	public Board(int size)
	{
		this.start = 1;
		this.end = start + size - 1;
		this.size = size;
	}

	public int getStart()
	{
		return start;
	}

	public int getEnd()
	{
		return end;
	}

	public int getSize()
	{
		return size;
	}

}
