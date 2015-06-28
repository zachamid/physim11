package coursework;

/**Class:  	Gravitation							Date of Revision:  			November 6, 2010
 *Author:  	Zaccaria Hamid						IBO Candidate No:   		01118---
 *
 *Purpose: 	This class designs the Gravitation Applet
 *
 *Teacher:	Mrs. N. Khan						School:						British International School, Jeddah
 *
 *Language:	Java J.R.E. 1.5.0					Target Operating System:	Java Virtual Machine
 *System:	Intel 2 Duo 2.4 GHz on Mac OSX		IDE:						Eclipse 3.5.1*/

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Gravitation extends Applet implements Runnable
{
	int i =0;
	Thread t = null;	//This will enable the applet to move
	boolean threadSuspended;//This will determine when the applet runs
	public int rad, mass, mass2;
	/*These variables will make the applets unique
	 * rad - distance between the the two "planets"
	 * mass1 & mass2 - respective masses of the "planets"
	 */
	public double g;
	/*Variable used to store resultant values
	 * g - gravitational force between the two "planets"
	 */
	public static final double G =6.6742*(10^(-10));
	/*In actual fact, the value of the gravitational constant G
	 * is 6.6742 x 10 ^ -11, but because of the addition
	 * powers displayed at the bottom of applet, it is easier to
	 * multiply the constant by 10 ^ -10*/
	public Gravitation(int r, int m, int m2)
	{
		super();
		init();
		rad = r;
		mass = m;
		mass2 = m2;
		g=(G*mass*mass2)/(rad*rad);
	}
	public void init()
	//init() determines what happens when the applet is opened
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
	         setSize(new Dimension(380,480));
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
	            if ( i == 360 ) {
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
	            t.sleep(100);
	         }
	      }
	      catch (InterruptedException e) { }
	      System.out.println("run(): end");
	   }
	public void paint(Graphics g)
	//paint() determines what happens when the applet is asked to repaint itself
	{
		int factor =(mass*mass2)/(rad);
		System.out.println("paint()");
		g.setColor(Color.BLUE);
		g.fillOval(200,200,200,200);
		g.setColor(Color.GREEN);
		g.fillOval(40, 50, 50, 50);
		g.setColor(Color.RED);
		for(int n = 0;n <= 500; n++)
		{
			int m = n*n;
			g.drawOval(200-(m*factor),200-(m*factor),200+2*(m*factor),200+2*(m*factor));
		}
	}
}
