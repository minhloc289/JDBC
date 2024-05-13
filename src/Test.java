import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa"); // username
        ds.setPassword("28092004"); //password
        ds.setServerName("DESKTOP-DAFL3UN\\SQLEXPRESS"); // server name
        ds.setPortNumber(1433); // port number
        ds.setDatabaseName("test"); // database name
        ds.setEncrypt("False");

        try (Connection con = ds.getConnection()) {
            System.out.println("Ket noi thanh cong");
            System.out.println(con.getMetaData());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
