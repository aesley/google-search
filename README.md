# Automação de Pesquisa no Google
O projeto consiste na automação da página de pesquisa do google, utilizando os seguintes recursos: 

- IDE: IntelliJ;
- Padrão PageObjects;
- Java;
- Maven;
- JUnit;
- Selenium;
- Cucumber (BDD);
- Pluguins p/ relatórios automatizados.

# Configuração da IDE e Projeto de Automação
Criar projeto no IntelliJ
- File > New > Maven Project

Instalação de plugin na IDE
- File > Settings > Plugins > Cucumber Java

Instalar os pacotes na Aplicação através do Maven (pom.xml)
- cucumber-java 7.2.3
- cucumber-junit 7.2.3
- selenium-java 3.141.59
- webdrivermanager 5.0.3

# Planejamento de Testes
    Funcionalidade: Pesquisa Google
       Eu como usuário do "Google"
       Gostaria de realizar uma pesquisa
       Para pesquisar por diferentes assuntos de interesse

#### Mapeando cenários
- Fazer uma pesquisa

#### Criação da Feature de Teste
Na feature, criei o cenário base, utilizando a escrita da feature em *gherkin* tendo como base o *BDD*:
`/src/test/resources/features/PesquisaGoogle.feature`

## Apoie este projeto
Se você quer apoiar este projeto, deixe uma ⭐.
