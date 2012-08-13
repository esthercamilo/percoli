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
	@NamedQuery(name = "findGeneByName", query = "SELECT c FROM Gene c WHERE c.COMMONNAME =:nameGene")

})

public class Gene {

	@SequenceGenerator(name="gene", initialValue=1, allocationSize=100)
	@Id
	String UNIQUEID;
	String TYPES;
	String COMMONNAME;
	String ACCESSION1;
	String ACCESSION2;
	String CENTISOMEPOSITION;
	String CITATIONS;
	String COMMENT;
	String COMPONENTOF;
	String CREDITS;
	String DATASOURCE;
	String DBLINKS;
	String DOCUMENTATION;
	String HIDESLOT;
	String INPARALOGOUSGENGROUP;
	String INTERRUPTED;
	String KNOCKOUTGROWTHOBSERVATIONS;
	long LASTUPDATE;
	long LEFTENDPOSITION;
	String MEMBERSORTFN;
	String PRODUCT;
	String REGULATEDBY;
	long RIGHTENDPOSITION;
	String SYNCWORTHOLOG;
	String SYNONYMS;
	String TRANSCRIPTIONDIRECTION;
	double damage;
	public String getUNIQUEID() {
		return UNIQUEID;
	}
	public void setUNIQUEID(String uNIQUEID) {
		UNIQUEID = uNIQUEID;
	}
	public String getTYPES() {
		return TYPES;
	}
	public void setTYPES(String tYPES) {
		TYPES = tYPES;
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
	public String getCITATIONS() {
		return CITATIONS;
	}
	public void setCITATIONS(String cITATIONS) {
		CITATIONS = cITATIONS;
	}
	public String getCOMMENT() {
		return COMMENT;
	}
	public void setCOMMENT(String cOMMENT) {
		COMMENT = cOMMENT;
	}
	public String getCOMPONENTOF() {
		return COMPONENTOF;
	}
	public void setCOMPONENTOF(String cOMPONENTOF) {
		COMPONENTOF = cOMPONENTOF;
	}
	public String getCREDITS() {
		return CREDITS;
	}
	public void setCREDITS(String cREDITS) {
		CREDITS = cREDITS;
	}
	public String getDATASOURCE() {
		return DATASOURCE;
	}
	public void setDATASOURCE(String dATASOURCE) {
		DATASOURCE = dATASOURCE;
	}
	public String getDBLINKS() {
		return DBLINKS;
	}
	public void setDBLINKS(String dBLINKS) {
		DBLINKS = dBLINKS;
	}
	public String getDOCUMENTATION() {
		return DOCUMENTATION;
	}
	public void setDOCUMENTATION(String dOCUMENTATION) {
		DOCUMENTATION = dOCUMENTATION;
	}
	public String getHIDESLOT() {
		return HIDESLOT;
	}
	public void setHIDESLOT(String hIDESLOT) {
		HIDESLOT = hIDESLOT;
	}
	public String getINPARALOGOUSGENGROUP() {
		return INPARALOGOUSGENGROUP;
	}
	public void setINPARALOGOUSGENGROUP(String iNPARALOGOUSGENGROUP) {
		INPARALOGOUSGENGROUP = iNPARALOGOUSGENGROUP;
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
	public long getLASTUPDATE() {
		return LASTUPDATE;
	}
	public void setLASTUPDATE(long lASTUPDATE) {
		LASTUPDATE = lASTUPDATE;
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
	public String getSYNCWORTHOLOG() {
		return SYNCWORTHOLOG;
	}
	public void setSYNCWORTHOLOG(String sYNCWORTHOLOG) {
		SYNCWORTHOLOG = sYNCWORTHOLOG;
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


	
	
}
