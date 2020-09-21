from re import sub
from decimal import Decimal


class Product:
  def __init__(self, name, current_price, old_price, link):
    self.name = name
    self.current_price = current_price
    self.old_price = old_price
    self.link = link

  def product_from_json(self, json):
    self.name = json['name']
    self.current_price = json['current_price']
    self.old_price = json['old_price']
    self.link = json['link']

  def serialize(self):
    return {
      "name": self.name,
      "current_price": self.current_price,
      "old_price": self.old_price,
      "link": self.link,
    }


def convert_price_to_number(price):
  return float(Decimal(sub(r'[^\d.]', '', price)))
