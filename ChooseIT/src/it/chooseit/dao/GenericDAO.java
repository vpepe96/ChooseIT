package it.chooseit.dao;

import java.sql.SQLException;
import java.util.Collection;

/***
 * Definisce l'interfaccia che tutti i DAO dovranno esporre
 * */
public interface GenericDAO<T,S> {

  /**
   * Restituisce un oggetto di tipo T in base al codice.
   * @param key chiave dell'elemento che si vuole ottenere
   * @return T oggetto contenente i dati dell'elemento desiderato
   * */
  public T retrieveByKey(S key) throws SQLException;

  /**
   * Restituisce tutti gli elementi di tipo T nel DB.
   * @param order parametro in base al quale ordinare la collezione restituita
   * @return Collection<T> collezione contenente tutti gli oggetti del tipo desiderato
   * */
  public Collection<T> retrieveAll(String order) throws SQLException; 

  /**
   * Inserisce un oggetto di tipo T.
   * @param object elemento che si desidera salvare nel DB
   * */
  public void insert(T object) throws SQLException;

  /**
   * Aggiorna un oggetto di tipo T.
   * @param object elemento che si desidera aggiornare nel DB
   * */
  public void update(T object) throws SQLException;

  /**
   * Elimina un oggetto di tipo T in base al codice.
   * @param key codice dell'elemento che si vuole eliminare
   * @return boolean true se l'oggetto &egrave; stato eliminato, false altrimenti
   * */
  public boolean delete(S key) throws SQLException;

}
