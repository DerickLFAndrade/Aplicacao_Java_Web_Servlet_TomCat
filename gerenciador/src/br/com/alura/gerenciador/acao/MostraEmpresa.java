package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer paramId = Integer.parseInt(request.getParameter("id"));
		
		Banco banco = new Banco();
		
		Empresa empresa = banco.buscaEmpresaPelaId(paramId);
		
		System.out.println(empresa);
		
		request.setAttribute("empresa", empresa);
		
		return "forward:formAlteraEmpresa.jsp";
		
	}
}
