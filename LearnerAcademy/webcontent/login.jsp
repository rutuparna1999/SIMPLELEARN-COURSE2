<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Learners Academy</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" type="text/javascript"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<style>
	@import url("https://fonts.googleapis.com/css2?family=Sriracha&display=swap");
	
	
	body {
	  margin: 0;
	  box-sizing: border-box;
	}
	
	/* CSS for header */
	.header {
	  display: flex;
	  justify-content: space-between;
	  align-items: center;
	  background-color: #f5f5f5;
	}
	
	.header .logo {
	  font-size: 25px;
	  font-family: "Sriracha", cursive;
	  color: #000;
	  text-decoration: none;
	  margin-left: 30px;
	}
	
	.nav-items {
	  display: flex;
	  justify-content: space-around;
	  align-items: center;
	  background-color: #f5f5f5;
	  margin-right: 20px;
	}
	
	.nav-items a {
	  text-decoration: none;
	  color: #000;
	  padding: 35px 20px;
	}
	
	/* CSS for main element */
	.intro {
	  display: flex;
	  flex-direction: column;
	  justify-content: center;
	  align-items: center;
	  width: 100%;
	  height: 520px;
	  background: linear-gradient(to bottom, rgba(0, 0, 0, 0.5) 0%, rgba(0, 0, 0, 0.5) 100%), url("https://images.unsplash.com/photo-1587620962725-abab7fe55159?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1031&q=80");
	  background-size: cover;
	  background-position: center;
	  background-repeat: no-repeat;
	}
	
	.intro h1 {
	  font-family: sans-serif;
	  font-size: 60px;
	  color: #fff;
	  font-weight: bold;
	  text-transform: uppercase;
	  margin: 0;
	}
	
	.intro p {
	  font-size: 20px;
	  color: #d1d1d1;
	  text-transform: uppercase;
	  margin: 20px 0;
	}
	
	.intro button {
	  background-color: #5edaf0;
	  color: #000;
	  padding: 10px 25px;
	  border: none;
	  border-radius: 5px;
	  font-size: 20px;
	  font-weight: bold;
	  cursor: pointer;
	  box-shadow: 0px 0px 20px rgba(255, 255, 255, 0.4)
	}
	
	.achievements {
	  display: flex;
	  justify-content: space-around;
	  align-items: center;
	  padding: 40px 80px;
	}
	
	.achievements .work {
	  display: flex;
	  flex-direction: column;
	  justify-content: center;
	  align-items: center;
	  padding: 0 40px;
	}
	
	.achievements .work i {
	  width: fit-content;
	  font-size: 50px;
	  color: #333333;
	  border-radius: 50%;
	  border: 2px solid #333333;
	  padding: 12px;
	}
	
	.achievements .work .work-heading {
	  font-size: 20px;
	  color: #333333;
	  text-transform: uppercase;
	  margin: 10px 0;
	}
	
	.achievements .work .work-text {
	  font-size: 15px;
	  color: #585858;
	  margin: 10px 0;
	}
	
	.about-me {
	  display: flex;
	  justify-content: center;
	  align-items: center;
	  padding: 40px 80px;
	  border-top: 2px solid #eeeeee;
	}
	
	.about-me img {
	  width: 500px;
	  max-width: 100%;
	  height: auto;
	  border-radius: 10px;
	}
	
	.about-me-text h2 {
	  font-size: 30px;
	  color: #333333;
	  text-transform: uppercase;
	  margin: 0;
	}
	
	.about-me-text p {
	  font-size: 15px;
	  color: #585858;
	  margin: 10px 0;
	}
	
	/* CSS for footer */
	.footer {
	  display: flex;
	  justify-content: space-between;
	  align-items: center;
	  background-color: #302f49;
	  padding: 40px 80px;
	}
	
	.footer .copy {
	  color: #fff;
	}
	
	.bottom-links {
	  display: flex;
	  justify-content: space-around;
	  align-items: center;
	  padding: 40px 0;
	}
	
	.bottom-links .links {
	  display: flex;
	  flex-direction: column;
	  justify-content: center;
	  align-items: center;
	  padding: 0 40px;
	}
	
	.bottom-links .links span {
	  font-size: 20px;
	  color: #fff;
	  text-transform: uppercase;
	  margin: 10px 0;
	}
	
	.bottom-links .links a {
	  text-decoration: none;
	  color: #a1a1a1;
	  padding: 10px 20px;
	}
	
	
	.btn-login {
	  font-size: 0.9rem;
	  letter-spacing: 0.05rem;
	  padding: 0.75rem 1rem;
	}
	
	
</style>
</head>

<body>
  <header class="header">
    <a href="#" class="logo">Learners Academy</a>
    <nav class="nav-items">
      <a href="#">Home</a>
      <a href="#">About</a>
      <a href="#">Contact</a>
    </nav>
  </header>
  <main>
    <div class="intro">
      <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card border-0 shadow rounded-3 my-5">
          <div class="card-body p-4 p-sm-5">
            <h5 class="card-title text-center mb-5 fw-light fs-5">Sign In</h5>
            <form method="post" action="postlogin">
              <div class="form-floating mb-3">
                <input type="text" class="form-control" id="uname"  name="uname" placeholder="name@example.com">
                <label for="floatingInput">User Name</label>
              </div>
              <div class="form-floating mb-3">
                <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                <label for="floatingPassword">Password</label>
              </div>

              <div class="form-check mb-3">
              
              </div>
              <div class="d-grid">
                <button class="btn btn-primary btn-login text-uppercase fw-bold" type="submit">Sign
                  in</button>
              </div>
              <hr class="my-4">
              <div class="d-grid mb-2">
               
              </div>
              <div class="d-grid">
               
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
 </div>
  </main>
  <footer class="footer">
    <div class="copy">&copy; 2022 LearnersAcademy</div>
  </footer>
</body>

</html>