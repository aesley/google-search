#language: pt
Funcionalidade: Pesquisa Google
#  Cenario: Pesquisa do Google
#    Dado que o usuario esta na pagina de pesquisa
#    Quando o usuario preencher a pesquisa com "IT Talent"
#    E o usuario clicar no botao de pesquisar
#    E o sistema apresenta os resultados buscados
#    E o usuario clicar no primeiro resultado da pagina
#    Entao a pagina deve exibir o titulo do link
#    E a pagina deve exibir o texto de descricao

#  Cenario: Baixar imagem do google
#    Dado que o usuario esta na pagina de pesquisa
#    Quando o usuario clicar no link do google imagens
#    E o usuario preencher a pesquisa com "Instituto Atlântico"
#    E o usuario clicar no botao de pesquisar do google imagens
#    E o usuario fazer o download da primeira imagem do resultado
#    Entao o sistema deve exibir o download da imagem

  Cenario: Pesquisa google imagem e download da primeira imagem
    Dado que o usuario esta na pagina de pesquisa
    Quando o usuario clicar no link do google imagens
    E o usuario preencher a pesquisa com {Instituto Atlântico, IREDE, AVANTI, UECE}
    E o usuario clicar no botao de pesquisar do google imagens
    E o sistema apresenta os resultados das imagens
    E o usuario clicar em salvar a primeira imagem do resultado
    Entao o sistema deve exibir o download da imagem