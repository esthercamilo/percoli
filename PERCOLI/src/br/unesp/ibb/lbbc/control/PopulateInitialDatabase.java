package br.unesp.ibb.lbbc.control;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NonUniqueResultException;
import javax.swing.JOptionPane;

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

	public void populateGenome(String projectName) {

		/*
		 * Entidade ent = new Entidade(); NewProject fileName = (NewProject)
		 * ent.findProjectByName(projectName); try { FileReader fileGenome = new
		 * FileReader(fileName.getFileGenome()); BufferedReader in = new
		 * BufferedReader(fileGenome); String str; int i = 1; while (in.ready())
		 * { str = in.readLine(); String[] dado = str.split("\t"); Gene gene =
		 * new Gene(); gene.setId(i); gene.setName(dado[0]);
		 * gene.setPercolation(0.0);
		 * 
		 * ent.inserirObjeto(gene); i = i + 1; } in.close(); } catch
		 * (IOException e) { } ent.close();
		 */
	}

	public void populatePPI(String projectName) {
		Entidade ent = new Entidade();
		NewProject fileName = (NewProject) ent.findProjectByName(projectName);
		ArrayList<String> missingGenes = new ArrayList<>();
		try {
			FileReader filePpi = new FileReader(fileName.getFilePPI());
			BufferedReader in = new BufferedReader(filePpi);
			String str;
			int i = 1;
			while (in.ready()) {
				str = in.readLine();
				String[] dado = str.split("\t");
				PPI ppi = new PPI();
				System.out.println("dado[0]: "+dado[0]+"\t"+"dado[1]: "+dado[1]);
				
				
				try {
					Gene gene1 = (Gene) ent.findGeneByName(dado[0]);
					Gene gene2 = (Gene) ent.findGeneByName(dado[1]);
					ppi.setId(i);
					ppi.setGene1(gene1);
					ppi.setGene2(gene2);
					ent.inserirObjeto(ppi);
					i = i + 1;
					
				} catch (Exception e) {
					missingGenes.add(e.getLocalizedMessage());
					
				}
		}
			in.close();
			ent.close();
		} catch (IOException e) {
		}
		
		for (String elem:missingGenes){
			System.out.println(elem);
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
					Gene gene1 = (Gene) ent.findGeneByName(dado[0].replaceAll("\\s",""));
					Gene gene2 = (Gene) ent.findGeneByName(dado[1].replaceAll("\\s",""));
					// if (dado[2].contains("-")){inhibits = false;}
					// else {inhibits = true;}
					reg.setId(i);
					reg.setGene1(gene1);
					reg.setGene2(gene2);
					reg.setActivates(true);

					ent.inserirObjeto(reg);
					i = i + 1;

				} catch (Exception e) {
					System.out.println(dado[0]+" or "+dado[1]);
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

				try {
					Gene gene1 = (Gene) ent.findGeneByName(dado[0]);
					Gene gene2 = (Gene) ent.findGeneByName(dado[1]);
					met.setId(i);
					met.setGene1(gene1);
					met.setGene2(gene2);
					ent.inserirObjeto(met);
					i = i + 1;
				} catch (Exception e) {
					
					try {
						Gene gene1 = (Gene) ent.findGeneBySynonym(dado[0]);
						Gene gene2 = (Gene) ent.findGeneBySynonym(dado[1]);

						met.setId(i);
						met.setGene1(gene1);
						met.setGene2(gene2);

						ent.inserirObjeto(met);
						i = i + 1;
					} catch (Exception e1) {
						//JOptionPane.showMessageDialog(null,"Missing one of the genes interacting\n "+dado[0]+" or "+dado[1]);
						System.out.println( dado[0]+" or "+dado[1]);
					}
					
					
				}

			}
			ent.close();
			in.close();
		} catch (IOException e) {
		}

	}

	public void populateIngi() {
		Entidade ent = new Entidade();
		List<PPI> ppiList = ent.findAll(PPI.class);
		List<REG> regList = ent.findAll(REG.class);
		List<MET> metList = ent.findAll(MET.class);

		int Id = 1;
		for (PPI elem : ppiList) {
			Ingi ingi = new Ingi();
			ingi.setId(Id);
			ingi.setGeneA(elem.getGene1());
			ingi.setGeneB(elem.getGene2());
			ent.inserirObjeto(ingi);
			Id = Id + 1;
		}

		for (REG elem : regList) {
			Ingi ingi = new Ingi();
			ingi.setId(Id);
			ingi.setGeneA(elem.getGene1());
			ingi.setGeneB(elem.getGene2());
			ent.inserirObjeto(ingi);
			Id = Id + 1;
		}

		for (MET elem : metList) {
			Ingi ingi = new Ingi();
			ingi.setId(Id);
			ingi.setGeneA(elem.getGene1());
			ingi.setGeneB(elem.getGene2());
			ent.inserirObjeto(ingi);
			Id = Id + 1;
		}
		ent.close();
	}

	/**
	 * Populate database from genes.dat
	 * */

	public void populateGeneFromEcocyc(String file) {
		FileReader fileReader;
		BufferedReader in;
		Gene gene = Gene.initGene();
		try {
			
			fileReader = new FileReader(file);
			in = new BufferedReader(fileReader);
			while (in.ready()) {
				String a = in.readLine();
				if (0 == a.indexOf("#")) {
					continue;
				} else if (0 == a.indexOf("//")) {
					Entidade ent = new Entidade();
					ent.inserirObjeto(gene);
					gene = Gene.initGene();
					
									
					
				} else {
					//String str = in.readLine();
					String[] dado = a.split(" - ");
					System.out.println(dado[0]);			
					switch (dado[0]) {
					case "UNIQUE-ID":
						gene.setUNIQUEID(dado[1]);
						break;

					case "COMMON-NAME":
						gene.setCOMMONNAME(dado[1].toLowerCase());
						break;

					case "ACCESSION-1":
						gene.setACCESSION1(dado[1]);
						break;
	
					case "ACCESSION-2":
						gene.setACCESSION2(dado[1]);
						break;
		
					case "CENTISOME-POSITION":
						gene.setCENTISOMEPOSITION(dado[1]);
						break;
	
					case "IN-PARALOGOUS-GEN-GROUP":
						gene.setINPARALOGOUSGENEGROUP(dado[1]);
						break;
						
					case "INTERRUPTED":
						gene.setINTERRUPTED(dado[1]);
						break;
						
					case "KNOCKOUT-GROWTH-OBSERVATIONS":
						gene.setKNOCKOUTGROWTHOBSERVATIONS(dado[1]);
						break;
						
						
					case "LEFT-END-POSITION":
						gene.setLEFTENDPOSITION(Long.parseLong(dado[1]));
						break;
						
					case "MEMBER-SORT-FN":
						gene.setMEMBERSORTFN(dado[1]);
						break;
						
					case "PRODUCT":
						gene.setPRODUCT(dado[1]);
						break;
					
					case "REGULATED-BY":
						gene.setREGULATEDBY(dado[1]);
						break;
					
						
					case "RIGHT-END-POSITION":
						gene.setRIGHTENDPOSITION(Long.parseLong(dado[1]));
						break;
					
						
					case "SYNONYMS":
						gene.setSYNONYMS(dado[1]);
						break;
					
					case "TRANSCRIPTION-DIRECTION":
						gene.setTRANSCRIPTIONDIRECTION(dado[1]);
						break;				
						
					default:
						
						break;
					}
				}
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"Gene file not found");
			e.printStackTrace(); 
		}

	}
}
