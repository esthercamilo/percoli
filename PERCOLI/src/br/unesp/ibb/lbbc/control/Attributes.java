package br.unesp.ibb.lbbc.control;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import agape.tools.Components;
import br.unesp.ibb.lbbc.model.Gene;
import br.unesp.ibb.lbbc.model.REG;
import br.unesp.ibb.lbbc.persistence.Entidade;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;

public class Attributes {

	String att;
	Entidade ent = new Entidade();
	Graph<Gene, Gene[]> graph = new DirectedSparseGraph<>();
	HashMap<String, Double> mapDamage = new HashMap<>();
	
	Formatter formater;
	
	public Attributes() {

		try {
			formater = new Formatter(new File("C:\\Users\\esther\\Desktop\\ProjetosTestes\\teste1\\damage.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void calculateDamage() {
		// for while only to regulation

		List<REG> regList = ent.findAll(REG.class);
		

		for (REG reg : regList) {  //para cada linha na tabela reg
			Gene[] e = { reg.getGene1(), reg.getGene2() };
			Gene v1 = reg.getGene1();
			Gene v2 = reg.getGene2();
			graph.addEdge(e, v1, v2);
		}

		Collection<Gene> listGenes = graph.getVertices();
		
		int graphMaior = getBiggestGraph(graph);
	//	System.out.println("graphMaior "+graphMaior);
		
		Gene[] initial = new Gene[listGenes.size()]; //empty array
		Gene[] arrayGenes = listGenes.toArray(initial); //create a list of genes
		
		for (int i =0; i<arrayGenes.length;i++){
			Graph<Gene, Gene[]> newGraph = new DirectedSparseGraph<>();
			
			
//****************VAI FICAR SUPER LERDO porque reconstroi a rede toda vez que vai deletar um gene
			
			
			for (REG reg : regList) {  //para cada linha na tabela reg
				Gene[] e = { reg.getGene1(), reg.getGene2() };
				Gene v1 = reg.getGene1();
				Gene v2 = reg.getGene2();
				newGraph.addEdge(e, v1, v2);
			}
			
//********************************************************************************************************			
			
			
			newGraph.removeVertex(arrayGenes[i]);
			int tamanhoDeste = getBiggestGraph(newGraph);
			//System.out.println("tamanhoDeste "+tamanhoDeste);
			
			double damage = 100.00000-((double)tamanhoDeste*100/graphMaior);
			//System.out.println(arrayGenes[i].getName()+"   "+damage );
			mapDamage.put(arrayGenes[i].getName(), damage);
			
		}
		
		
		for (String key:mapDamage.keySet()){
			formater.format("%s;%2.10f\n",key,mapDamage.get(key));	
		}
		
		formater.close();
		

	}

	// return the index of the biggest graph
	private int getBiggestGraph(Graph graph) {
		
		ArrayList<Set<Gene>> list = Components.getAllConnectedComponent(graph);

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
		return tamanhoDoMaior;

	}
}
