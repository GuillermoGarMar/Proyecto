/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author guille
 */
public class BD {
    private String url = "jdbc:sqlite:BD1.db";
    private Connection conn = null;
    public static String db = "BD1.db";

    public BD() {
    }

    public void createnewBD(String fileName) {

        url = "jdbc:sqlite:" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:BD1.db");
            JOptionPane.showMessageDialog(null, "La conexión está establecida");
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public void crearTb(Connection c) throws SQLException {
        Statement st = c.createStatement();
        try {
            st.execute("CREATE TABLE ScoreTB (name String primary key, score String);");
            System.out.println("Table created");
        } catch (SQLException ex) {
            System.err.println("Tabla ya creada");
        }
    }

    public void insertarJugador(String x, String y, Connection cn) throws SQLException {
        try {
            PreparedStatement st = cn.prepareStatement("insert into ScoreTB (name,score) values (?,?,?)");
            st.setString(2, x);
            st.setString(3, y);
            st.execute();
        } catch (SQLException ex) {
            System.err.println("Registro no insertado");
        }
    }
    


    public void Borrar(String id, Connection cn) throws SQLException {
        String sql = "DELETE FROM ScoreTB WHERE id = ?";
        PreparedStatement pstmt = cn.prepareStatement(sql);
        pstmt.setString(1, id);
        pstmt.executeUpdate();
    }
    
    public void close(Connection cn) {
        try {
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexion");;
        }
    }
}
