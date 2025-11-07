package claseoverloading;

public class Objetos {
    public static void main(String[] args) {
        System.out.println("SIMULADOR DE COCHES");
        
        // Crear los coches
        Coche miCoche = new Coche("verde", 80, 3.2f); 
        Coche tuCoche = new Coche("rojo", 120, 4.1f);
        Coche suCoche = new Coche("amarillo", 100, 3.4f);
        
        System.out.println("\nESCENA 1: Prueba de sobrecarga");
        
        // NUEVO: Escuchamos el ruido antes de empezar
        System.out.println("--- Ruido inicial ---");
        miCoche.emitirRuido();
        
        miCoche.avanzar();
        miCoche.avanzar(50);
        miCoche.avanzar(30, 100);
        miCoche.girarDerecha();
        miCoche.parar();
        
        System.out.println("\nESCENA 2: Carrera corta");
        
        tuCoche.avanzar(80, 130);
        suCoche.avanzar(80, 110);
        miCoche.avanzar(80);
        
        tuCoche.avanzar(60, 140);
        suCoche.avanzar(60, 120);
        // miCoche se quedará sin combustible aquí
        miCoche.avanzar(60, 90); 
        
        System.out.println("--- Ruido de la carrera al terminar ---");
        tuCoche.emitirRuido();
        suCoche.emitirRuido();
        miCoche.emitirRuido();
        
        System.out.println("\nRESULTADOS");
        System.out.println("Coche " + tuCoche.getColor() + ": " + 
                         tuCoche.getDistanciaRecorrida() + "m");
        System.out.println("Coche " + suCoche.getColor() + ": " + 
                         suCoche.getDistanciaRecorrida() + "m");
        System.out.println("Coche " + miCoche.getColor() + ": " + 
                         miCoche.getDistanciaRecorrida() + "m");
        
        System.out.println("\nRepostaje");
        
        miCoche.repostar();
        miCoche.avanzar(100, 120);
        miCoche.girarIzquierda();
        miCoche.avanzar(50);
        miCoche.parar();
        
        System.out.println("\nFIN");
    }
}
