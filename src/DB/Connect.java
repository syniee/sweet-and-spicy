
package DB;

import java.sql.*;


public class Connect {

    public Connection conn;

    public Connection getConn(){
        return conn;
    }
    public Connect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");             
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=MYCAYTRASUA; user=sa;password=sa2008");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("DB.Connect.<init>()");
        }
    }
    

}

//        Properties p = new Properties();
//        try {
//            FileReader fin = new FileReader(new File("connection.properties"));
//            p.load(fin);
//            String host = p.getProperty("ID");
//            String port = p.getProperty("Port");
//            String dbname = p.getProperty("DatabaseName");
//            String user = p.getProperty("Username");
//            String pw = p.getProperty("Password");
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            String url = "jdbc:sqlserver://" + host + ":" + port + ";databaseName=" + dbname;
//            conn = DriverManager.getConnection(url, user, pw);
//        } catch (ClassNotFoundException e) {
//            JOptionPane.showMessageDialog(null, "Lỗi 100:: Không tìm thấy lớp");
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Lỗi 101:: Không thể kết nối đến máy chủ");
//        } catch (NullPointerException e) {
//            JOptionPane.showMessageDialog(null, "Lỗi 102:: Cấu hình bị trống");
//        } catch (Exception e) {
//        }
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

