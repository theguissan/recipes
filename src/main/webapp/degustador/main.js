function buscar() {

    var backendURL = "http://localhost:9096/teste"


    const objeto = {
        primeiroIngrediente: document.getElementById("primeiroIngrediente").value,
        segundoIngrediente: document.getElementById("segundoIngrediente").value
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

                var primeiroIngrediente = row.insertCell(0);
                var segundoIngrediente = row.insertCell(1);
                var testador = row.insertCell(2);
                var receita = row.insertCell(3);
                var nota = row.insertCell(4);


                primeiroIngrediente.textContent = elemento.primeiroIngrediente;
                segundoIngrediente.textContent = elemento.segundoIngrediente;
                testador.textContent = elemento.testador;
                receita.textContent = elemento.receita;
                nota.textContent = elemento.nota;

            });


        })
        .catch(error => {
            console.error("Erro na requisição:", error)
        });
}