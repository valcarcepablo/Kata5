package kata5d;

/**
 *
 * @author Alber
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static kata5d.MailListreader.read;
  

public class Kata5{

    public static void selectAll(){
         String sql = "SELECT * FROM PEOPLE";
         try (
             Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){
             // Bucle sobre el conjunto de registros.
             while (rs.next()) {
                 System.out.println(rs.getInt("id") + "\t" +
                 rs.getString("Name") + "\t" +
                 rs.getString("Apellidos") + "\t" +
                 rs.getString("Departamento") + "\t");
             }
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         }
    }
     
    public static void createNewTable() {
         String sql = "CREATE TABLE IF NOT EXISTS EMAIL (\n"
         + " id integer PRIMARY KEY AUTOINCREMENT,\n"
         + " mail text NOT NULL);";
         try (Connection conn = connect();Statement stmt = conn.createStatement()) {
             stmt.execute(sql);
         } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void insert(String email) {
        String sql = "INSERT INTO EMAIL(mail) VALUES(?)";
        try (
            Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            List<String> emails = read("email.txt");
            for (int i = 0;i<emails.size();i++) {
                insert(emails.get(i));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static Connection connect() throws SQLException {
         Connection conn = null;
         String url = "jdbc:sqlite:C:\\Users\\danil\\OneDrive\\Documentos\\NetBeansProjects\\\\DB_Sql";
         //C:\Users\danil\OneDrive\Escritorio\DB_SQLite
         //C:\Users\danil\OneDrive\Documentos\NetBeansProjects\\DB_Sql
         conn = DriverManager.getConnection(url);
         return conn;
    }

 }