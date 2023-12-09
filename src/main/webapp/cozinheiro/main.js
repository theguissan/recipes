function buscar() {

    var backendURL = "http://localhost:9096/cozinheiro/quantidade-de-receitas"


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

                var cellNome = row.insertCell(0)
                var cellNomeFantasia = row.insertCell(1);
                var cellCpf = row.insertCell(2);
                var cellQuantidadeDeReceitas = row.insertCell(3);

                cellNome.textContent = elemento.nome;
                cellCpf.textContent = elemento.cpf;
                cellNomeFantasia.textContent = elemento.nomeFantasia;
                cellQuantidadeDeReceitas.textContent = elemento.quantidadeDeReceitas;

            });


        })
        .catch(error => {
            console.error("Erro na requisição:", error)
        });
}