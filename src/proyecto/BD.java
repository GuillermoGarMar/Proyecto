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

    private String url = "jdbc:sqlite:Jugadores.db";
    private Connection conn = null;
    public static String db = "Jugadores.db";

    public BD() {
    }

    public void createnewBD() {

        url = "jdbc:sqlite:" + db;

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
            Connection con = DriverManager.getConnection("jdbc:sqlite:Jugadores.db");
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }

    public void crearTb(Connection c) throws SQLException {
        Statement st = c.createStatement();
        try {
            st.execute("CREATE TABLE ScoreTB (name String, score String);");
            System.out.println("Table created");
        } catch (SQLException ex) {
        }
    }

    public void insertarJugador(String n, String p, Connection cn) throws SQLException {
        try {
            PreparedStatement st = cn.prepareStatement("insert into ScoreTB (name,score) values (?,?)");
            st.setString(1, n);
            st.setString(2, p);
            st.execute();
        } catch (SQLException ex) {
            System.err.println("Registro no insertado");
        }
    }
    
    public void limpiar(Connection cn) throws SQLException{
        Statement st = cn.createStatement();
        Statement st2 = cn.createStatement();
        try {
            st.execute("Drop TABLE ScoreTB;");
            st2.execute("CREATE TABLE ScoreTB (name String, score String);");
            System.out.println("Table created");
        } catch (SQLException ex) {
        }
    }
    public void close(Connection cn) {
        try {
            cn.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexion");;
        }
    }
}
