package conector;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class Conectar {
		protected Connection cn;

		private String host = "localhost";
		private String bbdd = "proyecto";
		private String usuario = "root";
		private String contrasenia = "";

		public Conectar() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");

				this.cn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + bbdd, usuario, contrasenia);


			} catch (ClassNotFoundException e) {
				System.out.println("Error al importar Driver");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("Error conexion");
				e.printStackTrace();
			}
		}

		public void cerrar() {
			try {
				cn.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar la conexion");
				e.printStackTrace();
			}
		}

		public Connection getCn() {
			return cn;
		}

		public void setCn(Connection cn) {
			this.cn = cn;
		}
	}


