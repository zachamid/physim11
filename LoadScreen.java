package coursework;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.SwingUtilities;


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
/**Class:   	LoadScreen							Date of Revision:  			November 6, 2010
 *Author:  	Zaccaria Hamid						IBO Candidate No:   		01118---
 *
 *Purpose: 	This class creates the UI which will display the records and its respective methods
 *
 *Teacher:	Mrs. N. Khan						School:						British International School, Jeddah
 *
 *Language:	Java J.R.E. 1.5.0					Target Operating System:	Java Virtual Machine
 *System:	Intel 2 Duo 2.4 GHz on Mac OSX		IDE:						Eclipse 3.5.1*/


public class LoadScreen extends javax.swing.JFrame {
	private JScrollPane scrlPaneTable;
	private JButton bttnDeleteAll;
	private ButtonGroup bttnSortCrtrn;
	private JLabel lblSort;
	private JComboBox cmboBxSearch;
	private JButton bttnShowAll;
	private JTextField txtfldSearch;
	private JButton btteDelete;
	private JButton bttnLoad;
	private JTable tbleData;
	private JLabel lblFilter;
	private JButton bttnSearch;
	/**the above objects create the components that will
	 *be visible in the UI
	 */
	private static PersistentSaveArray psA;
	String[] colHead = {"#", "Name", "Type", "Date"};
	private JButton bttnOK;
	private JRadioButton bttnDescending;
	private JRadioButton bttnAsc;
	private ButtonGroup bttnAscDesc;
	private JRadioButton SortDate;
	private JRadioButton SortName;
	/**The above objects are used to save, search and sort and display
	 * in the UI 
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				LoadScreen inst;
				try {
					inst = new LoadScreen(psA);
					inst.setLocationRelativeTo(null);
					inst.setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
	}

	
	public LoadScreen(PersistentSaveArray p) throws IOException {
		super();
		initGUI();
		psA = p;
		SortSearchNDisplay ssd = new SortSearchNDisplay(psA);
		String [][] tble = ssd.turnToTable();
		tbleData.setModel(new DefaultTableModel(tble, colHead));
		tbleData.getTableHeader().setFont(new java.awt.Font("Century Gothic",0,12));
		/**When the UI opens, the table is automatically is updated
		 */
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				bttnSortCrtrn = new ButtonGroup();
			}
			{
				scrlPaneTable = new JScrollPane();
				getContentPane().add(scrlPaneTable);
				scrlPaneTable.setBounds(12, 87, 488, 253);
				{
					TableModel tbleDataModel = 
						new DefaultTableModel(
								new String[][] { { "One", "Two" }, { "Three", "Four" } },
								new String[] { "Column 1", "Column 2" });
					tbleData = new JTable();
					scrlPaneTable.setViewportView(tbleData);
					tbleData.setModel(tbleDataModel);
				}
				/**This Pane enables the table to be of unlimited size
				 * The table itself is assigned the default model
				 */
			}
			{
				bttnLoad = new JButton();
				getContentPane().add(bttnLoad);
				bttnLoad.setText("Load");
				bttnLoad.setBounds(521, 87, 99, 22);
				bttnLoad.setFont(new java.awt.Font("Century Gothic",0,12));
				bttnLoad.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("bttnLoad.actionPerformed, event="+evt);
						DisplaySaveEntry dse = new DisplaySaveEntry();
						dse.recNumber = Integer.parseInt(tbleData.getValueAt(tbleData.getSelectedRow(), 0).toString());
						dse.name = tbleData.getValueAt(tbleData.getSelectedRow(), 1).toString();
						dse.type = tbleData.getValueAt(tbleData.getSelectedRow(), 2).toString();
						dse.date = tbleData.getValueAt(tbleData.getSelectedRow(), 3).toString();
						try {
								if(dse.type.equals("Circular Motion"))
								{
									SaveEntry se = psA.get(dse.recNumber-1);
									Applet4CircMot a4cm = new Applet4CircMot(psA , "Circular Motion (" + dse.name + ") - PhySim '11");
									a4cm.sldrVelo.setValue(se.val2);
									a4cm.sldrVelo.setEnabled(false);
									a4cm.sldrMass.setValue(se.val1);
									a4cm.sldrMass.setEnabled(false);
									a4cm.sldrRad.setValue(se.val3);
									a4cm.sldrRad.setEnabled(false);
									a4cm.bttnQuit.setVisible(false);
									a4cm.bttnSave.setVisible(false);
									a4cm.setVisible(true);
								}
								else if(dse.type.equals("Gravitation"))
								{
									SaveEntry se = psA.get(dse.recNumber-1);
									Applet4Grav a4g = new Applet4Grav(psA,"Gravitation (" + dse.name + ") - PhySim '11");
									a4g.sldrRad.setValue(se.val1);
									a4g.sldrRad.setEnabled(false);
									a4g.sldrMass.setValue(se.val2);
									a4g.sldrMass.setEnabled(false);
									a4g.sldrMass2.setValue(se.val3);
									a4g.sldrMass2.setEnabled(false);
									a4g.bttnQuit.setVisible(false);
									a4g.bttnSave.setVisible(false);
									a4g.setVisible(true);
								}
								else if(dse.type.equals("Electric Fields"))
								{
									SaveEntry se = psA.get(dse.recNumber-1);
									Applet4ElecFields a4ef = new Applet4ElecFields(psA, "Electric Fields (" + dse.name + ") - PhySim '11");
									a4ef.ef.x = se.val1;
									a4ef.ef.y = se.val2;
									a4ef.ef.q1 = se.val3;
									a4ef.ef.q2 = se.val4;
									a4ef.cmbCentreCharge.setSelectedIndex(se.val3);
									a4ef.cmb2ndCharge.setSelectedIndex(se.val4);
									a4ef.bttnQuit.setVisible(false);
									a4ef.bttnSave.setVisible(false);
									a4ef.setVisible(true);
								}
								else if(dse.type.equals("Standing Waves"))
								{
									SaveEntry se = psA.get(dse.recNumber-1);
									Applet4StndgWvs a4sw = new Applet4StndgWvs(psA, "Standing Waves (" + dse.name + ") - PhySim '11");
									a4sw.sldrFreq.setValue(se.val1);
									a4sw.sldrFreq.setEnabled(false);
									a4sw.sldrAmp.setValue(se.val2);
									a4sw.sldrAmp.setEnabled(false);
									a4sw.sldrLngth.setValue(se.val3);
									a4sw.sldrLngth.setEnabled(false);
									a4sw.bttnQuit.setVisible(false);
									a4sw.bttnSave.setVisible(false);
									a4sw.setVisible(true);
								}
								else
								{
									Applet4MagFields a4mf = new Applet4MagFields(psA, "Lenz's Law (" + dse.name + ") - PhySim '11");
									SaveEntry se = psA.get(dse.recNumber-1);
									a4mf.sldrLen.setValue(se.val1);
									a4mf.sldrLen.setEnabled(false);
									a4mf.sldrflx.setValue(se.val2);
									a4mf.sldrflx.setEnabled(false);
									a4mf.sldrAng.setValue(se.val3);
									a4mf.sldrAng.setEnabled(false);
									a4mf.sldrVelo.setValue(se.val4);
									a4mf.sldrVelo.setEnabled(false);
									a4mf.bttnQuit.setVisible(false);
									a4mf.bttnSave.setVisible(false);
									a4mf.setVisible(false);
								}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				/**This button enables the user to take the selected record and
				 * replay the simulation
				 */
			}
			{
				btteDelete = new JButton();
				getContentPane().add(btteDelete);
				btteDelete.setText("Delete");
				btteDelete.setBounds(521, 113, 99, 22);
				btteDelete.setFont(new java.awt.Font("Century Gothic",0,12));
				btteDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("btteDelete.actionPerformed, event="+evt);
						try {
							int recNumber =Integer.parseInt(tbleData.getModel().getValueAt(
									tbleData.getSelectedRow(),0).toString());
							psA.delete(recNumber-1);
							SortSearchNDisplay ssd = new SortSearchNDisplay(psA);
							tbleData.setModel(new DefaultTableModel (ssd.turnToTable(),colHead ));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				/**This button enables the user to delete records
				 */
			}
			{
				bttnDeleteAll = new JButton();
				getContentPane().add(bttnDeleteAll);
				bttnDeleteAll.setText("Delete All");
				bttnDeleteAll.setBounds(521, 141, 99, 22);
				bttnDeleteAll.setFont(new java.awt.Font("Century Gothic",0,12));
				bttnDeleteAll.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("bttnDeleteAll.actionPerformed, event="+evt);
						try {
							psA.deleteAll();
							SortSearchNDisplay ssd = new SortSearchNDisplay(psA);
							tbleData.setModel(new DefaultTableModel (ssd.turnToTable(),colHead ));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				/**This button enables the user to delete all the records
				 */
			}
			{
				txtfldSearch = new JTextField();
				getContentPane().add(txtfldSearch);
				txtfldSearch.setText("Search");
				txtfldSearch.setBounds(554, 185, 99, 22);
				/**This text field enables the user to search records by name
				 */
			}
			{
				bttnShowAll = new JButton();
				getContentPane().add(bttnShowAll);
				bttnShowAll.setText("Show All");
				bttnShowAll.setBounds(521, 318, 99, 22);
				bttnShowAll.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("bttnShowAll.actionPerformed, event="+evt);
						SortSearchNDisplay ssd;
						try {
							ssd = new SortSearchNDisplay(psA);
							tbleData.setModel(new DefaultTableModel (ssd.turnToTable(),colHead ));
							bttnOK.setEnabled(true);
							SortDate.setEnabled(true);
							SortName.setEnabled(true);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				/**This button enables the user to
				 * display all the records in the table
				 */
			}
			{
				ComboBoxModel cmboBxSearchModel = 
					new DefaultComboBoxModel(
							new String[] {"Filter By Type","Circular Motion", "Gravitation",
									"Electric Fields", "Standing Waves", "Magnetic Fields"});
				cmboBxSearch = new JComboBox();
				getContentPane().add(cmboBxSearch);
				cmboBxSearch.setModel(cmboBxSearchModel);
				cmboBxSearch.setBounds(554, 213, 123, 22);
				cmboBxSearch.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent evt) {
						System.out.println("cmboBxSearch.itemStateChanged, event="+evt);
						SortSearchNDisplay ssd;
						try {
							ssd = new SortSearchNDisplay(psA);
							DefaultTableModel dtm = new DefaultTableModel((ssd.searchByType(cmboBxSearch.getSelectedItem().toString())),colHead);
							tbleData.setModel(dtm);
							bttnOK.setEnabled(false);
							SortDate.setEnabled(false);
							SortName.setEnabled(false);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});

				/**This drop-box enables the user to
				 * filter which simulation they wish to see
				 */
			}
			{
				bttnSearch = new JButton();
				getContentPane().add(bttnSearch);
				bttnSearch.setText("Search");
				bttnSearch.setBounds(689, 185, 52, 22);
				bttnSearch.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("bttnSearch.actionPerformed, event="+evt);
						SortSearchNDisplay ssd;
						try {
							ssd = new SortSearchNDisplay(psA);
							DefaultTableModel mdl = new DefaultTableModel(ssd.search(txtfldSearch.getText()),
									colHead);
							tbleData.setModel(mdl);
							bttnOK.setEnabled(false);
							SortDate.setEnabled(false);
							SortName.setEnabled(false);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				/**This button enables the user to search records by name
				 */
			}
			{
				lblFilter = new JLabel();
				getContentPane().add(lblFilter);
				lblFilter.setText("Filter");
				lblFilter.setBounds(521, 173, 49, 15);
			}
			{
				lblSort = new JLabel();
				getContentPane().add(lblSort);
				lblSort.setText("Sort");
				lblSort.setBounds(521, 241, 111, 15);
			}
			{
				SortName = new JRadioButton();
				getContentPane().add(SortName);
				SortName.setText("Sort By Name");
				SortName.setBounds(554, 256, 123, 19);
				bttnSortCrtrn.add(SortName);
			}
			{
				SortDate = new JRadioButton();
				getContentPane().add(SortDate);
				SortDate.setText("Sort By Date");
				SortDate.setBounds(554, 275, 123, 19);
				bttnSortCrtrn.add(SortDate);
			}
			{
				bttnOK = new JButton();
				getContentPane().add(bttnOK);
				bttnOK.setText("OK");
				bttnOK.setBounds(689, 273, 31, 22);
				bttnOK.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent evt) 
					{
						System.out.println("bttnOK.actionPerformed, event="+evt);
						try {
							if(SortName.isSelected())
							{
								SortSearchNDisplay ssd = new SortSearchNDisplay(psA);
								DefaultTableModel dtm = new DefaultTableModel(ssd.turnToTable(ssd.sortByName()), colHead);
								tbleData.setModel(dtm);
							}
							else if(SortDate.isSelected())
							{
								SortSearchNDisplay ssd = new SortSearchNDisplay(psA);
								DefaultTableModel dtm = new DefaultTableModel(ssd.turnToTable(ssd.sortByDate()), colHead);
								tbleData.setModel(dtm);
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
			}
			pack();
			this.setSize(855, 410);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}