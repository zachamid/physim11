package coursework;

/**Class:  	MagneticFields						Date of Revision:  			November 6, 2010
 *Author:  	Zaccaria Hamid						IBO Candidate No:   		01118---
 *
 *Purpose: 	This class designs the Lenz' Applet
 *
 *Teacher:	Mrs. N. Khan						School:						British International School, Jeddah
 *
 *Language:	Java J.R.E. 1.5.0					Target Operating System:	Java Virtual Machine
 *System:	Intel 2 Duo 2.4 GHz on Mac OSX		IDE:						Eclipse 3.5.1*/

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class LenzLaw extends Applet implements Runnable
{
	public int l, a, f, v;
	/**These variables will make the applets unique
	 * l - length of conductor
	 * f - flux
	 * a - angle
	 * v - velocity
	 */
	public int  x, y, i;
	/**These variables will determine how the applet will run
	 */
	public boolean threadSuspended;
	//This will determine when the applet runs
	Thread t;
	//This will enable the applet to move
	public LenzLaw(int len, int ang, int flux, int vel)
	{
		super();
		init();
		l = len;
		a = ang;
		f = flux;
		v = vel;
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
	public void paint (Graphics g)
	//paint() determines what happens when the applet is asked to repaint itself
	{
		x = (int)(Mthds.xresvector(a, f));
		y = (int)(Mthds.yresvector(a, f));
		g.setColor(Color.BLUE);
		g.fillRect(250-(l/2), 245, l, 10);
		g.setColor(Color.RED);
		g.drawLine(250-x, 250-y, 250+x, 250+y);
		g.drawLine(350-x, 350-y, 350+x, 350+y);
		g.drawLine(150-x, 150-y, 150+x, 150+y);
		g.fillOval(245-x, 245-y, 10, 10);
	}
}