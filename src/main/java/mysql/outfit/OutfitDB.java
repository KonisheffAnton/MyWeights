package mysql.outfit;


import java.sql.*;
import java.util.ArrayList;
 
public class OutfitDB {
 
    private static String url = "jdbc:mysql://localhost/outfit?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private static String password = "1625031995";
    
    public static ArrayList<ExerciseC> select() {
         
        ArrayList<ExerciseC> exercises = new ArrayList<ExerciseC>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM exercises");
                while(resultSet.next()){
                      
                    int id = resultSet.getInt(1);
                    String nameEx = resultSet.getString(2);
                    int weight = resultSet.getInt(3);
                    ExerciseC exercise = new ExerciseC(id, nameEx, weight);
                    exercises.add(exercise);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return exercises;
    }
    public static ExerciseC selectOne(int id) {
         
    	ExerciseC exercise = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "SELECT * FROM exercises WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
 
                        int prodId = resultSet.getInt(1);
                        String nameEx = resultSet.getString(2);
                        int weight = resultSet.getInt(3);
                        exercise = new ExerciseC(prodId, nameEx, weight);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return exercise;
    }
    public static int insert(ExerciseC exercise) {
         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "INSERT INTO exercises (exercise, weight) Values (?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, exercise.getName());
                    preparedStatement.setInt(2, exercise.getWeight());
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
     
    public static int update(ExerciseC exercise) {
         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "UPDATE products SET name = ?, exercise = ? WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, exercise.getName());
                    preparedStatement.setInt(2, exercise.getWeight());
                    preparedStatement.setInt(3, exercise.getId());
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    public static int delete(int id) {
         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "DELETE FROM exercises WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}
