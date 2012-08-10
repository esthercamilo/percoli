package br.unesp.ibb.lbbc.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ingi
 *
 */
@Entity

public class Ingi implements Serializable {

	   
	@Id
	private int Id;
	private Gene geneA;
	private Gene geneB;
	private static final long serialVersionUID = 1L;

	public Ingi() {
		super();
	}   
	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}   
	public Gene getGeneA() {
		return this.geneA;
	}

	public void setGeneA(Gene geneA) {
		this.geneA = geneA;
	}   
	public Gene getGeneB() {
		return this.geneB;
	}

	public void setGeneB(Gene geneB) {
		this.geneB = geneB;
	}
   
}
