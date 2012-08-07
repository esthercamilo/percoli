package br.unesp.ibb.lbbc.control;

import java.util.List;

import edu.uci.ics.jung.graph.DirectedSparseGraph;

import br.unesp.ibb.lbbc.model.Gene;
import br.unesp.ibb.lbbc.model.REG;
import br.unesp.ibb.lbbc.persistence.Entidade;

public class Attributes {

	String att;
	Entidade ent = new Entidade();

	public Attributes() {
		
	}

	public void calculateDamage() {
		//for while only to regulation
		
	List<REG> regList = ent.findAll(REG.class);
	DirectedSparseGraph<Gene, Gene[]> graph = new DirectedSparseGraph<>();
	for (REG reg: regList){
		Gene[] e = {reg.getGene1(),reg.getGene2()};
		Gene v1 = reg.getGene1();
		Gene v2 = reg.getGene2();
		graph.addEdge(e, v1, v2);
		
	}
		
	}

	public void calculateDegree() {

	}

}
