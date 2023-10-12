package page_objects;

import base_class.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static base_class.BaseSteps.screenshot;
import static org.junit.Assert.assertEquals;

public class ResultadosPesquisaGooglePage extends BasePage {
    private By txtResultadosPesquisa = By.id("result-stats");
    private By primeiroResultadoSelector = By.cssSelector("#rso > div:nth-child(1) > div > div > div > div > div > div > div.yuRUbf > div > span > a > h3");
    private By textoLink = By.cssSelector("#sobre > div > div.elementor-element.elementor-element-5a3af61.elementor-widget.elementor-widget-heading > div > h1");
    private By descricaoResultado = By.cssSelector("#sobre > div > div.elementor-element.elementor-element-f0873ce.elementor-widget.elementor-widget-heading > div > h3");

    public ResultadosPesquisaGooglePage(WebDriver navegador)  {
        super(navegador);
    }

    public int getResultPesquisa() {
        String texto = driver.findElement(txtResultadosPesquisa).getText();
        String[] vetorTexto = texto.split(" ");
        texto = vetorTexto[1].replace(",", "").replace(".", "");
        int nunTratado = Integer.parseInt(texto);
        return nunTratado;
    }

    public void clicarNoResultado(){
        waitElementVisible(primeiroResultadoSelector, 5);
        driver.findElement(primeiroResultadoSelector).click();
        screenshot();
    }

    public String getTexto() {
        waitElementVisible(textoLink, 5);
        WebElement message = driver.findElement(By.cssSelector("#sobre > div > div.elementor-element.elementor-element-5a3af61.elementor-widget.elementor-widget-heading > div > h1"));
        String value = message.getText();
        assertEquals("Programa IT Talent", value);
        return value;
    }

    public String getDescricao() {
        waitElementVisible(descricaoResultado, 5);
        WebElement message = driver.findElement(By.cssSelector("#sobre > div > div.elementor-element.elementor-element-f0873ce.elementor-widget.elementor-widget-heading > div > h3"));
        String value = message.getText();
        assertEquals("O Programa IT Talent é realizado pela UECE, HP, IREDE e Instituto Atlântico, onde serão disponibilizadas 80 vagas para um curso na área de Tecnologia da Informação, com duração de cinco meses. O Programa é dividido entre os cursos DevOps Básico e Quality Assurance, tendo cada um 40 vagas disponíveis.", value);
        return value;
    }
}

