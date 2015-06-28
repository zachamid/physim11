package coursework;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

/*Class:   	Applet4CircMot						Date of Revision:  			November 6, 2010
 *Author:  	Zaccaria Hamid						IBO Candidate No:   		01118---
 *
 *Purpose: 	This class creates the Simple Harmonic Motion Applet
 *
 *Teacher:	Mrs. N. Khan						School:						British International School, Jeddah
 *
 *Language:	Java J.R.E. 1.5.0					Target Operating System:	Java Virtual Machine
 *System:	Intel 2 Duo 2.4 GHz on Mac OSX		IDE:						Eclipse 3.5.1*/

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class Applet4SHMSim extends javax.swing.JFrame {
	private JPanel pnlSHMSim;	//This Component will display the applet
	private JButton bttnStop;
	private JButton BttnStart;
	private JToolBar tlbr;
	private SHMSim applet = new SHMSim(); 	//This is the object of the actual applet
	private JButton bttnQuit;
	public static Applet4SHMSim inst;	//This 0bject will store the UI in use 
	private JLabel lblTitle;
	public static OpeningUI oUI;	//This Object will store the parent UI (for parsing purposes)

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				inst = new Applet4SHMSim("");
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Applet4SHMSim(String s) {
		super(s);
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				pnlSHMSim = new JPanel();
				getContentPane().add(pnlSHMSim);
				pnlSHMSim.setBounds(22, 56, 554, 514);
				pnlSHMSim.add(applet);	//adds the applet to the UI
				applet.setPreferredSize(new java.awt.Dimension(522, 515));
			}
			{
				tlbr = new JToolBar();
				getContentPane().add(tlbr);
				tlbr.setBounds(588, 56, 119, 43);
				{
					BttnStart = new JButton();
					tlbr.add(BttnStart);
					BttnStart.setText("Start");
					BttnStart.setFont(new java.awt.Font("Century Gothic",0,12));
					BttnStart.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent evt)
						{
							applet.init();	//Initializes the applet
							applet.start();
						}
					});
				}
				{
					bttnStop = new JButton();
					tlbr.add(bttnStop);
					bttnStop.setText("Stop");
					bttnStop.setFont(new java.awt.Font("Century Gothic",0,12));
					bttnStop.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent evt)
						{
							applet.stop();
						}
					});
				}
				{
					bttnQuit = new JButton();
					tlbr.add(bttnQuit);
					bttnQuit.setText("Quit");
					bttnQuit.setFont(new java.awt.Font("Century Gothic",0,12));
					bttnQuit.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent evt)
						{
							applet.stop();
							oUI.shms.setVisible(false);
							oUI.setVisible(true);
						}
					});
				}
			}
			{
				lblTitle = new JLabel();
				getContentPane().add(lblTitle);
				lblTitle.setText("Simple Harmonic Motion");
				lblTitle.setBounds(125, 12, 356, 32);
				lblTitle.setFont(new java.awt.Font("Century Gothic",1,28));
			}
			pack();
			this.setSize(719, 617);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
