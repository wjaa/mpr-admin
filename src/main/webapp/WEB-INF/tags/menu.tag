<%@tag pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/"><img src="/static/img/logo.svg" height="40px"/> - BACKOFFICE</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav">

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownCadastro" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  Cadastro
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownCadastro">
                  <a class="dropdown-item" href="/admin/FornecedorEntity">Fornecedores</a>
                  <a class="dropdown-item" href="/admin/TipoProdutoEntity">Tipo de Produto</a>
                  <a class="dropdown-item" href="/admin/ProdutoEntity/list">Produtos</a>
                  <a class="dropdown-item" href="/admin/EstoqueEntity">Estoque</a>
                  <a class="dropdown-item" href="/admin/TabelaPrecoEntity">Tabela de Preço</a>
                  <a class="dropdown-item" href="/admin/CupomEntity">Cupom de Desconto</a>
                  <a class="dropdown-item" href="/admin/CatalogoGrupoEntity">Catalogo</a>
                  <a class="dropdown-item" href="/admin/CatalogoEntity">Imagens Exclusivas</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownCliente" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  Cliente
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownCliente">
                  <a class="dropdown-item" href="/admin/ClienteEntity">Cadastro Cliente</a>
                  <a class="dropdown-item" href="/admin/PedidoEntity/list">Pedidos</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/checkout/escolhaCliente">Checkout Test</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownCadastro" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  Operação
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownCadastro">
                  <a class="dropdown-item" href="/admin/FornecedorEntity">Fornecedores</a>
                  <a class="dropdown-item" href="/admin/TipoProdutoEntity">Tipo de Produto</a>
                  <a class="dropdown-item" href="/admin/ProdutoEntity/list">Produtos</a>
                  <a class="dropdown-item" href="/admin/EstoqueEntity">Estoque</a>
                  <a class="dropdown-item" href="/admin/TabelaPrecoEntity">Tabela de Preço</a>
                  <a class="dropdown-item" href="/admin/CupomEntity">Cupom de Desconto</a>
                  <a class="dropdown-item" href="/admin/CatalogoGrupoEntity">Catalogo</a>
                  <a class="dropdown-item" href="/admin/CatalogoEntity">Imagens Exclusivas</a>
                </div>
            </li>
        </ul>
     </div>
</nav>