package br.unesp.ibb.lbbc.gui;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;

import br.unesp.ibb.lbbc.model.PercoliTreeModel;
import br.unesp.ibb.lbbc.model.TableAttModel;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JPanel;

public class SplitDesktop extends JSplitPane {
	private JTable table;

	
	public SplitDesktop(String project){
	this.setResizeWeight(0.1);
		
	PercoliTreeModel treeModel = new PercoliTreeModel(project);
	JTree tree = new JTree(treeModel);
	JScrollPane scrollPane = new JScrollPane(tree);
	this.setLeftComponent(scrollPane);
	
	JSplitPane splitPane = new JSplitPane();
	splitPane.setResizeWeight(1.0);
	splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
	setRightComponent(splitPane);
	
	table = new JTable();
	TableAttModel tableModel = new TableAttModel();
	splitPane.setRightComponent(table);
	
	JPanel panel = new JPanel();
	splitPane.setLeftComponent(panel);
	
	
	
	}
	
}


//frmPercoliPercolation.getContentPane().add(splitPane, BorderLayout.CENTER);