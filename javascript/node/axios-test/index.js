const axios = require('axios')

let url = 'https://api-stage.revenatium.com/agencies-admin/public/search'
let query = 'Hotel Laguna'

const getData = async () => {
  try {
    const response = await axios.get(url, {
    params: {
      query
      }
    })
  console.log(response)
  } catch (error) {
    console.error(error.response.data);
  }
}

getData()

console.log("Test")
