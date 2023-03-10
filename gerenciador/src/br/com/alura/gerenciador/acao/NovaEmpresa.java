package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class NovaEmpresa implements Acao{
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeEmpresa = request.getParameter("nome");
		Date dataAbertura;
		try {
			dataAbertura = sdf.parse(request.getParameter("dataAbertura"));
			Empresa empresa = new Empresa(1, nomeEmpresa, dataAbertura);
			Banco banco = new Banco();
			banco.addEmpresa(empresa);
			System.out.println("Cadastrando nova empresa");
			return "redirect:entrada?acao=ListaEmpresas";
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
	
	}
	
}
