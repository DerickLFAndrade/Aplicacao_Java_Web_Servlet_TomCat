package br.com.alura.cliente;

import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

public class ClienteWebService {

	public static void main(String[] args) {
		
		Request.Post("http://targethost/login")
	    .bodyForm(Form.form().add("username",  "vip").add("password",  "secret").build())
	    .execute().returnContent();
		
	}

}
