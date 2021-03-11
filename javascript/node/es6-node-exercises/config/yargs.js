const options = {
  base: {
    alias: 'b',
    demand: true,
  },
  limit: {
    alias: 'l',
    default: 10,
  },
}

const weatherOptions = {
  city: {
    alias: 'c',
    desc: 'Dirección de la ciudad para obtener el clima',
    demand: true,
  },
}

const vargs = require('yargs')
  .command('list', 'Listar en consola la tabla de multiplicar', options)
  .command('create', 'Generar la tabla de multiplicar', options)
  .command('weather', 'Clima de una ciudad', weatherOptions)
  .help().argv

module.exports = {
  vargs,
}
