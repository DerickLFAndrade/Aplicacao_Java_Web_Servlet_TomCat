package br.com.alura.gerenciador.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class ListaEmpresas {
	
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Listando empresa");
		Banco banco = new Banco();
		List<Empresa> empresasList= banco.getEmpresas();
		request.setAttribute("empresas", empresasList);
		RequestDispatcher rw =  request.getRequestDispatcher("/listaEmpresas.jsp");
		rw.forward(request, response);
		
	}
}
