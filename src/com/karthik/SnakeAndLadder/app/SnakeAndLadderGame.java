package com.karthik.SnakeAndLadder.app;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.karthik.SnakeAndLadder.jump.Jump;
import com.karthik.SnakeAndLadder.model.Board;
import com.karthik.SnakeAndLadder.model.Dice;
import com.karthik.SnakeAndLadder.model.Player;

public class SnakeAndLadderGame
{
	Deque<Player> players;
	List<Jump> snakes;
	List<Jump> ladders;
	Board board;
	Dice dice;

	public SnakeAndLadderGame(int size)
	{
		initializeGame(size);
	}

	public void initializeGame(int size)
	{
		players = new LinkedList<>();
		Player player1 = new Player("Player1");
		Player player2 = new Player("Player2");
		players.add(player1);
		players.add(player2);

		board = new Board(size);

		snakes = new ArrayList<>();
		Jump snake1 = new Jump(10, 2);
		Jump snake2 = new Jump(25, 15);
		Jump snake3 = new Jump(65, 45);
		Jump snake4 = new Jump(99, 22);

		snakes.add(snake1);
		snakes.add(snake2);
		snakes.add(snake3);
		snakes.add(snake4);

		ladders = new ArrayList<>();
		Jump ladder1 = new Jump(5, 24);
		Jump ladder2 = new Jump(12, 46);
		Jump ladder3 = new Jump(53, 70);
		Jump ladder4 = new Jump(32, 50);
		Jump ladder5 = new Jump(68, 89);

		ladders.add(ladder1);
		ladders.add(ladder2);
		ladders.add(ladder3);
		ladders.add(ladder4);
		ladders.add(ladder5);

		dice = new Dice(1, 6, 1);
	}

	public void startGame()
	{
		while (true)
		{
			Player player = players.removeFirst();
			int val = dice.roll();
			int newPosition = player.getPosition() + val;
			if (newPosition > board.getEnd())
			{
				player.setPosition(player.getPosition());
				players.addLast(player);
				continue;
			}

			newPosition = getNewPosition(newPosition);
			if (newPosition == board.getEnd())
			{
				System.out.println(player.getName() + " Won the game.");
				break;
			}
			
			System.out.println(player.getName() + " moved from position " + player.getPosition() + " to new position "
					+ newPosition);
			player.setPosition(newPosition);
			players.addLast(player);
		}
	}

	private int getNewPosition(int newPosition)
	{
		for (Jump snake : snakes)
		{
			if (snake.getStart() == newPosition)
			{
				System.out.println("Player Bit By Snake");
				return snake.getEnd();
			}
		}
		for (Jump ladder : ladders)
		{
			if (ladder.getStart() == newPosition)
			{
				System.out.println("Player Climbed ladder");
				return ladder.getEnd();
			}
		}
		return newPosition;
	}
}
