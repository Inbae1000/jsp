package member.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.*;

/**
 * Servlet implementation class MemberController
 */
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
		// TODO Auto-generated method stub


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	

		process(request, response);
	}

	public void process (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String RequestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		
		resp.setContentType("text/html; charset-utf-8");
		req.setCharacterEncoding("utf-8");
		
		if(command.equals("/home.do")) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/main.jsp");
			rd.forward(req, resp);
		}
		
		else if(command.equals("/select.do")) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/select01.jsp");
			rd.forward(req, resp);
		}
		
		else if(command.equals("/insert.do")) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/insert2.jsp");
			rd.forward(req, resp);	
		}
		
		else if(command.equals("/insert2.do")) {
			requestInsert(req,resp);
		}
		
		else if(command.equals("/er.do")) {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/er.jsp");
			rd.forward(req, resp);
		}
		
		else if(command.equals("/update.do")) {
			selectOne(req, resp);

		}
		else if(command.equals("/update2.do")) {
			requestUpdate(req, resp);
		}

		else if(command.equals("/delete.do")) {
			delete(req, resp);
		}
		

	}
	
	// 정보 저장
	public void requestInsert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		System.out.println("완료");
		
		String name = req.getParameter("name");
		String birth = req.getParameter("birth");
		String number = req.getParameter("number");
		String country = req.getParameter("country");
		String sex = req.getParameter("sex");
		String type1 = req.getParameter("type1");
		String type2 = req.getParameter("type2");
		String company = req.getParameter("company");
		String coAddress = req.getParameter("coAddress");
		String coDate1 = req.getParameter("coDate1");
		String coDate2 = req.getParameter("coDate2");
		String coResignation = req.getParameter("coResignation");
		String coNumber = req.getParameter("coNumber");
		String notice = req.getParameter("notice");
		
		int age = 0;
		if(req.getParameter("age") == null || req.getParameter("age") == "") {
			age = 0;
		}else {
			age = Integer.parseInt(req.getParameter("age"));
		}
		
		
		MemberDAO memberDao = MemberDAO.getInstance();
		MemberDTO dto = new MemberDTO();
		
		dto.setId(memberDao.nextval() + 1);
		dto.setName(name);
		dto.setBirth(birth);
		dto.setNumber(number);
		dto.setCountry(country);
		dto.setSex(sex);
		dto.setAge(age);
		dto.setType1(type1);
		dto.setType2(type2);
		dto.setCompany(company);
		dto.setCoAddress(coAddress);
		dto.setCoDate1(coDate1);
		dto.setCoDate2(coDate2);
		dto.setCoResignation(coResignation);
		dto.setCoNumber(coNumber);
		dto.setNotice(notice);
		
		int wResult = memberDao.insert(dto);
		System.out.println(wResult);
		if(wResult == -1) {
			resp.sendRedirect("er.do");
		} else {
			resp.sendRedirect("select.do");
		}
		
	}
	
	// 정보 수정
	public void requestUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String birth = req.getParameter("birth");
		String number = req.getParameter("number");
		String country = req.getParameter("country");
		String sex = req.getParameter("sex");
		int age = Integer.parseInt(req.getParameter("age"));
		String type1 = req.getParameter("type1");
		String type2 = req.getParameter("type2");
		String company = req.getParameter("company");
		String coAddress = req.getParameter("coAddress");
		String coDate1 = req.getParameter("coDate1");
		String coDate2 = req.getParameter("coDate2");
		String coResignation = req.getParameter("coResignation");
		String coNumber = req.getParameter("coNumber");
		String notice = req.getParameter("notice");


		
		
		MemberDAO memberDao = MemberDAO.getInstance();
		MemberDTO dto = new MemberDTO();
		
		dto.setId(id);
		dto.setName(name);
		dto.setBirth(birth);
		dto.setNumber(number);
		dto.setCountry(country);
		dto.setSex(sex);
		dto.setAge(age);
		dto.setType1(type1);
		dto.setType2(type2);
		dto.setCompany(company);
		dto.setCoAddress(coAddress);
		dto.setCoDate1(coDate1);
		dto.setCoDate2(coDate2);
		dto.setCoResignation(coResignation);
		dto.setCoNumber(coNumber);
		dto.setNotice(notice);
		
		memberDao.selectOne(dto.getId());
		int wResult = memberDao.update(dto);
		System.out.println(wResult);
		if(wResult == -1) {
			resp.sendRedirect("er.do");
		} else {
			resp.sendRedirect("select.do");
		}
		
	}
	
	public void selectOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		int id = Integer.parseInt(req.getParameter("id"));
		MemberDAO dao = MemberDAO.getInstance();
		MemberDTO dto = new MemberDTO();
		dto = dao.selectOne(id);
		
		req.setAttribute("select2", dto);
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/update.jsp");
		rd.forward(req, resp);
	}
	
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		int id = Integer.parseInt(req.getParameter("id"));
		MemberDAO dao = MemberDAO.getInstance();
		dao.delete(id);
		
		resp.sendRedirect("select.do");
	}

}
