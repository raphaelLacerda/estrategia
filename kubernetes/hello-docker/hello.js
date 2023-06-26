const express = require('express')
const app = express()
const port = 3000

let contador = 0;

app.get('/', (req, res) => res.send('Hello World! versao 2.0.0 - requisicao número: '+contador++))

app.listen(port, () => console.log(`Example app listening on port ${port}!`))