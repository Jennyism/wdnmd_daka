package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDao userdao = new UserDao();
		boolean a = userdao.Regist(username, password);
		String json = "{\"err\":ERR,\"msg\":\"MSG\"}";
		if(a) {
			json = json.replace("ERR", "0");
			json = json.replace("MSG", "注册成功");
			PrintWriter printWriter = response.getWriter();
			printWriter.write(json);
		}else {
			json = json.replace("ERR", "-1");
			json = json.replace("MSG", "注册失败,请使用其他用户名进行注册");
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
