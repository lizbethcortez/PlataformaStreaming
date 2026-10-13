
package com.mycompany.plataformastreaming;

public class ContenidoAudio {

    // 1. ATRIBUTOS (Las características de nuestros audios)
    // Usamos "private" porque es el requisito de Encapsulamiento (R2). 
    // Esto significa que nadie de fuera puede modificar estos datos directamente; 
    // Solo se puede a través de los métodos de abajo (getters y setters).
    private int id;                 // Número único para identificar el contenido
    private String titulo;          // Nombre de la canción o podcast
    private double duracionMinutos; // Cuánto dura el audio en minutos
    private int reproducciones;     // Cantidad de veces que se ha escuchado

    // 2. CONSTRUCTORES (Para crear los objetos)
    // Constructor Vacío: Crea un objeto sin datos iniciales (por si queremos rellenarlo después).
    public ContenidoAudio() {
    }

    // Constructor con Parámetros: Nos permite crear el objeto y meterle todos los datos de golpe al mismo tiempo.
    public ContenidoAudio(int id, String titulo, double duracionMinutos, int reproducciones) {
        this.id = id;                       // "this.id" se refiere al atributo de la clase, y "id" al valor que le pasamos.
        this.titulo = titulo;
        this.duracionMinutos = duracionMinutos;
        this.reproducciones = reproducciones;
    }
    // 3. MÉTODOS GETTERS Y SETTERS (R2)
    // El "get" sirve para CONSULTAR (leer) el valor privado de un atributo.
    // El "set" sirve para MODIFICAR (actualizar) el valor de un atributo usando "this".

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id; // Usamos "this" para indicar que estamos modificando el atributo de este objeto en específico.
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(double duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public int getReproducciones() {
        return reproducciones;
    }

    public void setReproducciones(int reproducciones) {
        this.reproducciones = reproducciones;
    }
    // 4. MÉTODO PARA EL POLIMORFISMO (R4)
    // Este método calcula una regalía base general (por ejemplo, 5 centavos por reproducción).
    // Más adelante, en las clases hijas (como Cancion o Podcast), vamos a sobrescribir este mismo método usando "@Override" para que calcule tarifas distintas según el tipo de contenido.
    
    public double calcularCostoRoyalty() {
        return this.reproducciones * 0.05;
    }
}