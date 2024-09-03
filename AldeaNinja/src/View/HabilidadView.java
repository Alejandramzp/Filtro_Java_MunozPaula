
package View;

import Controller.HabilidadController;
import Model.HabilidadModel;
import java.util.Scanner;

public class HabilidadView {
    private HabilidadController habilidadController;
    private Scanner scanner;

    public HabilidadView() {
        this.habilidadController = new HabilidadController();
        this.scanner = new Scanner(System.in);
    }
    
    public void displayMenu() {
        
        int option;
        do {
            System.out.println("-----------------------------------------");
            System.out.println("'         Gestión de Habilidades:       '");
            System.out.println("'                                       '");
            System.out.println("'    1. Añadir Habilidad                '");
            System.out.println("'    2. Salir                           '");
            System.out.println("-----------------------------------------");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume la nueva línea

            switch (option) {
                case 1 -> addHabilidad();
                case 2 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (option != 2);
    }
    
    private void addHabilidad() {
        System.out.println("\n-----------------------------------------");
        System.out.println("           Añadir nuevo Ninja              ");
        System.out.println("-------------------------------------------");
        
        int Id;
        
        // Validar el ID del evento
        while (true) {
            try {
                System.out.println("ID del Ninja: ");
                Id = scanner.nextInt();
                scanner.nextLine();
                
                if(habilidadController.isNinjaExists(Id)){
                    break; // Si no hay excepción, salir del bucle
                }else{
                    System.out.println("El Ninja no se encuentra registrado");
                } 
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Por favor, introduzca un ID de Ninja diferente.");
            }
        }
        
        
        System.out.println("Nombre de la Habilidad: ");
        String nombre = scanner.nextLine();
    
        System.out.println("Descripcion de la habilidad ");
        String descripcion = scanner.nextLine();
       
        HabilidadModel habi = new HabilidadModel(Id,nombre,descripcion);
        
        try {
            if (habilidadController.addHabilidad(habi)) {
                System.out.println("Habilidad añadido exitosamente.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }      
    } 
    
    public static void main(String[] args) {
        HabilidadView view = new HabilidadView();
        view.displayMenu();
    }
}
