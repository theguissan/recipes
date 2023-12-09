function buscar() {

    var backendURL = "http://localhost:9096/categoria-receita/por-categoria"


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

                var cellCodigoDaCategoria = row.insertCell(0);
                var cellDescricao = row.insertCell(1);
                var cellQuantidadeDeReceitas = row.insertCell(2);
                cellCodigoDaCategoria.textContent = elemento.codigo;
                cellDescricao.textContent = elemento.descricao;
                cellQuantidadeDeReceitas.textContent = elemento.quantidadeDeReceitas;

            });


        })
        .catch(error => {
            console.error("Erro na requisição:", error)
        });
}