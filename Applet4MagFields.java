package coursework;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


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
@SuppressWarnings("unused")
public class Applet4MagFields extends javax.swing.JFrame {
	private JPanel pnlApplet;	//This Component will display the applet
	private JLabel lblMagFields;
	private JLabel lblLen;
	public JSlider sldrAng;
	public JSlider sldrVelo;
	private JLabel lblEMF;
	private JTextField txtfldEMF;
	private JTextField txtfldVelo;
	private JTextField txtfldFlux;
	private JTextField txtfldLen;
	private JTextField txtfldAng;
	private JLabel lblVelo;
	private JLabel lblAng;
	public JSlider sldrflx;
	private JLabel lblMgFlx;
	public JSlider sldrLen;
	private LenzLaw mf = new LenzLaw(0,0,0,0);	//This is the object of the actual applet
	public static OpeningUI oUI;	//This Object will store the parent UI (for parsing purposes)
	public JButton bttnQuit;		
	public JButton bttnSave;
	public static PersistentSaveArray psA;//This will be used to store the object of the RandomAccessFile

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Applet4MagFields inst = new Applet4MagFields(psA,"");
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public Applet4MagFields(PersistentSaveArray p, String s) {
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
				pnlApplet.setBounds(12, 66, 591, 542);
				pnlApplet.add(mf);	//adds the applet to the UI
				mf.setPreferredSize(new java.awt.Dimension(581, 519));
				mf.init();	//Initializes the applet
				mf.start();
			}
			{
				lblMagFields = new JLabel();
				getContentPane().add(lblMagFields);
				lblMagFields.setText("Magnetic Fields");
				lblMagFields.setBounds(311, 12, 225, 31);
				lblMagFields.setFont(new java.awt.Font("Century Gothic",0,28));
			}
			{
				lblLen = new JLabel();
				getContentPane().add(lblLen);
				lblLen.setText("Length of Conductor");
				lblLen.setBounds(633, 66, 158, 15);
				lblLen.setFont(new java.awt.Font("Century Gothic",0,12));
			}
			{
				txtfldLen = new JTextField();
				getContentPane().add(txtfldLen);
				txtfldLen.setBounds(760, 109, 67, 22);
				txtfldLen.setEditable(false);
				txtfldLen.setFont(new java.awt.Font("Century Gothic",0,12));
			}
			{
				sldrLen = new JSlider(100,250);
				getContentPane().add(sldrLen);
				sldrLen.setBounds(627, 87, 200, 16);
				sldrLen.addChangeListener(new ChangeListener()
				{
					public void stateChanged(ChangeEvent evt) 
					{
						JSlider slider= (JSlider)evt.getSource();
						if(!slider.getValueIsAdjusting())
						{
							mf.l = slider.getValue();
							txtfldLen.setText(slider.getValue() + "m");
							txtfldEMF.setText((int) (mf.f*mf.v*mf.l*(Math.abs(Math.sin(Math.toRadians(mf.a)))))/1000 + "mV");
						}
					}
					
				});
			}
			{
				lblMgFlx = new JLabel();
				getContentPane().add(lblMgFlx);
				lblMgFlx.setText("Magnetic Flux Density");
				lblMgFlx.setBounds(633, 143, 172, 15);
				lblMgFlx.setFont(new java.awt.Font("Century Gothic",0,12));
			}
			{
				txtfldFlux = new JTextField();
				getContentPane().add(txtfldFlux);
				txtfldFlux.setBounds(760, 186, 67, 22);
				txtfldFlux.setEditable(false);
				txtfldFlux.setFont(new java.awt.Font("Century Gothic",0,12));
			}
			{
				sldrflx = new JSlider(0, 250);
				getContentPane().add(sldrflx);
				sldrflx.setBounds(627, 164, 200, 16);
				sldrflx.addChangeListener(new ChangeListener()
				{
					public void stateChanged(ChangeEvent evt) 
					{
						JSlider slider= (JSlider)evt.getSource();
						if(!slider.getValueIsAdjusting())
						{
							mf.f = slider.getValue();
							txtfldFlux.setText(slider.getValue() + "mT");
							txtfldEMF.setText((int) (mf.f*mf.v*mf.l*(Math.abs(Math.sin(Math.toRadians(mf.a)))))/1000 + "mV");
						}
					}
					
				});
			}
			{
				lblAng = new JLabel();
				getContentPane().add(lblAng);
				lblAng.setText("Angle");
				lblAng.setBounds(633, 221, 72, 16);
				lblAng.setFont(new java.awt.Font("Century Gothic",0,12));
			}
			{
				txtfldAng = new JTextField();
				getContentPane().add(txtfldAng);
				txtfldAng.setBounds(760, 265, 67, 22);
				txtfldAng.setEditable(false);
				txtfldAng.setFont(new java.awt.Font("Century Gothic",0,12));
			}
			{
				sldrAng = new JSlider(0,360);
				getContentPane().add(sldrAng);
				sldrAng.setBounds(627, 243, 200, 16);
				sldrAng.addChangeListener(new ChangeListener()
				{
					public void stateChanged(ChangeEvent evt) 
					{
						JSlider slider= (JSlider)evt.getSource();
						if(!slider.getValueIsAdjusting())
						{
							mf.a = slider.getValue();
							txtfldAng.setText(slider.getValue() + "ú");
							txtfldEMF.setText((int) (mf.f*mf.v*mf.l*(Math.abs(Math.sin(Math.toRadians(mf.a)))))/1000 + "mV");
						}
					}
				});
			}
			{
				lblVelo = new JLabel();
				getContentPane().add(lblVelo);
				lblVelo.setText("Velocity");
				lblVelo.setBounds(633, 299, 79, 15);
				lblVelo.setFont(new java.awt.Font("Century Gothic",0,12));
			}
			{
				txtfldVelo = new JTextField();
				getContentPane().add(txtfldVelo);
				txtfldVelo.setBounds(760, 342, 67, 22);
				txtfldVelo.setEditable(false);
				txtfldVelo.setFont(new java.awt.Font("Century Gothic",0,12));
			}
			{
				sldrVelo = new JSlider(0,5);
				getContentPane().add(sldrVelo);
				sldrVelo.setBounds(627, 320, 200, 16);
				sldrVelo.addChangeListener(new ChangeListener()
				{
					public void stateChanged(ChangeEvent evt) 
					{
						JSlider slider= (JSlider)evt.getSource();
						if(!slider.getValueIsAdjusting())
						{
							mf.v = slider.getValue();
							txtfldVelo.setText(slider.getValue() + "m/s");
							txtfldEMF.setText((int) (mf.f*mf.v*mf.l*(Math.abs(Math.sin(Math.toRadians(mf.a)))))/1000 + "mV");
						}
					}
				});
			}
			{
				lblEMF = new JLabel();
				getContentPane().add(lblEMF);
				lblEMF.setText("E.M.F. / ÆV");
				lblEMF.setBounds(628, 374, 126, 15);
				lblEMF.setFont(new java.awt.Font("Century Gothic",0,12));
			}
			{
				txtfldEMF = new JTextField();
				getContentPane().add(txtfldEMF);
				txtfldEMF.setBounds(760, 370, 67, 22);
				txtfldEMF.setEditable(false);
				txtfldEMF.setFont(new java.awt.Font("Century Gothic",0,10));
			}
			{
				bttnSave = new JButton();
				getContentPane().add(bttnSave);
				bttnSave.setText("Save");
				bttnSave.setBounds(683, 401, 58, 22);
				bttnSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("bttnSave.actionPerformed, event="+evt);
						int vls[] = {sldrLen.getValue(),
								sldrflx.getValue(),
								sldrAng.getValue(),
								sldrVelo.getValue()};
						String n = (String)(JOptionPane.showInputDialog(null, "Enter a Simulation name", "Customized Dialog", JOptionPane.QUESTION_MESSAGE));
						//Asking and receiving the name of the simulation 
						String d = DateUtils.now();
						//Receiving the date
						if(n!=null)
						{
							try {
								mf.stop();
								psA.add(new SaveEntry(n,d,"Magnetic Fields",vls[0],vls[1],vls[2],vls[3])); 	//Saving the simulation to the database
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
				bttnQuit = new JButton();
				final Applet4MagFields ths = this;
				getContentPane().add(bttnQuit);
				bttnQuit.setText("Quit");
				bttnQuit.setBounds(747, 401, 58, 22);
				bttnQuit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("bttnQuit.actionPerformed, event="+evt);
						oUI.setVisible(true);
						mf.stop();
						mf.destroy();
						ths.setVisible(false);
					}
				});
			}
			pack();
			this.setSize(839, 642);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
