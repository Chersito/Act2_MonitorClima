// Se importa libreria que representa la hora del sistema
import java.time.LocalTime;
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
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Hilo de temperatura terminado.");
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
    public void run(){
        Random random = new Random();
        System.out.println("    Registrando --->     "+ getName()+": Nuevo hilo " + " (" + LocalTime.now() + ")");


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
    }
}