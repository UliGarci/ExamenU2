package mx.edu.utez.hm.utils;

import java.sql.*;

public class MySQLConection {
    public static Connection getConnection() throws SQLException {
        String host = "127.0.0.1";
        String port = "3306";
        String database ="shop";
        String useSSL = "false";
        String timezone = "UTC";
        String url=String.format("jdbc:mysql://%s:%s/%s?useSSL=%s&serverTimezone=%s",host,port,database,useSSL,timezone);
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        return DriverManager.getConnection(url,"root","");
    }
    public void closeConexion(Connection con, PreparedStatement ps, ResultSet rs){
        try {
            if(con!=null){
                con.close();
            }
            if(ps!=null){
                ps.close();
            }
            if(rs!=null){
                rs.close();
            }
        }catch(SQLException e){
            System.out.println("Error en el cierre de conexiones -> "+e.getMessage());
        }
    }

    //PROBAR CONEXIÓN
    public static void main(String[] args) {
        try{
            Connection con = getConnection();
            System.out.println("Conexión exitosa ☺");
            con.close();
        }catch(SQLException e){
            System.out.println("Conexión fallida"+ e.getMessage());
        }
    }
}
