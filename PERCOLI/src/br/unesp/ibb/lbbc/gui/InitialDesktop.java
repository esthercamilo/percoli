package br.unesp.ibb.lbbc.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.unesp.ibb.lbbc.control.PopulateInitialDatabase;
import br.unesp.ibb.lbbc.model.Acessos;
import br.unesp.ibb.lbbc.persistence.Entidade;

import com.jgoodies.looks.windows.WindowsLookAndFeel;
import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class InitialDesktop {

	private static JFrame frmPercoliPercolation;
	private JTextField txtLbbcLaboratrio;
	private JToolBar toolBar;
	SplashScreen screen;
	private static JToolBar toolBarPercolation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		
		
		setLookAndFeel();
		InitialDesktop window = new InitialDesktop();
		
		window.frmPercoliPercolation.setVisible(true);
		
	}

	public static JFrame getFrmPercoliPercolation() {
		return frmPercoliPercolation;
	}

	/**
	 * Create the application.
	 */
	public InitialDesktop() {
		
		splashScreenInit();
		Entidade entidade = new Entidade();
		Acessos ac = new Acessos();
		ac.setDate(Calendar.DATE);
		entidade.inserirObjeto(ac);
		screen.setProgress("" , entidade.hashCode());  
		  
		
		
		initialize();
		splashScreenDestruct();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPercoliPercolation = new JFrame();
		frmPercoliPercolation.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(
						InitialDesktop.class
								.getResource("/images/percolation.png")));
		frmPercoliPercolation
				.setTitle("PERCOLI - Percolation Analysis of E.coli Gene Network");
		frmPercoliPercolation.setBounds(100, 100, 800, 600);
		frmPercoliPercolation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmPercoliPercolation.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		JMenuItem mniNewProject = new JMenuItem("New Project");
		mniNewProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new NewProjectDialog();
			}
		});
		mniNewProject.setIcon(null);
		mnFile.add(mniNewProject);

		JSeparator separator = new JSeparator();
		mnFile.add(separator);

		JMenuItem mniExit = new JMenuItem("Exit");
		mnFile.add(mniExit);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmRedo = new JMenuItem("Redo");
		mnEdit.add(mntmRedo);
		
		JMenuItem mntmUndo = new JMenuItem("Undo");
		mnEdit.add(mntmUndo);
		
		JMenuItem mntmFind = new JMenuItem("Find");
		mnEdit.add(mntmFind);
		
		JMenu mnDatabase = new JMenu("Database");
		menuBar.add(mnDatabase);
		
		JMenuItem mntmImportGeneData = new JMenuItem("Import Gene Data");
		mnDatabase.add(mntmImportGeneData);
		
		JMenu mnCalculations = new JMenu("Calculations");
		menuBar.add(mnCalculations);
		
		JMenuItem mntmDamage = new JMenuItem("Damage");
		mnCalculations.add(mntmDamage);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JMenuItem mntmDecisionTree = new JMenuItem("Decision Tree");
		mnView.add(mntmDecisionTree);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmSearch = new JMenuItem("Search");
		mnHelp.add(mntmSearch);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);

		txtLbbcLaboratrio = new JTextField();
		txtLbbcLaboratrio.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		txtLbbcLaboratrio
				.setText("Laborat\u00F3rio de Bioinfom\u00E1tica e Biof\u00EDsica Computacional - Unesp / Brasil 2012");
		frmPercoliPercolation.getContentPane().add(txtLbbcLaboratrio,
				BorderLayout.SOUTH);
		txtLbbcLaboratrio.setColumns(10);

		toolBar = new JToolBar();
		frmPercoliPercolation.getContentPane().add(toolBar, BorderLayout.NORTH);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NewProjectDialog();
			}
		});
		btnNewButton.setToolTipText("New");
		btnNewButton.setIcon(new ImageIcon(InitialDesktop.class
				.getResource("/images/document-icon.png")));
		toolBar.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OpenProjectDialog();
			}
		});
		btnNewButton_1.setToolTipText("Open");
		btnNewButton_1.setIcon(new ImageIcon(InitialDesktop.class
				.getResource("/images/folder-icon.png")));
		toolBar.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setToolTipText("Save");
		btnNewButton_2.setIcon(new ImageIcon(InitialDesktop.class
				.getResource("/images/save-icon.png")));
		toolBar.add(btnNewButton_2);
		
		toolBarPercolation = new JToolBar();
		toolBar.add(toolBarPercolation);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PopulateInitialDatabase pop = new PopulateInitialDatabase();
				
			}
		});
		btnNewButton_4.setToolTipText("Populate gene database");
		btnNewButton_4.setIcon(new ImageIcon(InitialDesktop.class.getResource("/images/gen.png")));
		toolBarPercolation.add(btnNewButton_4);
		
		
	

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator_1);

		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setToolTipText("Help");
		btnNewButton_3.setIcon(new ImageIcon(InitialDesktop.class
				.getResource("/images/info-icon.png")));
		toolBar.add(btnNewButton_3);
		
	
		
		
	}

	public static void setLookAndFeel() {
		// PlasticLookAndFeel look = new PlasticLookAndFeel();
		// PlasticLookAndFeel.setCurrentTheme(new ExperienceBlue());
		WindowsLookAndFeel look = new WindowsLookAndFeel();
		try {
			UIManager.setLookAndFeel(look);
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void splashScreenInit() {
		    ImageIcon myImage = new ImageIcon(InitialDesktop.class.getResource("/images/initSplash.jpg"));
		    screen = new SplashScreen(myImage);
		    screen.setLocationRelativeTo(null);
		    screen.setProgressMax(100);
		    screen.setScreenVisible(true);
		    
		    
	 }
	
	public static JToolBar getToolBarPercolation() {
		return toolBarPercolation;
	}

	private void splashScreenDestruct() {
	    screen.setScreenVisible(false);
	  }

}
