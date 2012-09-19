package testes;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;


import br.unesp.ibb.lbbc.control.BooleanNetwork;
import br.unesp.ibb.lbbc.control.DamageReg;
import br.unesp.ibb.lbbc.control.PopulateInitialDatabase;
import br.unesp.ibb.lbbc.model.Gene;
import br.unesp.ibb.lbbc.model.REG;
import br.unesp.ibb.lbbc.persistence.Entidade;

public class CalcDamageTest {

	
	public CalcDamageTest(){
	//	PopulateInitialDatabase pop= new PopulateInitialDatabase();
	//	pop.populateREG("1");
		
	Entidade ent = new Entidade();
		List prov = ent.findAll(REG.class);
		ArrayList<REG> setOfReg = new ArrayList<>();
		
		for (int i=0;i<prov.size();i++){
			setOfReg.add((REG) prov.get(i));
		}
		BooleanNetwork bn = new BooleanNetwork(setOfReg);
		HashMap<String,Double> damages = new HashMap<>();
		DamageReg dam = new DamageReg();
		for (Gene gene:bn.getVertices()){
			double damage = dam.getDamageReg(bn, gene);
			damages.put(gene.getCOMMONNAME(),damage);
		}
	
		Formatter output = null;
		try {
			output = new Formatter("C:\\ESTHER\\damage.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (String key:damages.keySet()){
			output.format("%s;%2.12f\n",key,damages.get(key));
		}
		output.close();
	}
	
	public static void main(String[] args) {
		CalcDamageTest t = new CalcDamageTest();

	}

}
