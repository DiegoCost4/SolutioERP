//Seleção Pessoa fisica e juridica, altera campo CPF e CNPJ
function mostrarCampo() {
    var tipoPessoa = document.getElementById('tipo_pessoa').value;
    var campoCPF = document.getElementById('campo_cpf');
    var campoCNPJ = document.getElementById('campo_cnpj');

    if (tipoPessoa === 'fisica') {
        campoCPF.style.display = 'block';
        campoCNPJ.style.display = 'none';
    } else if (tipoPessoa === 'juridica') {
        campoCPF.style.display = 'none';
        campoCNPJ.style.display = 'block';
    }
}
// Função para gerar código automaticamente
function gerarCodigo() {
    var codigoInput = document.getElementById('codigo');
    // Lógica para gerar um código único, por exemplo, usando um timestamp
    var codigoGerado = Date.now();
    codigoInput.value = codigoGerado;
}

//adiconar produto 
function cadastrarProduto() {
  // Aqui você pode adicionar o código para enviar os dados do formulário para o backend e cadastrar o produto
  // Por exemplo, usando AJAX para fazer uma requisição POST para o servidor
  // Após o cadastro, você pode exibir uma mensagem de sucesso e fechar o modal
  // Este é apenas um exemplo básico para ilustrar o conceito
  alert('Produto cadastrado com sucesso!');
  $('#adicionarProdutoModal').modal('hide');
}
