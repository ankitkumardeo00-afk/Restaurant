package restaurant;

import java.util.List;

public interface FoodItemDAO {

    void addFoodItem(FoodItemDTO food);

    List<FoodItemDTO> viewFoodItems();

    FoodItemDTO getFoodById(int id);

    boolean updatePrice(int id, double price);

    boolean deleteFoodItem(int id);

    List<FoodItemDTO> getFoodByCategory(String category);
}
