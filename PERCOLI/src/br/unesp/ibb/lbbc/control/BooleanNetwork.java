package br.unesp.ibb.lbbc.control;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import br.unesp.ibb.lbbc.model.Gene;
import br.unesp.ibb.lbbc.model.REG;
import edu.uci.ics.jung.graph.DirectedSparseGraph;

/**
 * @author esther
 *
 */
@SuppressWarnings("serial")
public class BooleanNetwork extends DirectedSparseGraph<Gene,REG>{
	private ArrayList<REG> setOfReg;
	private Collection<Gene> vertex;
	int numberGenes;
	int i = 0;
	
	public BooleanNetwork (ArrayList<REG> setOfReg){
		this.setOfReg = setOfReg;
		
		//build the graph based on REG interactions
		for (REG reg:setOfReg){
			this.addEdge(reg,reg.getGene1(),reg.getGene2());
		}
		
		vertex = this.getVertices();
		numberGenes = vertex.size();
		
		
	}
	
	
	public ArrayList<REG> getSetOfReg() {
		return setOfReg;
	}

	
	public HashMap<Gene, Boolean> getNetworkNextState(HashMap<Gene, Boolean> initialState){
		
		HashMap<Gene, Boolean> map = new HashMap<>();
		for (Gene gene:initialState.keySet()){
			boolean newState = getGeneState(initialState, gene);
			map.put(gene, newState);
		}
				
		return map;
	}
	
	public void findSingleAttractors(){
		
		
		
	}
	/**
	 * 
	 * */
	public boolean getGeneState(HashMap<Gene, Boolean> initialState, Gene gene){
		
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
