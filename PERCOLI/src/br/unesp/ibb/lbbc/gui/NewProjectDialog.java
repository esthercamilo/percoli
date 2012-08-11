package br.unesp.ibb.lbbc.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import br.unesp.ibb.lbbc.control.PopulateInitialDatabase;

import br.unesp.ibb.lbbc.model.NewProject;
import br.unesp.ibb.lbbc.persistence.Entidade;
import static java.nio.file.StandardCopyOption.*;


public class NewProjectDialog extends JDialog {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	protected String projectName;
	private JButton okButton;

	/**
	 * Launch the application.
	 */

	public NewProjectDialog() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewProjectDialog.class.getResource("/images/percolation.png")));
		setTitle("New Project");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		//setVisible(true);
		setBounds(100, 100, 600, 560);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Finish");
				okButton.setEnabled(false);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						okPressed();
					}
				});
				//okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancelPressed();
					}
				});
				//cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(0, 0, 589, 94);
				panel_1.setBackground(Color.WHITE);
				panel.add(panel_1);
				panel_1.setLayout(null);
				
				JLabel lblCreateANew = new JLabel("Create a new Project");
				lblCreateANew.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblCreateANew.setBounds(10, 29, 242, 19);
				panel_1.add(lblCreateANew);
				
				JLabel lblCreateANew_1 = new JLabel("Create a new model based on database below.");
				lblCreateANew_1.setBounds(10, 59, 283, 14);
				panel_1.add(lblCreateANew_1);
				
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setToolTipText("");
				lblNewLabel.setIcon(new ImageIcon(NewProjectDialog.class.getResource("/images/ecoli.png")));
				lblNewLabel.setBounds(504, 19, 64, 54);
				panel_1.add(lblNewLabel);
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(10, 105, 564, 80);
				panel_1.setBorder(null);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel lblProjectName = new JLabel("Project name:");
					lblProjectName.setBounds(2, 14, 93, 17);
					panel_1.add(lblProjectName);
				}
				{
					textField = new JTextField();					
					textField.addKeyListener(new KeyAdapter() {
						@Override
						public void keyTyped(KeyEvent arg0) {
							habilitaOk();
						}
					});
					
					
					textField.setBounds(92, 11, 467, 20);
					panel_1.add(textField);
					textField.setColumns(10);
				}
				{
					JLabel lblLocation = new JLabel("Location: ");
					lblLocation.setBounds(16, 45, 66, 17);
					panel_1.add(lblLocation);
				}
				{
					textField_1 = new JTextField();
					textField_1.setEnabled(false);
					textField_1.addKeyListener(new KeyAdapter() {
						@Override
						public void keyTyped(KeyEvent arg0) {
							habilitaOk();
						}
					});
					textField_1.setBounds(92, 42, 375, 20);
					panel_1.add(textField_1);
					textField_1.setColumns(10);
				}
				{
					JButton btnBrowse = new JButton("Browse");
					btnBrowse.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							
							JFileChooser chooser = new JFileChooser();
							chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
							chooser.showOpenDialog(null);
							chooser.requestFocus();
							File file = chooser.getSelectedFile();
							projectName = file.getAbsolutePath();
							textField_1.setText(projectName+"\\"+textField.getText());
							
							
						}
					});
					btnBrowse.setBounds(480, 40, 73, 23);
					panel_1.add(btnBrowse);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(10, 196, 564, 72);
				panel_1.setBorder(new TitledBorder(null, "Organism genome", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel lblGenome = new JLabel("Genome: ");
					lblGenome.setBounds(12, 36, 75, 14);
					panel_1.add(lblGenome);
				}
				{
					textField_2 = new JTextField();
					textField_2.setEnabled(false);
					textField_2.addKeyListener(new KeyAdapter() {
						@Override
						public void keyTyped(KeyEvent arg0) {
							habilitaOk();
						}
					});
					textField_2.setBounds(88, 33, 275, 20);
					panel_1.add(textField_2);
					textField_2.setColumns(10);
				}
				{
					JButton btnNewButton_1 = new JButton("From file");
					btnNewButton_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							
							JFileChooser chooser = new JFileChooser();
							chooser.showOpenDialog(null);
							chooser.requestFocus();
							File file = chooser.getSelectedFile();
							textField_2.setText(file.getAbsolutePath());
						}
					});
					btnNewButton_1.setBounds(395, 32, 79, 23);
					panel_1.add(btnNewButton_1);
				}
				{
					JButton btnNewButton = new JButton("Import");
					btnNewButton.setBounds(480, 32, 73, 23);
					panel_1.add(btnNewButton);
				}
			}
			{
				JButton btnNewButton_4 = new JButton("");
				btnNewButton_4.setOpaque(false);
				btnNewButton_4.setBorder(null);
				btnNewButton_4.setIcon(new ImageIcon(NewProjectDialog.class.getResource("/images/Help_32.png")));
				btnNewButton_4.setBackground(SystemColor.menu);
				btnNewButton_4.setBounds(42, 659, 33, 28);
				panel.add(btnNewButton_4);
			}
			
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(10, 315, 564, 94);
			panel.add(tabbedPane);
			
			JPanel panel_1 = new JPanel();
			tabbedPane.addTab("PPI", null, panel_1, null);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel_2 = new JLabel("Source");
			lblNewLabel_2.setBounds(10, 25, 51, 14);
			panel_1.add(lblNewLabel_2);
			
			textField_4 = new JTextField();
			textField_4.setEnabled(false);
			textField_4.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					habilitaOk();
				}
			});
			textField_4.setBounds(60, 22, 312, 20);
			panel_1.add(textField_4);
			textField_4.setColumns(40);
			
			JButton btnFromFile = new JButton("From file");
			btnFromFile.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser chooser = new JFileChooser();
					chooser.showOpenDialog(null);
					chooser.requestFocus();
					File file = chooser.getSelectedFile();
					textField_4.setText(file.getAbsolutePath());
				}
			});
			btnFromFile.setBounds(396, 21, 79, 23);
			panel_1.add(btnFromFile);
			
			JButton btnImport = new JButton("Import");
			btnImport.setBounds(480, 21, 73, 23);
			panel_1.add(btnImport);
			
			JPanel panel_2 = new JPanel();
			tabbedPane.addTab("REG", null, panel_2, null);
			panel_2.setLayout(null);
			{
				JLabel label = new JLabel("Source");
				label.setBounds(10, 25, 51, 14);
				panel_2.add(label);
			}
			{
				textField_5 = new JTextField();
				textField_5.setEnabled(false);
				textField_5.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent arg0) {
						habilitaOk();
					}
				});
				textField_5.setColumns(40);
				textField_5.setBounds(60, 22, 312, 20);
				panel_2.add(textField_5);
			}
			{
				JButton btnFromFile_1 = new JButton("From file");
				btnFromFile_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFileChooser chooser = new JFileChooser();
						chooser.showOpenDialog(null);
						chooser.requestFocus();
						File file = chooser.getSelectedFile();
						textField_5.setText(file.getAbsolutePath());
					}
				});
				btnFromFile_1.setBounds(387, 21, 79, 23);
				panel_2.add(btnFromFile_1);
			}
			{
				JButton btnImport_1 = new JButton("Import");
				btnImport_1.setBounds(476, 21, 73, 23);
				panel_2.add(btnImport_1);
			}
			
			JPanel panel_3 = new JPanel();
			tabbedPane.addTab("MET", null, panel_3, null);
			panel_3.setLayout(null);
			{
				JLabel label = new JLabel("Source");
				label.setBounds(10, 25, 51, 14);
				panel_3.add(label);
			}
			{
				textField_6 = new JTextField();
				textField_6.setEnabled(false);
				textField_6.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent arg0) {
						habilitaOk();
					}
				});
				
				textField_6.setColumns(40);
				textField_6.setBounds(60, 22, 312, 20);
				panel_3.add(textField_6);
			}
			{
				JButton btnFromFile_2 = new JButton("From file");
				btnFromFile_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFileChooser chooser = new JFileChooser();
						chooser.showOpenDialog(null);
						chooser.requestFocus();
						File file = chooser.getSelectedFile();
						textField_6.setText(file.getAbsolutePath());
					}
				});
				btnFromFile_2.setBounds(387, 21, 79, 23);
				panel_3.add(btnFromFile_2);
			}
			{
				JButton btnImport_2 = new JButton("Import");
				btnImport_2.setBounds(476, 21, 73, 23);
				panel_3.add(btnImport_2);
			}
			
			JLabel lblInteractionData = new JLabel("Interaction data");
			lblInteractionData.setBounds(15, 290, 169, 14);
			panel.add(lblInteractionData);
			{
				JLabel lblNewLabel_1 = new JLabel("");
				lblNewLabel_1.setBounds(10, 431, 32, 32);
				panel.add(lblNewLabel_1);
				lblNewLabel_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						System.out.println("bla");
						JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);
					}
				});
				lblNewLabel_1.setIcon(new ImageIcon(NewProjectDialog.class.getResource("/images/Help_32.png")));
			}
		}
		//pack();
		setLocationRelativeTo(null);
		setVisible(true);
		InitialDesktop.getFrmPercoliPercolation().setEnabled(false);
	
	}

	protected void cancelPressed() {
		
		this.setVisible(false);
	}

	private void habilitaOk(){
	
		if (textField.getText().length()!=0 && textField_1.getText().length()!=0 && textField_2.getText().length()!=0 && textField_4.getText().length()!=0 && textField_5.getText().length()!=0 && textField_6.getText().length()!=0){okButton.setEnabled(true);}
		}
	
	protected void okPressed() {
		
		//cria diretórios
		File dir = new File(textField_1.getText());  
		if (!dir.mkdir()) {  
			JOptionPane.showMessageDialog(null, "This directory alread exists", "alert", JOptionPane.ERROR_MESSAGE);
		}  else{JOptionPane.showMessageDialog(null,"Sucess","Information",JOptionPane.INFORMATION_MESSAGE);}
		
		
		//Localizacao dos arquivos antigos
		File genome = new File(textField_2.getText());
		Path genomePath = genome.toPath();
		File ppi = new File(textField_4.getText());
		Path ppiPath = ppi.toPath();
		File reg = new File(textField_5.getText());
		Path regPath = reg.toPath();
		File met = new File(textField_6.getText());
		Path metPath = met.toPath();
		
		//Nova localizacao
		Path genoma2 = (new File ((dir.getAbsolutePath()+"/"+genome.getName()))).toPath();
		Path ppi2 = (new File ((dir.getAbsolutePath()+"/"+ppi.getName()))).toPath();
		Path reg2 = (new File ((dir.getAbsolutePath()+"/"+reg.getName()))).toPath();
		Path met2 = (new File ((dir.getAbsolutePath()+"/"+met.getName()))).toPath();
		
		//Copiando
		try {
			Files.copy(genomePath,genoma2,REPLACE_EXISTING);
			Files.copy(ppiPath,ppi2,REPLACE_EXISTING);
			Files.copy(regPath,reg2,REPLACE_EXISTING);
			Files.copy(metPath,met2,REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		NewProject newproject = new NewProject();
		newproject.setName(textField.getText());
		newproject.setDirectory(textField_1.getText());
		newproject.setFileGenome(genoma2.toString());
		newproject.setFilePPI(ppi2.toString());
		newproject.setFileREG(reg2.toString());
		newproject.setFileMET(met2.toString());
		
		Entidade entidade = new Entidade();
		entidade.inserirObjeto(newproject);
		this.setVisible(false);
		InitialDesktop.getFrmPercoliPercolation().setEnabled(true);
		InitialDesktop.getFrmPercoliPercolation().setVisible(true);
		InitialDesktop.getFrmPercoliPercolation().setAutoRequestFocus(true);
		
		setPerspective(newproject.getName());
		PopulateInitialDatabase pop = new PopulateInitialDatabase();
		pop.populateGenome(newproject.getName());
		pop.populatePPI(newproject.getName());
		pop.populateREG(newproject.getName());
		pop.populateMET(newproject.getName());
		pop.populateIngi();
	}

	private static void setPerspective(String projName) {
		InitialDesktop.getFrmPercoliPercolation().getContentPane().add(new SplitDesktop(projName), BorderLayout.CENTER);
		InitialDesktop.getToolBarPercolation().setVisible(true);
		InitialDesktop.getFrmPercoliPercolation().revalidate();
	
	}
	
	
}
