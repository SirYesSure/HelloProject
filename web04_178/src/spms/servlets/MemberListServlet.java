package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/member/list")
public class MemberListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1591928815947883690L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "psu";
		String password = "psu";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();

			String sql = "SELECT MNO, MNAME, EMAIL, CRE_DATE" + " FROM MEMBERS" + " ORDER BY MNO ASC";

			rs = stmt.executeQuery(sql);

			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");

			PrintWriter out = res.getWriter();

			out.println("<html><head><title>회원목록</title></head>");
			out.println("<body><h1>회원목록</h1>");

			while (rs.next()) {
				out.println(rs.getInt("MNO") + "," + rs.getString("MNAME") + "," + rs.getString("EMAIL") + ","
						+ rs.getDate("CRE_DATE") + "<br>");
			}
			out.println("</body></html>");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("음 이런게 되던가?");
		resp.sendRedirect("../index.jsp");
		
	}

}
