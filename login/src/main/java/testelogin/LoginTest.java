package testelogin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
    public static void main(String[] args) {
        WebDriver driver = null;

        try {
            // Configura o WebDriver do Firefox automaticamente
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(); // Inicia o navegador Firefox
            driver.get("http://localhost:3000/login.html"); 

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

        } catch (Exception e) {
            System.out.println("Erro ao realizar login: " + e.getMessage());
        } finally {
            // Fechar o navegador após um tempo (para visualizar o resultado)
            try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
            if (driver != null) {
               // driver.quit();
            }
        }
    }
}
