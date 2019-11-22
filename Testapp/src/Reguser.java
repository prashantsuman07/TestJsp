import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/register")
public class Reguser extends HttpServlet{
	Testdao dao=new Testdaoimpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession(true);
		
		if(session!=null) {	
		String username=req.getParameter("uname");
		String password=req.getParameter("pswd");
		int age=Integer.parseInt(req.getParameter("age"));
		String gender=req.getParameter("gender");
		
		TestBean testBean=new TestBean();
		testBean.setUsername(username);
		testBean.setPassword(password);
		testBean.setAge(age);
		testBean.setGender(gender);
		
			if(dao.regUser(testBean)) {
				req.setAttribute("addemp", testBean);
				
			}
			else {
				req.setAttribute("msg","not regitered");
			}
			req.getRequestDispatcher("./loginform").forward(req, resp);
		}
		else {
			req.setAttribute("msg", "please login first");
			req.getRequestDispatcher("./loginform").forward(req, resp);
		}
	}

}
