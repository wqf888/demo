package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Emp;
import com.dao.EmpDao;

/**
 * Servlet implementation class ServlectTest
 */
@WebServlet("/ServlectTest")
public class ServlectTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServlectTest() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**      *_*   ^-^   ^_^  0.0 #_#  |_| 0_0  ~_~  +_+												
	 * 		 T_T  M_M $_$ Y_Y ?_? @^@ 0^0
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String test = request.getParameter("test");
		
		System.out.println("标记是："+test);
		if(test.equals("show")){ //显示所有员工信息
			this.show(request,response);
		}else if(test.equals("saveEmp")){ //添加员工
			this.saveEmp(request,response);
		}else if(test.equals("DeleteEmp")){
			DeleteEmp(request,response);
		}

	}
	
	private void DeleteEmp(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String eid = request.getParameter("eid");
		empDao.deleteEmp(eid);
		response.sendRedirect("index.jsp");
		
	}
	//添加员工
	private void saveEmp(HttpServletRequest request, HttpServletResponse response) 
			throws  ServletException, IOException{
			
			String ename = request.getParameter("ename");
			String bdate = request.getParameter("bdate");
			String sex = request.getParameter("sex");
			String deptid = request.getParameter("deptid");
			
			empDao.saveEmp(ename, bdate, sex, deptid);
			
			response.sendRedirect("index.jsp");	
	}
	EmpDao empDao = new EmpDao(); 
	
	//显示所有的员工信息
	private void show(HttpServletRequest request, HttpServletResponse response)
			throws  ServletException, IOException {
		
		try {		
			String LikeNname = request.getParameter("LikeNname");
			String LikeDid = request.getParameter("LikeDid");
			List<Emp> list = empDao.listEmp(null, null);
			
			
			for (Emp emp : list) {
				if(emp.getSex().equals("f")){
					emp.setSex("男");
				}else{
					emp.setSex("女");
				}

			}
			request.getSession().setAttribute("listDept", empDao.listDept());
			request.getSession().setAttribute("list", list);
			
			response.sendRedirect("show.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}