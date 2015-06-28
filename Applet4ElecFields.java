package coursework;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

/*Class:   	Applet4CircMot						Date of Revision:  			November 6, 2010
 *Author:  	Zaccaria Hamid						IBO Candidate No:   		01118---
 *
 *Purpose: 	This class creates and changes the values to the Electric Fields Applet
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
public class Applet4ElecFields extends javax.swing.JFrame {
	private JLabel lblTitle;
	public JButton bttnSave;
	private JLabel lblCenterCharge;
	private JButton bttnGo;
	private JLabel lbl2ndCharge;
	public JComboBox cmb2ndCharge;
	public JComboBox cmbCentreCharge;
	private JPanel pnlApplet;	//This Component will display the applet
	private String[] chrgsNm1 = {"Alpha", "Proton", "Gold nucleus"};	//The Options for the first JComboBox
	private String[] chrgsNm2 = {"Alpha","Proton","Electron"};			//The Options for the second JComboBox
	public ElectricFields ef = new ElectricFields(0,0,0,0);	//This is the object of the actual applet
	public static OpeningUI oUI;	//This Object will store the parent UI (for parsing purposes)
	private JLabel lblDist;
	private JTextField txtfldPE;
	private JLabel lblPE;
	private JTextField txtfldDist;
	public static PersistentSaveArray psA;	//This will be used to store the object of the RandomAccessFile
	public JButton bttnQuit;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Applet4ElecFields inst = new Applet4ElecFields(psA,"");
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Applet4ElecFields(PersistentSaveArray p, String s) {
		super(s);
		initGUI();
		psA = p;
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				lblTitle = new JLabel();
				getContentPane().add(lblTitle);
				lblTitle.setText("Electric Fields");
				lblTitle.setBounds(309, 12, 196, 34);
				lblTitle.setFont(new java.awt.Font("Century Gothic",0,28));
			}
			{
				pnlApplet = new JPanel();
				getContentPane().add(pnlApplet);
				pnlApplet.add(ef);	//adds the applet to the UI
				ef.init();			//Initializes the applet
				ef.start();			//Starts the applet
				ef.setPreferredSize(new java.awt.Dimension(481, 519));
				ef.addMouseListener(new MouseAdapter() {		//enables the component to read mouse clicks
					public void mouseClicked(MouseEvent evt) {
						System.out.println("ef.mouseClicked, event="+evt);
						ef.x = evt.getX();
						ef.y = evt.getY();
						txtfldPE.setText((int)ef.energy + "E-29 J");
						txtfldDist.setText((int)ef.d+ "m");
					}
				});
				pnlApplet.setBounds(12, 46, 564, 524);
			}
			{
				ComboBoxModel cmbCentreChargeModel = 
					new DefaultComboBoxModel(chrgsNm1);
				cmbCentreCharge = new JComboBox();
				getContentPane().add(cmbCentreCharge);
				cmbCentreCharge.setModel(cmbCentreChargeModel);
				cmbCentreCharge.setBounds(659, 82, 102, 22);
				cmbCentreCharge.setFont(new java.awt.Font("Century Gothic",0,12));
			}
			{
				ComboBoxModel cmb2ndChargeModel = 
					new DefaultComboBoxModel(chrgsNm2);
				cmb2ndCharge = new JComboBox();
				getContentPane().add(cmb2ndCharge);
				cmb2ndCharge.setModel(cmb2ndChargeModel);
				cmb2ndCharge.setBounds(659, 150, 102, 22);
				cmb2ndCharge.setFont(new java.awt.Font("Century Gothic",0,12));
			}
			{
				lbl2ndCharge = new JLabel();
				getContentPane().add(lbl2ndCharge);
				lbl2ndCharge.setText("Outside Charge");
				lbl2ndCharge.setBounds(595, 123, 152, 15);
				lbl2ndCharge.setFont(new java.awt.Font("Century Gothic",0,12));
			}
			{
				lblCenterCharge = new JLabel();
				getContentPane().add(lblCenterCharge);
				lblCenterCharge.setText("Center Charge");
				lblCenterCharge.setBounds(595, 55, 152, 15);
				lblCenterCharge.setFont(new java.awt.Font("Century Gothic",0,12));
			}
			{
				txtfldDist = new JTextField();
				getContentPane().add(txtfldDist);
				txtfldDist.setBounds(693, 178, 68, 22);
				txtfldDist.setEditable(false);
				txtfldDist.setFont(new java.awt.Font("Century Gothic",0,12));
			}
			{
				lblDist = new JLabel();
				getContentPane().add(lblDist);
				lblDist.setText("Distance");
				lblDist.setBounds(595, 182, 75, 15);
				lblDist.setFont(new java.awt.Font("Century Gothic",0,12));
			}
			{
				lblPE = new JLabel();
				getContentPane().add(lblPE);
				lblPE.setText("Potential Energy");
				lblPE.setBounds(595, 209, 92, 15);
				lblPE.setFont(new java.awt.Font("Century Gothic",0,10));
			}
			{
				txtfldPE = new JTextField();
				getContentPane().add(txtfldPE);
				txtfldPE.setBounds(693, 205, 68, 22);
				txtfldPE.setFont(new java.awt.Font("Century Gothic",0,12));
				txtfldPE.setEditable(false);
			}
			{
				bttnGo = new JButton();
				getContentPane().add(bttnGo);
				bttnGo.setText("Go");
				bttnGo.setBounds(627, 245, 39, 22);
				bttnGo.setFont(new java.awt.Font("Century Gothic",0,12));
				bttnGo.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent evt) 
					{
						ef.q1 = cmbCentreCharge.getSelectedIndex();
						ef.q2 = cmb2ndCharge.getSelectedIndex();
						txtfldPE.setText(ef.energy + "E-29 J");
					}
				});
			}
			{
				bttnSave = new JButton();
				getContentPane().add(bttnSave);
				bttnSave.setText("Save");
				bttnSave.setBounds(672, 245, 46, 22);
				bttnSave.setFont(new java.awt.Font("Century Gothic",0,12));
				bttnSave.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent evt) 
					{
						System.out.println("bttnSave.actionPerformed, event="+evt);
						ef.stop();	//Stops the applet
						int[] vls = {ef.x,ef.y,ef.q1,ef.q2};
						String n = (String)(JOptionPane.showInputDialog(null, "Enter a Simulation name", "Customized Dialog", JOptionPane.QUESTION_MESSAGE));
						//Asking and receiving the name of the simulation 
						String d = DateUtils.now();
						//Receiving the date
						if(n!=null)
						{
							try {
								psA.add(new SaveEntry(n,d,"Electric Fields",vls[0],vls[1],vls[2],vls[3]));	//Creates and saves the data of the simulation
								LoadScreen l = new LoadScreen(psA); //Creates a new Object of the Saved Simulations UI 
								l.setVisible(true);	//Makes the object visible
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
				bttnQuit.setBounds(724, 245, 37, 22);
				bttnQuit.setFont(new java.awt.Font("Century Gothic",0,12));
				bttnQuit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("bttnQuit.actionPerformed, event="+evt);
						ef.stop();
						oUI.ef.setVisible(false);
						oUI.setVisible(true);
					}
				});
			}
			pack();
			this.setSize(773, 604);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
