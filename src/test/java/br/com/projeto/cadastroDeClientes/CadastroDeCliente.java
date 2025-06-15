package br.com.projeto.cadastroDeClientes;

import java.sql.SQLException;
import java.time.Duration;
import java.util.Random;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CadastroDeCliente extends Credenciais{
    ConexaoDB dados = new ConexaoDB();
    Random random = new Random();

    @Test
    @DisplayName("Deve cadastrar o cliente")
    void iniciaRobo(int indice) throws SQLException {
        dados.startConexao();

        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        navegador.manage().window().maximize();
        navegador.get(url);

        // Insere o primeiro nome no formulário
        navegador.findElement(By.id("user-name")).sendKeys(dados.getPrimeiroNome().get(indice));
        // Insere o sobrenome no formulário
        navegador.findElement(By.id("user-lastname")).sendKeys(dados.getSobrenome().get(indice));
        // Insere o e-mail no formulário
        navegador.findElement(By.id("user-email")).sendKeys(dados.getEmail().get(indice));
        // Insere o número do telefone no formulário
        navegador.findElement(By.id("user-phone")).sendKeys(dados.getNumeroCel().get(indice));
        // Insere a empresa no formulário
        navegador.findElement(By.id("user-company")).sendKeys(dados.getEmpresa().get(indice));
        // Insere a cidade no formulário
        navegador.findElement(By.id("user-city")).sendKeys(dados.getCidade().get(indice));

        // Fecha a aba do navegador
        navegador.close();
        
    }
    
}
