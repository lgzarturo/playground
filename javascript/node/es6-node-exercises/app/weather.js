require('dotenv').config()
const axios = require('axios')
const debug = require('debug')('app')
const logger = require('../config/logger')
const _ = require('lodash')

const address = async (city) => {
  logger.info(`Obteniendo el clima de la ciudad: ${city}`)
  const response = await axios.get(
    'https://devru-latitude-longitude-find-v1.p.rapidapi.com/latlon.php',
    {
      baseURL: '',
      useQueryString: true,
      params: {
        location: encodeURI(city),
      },
      headers: {
        'x-rapidapi-key': process.env.RAPID_API_KEY,
      },
    }
  )

  debug(response.data)

  if (_.isNull(response.data.Results)) {
    logger.error('No hay información')
  }

  return {
    address: 'New York City, New York',
    lat: '40.750000',
    lon: '-74.000000',
  }
}

const weather = async (lat, lon) => {
  const response = await axios.get('https://api.openweathermap.org/data/2.5/weather', {
    baseURL: '',
    useQueryString: true,
    params: {
      lat: encodeURI(lat),
      lon: encodeURI(lon),
      appid: process.env.OPEN_WEATHER_API_KEY,
    },
  })

  return {
    temp: response.data.main.temp,
  }
}

const getWeather = async (city) => {
  try {
    const coordinates = await address(city)
    const temperature = await weather(coordinates.lat, coordinates.lon)
    return `El clima de ${coordinates.address} es de ${temperature.temp}`
  } catch (e) {
    logger.error('Error:', e)
    return `No se pudo obtener el clima de ${city}`
  }
}

module.exports = {
  address,
  weather,
  getWeather,
}
