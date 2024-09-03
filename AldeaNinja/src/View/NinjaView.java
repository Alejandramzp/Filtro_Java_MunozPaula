
package View;

import Controller.NinjaController;
import Model.NinjaModel;
import java.util.Scanner;



public class NinjaView {
    private NinjaController ninjaController;
    private Scanner scanner;

    public NinjaView() {
        this.ninjaController = new NinjaController();
        this.scanner = new Scanner(System.in);
    }
    
    public void displayMenu() {
        
        int option;
        do {
            System.out.println("-----------------------------------------");
            System.out.println("'         Gestión de Ninja:             '");
            System.out.println("'                                       '");
            System.out.println("'    1. Añadir Ninja                    '");
            System.out.println("'    2. Mostrar todas los Ninjas        '");
            System.out.println("'    3. Salir                           '");
            System.out.println("-----------------------------------------");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume la nueva línea

            switch (option) {
                case 1 -> addNinja();
                case 2 -> showAllNinjas();
                case 3 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (option != 3);
    }
    
    private void addNinja() {
        System.out.println("\n-----------------------------------------");
        System.out.println("           Añadir nuevo Ninja              ");
        System.out.println("-------------------------------------------");
        
        System.out.println("Nombre del Ninja: ");
        String nombre = scanner.nextLine();
        
        System.out.println("Rango númerico al que pertence: ");
        Double rango = scanner.nextDouble();
        scanner.nextLine();
      
        System.out.println("Aldea a la que pertenece el Ninja: ");
        String aldea = scanner.nextLine();
       
        NinjaModel ninja = new NinjaModel(0,nombre,rango,aldea);
        
        try {
            if (ninjaController.addNinja(ninja)) {
                System.out.println("Ninja añadido exitosamente.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }      
    }
    
    private void showAllNinjas() {
        System.out.println("\n----------------------------------------");
        System.out.println("     Listado de todos las Ninjas:         ");
        System.out.println("------------------------------------------");
        ninjaController.getAllNinja().forEach(ninja -> System.out.println(
                
                "-> ID: " + ninja.getId() +
                ", Nombre: " + ninja.getNombre() +
                ", Rango: " + ninja.getRango() +
                ", Aldea: " + ninja.getAldea() + "\n"));                
    }
    
    
    public static void main(String[] args) {
        NinjaView view = new NinjaView();
        view.displayMenu();
    }
}
