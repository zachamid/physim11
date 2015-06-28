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
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*Class:   	Applet4CircMot						Date of Revision:  			November 6, 2010
 *Author:  	Zaccaria Hamid						IBO Candidate No:   		01118---
 *
 *Purpose: 	This class creates and changes the values to the Circular Motion Applet
 *
 *Teacher:	Mrs. N. Khan						School:						British International School, Jeddah
 *
 *Language:	Java J.R.E. 1.5.0					Target Operating System:	Java Virtual Machine
 *System:	Intel 2 Duo 2.4 GHz on Mac OSX		IDE:						Eclipse 3.5.1*/

public class Applet4CircMot extends javax.swing.JFrame {
	private JPanel pnlCircMot;				//This Component will display the applet
	public static PersistentSaveArray psA;	//This will be used to store the object of the RandomAccessFile
	private static Applet4CircMot inst = new Applet4CircMot(psA,"");;		//This 0bject will store the UI in use 
	private JLabel lblForce;
	private JTextField txtfldFrce;
	private JTextField txtfldMass;
	private JTextField txtfldRadius;
	private JTextField txtfldVelo;
	public JButton bttnSave;
	private JLabel lblRad;
	public JSlider sldrVelo;
	private JButton bttnStart;
	public JButton bttnQuit;
	private JLabel lblTitle;
	private JButton bttnStop;
	private JLabel lblVelo;
	public JSlider sldrRad;
	public JSlider sldrMass;
	private JLabel lblMass;
	private CircularMotion CircMot = new CircularMotion(0,0,0);	//This is the object of the actual applet
	public static OpeningUI oUI;			//This Object will store the parent UI (for parsing purposes)

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	public Applet4CircMot(PersistentSaveArray p, String s) {
		super(s);
		initGUI();
		psA = p;
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				pnlCircMot = new JPanel();
				getContentPane().add(pnlCircMot);
				pnlCircMot.setBounds(12, 68, 628, 534);
				pnlCircMot.add(CircMot);	//adds the applet to the UI
				CircMot.init();				//Initializes the applet
			}
			{
				lblMass = new JLabel();
				getContentPane().add(lblMass);
				lblMass.setText("Mass");
				lblMass.setBounds(652, 40, 51, 15);
				lblMass.setFont(new java.awt.Font("Century Gothic",0,12));
			}
			{
				sldrMass = new JSlider(0,100);
				getContentPane().add(sldrMass);
				sldrMass.setBounds(657, 61, 172, 16);
				sldrMass.addChangeListener(new ChangeListener()
				{
					public void stateChanged(ChangeEvent evt)
					{
						JSlider slider= (JSlider)evt.getSource();
						if(!slider.getValueIsAdjusting())
						{
							CircMot.m = slider.getValue();
							txtfldMass.setText(slider.getValue() + "kg");
							txtfldFrce.setText(((sldrMass.getValue()*(sldrVelo.getValue()^2))/sldrRad.getValue()) + "N");
						}
					}
				});
			}
			{
				lblRad = new JLabel();
				getContentPane().add(lblRad);
				lblRad.setText("Radius");
				lblRad.setBounds(652, 105, 63, 15);
				lblRad.setFont(new java.awt.Font("Century Gothic",0,12));
			}
			{
				sldrRad = new JSlider(0,15);
				getContentPane().add(sldrRad);
				sldrRad.setBounds(657, 126, 167, 16);
				sldrRad.addChangeListener(new ChangeListener()
				{
					public void stateChanged(ChangeEvent evt)
					{
						JSlider slider= (JSlider)evt.getSource();
						if(!slider.getValueIsAdjusting())
						{
							CircMot.r = slider.getValue();
							txtfldRadius.setText(slider.getValue() + "m");
							txtfldFrce.setText(((sldrMass.getValue()*(sldrVelo.getValue()^2))/sldrRad.getValue()) + "N");
						}
					}
				});
			}
			{
				sldrVelo = new JSlider(0,10);
				getContentPane().add(sldrVelo);
				sldrVelo.setBounds(657, 191, 167, 16);
				sldrVelo.addChangeListener(new ChangeListener()
				{
					public void stateChanged(ChangeEvent evt)
					{
						JSlider slider= (JSlider)evt.getSource();
						if(!slider.getValueIsAdjusting())
						{
							CircMot.s = slider.getValue();
							txtfldVelo.setText(slider.getValue() + "m/s");
							txtfldFrce.setText(((sldrMass.getValue()*(sldrVelo.getValue()^2))/sldrRad.getValue()) + "N");
						}
					}
				});
			}
			{
				lblVelo = new JLabel();
				getContentPane().add(lblVelo);
				lblVelo.setText("Velocity");
				lblVelo.setBounds(652, 170, 58, 15);
				lblVelo.setFont(new java.awt.Font("Century Gothic",0,12));
			}
			{
				bttnStart = new JButton();
				getContentPane().add(bttnStart);
				bttnStart.setText("Start");
				bttnStart.setBounds(652, 274, 45, 22);
				bttnStart.setFont(new java.awt.Font("Century Gothic",0,12));
				bttnStart.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						CircMot.start();	//Restarts the applet from its temporarily paused state
					}
				});
			}
			{
				bttnStop = new JButton();
				getContentPane().add(bttnStop);
				bttnStop.setText("Stop");
				bttnStop.setBounds(703, 274, 51, 22);
				bttnStop.setFont(new java.awt.Font("Century Gothic",0,12));
				CircMot.setBounds(12, 85, 573, 519);
				CircMot.setPreferredSize(new java.awt.Dimension(517, 518));
				bttnStop.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						CircMot.stop();		//Temporarily pauses the applet
					}
				});
			}
			{
				lblTitle = new JLabel();
				getContentPane().add(lblTitle);
				lblTitle.setText("Circular Motion");
				lblTitle.setBounds(210, 11, 225, 31);
				lblTitle.setFont(new java.awt.Font("Century Gothic",1,28));
			}
			{
				bttnQuit = new JButton();
				getContentPane().add(bttnQuit);
				bttnQuit.setText("Quit");
				bttnQuit.setBounds(760, 274, 44, 22);
				bttnQuit.setFont(new java.awt.Font("Century Gothic",0,12));
				bttnQuit.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						CircMot.stop();
						inst.setVisible(false);
					}
				});
			}
			{
				bttnSave = new JButton();
				getContentPane().add(bttnSave);
				bttnSave.setText("Save");
				bttnSave.setBounds(810, 274, 51, 22);
				bttnSave.setFont(new java.awt.Font("Century Gothic",0,12));
				bttnSave.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent evt) 
					{
						System.out.println("bttnSave.actionPerformed, event="+evt);
						CircMot.stop();
						int vls[] = {sldrMass.getValue(),sldrVelo.getValue(),sldrRad.getValue(),0};
						String n = (String)(JOptionPane.showInputDialog(null, "Enter a Simulation name", "Customized Dialog", JOptionPane.QUESTION_MESSAGE));
						//Asking and receiving the name of the simulation 
						String d = DateUtils.now();
						//Receiving the date
						if(n!=null)
						{
							try {
								psA.add(new SaveEntry(n,d,"Circular Motion",vls[0],vls[1],vls[2],vls[3]));	//Saving the simulation to the database
								LoadScreen l = new LoadScreen(psA);
								l.setVisible(true);	//Opens the list of saved simulation
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				});
			}
			{
				txtfldVelo = new JTextField();
				getContentPane().add(txtfldVelo);
				txtfldVelo.setBounds(765, 210, 59, 22);
				txtfldVelo.setFont(new java.awt.Font("Century Gothic",0,12));
				txtfldVelo.setEditable(false);
			}
			{
				txtfldRadius = new JTextField();
				getContentPane().add(txtfldRadius);
				txtfldRadius.setBounds(765, 148, 59, 22);
				txtfldRadius.setFont(new java.awt.Font("Century Gothic",0,12));
				txtfldRadius.setEditable(false);
			}
			{
				txtfldMass = new JTextField();
				getContentPane().add(txtfldMass);
				txtfldMass.setBounds(765, 83, 59, 22);
				txtfldMass.setFont(new java.awt.Font("Century Gothic",0,12));
				txtfldMass.setEditable(false);
			}
			{
				txtfldFrce = new JTextField();
				getContentPane().add(txtfldFrce);
				txtfldFrce.setBounds(765, 238, 59, 22);
				txtfldFrce.setEditable(false);
			}
			{
				lblForce = new JLabel();
				getContentPane().add(lblForce);
				lblForce.setText("Force");
				lblForce.setBounds(703, 242, 50, 15);
				lblForce.setFont(new java.awt.Font("Century Gothic",0,12));
			}
			pack();
			this.setSize(889, 653);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}