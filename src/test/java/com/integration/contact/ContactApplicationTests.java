package com.integration.contact;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.integration.model.Contact;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContactApplicationTests {

	private static final String URI = "http://localhost:8080";
	private static final String ANY_STRING = "ANY";
	private static final String ID = "5ba73398427f204034c0bd9d";

	/*
	 * @Autowired private ContactRepository contactRepository;
	 */

	@Test
	public void getContacts() {
		RestTemplate restTemplate = new RestTemplate();
		String resultado = restTemplate.getForObject(URI + "/contacts", String.class);
		System.out.println("Lista de Contactos " + resultado);
	}

	@Test
	public void createContact() {
		RestTemplate restTemplate = new RestTemplate();
		Contact result = restTemplate.postForObject(URI + "/contact", mockContact(), Contact.class);
		System.out.println("New Contacto " + result);
	}
	
	@Test
	public void getContactsId() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", ID);
		RestTemplate restTemplate = new RestTemplate();
		Contact result = restTemplate.getForObject(URI + "/contact/{id}",Contact.class, params);
		System.out.println("El registro es: " + result);
		
	}
	
	@Test
	public void deleteContact() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", ID);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(URI + "/contact/{id}", params);
		System.out.println("contacto removido");
	}

	private Contact mockContact() {
		Contact contact = new Contact();

		contact.setName(ANY_STRING);
		contact.setLastname(ANY_STRING);
		contact.setEmail(ANY_STRING);
		contact.setCiudad(ANY_STRING);

		return contact;
	}

}
