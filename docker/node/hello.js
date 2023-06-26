const express = require('express')
const app = express()
const port = 3000
const { Pool, Client } = require('pg')

let contador = 0;

app.get('/', (req, res) => res.send('Hello World - Docker Coruja! - requisicao número: ' + contador++))

app.get('/conexao', async (req, res) => {

    // clients will also use environment variables
    // for connection information
    const client = new Client()
    await client.connect()
    const resposta = await client.query('SELECT NOW()')

    res.send('resposta: ' + JSON.stringify(resposta)+ ' - connection '+ client)

    await client.end()

});





app.listen(port, () => console.log(`Example app listening on port ${port}!`))