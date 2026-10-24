package com.mycompany.plataformastreaming;

import java.util.ArrayList;
import java.util.Scanner;

public class PlataformaStreaming {

    public static void main(String[] args) {//Main es el punto de entrada y el motor principal de cualquier programa en Java
        
        //1. CREACIÓN DE LAS LISTAS (Nuestra base de datos temporal en memoria)
        //ArrayList guardar mis salidas, en otras palabras, lo que el usuario ingresa en la consola
        //La lista de contenidos es de tipo "ContenidoAudio" (la clase padre), 
        //lo que nos permite guardar tanto Canciones como Podcasts juntos gracias al Polimorfismo.
        ArrayList<ContenidoAudio> listaContenidos = new ArrayList<>();
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        
        //El Scanner sirve para leer lo que el usuario escriba con el teclado en la consola.
        Scanner scanner = new Scanner(System.in);
        
        //Esta variable "opcion" guardará el número que el usuario elija en el menú.
        int opcion = 0;

        //2.EL BUCLE DO-WHILE (Para que el menú no se cierre solo)
        //Un "do-while" ejecuta el bloque al menos una vez y se repite siempre y cuando 
        //la condición (en este caso, que la opción sea diferente de 5) se cumpla.
        do {
            //Imprimimos el menú visual en la consola
            System.out.println("\n========================================");//salto de línea
            System.out.println("   PLATAFORMA DE STREAMING - MENÚ CRUD  ");
            System.out.println("========================================");
            System.out.println("1. Registrar una nueva Canción");
            System.out.println("2. Registrar un nuevo Podcast");
            System.out.println("3. Registrar un nuevo Usuario");
            System.out.println("4. Mostrar todo el contenido y usuarios");
            System.out.println("5. Salir del sistema");
            System.out.print("Elige una opción (1-5): ");

            // 3. VALIDACIÓN DE ENTRADA (Para evitar que el programa truene con letras)
            //"hasNextInt()" pregunta: ¿Lo que escribió el usuario es un número entero?
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt(); //Guardamos el número elegido
                scanner.nextLine(); //Limpiamos el "buffer" de la consola

                // 4. SWITCH (Es un desvío que dirige al usuario según su elección)
                switch (opcion) {
                    case 1:
                        //CREAR / REGISTRAR UNA CANCIÓN
                        System.out.println("\n--- REGISTRAR CANCIÓN ---");
                        System.out.print("ID numérico: ");
                        int idC = scanner.nextInt();
                        scanner.nextLine();// Limpiar enter
                        
                        System.out.print("Título de la canción: ");
                        String tituloC = scanner.nextLine();
                        
                        System.out.print("Duración en minutos (ej. 3.5): ");
                        double duracionC = scanner.nextDouble();
                        
                        System.out.print("Número de reproducciones: ");
                        int repsC = scanner.nextInt();
                        scanner.nextLine();//Limpiar enter
                        
                        System.out.print("Álbum: ");
                        String albumC = scanner.nextLine();
                        
                        System.out.print("Nombre del Artista: ");
                        String artistaC = scanner.nextLine();

                        //Creamos el objeto Cancion usando su constructor con parámetros
                        Cancion nuevaCancion = new Cancion(idC, tituloC, duracionC, repsC, albumC, artistaC);
                        
                        //Guardamos la canción en la lista general de contenidos
                        listaContenidos.add(nuevaCancion);
                        System.out.println("¡Canción registrada con éxito!");
                        break;// "break" detiene el switch para que no ejecute los demás casos

                    case 2:
                        //CREAR / REGISTRAR UN PODCAST
                        System.out.println("\n--- REGISTRAR PODCAST ---");
                        System.out.print("ID numérico: ");
                        int idP = scanner.nextInt();
                        scanner.nextLine();
                        
                        System.out.print("Título del episodio: ");
                        String tituloP = scanner.nextLine();
                        
                        System.out.print("Duración en minutos: ");
                        double duracionP = scanner.nextDouble();
                        
                        System.out.print("Número de reproducciones: ");
                        int repsP = scanner.nextInt();
                        
                        System.out.print("Número de episodio: ");
                        int numEp = scanner.nextInt();
                        scanner.nextLine(); // Limpiar enter
                        
                        System.out.print("Invitado especial (deja en blanco si no hubo): ");
                        String invitado = scanner.nextLine();

                        //Creamos el objeto Podcast
                        Podcast nuevoPodcast = new Podcast(idP, tituloP, duracionP, repsP, numEp, invitado);
                        
                        //Lo guardamos en la misma lista de contenidos
                        listaContenidos.add(nuevoPodcast);
                        System.out.println("¡Podcast registrado con éxito!");
                        break;

                    case 3:
                        //CREAR / REGISTRAR UN USUARIO
                        System.out.println("\n--- REGISTRAR USUARIO ---");
            
                        System.out.print("Nombre completo: ");
                        String nombreU = scanner.nextLine();

                        System.out.print("Correo electrónico: ");
                        String correoU = scanner.nextLine();

                        System.out.print("¿Es cuenta Premium? (escribe 'si' o 'no'): ");
                        String respuestaPremium = scanner.nextLine().trim().toLowerCase();
                        boolean premiumU = respuestaPremium.equals("si") || respuestaPremium.equals("true");

                        //Creamos el objeto Usuario pasándole solo nombre, correo y premium (el ID se genera solo)
                        Usuario nuevoUsuario = new Usuario(nombreU, correoU, premiumU);
                        listaUsuarios.add(nuevoUsuario);
                        System.out.println("¡Usuario registrado con éxito! Su ID asignado es: " + nuevoUsuario.getIdUsuario());
                        break;

                    case 4:
                        //LEER / MOSTRAR DATOS (Reporte General)
                        System.out.println("\n========================================");
                        System.out.println("     REPORTE GENERAL DE LA PLATAFORMA   ");
                        System.out.println("========================================");
                        
                        System.out.println("\n--- CONTENIDOS AUDIOVISUALES ---");
                        if (listaContenidos.isEmpty()) {
                            System.out.println("(No hay canciones ni podcasts registrados aún).");
                        } else {
                            //Usamos un bucle "for-each" para recorrer cada elemento de la lista.
                            //Aquí se nota el POLIMORFISMO: la variable "c" es de tipo ContenidoAudio, 
                            //pero al llamar a "c.calcularCostoRoyalty()", Java detecta automáticamente 
                            //si es Canción o Podcast y ejecuta la regla matemática correspondiente de cada uno.
                            for (ContenidoAudio c : listaContenidos) {
                                System.out.println("- Título: " + c.getTitulo() + 
                                                   " | Duración: " + c.getDuracionMinutos() + " min" + 
                                                   " | Reproducciones: " + c.getReproducciones() + 
                                                   " | Royalty calculado: $" + c.calcularCostoRoyalty());
                            }
                        }

                        System.out.println("\n--- USUARIOS REGISTRADOS ---");
                        if (listaUsuarios.isEmpty()) {
                            System.out.println("(No hay usuarios registrados aún).");
                        } else {
                            //Recorremos la lista de usuarios. Al imprimir "u", Java llama 
                            //automáticamente al método "toString()" que diseñamos en la clase Usuario.
                            for (Usuario u : listaUsuarios) {
                                System.out.println(u);
                            }
                        }
                        break;

                    case 5:
                        //SALIR DEL SISTEMA
                        System.out.println("\n¡Gracias por usar la plataforma de streaming! Saliendo del sistema...");
                        break;

                    default:
                        //Si ponen un número que no está en el menú (ej. 8 o 9) se imprime error
                        System.out.println("\n[Error] Opción no válida. Por favor elige un número entre 1 y 5.");
                }

            } else {
                //Si el usuario escribió letras en lugar de un número en el menú principal la consola pide núm. v+alido
                System.out.println("\n[Error] Debes ingresar un número válido.");
                scanner.next(); // Limpiamos la entrada incorrecta para que el programa no se trabe
                opcion = 0;
            }

        } while (opcion != 5); //Sirve para que el ciclo se repite mientras no elijan la opción 5

        scanner.close(); //Cerramos el scanner
    }
}
