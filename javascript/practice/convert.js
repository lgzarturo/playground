const jsonForm = document.getElementById('jsonform')
const csvForm = document.getElementById('csvform')
const convert = document.getElementById('convert')

convert.addEventListener('click', e => {
  convertJsonToCsv()
})

function convertJsonToCsv () {
  let json
  let keys = []
  const values = []
  try {
    json = JSON.parse(jsonForm.value)
  } catch (err) {
    console.log('format error', err)
    alert('json format error')
  }

  if (Array.isArray(json)) {
    json.forEach(item => {
      const nkeys = Object.keys(item)
      if (keys.length === 0) {
        keys = [...nkeys]
      } else {
        if (keys.length !== nkeys.length) {
          console.log('key length error')
          throw new Error('key length error')
        } else {
          console.log('key length ok', nkeys)
        }
      }
      const row = keys.map((key, i) => {
        return item[key]
      })
      values.push([...row])
    })
    console.log(keys, values)
    values.unshift(keys)
    const text = values.map(v => v.join(',')).join('\n')
    csvForm.value = text
  } else {
    alert('json format error')
  }
}
// [{"id":"1", "name": "arturo"},{"id":"2", "name": "gus"}]
