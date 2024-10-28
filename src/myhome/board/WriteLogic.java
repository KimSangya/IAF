package myhome.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myhome.domain.NoticeDao;
import myhome.domain.BoardDto;
import myhome.domain.MemberDto;

public class WriteLogic implements Logic{
	
	@Override
	public boolean doLogic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title").trim();
		String email = request.getParameter("email").trim();
		String username = request.getParameter("username").trim();
		String content = request.getParameter("content").trim().replaceAll("\\n|\\r\\n", "<br/>");
		
		HttpSession session = request.getSession();
		int writerNo = ((MemberDto)session.getAttribute("currentDto")).getNo();
		
		BoardDto dto = new BoardDto();
		dto.setTitle(title);
		dto.setEmail(email);
		dto.setUsername(username);
		dto.setContent(content);
		dto.setWriterNo(writerNo);
		
		NoticeDao dao = NoticeDao.getInstance();
		return dao.insert(dto);
	}
}
