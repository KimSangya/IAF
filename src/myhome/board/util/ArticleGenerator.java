package myhome.board.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myhome.domain.NoticeDao;
import myhome.domain.BoardDto;

@WebServlet("/create")
public class ArticleGenerator extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NoticeDao dao = NoticeDao.getInstance();
		int[] arr = {1,2,4,6};
		for(int i = 0 ; i < 200; ++i) {
			
			BoardDto dto = new BoardDto();
			dto.setTitle((i+1) + "번 글의 제목임!");
			dto.setContent((i+1) + "번 글의 내용임!");
			dto.setWriterNo(i);
			dto.setWriterNo(arr[(int)(Math.random() * arr.length)]);
			dao.insert(dto);
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
