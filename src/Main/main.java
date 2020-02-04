package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class main {

    public static void main(String[] args) {
        String URL_BD_SQLite = new String("jdbc:sqlite:C:\\Users\\danil\\OneDrive\\Documentos\\NetBeansProjects\\\\DB_Sql\\\\miErcoles1030.db");
        //C:\Users\danil\OneDrive\Documentos\NetBeansProjects\\DB_Sql\\miErcoles1030.db
        Connection connection = connect(URL_BD_SQLite);
    }

    private static Connection connect(String URL_BD_SQLite) {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL_BD_SQLite);
            System.out.println("Base de datos conectada...");
            selectData_PEOPLE(connection);
            insertData_PEOPLE(connection);
            System.out.print("\n");
            selectData_PEOPLE(connection);
        }
        catch(SQLException exception){
            System.out.println("Error Kata5 ::Connect " + exception.getMessage());
        }
        finally{
            try{
                if(connection != null){
                    connection.close();
                }
            }
            catch(SQLException exception){
                System.out.println("Error Kata5 ::Connect " + exception.getMessage());
            }
        }
        return connection;
    }

    private static void insertData_PEOPLE(Connection connection) {
        String SQL = "INSERT INTO PEOPLE(ID,NOMBRE,APELLIDOS,DEPARTAMENTO) values (?,?,?,?)";
        try{
            PreparedStatement preparedstatement = connection.prepareStatement(SQL);
            preparedstatement.setInt(1,25);
            preparedstatement.setString(2, "Juan");
            preparedstatement.setString(3, "Pepe");
            preparedstatement.setString(4, "Tomas");
            preparedstatement.executeUpdate();
        }
        catch(SQLException exception){
            System.out.println("Error Kata5 ::insertData_PEOPLE " + exception.getMessage());
        }
    }
    
    private static void selectData_PEOPLE(Connection connection) {
        String SQL = "SELECT * FROM PEOPLE";
        try{
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery(SQL);
            System.out.println("ID \t NOMBRE \t APELLIDOS \t DEPARTAMENTO");
            while(resultset.next()){
                System.out.println(resultset.getInt("ID") + " \t " + 
                                   resultset.getString("NOMBRE") + " \t \t " + 
                                   resultset.getString("APELLIDOS") + " \t " + 
                                   resultset.getString("DEPARTAMENTO"));
            }
        }
        catch(SQLException exception){
            System.out.println("Error Kata5 ::selectData_PEOPLE " + exception.getMessage());
        }
    }
}