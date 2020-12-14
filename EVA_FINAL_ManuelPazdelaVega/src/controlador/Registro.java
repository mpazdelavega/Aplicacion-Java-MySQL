package controlador;

import bd.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Paciente;


public class Registro {
    
    private static final String SQL_INSERT  = "INSERT INTO PACIENTE VALUES(?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE  = "UPDATE PACIENTE SET nombre = ?, genero = ?, edad = ?, direccion = ?, ciudad = ?, isapre = ?, donante = ? WHERE rut = ?";
    private static final String SQL_DELETE  = "DELETE FROM PACIENTE WHERE rut = ?";
    private static final String SQL_READ    = "SELECT * FROM PACIENTE WHERE rut = ?";
    private static final String SQL_READALL = "SELECT * FROM PACIENTE ORDER BY rut";
    
    private PreparedStatement ps;
    private ResultSet rs;
    
    private static final Conexion CONEXION = Conexion.obtenerEstadoConexion();
    
    public boolean create(Paciente t) {
        try 
        {
            ps = CONEXION.getConexion().prepareStatement(SQL_INSERT);
            ps.setString(1, t.getRut());
            ps.setString(2, t.getNombre());
            ps.setString(3, t.getGenero());
            ps.setInt(4, t.getEdad());
            ps.setString(5, t.getDireccion());
            ps.setString(6, t.getCiudad());
            ps.setString(7, t.getIsapre());
            ps.setInt(8, t.getDonante());


            if(ps.executeUpdate() > 0)
            {
                return true;
            }
        } 
        catch (SQLException e) 
        {
            return false;
        }
        finally
        {
            CONEXION.cerrarConexion();
        }
        return false;
    }
    
    public boolean update(Paciente t) {
        try 
        {
            ps = CONEXION.getConexion().prepareStatement(SQL_UPDATE);
            
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getGenero());
            ps.setInt(3, t.getEdad());
            ps.setString(4, t.getDireccion());
            ps.setString(5, t.getCiudad());
            ps.setString(6, t.getIsapre());
            ps.setInt(7, t.getDonante());
            ps.setString(8, t.getRut());

            
            if(ps.executeUpdate() > 0)
            {
                return true;
            }
        } 
        catch (SQLException e) 
        {
            return false;
        }
        finally
        {
            CONEXION.cerrarConexion();
        }
        return false;
    }
    
    public boolean delete(Object key) {
        try
        {
            ps = CONEXION.getConexion().prepareStatement(SQL_DELETE);
            ps.setString(1, (String) key);
            if(ps.executeUpdate() > 0 )
            {
                return true;
            }
        }
        catch(SQLException ex)
        {
            return false;
        }
        finally
        {
            CONEXION.cerrarConexion();
        }
        return false;
    }
    
    public Paciente read(Object key) {
        Paciente p = null;
        
        try
        {
            ps = CONEXION.getConexion().prepareStatement(SQL_READ);
            ps.setString(1, (String) key);
            rs = ps.executeQuery();
            if(rs.next())
            {
                p = new Paciente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getString(6), rs.getString(7),rs.getInt(8));
            }
        }
        catch(SQLException e)
        {
            return null;
        }
        finally
        {
            CONEXION.cerrarConexion();
        }
        return p;
    }
    
    public ArrayList<Paciente> readAll() {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        try
        {
            ps = CONEXION.getConexion().prepareStatement(SQL_READALL);
            rs = ps.executeQuery();
            while(rs.next())
            {
                pacientes.add(new Paciente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),rs.getString(6), rs.getString(7),rs.getInt(8)));
            }
        }
        catch(SQLException e)
        {
            return null;
        }
        finally
        {
            CONEXION.cerrarConexion();
        }
        return pacientes;
    }
}
