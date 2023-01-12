package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class AlteraEmpresa implements Acao {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer paramId = Integer.parseInt(request.getParameter("id"));
		String nomeEmpresa = request.getParameter("nome");
		Date dataAbertura;
		
		try {
			dataAbertura = sdf.parse(request.getParameter("dataAbertura"));;
			Banco banco = new Banco();
			banco.alteraEmpresa(paramId, nomeEmpresa, dataAbertura);
			System.out.println(paramId);
			System.out.println(nomeEmpresa);
			System.out.println(dataAbertura);
			
			return "redirect:entrada?acao=ListaEmpresas";
		} catch (ParseException e) {
			throw new ServletException(e);
		}
	}
	
}
