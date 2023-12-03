function buscar() {

    var backendURL = "http://localhost:9096/cozinheiro"


    fetch(backendURL, {
        method: "GET",
        headers: {
            "Content-Type": "application/json",  
        },
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Erro na requisição")
        }
        return response.json()
    })
    .then(data => {
        console.log("Requisição bem-sucedida:", data)


        const tabela = document.getElementById("tabelaDeDados")


        tbody = tabela.getElementsByTagName('tbody')[0];
    
        tbody.innerHTML = '';
    
    
        data.forEach(elemento => {
    
            var row = tbody.insertRow();
    
            var cellCpf = row.insertCell(0);
            var cellNomeFantasia = row.insertCell(1);
            var cellQuantidadeDeReceitas = row.insertCell(2);
    
            cellCpf.textContent = elemento.cpf;
            cellNomeFantasia.textContent = elemento.nomeFantasia;
    
            // TODO mudar depois para o dado correto
            cellQuantidadeDeReceitas.textContent = 1;
    
        });


    })
    .catch(error => {
        console.error("Erro na requisição:", error)
    });
}