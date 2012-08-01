package br.unesp.ibb.lbbc.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;

import br.unesp.ibb.lbbc.control.Percolation;

import java.awt.event.ActionListener;

public class PercoliDataDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnNewRadioButton_3;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton rdbtnNewRadioButton;


	/**
	 * Create the dialog.
	 */
	public PercoliDataDialog() {
		setTitle("Choice of the network");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JSplitPane splitPane = new JSplitPane();
			splitPane.setResizeWeight(0.3);
			splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			contentPanel.add(splitPane, BorderLayout.CENTER);
			{
				JPanel panel = new JPanel();
				panel.setBackground(Color.WHITE);
				splitPane.setLeftComponent(panel);
				panel.setLayout(null);
				
				JLabel lblSelectTheType = new JLabel("Select the type of network to perform");
				lblSelectTheType.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblSelectTheType.setBounds(10, 11, 326, 17);
				panel.add(lblSelectTheType);
				
				JLabel lblThePercolationCalculations = new JLabel("the percolation calculations.");
				lblThePercolationCalculations.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblThePercolationCalculations.setBounds(10, 33, 263, 31);
				panel.add(lblThePercolationCalculations);
			}
			
			JPanel panel = new JPanel();
			splitPane.setRightComponent(panel);
			panel.setLayout(null);
			
			rdbtnNewRadioButton = new JRadioButton("PPI");
			rdbtnNewRadioButton.setActionCommand("ppi");
			buttonGroup.add(rdbtnNewRadioButton);
			rdbtnNewRadioButton.setBounds(86, 31, 109, 23);
			panel.add(rdbtnNewRadioButton);
			
			rdbtnNewRadioButton_1 = new JRadioButton("REG");
			rdbtnNewRadioButton_1.setActionCommand("reg");
			buttonGroup.add(rdbtnNewRadioButton_1);
			rdbtnNewRadioButton_1.setBounds(86, 74, 109, 23);
			panel.add(rdbtnNewRadioButton_1);
			
			rdbtnNewRadioButton_2 = new JRadioButton("MET");
			rdbtnNewRadioButton_2.setActionCommand("met");
			buttonGroup.add(rdbtnNewRadioButton_2);
			rdbtnNewRadioButton_2.setBounds(197, 31, 109, 23);
			panel.add(rdbtnNewRadioButton_2);
			
			rdbtnNewRadioButton_3 = new JRadioButton("IN");
			rdbtnNewRadioButton_3.setActionCommand("in");
			buttonGroup.add(rdbtnNewRadioButton_3);
			rdbtnNewRadioButton_3.setToolTipText("Integrated Network");
			rdbtnNewRadioButton_3.setBounds(197, 74, 109, 23);
			panel.add(rdbtnNewRadioButton_3);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(PercoliDataDialog.class.getResource("/images/Help_32.png")));
			lblNewLabel.setBounds(366, 107, 32, 32);
			panel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String pressed = buttonGroup.getSelection().getActionCommand();
						new Percolation(pressed);
												
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				buttonPane.add(cancelButton);
			}
		}
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
}
