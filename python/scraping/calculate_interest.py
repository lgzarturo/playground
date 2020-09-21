# Estimar los intereses por año

print('Numero de años')
years = int(input('Años: '))

print('Cuanto dinero tienes?')
principal = float(input('Dinero: '))

print('Inversión mensual')
monthly_invest = float(input('Ahorro: '))

print('Cual es el estimado de intereses por año en la inversion')
interest = float(input('Interes en decimal (10% = 0.1): '))

print(' ')

monthly_invest = monthly_invest * 12
final_amount = 0

for i in range(0, years):
  if final_amount == 0:
    final_amount = principal

  final_amount = (final_amount + monthly_invest) * (1 + interest)

print(f'Esta es la cantidad de dinero después de {years} años: {final_amount}')
