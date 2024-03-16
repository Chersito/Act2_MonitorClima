// Se importa libreria que representa la hora del sistema
import java.util.Random;

class Temp extends Thread{
    private final int[] tempVect;
    private final int minTemp;
    private final int maxTemp;

    public Temp(int[] tempVect, int minTemp, int maxTemp) {
        this.tempVect = tempVect;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    @Override
    public void run(){
        Random random = new Random();
        System.out.println("Inicia sensor de " + this.getName());

        for (int i = 0; i < tempVect.length; i++) {
            int temperatura = random.nextInt(maxTemp - minTemp + 1) + minTemp;
            tempVect[i] = temperatura;
            System.out.println("    Registrando --->    " + getName() + "[" + i + "]= " + temperatura + "°C");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Termina el sensor de " + getName());
    }
}

class Hum extends Thread{
    private final int[] humVect;
    private final int minHum;
    private final int maxHum;

    public Hum(int[] humVect, int minHum, int maxHum) {
        this.humVect = humVect;
        this.minHum = minHum;
        this.maxHum = maxHum;
    }
    @Override
    public void run() {
        Random random = new Random();
        System.out.println("Inicia sensor de " + this.getName());

        for (int i = 0; i < humVect.length; i++) {
            int humedad = random.nextInt(maxHum - minHum + 1) + minHum;
            humVect[i] = humedad;
            System.out.println("    Registrando --->        " + getName() + "[" + i + "]= " + humedad + "%");
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
        int[] tempVect = new int[9];
        int[] humVect = new int[9];
        int minTemp = 10;
        int maxTemp = 30;
        int minHum = 45;
        int maxHum = 60;

        Temp thread1 = new Temp(tempVect, minTemp, maxTemp);
        Hum thread2 = new Hum(humVect, minHum, maxHum);
        
        thread1.setName("Temperatura");
        thread2.setName("Humedad");
        
        thread1.start();
        thread2.start();

        if (thread1.isAlive() && thread2.isAlive()) {
            System.out.println("main: El hilo Temperatura activo");
            System.out.println("main: El hilo Humedad activo");
        }
        
        thread1.join();
        thread2.join();

        int tempSum = 0;
        int minHumedadDay = humVect[0];
        int maxHumedadDay = humVect[0];

        for (int temperatura : tempVect) {
            tempSum += temperatura;
        }

        float promedioTemp = (float) tempSum / tempVect.length;

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