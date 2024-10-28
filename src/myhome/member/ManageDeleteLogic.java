package myhome.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

import myhome.domain.MemberDao;
import myhome.domain.MemberDto;

@WebServlet("/member/manageDelete")
public class ManageDeleteLogic extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		MemberDto dto = (MemberDto) session.getAttribute("currentDto");
		
		JsonObject json = new JsonObject();
		if(dto == null || dto.getType() != 0) {
			json.addProperty("result", false);
		}
		else {
			int no = Integer.parseInt(req.getParameter("no"));
			MemberDao dao = MemberDao.getInstance();
			json.addProperty("result", dao.delete(no));
			json.addProperty("no", no);
		}
		
		resp.getWriter().write(json.toString());
	}
	
	
}

