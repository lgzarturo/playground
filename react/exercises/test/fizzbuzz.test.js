
import { describe, expect, it } from 'vitest'
import { fizzBuzz } from '../src/utils/fizzbuzz'

describe('', () => {
  it('should throw if not a number is provided as parameter', () => {
    expect(() => fizzBuzz()).toThrow()
  })

  it('should throw a specific error message if not a number is provided as parameter', () => {
    expect(() => fizzBuzz()).toThrow('Parameter provided must be a number')
  })

  it('should throw a specific error message not a number is provided', () => {
    expect(() => fizzBuzz(NaN)).toThrow('Parameter provided must be a number')
  })

  it('should return 1 if number provided is 1', () => {
    expect(fizzBuzz(1)).toBe(1)
  })

  it('should return 2 if number provided is 2', () => {
    expect(fizzBuzz(2)).toBe(2)
  })

  it('should return "fizz" if number provided is 3', () => {
    expect(fizzBuzz(3)).toBe('fizz')
  })

  it('should return "fizz" if number provided is multiple of 3', () => {
    expect(fizzBuzz(6)).toBe('fizz')
    expect(fizzBuzz(9)).toBe('fizz')
    expect(fizzBuzz(12)).toBe('fizz')
  })

  it('should return "buzz" if number provided is 5', () => {
    expect(fizzBuzz(5)).toBe('buzz')
  })

  it('should return "buzz" if number provided is multiple of 5', () => {
    expect(fizzBuzz(10)).toBe('buzz')
    expect(fizzBuzz(20)).toBe('buzz')
    expect(fizzBuzz(25)).toBe('buzz')
  })

  it('should return "fizz buzz" if number provided is 15', () => {
    expect(fizzBuzz(15)).toBe('fizzbuzz')
  })
})
