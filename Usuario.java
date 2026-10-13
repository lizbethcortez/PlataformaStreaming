
package com.mycompany.plataformastreaming;

public class Usuario {

    // 1. ATRIBUTOS (Datos del usuario)
    // Aplicamos Encapsulamiento (R2) usando "private" para proteger la información.
    private int idUsuario;
    private String nombre;
    private String correo;
    private boolean esPremium; // true si paga suscripción, false si es cuenta gratuita

    // 2. CONSTRUCTORES
    // Constructor vacío (para crear el objeto sin datos iniciales)
    public Usuario() {
    }

    // Constructor con parámetros (para inicializar todos los datos de golpe al registrarse)
    public Usuario(int idUsuario, String nombre, String correo, boolean esPremium) {
        this.idUsuario = idUsuario;//this.idUsuario es el atributo y idUsuario es el valor
        this.nombre = nombre;
        this.correo = correo;
        this.esPremium = esPremium;
    }

    // 3. GETTERS Y SETTERS (R2)
    //consultar (get) y modificar (set) los datos privados de forma segura.
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public boolean isEsPremium() {
        return esPremium;
    }

    public void setEsPremium(boolean esPremium) {
        this.esPremium = esPremium;
    }

    // 4. MÉTODO DE APOYO (toString)
    // Este método nos ayuda a convertir los datos del usuario en un texto legible 
    // para cuando queramos mostrarlos en la consola o en el menú de la plataforma.
    @Override //sobreescribir el método pero con una regla distinta
    public String toString() {
        String tipoCuenta = esPremium ? "Premium (De pago)" : "Gratuita";
        return "Usuario [ID: " + idUsuario + ", Nombre: " + nombre + ", Correo: " + correo + ", Tipo: " + tipoCuenta + "]";
    }
}