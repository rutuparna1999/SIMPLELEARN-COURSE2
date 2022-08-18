package simplilearn.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import simplilearn.com.Dao.AdminActionDao;
import simplilearn.com.Model.classMaster;
import simplilearn.com.Model.login;
import simplilearn.com.Model.subjectMaster;
import simplilearn.com.Model.subjecttoteacher;
import simplilearn.com.Model.userMaster;

/**
 * Servlet implementation class AdminControllerServlet
 */
@WebServlet("/")
public class AdminControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminActionDao AdminActionDao = new AdminActionDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = null;
		String action = request.getServletPath();
		
		HttpSession session = request.getSession();
		 username = (String) session.getAttribute("username");
        switch (action) {
		case "/login":
			request.getRequestDispatcher("login.jsp").forward(request, response);
		    break;
		case "/postlogin":
			dologin(request, response);
            break;
		case "/dashboard":
			if(username != null) {
				dashboard(request, response);
	           
			}else {
				response.sendRedirect("login");
			}
			 break; 
		case "/listClass":
			if(username != null) {
				try {
					listClass(request, response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
			
            break;
            
		case "/addNewClass":
			if(username != null) {
				showNewClassForm(request, response);
			}else {
				response.sendRedirect("login");
			}
			
            break; 
		case "/addclass":
			if(username != null) {
				try {
					addclass(request, response);
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
			
            break;
		case "/editClass":
			if(username != null) {
				try {
					showEditclassForm(request, response);
				} catch (IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
			
            break; 
            
		case "/updateClass":
			if(username != null) {
				try {
					doUpdateClass(request, response);
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
			
            break;
		case "/deleteClass":
			if(username != null) {
				try {
					doDeleteClass(request, response);
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
			
            break;
		case "/listSubject":
			if(username != null) {
				try {
					listSubject(request, response);
				} catch (ServletException | IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
            break;  
		case "/addNewSubject":
			if(username != null) {
				try {
					showNewSubForm(request, response);
				} catch (ServletException | IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
			
            break; 
		case "/addSubject":
			if(username != null) {
				try {
					addnewsubject(request, response);
				} catch (IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
			
            break;    
		case "/editSubject":
			if(username != null) {
				try {
					showEditSubForm(request, response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
			
            break;    
		case "/updateSubject":
			if(username != null) {
				try {
					doUpdateSubject(request, response);
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
			
            break; 
		case "/deleteSubject":
			if(username != null) {
				try {
					doDeleteSubject(request, response);
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
			
            break; 
		case "/listTeacher":
			if(username != null) {
				try {
					listTeacher(request, response);
				} catch (ServletException | IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
            break;  
		case "/addNewTeacher":
			if(username != null) {
				try {
					showNewTeacherForm(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
			
            break; 
		case "/addTeacher":
			if(username != null) {
				try {
					addnewteacher(request, response);
				} catch (IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
			
            break;    
		case "/editTeacher":
			if(username != null) {
				try {
					showEditTeacherForm(request, response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
			
            break;    
		case "/updateTeacher":
			if(username != null) {
				try {
					doUpdateTeacher(request, response);
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
			
            break; 
		case "/deleteTeacher":
			if(username != null) {
				try {
					doDeleteTeacher(request, response);
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
			
            break;
		case "/listStudent":
			if(username != null) {
				try {
					listStudent(request, response);
				} catch (ServletException | IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
            break;  
		case "/addNewStudent":
			if(username != null) {
				try {
					showNewStudentForm(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
			
            break; 
		case "/addStudent":
			if(username != null) {
				try {
					addnewstudent(request, response);
				} catch (IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
			
            break;    
		case "/editStudent":
			if(username != null) {
				try {
					showEditStudentForm(request, response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
			
            break;    
		case "/updateStudent":
			if(username != null) {
				try {
					doUpdateStudent(request, response);
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
			
            break; 
		case "/deleteStudent":
			if(username != null) {
				try {
					doDeleteStudent(request, response);
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
			
            break; 
		case "/listTeacherToSubject":
			if(username != null) {
				try {
					listTeacherToSubject(request, response);
				} catch (ServletException | IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
            break;  
		case "/addSubToTeacher":
			if(username != null) {
				try {
					showAssignForm(request, response);
				} catch (ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
			
            break; 
		case "/assignSubject":
			if(username != null) {
				try {
					assignSubject(request, response);
				} catch (IOException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
			
            break;  
		case "/deletestt":
			if(username != null) {
				try {
					doDeleteAssignSubject(request, response);
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
			
            break; 
            
		case "/ListStudentByClass":
			if(username != null) {
				try {
					doListStudentByClass(request, response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
			
            break;
		case "/searchByclass":
			if(username != null) {
				try {
					dosearchByclass(request, response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
			
            break;
		case "/ListTeacherBySubject":
			if(username != null) {
				try {
					doListTutorBySubject(request, response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
			
            break;
		case "/searchBySubject":
			if(username != null) {
				try {
					dosearchteacherbysubject(request, response);
				} catch (SQLException | ServletException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				response.sendRedirect("login");
			}
			
            break;    
		case "/logout":
			if(username != null) {
				dologout(request, response);
			}else {
				response.sendRedirect("login");
			}
			
            break;     
		default:
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("index.jsp");
			dispatcher1.forward(request, response);
		    break;
		}
        
        
	}

	

		/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void dologin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("uname");
        String password = request.getParameter("password");
        login login = new login();
        login.setUsername(username);
        login.setPassword(password);
        if(username != null && password != null) {
        	try {
    			if (AdminActionDao.validate(login)) {
                    HttpSession session = request.getSession();
                     session.setAttribute("username",username);
                    response.sendRedirect("dashboard");
                } else {
                    response.sendRedirect("login");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else {
        	response.sendRedirect("login");
        }
        
	}

	private void dashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		try {
			if(username == null) {
				response.sendRedirect("login");
			}else {
			userMaster userdata = AdminActionDao.getprofile(username);
			 RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
		        request.setAttribute("user", userdata);
		        dispatcher.forward(request, response);
			}    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	private void listClass(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		 	List<classMaster> listclass = AdminActionDao.listAllClasses();
	        request.setAttribute("listClass", listclass);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("listClass.jsp");
	        dispatcher.forward(request, response);
		
	}
	
	private void showNewClassForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("addEditClassForm.jsp");
        dispatcher.forward(request, response);
		
	}
	
	private void addclass(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		String classcode = request.getParameter("ccode");
        String classname = request.getParameter("cname");
        if(classcode!="" && classname != ""){
        	 classMaster newclass = new classMaster(classcode, classname);
             AdminActionDao.insertclass(newclass);
             response.sendRedirect("listClass");
        }else {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("addEditClassForm.jsp");
            dispatcher.forward(request, response);
        }
       
		
	}

	private void showEditclassForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		    int id = Integer.parseInt(request.getParameter("id"));
		    classMaster classlistid = AdminActionDao.getclassbyid(id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("addEditClassForm.jsp");
			request.setAttribute("classMaster", classlistid);
			dispatcher.forward(request, response);
		
	}
	
	private void doUpdateClass(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("classid"));
        String ccode = request.getParameter("ccode");
        String cname = request.getParameter("cname");
        if(ccode!="" && cname != ""){
        	  classMaster classMaster = new classMaster(id, ccode, cname);
              AdminActionDao.updateclass(classMaster);
              response.sendRedirect("listClass");
       }else {
    	   response.sendRedirect("editClass?id="+id);
       }
      
		
	}

	private void doDeleteClass(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		 int id = Integer.parseInt(request.getParameter("id"));
	        classMaster classMaster = new classMaster(id);
	        AdminActionDao.deleteclass(classMaster);
	        response.sendRedirect("listClass");
		
	}
	
	private void listSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		 List<subjectMaster> listSubject = AdminActionDao.listAllSubjects();
	        request.setAttribute("listSubject", listSubject);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("listSubject.jsp");
	        dispatcher.forward(request, response);
	}
	
	private void showNewSubForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		List<classMaster> listclass = AdminActionDao.listAllClasses();
        request.setAttribute("listClass", listclass);
		RequestDispatcher dispatcher = request.getRequestDispatcher("addEditSubForm.jsp");
        dispatcher.forward(request, response);
		
	}
	
	private void addnewsubject(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		String classcode = request.getParameter("cname");
        String subcode = request.getParameter("scode");
        String subname = request.getParameter("sname");
        if(classcode !=null && subcode !=null && subname != null) {
        	subjectMaster newsubject = new subjectMaster(classcode, subcode,subname);
            AdminActionDao.insertSubject(newsubject);
            response.sendRedirect("listSubject");
        }else {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("addEditSubForm.jsp");
            dispatcher.forward(request, response);
        }
        	
	}
	
	private void showEditSubForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		 	int id = Integer.parseInt(request.getParameter("id"));
		    subjectMaster subjectlistid = AdminActionDao.getsubbyid(id);
		    List<classMaster> listclass = AdminActionDao.listAllClasses();
			RequestDispatcher dispatcher = request.getRequestDispatcher("addEditSubForm.jsp");
			request.setAttribute("subjectMaster", subjectlistid);
			request.setAttribute("selectedclass", subjectlistid.getccode());
			request.setAttribute("listClass", listclass);
			dispatcher.forward(request, response);
		
	}
	
	private void doUpdateSubject(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("sid"));
		String cname = request.getParameter("ccode");
        String scode = request.getParameter("scode");
        String sname = request.getParameter("sname");
        if(cname !="" && scode !="" && sname != "") {
        	 subjectMaster subjectMaster = new subjectMaster(id,cname,scode, sname);
             AdminActionDao.updateSubject(subjectMaster);
             response.sendRedirect("listSubject");
        }else {
        	response.sendRedirect("editSubject?id="+id);
        }
       
	}
	
	private void doDeleteSubject(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		 int id = Integer.parseInt(request.getParameter("id"));
		 subjectMaster subjectMaster = new subjectMaster(id);
	        AdminActionDao.deleteSubject(subjectMaster);
	        response.sendRedirect("listSubject");
		
	}
	private void listTeacher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		List<userMaster> listTeacher = AdminActionDao.listAllTeachers();
        request.setAttribute("listTeacher", listTeacher);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listTeacher.jsp");
        dispatcher.forward(request, response);
		
	}
	
	private void showNewTeacherForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("addEditTeacherForm.jsp");
        dispatcher.forward(request, response);
		
	}
	
	private void addnewteacher(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("uname");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String role = "TEACHER";
        String school = "SSSVV";
        if(uname !="" && fname !="" && lname != "") {
        	userMaster newteacher = new userMaster(uname, fname,lname,role,school);
            AdminActionDao.insertTeacher(newteacher);
            response.sendRedirect("listTeacher");
        }else {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("addEditSubForm.jsp");
            dispatcher.forward(request, response);
        }
        	
	}
	
	private void showEditTeacherForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		 	int id = Integer.parseInt(request.getParameter("id"));
		    userMaster teacherlistid = AdminActionDao.getteacherbyid(id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("addEditTeacherForm.jsp");
			request.setAttribute("userMaster", teacherlistid);
			dispatcher.forward(request, response);
		
	}
	
	private void doUpdateTeacher(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("uid"));
		String uname = request.getParameter("hiduname");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String role = "TEACHER";
        String school = "SSSVV";
        if(uname !="" && fname !="" && lname != "") {
        	 userMaster userMaster = new userMaster(id,uname,fname, lname,role,school);
             AdminActionDao.updateTeacher(userMaster);
             response.sendRedirect("listTeacher");
        }else {
        	response.sendRedirect("editTeacher?id="+id);
        }
       
	}
	
	private void doDeleteTeacher(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		userMaster userMaster = new userMaster(id);
	        AdminActionDao.deleteTeacher(userMaster);
	        response.sendRedirect("listTeacher");
		
	}
	
	private void listStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		List<userMaster> listStudents = AdminActionDao.listAllStudents();
        request.setAttribute("listStudent", listStudents);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listStudent.jsp");
        dispatcher.forward(request, response);
		
	}
	
	private void showNewStudentForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		List<classMaster> listclass = AdminActionDao.listAllClasses();
        request.setAttribute("listClass", listclass);
		RequestDispatcher dispatcher = request.getRequestDispatcher("addEditStudentForm.jsp");
        dispatcher.forward(request, response);
		
	}
	
	private void addnewstudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("uname");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String cname = request.getParameter("cname");
        String role = "STUDENT";
        String school = "SSSVV";
        if(uname !="" && fname !="" && lname != "" && cname != "") {
        	userMaster newstudent = new userMaster(uname, fname,lname,role,school,cname);
            AdminActionDao.insertStudent(newstudent);
            response.sendRedirect("listStudent");
        }else {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("addEditSubForm.jsp");
            dispatcher.forward(request, response);
        }
        	
	}
	
	private void showEditStudentForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		 	int id = Integer.parseInt(request.getParameter("id"));
		    userMaster studentlistid = AdminActionDao.getstudentbyid(id);
		    List<classMaster> listclass = AdminActionDao.listAllClasses();
			RequestDispatcher dispatcher = request.getRequestDispatcher("addEditStudentForm.jsp");
			request.setAttribute("userMaster", studentlistid);
			request.setAttribute("selectedclass", studentlistid.getclasscode());
			request.setAttribute("listClass", listclass);
			dispatcher.forward(request, response);
		
	}
	
	private void doUpdateStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("uid"));
		String uname = request.getParameter("hiduname");
		String ccode = request.getParameter("ccode");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String role = "TEACHER";
        String school = "SSSVV";
        if(uname !="" && fname !="" && lname != "") {
        	 userMaster userMaster = new userMaster(id,uname,fname, lname,role,school,ccode);
             AdminActionDao.updateStudent(userMaster);
             response.sendRedirect("listStudent");
        }else {
        	response.sendRedirect("editStudent?id="+id);
        }
       
	}
	
	private void doDeleteStudent(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		userMaster userMaster = new userMaster(id);
	        AdminActionDao.deleteStudent(userMaster);
	        response.sendRedirect("listStudent");
		
	}
	
	private void listTeacherToSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		List<subjecttoteacher> listTeacherToSubject = AdminActionDao.listAllTeacherToSubject();
        request.setAttribute("listTTS", listTeacherToSubject);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listTeacherToSubject.jsp");
        dispatcher.forward(request, response);
		
	}
	
	private void showAssignForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		List<userMaster> listTeacher = AdminActionDao.listAllTeachers();
		List<subjectMaster> listSubject = AdminActionDao.listAllSubjects();
        request.setAttribute("listTeacher", listTeacher);
        request.setAttribute("listSubject", listSubject);
		RequestDispatcher dispatcher = request.getRequestDispatcher("assignTtSForm.jsp");
        dispatcher.forward(request, response);
		
	}
	
	private void assignSubject(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		// TODO Auto-generated method stub
		String sname = request.getParameter("sname");
        String tname = request.getParameter("tname");
       
        if(sname !="" && tname !="") {
        	subjecttoteacher assignsubject = new subjecttoteacher(sname, tname);
            AdminActionDao.assignsubject(assignsubject);
            response.sendRedirect("listTeacherToSubject");
        }else {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("addEditSubForm.jsp");
            dispatcher.forward(request, response);
        }
        	
	}
	
	
	private void doDeleteAssignSubject(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		subjecttoteacher subjecttoteacher = new subjecttoteacher(id);
	        AdminActionDao.deleteAssignSubject(subjecttoteacher);
	        response.sendRedirect("listTeacherToSubject");
		
	}
	
	private void doListStudentByClass(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<classMaster> listclass = AdminActionDao.listAllClasses();
        request.setAttribute("listClass", listclass);
		RequestDispatcher dispatcher = request.getRequestDispatcher("searchByClass.jsp");
        dispatcher.forward(request, response);
		
		
	}
	
	
	private void dosearchByclass(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		String cname = request.getParameter("cname");
		List<userMaster> listStudentByClass = AdminActionDao.listStudentsByclass(cname);
        request.setAttribute("listStudentByClass", listStudentByClass);
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("listStudentByClass.jsp");
        dispatcher.forward(request, response);
		
	}
	
	private void doListTutorBySubject(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<subjectMaster> listSubject = AdminActionDao.listAllSubjects();
        request.setAttribute("listSubject", listSubject);
		RequestDispatcher dispatcher = request.getRequestDispatcher("searchBySubject.jsp");
        dispatcher.forward(request, response);
		
		
	}
	
	private void dosearchteacherbysubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		
		String sname = request.getParameter("sname");
		List<subjecttoteacher> listTeacherBySubject = AdminActionDao.listAllTeacherBySubject(sname);
        request.setAttribute("listTTSBysubject", listTeacherBySubject);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listTeacherbySubject.jsp");
        dispatcher.forward(request, response);
	}
	
	private void dologout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		request.getSession(false).invalidate();
		response.sendRedirect("login");
		
	}
	

}
