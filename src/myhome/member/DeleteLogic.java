package myhome.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myhome.board.Logic;
import myhome.domain.NoticeDao;

@WebServlet("/view/member/delete")
public class DeleteLogic implements Logic {
	@Override
	public boolean doLogic(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		return NoticeDao.getInstance().delete(no);
	}

}
