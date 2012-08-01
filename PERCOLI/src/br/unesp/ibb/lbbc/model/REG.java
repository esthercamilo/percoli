package br.unesp.ibb.lbbc.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity


public class REG {

	@Id
	@SequenceGenerator(name="reg", initialValue=1, allocationSize=100)
	int id;
	Gene gene1;
	Gene gene2;
	Boolean activates;  //If true, gene1 activates gene2, if false, gene1 inhibits gene2.

	public Boolean getActivates() {
		return activates;
	}

	public void setActivates(Boolean activates) {
		this.activates = activates;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Gene getGene1() {
		return gene1;
	}

	public void setGene1(Gene gene1) {
		this.gene1 = gene1;
	}

	public Gene getGene2() {
		return gene2;
	}

	public void setGene2(Gene gene2) {
		this.gene2 = gene2;
	}
	
}
