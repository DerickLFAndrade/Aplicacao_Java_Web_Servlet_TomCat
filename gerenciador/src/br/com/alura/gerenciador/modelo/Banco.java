package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> listEmpresa = new ArrayList<>();
	private static List<Usuario> listUsuarios = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	static {
		  Empresa empresa = new Empresa(chaveSequencial++, "Alura", new Date());
		  Empresa empresa2 = new Empresa(chaveSequencial++, "Caelum", new Date());
		  Banco.listEmpresa.add(empresa);
		  Banco.listEmpresa.add(empresa2);
		  
		  Usuario user1 = new Usuario("Derick", "senha123");
		  Usuario user2 = new Usuario("Lucas", "senha1234");
		  
		  Banco.listUsuarios.add(user1);
		  Banco.listUsuarios.add(user2);
		  
		}
	
	public static List<Empresa> getListEmpresa() {
		return listEmpresa;
	}

	public void addEmpresa(Empresa emp) {
		emp.setId(Banco.chaveSequencial++);
		Banco.listEmpresa.add(emp);
	}
	public List<Empresa> getEmpresas(){
		return Banco.listEmpresa;
	}
	public void removerEmpresa(Integer id) {
		
		Iterator<Empresa> it = listEmpresa.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			
			if(emp.getId() == id) {				
				it.remove();
			}
		}
	}

	public Empresa buscaEmpresaPelaId(Integer id) {
		
		for(Empresa empresa : listEmpresa) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		
		return null;
	}
	
	public void alteraEmpresa(Integer id, String nome, Date dataAbertura) {
			Iterator<Empresa> it = listEmpresa.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			
			if(emp.getId() == id) {				
				emp.setDataAbertura(dataAbertura);
				emp.setNome(nome);
			}
		}
	}
	
	public Usuario existeUsuraio (String login, String senha) {
		for(Usuario usuario : listUsuarios) {
			if(usuario.equalsUs(login, senha)) {
				return usuario;
			}
		}
		return null;
		
	}
}
