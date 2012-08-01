package br.unesp.ibb.lbbc.gui;

import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;

import br.unesp.ibb.lbbc.model.PercoliTreeModel;

public class SplitDesktop extends JSplitPane {

	
	public SplitDesktop(String project){
	this.setResizeWeight(0.1);
		
	PercoliTreeModel treeModel = new PercoliTreeModel(project);
	JTree tree = new JTree(treeModel);
	JScrollPane scrollPane = new JScrollPane(tree);
	this.setLeftComponent(scrollPane);
	
	
	
	}
	
}


//frmPercoliPercolation.getContentPane().add(splitPane, BorderLayout.CENTER);