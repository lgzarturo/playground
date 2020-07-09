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

const vargs = require('yargs')
  .command('list', 'listar en consola la tabla de multiplicar', options)
  .command('create', 'generar la tabla de multiplicar', options)
  .help().argv

module.exports = {
  vargs,
}
