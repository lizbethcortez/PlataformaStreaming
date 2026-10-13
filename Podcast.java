
package com.mycompany.plataformastreaming;

// Nuevamente usamos "extends ContenidoAudio" (Herencia - R3).
// Significa que "Podcast" también es hijo de "ContenidoAudio" y comparte sus atributos y métodos base.
public class Podcast extends ContenidoAudio {

    // 1. ATRIBUTOS PROPIOS DEL PODCAST
    private int numeroEpisodio;       // El número del episodio dentro de la temporada
    private String invitadoEspecial;  // Nombre del invitado (si aplica)

    // 2. CONSTRUCTORES
    // Constructor vacío
    public Podcast() {
        super();
    }
    // Constructor con parámetros (los propios y los heredados del padre)
    public Podcast(int id, String titulo, double duracionMinutos, int reproducciones, int numeroEpisodio, String invitadoEspecial) {
        super(id, titulo, duracionMinutos, reproducciones); // Mandamos los datos base al padre
        this.numeroEpisodio = numeroEpisodio;//this.numeroEpisodio es el atributo y numeroEpisodio es el valor
        this.invitadoEspecial = invitadoEspecial;
    }

    // 3. GETTERS Y SETTERS ESPECÍFICOS DE PODCAST
    public int getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public void setNumeroEpisodio(int numeroEpisodio) {
        this.numeroEpisodio = numeroEpisodio;
    }

    public String getInvitadoEspecial() {
        return invitadoEspecial;
    }

    public void setInvitadoEspecial(String invitadoEspecial) {
        this.invitadoEspecial = invitadoEspecial;
    }

    // 4. POLIMORFISMO CON @Override (R4)
    // Aquí volvemos a aplicar polimorfismo. A diferencia de las canciones (que cobran por reproducción),
    // a los podcasts les pagamos una tarifa fija por episodio más un bono si tuvieron un invitado especial.
    @Override
    public double calcularCostoRoyalty() {
        double pagoBaseEpisodio = 15.0; // Tarifa fija por cada episodio de podcast
        
        // Si el podcast tuvo un invitado especial, le sumamos un bono extra de 10.0
        if (this.invitadoEspecial != null && !this.invitadoEspecial.isEmpty()) {//El operador "YY" Significa que ambas condiciones de los lados deben cumplirse al mismo tiempo para que lo de adentro del if pase.
            return pagoBaseEpisodio + 10.0;
        } else {
            return pagoBaseEpisodio;
        }
    }
}
//"Si el invitado especial tiene un nombre escrito (ya no está nulo ni vacío)..."
//En ese caso se ejecuta la primera línea (return pagoBaseEpisodio + 10.0;), 
//lo que significa que a los 15.0 de base se le suman 10.0 extra de bono por haber tenido invitado.
//Y si es falso (else), significa que no hubo invitado, por lo que se va al else y solo regresa 
//la tarifa normal de pagoBaseEpisodio (15.0).