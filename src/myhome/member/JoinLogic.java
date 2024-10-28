package myhome.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myhome.domain.MemberDao;
import myhome.domain.MemberDto;

@WebServlet("/view/member/join_logic.do")
public class JoinLogic extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post로 넘어오는 파라미터는 반드시 문자 인코딩 utf-8로..
		request.setCharacterEncoding("utf-8");


		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String email = request.getParameter("email");
		int type = Integer.parseInt(request.getParameter("type"));
		
		MemberDto dto = new MemberDto();
		dto.setUsername(username);
		dto.setPassword(password);
		dto.setNickname(nickname);
		dto.setEmail(email);
		dto.setType(type);
		
		MemberDao dao = MemberDao.getInstance();
		boolean result = dao.insert(dto);
		
//		String message =
//				result ? "회원 가입에 감사드립니다." : "회원가입에 실패했습니다.";
//		
//		if(dto != null) {
//			
//			HttpSession session = request.getSession();
//			session.setAttribute("currentDto", dto);
//		}
//		
//		request.setAttribute("msg", message);
//		request.setAttribute("result", dto != null);
//		request.getRequestDispatcher("join_result.jsp").forward(request, response);
		
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("/view/member/join_result.jsp");
		rd.forward(request, response);
		
	}
}
