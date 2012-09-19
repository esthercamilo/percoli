package br.unesp.ibb.lbbc.control;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JOptionPane;

import br.unesp.ibb.lbbc.model.Gene;
import br.unesp.ibb.lbbc.model.REG;
import edu.uci.ics.jung.graph.DirectedSparseGraph;

/**
 * @author esther
 *BooleanNetwork is based only in REG type of interaction
 */
@SuppressWarnings("serial")
public class BooleanNetwork extends DirectedSparseGraph<Gene,REG>{
	
	private ArrayList<REG> setOfReg;
	
	public BooleanNetwork (ArrayList<REG> setOfReg){
		this.setOfReg = setOfReg;
		
		//build the graph based on REG interactions
		for (REG reg:setOfReg){
			this.addEdge(reg,reg.getGene1(),reg.getGene2());
		}
	}
	
	public ArrayList<REG> getSetOfReg() {
		return setOfReg;
	}

	public HashMap<Gene, Boolean> getNetworkNextState(HashMap<Gene, Boolean> initialState){
		
		HashMap<Gene, Boolean> map = new HashMap<>();
		for (Gene gene:initialState.keySet()){
			boolean newState = getGeneNexState(initialState, gene);
			map.put(gene, newState);
		}
				
		return map;
	}
	
	/**
	 * 
	 * */
	public boolean getGeneNexState(HashMap<Gene, Boolean> initialState, Gene gene){
		
			boolean resultState = initialState.get(gene);
			Collection<REG> edges = this.getInEdges(gene);
			int pos = 0;
			int neg = 0;
			for (REG r:edges){
				boolean state = initialState.get(r.getGene1());
				if (state==true){
					if (r.getActivates()==true){
						pos = pos+1;
					}
					else{neg = neg+1;}
				}
			}
			int result = pos-neg;
			if (result<0){resultState=false;}
			else if (result>0){resultState=true;}
		
			
			
		return resultState;
			
	
	}

		
}
