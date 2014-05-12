package pizza;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class PizzaServlet
 */
@WebServlet("/PizzaServlet")
public class PizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("username");
		PrintWriter out = response.getWriter();
		if(username!=null){
			out.println("Du �ro redan inloggad herrn!");
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		if(action.equals("login")){			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://mysql12.citynetwork.se/108985-lmm","108985-mb29814","Larsa1952");
				Statement st= con.createStatement(); 
				ResultSet rs=st.executeQuery("SELECT * FROM users WHERE username='"+username+"' AND password='"+password+"'"); 
				if(rs.next()){
					out.println("LOGIN SUCCESFUL!");
					request.getSession().setAttribute("username",username);
				} else {
					out.println("<h2>WRONG USERNAME/PASSWORD, TRY AGAIN!</h2>");
					out.print("<h3><a href='login.jsp'>Back</a></h3>");
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("START STACKTRACE");
				e.printStackTrace();
			} 
		} else if(action.equals("register")){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String address = request.getParameter("address");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://mysql12.citynetwork.se/108985-lmm","108985-mb29814","Larsa1952");
				Statement st= con.createStatement();
				st.executeUpdate("INSERT INTO users VALUES('"+username+"','"+password+"','"+email+"','"+address+"')");
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("START STACKTRACE");
				e.printStackTrace();
			} 
			out.println("REGISTRATION SUCCESSFUL!");
			out.print("<h3><a href='login.jsp'>Back</a></h3>");
		} else {
			out.println("ERROR: ooops, something went wrong!");
		}
	}

}
