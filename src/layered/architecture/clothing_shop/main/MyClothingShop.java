package layered.architecture.clothing_shop.main;
/**
 * A simple clothing shop. I created it in order to practice layered architecture!
 *
 */

import layered.architecture.clothing_shop.dao.ClothesDAOImpl;
import layered.architecture.clothing_shop.dao.IClothesDAO;
import layered.architecture.clothing_shop.dto.ClothesDTO;
import layered.architecture.clothing_shop.service.ClothesServiceImpl;
import layered.architecture.clothing_shop.service.IClothesService;

import java.util.Scanner;

public class MyClothingShop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        IClothesDAO dao = new ClothesDAOImpl();// I call that because in the next line I need the dao!!!
        IClothesService service = new ClothesServiceImpl(dao);// I am bringing service here because that layer calls the mapper to translate my data

        boolean running = true;

        while (running) {
            printMenu();

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1: { // Add new item
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter size: ");
                    String size = scanner.nextLine();

                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // consume leftover newline

                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();

                    System.out.print("Enter stock quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    service.addClothes(new ClothesDTO(name, category, price));
                    break;
                }
                case 2:{// View all
                    System.out.println("The clothes that are currently in our site are: ");
                    System.out.println(service.findAllClothes());
                    break;
                }
                case 3: {// Find by category
                    System.out.println("Give the category of clothes you want to check: ");
                    String category = scanner.nextLine();

                    System.out.println("🧾 Clothes in category '" + category + "':");
                    service.findClothesByCategory(category).forEach(System.out::println);
                    break;
                }
                case 4: {
                    System.out.println("These clothes are out of stock:");
                    System.out.println(service.findAllOutOfStock());
                    break;
                }
                case 5:
                    System.out.println("Type the name of the cloth you want to update the price: ");
                    String clothForUpdate = scanner.nextLine();
                    double updatedPrice = scanner.nextDouble();

                    service.updatePrice(clothForUpdate, updatedPrice);
                    System.out.println("The price has been updated!");
                    break;
                case 6: {
                    System.out.println("Type the name of the cloth you want to delete: ");
                    String deleteCloth = scanner.nextLine();
                    service.deleteClothesByName(deleteCloth);
                    System.out.println("The cloth has been deleted successfully");
                    break;
                }
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }
    public static void printMenu() {
        System.out.println("\n--- CLOTHING SHOP MENU ---");
        System.out.println("1. Add new clothing item");
        System.out.println("2. View all clothes");
        System.out.println("3. Find clothes by category");
        System.out.println("4. Find out-of-stock clothes");
        System.out.println("5. Update price");
        System.out.println("6. Delete by name");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }
}

