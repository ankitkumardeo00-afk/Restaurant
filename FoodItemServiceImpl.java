package restaurant;

import java.util.List;
import java.util.Scanner;

public class FoodItemServiceImpl implements FoodItemService {

    private final FoodItemDAO dao = new FoodItemDAOImpl();
    private final Scanner sc = new Scanner(System.in);

    @Override
    public void addFood() {
        System.out.print("Food Name: ");
        String name = sc.nextLine();
        System.out.print("Category: ");
        String category = sc.nextLine();
        System.out.print("Price: ");
        double price = Double.parseDouble(sc.nextLine());
        System.out.print("Available (true/false): ");
        boolean available = Boolean.parseBoolean(sc.nextLine());

        dao.addFoodItem(new FoodItemDTO(0, name, category, price, available));
    }

    @Override
    public void showFoodItems() {
        List<FoodItemDTO> list = dao.viewFoodItems();
        list.forEach(f ->
                System.out.println(f.getId()+" | "+f.getName()+" | "+
                        f.getCategory()+" | "+f.getPrice()+" | "+f.isAvailable()));
    }

    @Override
    public void searchFood() {
        System.out.print("Enter Food ID: ");
        int id = Integer.parseInt(sc.nextLine());

        FoodItemDTO f = dao.getFoodById(id);
        if (f != null)
            System.out.println(f.getId()+" | "+f.getName()+" | "+
                    f.getCategory()+" | "+f.getPrice()+" | "+f.isAvailable());
        else
            System.out.println("Food item not found");
    }

    @Override
    public void updateFoodPrice() {
        System.out.print("Food ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("New Price: ");
        double price = Double.parseDouble(sc.nextLine());

        System.out.println(dao.updatePrice(id, price)
                ? "Price updated" : "Update failed");
    }

    @Override
    public void deleteFood() {
        System.out.print("Food ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.println(dao.deleteFoodItem(id)
                ? "Food item deleted" : "Delete failed");
    }

    @Override
    public void showByCategory() {
        System.out.print("Enter Category: ");
        String category = sc.nextLine();

        dao.getFoodByCategory(category)
           .forEach(f -> System.out.println(f.getId()+" | "+f.getName()+" | "+f.getPrice()));
    }
}
