package com.javagotchi.main; 

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable{

	/**
	 * Main class  of JavaGotchi
	 */
	
	private static final long serialVersionUID = 6532126699542462710L;
	
	//Window resolution, 16 x 9 aspect ratio
	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3; //renders 3x the windows size, increases performance
	
	
	private Thread thread; //Create new sub process
	private boolean running = false; //For the main loop, in the auto generated method from implementing runnable 
	private JFrame frame;
		
	
	
	//Constructor
	public Game()
	{
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size); //method extended from Canvas, sets size of the canvas
		
		frame = new JFrame();
	}
	
	//Main thread, opens the game
	public synchronized void start()
	{
		running = true;
		thread =  new Thread(this, "Display.");
		thread.start();
	}
	
	//Closes the main thread safely, waits for thread to die
	public synchronized void stop()
	{
		running = false;
		try{
			thread.join(); 
		} catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	//Auto generated method by implementing Runnable
	public void run()
	{
		while ( running == true )
		{
			
		}
	}
	
	public static void main(String[] args)
	{
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle("JavaGotchi v1.0");
		game.frame.add(game); //adds component to game, instance of Game
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//game.frame.setLocation(null);
		game.frame.setVisible(true);
		
		//TODO update method, clear method
		
	}
	
	
} //EOF
