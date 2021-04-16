var id;
var total;

var getPokemonTotal = function () {
    $.ajax({
        url: `https://pokeapi.co/api/v2/pokemon-species/?limit=0`,
        async: true,
        success: pokemonCountSuccess,
        error: pokemonCountError
    });
    function pokemonCountSuccess(response) {
        total = response.count;
        getPokemonData();
    }
    function pokemonCountError() {
        total = 0;
        getPokemonData();
    }
}

var createPokemonView = function (response) {
    return `
            <div class="name">${response.name}</div>
            <a href='https://www.pokemondb.net/pokedex/${response.name}'
            target="_blank">
            <img class='pokemon-image' src=${response.sprites.front_default}></a>
            <div class = "details">
            <span>Type: ${response.types[0]['type']['name']}</span>
            <span>Starting HP: ${response.stats[0]['base_stat']}</span>
            </div>
            `
}

function getPokemonData() {
    id = Math.ceil(Math.random() * total);

    $.ajax({
        url: `https://pokeapi.co/api/v2/pokemon/${id}`,
        async: true,
        success: successCallback,
        error: errorCallback
    });

    function successCallback(response) {
        $('#main-box').addClass('pokemon-box').delay(500).queue(function () {
            $('#main-box').removeClass('pokemon-box').dequeue();

        });

        const html = createPokemonView(response);

        const pokemonDiv = document.querySelector('.pokemon')
        pokemonDiv.innerHTML = html

    }

    function errorCallback(request, status, error) {

        //console.log(request);

        const html = `
            <div class="name">Request ${request.responseText}</div>
            `

        const pokemonDiv = document.querySelector('.pokemon')
        pokemonDiv.innerHTML = html
    };
}

var searchPokemon = function () {


    var searchValue = document.getElementById('pokemon-name').value;
    
    if(searchValue) {
        searchValue = searchValue.toLowerCase();
        
        $.ajax({
            url: `https://pokeapi.co/api/v2/pokemon/${searchValue}`,
            async: true,
            success: successSearchPokemon,
            error: errorSearchPokemon
        });
    }
        
    function successSearchPokemon(response) {

        const html = createPokemonView(response);

        const pokemonDiv = document.querySelector('.pokemon')
        pokemonDiv.innerHTML = html
    }

    function errorSearchPokemon(request) {
        const html = `
    <div class="name">Pokemon ${searchValue} ${request.responseText.toLowerCase()}</div>
    `
        const pokemonDiv = document.querySelector('.pokemon')
        pokemonDiv.innerHTML = html

    }

};

getPokemonTotal();

document.getElementById('random').addEventListener("click", getPokemonData);
document.getElementById('submit').addEventListener('click', searchPokemon)