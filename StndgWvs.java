package coursework;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

/*Class:   	Applet4CircMot						Date of Revision:  			November 6, 2010
 *Author:  	Zaccaria Hamid						IBO Candidate No:   		01118---
 *
 *Purpose: 	This class designs the Standing Waves Applet
 *
 *Teacher:	Mrs. N. Khan						School:						British International School, Jeddah
 *
 *Language:	Java J.R.E. 1.5.0					Target Operating System:	Java Virtual Machine
 *System:	Intel 2 Duo 2.4 GHz on Mac OSX		IDE:						Eclipse 3.5.1*/

public class StndgWvs extends Applet implements Runnable
{
	int i =0;					//This variable counts the number of different "stills" in one round
	Thread t = null;			//This object enables movement in the applet
	boolean threadSuspended;	//This boolean variable indicates whether or not the applet has stopped
	public int f,l;				
	public double a;			//These variables will make the applets unique
								//l - length, f - frequency, a - amplitude
	
	public StndgWvs(int freq, double amp, int lngth)
	{
		super();
		init();
		f=freq;
		a=amp;
		l=lngth;
	}
	
	public void init()
	//init() determines what happens when the applet is opened
	{
		System.out.println("init(): begin");
	    System.out.println("init(): end");
	    setSize(new Dimension(900,500));
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
	            t.sleep(10);
	         }
	      }
	      catch (InterruptedException e) { }
	      System.out.println("run(): end");
	}
	public void paint(Graphics g)
	//paint() determines what happens when the applet is asked to repaint itself
	{
		for(int c = 0; c<=360+l;c++)
		{
			g.setColor(Color.RED);
			double fctr = Math.cos(Math.toRadians(i));
			g.drawLine(35+c,(int)(250+fctr*a*10*(Math.sin(Math.toRadians(f*c)))), 36+c,(int)(250+fctr*a*10*(Math.sin(Math.toRadians(f*(c+1))))));
			g.drawLine(35+c,(int)(250-fctr*a*10*(Math.sin(Math.toRadians(f*c)))), 36+c,(int)(250-fctr*a*10*(Math.sin(Math.toRadians(f*(c+1))))));
			g.setColor(Color.GREEN);
			int period = 360/(2*f);
			for(int y = 0; y<=360+l;y=y+(period))
			{
				g.fillOval(30+y, 245,10, 10);
			}
			g.setColor(Color.BLUE);
			int num=0;
			for(int y = period/2; y<=360+l;y=y+(period))
			{
				g.fillOval(30+y, (int)(247.5+fctr*a*10*(Math.sin(Math.toRadians(f*c)))),5, 5);
				g.fillOval(30+y, (int)(247.5-fctr*a*10*(Math.sin(Math.toRadians(f*c)))),5, 5);
				num++;
			}
			g.drawString(("Harmonic No:" + num),0,20);
		}
	}
}
