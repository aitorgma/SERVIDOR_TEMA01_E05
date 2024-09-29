import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static ArrayList<Dispositivos> dispositivos;

    public static void main(String[] args) throws Exception {
        //Creamos el Array con las 3 clases de dispositivos que tenemos
        dispositivos = new ArrayList<>();
        dispositivos.add(new Termostato());
        dispositivos.add(new Ascensor());
        dispositivos.add(new Radio());
        
        try (Scanner teclado = new Scanner(System.in)) {
            int opcion;
            //Realizamos un bucle do while para mostrar al iniciar el estado de los dispositivos
            do {
                mostrarEstadoDispo();

                System.out.println("\nMenu domótica");
                System.out.println("1. Subir un dispositivo");
                System.out.println("2. Bajar un dispositivo");
                System.out.println("3. Resetear un dispositivo");
                System.out.println("4. Revisar termostato");
                System.out.println("0. Salir");
                
                //Creamos un submenú para seleccionar sobre qué dispositivo se hará la accion anterior.
                opcion= teclado.nextInt();
                if (opcion !=0) {
                    System.out.println("Selecciona tipo de dispositivo:\n1.TERMOSTATO\n2.ASCENSOR\n3.RADIO");
                    int seleccionDispo= teclado.nextInt()-1;
                    if (seleccionDispo < 0 || seleccionDispo >= dispositivos.size()){
                        System.out.println("No hay ningún dispositivo asociado a esa opción");
                        continue;
                    }
                    switch (opcion) {
                        case 1 -> {
                            if (!dispositivos.get(seleccionDispo).subir()){
                                System.out.println("No se puede subir más, está en su valor máximo");
                            }
                        }
                        case 2 -> {
                            if (!dispositivos.get(seleccionDispo).bajar()){
                                System.out.println("No se puede bajar más, está en su valor mínimo");
                            }
                        }
                        case 3 -> {
                            dispositivos.get(seleccionDispo).reset();
                            System.out.println("Valor inicial establecido");
                        }
                        case 4 -> {
                            //Verificar si el dispo seleccionado es un Termostato
                            if (dispositivos.get(seleccionDispo) instanceof Termostato termostato){
                                termostato.revisar();
                            } else {
                                System.out.println("El dispositivo seleccionado no es el Termostato. Marque la opción correcta");
                            }
                        }
                        default -> System.out.println("Opción no válida.");
                    }
                }
            } while (opcion !=0);
        }
    }

    private static void mostrarEstadoDispo(){
    System.out.println("\nEstado actual dispositivos:");
    for (Dispositivos d : dispositivos){
        System.out.println(d.verEstado());
    }


}

}