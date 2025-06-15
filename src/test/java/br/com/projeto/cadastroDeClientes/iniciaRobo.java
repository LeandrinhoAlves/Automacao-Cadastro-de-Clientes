package br.com.projeto.cadastroDeClientes;

import java.sql.SQLException;

public class iniciaRobo {
    public static void main(String[] args) throws SQLException{
        ConexaoDB conexao = new ConexaoDB();
        conexao.startConexao();
        CadastroDeCliente startRobo = new CadastroDeCliente();

        for(int i = 0; i < conexao.getPrimeiroNome().size(); i++) {
            startRobo.iniciaRobo(i);
        }
    }
}