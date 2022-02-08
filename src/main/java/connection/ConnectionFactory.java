
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author SARA
 */
public class ConnectionFactory {
        
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql:localhost:3360/erp";
    private static final String USER = "root";
    private static final String PASSWORD = "root";


        
    public static Connection getConnection(){
        
        Connection conexao = null;
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver não localizado");
        } catch (SQLException ex){
            System.out.println("Erro ao acessar o banco" + ex.getMessage());
        } 
        return conexao;
    }
    
    public static void closeConnection (Connection con){
        if(con != null){
                try{
                    con.close();
                } catch (SQLException ex){
                    System.out.println("Erro ao fechar conexão" + ex.getMessage());
                }   
         }
    }

    public static void closeConnection (Connection con, PreparedStatement stmt){
        
        closeConnection(con);
        if(stmt != null){
            try{
                stmt.close();
            } catch (SQLException ex){
                    System.out.println("Erro ao fechar conexão" + ex.getMessage());
            }   
         }
    }
    
    public static void closeConnection (Connection con, PreparedStatement stmt, ResultSet rs){
        
        closeConnection(con, stmt);
        if(rs != null){
            try{
                rs.close();
            } catch (SQLException ex){
                    System.out.println("Erro ao fechar conexão" + ex.getMessage());
            }   
         }
    }
    
}
