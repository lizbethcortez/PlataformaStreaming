
package com.mycompany.plataformastreaming;

// Usamos "extends ContenidoAudio" para aplicar la Herencia (R3).
// Esto significa que "Cancion" es hija de "ContenidoAudio" y hereda automáticamente sus atributos (id, titulo, etc.) y sus métodos (getters y setters).

public class Cancion extends ContenidoAudio {

    // 1. ATRIBUTOS PROPIOS DE LA CANCIÓN
    private String album;          // Nombre del disco o álbum al que pertenece
    private String nombreArtista;  // Quién interpreta la canción

    // 2. CONSTRUCTORES
    // Constructor vacío
    public Cancion() {
        super(); // Llama al constructor vacío de la clase padre (ContenidoAudio)
    }

    // Constructor con parámetros (tanto de los atributos propios como los heredados)
    public Cancion(int id, String titulo, double duracionMinutos, int reproducciones, String album, String nombreArtista) {
        // "super(...)" se usa para enviar los datos que le pertenecen a la clase padre
        super(id, titulo, duracionMinutos, reproducciones);
        this.album = album;
        this.nombreArtista = nombreArtista;
    }
    // 3. GETTERS Y SETTERS ESPECÍFICOS DE CANCIÓN
  
    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    // 4. POLIMORFISMO CON @Override (R4)
    // Sobrescribimos el método "calcularCostoRoyalty" del padre, pero con una regla distinta:
    // Supongamos que a las canciones les damos un bono especial por reproducción (0.08 en lugar de 0.05).
    @Override
    public double calcularCostoRoyalty() {
        // Multiplicamos las reproducciones heredadas por una tarifa de 0.08
        return this.getReproducciones() * 0.08;
    }
}

