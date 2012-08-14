package br.unesp.ibb.lbbc.control;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import br.unesp.ibb.lbbc.model.Gene;
import br.unesp.ibb.lbbc.model.MET;
import br.unesp.ibb.lbbc.model.PPI;
import br.unesp.ibb.lbbc.model.REG;
import br.unesp.ibb.lbbc.persistence.Entidade;

public class Percolation {
	private String network;

	public Percolation(String network) {
		this.network = network;
		
	}

	/**
	 * Given a interaction set, this method returns a list of genes that is deleted tobecause the deletion of  
	 * one gene
	 * 
	 */
	public List<REG> calculateImpact(String deletedGene){
		
		
		Entidade ent = new Entidade();
		List<REG> listReg = ent.findAll(REG.class);
		
		DirectedSparseGraph<String, String[]> graph = new DirectedSparseGraph<String, String[]>();
		for (REG reg : listReg){
			String v1 =reg.getGene1().getCOMMONNAME(); 
			String v2 =reg.getGene2().getCOMMONNAME(); 
			String[] e = {v1,v2};
			graph.addEdge(e, v1, v2);
		}
		
		//JOptionPane.showMessageDialog(null,"Incidentes em D:  "+graph.inDegree("D"));
		
		
		
		return null;
		
	}
	
	
	
	
	
}
