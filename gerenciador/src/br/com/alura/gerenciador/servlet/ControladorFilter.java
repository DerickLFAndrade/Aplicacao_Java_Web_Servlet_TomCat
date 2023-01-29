package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;


public class ControladorFilter extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 1L;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException{
	}
	
	@Override
	public void destroy() {		
	}
	

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("ControladorFilter");
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
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
