package myhome.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myhome.domain.MemberDao;
import myhome.domain.MemberDto;

// '/' : http://127.0.0.1:8080/myhome/
// http://127.0.0.1:8080/myhome/view/member/login_logic.do
@WebServlet("/view/member/login_logic.do")
public class LoginLogic extends HttpServlet {
	
	// doGet() ? 
	// doPost() ? 
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		MemberDao dao = MemberDao.getInstance();
		MemberDto dto = dao.findByUsernameAndPassword(username, password);
		
		String message = dto != null ? dto.getNickname() + "님, 안녕하세요."
									: "로그인 실패!";
		
		// 로그인 성공하면 index 페이지로 이동
		// 로그인 실패하면 로그인 실패! 를 alert() 하고, 
		// 로그인 페이지로 이동
		if(dto != null) {
			// 현재 유저 dto를 session 바구니에 저장
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(600);
			session.setAttribute("currentDto", dto);
		}
		
		// 아이디 기억하기 ///////////////////////////////////
		
		Cookie cookie = new Cookie("rememberId", "");
		cookie.setPath("/");
		
		if(request.getParameter("remember_me") != null) {
			cookie.setValue(username);
			cookie.setMaxAge(60 * 60 * 24 * 365);
		}
		else {
			cookie.setMaxAge(0);
		}
		response.addCookie(cookie);
		//////////////////////////////////////////////////
		
		
		
		request.setAttribute("msg", message);
		request.setAttribute("result", dto != null);
		// 결과페이지로 이동
		request.getRequestDispatcher("login_result.jsp")
				.forward(request, response);
		
	}
}





