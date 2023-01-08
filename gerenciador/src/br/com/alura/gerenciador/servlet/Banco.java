package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Banco {
	
	private static List<Empresa> listEmpresa = new ArrayList<>();
	
	static {
		  Empresa empresa = new Empresa(1, "Alura", new Date());
		  Empresa empresa2 = new Empresa(2, "Caelum", new Date());
		  Banco.listEmpresa.add(empresa);
		  Banco.listEmpresa.add(empresa2);
		}
	
	public void addEmpresa(Empresa emp) {
		Banco.listEmpresa.add(emp);
	}
	public List<Empresa> getEmpresas(){
		return Banco.listEmpresa;
	}
}
