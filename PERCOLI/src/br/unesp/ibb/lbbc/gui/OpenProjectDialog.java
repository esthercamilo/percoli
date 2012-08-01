package br.unesp.ibb.lbbc.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListDataListener;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JList;

import br.unesp.ibb.lbbc.model.NewProject;
import br.unesp.ibb.lbbc.persistence.Entidade;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpenProjectDialog extends JDialog {


	private JList list;
	private OpenProjListModel model;

	
	
	public OpenProjectDialog() {
		
	
		
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						InitialDesktop.getFrmPercoliPercolation().getContentPane().add(new SplitDesktop((String)list.getSelectedValue()), BorderLayout.CENTER);
						InitialDesktop.getToolBarPercolation().setVisible(true);
						InitialDesktop.getFrmPercoliPercolation().revalidate();
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				model = new OpenProjListModel(); 
				list = new JList(model);
				list.setBounds(87, 38, 255, 125);
				panel.add(list);
				
			}
		}
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			panel.setBackground(Color.WHITE);
			getContentPane().add(panel, BorderLayout.NORTH);
			{
				JLabel lblChooseAProject = new JLabel("Choose a project from database");
				lblChooseAProject.setFont(new Font("Tahoma", Font.PLAIN, 18));
				panel.add(lblChooseAProject);
			}
		}
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	private class OpenProjListModel implements ListModel<String> {

		private Entidade en;
		private List<NewProject> listaProjetos;

		public OpenProjListModel (){
			en = new Entidade();
			listaProjetos = en.findAll(NewProject.class);
		}
		
		@Override
		public void addListDataListener(ListDataListener l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getElementAt(int index) {
			
			
			String elem = listaProjetos.get(index).getName();
			return elem;
		}

		@Override
		public int getSize() {
			int tamanho = listaProjetos.size();
			return tamanho;
		}

		@Override
		public void removeListDataListener(ListDataListener l) {
			// TODO Auto-generated method stub
			
		}
		
	} 

}


