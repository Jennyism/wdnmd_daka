package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDao userdao = new UserDao();
		User user  = userdao.login(username, password);
		String json = "{\"err\":ERR,\"msg\":\"MSG\",\"uid\":\"UID\"}";
		if(user!=null) {
			json = json.replace("ERR", "0");
			json = json.replace("MSG", "登录成功");
			json = json.replace("UID", Integer.toString(user.getUid()));
			PrintWriter printWriter = response.getWriter();
			printWriter.write(json);
		}
		else {
			json = json.replace("ERR", "-1");
			json = json.replace("MSG", "账号密码错误");
			PrintWriter printWriter = response.getWriter();
			printWriter.write(json);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
