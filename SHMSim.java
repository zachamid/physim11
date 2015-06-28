package coursework;

import java.applet.*;
import java.awt.*;

/**Class:  	OpeningUI							Date of Revision:  			November 6, 2010
 *Author:  	Zaccaria Hamid						IBO Candidate No:   		01118---
 *
 *Purpose: 	This class creates the applet for Simple Harmonic Motion
 *
 *Teacher:	Mrs. N. Khan						School:						British International School, Jeddah
 *
 *Language:	Java J.R.E. 1.5.0					Target Operating System:	Java Virtual Machine
 *System:	Intel 2 Duo 2.4 GHz on Mac OSX		IDE:						Eclipse 3.5.1*/

public class SHMSim extends Applet implements Runnable
{
	int i =0;					//This variable counts the number of different "stills" in one round
	Thread t = null;			//This object enables movement in the applet
	boolean threadSuspended;	//This boolean variable indicates whether or not the applet has stopped	
	
	public SHMSim()
	{
		super();
		init();
	}
	
	public void init()
	{
		System.out.println("init(): begin");
	    System.out.println("init(): end");
	    setSize(new Dimension(500,500));
	}
	public void destroy()
	//destroy() determines what happens when the applet is closed
	{
		System.out.println("destroy()");
	}
	public void start()
	//start() determines what happens when the applet is started
	{
		System.out.println("start().begin");
		if (t==null)
		{
			System.out.println("start(): creating thread");
	         t = new Thread( this );
	         System.out.println("start(): starting thread");
	         threadSuspended = false;
	         t.start();
		}
		else
		{
			if(threadSuspended)
			{
				threadSuspended = false;
	            System.out.println("start(): notifying thread");
	            synchronized( this )
	            {
	            	notify();
	            }
			}
		}
		System.out.println("start(): end");
	}
	public void stop() 
	//stop() determines what happens when the applet is paused
	{
		System.out.println("stop(): begin");
	    threadSuspended = true;
	}
	public void run()
	//run() determines what happens when the applet is run
	{
		System.out.println("run(): begin");
	    try {
	    	while (true) {
	            System.out.println("run(): awake");
	            ++i;
	            if ( i == 720 ) {
	               i = 0;
	            }
	            if ( threadSuspended ) {
	               synchronized( this ) {
	                  while ( threadSuspended ) {
	                     System.out.println("run(): waiting");
	                     wait();
	                  }
	               }
	            }
	            System.out.println("run(): requesting repaint");
	            repaint();
	            System.out.println("run(): sleeping");
	            t.sleep( 15 );
	         }
	      }
	      catch (InterruptedException e) { }
	      System.out.println("run(): end");
	}
	public void paint(Graphics g)
	//paint() determines what happens when the applet is asked to repaint itself
	{
		g.drawLine(20, 20, 20, 80);
		g.drawLine(20, 80, 450, 80);
		g.drawLine(35, 150, 35,370);
		g.drawLine(35, 370, 395, 370);
		g.drawString("Energy (J)", 30, 145);
		g.drawString("P.E.", 395, 145);
		g.drawString("K.E.", 395, 370);
		
		g.setColor(Color.BLUE);
		for(int c = 0; c<=360;c++)
		{
			g.drawLine(35+c,(int)(150+220*(Math.sin(Math.toRadians(0.5*c)))), 36+c,(int)(150+220*(Math.sin(Math.toRadians(0.5*(c+1))))));
			g.drawLine(35+c,(int)(370-220*(Math.sin(Math.toRadians(0.5*c)))), 36+c,(int)(370-220*(Math.sin(Math.toRadians(0.5*(c+1))))));
		}
		g.setColor(Color.GREEN);
		if(i<361)
		{
			g.fillOval(20+i, 50, 30, 30);
			g.fillOval(25+i, (int)(360-220*(Math.sin(Math.toRadians(0.5*i)))), 20, 20);
			g.fillOval(25+i, (int)(140+220*(Math.sin(Math.toRadians(0.5*i)))), 20, 20);
			g.setColor(Color.BLUE);
			g.drawLine(20, 60, 20+i, 60);
		}
		else
		{
			g.setColor(Color.GREEN);
			g.fillOval(740-i, 50, 30, 30);
			g.fillOval(745-i, (int)(360-220*(Math.sin(Math.toRadians(0.5*(-i))))), 20, 20);
			g.fillOval(745-i, (int)(140+220*(Math.sin(Math.toRadians(0.5*(-i))))), 20, 20);
			g.setColor(Color.BLUE);
			g.drawLine(20, 60, 740-i, 60);
		}
	}
}
