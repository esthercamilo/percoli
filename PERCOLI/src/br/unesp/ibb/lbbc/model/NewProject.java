package br.unesp.ibb.lbbc.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;



@Entity

@NamedQueries({
	@NamedQuery(name = "findProjectByName", query = "SELECT c FROM NewProject c WHERE c.name =:nameProject")

}) 
    
 
public class NewProject {

	@Id
	String name;
	String directory;
	String fileGenome;
	String filePPI;
	String fileREG;
	String fileMET;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDirectory() {
		return directory;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	public String getFileGenome() {
		return fileGenome;
	}
	public void setFileGenome(String fileGenome) {
		this.fileGenome = fileGenome;
	}
	public String getFilePPI() {
		return filePPI;
	}
	public void setFilePPI(String filePPI) {
		this.filePPI = filePPI;
	}
	public String getFileREG() {
		return fileREG;
	}
	public void setFileREG(String fileREG) {
		this.fileREG = fileREG;
	}
	public String getFileMET() {
		return fileMET;
	}
	public void setFileMET(String fileMET) {
		this.fileMET = fileMET;
	}
	
	
	
	
	
	
	
}
