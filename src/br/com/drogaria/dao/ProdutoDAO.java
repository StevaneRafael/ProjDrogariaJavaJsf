package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.drogaria.domain.Produto;
import br.com.drogaria.factory.ConexaoFactory;

public class ProdutoDAO {
	public void salvar(Produto p) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO produto ");
		sql.append("(descricao, preco, quantidade, fabricante_codigo) ");
		sql.append("VALUES (?, ?, ?, ?) ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setString(1, p.getDescricao());
		comando.setDouble(2, p.getPreco());
		comando.setDouble(3, p.getQuantidade());
		comando.setLong(4, p.getFabricante().getCodigo());
		
		comando.executeUpdate();
	}	
	
	
	
}
