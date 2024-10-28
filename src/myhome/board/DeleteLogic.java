package myhome.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myhome.domain.NoticeDao;

public class DeleteLogic implements Logic {
	@Override
	public boolean doLogic(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		return NoticeDao.getInstance().delete(no);
	}

}
