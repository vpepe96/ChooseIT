package it.chooseit.test.services;

import static org.junit.jupiter.api.Assertions.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.junit.jupiter.api.Test;

import it.chooseit.services.GestorePassword;

class GestorePasswordTest {

	/**
	 * Testa il metodo generateStrongPassword su una password valida inserita 
	 * da un utente in fase di registrazione.
	 * @throws Exception 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testGenerateStrongPasswordHash() throws NoSuchAlgorithmException, Exception {
		String password = "passwordditest";
		String hashPwd = GestorePassword.generateStrongPasswordHash(password);
		assertNotNull(hashPwd);
	}

	/**
	 * Testa il metodo validatePassword su una password valida inserita
	 * da un utente in fase di login.
	 * @throws InvalidKeySpecException 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testValidatePasswordValida() throws NoSuchAlgorithmException, InvalidKeySpecException {
		String password = "passwordditest";
		String hashPwd = GestorePassword.generateStrongPasswordHash(password);
		boolean ok = GestorePassword.validatePassword(password, hashPwd);
		assertEquals(true, ok);
	}


	/**
	 * Testa il metodo validatePassword su una password non valida inserita
	 * da un utente in fase di login.
	 * @throws InvalidKeySpecException 
	 * @throws NoSuchAlgorithmException 
	 */
	@Test
	void testValidatePasswordInvalida() throws NoSuchAlgorithmException, InvalidKeySpecException {
		String password = "passwordditest";
		String hashPwd = GestorePassword.generateStrongPasswordHash(password);
		boolean ok = GestorePassword.validatePassword("passwordnonvalida", hashPwd);
		assertEquals(false, ok);
	}

}
