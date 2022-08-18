package simplilearn.com.Model;

public class userMaster {

	protected int id;
	protected String username;
	protected String firstname;
	protected String lastname;
    protected String rolecode;
    protected String schoolname;
	protected String classcode;
	
    public userMaster() {
	}

    public userMaster(int id) {
    	this.id = id;
    	}
    public userMaster(String username, String firstname, String lastname,String rolecode,String schoolname) {
        super();
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.rolecode = rolecode;
        this.schoolname = schoolname;
    }
	public userMaster(int id,String username, String firstname, String lastname,String rolecode,String schoolname) {
		// TODO Auto-generated constructor stub
		 super();
		    this.id = id;
	        this.username = username;
	        this.firstname = firstname;
	        this.lastname = lastname;
	        this.rolecode = rolecode;
	        this.schoolname = schoolname;
	}
	
	public userMaster(int id,String username, String firstname, String lastname,String rolecode,String schoolname,String classcode) {
		// TODO Auto-generated constructor stub
		 super();
		    this.id = id;
	        this.username = username;
	        this.firstname = firstname;
	        this.lastname = lastname;
	        this.rolecode = rolecode;
	        this.schoolname = schoolname;
	        this.classcode = classcode;
	}
	
	public userMaster(String username, String firstname, String lastname,String rolecode,String schoolname,String classcode) {
		// TODO Auto-generated constructor stub
		 super();
		    
	        this.username = username;
	        this.firstname = firstname;
	        this.lastname = lastname;
	        this.rolecode = rolecode;
	        this.schoolname = schoolname;
	        this.classcode = classcode;
	}
	
	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getuname() {
        return username;
    }
    public void setuname(String username) {
        this.username = username;
    }
    public String getfName() {
        return firstname;
    }
    public void setfName(String firstname) {
        this.firstname = firstname;
    }
    public String getlName() {
        return lastname;
    }
    public void setlname(String lastname) {
        this.lastname = lastname;
    }
    public String getrole() {
        return rolecode;
    }
    public void setrole(String rolecode) {
        this.rolecode = rolecode;
    }
    
    public String getschool() {
        return schoolname;
     }
     public void setschool(String schoolname) {
        this.schoolname = schoolname;
     }
     public String getclasscode() {
         return classcode;
      }
      public void setclasscode(String classcode) {
         this.classcode = classcode;
      }
}
