const colors = require('colors')
const fs = require('fs')

const iterator = (base, limit = 10) => {
  let data = ''
  for (let i = 1; i <= limit; i++) {
    data += colors.dim(`${base} * ${i} = ${base * i}\n`)
  }
  return data
}

const listTable = (base, limit = 10) => {
  console.log(iterator(base, limit))
}

const createMultiplyTable = (base, limit = 10) => {
  return new Promise((resolve, reject) => {
    if (!Number(base)) {
      // eslint-disable-next-line prefer-promise-reject-errors
      reject(`El valor de la base '${base}' no es un número`)
      return
    }

    const data = iterator(base, limit)
    const directory = 'data'
    const filename = `./${directory}/tabla-${base}.txt`

    fs.writeFile(`${filename}`, data, (err) => {
      if (err) {
        reject(err)
      } else {
        resolve(`${filename}`)
      }
    })
  })
}

module.exports = {
  listTable,
  createMultiplyTable,
}
