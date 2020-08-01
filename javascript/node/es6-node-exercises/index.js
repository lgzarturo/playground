const debug = require('debug')('app')
const colors = require('colors')
const { listTable, createMultiplyTable } = require('./app/multiply')
const { address, weather, getWeather } = require('./app/weather')

const logger = require('./config/logger')
const vargs = require('./config/yargs').vargs

debug('Comandos %o', vargs)

let command = vargs._[0]

debug('Comando seleccionado %o', command)

switch (command) {
  case 'list':
    logger.info('List command : listar en consola la tabla de multiplicar')
    listTable(vargs.base, vargs.limit)
    break
  case 'create':
    logger.info('Create command: Generar un archivo con la tabla de multiplicar')
    createMultiplyTable(vargs.base, vargs.limit)
      .then((file) => logger.success(`Archivo creado: ${colors.inverse(file)}`))
      .catch((err) => logger.error(err))
    break
  case 'todo':
    logger.info('Crear una lista de todo')
    break
  case 'complete':
    logger.info('Completar una tarea')
    break
  case 'weather':
    logger.info('Clima de la ciudad')
    getWeather(vargs.city)
      .then((res) => logger.success(`Datos`, {data:res}))
      .catch((err) => logger.error(err))
    break
  default:
    logger.error('El comando no es valido')
    break
}
