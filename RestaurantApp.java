package restaurant;

import java.util.Scanner;

public class RestaurantApp {

    public static void main(String[] args) {

        FoodItemService service = new FoodItemServiceImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- RESTAURANT MENU ---");
            System.out.println("1. Add Food Item");
            System.out.println("2. View Food Items");
            System.out.println("3. Search Food by ID");
            System.out.println("4. Update Food Price");
            System.out.println("5. Delete Food Item");
            System.out.println("6. View Food by Category");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> service.addFood();
                case 2 -> service.showFoodItems();
                case 3 -> service.searchFood();
                case 4 -> service.updateFoodPrice();
                case 5 -> service.deleteFood();
                case 6 -> service.showByCategory();
                case 7 -> {
                    System.out.println("Thank you!");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}
