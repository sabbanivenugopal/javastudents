package javastudents;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestStudentsLogin extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String studentid = req.getParameter("stdid");
		String studentname = req.getParameter("stdname");
		
		try {
			
			Configuration config = new Configuration().configure("hibernate.cfg.xml");
			SessionFactory sf = config.buildSessionFactory();
			Session ops = sf.openSession();
			Transaction bt = ops.beginTransaction();
			Query cq = ops.createQuery("from students where id=? and name=?");

			cq.setParameter(0, studentid);
			cq.setParameter(1, studentname);
			List<StudentPojo> list = cq.list();
			
			
		
			if (!list.isEmpty()) {
			//	req.setAttribute("message1", list.getString("name"));
				System.out.println("hai");
				req.getRequestDispatcher("confirm.jsp").forward(req, resp);
				
			} else {
				req.setAttribute("message", "invalid credentials!! please enter valid credentials");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
				

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

/*
 * Class.forName("com.mysql.jdbc.Driver"); System.out.println("hai helo");
 * Connection con =
 * DriverManager.getConnection("jdbc:mysql://localhost:3306/javastudents",
 * "root", "root"); PreparedStatement ps =
 * con.prepareStatement("select id,name from students where id=? and name=?");
 * ps.setString(1, studentid); ps.setString(2, studentname); ResultSet rs =
 * ps.executeQuery();
 */