package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DakaDao;

/**
 * Servlet implementation class DakaServlet
 */
@WebServlet("/DakaServlet")
public class DakaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DakaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
        int uid = Integer.parseInt(request.getParameter("uid"));
        System.out.println(request.getParameter("uid"));
        SimpleDateFormat sdf = new SimpleDateFormat();
		Date date = new Date();
		sdf.applyPattern("yyyy-MM-dd");
		String date1 = sdf.format(date);
		
		Date date2 = new Date();
		sdf.applyPattern("HH:mm:ss");
		String date3 = sdf.format(date2);
		
		DakaDao dakadao = new DakaDao();
		
		int num = dakadao.daka(uid,date1,date3);
		String json = "{\"err\":ERR,\"msg\":\"MSG\"}";
		if(num>0) {
			json = json.replace("ERR", "0");
			json = json.replace("MSG", "打卡成功\n"+date1+" "+date3);
			PrintWriter printWriter = response.getWriter();
			printWriter.write(json);
		}
		if(num==0) {
			json = json.replace("ERR", "-1");
			json = json.replace("MSG", "打卡失败");
			PrintWriter printWriter = response.getWriter();
			printWriter.write(json);
		}
		if(num<0) {
			json = json.replace("ERR", "1");
			json = json.replace("MSG", "今天已经打卡了");
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
