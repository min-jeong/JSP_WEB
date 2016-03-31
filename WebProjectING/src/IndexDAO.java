import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




	public class IndexDAO {
		
		public List<IndexVO> getAllIndex() {

			loadOracleDriver();

			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;

			List<IndexVO> Indexs = new ArrayList<IndexVO>();

			try {

				IndexVO indexx = null;

				conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER, Const.DB_PASSWORD);

				
				String query = XML.getNodeString("//query/getAllIndex/text()");
				stmt = conn.prepareStatement(query);
		
				rs = stmt.executeQuery();

				while (rs.next()) {
					indexx = new IndexVO();
					indexx.setMemName(rs.getString("MEM_NAME"));
					indexx.setMemNumber(rs.getInt("MEM_NUM"));
					Indexs.add(indexx);
				}

			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage(), e);

			} finally {
				closeDB(conn, stmt, rs);
			}
			return Indexs;
		}


		public int insertIndex (String title) {

			int insertCount = 0;
			loadOracleDriver();

			Connection conn = null;
			PreparedStatement stmt = null;

			try {

				conn = DriverManager.getConnection(Const.DB_URL, Const.DB_USER , Const.DB_PASSWORD);

				String query = XML.getNodeString("//query/index/text()");
				stmt = conn.prepareStatement(query);

				stmt.setString(1, title);
				

				insertCount = stmt.executeUpdate();

				return insertCount;
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage(), e);
			} finally {
				closeDB(conn, stmt, null);
			}
			
		}
		
		private void loadOracleDriver() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
		}

		private void closeDB(Connection conn, PreparedStatement stmt, ResultSet rs) {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}

		}
	}
	

	
	
	

