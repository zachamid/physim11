package coursework;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

/*Class:   	Applet4CircMot						Date of Revision:  			November 6, 2010
 *Author:  	Zaccaria Hamid						IBO Candidate No:   		01118---
 *
 *Purpose: 	This class designs the Circular Motion Applet
 *
 *Teacher:	Mrs. N. Khan						School:						British International School, Jeddah
 *
 *Language:	Java J.R.E. 1.5.0					Target Operating System:	Java Virtual Machine
 *System:	Intel 2 Duo 2.4 GHz on Mac OSX		IDE:						Eclipse 3.5.1*/

public class CircularMotion extends Applet implements Runnable
{
	int width,height;
	int i =0;
	Thread t = null;			//This will enable the applet to move
	boolean threadSuspended;	//This will determine when the applet runs
	public int s,m,r,c;			//These variables will make the applets unique
								//s - speed, r - radius, m - mass, c & i - counters
								//width & height - dimension variables
	
	public CircularMotion(int vlcty,int mss, int rds)
	{
		super();
		init();
		s = vlcty;
		m = (mss*100)/(rds+1);
	}
	public void init()
	//init() determines what happens when the applet is opened
	{
		System.out.println("init(): begin");
	    width = getSize().width;
	    height = getSize().height;
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
	         setSize(new Dimension(500,500));	//setting the size of the applet
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
	    	c =0;
	    	while (c<(1000*360)) {
	            System.out.println("run(): awake");
	            ++i;
	            c++;
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
	            t.sleep(100/(s+1));
	         }
	      }
	      catch (InterruptedException e) { }
	      System.out.println("run(): end");
	   }
	public void paint(Graphics g)
	//paint() determines what happens when the applet is asked to repaint itself
	{
		System.out.println("paint()");
		g.setColor(Color.RED);
		double y = 225+Mthds.yresvector(i, 175);
		double x = 225+Mthds.xresvector(i, 175);
		double xvector =x+Mthds.xresvector(i+90, s*10);
		double yvector =y+Mthds.yresvector(i+90, s*10);
		g.drawLine((int)x, (int)y, (int)(xvector),(int)(yvector));
		g.drawLine((int)xvector,(int) yvector, (int)(xvector+Mthds.xresvector(i-45, 10)), (int)(yvector+Mthds.yresvector(i-45, 10)));
		g.drawLine((int)xvector,(int) yvector, (int)(xvector+Mthds.xresvector(i+225, 10)), (int)(yvector+Mthds.yresvector(i+225, 10)));
		g.drawLine(225, 225, (int)x, (int)y);
		g.setColor(Color.BLUE);
		g.drawOval(50, 50, 350, 350);
		g.setColor(Color.ORANGE);
		g.fillOval((int)(x-(.5*m)),(int)(y-(.5*m)), m, m);
	}
}
