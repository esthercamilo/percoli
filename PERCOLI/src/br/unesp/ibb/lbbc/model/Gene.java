package br.unesp.ibb.lbbc.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

//@Embeddable
@Entity

@NamedQueries({
	@NamedQuery(name = "findGeneByName", query = "SELECT c FROM Gene c WHERE c.name =:nameGene")

})

public class Gene {

	@SequenceGenerator(name="gene", initialValue=1, allocationSize=100)
	@Id
	int id;
	String name;
	Double percolation;

	public Double getPercolation() {
		return percolation;
	}

	public void setPercolation(Double percolation) {
		this.percolation = percolation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
