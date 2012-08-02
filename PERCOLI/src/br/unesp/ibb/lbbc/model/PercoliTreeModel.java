package br.unesp.ibb.lbbc.model;

import java.util.List;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import br.unesp.ibb.lbbc.persistence.Entidade;

public class PercoliTreeModel implements TreeModel {

	
	String nameProject;
	Entidade ent = new Entidade();
	
	
	public PercoliTreeModel(String nameProject) {
		super();
		this.nameProject = nameProject;
	}

	@Override
	public void addTreeModelListener(TreeModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getChild(Object arg0, int arg1) {
		if (arg1==0){return "ppi";}
		else if (arg1==1){return "reg";}
		else if (arg1==2){return "met";}
		else {return "INGI";}
		
	}

	@Override
	public int getChildCount(Object arg0) {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int getIndexOfChild(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getRoot() {
		NewProject project = (NewProject) ent.findProjectByName(nameProject);
		return project.name;
	}

	@Override
	public boolean isLeaf(Object arg0) {
		if (arg0!=getRoot()){return true;}
		return false;
	}

	@Override
	public void removeTreeModelListener(TreeModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueForPathChanged(TreePath arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	

}
