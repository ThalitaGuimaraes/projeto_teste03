package tests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CadastroDeFuncionariosComSucesso {

	@Test
	public void test() {

		//abrindo o navegador e acessando a página do sistema
		System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://testesoftware1-001-site1.etempurl.com/exercicios/tarefa03");
		
		//preenchendo o nome do funcionário
		driver.findElement(By.xpath("//*[@id=\"Nome\"]")).sendKeys("Sergio Mendes");
		
		//preenchendo o cpf do funcionário
		driver.findElement(By.xpath("//*[@id=\"Cpf\"]")).sendKeys("123.456.789-00");
		
		//preenchendo a matrícula do funcionário
		driver.findElement(By.xpath("//*[@id=\"Matricula\"]")).sendKeys("2023-0001");
		
		//preenchendo a data de admissão do funcionário
		driver.findElement(By.xpath("//*[@id=\"DataAdmissao\"]")).sendKeys("28/02/2023");
		
		//selecionando a empresa do funcionário
		new Select(driver.findElement(By.xpath("//*[@id=\"Empresa\"]"))).selectByVisibleText("Empresa Modelo A");
		
		//selecionando o setor do funcionário
		new Select(driver.findElement(By.xpath("//*[@id=\"Setor\"]"))).selectByVisibleText("Contabilidade");
		
		//clicar no botão de confirmação de cadastro
		driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();
		
		//capturar a mensagem obtida do sistema
		String mensagem = driver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();
		
		//verificando a mensagem
		assertEquals("Funcionário cadastrado com sucesso.", mensagem);
		
		//gerando a evidência
		try {
			
			File arquivo = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(arquivo, new File("Evidência - Cadastro de funcionário com sucesso.png"));	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//fechando o navegador
		driver.close();
	}
}
