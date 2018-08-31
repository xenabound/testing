package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




    public class Koneksi {

        private Koneksi instance;
        private Connection connection;

        public Koneksi getInstance() {
            if (instance == null) {
                return new Koneksi();
            } else {
                return instance;
            }
        }

        public Connection getConnection() {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                this.connection = (Connection)
                        DriverManager.getConnection("jdbc:mysql://localhost:3306/Mahasiswa",
                                "root", "root");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }

            return connection;
        }
    }


