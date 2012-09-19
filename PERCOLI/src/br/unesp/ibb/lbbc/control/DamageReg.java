package br.unesp.ibb.lbbc.control;

import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;

import br.unesp.ibb.lbbc.model.Gene;
import br.unesp.ibb.lbbc.model.REG;
import edu.uci.ics.jung.graph.DirectedSparseGraph;

public class DamageReg {

	
	
	public DamageReg(){
		
	}
/**
 * calculate the damage for each gene
 * */
	public double getDamageReg(BooleanNetwork bn, Gene deletedGene){
		int initNumberOfGenes = bn.getVertexCount();
		//Do one clone and then remove the gene.
		BooleanNetwork clone = new BooleanNetwork(bn.getSetOfReg());
		clone.removeVertex(deletedGene);
		
		//state initial state = 1 for all genes
		HashMap<Gene, Boolean> initialState = new HashMap<>();
		Iterator<Gene> it = clone.getVertices().iterator();
		while (it.hasNext()){
			initialState.put((Gene) it.next(),true);
		}
		
		//run untill find the first attractor
		boolean go = true;
		while(go){
			HashMap<Gene, Boolean> current = clone.getNetworkNextState(initialState); 
			if (current.equals(initialState)){
				go=false;
			}
			else{
				initialState=current;
			}
		}
		
		//determine how many genes are turned off now
		int sobra = 0;
		for (Gene gene:initialState.keySet()){
			if (initialState.get(gene)==true){
				sobra = sobra +1;
			}
		}
		
		double damage = (double)sobra/(double)initNumberOfGenes;
		
		return damage;
	}
	
}
