/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */

 import java.time.Duration;

 import org.openqa.selenium.By;
 import org.openqa.selenium.JavascriptExecutor;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.firefox.FirefoxDriver;
 import org.openqa.selenium.support.ui.ExpectedConditions;
 import org.openqa.selenium.support.ui.WebDriverWait;
 
 import io.github.bonigarcia.wdm.WebDriverManager;
 
 public class ArterarCadastro {
     public static void main(String[] args) {
         WebDriver driver = null;
 
         try {
             // Configura o WebDriver do Firefox automaticamente
             WebDriverManager.firefoxdriver().setup();
             driver = new FirefoxDriver(); // Inicia o navegador Firefox
             driver.get("http://localhost:3000/login.html"); // Acessa a página de login
 
             WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 
             // Localizar os campos de login e senha
             WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
             WebElement passwordField = driver.findElement(By.id("password"));
 
             // Preencher os campos
             usernameField.sendKeys("admin@admin.com");
             passwordField.sendKeys("admin");
 
             // Localizar o botão de login
             WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Entrar')]")));
 
             // Executar o clique via JavaScript
             JavascriptExecutor js = (JavascriptExecutor) driver;
             js.executeScript("arguments[0].click();", loginButton);
 
             System.out.println("Login realizado com sucesso!");
 
             // Aguardar até que a página do dashboard seja carregada
             wait.until(ExpectedConditions.urlContains("dashboard"));
 
             // Localizar e clicar no botão de "Atualizar Cadastro"
             WebElement updateButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Atualizar Cadastro')]")));
             js.executeScript("arguments[0].click();", updateButton);
 
             System.out.println("Botão de 'Atualizar Cadastro' clicado com sucesso!");
 
             // Esperar até que os campos de edição do cadastro sejam visíveis
             wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-form")));
 
             // Localizar os campos de nome e e-mail
             WebElement nameField = driver.findElement(By.id("name")); // Corrigir o id aqui
             WebElement emailField = driver.findElement(By.id("email")); // Esse id pode ser o mesmo de login, verifique se é o campo de edição
 
             // Atualizar os valores dos campos
             nameField.clear();
             nameField.sendKeys("João Paulo");
             emailField.clear();
             emailField.sendKeys("joao@gmail.com"); // Corrigir domínio do email
 
             // Localizar o botão de "Atualizar" e clicar nele
             WebElement updateProfileButton = driver.findElement(By.xpath("//button[contains(text(), 'Atualizar')]"));
             js.executeScript("arguments[0].click();", updateProfileButton);
 
             // Exibir mensagem indicando que a alteração foi realizada
             System.out.println("Cadastro atualizado com sucesso!");
 
         } catch (Exception e) {
             System.out.println("Erro: " + e.getMessage());
         } finally {
             // Fechar o navegador após um tempo (para visualizar o resultado)
             try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
             if (driver != null) {
                //driver.quit(); // Fechar o navegador corretamente
             }
         }
     }
 }
 


