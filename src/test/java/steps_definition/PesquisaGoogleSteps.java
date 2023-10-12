package steps_definition;

import base_class.BaseSteps;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import page_objects.PesquisaGooglePage;
import page_objects.ResultadosPesquisaGooglePage;

public class PesquisaGoogleSteps extends BaseSteps {

    PesquisaGooglePage paginaPesquisa = new PesquisaGooglePage(browser);
    ResultadosPesquisaGooglePage resultPesquisa = new ResultadosPesquisaGooglePage(browser);

    @Dado("que o usuario esta na pagina de pesquisa")
    public void queOUsuarioEstaNaPaginaDePesquisa() {
        paginaPesquisa.abrirPagina();
        screenshot();
    }

    @Quando("o usuario clicar no link do google imagens")
    public void oUsuarioClicarNoLinkDoGoogleImagens() {
        paginaPesquisa.abrirPaginaGoogleImagens();
        screenshot();
    }

    @Quando("o usuario preencher a pesquisa com {string}")
    public void oUsuarioPreencherAPesquisaCom(String textoPesquisa) {
        paginaPesquisa.preencherPesquisa(textoPesquisa);
        screenshot();
    }

    @E("o usuario clicar no botao de pesquisar do google imagens")
    public void oUsuarioClicarNoBotaoDePesquisarDoGoogleImagens() {
        paginaPesquisa.clicarBtnGoogleImagens();
        screenshot();
    }

    @Entao("o sistema apresenta os resultados buscados")
    public void oSistemaApresentaOsResultadosBuscados() {
        int resut = resultPesquisa.getResultPesquisa();;
        Assert.assertTrue(resut > 0);
        screenshot();
    }

    @Quando("o sistema apresenta os resultados das imagens")
    public void oSistemaApresentaOsResultadosDasImagens() {

    }

    @Quando("o usuario clicar em salvar a primeira imagem do resultado")
    public void oUsuarioClicarEmSalvarAPrimeiraImagemDoResultado() {

    }

    @E("o usuario clicar no botao de pesquisar")
    public void oUsuarioClicarNoBotãoDePesquisar() {
        paginaPesquisa.clicarBtnPesquisar();
    }


    @E("o usuario clicar no primeiro resultado da pagina")
    public void oUsuarioClicarNoPrimeiroResultadoDaPagina() {
        resultPesquisa.clicarNoResultado();
    }

    @E("a pagina deve exibir o titulo do link")
    public void aPaginaDeveExibirOTituloDoLink() {
        resultPesquisa.getTexto();
        screenshot();
    }

    @E("a pagina deve exibir o texto de descricao")
    public void aPaginaDeveExibirOTextoDeDescricao() {
        resultPesquisa.getDescricao();
        screenshot();
    }

    @E("o usuario fazer o download da primeira imagem do resultado")
    public void oUsuarioFazerODownloadDaPrimeiraImagemDoResultado() {

    }
    @Entao("o sistema deve exibir o download da imagem")
    public void oSistemaDeveExibirODownloadDaImagem() {

    }

    @Quando("o usuario preencher a pesquisa com \\{Instituto Atlântico, IREDE, AVANTI, UECE}")
    public void oUsuarioPreencherAPesquisaCom() {

    }


}
