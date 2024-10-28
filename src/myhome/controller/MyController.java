package myhome.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

import myhome.board.DeleteLogic;
import myhome.board.ListLogic;
import myhome.board.ModifyActionLogic;
import myhome.board.ModifyLogic;
import myhome.board.ReadLogic;
import myhome.board.WriteLogic;
import myhome.domain.BoardDao;
import myhome.domain.BoardDto;
import myhome.domain.MemberDto;

// 127.0.0.1:8080/myhome/board/write.do
// 127.0.0.1:8080/myhome/board/a.html
// 127.0.0.1:8080/myhome/board/a/b.html

@WebServlet("/board/*")
public class MyController extends HttpServlet{
	
	private BoardDao dao = BoardDao.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		String method = request.getMethod();
		String requestUri = uri.replace(request.getContextPath() + "/board", "");
		
		HttpSession session = request.getSession();
		MemberDto currentMemberDto = (MemberDto)session.getAttribute("currentDto");
		
		request.setAttribute("tab", "board");
		
		boolean result;
		
		switch(requestUri) {
		case "/write":
			if(currentMemberDto == null) {
				response.sendRedirect(request.getContextPath() + "/board/list");
				break;
			}
			
			switch (method) {
			case "GET":
				request.getRequestDispatcher("/view/board/write.jsp")
						.forward(request, response);
				break;
			case "POST":
				result = new WriteLogic().doLogic(request, response);
				request.setAttribute("result", result);
				request.setAttribute("status", "write");
				request.getRequestDispatcher("/view/board/result.jsp")
						.forward(request, response);
				break;
			}
			break;
		case "/list":
//			request.setAttribute("list", dao.selectAll());
			new ListLogic().doLogic(request, response);
			request.getRequestDispatcher("/view/board/list.jsp")
					.forward(request, response);
			break;
		case "/delete":
			// 세션 검사 (글 주인이 맞는 지)
			result = 
				new DeleteLogic().doLogic(request, response);
			request.setAttribute("result", result);
			request.setAttribute("status", "delete");
			request.getRequestDispatcher("/view/board/result.jsp")
			.forward(request, response);
			break;
			
		case "/modify":
			switch (method) {
			case "GET":
				new ModifyLogic().doLogic(request, response);
				request.getRequestDispatcher("/view/board/modify.jsp")
						.forward(request, response);
				break;
			case "POST":
				result = 
					new ModifyActionLogic().doLogic(request, response);
				JsonObject json = new JsonObject();
				json.addProperty("result", result);
				response.getWriter().write(json.toString());
				break;
			}
			break;
		case "/read":
			new ReadLogic().doLogic(request, response);
			request.getRequestDispatcher("/view/board/read.jsp")
					.forward(request, response);
			break;
		default:
			response.sendRedirect(request.getContextPath() + "/board/list");
			break;
		}
		
	}
}


