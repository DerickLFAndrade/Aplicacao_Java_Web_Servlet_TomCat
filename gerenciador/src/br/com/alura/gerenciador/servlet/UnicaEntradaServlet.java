package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;

public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		
		String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;
		String nome;
		
		try {
			Class<?> classe = Class.forName(nomeDaClasse);
			
			@SuppressWarnings("deprecation")
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		}
		catch(ClassNotFoundException | InstantiationException | IllegalAccessException e ) {
			throw new ServletException(e);
		}
		
		
		
		String[] destino = nome.split(":");
	if(destino[0].equals("forward")) {
			RequestDispatcher rw =  request.getRequestDispatcher("WEB-INF/view/" + destino[1]);
			rw.forward(request, response);
			
		}
		else {
			response.sendRedirect(destino[1]);
		}
	}	
	
	

}
