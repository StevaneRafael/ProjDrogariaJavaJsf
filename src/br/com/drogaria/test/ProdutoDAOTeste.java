package br.com.drogaria.test;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;

public class ProdutoDAOTeste {
	@Test
	@Ignore
	public void salvar() throws SQLException {
		Produto p = new Produto();
		p.setDescricao("NOVALGINA COM 10 COMPRIMIDOS");
		p.setPreco(2.45D);
		p.setQuantidade(13L);
		
		Fabricante f = new Fabricante();
		f.setCodigo(20L);
		
		p.setFabricante(f);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.salvar(p);
	}
	
	@Test
	@Ignore
	public void listar() throws SQLException{
		ProdutoDAO dao = new ProdutoDAO();
		ArrayList<Produto> lista = dao.listar();
		
		for(Produto p : lista) {
			System.out.println("C�digo do Produto: " + p.getCodigo());
			System.out.println("Descricao do Produto: " + p.getDescricao());
			System.out.println("Pre�o do Produto: " + p.getPreco());
			System.out.println("Quantidade do Produto: " + p.getQuantidade());
			System.out.println("C�digo do Fabricante: " + p.getFabricante().getCodigo());
			System.out.println("Descri��o do Fabricante: " + p.getFabricante().getDescricao());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void excluir() throws SQLException {
		Produto p = new Produto();
		p.setCodigo(5L);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.excluir(p);
	}
	
	@Test
	public void editar() throws SQLException{
		Produto p = new Produto();
		p.setCodigo(5L);
		p.setDescricao("Cataflan Pomada com 60 Gramas");
		p.setQuantidade(20L);
		p.setPreco(6.30);
		
		Fabricante f = new Fabricante();
		f.setCodigo(6L);
		
		p.setFabricante(f);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.editar(p);
		
	}
	
	
}
