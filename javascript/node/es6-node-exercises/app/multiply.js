const colors = require('colors')
const fs = require('fs')

let iterator = (base, limit = 10) => {
  let data = ''
  for (let i = 1; i <= limit; i++) {
    data += colors.dim(`${base} * ${i} = ${base * i}\n`)
  }
  return data
}

let listTable = (base, limit = 10) => {
  console.log(iterator(base, limit))
}

let createMultiplyTable = (base, limit = 10) => {
  return new Promise((resolve, reject) => {
    if (!Number(base)) {
      reject(`El valor de la base '${base}' no es un número`)
      return
    }

    let data = iterator(base, limit)
    let directory = 'data'
    let filename = `./${directory}/tabla-${base}.txt`

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
