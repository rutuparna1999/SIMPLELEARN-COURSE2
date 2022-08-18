package simplilearn.com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import simplilearn.com.Model.classMaster;
import simplilearn.com.Model.login;
import simplilearn.com.Model.subjectMaster;
import simplilearn.com.Model.subjecttoteacher;
import simplilearn.com.Model.userMaster;
import simplilearn.com.dbcon.dbcon;

public class AdminActionDao {

	dbcon dbConnection = new dbcon();
	Connection connection = dbConnection.getConnection();
	
	public boolean validate(login login) throws ClassNotFoundException {
        boolean status = false;
        try  {
        	PreparedStatement statement = connection
    	            .prepareStatement("select * from user_master where username = ? and password = ? and rolecode = 'ADMIN'");
        	statement.setString(1, login.getUsername());
        	statement.setString(2, login.getPassword());

            //System.out.println(preparedStatement);
            ResultSet rs = statement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return status;
	}

	public userMaster getprofile(String rcvusername) throws SQLException {
		 
        userMaster user = null;
        
        String username = null;
        String firstname = null;
		String lastname = null;
		String rolecode = null;
		String schoolname = null;
		
        PreparedStatement statement = connection
    	            .prepareStatement("SELECT * FROM  user_master A INNER JOIN school_master B ON A.school_code = B.school_code WHERE username = ?");
        statement.setString(1,rcvusername);
        ResultSet resultSet = statement.executeQuery();
    	
        if (resultSet.next()) {
        	  
        	username = resultSet.getString("username");
        	firstname = resultSet.getString("firstname");
        	lastname = resultSet.getString("lastname");
        	rolecode = resultSet.getString("rolecode");
        	schoolname = resultSet.getString("school_name");
        }
          
          user = new userMaster(username,firstname,lastname,rolecode,schoolname);
	        resultSet.close();
	        statement.close();
			return  user;
    }
	
    
	public List<classMaster> listAllClasses() throws SQLException {
        List<classMaster> listClass = new ArrayList<>();
        
         
        PreparedStatement statement = connection
	            .prepareStatement("SELECT * FROM classmaster");
        ResultSet resultSet = statement.executeQuery();
         
        while (resultSet.next()) {
            int id = resultSet.getInt("cid");
            String classcode = resultSet.getString("classcode");
            String classname = resultSet.getString("classname");
             
            classMaster Classlist = new classMaster(id,classcode,classname);
            listClass.add(Classlist);
        }
         
        resultSet.close();
        statement.close();
        return listClass;
    }
	public boolean insertclass(classMaster classMaster) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO classmaster (classcode,classname) VALUES (?, ?)");
        statement.setString(1, classMaster.getccode());
        statement.setString(2, classMaster.getcName());        
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        return rowInserted;
    }
	
	public classMaster getclassbyid(int id) throws SQLException {
        classMaster classlistid = null;
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM classmaster WHERE cid = ?");
        statement.setInt(1, id); 
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String classcode = resultSet.getString("classcode");
            String classname = resultSet.getString("classname");
            classlistid = new classMaster(id, classcode, classname);
        }
        resultSet.close();
        statement.close();
        return classlistid;
    }
	 public boolean updateclass(classMaster classMaster) throws SQLException {
		 
	        PreparedStatement statement = connection.prepareStatement("UPDATE classmaster SET classcode = ?, classname = ? WHERE cid = ?");
	        statement.setString(1, classMaster.getccode());
	        statement.setString(2, classMaster.getcName());
	        statement.setFloat(3, classMaster.getId());
	        boolean rowUpdated = statement.executeUpdate() > 0;
	        statement.close();
	        return rowUpdated;     
	  }
	 
	 public boolean deleteclass(classMaster classMaster) throws SQLException {
	        PreparedStatement statement = connection.prepareStatement("DELETE FROM classmaster where cid = ?");
	        statement.setInt(1, classMaster.getId());
	        boolean rowDeleted = statement.executeUpdate() > 0;
	        statement.close();
	        return rowDeleted;     
	 }
	 
	 public List<subjectMaster> listAllSubjects() throws SQLException {
	        List<subjectMaster> listSubject = new ArrayList<>();
	        
	         
	        PreparedStatement statement = connection
		            .prepareStatement("SELECT * FROM  subjectmaster A INNER JOIN classmaster B ON A.classcode = B.classcode");
	        ResultSet resultSet = statement.executeQuery();
	         
	        while (resultSet.next()) {
	            int id = resultSet.getInt("sid");
	            String classcode = resultSet.getString("classname");
	            String subjectcode = resultSet.getString("subcode");
	            String subjectname = resultSet.getString("subname");
	             
	            subjectMaster subjectlist = new subjectMaster(id,classcode,subjectcode,subjectname);
	            listSubject.add(subjectlist);
	        }
	         
	        resultSet.close();
	        statement.close();
	        return listSubject;
	    }
	 
	 public boolean insertSubject(subjectMaster subjectMaster) throws SQLException {
	        PreparedStatement statement = connection.prepareStatement("INSERT INTO subjectmaster (classcode,subcode,subname) VALUES (?, ?,?)");
	        statement.setString(1, subjectMaster.getccode()); 
	        statement.setString(2, subjectMaster.getscode());
	        statement.setString(3, subjectMaster.getsName());        
	        boolean rowInserted = statement.executeUpdate() > 0;
	        statement.close();
	        return rowInserted;
	 }
	 
	 public subjectMaster getsubbyid(int id) throws SQLException {
	        subjectMaster subjectlistid = null;
	        PreparedStatement statement = connection.prepareStatement("SELECT * FROM subjectmaster WHERE sid = ?");
	        statement.setInt(1, id); 
	        ResultSet resultSet = statement.executeQuery();
	         
	        if (resultSet.next()) {
	            String classcode = resultSet.getString("classcode");
	            String subcode = resultSet.getString("subcode");
	            String subname = resultSet.getString("subname");
	            subjectlistid = new subjectMaster(id, classcode, subcode,subname);
	        }
	        resultSet.close();
	        statement.close();
	        return subjectlistid;
	    }
	 
	 public boolean updateSubject(subjectMaster subjectMaster) throws SQLException {
		 
	        PreparedStatement statement = connection.prepareStatement("UPDATE subjectmaster SET classcode = ?, subcode = ?,subname=? WHERE sid = ?");
	        statement.setString(1, subjectMaster.getccode());
	        statement.setString(2, subjectMaster.getscode());
	        statement.setString(3, subjectMaster.getsName());
	        statement.setInt(4, subjectMaster.getId());
	        boolean rowUpdated = statement.executeUpdate() > 0;
	        statement.close();
	        return rowUpdated;     
	  }
	 public boolean deleteSubject(subjectMaster subjectMaster) throws SQLException {
	        PreparedStatement statement = connection.prepareStatement("DELETE FROM subjectmaster where sid = ?");
	        statement.setInt(1, subjectMaster.getId());
	        boolean rowDeleted = statement.executeUpdate() > 0;
	        statement.close();
	        return rowDeleted;     
	 }
	 
	 public List<userMaster> listAllTeachers() throws SQLException {
	        List<userMaster> listTeachers = new ArrayList<>();
	        PreparedStatement statement = connection
		            .prepareStatement("SELECT * FROM  user_master A INNER JOIN school_master B ON A.school_code = B.school_code WHERE rolecode = 'TEACHER'");
	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	            int uid = resultSet.getInt("user_id");
	            String username = resultSet.getString("username");
	            String firstname = resultSet.getString("firstname");
	            String lastname = resultSet.getString("lastname");
	            String rolecode = resultSet.getString("rolecode");
	            String schoolname = resultSet.getString("school_name");
	            userMaster teacherlist = new userMaster(uid,username,firstname,lastname,rolecode,schoolname);
	            listTeachers.add(teacherlist);
	        }
	        resultSet.close();
	        statement.close();
	        return listTeachers;
	    }
	 
	 public boolean insertTeacher(userMaster userMaster) throws SQLException {
	        PreparedStatement statement = connection.prepareStatement("INSERT INTO  user_master  (  username ,  firstname ,  lastname ,  rolecode ,  school_code ) VALUES(?, ?,?,?,?)");
	        statement.setString(1, userMaster.getuname()); 
	        statement.setString(2, userMaster.getfName());
	        statement.setString(3,userMaster.getlName());   
	        statement.setString(4,userMaster.getrole()); 
	        statement.setString(5,userMaster.getschool()); 
	        boolean rowInserted = statement.executeUpdate() > 0;
	        statement.close();
	        return rowInserted;
	 }
	 
	 public userMaster getteacherbyid(int id) throws SQLException {
	        userMaster teacherlistid = null;
	        PreparedStatement statement = connection.prepareStatement("SELECT * FROM user_master WHERE user_id = ?");
	        statement.setInt(1, id); 
	        ResultSet resultSet = statement.executeQuery();
	         
	        if (resultSet.next()) {
	            String username = resultSet.getString("username");
	            String firstname = resultSet.getString("firstname");
	            String lastname = resultSet.getString("lastname");
	            String rolecode = "TEACHER";
	            String school = "SSSVV";
	            teacherlistid = new userMaster(id, username, firstname,lastname,rolecode,school);
	        }
	        resultSet.close();
	        statement.close();
	        return teacherlistid;
	    }
	 
	 public boolean updateTeacher(userMaster userMaster) throws SQLException {
		 
	        PreparedStatement statement = connection.prepareStatement("UPDATE user_master SET  firstname = ?,lastname=? WHERE user_id = ?");
	        statement.setString(1, userMaster.getfName());
	        statement.setString(2, userMaster.getlName());
	        statement.setInt(3, userMaster.getId());
	        boolean rowUpdated = statement.executeUpdate() > 0;
	        statement.close();
	        return rowUpdated;     
	  }
	 
	 public boolean deleteTeacher(userMaster userMaster) throws SQLException {
	        PreparedStatement statement = connection.prepareStatement("DELETE FROM user_master where user_id = ?");
	        statement.setInt(1, userMaster.getId());
	        boolean rowDeleted = statement.executeUpdate() > 0;
	        statement.close();
	        return rowDeleted;     
	 }
	 public List<userMaster> listAllStudents() throws SQLException {
	        List<userMaster> listStudents = new ArrayList<>();
	        PreparedStatement statement = connection
		            .prepareStatement("SELECT * FROM  user_master A INNER JOIN school_master B ON A.school_code = B.school_code  INNER JOIN  classmaster C ON C.classcode = A.classcode WHERE rolecode = 'STUDENT'");
	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	            int uid = resultSet.getInt("user_id");
	            String username = resultSet.getString("username");
	            String firstname = resultSet.getString("firstname");
	            String lastname = resultSet.getString("lastname");
	            String rolecode = resultSet.getString("rolecode");
	            String schoolname = resultSet.getString("school_name");
	            String classname = resultSet.getString("classname");
	            userMaster studentlist = new userMaster(uid,username,firstname,lastname,rolecode,schoolname,classname);
	            listStudents.add(studentlist);
	        }
	        resultSet.close();
	        statement.close();
	        return listStudents;
	    } 
	 public boolean insertStudent(userMaster userMaster) throws SQLException {
	        PreparedStatement statement = connection.prepareStatement("INSERT INTO  user_master  (  username ,  firstname ,  lastname ,  rolecode ,  school_code,classcode ) VALUES(?, ?,?,?,?,?)");
	        statement.setString(1, userMaster.getuname()); 
	        statement.setString(2, userMaster.getfName());
	        statement.setString(3,userMaster.getlName());   
	        statement.setString(4,userMaster.getrole()); 
	        statement.setString(5,userMaster.getschool());
	        statement.setString(6,userMaster.getclasscode());
	        boolean rowInserted = statement.executeUpdate() > 0;
	        statement.close();
	        return rowInserted;
	 }
	 
	 public userMaster getstudentbyid(int id) throws SQLException {
	        userMaster studentlistid = null;
	        PreparedStatement statement = connection.prepareStatement("SELECT * FROM user_master WHERE user_id = ?");
	        statement.setInt(1, id); 
	        ResultSet resultSet = statement.executeQuery();
	         
	        if (resultSet.next()) {
	            String username = resultSet.getString("username");
	            String firstname = resultSet.getString("firstname");
	            String lastname = resultSet.getString("lastname");
	            String classcode = resultSet.getString("classcode");
	            String rolecode = "TEACHER";
	            String school = "SSSVV";
	            studentlistid = new userMaster(id, username, firstname,lastname,rolecode,school,classcode);
	        }
	        resultSet.close();
	        statement.close();
	        return studentlistid;
	    }
	 
	 public boolean updateStudent(userMaster userMaster) throws SQLException {
		 
	        PreparedStatement statement = connection.prepareStatement("UPDATE user_master SET  firstname = ?,lastname=? WHERE user_id = ?");
	        statement.setString(1, userMaster.getfName());
	        statement.setString(2, userMaster.getlName());
	        statement.setInt(3, userMaster.getId());
	        boolean rowUpdated = statement.executeUpdate() > 0;
	        statement.close();
	        return rowUpdated;     
	  }
	 
	 public boolean deleteStudent(userMaster userMaster) throws SQLException {
	        PreparedStatement statement = connection.prepareStatement("DELETE FROM user_master where user_id = ?");
	        statement.setInt(1, userMaster.getId());
	        boolean rowDeleted = statement.executeUpdate() > 0;
	        statement.close();
	        return rowDeleted;     
	 }
	 
	 @SuppressWarnings("unused")
	public List<subjecttoteacher> listAllTeacherToSubject() throws SQLException {
	        List<subjecttoteacher> subjecttoteacherlist = new ArrayList<>();
	        PreparedStatement statement = connection
		            .prepareStatement("SELECT * FROM  subjecttoteacher A INNER JOIN user_master B ON A.teachercode = B.username INNER JOIN  subjectmaster C ON C.subcode = A.subcode INNER JOIN classmaster D ON D.classcode = C.classcode ");
	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	            int stt_id = resultSet.getInt("stt_id");
	            String username = resultSet.getString("username");
	            String firstname = resultSet.getString("firstname");
	            String lastname = resultSet.getString("lastname");
	            String subname = resultSet.getString("subname");
	            String classname = resultSet.getString("classname");
	            String fullname = firstname+" "+lastname;
	            subjecttoteacher sttlist = new subjecttoteacher(stt_id,subname,fullname,classname);
	            subjecttoteacherlist.add(sttlist);
	        }
	        resultSet.close();
	        statement.close();
	        return subjecttoteacherlist;
	    } 
	 
	 
	 public boolean assignsubject(subjecttoteacher subjecttoteacher) throws SQLException {
	        PreparedStatement statement = connection.prepareStatement("INSERT INTO subjecttoteacher (subcode,teachercode) VALUES (?, ?)");
	        statement.setString(1, subjecttoteacher.getscode());
	        statement.setString(2, subjecttoteacher.gettcode());        
	        boolean rowInserted = statement.executeUpdate() > 0;
	        statement.close();
	        return rowInserted;
	    }
	 
	 public boolean deleteAssignSubject(subjecttoteacher subjecttoteacher) throws SQLException {
	        PreparedStatement statement = connection.prepareStatement("DELETE FROM subjecttoteacher where stt_id = ?");
	        statement.setInt(1, subjecttoteacher.getId());
	        boolean rowDeleted = statement.executeUpdate() > 0;
	        statement.close();
	        return rowDeleted;     
	 }
	 
	 public List<userMaster> listStudentsByclass(String classcode) throws SQLException {
	        List<userMaster> listStudentsByclass = new ArrayList<>();
	        PreparedStatement statement = connection
		            .prepareStatement("SELECT * FROM  user_master A INNER JOIN school_master B ON A.school_code = B.school_code  INNER JOIN  classmaster C ON C.classcode = A.classcode WHERE rolecode = 'STUDENT' AND A.classcode = ?");
	        statement.setString(1, classcode);
	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	            int uid = resultSet.getInt("user_id");
	            String username = resultSet.getString("username");
	            String firstname = resultSet.getString("firstname");
	            String lastname = resultSet.getString("lastname");
	            String rolecode = resultSet.getString("rolecode");
	            String schoolname = resultSet.getString("school_name");
	            String classname = resultSet.getString("classname");
	            userMaster studentlistbyclass = new userMaster(uid,username,firstname,lastname,rolecode,schoolname,classname);
	            listStudentsByclass.add(studentlistbyclass);
	        }
	        resultSet.close();
	        statement.close();
	        return listStudentsByclass;
	    } 
	 
	 @SuppressWarnings("unused")
	public List<subjecttoteacher> listAllTeacherBySubject(String subcode) throws SQLException {
	        List<subjecttoteacher> teacherlistbysubject = new ArrayList<>();
	        PreparedStatement statement = connection
		            .prepareStatement("SELECT * FROM  subjecttoteacher A INNER JOIN user_master B ON A.teachercode = B.username INNER JOIN  subjectmaster C ON C.subcode = A.subcode INNER JOIN classmaster D ON D.classcode = C.classcode WHERE A.subcode =?");
	        statement.setString(1, subcode);
	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	            int stt_id = resultSet.getInt("stt_id");
	            String username = resultSet.getString("username");
	            String firstname = resultSet.getString("firstname");
	            String lastname = resultSet.getString("lastname");
	            String subname = resultSet.getString("subname");
	            String classname = resultSet.getString("classname");
	            String fullname = firstname+" "+lastname;
	            subjecttoteacher sttlistbysubject = new subjecttoteacher(stt_id,subname,fullname,classname);
	            teacherlistbysubject.add(sttlistbysubject);
	        }
	        resultSet.close();
	        statement.close();
	        return teacherlistbysubject;
	    } 
		
	private void printSQLException(SQLException e) {
		// TODO Auto-generated method stub
		
	}

	



}
