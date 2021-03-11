require('dotenv').config()
const debug = require('debug')('app')
const logger = require('./config/logger')
const express = require('express')
const app = express()

app.get('/', (req, res) => {
  let data = {
    nombre: 'Arturo',
    edad: 38,
    saludo: 'Hola Arturo',
    url: req.url,
  }
  debug(data)
  res.send(data)
})

app.listen(process.env.PORT, () => {
  logger.success(`Escuchando el puerto ${process.env.PORT}`, {
    host: `http://localhost:${process.env.PORT}`,
  })
})
