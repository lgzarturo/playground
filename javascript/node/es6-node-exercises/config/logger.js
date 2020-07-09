const colors = require('colors')
const winston = require('winston')

class Logger {
  constructor(name) {
    this.logger = winston.createLogger({
      level: 'info',
      defaultMeta: { service: name },
      transports: [
        new winston.transports.Console({
          format: winston.format.combine(
            winston.format.timestamp(),
            winston.format.metadata({ fillExcept: ['timestamp', 'service', 'level', 'message'] }),
            winston.format.colorize(),
            this.winstonConsoleFormat()
          ),
        }),
      ],
    })
  }

  debug(log, metadata) {
    this.logger.debug(colors.cyan(log), metadata)
  }

  info(log, metadata) {
    this.logger.info(colors.blue(log), metadata)
  }

  success(log, metadata) {
    this.logger.info(colors.green(log), metadata)
  }

  warn(log, metadata) {
    this.logger.warn(colors.yellow(log), metadata)
  }

  error(log, metadata) {
    this.logger.error(colors.red(log), metadata)
  }

  log(level, log, metadata) {
    const metadataObject = {}
    if (metadata) metadataObject.metadata = metadata

    this.logger[level](colors.inverse(log), metadataObject)
  }

  winstonConsoleFormat() {
    return winston.format.printf(({ timestamp, level, message, metadata }) => {
      const metadataString = metadata != null ? JSON.stringify(metadata) : ''

      return `[${timestamp}][${level}][${message}] : ${'metadata: ' + metadataString}`
    })
  }
}

module.exports = new Logger(process.env.APP_NAME)

module.getLogger = (name) => {
  return new Logger(name)
}
