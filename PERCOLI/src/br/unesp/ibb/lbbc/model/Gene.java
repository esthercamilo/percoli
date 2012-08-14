package br.unesp.ibb.lbbc.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import br.unesp.ibb.lbbc.persistence.Entidade;

//@Embeddable
@Entity

@NamedQueries({
	@NamedQuery(name = "findGeneByName", query = "SELECT c FROM Gene c WHERE c.COMMONNAME =:nameGene"),
	@NamedQuery(name = "findGeneBySynonym", query = "SELECT c FROM Gene c WHERE c.SYNONYMS =:synonymGene"),
	

})

public class Gene {

	//@SequenceGenerator(name="gene", initialValue=1, allocationSize=100)
	@Id
	String UNIQUEID;
	String COMMONNAME;
	String ACCESSION1;
	String ACCESSION2;
	String CENTISOMEPOSITION;
	String INPARALOGOUSGENEGROUP;
	String INTERRUPTED;
	String KNOCKOUTGROWTHOBSERVATIONS;
	long LEFTENDPOSITION;
	String MEMBERSORTFN;
	String PRODUCT;
	String REGULATEDBY;
	long RIGHTENDPOSITION;
	String SYNONYMS;
	String TRANSCRIPTIONDIRECTION;
	double damage;
	
	
	
	
	
	
	
	
	public String getUNIQUEID() {
		return UNIQUEID;
	}
	public void setUNIQUEID(String uNIQUEID) {
		UNIQUEID = uNIQUEID;
	}
	public String getCOMMONNAME() {
		return COMMONNAME;
	}
	public void setCOMMONNAME(String cOMMONNAME) {
		COMMONNAME = cOMMONNAME;
	}
	public String getACCESSION1() {
		return ACCESSION1;
	}
	public void setACCESSION1(String aCCESSION1) {
		ACCESSION1 = aCCESSION1;
	}
	public String getACCESSION2() {
		return ACCESSION2;
	}
	public void setACCESSION2(String aCCESSION2) {
		ACCESSION2 = aCCESSION2;
	}
	public String getCENTISOMEPOSITION() {
		return CENTISOMEPOSITION;
	}
	public void setCENTISOMEPOSITION(String cENTISOMEPOSITION) {
		CENTISOMEPOSITION = cENTISOMEPOSITION;
	}
	
	public String getINPARALOGOUSGENEGROUP() {
		return INPARALOGOUSGENEGROUP;
	}
	public void setINPARALOGOUSGENEGROUP(String iNPARALOGOUSGENEGROUP) {
		INPARALOGOUSGENEGROUP = iNPARALOGOUSGENEGROUP;
	}
	public String getINTERRUPTED() {
		return INTERRUPTED;
	}
	public void setINTERRUPTED(String iNTERRUPTED) {
		INTERRUPTED = iNTERRUPTED;
	}
	public String getKNOCKOUTGROWTHOBSERVATIONS() {
		return KNOCKOUTGROWTHOBSERVATIONS;
	}
	public void setKNOCKOUTGROWTHOBSERVATIONS(String kNOCKOUTGROWTHOBSERVATIONS) {
		KNOCKOUTGROWTHOBSERVATIONS = kNOCKOUTGROWTHOBSERVATIONS;
	}
	public long getLEFTENDPOSITION() {
		return LEFTENDPOSITION;
	}
	public void setLEFTENDPOSITION(long lEFTENDPOSITION) {
		LEFTENDPOSITION = lEFTENDPOSITION;
	}
	public String getMEMBERSORTFN() {
		return MEMBERSORTFN;
	}
	public void setMEMBERSORTFN(String mEMBERSORTFN) {
		MEMBERSORTFN = mEMBERSORTFN;
	}
	public String getPRODUCT() {
		return PRODUCT;
	}
	public void setPRODUCT(String pRODUCT) {
		PRODUCT = pRODUCT;
	}
	public String getREGULATEDBY() {
		return REGULATEDBY;
	}
	public void setREGULATEDBY(String rEGULATEDBY) {
		REGULATEDBY = rEGULATEDBY;
	}
	public long getRIGHTENDPOSITION() {
		return RIGHTENDPOSITION;
	}
	public void setRIGHTENDPOSITION(long rIGHTENDPOSITION) {
		RIGHTENDPOSITION = rIGHTENDPOSITION;
	}
	public String getSYNONYMS() {
		return SYNONYMS;
	}
	public void setSYNONYMS(String sYNONYMS) {
		SYNONYMS = sYNONYMS;
	}
	public String getTRANSCRIPTIONDIRECTION() {
		return TRANSCRIPTIONDIRECTION;
	}
	public void setTRANSCRIPTIONDIRECTION(String tRANSCRIPTIONDIRECTION) {
		TRANSCRIPTIONDIRECTION = tRANSCRIPTIONDIRECTION;
	}
	public double getDamage() {
		return damage;
	}
	public void setDamage(double damage) {
		this.damage = damage;
	}


	public static Gene initGene() {
		Gene gene = new Gene();
		gene.setUNIQUEID("");
		gene.setCOMMONNAME("");
		gene.setACCESSION1("");
		gene.setACCESSION2("");
		gene.setCENTISOMEPOSITION("");
		gene.setINPARALOGOUSGENEGROUP("");
		gene.setINTERRUPTED("");
		gene.setKNOCKOUTGROWTHOBSERVATIONS("");
		gene.setLEFTENDPOSITION(0);
		gene.setMEMBERSORTFN("");
		gene.setPRODUCT("");
		gene.setREGULATEDBY("");
		gene.setRIGHTENDPOSITION(0);
		gene.setSYNONYMS("");
		gene.setTRANSCRIPTIONDIRECTION("");
		gene.setDamage(0);
		return gene;
	}
	
	
	
	
	
}
