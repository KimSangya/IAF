package myhome.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myhome.domain.NoticeDao;
import myhome.domain.BoardDto;

@WebServlet("/board/modifyAction")
public class ModifyActionLogic implements Logic {
	@Override
	public boolean doLogic(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title").trim();
		String content = request.getParameter("content").trim().replaceAll("\\n|\\r\\n", "<br/>");
		int no = Integer.parseInt(request.getParameter("no"));
		
		BoardDto dto = new BoardDto();
		dto.setTitle(title);
		dto.setContent(content);
		dto.setNo(no);
		
		NoticeDao dao = NoticeDao.getInstance();
		return dao.update(dto);
	}
}
