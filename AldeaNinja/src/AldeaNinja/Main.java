
package AldeaNinja;

import java.util.Scanner;

public class Main {
    private Scanner scanner;

    public Main() {
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("------------------------------------------");
            System.out.println("'      Menú Principal de Aldea Ninja     '");
            System.out.println("' 1. Ninjas                              '");
            System.out.println("' 2. Habilidades                         '");
            System.out.println("' 3. Misiones                            '");
            System.out.println("' 4. Salir                               '");
            System.out.println("------------------------------------------");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (option) {
                case 1:
                   
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }
        } while (option != 7);
        
    }
    
    public static void main(String[] args) {
        Main menu = new Main();
        menu.showMenu();
    }
}