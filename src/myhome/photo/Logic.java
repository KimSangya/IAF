package myhome.photo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Logic {
	public boolean doLogic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}
