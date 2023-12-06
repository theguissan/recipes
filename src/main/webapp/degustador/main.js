function buscar() {

    var backendURL = "http://localhost:9096/degustador/maiores-degustadores"


    const objeto = {
        primeiroIngrediente : document.getElementById("primeiroIngrediente").value,
        segundoIngrediente : document.getElementById("segundoIngrediente").value
    }


    fetch(backendURL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",  
        },
        body: JSON.stringify(objeto)
    })
    .then(response => {
        if (!response.ok) {
            /* TODO implementar logica para avisar na tela aconteca algum erro: ex. tiver algum erro bad request!

               verificar tambem a possibilidade de mudar para typescript, para usar OO e facilitar reuso de codigo!
            
            */
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