package it.chooseit.services;

import java.sql.Date;

import it.chooseit.bean.RegistroTirocinioBean;

public class ReportKey {
  private RegistroTirocinioBean registro;
  private Date data;



  public ReportKey(RegistroTirocinioBean registro, Date data) {
    super();
    this.registro = registro;
    this.data = data;
  }


  public RegistroTirocinioBean getRegistro() {
    return registro;
  }
  public void setRegistro(RegistroTirocinioBean registro) {
    this.registro = registro;
  }
  public Date getData() {
    return data;
  }
  public void setData(Date data) {
    this.data = data;
  }



}
