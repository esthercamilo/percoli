package testes;

import java.util.ArrayList;
import java.util.HashMap;

import br.unesp.ibb.lbbc.control.BooleanNetwork;
import br.unesp.ibb.lbbc.model.Gene;
import br.unesp.ibb.lbbc.model.REG;

public class TestaBoolean {

	public TestaBoolean(){
		
		Gene g1 = new Gene();
		g1.setCOMMONNAME("A");
		Gene g2 = new Gene();
		g2.setCOMMONNAME("B");
		Gene g3 = new Gene();
		g3.setCOMMONNAME("C");
		Gene g4 = new Gene();
		g4.setCOMMONNAME("D");
		Gene g5 = new Gene();
		g5.setCOMMONNAME("E");
	
		ArrayList<REG> setReg =new ArrayList<>();
		
		REG r1 = new REG();
		r1.setGene1(g1);
		r1.setGene2(g2);
		r1.setActivates(true);
		setReg.add(r1);
		
		REG r2 = new REG();
		r2.setGene1(g1);
		r2.setGene2(g3);
		r2.setActivates(true);
		setReg.add(r2);
		
		REG r3 = new REG();
		r3.setGene1(g1);
		r3.setGene2(g5);
		r3.setActivates(false);
		setReg.add(r3);
		
		REG r4 = new REG();
		r4.setGene1(g5);
		r4.setGene2(g3);
		r4.setActivates(false);
		setReg.add(r4);
		
		REG r5 = new REG();
		r5.setGene1(g5);
		r5.setGene2(g4);
		r5.setActivates(true);
		setReg.add(r5);
		
		REG r6 = new REG();
		r6.setGene1(g4);
		r6.setGene2(g3);
		r6.setActivates(false);
		setReg.add(r6);
		
		BooleanNetwork bn = new BooleanNetwork(setReg);
		HashMap<Gene,Boolean> estados = new HashMap<>();
		estados.put(g1,true);
		estados.put(g2,false);
		estados.put(g3,false);
		estados.put(g4,true);
		estados.put(g5,true);
		
	/*	System.out.println(bn.getGeneState(estados,g1, bn));
		System.out.println(bn.getGeneState(estados,g2, bn));
		System.out.println(bn.getGeneState(estados,g3, bn));
		System.out.println(bn.getGeneState(estados,g4, bn));
		System.out.println(bn.getGeneState(estados,g5, bn));*/
		
		
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		TestaBoolean t = new TestaBoolean();

	}

}
