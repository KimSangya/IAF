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

@WebServlet("/member/modifyAction")
public class ModifyActionLogic extends HttpServlet{
	@Override
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		MemberDto currentDto = (MemberDto)session.getAttribute("currentDto");
		
		// 응답으로 보내줄 json 객체 준비
		JsonObject json = new JsonObject();
		response.setCharacterEncoding("utf-8");
		if(currentDto == null) {
			//	{result : false} 를 응답한다.
			json.addProperty("result", false);
			response.getWriter().write(json.toString());
			return;
		}
		
		MemberDto newDto = new MemberDto();
		newDto.setNo(currentDto.getNo());
		newDto.setNickname(request.getParameter("nickname"));
		newDto.setPassword(request.getParameter("password"));
		newDto.setType(Integer.parseInt(request.getParameter("type")));
		
		MemberDao dao = MemberDao.getInstance();
		boolean result = dao.update(newDto);
		
		if(result) {
			session.setAttribute("currentDto", dao.select(newDto.getNo()));
			json.addProperty("new_nickname", newDto.getNickname());
		}
		
		
		//{result:true/false} 를 응답.
		json.addProperty("result", result);
		response.getWriter().write(json.toString());
		
 	}
}
