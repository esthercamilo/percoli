package testes;

import br.unesp.ibb.lbbc.control.Percolation;

public class Teste {

	
	public Teste(){
		Percolation percolation = new Percolation("ppi");
		percolation.calculateImpact("D");
	}
	
	
	
	public static void main(String[] args) {
		Teste t = new Teste();

	}

}
