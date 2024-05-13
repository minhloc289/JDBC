package Database;

import java.sql.*;

public class JDBCUtil {
    /*public static Connection getConnection() {
            Connection conn = null;
            try {
                // dang ky driver
                DriverManager.registerDriver(new SQLServerDriver());

                // thong so
                String url = "jdbc:sqlserver://DESKTOP-DAFL3UN\\SQLEXPRESS:1433;databaseName=test;encrypt=false";
                String username = "sa";
                String password = "28092004";

                // tao ket noi
                conn = DriverManager.getConnection(url, username, password);
                System.out.println("Ket noi thanh cong!!");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return conn;
        }
        public static void closeConnection (Connection conn) {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        public static void printInfo (Connection conn) {
            try {
                if (conn != null) {
                    DatabaseMetaData dt = conn.getMetaData();
                    System.out.println("Database name: " + dt.getDatabaseProductName());
                    System.out.println("Version: " + dt.getDatabaseProductVersion());
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }*/
    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // dang ky driver

            // Thong so ket noi
            String url = "jdbc:sqlserver://DESKTOP-DAFL3UN\\SQLEXPRESS:1433;databaseName=test;encrypt=false";
            String userName = "sa";
            String password = "28092004";

            // Ket noi
            Connection connect = DriverManager.getConnection(url,userName,password);
            System.out.println("Ket noi thanh cong!");
            System.out.println("Database: " + connect.getMetaData().getDatabaseProductName());
            System.out.println("Version: " + connect.getMetaData().getDatabaseProductVersion());
            System.out.println("----------------------------------------------------------");

            // Bat dau transaction
            connect.setAutoCommit(false);

            System.out.println("Thong tin thanh vien nhom: ");
            String sql = "select * from THANHVIEN";
            Statement statement = connect.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                System.out.println(rs.getString("MSSV") + ": " + rs.getString("HOTEN"));
            }

            // Ket thuc transaction
            connect.commit();
            System.out.println("Transaction thanh cong!");
            // Dong ket noi
            connect.close();
            /*String sql1 = "INSERT THANHVIEN VALUES('2252xxxx', 'Cai Pham Nong A')";
            Statement statement1 = connect.createStatement();
            int rs1 = statement1.executeUpdate(sql1);
            if (rs1 > 0){
                System.out.println("Them thanh cong!");
            }
*/
            /*String sql2 = "DELETE FROM THANHVIEN WHERE HOTEN = 'Cai Pham Nong A'";
            Statement statement2 = connect.createStatement();
            int delete = statement2.executeUpdate(sql2);
            if (delete == 1){
                System.out.println("Da xoa thanh cong!");
            }
            else {
                System.out.println("Xoa khong thanh cong!");
            }*/

            /*String sql3 = "DELETE FROM THANHVIEN";
            Statement statement3 = connect.createStatement();
            int delete = statement3.executeUpdate(sql3);
            if (delete > 0) {
                System.out.println("Da xoa tat ca cac dong");
            }
*/
            /*String sql4 = "DROP TABLE THANHVIEN";
            Statement statement4 = connect.createStatement();
            statement4.execute(sql4);
            System.out.println("Da xoa bang thanh cong!");*/

            /*String sql5 = "UPDATE THANHVIEN SET MSSV = ? WHERE HOTEN = ?";
            PreparedStatement prs = connect.prepareStatement(sql5);
            prs.setString(1, "2252yyyy");
            prs.setString(2, "Cai Pham Nong A");
            prs.executeUpdate();
            System.out.println("Da update cho sinh vien 2252xxxx!");*/

            /*String sqlCall = "{call countThanhVien}";
            CallableStatement call = connect.prepareCall(sqlCall);
            ResultSet resultSet = call.executeQuery();
            if (resultSet.next()) {
                int totalCount = resultSet.getInt(1);
                System.out.println("Tổng thành viên: " + totalCount);
            }*/
            /*String sqlCall1 = "{call deleteThanhVien(?)}";
            CallableStatement call1 = connect.prepareCall(sqlCall1);
            call1.setString(1,"2252yyyy");
            call1.execute();*/
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

