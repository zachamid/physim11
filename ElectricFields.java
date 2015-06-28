package coursework;

/*Class:   	ElectricFields						Date of Revision:  			November 6, 2010
 *Author:  	Zaccaria Hamid						IBO Candidate No:   		01118---
 *
 *Purpose: 	This class designs the Electric Fields Applet
 *
 *Teacher:	Mrs. N. Khan						School:						British International School, Jeddah
 *
 *Language:	Java J.R.E. 1.5.0					Target Operating System:	Java Virtual Machine
 *System:	Intel 2 Duo 2.4 GHz on Mac OSX		IDE:						Eclipse 3.5.1*/

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ElectricFields extends Applet implements Runnable 
{	
	public int x,y,q1,q2;
	/*These variables will make the applets run uniquely
	 * x - x-coordinate, y - y-coordinate
	 * q1 and q2 - Charges for particles 1 and 2
	 */
	public double d, energy;
	/*These variables are used to store resultant 
	 * values of the simulation
	 * d - distance
	 * energy - work done
	 */
	int i =0;
	Thread t = null;			//This will enable the applet to move
	boolean threadSuspended;	//This will determine when the applet runs
	public static final double K = 8.99;
	//The above constant is used for mathematical purposes
	public static final int[] C1 = {2,1,79};
	public static final Color[] ColorC1 ={Color.BLUE,Color.GREEN,Color.YELLOW};
	public static final int[] SizeC1 = {30,20,50};
	public static final int[] C2 = {2,1,-1};
	public static final Color[] ColorC2 ={Color.BLUE,Color.GREEN,Color.RED};
	public static final int[] SizeC2 = {30,20,10};
	/*the above six constants are used as parallel arrays so that changes made
	 * are as seamless as possible
	 */
	public ElectricFields(int xc, int yc, int c1, int c2)
	{
		super();
		init();
		x=xc;
		y=yc;
		q1=c1;
		q2=c2;
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
	         setSize(new Dimension(380,480));	//setting the size of the applet
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
	public void paint (Graphics g)
	//paint() determines what happens when the applet is asked to repaint itself
	{
		System.out.println("paint()");
		if(x<250&&y<250)
		{
			d = Math.sqrt(((250-x)^2)+((250-y)^2));
		}
		else if(x<250&&y>250)
		{
			d = Math.sqrt(((250-x)^2)+((y-250)^2));
		}
		else if(x>250&&y>250)
		{
			d = Math.sqrt(((x-250)^2)+((y-250)^2));
		}
		else
		{
			d = Math.sqrt(((x-250)^2)+((250-y)^2));
		}
		energy = (C1[q1]*C2[q2]*K)/(d/100);
		if((x>(250-(SizeC1[q1]/2))&&x<(250+(SizeC1[q1]/2)))&&
				(y>(250-(SizeC1[q1]/2))&&y<(250+(SizeC1[q1]/2))))
		{
			energy = 0;
		}
		g.drawString(("Potential Energy: " + energy + "x 10^-29 J"), 0, 475);
		g.drawLine(x, y, 250, 250);
		g.setColor(ColorC1[q1]);
		g.fillOval(250-(SizeC1[q1]/2),250-(SizeC1[q1]/2),SizeC1[q1], SizeC1[q1]);
		g.setColor(ColorC2[q2]);
		g.fillOval(x-(SizeC2[q2]/2),y-(SizeC2[q2]/2),SizeC2[q2], SizeC2[q2]);
	}
}