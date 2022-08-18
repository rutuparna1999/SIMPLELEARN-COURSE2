<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Learners Academy</title>
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css" integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I" crossorigin="anonymous">
    <style>
    body{
    font-size:21px;
    }
        .sidebar {
            position: fixed;
            top: 0;
            bottom: 0;
            left: 0;
            z-index: 100;
            padding: 90px 0 0;
            box-shadow: inset -1px 0 0 rgba(0, 0, 0, .1);
            z-index: 99;
        }

        @media (max-width: 767.98px) {
            .sidebar {
                top: 11.5rem;
                padding: 0;
            }
        }
            
        .navbar {
            box-shadow: inset 0 -1px 0 rgba(0, 0, 0, .1);
        }

        @media (min-width: 767.98px) {
            .navbar {
                top: 0;
                position: sticky;
                z-index: 999;
            }
        }

        .sidebar .nav-link {
            color: #333;
        }

        .sidebar .nav-link.active {
            color: #0d6efd;
        }
     
	
      
    </style>
</head>
<body>
    <nav class="navbar navbar-light bg-light p-3">
        <div class="d-flex col-12 col-md-3 col-lg-2 mb-2 mb-lg-0 flex-wrap flex-md-nowrap justify-content-between">
            <a class="navbar-brand" href="#">
              <h1 style="font-size:21px;">Learners Academy Dashboard</h1>
            </a>
            <button class="navbar-toggler d-md-none collapsed mb-3" type="button" data-toggle="collapse" data-target="#sidebar" aria-controls="sidebar" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </div>
       
        <div class="col-12 col-md-5 col-lg-8 d-flex align-items-center justify-content-md-end mt-3 mt-md-0">
            
           
        </div>
    </nav>
    <div class="container-fluid">
        <div class="row">
            <nav id="sidebar" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
                <div class="position-sticky">
                    <ul class="nav flex-column">
                        <li class="nav-item">
                          <a class="nav-link" aria-current="page" href="dashboard">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-home"><path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path><polyline points="9 22 9 12 15 12 15 22"></polyline></svg>
                            <span class="ml-2">Dashboard</span>
                          </a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="listClass">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                            <span class="ml-2">Class</span>
                          </a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="listTeacher">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-users"><path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path><circle cx="9" cy="7" r="4"></circle><path d="M23 21v-2a4 4 0 0 0-3-3.87"></path><path d="M16 3.13a4 4 0 0 1 0 7.75"></path></svg>
                            <span class="ml-2">Teacher</span>
                          </a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="listStudent">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-users"><path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path><circle cx="9" cy="7" r="4"></circle><path d="M23 21v-2a4 4 0 0 0-3-3.87"></path><path d="M16 3.13a4 4 0 0 1 0 7.75"></path></svg>
                            <span class="ml-2">Student</span>
                          </a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="ListStudentByClass">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-bar-chart-2"><line x1="18" y1="20" x2="18" y2="10"></line><line x1="12" y1="20" x2="12" y2="4"></line><line x1="6" y1="20" x2="6" y2="14"></line></svg>
                            <span class="ml-2">Class Wise Student Reports</span>
                          </a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="ListTeacherBySubject">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-bar-chart-2"><line x1="18" y1="20" x2="18" y2="10"></line><line x1="12" y1="20" x2="12" y2="4"></line><line x1="6" y1="20" x2="6" y2="14"></line></svg>
                            <span class="ml-2">Subject Wise Teacher  Reports</span>
                          </a>
                        </li>

                      </ul>
                </div>
            </nav>
            <main class="col-md-9 ml-sm-auto col-lg-10 px-md-4 py-4">
           
             <div class="container">
			  <h2><c:if test="${userMaster != null}">
                        Edit Student
                    </c:if>
                    <c:if test="${userMaster == null}">
                        Add New Student
                    </c:if>
                   </h2>
				<c:if test="${userMaster != null}">
		            <form action="updateStudent" method="post">
		        </c:if>
		        <c:if test="${userMaster == null}">
		            <form action="addStudent" method="post">
		        </c:if>
				  <input type="hidden" name="uid" id="uid" value="<c:out value='${userMaster.id}' />"/>
				  <input type="hidden" name="hiduname" id="hiduname" value="<c:out value='${userMaster.uname}' />"/>
				  <input type="hidden" name="ccode" id="ccode" value="<c:out value='${userMaster.classcode}' />"/>
			    <div class="form-group"  style="padding:15px;">
			      <label for="username">User Name</label>
			      <c:if test="${userMaster != null}">
		             <input type="text" class="form-control" id="uname" name="uname" value="<c:out value='${userMaster.uname}' />" placeholder="Enter User Name"  disabled>
		        </c:if>
		        <c:if test="${userMaster == null}">
		             <input type="text" class="form-control" id="uname" name="uname" value="" placeholder="Enter User Name"  required>
		        </c:if>
		         </div>
			    <div class="form-group" style="padding:15px;">
			      <label for="fname">First Name:</label>
			      <input type="text" class="form-control" id="fname" name="fname" value="<c:out value='${userMaster.fName}' />" placeholder="Enter Class Name"  required>
			    </div>
			    
			    <div class="form-group" style="padding:15px;">
			      <label for="lname">Last Name:</label>
			      <input type="text" class="form-control" id="lname" name="lname" value="<c:out value='${userMaster.lName}' />" placeholder="Enter Class Name"  required>
			    </div>
			    <div class="form-group" style="padding:15px;">
			      <label for="cname">Class Name:</label>
			       <c:if test="${userMaster != null}">
			      <select name="cname" id="cname" class="form-control" disabled>
			      <option value = ""> Select CLass  </option>  
			       <c:forEach var="classMaster" items="${listClass}">
	                     <option value="<c:out value="${classMaster.ccode}" />" <c:if test="${classMaster.ccode eq selectedclass}">selected="selected"</c:if>><c:out value="${classMaster.cName}" /></option>
			      </c:forEach>   
				</select>   
				 </c:if>
				 <c:if test="${userMaster == null}">
				  <select name="cname" id="cname" class="form-control" >
			      <option value = ""> Select CLass  </option>  
			       <c:forEach var="classMaster" items="${listClass}">   
	                    <option value="<c:out value="${classMaster.ccode}" />"><c:out value="${classMaster.cName}" /></option>
			      </c:forEach>   
				</select> 
				 </c:if>  
			    </div>
			   <c:if test="${userMaster != null}">
		           <button type="submit"   class="btn btn-primary">Update Student</button>
		        </c:if>
		        <c:if test="${userMaster == null}">
		            <button type="submit"   class="btn btn-primary">Add Student</button>
		        </c:if>
			  </form>
			</div>

                <footer class="pt-5 d-flex justify-content-between">
                     <span>Copyright © 20122-2023 <a href="#">Learners Academy</a></span>
                </footer>
            </main>
        </div>
    </div>
  
 
</body>
</html>
