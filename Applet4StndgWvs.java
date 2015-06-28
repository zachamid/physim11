package coursework;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*Class:   	Applet4CircMot						Date of Revision:  			November 6, 2010
 *Author:  	Zaccaria Hamid						IBO Candidate No:   		01118---
 *
 *Purpose: 	This class creates and changes the values to the Standing Waves Applet
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
public class Applet4StndgWvs extends javax.swing.JFrame {
	private JPanel pnlApplet;	//This Component will display the applet
	private static Applet4StndgWvs inst;	//This will store the current UI
	public JButton bttnQuit;
	public JButton bttnSave;
	private JLabel lblAmp;
	private JLabel lblLngth;
	private JButton bttnStart;
	private JLabel lblTitle;
	private JButton bttnStop;
	public JSlider sldrLngth;
	public JSlider sldrAmp;
	public JSlider sldrFreq;
	private JLabel lblFreq;
	private StndgWvs sw = new StndgWvs(0,0,0);	//This will store the applet
	public static PersistentSaveArray psA;		//This will store the Object that will work with RandomAccessFile
	public static OpeningUI oUI;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				inst = new Applet4StndgWvs(psA, "");
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Applet4StndgWvs(PersistentSaveArray p, String s) {
		super(s);
		initGUI();
		psA = p;
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				pnlApplet = new JPanel();
				getContentPane().add(pnlApplet);
				pnlApplet.setBounds(12, 82, 910, 596);
				pnlApplet.add(sw);	//The applet is added to the Component
				sw.setPreferredSize(new java.awt.Dimension(892, 588));
				sw.init();	//The applet is initialized
				sw.start();
			}
			{
				lblFreq = new JLabel();
				getContentPane().add(lblFreq);
				lblFreq.setText("Frequency");
				lblFreq.setBounds(955, 38, 169, 15);
				lblFreq.setFont(new java.awt.Font("Century Gothic",0,12));
			}
			{
				sldrFreq = new JSlider(0,5);
				getContentPane().add(sldrFreq);
				sldrFreq.setBounds(955, 53, 169, 16);
				sldrFreq.addChangeListener(new ChangeListener()
				{
					public void stateChanged(ChangeEvent evt)
					{
						JSlider slider= (JSlider)evt.getSource();
						if(!slider.getValueIsAdjusting())
						{
							sw.f = slider.getValue();
						}
					}
				});
			}
			{
				lblAmp = new JLabel();
				getContentPane().add(lblAmp);
				lblAmp.setText("Amplitude");
				lblAmp.setBounds(955, 94, 169, 15);
				lblAmp.setFont(new java.awt.Font("Century Gothic",0,12));
			}
			{
				sldrAmp = new JSlider(0,10);
				getContentPane().add(sldrAmp);
				sldrAmp.setBounds(955, 109, 169, 16);
				sldrAmp.addChangeListener(new ChangeListener()
				{
					public void stateChanged(ChangeEvent evt)
					{
						JSlider slider= (JSlider)evt.getSource();
						if(!slider.getValueIsAdjusting())
						{
							sw.a = slider.getValue();
						}
					}
				});
			}
			{
				lblLngth = new JLabel();
				getContentPane().add(lblLngth);
				lblLngth.setText("Length");
				lblLngth.setBounds(955, 148, 169, 15);
				lblLngth.setFont(new java.awt.Font("Century Gothic",0,12));
			}
			{
				sldrLngth = new JSlider(0,360);
				getContentPane().add(sldrLngth);
				sldrLngth.setBounds(955, 163, 169, 16);
				sldrLngth.addChangeListener(new ChangeListener()
				{
					public void stateChanged(ChangeEvent evt)
					{
						JSlider slider= (JSlider)evt.getSource();
						if(!slider.getValueIsAdjusting())
						{
							sw.l = slider.getValue();
						}
					}
				});
			}
			{
				bttnStart = new JButton();
				getContentPane().add(bttnStart);
				bttnStart.setText("Start");
				bttnStart.setBounds(955, 191, 40, 22);
				bttnStart.setFont(new java.awt.Font("Century Gothic",0,12));
				bttnStart.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						sw.start();
					}
				});
			}
			{
				bttnStop = new JButton();
				getContentPane().add(bttnStop);
				bttnStop.setText("Stop");
				bttnStop.setBounds(1001, 191, 50, 22);
				bttnStop.setFont(new java.awt.Font("Century Gothic",0,12));
				bttnStop.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						sw.stop();
					}
				});
			}
			{
				lblTitle = new JLabel();
				getContentPane().add(lblTitle);
				lblTitle.setText("Standing Waves");
				lblTitle.setBounds(350, 12, 227, 32);
				lblTitle.setFont(new java.awt.Font("Century Gothic",1,28));
			}
			{
				bttnSave = new JButton();
				getContentPane().add(bttnSave);
				bttnSave.setText("Save");
				bttnSave.setBounds(955, 219, 60, 22);
				bttnSave.setFont(new java.awt.Font("Century Gothic",0,12));
				bttnSave.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent evt) 
					{
						System.out.println("bttnSave.actionPerformed, event="+evt);
						sw.stop();
						int[] vls = {sldrFreq.getValue(), sldrAmp.getValue(),sldrLngth.getValue(),0};
						String n = (String)(JOptionPane.showInputDialog(null, "Enter a Simulation name", "Customized Dialog", JOptionPane.QUESTION_MESSAGE));
						//Asking and receiving the name of the simulation 
						String d = DateUtils.now();
						//Receiving the date
						if(n!=null)
						{
							try {
								sw.stop();
								psA.add(new SaveEntry(n,d,"Standing Waves",vls[0],vls[1],vls[2],vls[3]));
								//Saving the record in the RandomAccessFile 
								LoadScreen l = new LoadScreen(psA);
								l.setVisible(true);
								//Opens the list of saved simulation
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				});
			}
			{
				bttnQuit = new JButton();
				getContentPane().add(bttnQuit);
				bttnQuit.setText("Quit");
				bttnQuit.setBounds(1021, 219, 51, 22);
				bttnQuit.setFont(new java.awt.Font("Century Gothic",0,12));
				bttnQuit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("bttnQuit.actionPerformed, event="+evt);
						sw.stop();
						oUI = new OpeningUI();
						oUI.setVisible(true);
					}
				});
			}
			pack();
			this.setSize(1157, 658);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
