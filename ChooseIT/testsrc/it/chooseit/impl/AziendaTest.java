package it.chooseit.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.chooseit.bean.AziendaBean;

class AziendaTest {
  
  private static Azienda classUnderTest;
  private static AziendaBean bean;
  private static String ragioneSociale;
  
  @BeforeEach
  void setUp() throws Exception {
    classUnderTest = new Azienda();
 
    ArrayList<AziendaBean> list = (ArrayList<AziendaBean>) classUnderTest.retrieveAll(null);
    int id = 0;
    for (AziendaBean aziendaBean : list) {
      id++;
    }
    
    ragioneSociale = "KeyBiz" + id;
    bean = new AziendaBean(ragioneSociale, "", "via Napoli", "via Napoli", null, null);
    
    assertNotNull(classUnderTest, "La classe classUnderTest è null");
    classUnderTest.insert(bean);
  }

  
  /**
   * Testa il metodo retrieveBtKey con un'azienda presente nel db.
   * @throws Exception 
   */
  @Test
  void testRetrieveByKeyAziendaInDB() throws Exception {
    System.out.println("retrieveByKey");
    
    AziendaBean b = classUnderTest.retrieveByKey(ragioneSociale);
    assertNotNull(b);
  }
  
  
  /**
   * Testa il metodo retrieveByKey con un'azienda non presente nel db.
   * @throws Exception
   */
  @Test
  void testRetrieveByKeyAziendaNonInDB() throws Exception{
   System.out.println("retriveByKey");
   
   AziendaBean b = classUnderTest.retrieveByKey(ragioneSociale+1);
   assertNull(b.getRagioneSociale());
  }
  

  /**
   * Test del metodo retrieveAll senza order.
   * @throws SQLException 
   */
  @Test
  void testRetrieveAllSenzaOrder() throws SQLException {
   System.out.println("retrieveAll");
   
   ArrayList<AziendaBean> list = (ArrayList<AziendaBean>) classUnderTest.retrieveAll(null);
   assertNotNull(list);
  }
  
  /**
   * Test del metodo retrieveAll con order.
   * @throws SQLException 
   */
  @Test
  void testRetrieveAllConOrder() throws SQLException {
   System.out.println("retrieveAll");
   
   ArrayList<AziendaBean> list = (ArrayList<AziendaBean>) classUnderTest.retrieveAll("ragione_sociale");
   assertNotNull(list);
  }

  
  /**
   * Test del metodo insert con un'azienda non presente nel db.
   * @throws Exception
   */
  @Test
  void testInsertAziendaNonInDB() throws Exception {
    System.out.println("insert");
    
    classUnderTest.delete(ragioneSociale);
    classUnderTest.insert(bean);
    AziendaBean b = classUnderTest.retrieveByKey(ragioneSociale);
    assertNotNull(b);
  }

  
  /**
   * Test del metodo insert con un'azienda già presente nel db.
   */
  @Test
  void testInsertAziendaGiaInDB() {
   System.out.println("insert");
   
   boolean exc = false;
   try {
    classUnderTest.insert(bean);
   } catch (SQLException e) {
    exc = true;
   }
   assertTrue(exc);
  }
  
  
  /**
   * Test del metodo update con azienda nel db e dati completi.
   * @throws Exception
   */
  @Test
  void testUpdateAziendaInDB() throws SQLException{
   System.out.println("update");
   
   bean.setSedeLegale("Firenze");
   classUnderTest.update(bean);
   bean = classUnderTest.retrieveByKey(ragioneSociale);
   assertEquals("Firenze", bean.getSedeLegale());
  }
  
  
  /**
   * Test del metodo delete con un'azienda presente nel db.
   * @throws SQLException 
   */
  @Test
  void testDeleteAziendaInDB() throws SQLException {
   System.out.println("delete");
   
   boolean deleted = classUnderTest.delete(bean.getRagioneSociale());
   assertTrue(deleted);
   classUnderTest.insert(bean);
  }

  /**
   * Test del metodo delete con un'azienda non presente nel db.
   * @throws SQLException 
   */
  @Test
  void testDeleteAziendaNonInDB() throws SQLException {
   System.out.println("delete");
   
   bean = new AziendaBean();
   bean.setRagioneSociale("Nextsoft");
   bean.setSedeLegale("Firenze");
   bean.setSedeOperativa("Padova");
   bean.setProgettoFormativo(" ");
   boolean deleted = classUnderTest.delete(bean.getRagioneSociale());
   assertFalse(deleted);
  }

}
