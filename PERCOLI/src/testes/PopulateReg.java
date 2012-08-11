package testes;

import br.unesp.ibb.lbbc.control.PopulateInitialDatabase;

public class PopulateReg {

	
	PopulateInitialDatabase pop = new PopulateInitialDatabase();
	
	
	public PopulateReg(){
		
		pop.populateIngi();
		
	}
	
	
	public static void main(String[] args) {
		PopulateReg populate = new PopulateReg();

	}

}
