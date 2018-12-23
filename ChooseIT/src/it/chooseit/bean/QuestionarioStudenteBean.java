package it.chooseit.bean;

import java.io.Serializable;

public class QuestionarioStudenteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int registroId;
	private int pdt1;
	private int pdt2;
	private int pdt3;
	private int pdt4;
	private int t1;
	private int t2;
	private int t3;
	private int t4;
	private int su1;
	private int su2;
	private int su3;
	
	public QuestionarioStudenteBean() {
		
	}

	public int getRegistroId() {
		return registroId;
	}

	public void setRegistroId(int registroId) {
		this.registroId = registroId;
	}

	public int getPdt1() {
		return pdt1;
	}

	public void setPdt1(int pdt1) {
		this.pdt1 = pdt1;
	}

	public int getPdt2() {
		return pdt2;
	}

	public void setPdt2(int pdt2) {
		this.pdt2 = pdt2;
	}

	public int getPdt3() {
		return pdt3;
	}

	public void setPdt3(int pdt3) {
		this.pdt3 = pdt3;
	}

	public int getPdt4() {
		return pdt4;
	}

	public void setPdt4(int pdt4) {
		this.pdt4 = pdt4;
	}

	public int getT1() {
		return t1;
	}

	public void setT1(int t1) {
		this.t1 = t1;
	}

	public int getT2() {
		return t2;
	}

	public void setT2(int t2) {
		this.t2 = t2;
	}

	public int getT3() {
		return t3;
	}

	public void setT3(int t3) {
		this.t3 = t3;
	}

	public int getT4() {
		return t4;
	}

	public void setT4(int t4) {
		this.t4 = t4;
	}

	public int getSu1() {
		return su1;
	}

	public void setSu1(int su1) {
		this.su1 = su1;
	}

	public int getSu2() {
		return su2;
	}

	public void setSu2(int su2) {
		this.su2 = su2;
	}

	public int getSu3() {
		return su3;
	}

	public void setSu3(int su3) {
		this.su3 = su3;
	}
	
	
}