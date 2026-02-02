package restaurant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FoodItemDAOImpl implements FoodItemDAO {

    @Override
    public void addFoodItem(FoodItemDTO food) {
        String sql = "INSERT INTO food_items(name,category,price,available) VALUES(?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, food.getName());
            ps.setString(2, food.getCategory());
            ps.setDouble(3, food.getPrice());
            ps.setBoolean(4, food.isAvailable());
            ps.executeUpdate();

            System.out.println("Food item added successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<FoodItemDTO> viewFoodItems() {
        List<FoodItemDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM food_items";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new FoodItemDTO(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getBoolean("available")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public FoodItemDTO getFoodById(int id) {
        String sql = "SELECT * FROM food_items WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new FoodItemDTO(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getBoolean("available")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updatePrice(int id, double price) {
        String sql = "UPDATE food_items SET price=? WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, price);
            ps.setInt(2, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteFoodItem(int id) {
        String sql = "DELETE FROM food_items WHERE id=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<FoodItemDTO> getFoodByCategory(String category) {
        List<FoodItemDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM food_items WHERE category=?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, category);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new FoodItemDTO(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getBoolean("available")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
