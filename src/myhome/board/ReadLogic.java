package myhome.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myhome.domain.NoticeDao;
import myhome.domain.BoardDto;
import myhome.domain.MemberDto;

public class ReadLogic implements Logic {
	@Override
	public boolean doLogic(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		NoticeDao dao = NoticeDao.getInstance();
		HttpSession session = request.getSession();
		MemberDto currentDto = (MemberDto)session.getAttribute("currentDto");
		String cookieName = (currentDto != null ? currentDto.getNo() : "anonymous")+"_"+no;
		Cookie[] cookies = request.getCookies();
		boolean cookieExists = false;
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals(cookieName)) {
				cookieExists = true;
				break;
			}
		}
		
		if(!cookieExists) {
			dao.updateHit(no);
			Cookie cookie = new Cookie(cookieName, String.valueOf(System.currentTimeMillis()));
			cookie.setPath("/");
			cookie.setMaxAge(60*60*24*90);//90일
			response.addCookie(cookie);
		}
		BoardDto dto = dao.select(no);
		
		request.setAttribute("dto", dto);
		return true;
		
	}

}
