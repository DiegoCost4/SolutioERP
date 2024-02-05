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

// Dados simulados para os gráficos
var salesData = {
    labels: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho'],
    datasets: [{
        label: 'Vendas',
        data: [42.586, 56.547, 38.452, 58.854, 47.421, 63.254],
        backgroundColor: 'rgba(54, 162, 235, 0.5)',
        borderColor: 'rgba(54, 162, 235, 1)',
        borderWidth: 1
    }]
};

var categoryData = {

        labels: [
          'Locação',
          'Equipamentos',
          'Gases'
        ],
        datasets: [{
          label: 'My First Dataset',
          data: [300, 50, 100],
          backgroundColor: [
            'rgb(255, 99, 132)',
            'rgb(54, 162, 235)',
            'rgb(255, 205, 86)'
          ],
          hoverOffset: 4
        }]
      };

var productData = {
    labels: ['Produto A', 'Produto B', 'Produto C', 'Produto D'],
    datasets: [
        {
            label: 'Vendas',
            backgroundColor: '#36A2EB',
            data: [500, 700, 900, 600]
        },
        {
            label: 'Estoque',
            backgroundColor: '#FFCE56',
            data: [200, 300, 400, 250]
        }
    ]
};

// Configurações dos gráficos
var lineConfig = {
    type: 'line',
    data: salesData
};

var pieConfig = {
    type: 'doughnut',
    data: categoryData,
};

var barConfig = {
    type: 'bar',
    data: productData,
    options: {
        scales: {
            xAxes: [{ stacked: true }],
            yAxes: [{ stacked: true }]
        }
    }
};

// Renderizar os gráficos
var lineChart = new Chart(document.getElementById('lineChart').getContext('2d'), lineConfig);
var pieChart = new Chart(document.getElementById('pieChart').getContext('2d'), pieConfig);
var barChart = new Chart(document.getElementById('barChart').getContext('2d'), barConfig);

// Dados simulados para o gráfico de desempenho de vendedores
var vendedorData = {
    labels: ['Bruno', 'Debora', 'Mateus'],
    datasets: [{
        label: 'Total de Vendas',
        backgroundColor: ['#FF6384', '#36A2EB', '#FFCE56'],
        data: [50, 40, 30]
    }]
};

// Configurações do gráfico de desempenho de vendedores
var vendedorConfig = {
    type: 'bar',
    data: vendedorData,
    options: {
        scales: {
            yAxes: [{
                ticks: {
                    beginAtZero: true
                }
            }]
        }
    }
};

// Renderizar o gráfico de desempenho de vendedores
var vendedorChart = new Chart(document.getElementById('vendedorChart').getContext('2d'), vendedorConfig);
