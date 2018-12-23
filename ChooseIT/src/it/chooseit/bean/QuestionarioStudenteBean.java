package it.chooseit.bean;

import java.io.Serializable;

public class QuestionarioStudenteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int registro_id;
	private int pdt_1;
	private int pdt_2;
	private int pdt_3;
	private int pdt_4;
	private int t_1;
	private int t_2;
	private int t_3;
	private int t_4;
	private int su_1;
	private int su_2;
	private int su_3;
	
	public QuestionarioStudenteBean() {
		
	}

	public int getRegistroId() {
		return registro_id;
	}

	public void setRegistroId(int registro_id) {
		this.registro_id = registro_id;
	}

	public int getPdt1() {
		return pdt_1;
	}

	public void setPdt1(int pdt_1) {
		this.pdt_1 = pdt_1;
	}

	public int getPdt2() {
		return pdt_2;
	}

	public void setPdt2(int pdt_2) {
		this.pdt_2 = pdt_2;
	}

	public int getPdt3() {
		return pdt_3;
	}

	public void setPdt3(int pdt_3) {
		this.pdt_3 = pdt_3;
	}

	public int getPdt4() {
		return pdt_4;
	}

	public void setPdt4(int pdt_4) {
		this.pdt_4 = pdt_4;
	}

	public int getT1() {
		return t_1;
	}

	public void setT1(int t_1) {
		this.t_1 = t_1;
	}

	public int getT2() {
		return t_2;
	}

	public void setT2(int t_2) {
		this.t_2 = t_2;
	}

	public int getT3() {
		return t_3;
	}

	public void setT3(int t_3) {
		this.t_3 = t_3;
	}

	public int getT4() {
		return t_4;
	}

	public void setT4(int t_4) {
		this.t_4 = t_4;
	}

	public int getSu1() {
		return su_1;
	}

	public void setSu1(int su_1) {
		this.su_1 = su_1;
	}

	public int getSu2() {
		return su_2;
	}

	public void setSu2(int su_2) {
		this.su_2 = su_2;
	}

	public int getSu3() {
		return su_3;
	}

	public void setSu3(int su_3) {
		this.su_3 = su_3;
	}
	
	
}
