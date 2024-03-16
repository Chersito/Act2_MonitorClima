// Se importa libreria que representa la hora del sistema
// import java.time.LocalTime;
// Se importa libreria Random
import java.util.Random;

// Se crea una clase para tratar el hilo de Temperatura
class Temp extends Thread{
    // Se crean variables finales o inmutables
    private final int[] tempVect;
    private final int minTemp;
    private final int maxTemp;

    // Constructor de la clase
    public Temp(int[] tempVect, int minTemp, int maxTemp) {
        this.tempVect = tempVect;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    // Se usa Override para sobreescribir el método de run() de la superclase Thread
    @Override
    public void run(){
        
        //Se crea instancia de random
        Random random = new Random();
        System.out.println("Inicia sensor de " + this.getName());

        // Este bucle itera el vector y almacena las temperaturas registradas por el sensor.
        for (int i = 0; i < tempVect.length; i++) {
            //Se genera un número aleatorio dentro del rango especificado por minTemp y maxTemp
            int temperatura = random.nextInt(maxTemp - minTemp + 1) + minTemp;
            tempVect[i] = temperatura;
            System.out.println("    Registrando --->    " + getName() + "[" + i + "]= " + temperatura + "°C");
            
            // Se utiliza try-catch para manejar la excepción InterruptedException
            // Puede ocurrir si el hilo es interrumpido mientras está dormido.
            try {
                Thread.sleep(1000); // Simular una hora de intervalo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Termina el sensor de " + getName());
    }
}

// Se crea una clase para tratar el hilo de Humedad
class Hum extends Thread{
    // Se crean variables finales o inmutables
    private final int[] humVect;
    private final int minHum;
    private final int maxHum;
    
    // Constructor de la clase
    public Hum(int[] humVect, int minHum, int maxHum) {
        this.humVect = humVect;
        this.minHum = minHum;
        this.maxHum = maxHum;
    }

    // Se usa Override para sobreescribir el método de run() de la superclase Thread
    @Override
    public void run() {
        
        //Se crea instancia de random
        Random random = new Random();
        System.out.println("Inicia sensor de " + this.getName());

        // Este bucle itera el vector y almacena la humedad registradas por el sensor.
        for (int i = 0; i < humVect.length; i++) {
            //Se genera un número aleatorio dentro del rango especificado por minHum y maxHum
            int humedad = random.nextInt(maxHum - minHum + 1) + minHum;
            humVect[i] = humedad;
            System.out.println("    Registrando --->        " + getName() + "[" + i + "]= " + humedad + "%");
            
            // Se utiliza try-catch para manejar la excepción InterruptedException
            // Puede ocurrir si el hilo es interrumpido mientras está dormido.
            try {
                Thread.sleep(1000); // Simular una hora de intervalo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Termina el sensor de " + getName());
    }
}

public class MonitorClima{
    public static void main(String[] args) throws Exception {
        // Se crea vectores que almacenan 9 elementos
        int[] tempVect = new int[9];
        int[] humVect = new int[9];
        // Se definen los parámetros
        int minTemp = 10;
        int maxTemp = 30;
        int minHum = 45;
        int maxHum = 60;

        // Se crean instancias de las clases y asigna los valores a los argumentos
        Temp thread1 = new Temp(tempVect, minTemp, maxTemp);
        Hum thread2 = new Hum(humVect, minHum, maxHum);
        
        // Se da un nombre diferente a los hilos
        thread1.setName("Temperatura");
        thread2.setName("Humedad");
        
        // Se inician los hilos
        thread1.start();
        thread2.start();

        // Condicional que verifica si ambos hilos están vivos y ejecutándose
        if (thread1.isAlive() && thread2.isAlive()) {
            System.out.println("main: El hilo Temperatura activo");
            System.out.println("main: El hilo Humedad activo");
        }
        
        // Espera a que los hilos terminen su ejecución antes de continuar.
        thread1.join();
        thread2.join();

        // Se declaran las variables para obtener promedio, mínimos y máximos
        int tempSum = 0;
        int minHumedadDay = humVect[0];
        int maxHumedadDay = humVect[0];

        // Calcula la suma de todas las temperaturas del vector tempVect
        for (int temperatura : tempVect) {
            tempSum += temperatura;
        }

        // Se calcula el promedio de Temperatura
        float promedioTemp = (float) tempSum / tempVect.length;

        // Con un bucle y una condicional, determina la humedad mínima y máxima
        for (int humedad : humVect) {
            if (humedad < minHumedadDay) {
                minHumedadDay = humedad;
            }
            if (humedad > maxHumedadDay) {
                maxHumedadDay = humedad;
            }
        }

        System.out.println("-----------------------------------------");
        System.out.println("main: Temperatura promedio = " + promedioTemp );
        System.out.println("main: Humedad minima: " + minHumedadDay );
        System.out.println("main: Huemdad maxima: " + maxHumedadDay);
        System.out.println("-----------------------------------------");
    }
}