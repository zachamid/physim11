package coursework;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**Class:  	OpeningUI							Date of Revision:  			November 6, 2010
 *Author:  	Zaccaria Hamid						IBO Candidate No:   		01118---
 *
 *Purpose: 	This class creates the UI that is initially opened
 *
 *Teacher:	Mrs. N. Khan						School:						British International School, Jeddah
 *
 *Language:	Java J.R.E. 1.5.0					Target Operating System:	Java Virtual Machine
 *System:	Intel 2 Duo 2.4 GHz on Mac OSX		IDE:						Eclipse 3.5.1*/

public class OpeningUI extends javax.swing.JFrame {
	private JButton bttnQuit;
	private JLabel lblNm;
	private JLabel lblTitle;
	public Applet4SHMSim shms;
	public Applet4CircMot cm;
	public Applet4StndgWvs sw;
	public Applet4ElecFields ef;
	public Applet4Grav g;
	public Applet4MagFields mf;
	public static OpeningUI inst;
	private JButton bttnGrav;
	private JButton bttnMagneticFields;
	private JButton bttnSavedSims;
	private JButton bttnStdWvs;
	private JButton bttnElecFields;
	private JButton bttnCircMot;
	private JButton bttnSHMS;
	/**
	 * The above objects store the components and other UI's which it is
	 * connected to 
	 */
	PersistentSaveArray psA;
	/**
	* The above objects will enable saving, sorting and displaying
	* throughout the program
	*/
	public static void main(String[] args) 
	{
		inst= new OpeningUI();	
		inst.setVisible(true);
	}
		
	
	
	public OpeningUI() {
		super();
		initGUI();

		try {
			psA = new PersistentSaveArray("psp11");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				lblTitle = new JLabel();
				getContentPane().add(lblTitle);
				lblTitle.setText("Physics Simulation Package 2011");
				lblTitle.setBounds(12, 12, 398, 35);
				lblTitle.setFont(new java.awt.Font("Century Gothic",3,24));
			}
			{
				lblNm = new JLabel();
				getContentPane().add(lblNm);
				lblNm.setText("Zaccaria Hamid");
				lblNm.setBounds(301, 348, 109, 15);
				lblNm.setFont(new java.awt.Font("Century Gothic",2,12));
			}
			{
				bttnQuit = new JButton();
				getContentPane().add(bttnQuit);
				bttnQuit.setText("Exit");
				bttnQuit.setBounds(18, 341, 35, 22);
				bttnQuit.setFont(new java.awt.Font("Century Gothic",0,12));
				bttnQuit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("bttnQuit.actionPerformed, event="+evt);
						System.exit(0);
					}
				});
			}
			{
				bttnSHMS = new JButton();
				getContentPane().add(bttnSHMS);
				bttnSHMS.setText("Simple Harmonic Motion");
				bttnSHMS.setBounds(128, 59, 173, 22);
				bttnSHMS.setFont(new java.awt.Font("Century Gothic",0,12));
				bttnSHMS.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("bttnSHMS.actionPerformed, event="+evt);
						shms = new Applet4SHMSim("Simple Harmonic Motion - IB PhySim '11");
						shms.setVisible(true);
					}
				});
				/**
				 * This button will open the applet for Simple Harmonic Motion
				 */
			}
			{
				bttnCircMot = new JButton();
				getContentPane().add(bttnCircMot);
				bttnCircMot.setText("Circular Motion");
				bttnCircMot.setBounds(128, 161, 173, 22);
				bttnCircMot.setFont(new java.awt.Font("Century Gothic",0,12));
				bttnCircMot.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("bttnCircMot.actionPerformed, event="+evt);
						cm = new Applet4CircMot(psA, "Circular Motion - IB PhySim '11");
						cm.setVisible(true);
					}
				});
				/**
				 * This button will open the applet for Circular Motion
				 */
			}
			{
				bttnGrav = new JButton();
				getContentPane().add(bttnGrav);
				bttnGrav.setText("Gravitation");
				bttnGrav.setBounds(128, 93, 173, 22);
				bttnGrav.setFont(new java.awt.Font("Century Gothic",0,12));
				bttnGrav.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("bttnGrav.actionPerformed, event="+evt);
						g = new Applet4Grav(psA, "Gravitation - IB PhySim '11");
						g.setVisible(true);
					}
				});
				/**
				 * This button will open the applet for Gravitation
				 */
			}
			{
				bttnElecFields = new JButton();
				getContentPane().add(bttnElecFields);
				bttnElecFields.setText("Electric Fields");
				bttnElecFields.setBounds(128, 127, 173, 22);
				bttnElecFields.setFont(new java.awt.Font("Century Gothic",0,12));
				bttnElecFields.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("bttnElecFields.actionPerformed, event="+evt);
						ef = new Applet4ElecFields(psA, "Electric Fields - IB PhySim '11");
						ef.setVisible(true);
					}
				});
				/**
				 * This button will open the applet for Electrical Fields
				 */
			}
			{
				bttnStdWvs = new JButton();
				getContentPane().add(bttnStdWvs);
				bttnStdWvs.setText("Standing Waves");
				bttnStdWvs.setBounds(127, 195, 174, 22);
				bttnStdWvs.setFont(new java.awt.Font("Century Gothic",0,12));
				bttnStdWvs.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("bttnStdWvs.actionPerformed, event="+evt);
						sw = new Applet4StndgWvs(psA, "Standing Waves - IB PhySim '11");
						sw.setVisible(true);
					}
				});
				/**
				 * This button will open the applet for Standing Waves
				 */
			}
			{
				bttnMagneticFields = new JButton();
				getContentPane().add(bttnMagneticFields);
				bttnMagneticFields.setText("Magnetic Fields");
				bttnMagneticFields.setBounds(127, 230, 174, 22);
				bttnMagneticFields.setFont(new java.awt.Font("Century Gothic",0,12));
				bttnMagneticFields.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) 
					{
						System.out.println("bttnMagneticFields.actionPerformed, event="+evt);
						mf = new Applet4MagFields(psA, "Lenz's Law - IB PhySim '11");
						mf.setVisible(true);
					}
				});
				/**
				 * This button will open the applet for Magnetic Fields
				 */
			}
			{
				bttnSavedSims = new JButton();
				getContentPane().add(bttnSavedSims);
				bttnSavedSims.setText("Saved Simulations");
				bttnSavedSims.setBounds(127, 264, 174, 22);
				bttnSavedSims.setFont(new java.awt.Font("Century Gothic",0,12));
				bttnSavedSims.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("bttnSavedSims.actionPerformed, event="+evt);
						try {
							LoadScreen ls = new LoadScreen(psA);
							ls.setVisible(true);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				/**
				 * This button will open the Load Screen
				 */
			}
			pack();
			this.setSize(422, 397);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}