document.getElementById('formCadastro').addEventListener('submit', function(event) {
    event.preventDefault(); // Evita que o formulário seja enviado normalmente

    // Coleta os dados do formulário
    const formData = new FormData(event.target);

    // Converte os dados do formulário para um objeto JSON
    const jsonData = {};
    formData.forEach((value, key) => {
        jsonData[key] = value;
    });

    // Envia os dados para a API
    fetch('http://localhost:8083/api/clientes', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(jsonData)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Erro ao enviar os dados');
        }
        return response.json();
    })
    .then(data => {
        console.log('Dados enviados com sucesso:', data);
        // Limpa os campos do formulário após o envio bem-sucedido, se necessário
        event.target.reset();
    })
    .catch(error => {
        console.error('Erro ao enviar os dados:', error);
    });
});

// Adicionando evento de clique ao botão "Cadastrar"
document.getElementById('btnCadastrar').addEventListener('click', function(event) {
    // Submeta o formulário quando o botão "Cadastrar" for clicado
    document.getElementById('formCadastro').submit();
});
