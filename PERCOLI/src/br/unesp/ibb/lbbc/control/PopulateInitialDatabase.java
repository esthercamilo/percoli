package br.unesp.ibb.lbbc.control;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NonUniqueResultException;
import br.unesp.ibb.lbbc.model.Gene;
import br.unesp.ibb.lbbc.model.Ingi;
import br.unesp.ibb.lbbc.model.MET;
import br.unesp.ibb.lbbc.model.NewProject;
import br.unesp.ibb.lbbc.model.PPI;
import br.unesp.ibb.lbbc.model.REG;
import br.unesp.ibb.lbbc.persistence.Entidade;

public class PopulateInitialDatabase {

	
	public PopulateInitialDatabase() {
		Entidade ent = new Entidade();
		
	}

	
	public void populateGenome(String projectName){
		
		Entidade ent = new Entidade();
		NewProject fileName = (NewProject) ent.findProjectByName(projectName);
		try {
			FileReader fileGenome = new FileReader(fileName.getFileGenome());
			BufferedReader in = new BufferedReader(fileGenome);
			String str;
			int i = 1;
			while (in.ready()) {
				str = in.readLine();
				String[] dado = str.split("\t");
				Gene gene = new Gene();
				gene.setId(i);
				gene.setName(dado[0]);
				gene.setPercolation(0.0);
			
				ent.inserirObjeto(gene);
				i = i + 1;
			}
			in.close();
		} catch (IOException e) {
		}
		ent.close();
	}
	
	public void populatePPI(String projectName) {
		Entidade ent = new Entidade();
		NewProject fileName = (NewProject) ent.findProjectByName(projectName);
		try {
			FileReader filePpi = new FileReader(fileName.getFilePPI());
			BufferedReader in = new BufferedReader(filePpi);
			String str;
			int i = 1;
			while (in.ready()) {
				str = in.readLine();
				String[] dado = str.split("\t");
				PPI ppi = new PPI();

				Gene gene1 = (Gene) ent.findGeneByName(dado[0]);
				Gene gene2 = (Gene) ent.findGeneByName(dado[1]);				

				ppi.setId(i);
				ppi.setGene1(gene1);
				ppi.setGene2(gene2);

				ent.inserirObjeto(ppi);
				i = i + 1;
			}
			in.close();
			ent.close();
		} catch (IOException e) {
		}

	}

	
	public void populateREG(String projectName) {
		
		Entidade ent = new Entidade();
		NewProject fileName = (NewProject) ent.findProjectByName(projectName);
		Boolean inhibits = true;
		try {
			
			FileReader fileReg = new FileReader(fileName.getFileREG());
			BufferedReader in = new BufferedReader(fileReg);
			String str;
			int i = 1;
			while (in.ready()) {
				str = in.readLine();
				String[] dado = str.split("\t");
				REG reg = new REG();

				
				try {
					Gene gene1 = (Gene) ent.findGeneByName(dado[0]);
					Gene gene2 = (Gene) ent.findGeneByName(dado[1]);
				//	if (dado[2].contains("-")){inhibits = false;}
				//	else {inhibits = true;}
					reg.setId(i);
					reg.setGene1(gene1);
					reg.setGene2(gene2);
					reg.setActivates(true);

					ent.inserirObjeto(reg);
					i = i + 1;
					
					
					
				} catch (NonUniqueResultException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(dado[0]+" e "+dado[1]);
					
				}
				
				
			}
			in.close();
			ent.close();
		} catch (IOException e) {
		}

	}

	
	public void populateMET(String projectName) {
		Entidade ent = new Entidade();
		NewProject fileName = (NewProject) ent.findProjectByName(projectName);
		try {
			FileReader fileMet = new FileReader(fileName.getFileMET());
			BufferedReader in = new BufferedReader(fileMet);
			String str;
			int i = 1;
			while (in.ready()) {
				str = in.readLine();
				String[] dado = str.split("\t");
				MET met = new MET();

				Gene gene1 = (Gene) ent.findGeneByName(dado[0]);
				Gene gene2 = (Gene) ent.findGeneByName(dado[1]);

				met.setId(i);
				met.setGene1(gene1);
				met.setGene2(gene2);

				ent.inserirObjeto(met);
				i = i + 1;
				
			}
			ent.close();
			in.close();
		} catch (IOException e) {
		}

	}
	
	public void populateIngi(){
		Entidade ent =new Entidade();
		List<PPI> ppiList = ent.findAll(PPI.class);
		List<REG> regList = ent.findAll(REG.class);
		List<MET> metList = ent.findAll(MET.class);

		int Id = 1;
		for (PPI elem: ppiList){
			Ingi ingi = new Ingi();
			ingi.setId(Id);
			ingi.setGeneA(elem.getGene1());
			ingi.setGeneB(elem.getGene2());
			ent.inserirObjeto(ingi);
			Id = Id+1;
		}
		
		for (REG elem: regList){
			Ingi ingi = new Ingi();
			ingi.setId(Id);
			ingi.setGeneA(elem.getGene1());
			ingi.setGeneB(elem.getGene2());
			ent.inserirObjeto(ingi);
			Id = Id+1;
		}
		
		for (MET elem: metList){
			Ingi ingi = new Ingi();
			ingi.setId(Id);
			ingi.setGeneA(elem.getGene1());
			ingi.setGeneB(elem.getGene2());
			ent.inserirObjeto(ingi);
			Id = Id+1;
		}
		ent.close();
	}
}
