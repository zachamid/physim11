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
 *Purpose: 	This class creates and changes the values to the Gravitation Applet
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
public class Applet4Grav extends javax.swing.JFrame {
	private JPanel pnlGrav;		//This Component will display the applet
	private static Applet4Grav inst;	//This 0bject will store the UI in use 
	private JLabel lblGForce;
	private JButton bttnQuit2;
	private JTextField txtfldGForce;
	private JTextField txtfldSatellite;
	private JTextField txtfldPlanet;
	private JTextField txtfldRadius;
	public JButton bttnSave;
	public Gravitation g = new Gravitation(1,0,0);		//This is the object of the actual applet
	private JLabel lblRad;
	private JLabel lblMass2;
	public JSlider sldrMass2;
	private JLabel lblTitle;
	public JButton bttnQuit;
	public JSlider sldrMass;
	private JLabel lblMass;
	public JSlider sldrRad;
	public static OpeningUI oUI;	//This Object will store the parent UI (for parsing purposes)
	public static PersistentSaveArray psA;	//This will be used to store the object of the RandomAccessFile
	
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				inst = new Applet4Grav(psA,"");
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Applet4Grav(PersistentSaveArray p, String s) {
		super(s);
		initGUI();
		psA = p;
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				pnlGrav = new JPanel();
				getContentPane().add(pnlGrav);
				pnlGrav.setBounds(12, 76, 587, 541);
				pnlGrav.add(g);		//adds the applet to the UI
				g.setPreferredSize(new java.awt.Dimension(520, 522));
				g.init();	//Initializes the applet
				g.start();	//Starts the Applet
			}
			{
				lblRad = new JLabel();
				getContentPane().add(lblRad);
				lblRad.setText("Radius");
				lblRad.setBounds(671, 27, 77, 15);
				lblRad.setFont(new java.awt.Font("Century Gothic",0,12));
			}
			{
				txtfldRadius = new JTextField();
				getContentPane().add(txtfldRadius);
				txtfldRadius.setBounds(797, 70, 64, 22);
				txtfldRadius.setEditable(false);
				txtfldRadius.setFont(new java.awt.Font("Century Gothic",0,12));
			}
			{
				sldrRad = new JSlider(0,10);
				getContentPane().add(sldrRad);
				sldrRad.setBounds(667, 42, 188, 16);
				sldrRad.addChangeListener(new ChangeListener()
				{
					public void stateChanged(ChangeEvent evt)
					{
						JSlider slider= (JSlider)evt.getSource();
						if(!slider.getValueIsAdjusting())
						{
							g.rad = slider.getValue();
							txtfldRadius.setText(slider.getValue() + " E10 m");
							txtfldGForce.setText((-1*(g.G*g.mass*g.mass2)/(g.rad*g.rad))+"N");
						}
					}
				});
			}
			{
				lblMass = new JLabel();
				getContentPane().add(lblMass);
				lblMass.setText("Planet Mass");
				lblMass.setBounds(673, 102, 98, 15);
				lblMass.setFont(new java.awt.Font("Century Gothic",0,12));
			}
			{
				txtfldPlanet = new JTextField();
				getContentPane().add(txtfldPlanet);
				txtfldPlanet.setBounds(797, 151, 64, 22);
				txtfldPlanet.setEditable(false);
				txtfldPlanet.setFont(new java.awt.Font("Century Gothic",0,12));
			}
			{
				sldrMass = new JSlider(0,10);
				getContentPane().add(sldrMass);
				sldrMass.setBounds(667, 123, 188, 16);
				sldrMass.addChangeListener(new ChangeListener()
				{
					public void stateChanged(ChangeEvent evt)
					{
						JSlider slider= (JSlider)evt.getSource();
						if(!slider.getValueIsAdjusting())
						{
							g.mass = slider.getValue();
							txtfldPlanet.setText(slider.getValue() + " E24 kg");
							txtfldGForce.setText((-1*(g.G*g.mass*g.mass2)/(g.rad*g.rad))+"N");
						}
					}
				});
			}
			{
				lblMass2 = new JLabel();
				getContentPane().add(lblMass2);
				lblMass2.setText("Satellite Mass");
				lblMass2.setBounds(673, 192, 77, 15);
				lblMass2.setFont(new java.awt.Font("Century Gothic",0,12));
			}
			{
				txtfldSatellite = new JTextField();
				getContentPane().add(txtfldSatellite);
				txtfldSatellite.setBounds(797, 239, 64, 22);
				txtfldSatellite.setEditable(false);
				txtfldSatellite.setFont(new java.awt.Font("Century Gothic",0,12));
			}
			{
				sldrMass2 = new JSlider(0,10);
				getContentPane().add(sldrMass2);
				sldrMass2.setBounds(667, 213, 188, 16);
				sldrMass2.addChangeListener(new ChangeListener()
				{
					public void stateChanged(ChangeEvent evt)
					{
						JSlider slider= (JSlider)evt.getSource();
						if(!slider.getValueIsAdjusting())
						{
							g.mass2 = slider.getValue();
							txtfldSatellite.setText(slider.getValue()+"E8 kg");
							txtfldGForce.setText((-1*(g.G*g.mass*g.mass2)/(g.rad*g.rad))+"N");
						}
					}
				});
			}
			{
				lblTitle = new JLabel();
				getContentPane().add(lblTitle);
				lblTitle.setText("Gravitation");
				lblTitle.setBounds(251, 12, 157, 30);
				lblTitle.setFont(new java.awt.Font("Century Gothic",1,28));
			}
			{
				lblGForce = new JLabel();
				getContentPane().add(lblGForce);
				lblGForce.setText("Gravitational Force");
				lblGForce.setBounds(667, 271, 124, 15);
				lblGForce.setFont(new java.awt.Font("Century Gothic",0,12));
			}
			{
				txtfldGForce = new JTextField();
				getContentPane().add(txtfldGForce);
				txtfldGForce.setBounds(704, 295, 157, 22);
				txtfldGForce.setEditable(false);
				txtfldGForce.setFont(new java.awt.Font("Century Gothic",0,10));
			}
			{
				bttnQuit = new JButton();
				getContentPane().add(bttnQuit);
				bttnQuit.setText("Quit");
				bttnQuit.setBounds(824, 329, 37, 22);
				bttnQuit.setFont(new java.awt.Font("Century Gothic",0,12));
				bttnQuit.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						g.stop();
						oUI.g.setVisible(false);
						oUI.setVisible(true);
					}
				});
			}
			{
				bttnSave = new JButton();
				getContentPane().add(bttnSave);
				bttnSave.setText("Save");
				bttnSave.setBounds(767, 329, 51, 22);
				bttnSave.setFont(new java.awt.Font("Century Gothic",0,12));
				bttnSave.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent evt) 
					{
						System.out.println("bttnSave.actionPerformed, event="+evt);
						g.stop();
						int vls[]= {sldrRad.getValue(),sldrMass.getValue(),sldrMass2.getValue(),0};
						String n = (String)(JOptionPane.showInputDialog(null, "Enter a Simulation name", "Customized Dialog", JOptionPane.QUESTION_MESSAGE));
						//Asking and receiving the name of the simulation 
						String d = DateUtils.now();
						//Receiving the date
						if(n!=null)
						{
							try {
								psA.add(new SaveEntry(n,d,"Gravitation",vls[0],vls[1],vls[2],vls[3]));	//Saving the simulation to the database
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
				bttnQuit2 = new JButton();
				getContentPane().add(bttnQuit2);
				bttnQuit2.setText("Quit");
				bttnQuit2.setBounds(724, 329, 37, 22);
				bttnQuit2.setFont(new java.awt.Font("Century Gothic",0,12));
				bttnQuit2.setVisible(false);
				bttnQuit2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("bttnQuit2.actionPerformed, event="+evt);
						g.stop();
						inst.setVisible(false);
					}
				});
			}
			pack();
			this.setSize(970, 665);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}