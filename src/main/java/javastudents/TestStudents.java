package javastudents;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class TestStudents extends HttpServlet {

protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	 int id = Integer.parseInt(req.getParameter("stdid"));
	String name= req.getParameter("stdname");
	String qualification= req.getParameter("qualify");
	String city= req.getParameter("city");
	System.out.println(id+"___"+ name + "---"+qualification+"---"+city);
	
	try {
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();
		Session ops = sf.openSession();
		Transaction bt = ops.beginTransaction();
		StudentPojo std = new StudentPojo();
		std.setId(id);
		std.setName(name);
		std.setDegree(qualification);
		std.setCity(city);
		

		ops.save(std);
		
		
			/*
			 * Class.forName("com.mysql.jdbc.Driver");
			 * 
			 * System.out.println("Driver class loading...");
			 * 
			 * Connection connection =
			 * DriverManager.getConnection("jdbc:mysql://localhost:3306/javastudents",
			 * "root", "root");
			 * 
			 * System.out.println("connection establishing....!!"); PreparedStatement ps =
			 * connection.prepareStatement("insert into  students values(?,?,?,?)");
			 * ps.setInt(1, id); ps.setString(2, name); ps.setString(3, qualification);
			 * ps.setString(4, city);
			 * 
			 * ps.executeUpdate();
			 */
	System.out.println("update successfully...!!");
	
	req.getRequestDispatcher("login.jsp").forward(req,resp);
	bt.commit();
	ops.close();
	//connection.close();
	} catch (Exception e) {
				e.printStackTrace();
	}
	
}
	
}

