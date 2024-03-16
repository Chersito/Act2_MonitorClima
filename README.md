# Programación Concurrente

## Segunda Práctica - Monitor de clima

- Se utilizó el lenguaje de JAVA para realizar el siguiente código

---

### Acerca del Proyecto
- Un invernadero inteligente implementado con sensores conectados a una computadora recolecta muestras de la temperatura y humedad:
    - La temperatura mínima requerida para las plantas de invernadero es de 10-15°C, mientras que 30°C podría ser la temperatura máxima.
    - La humedad del aire debe estar entre el 45 y el 60%. Para su control se coloca sensores de humedad en el interior del invernadero (higrómetro).

### **Ejercicio:**
1. Crear un hilo que simule la temperatura 9 horas a lo largo del tiempo, output esperado: 
```
        Registrando --->    Temperatura[0]= 14°C
        .
        .
        .
        Registrando --->    Temperatura[8]= 13°C
```
_Nota: El output puede variar dependiendo de la condición de competencia entre hilos y procesos_

2. Crear un hilo que simule la humedad 9 horas a lo largo del tiempo, output esperado: 
```
        Registrando --->        Humedad[0]= 48%
        .
        .
        .
        Registrando --->        Humedad[8]= 47%
```
_Nota: El output puede variar dependiendo de la condición de competencia entre hilos y procesos_

3. Crear los arreglos donde se almacenarán los datos de temperatura y humedad.
4. Correr un hilo para registrar los datos del sensor de temperatura.
5. Correr un hilo para registrar los datos del sensor de humedad.
6. Calcular el promedio de la temperatura del día.
7. Obtener la humedad más baja y la más alta del día.
8. Escribir a pantalla el inicio y terminación de los hilos sensores.
9. Cada hilo que envíe un mensaje a pantalla debe identificarse
10. Outuput esperado:
```
main: El hilo Temperatura activo
main: El hilo Humedad activo
Inicia sensor de Temperatura
Inicia sensor de Humedad
    Registrando --->        Humedad[0]= 57%
    Registrando --->    Temperatura[0]= 30°C
    Registrando --->        Humedad[1]= 46%
    Registrando --->    Temperatura[1]= 30°C
    Registrando --->    Temperatura[2]= 27°C
    Registrando --->        Humedad[2]= 54%
    Registrando --->    Temperatura[3]= 27°C
    Registrando --->        Humedad[3]= 56%
    Registrando --->    Temperatura[4]= 11°C
    Registrando --->        Humedad[4]= 52%
    Registrando --->    Temperatura[5]= 24°C
    Registrando --->        Humedad[5]= 56%
    Registrando --->    Temperatura[6]= 11°C
    Registrando --->        Humedad[6]= 58%
    Registrando --->        Humedad[7]= 46%
    Registrando --->    Temperatura[7]= 22°C
    Registrando --->    Temperatura[8]= 27°C
    Registrando --->        Humedad[8]= 51%
Termina el sensor de Humedad
Termina el sensor de Temperatura
-----------------------------------------
main: Temperatura promedio = 23.222221
main: Humedad minima: 46
main: Huemdad maxima: 58
-----------------------------------------
```
_Nota: El output puede variar dependiendo de la condición de competencia entre hilos y procesos_

---

### Para abrir el código :
Opción 1 :
1. Abrir la carpeta de [src](https://github.com/Chersito/Act2_MonitorClima/tree/main/src)

2. Código en  [MonitorClima.java](https://github.com/Chersito/Act2_MonitorClima/blob/main/src/MonitorClima.java)

Opción 2 :

Utiliza `git clone https://github.com/Chersito/Act2_MonitorClima.git` para obtener el repositorio por medio de tu terminal