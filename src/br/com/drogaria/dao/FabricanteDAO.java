package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.factory.ConexaoFactory;

public class FabricanteDAO {
	public void salvar(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fabricante ");
		sql.append("(descricao) ");
		sql.append("VALUES (?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());

		comando.executeUpdate();

	}

	public static void main(String[] args) {
		Fabricante f1 = new Fabricante();
		f1.setDescricao("DESCRICAO 1");
		
		Fabricante f2 = new Fabricante();
		f2.setDescricao("DESCRICAO 2");
		
		FabricanteDAO fdao = new FabricanteDAO();
		
		try {
			fdao.salvar(f1);
			fdao.salvar(f2);
			System.out.println("Os fabricantes foram salvos com sucesso!");
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao tentar salvar um dos fabricantes!");
			e.printStackTrace();
		}
		
		
	}

}
