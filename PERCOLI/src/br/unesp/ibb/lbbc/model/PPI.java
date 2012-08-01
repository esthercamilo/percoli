package br.unesp.ibb.lbbc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class PPI {
	
	@Id
	@SequenceGenerator(name="ppi", initialValue=1, allocationSize=100)
	int id;
	Gene gene1;
	Gene gene2;

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
