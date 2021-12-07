title = "Bienvenido al test"
score = 0
print(title)
print("-"*len(title))
print("Pregunta 1")
option = input("""Que haces con VSCode? 
        A - Edito videos en 4K
        B - Diseño video juegos en 3D
        C - Escribo código ya que es un editor
        D - Mejoro las pistas de audio
\nRespuesta: """)

if option == "C":
    score += 10
elif option == "A" or option == "B" or option == "D":
    score += 0
else:
    print("Error en la respuesta, solo se admiten las siguientes respuestas: [A, B, C, D]")
    exit()

print("Tu puntuación es de: {}".format(score))
