package br.com.projeto.cadastroDeClientes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConexaoDB extends Credenciais{

    Credenciais credenciais = new Credenciais();

    List<String> primeiroNome = new ArrayList<>();
    List<String> sobrenome = new ArrayList<>();
    List<String> cpf  = new ArrayList<>();
    List<String> email = new ArrayList<>();
    List<String> numeroCel = new ArrayList<>();
    List<String> empresa = new ArrayList<>();
    List<String> cidade = new ArrayList<>();

    public List<String> getEmpresa() {
        return empresa;
    }

    public List<String> getCidade() {
        return cidade;
    }

    public List<String> getPrimeiroNome() {
        return primeiroNome;
    }

    public List<String> getSobrenome() {
        return sobrenome;
    }

    public List<String> getCpf() {
        return cpf;
    }

    public List<String> getEmail() {
        return email;
    }

    public List<String> getNumeroCel() {
        return numeroCel;
    }

    public void startConexao() throws SQLException{

        Connection conexao = null;
        try {
            Class.forName(DRIVE);
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            ResultSet rsCliente = conexao.createStatement().executeQuery("SELECT * FROM dadoscliente");

            while (rsCliente.next()) {
                
                this.primeiroNome.add(rsCliente.getString("primeiroNome"));
                this.sobrenome.add(rsCliente.getString("sobrenome"));
                this.cpf.add(rsCliente.getString("cpf"));
                this.email.add(rsCliente.getString("email"));
                this.numeroCel.add(rsCliente.getString("numeroCel"));
                this.empresa.add(rsCliente.getString("empresa"));
                this.cidade.add(rsCliente.getString("cidade"));
            }
               
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conexao != null){
                conexao.close();
            }
        }
    }
}
