package claseoverloading;

public class Coche {
    
    private String color;
    private int velocidad;
    private float tamaño;
    private int distanciaRecorrida;
    private double combustible;
    private int nivelRuido; 
    
    public Coche(String color, int velocidad, float tamaño) {
        this.color = color;
        this.velocidad = velocidad;
        this.tamaño = tamaño;
        this.distanciaRecorrida = 0;
        this.combustible = 100.0;
        
        //  NUEVO: Cálculo del nivel de ruido
        // (Velocidad * 0.5) + (Tamaño * 10). Limitado a 100.
        this.nivelRuido = Math.min(100, (int)(velocidad * 0.5 + tamaño * 10));
    }
    
    // Sobrecarga 1: avanzar distancia por defecto (10m)
    public void avanzar() {
        avanzar(10);
    }
    
    // Sobrecarga 2: avanzar con metros específicos
    public void avanzar(int metros) {
        avanzar(metros, velocidad);
    }
    
    // Sobrecarga 3: avanzar con metros y velocidad personalizada
    public void avanzar(int metros, int velocidadActual) {
        double consumo = metros * 0.5;
        
        if (combustible >= consumo) {
            distanciaRecorrida += metros;
            combustible -= consumo;
            
            // NUEVO: El coche emite ruido al avanzar
            emitirRuido();
            
            System.out.println("Coche " + color + " avanzó " + metros + "m a " + 
                             velocidadActual + " km/h (Combustible: " + 
                             String.format("%.1f", combustible) + "%)");
        } else {
            System.out.println("Coche " + color + " se quedó sin combustible!");
        }
    }
    
    // NUEVO MÉTODO: Simulación de sonido basado en el nivel
    public void emitirRuido() {
        String sonido;
        
        if (nivelRuido >= 80) {
            sonido = "¡¡¡ROOAAAARRR!!! (Ruido alto)";
        } else if (nivelRuido >= 50) {
            sonido = "Vrooom vroom (Ruido moderado)";
        } else {
            sonido = "Sssshhh... (Ruido bajo)";
        }
        
        System.out.println(" El coche " + color + " emite: " + sonido + 
                           " | Nivel: " + nivelRuido + "/100");
    }
    
    public void parar() {
        System.out.println("coche " + color + " se detuvo");
    }
    
    public void girarIzquierda() {
        System.out.println("️Coche " + color + " giró a la izquierda");
    }
    
    public void girarDerecha() {
        System.out.println("Coche " + color + " giró a la derecha");
    }
    
    public void repostar() {
        combustible = 100.0;
        System.out.println("Coche " + color + " repostado al 100%");
    }
    
    // Getters
    public String getColor() { return color; }
    public int getDistanciaRecorrida() { return distanciaRecorrida; }
    public double getCombustible() { return combustible; }
}
