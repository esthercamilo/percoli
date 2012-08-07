package br.unesp.ibb.lbbc.control;

import java.awt.Component;
import java.awt.image.ComponentSampleModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import edu.uci.ics.jung.algorithms.filters.FilterUtils;
import edu.uci.ics.jung.algorithms.filters.KNeighborhoodFilter;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.event.GraphEvent.Edge;

import agape.tools.Components;
import br.unesp.ibb.lbbc.model.Gene;
import br.unesp.ibb.lbbc.model.REG;
import br.unesp.ibb.lbbc.persistence.Entidade;

public class Attributes {

	String att;
	Entidade ent = new Entidade();

	public Attributes() {

	}

	public void calculateDamage() {
		// for while only to regulation

		List<REG> regList = ent.findAll(REG.class);
		Graph<Gene, Gene[]> graph = new DirectedSparseGraph<>();

		for (REG reg : regList) {
			Gene[] e = { reg.getGene1(), reg.getGene2() };
			Gene v1 = reg.getGene1();
			Gene v2 = reg.getGene2();
			graph.addEdge(e, v1, v2);
		}

		Collection<Gene> listGenes = graph.getVertices();
		System.out.println("How many genes there are " + listGenes.size());

		int graphMaior = getBiggestGraph(graph);
		
		System.out.println("Graph maior "+graphMaior);
		
		Gene[] initial = new Gene[listGenes.size()]; //empty array
		Gene[] arrayGenes = listGenes.toArray(initial); //create a list of genes
	

		
		//for (Gene gene: arrayGenes){
		Graph<Gene, Gene[]> newGraph = graph;
		System.out.println(arrayGenes[5].getName());
		newGraph.removeVertex(arrayGenes[5]);
		
		int tamanhoDeste = getBiggestGraph(newGraph);
		System.out.println("o tamanho deste eh " + tamanhoDeste);
		//}
	}

	public void calculateDegree() {

	}

	// return the index of the biggest graph
	private int getBiggestGraph(Graph graph) {
		
		ArrayList<Set<Gene>> list = Components.getAllConnectedComponent(graph);

		// Catch the biggest index
		int lenght = list.size();
		int maior = 0;
		int index = 0;

		for (int i = 0; i < lenght; i++) {
			if (list.get(i).size() > maior) {
				maior = list.get(i).size();
				index = i;
			}
		}
		// Size of the biggest initial graph
		int tamanhoDoMaior = list.get(index).size();
		return index;

	}
}
