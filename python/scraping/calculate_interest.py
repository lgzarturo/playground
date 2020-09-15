# Estimar los intereses por año
from pip._vendor.distlib.compat import raw_input

print('Numero de años')
years = int(raw_input('Años: '))

print('Cuanto dinero tienes?')
principal = float(raw_input('Dinero: '))

print('Inversión mensual')
monthly_invest = float(raw_input('Ahorro: '))

print('Cual es el estimado de intereses por año en la inversion')
interest = float(raw_input('Interes en decimal (10% = 0.1): '))

print(' ')

monthly_invest = monthly_invest * 12
final_amount = 0

for i in range(0, years):
	if final_amount == 0:
		final_amount = principal

	final_amount = (final_amount + monthly_invest) * (1 + interest)


print(f'Esta es la cantidad de dinero después de {years} años: {final_amount}')
