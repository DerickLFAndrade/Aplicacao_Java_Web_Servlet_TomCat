package client_webservice;

import org.apache.http.client.fluent.Request;

public class ClientWebService {

	public static void main(String[] args) {
		
		Request.Post("http://targethost/login")
	    .bodyForm(Form.form().add("username",  "vip").add("password",  "secret").build())
	    .execute().returnContent();

	}

}
