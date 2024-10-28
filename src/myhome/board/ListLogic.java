package myhome.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myhome.domain.NoticeDao;
import myhome.domain.BoardDto;

public class ListLogic implements Logic{
	@Override
	public boolean doLogic(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");
		int beginRownum = 0;
		if(page != null) {
			beginRownum = (Integer.parseInt(page)-1)*10; 
		}
		
		
		NoticeDao dao = NoticeDao.getInstance();
		List<BoardDto> list = dao.selectAll(beginRownum);
		
		
		// 마지막 페이지를 계산하여 request에 저장.
		int totalBoard = dao.selectTotalCount(); // 전체 게시글 수
		int lastPage = (totalBoard - 1) / 10 + 1; // 마지막 페이지
		
		
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("list", list);
		return true; 
	}

}






