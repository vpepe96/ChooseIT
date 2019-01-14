package it.chooseit.test.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.chooseit.bean.AziendaBean;
import it.chooseit.impl.Azienda;

class AziendaTest {
  
  private static Azienda classUnderTest;
  private static AziendaBean bean;
  private static String ragioneSociale;
  
  @BeforeAll
  static void setUp() throws Exception {
    classUnderTest = new Azienda();
    
    ragioneSociale = "KeyBiz";
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
   
   AziendaBean b = new AziendaBean();
   b.setRagioneSociale(ragioneSociale+1);
   b.setSedeLegale("Firenze");
   b.setSedeOperativa("Padova");
   b.setProgettoFormativo(" ");
   boolean deleted = classUnderTest.delete(b.getRagioneSociale());
   assertFalse(deleted);
  }
  
  @AfterAll
  static void tearDown() throws Exception {
    classUnderTest.delete(ragioneSociale);
  }

}
