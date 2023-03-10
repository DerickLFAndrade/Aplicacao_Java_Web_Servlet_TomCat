package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class RemoveEmpresa  implements Acao {
	
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer paramId = Integer.parseInt(request.getParameter("id"));
		System.out.println(paramId);
		
		Banco banco = new Banco();
		banco.removerEmpresa(paramId);
		return "redirect:entrada?acao=ListaEmpresas";
	}
}
