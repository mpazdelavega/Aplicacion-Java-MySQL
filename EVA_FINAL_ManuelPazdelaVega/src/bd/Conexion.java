
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {
    public static Conexion instance; 
    private Connection conexion;
    
    private final String USER = "root";
    private final String PASSWORD = "";
    private final String SERVER = "localhost:3306";
    private final String BBDD = "consultaMedica";
    
     private Conexion(){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + SERVER + "/" + BBDD;
            conexion = DriverManager.getConnection(url,USER,PASSWORD);
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Problemas para conectarse a la base de datos.", 
                    "Mensajes", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public synchronized static Conexion obtenerEstadoConexion(){
        if(instance == null)
        {
            instance = new Conexion();
        }
        return instance;
    }
    
    public Connection getConexion(){
        return conexion;
    }
    
    public void cerrarConexion(){
        instance = null;
    }
}