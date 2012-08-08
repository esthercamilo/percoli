package br.unesp.ibb.lbbc.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.persistence.NonUniqueResultException;
import javax.swing.JOptionPane;

import br.unesp.ibb.lbbc.model.Gene;
import br.unesp.ibb.lbbc.model.MET;
import br.unesp.ibb.lbbc.model.NewProject;
import br.unesp.ibb.lbbc.model.PPI;
import br.unesp.ibb.lbbc.model.REG;
import br.unesp.ibb.lbbc.persistence.Entidade;

public class PopulateInitialDatabase {

	String projectName;
	
	public PopulateInitialDatabase(String projectName) {
		this.projectName = projectName;
	}

	
	public void populateGenome(){
		Entidade ent = new Entidade();
		NewProject fileName = (NewProject) ent.findProjectByName(projectName);
		JOptionPane.showMessageDialog(null, fileName);
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
		
	}
	
	public void populatePPI() {
		Entidade ent = new Entidade();
		NewProject fileName = (NewProject) ent.findProjectByName(projectName);
		JOptionPane.showMessageDialog(null, fileName);
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
		} catch (IOException e) {
		}

	}

	
	public void populateREG() {
		Entidade ent = new Entidade();
		NewProject fileName = (NewProject) ent.findProjectByName(projectName);
		JOptionPane.showMessageDialog(null, fileName);
		Boolean inhibits = true;
		try {
			
			FileReader fileReg = new FileReader(fileName.getFileREG());
			BufferedReader in = new BufferedReader(fileReg);
			String str;
			int i = 1;
			while (in.ready()) {
				str = in.readLine();
				String[] dado = str.split(",");
				REG reg = new REG();

				
				Gene gene1;
				Gene gene2;
				
				try {
					gene1 = (Gene) ent.findGeneByName(dado[0]);
					gene2 = (Gene) ent.findGeneByName(dado[1]);
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
		} catch (IOException e) {
		}

	}

	
	public void populateMET() {
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
			in.close();
		} catch (IOException e) {
		}

	}
	
}
