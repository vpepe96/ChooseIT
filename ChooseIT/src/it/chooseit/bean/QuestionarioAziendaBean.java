package it.chooseit.bean;

import java.io.Serializable;

public class QuestionarioAziendaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int registro_id;
	private int pdt_1;
	private int pdt_2;
	private int pdt_3;
	private int pdt_4;
	private int pdt_5;
	private int eo_1;
	private int eo_2;
	private int eo_3;
	private int eo_4;
	private int eo_5;
	private int su_1;
	private int su_2;
	private int su_3;
	
	public QuestionarioAziendaBean() {
		
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
	
	public int getPdt5() {
		return pdt_5;
	}

	public void setPdt5(int pdt_5) {
		this.pdt_5 = pdt_5;
	}


	public int getEo1() {
		return eo_1;
	}

	public void setEo1(int eo_1) {
		this.eo_1 = eo_1;
	}

	public int getEo2() {
		return eo_2;
	}

	public void setEo2(int eo_2) {
		this.eo_2 = eo_2;
	}

	public int getEo3() {
		return eo_3;
	}

	public void setEo3(int eo_3) {
		this.eo_3 = eo_3;
	}

	public int getEo4() {
		return eo_4;
	}

	public void setEo4(int eo_4) {
		this.eo_4 = eo_4;
	}

	public int getEo5() {
		return eo_5;
	}

	public void setEo5(int eo_5) {
		this.eo_5 = eo_5;
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
