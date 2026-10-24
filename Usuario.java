package com.mycompany.plataformastreaming;

public class Usuario {
    
    //Variable estática para llevar el control automático del ID (Empieza en 1)
    private static int contadorId = 1; 
    
    //1.ATRIBUTOS (Datos del usuario)
    private int idUsuario;
    private String nombre;
    private String correo;
    private boolean esPremium; // true si paga suscripción, false si es cuenta gratuita

    //2.CONSTRUCTORES
    //Constructor vacío
    public Usuario() {
    }

    //Constructor automático: Ya NO pide el ID por parámetro, lo genera solo sumando 1
    public Usuario(String nombre, String correo, boolean esPremium) {
        this.idUsuario = contadorId++; //Asigna el ID actual y luego incrementa el contador
        this.nombre = nombre;
        this.correo = correo;
        this.esPremium = esPremium;
    }

    //3.GETTERS Y SETTERS
    public int getIdUsuario() {
        return idUsuario;
    }
    //(Nota: Ya no necesito un setIdUsuario porque el sistema lo asigna solo de forma segura)

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

    //4.MÉTODO TOSTRING (Para imprimir los datos limpios)
    @Override
    public String toString() {
        return "ID: " + idUsuario + " | Nombre: " + nombre + " | Correo: " + correo + " | Premium: " + (esPremium ? "Sí" : "No");
    }
}
