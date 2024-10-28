package myhome.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myhome.domain.MemberDao;
import myhome.domain.MemberDto;

@WebServlet("/view/member/mypage")
public class MyPageLogic extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDao dao = MemberDao.getInstance();
		
		HttpSession session = req.getSession();
		MemberDto dto = (MemberDto)session.getAttribute("currentDto");
		
		// 로그인한 유저의 회원번호로 DB조회 후
		// 그 회원의 정보를 담은 dto 객체를 변수에 다시 대입 
		dto = dao.select(dto.getNo());
		
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/view/member/mypage.jsp")
			.forward(req, resp);
	}
	
}
