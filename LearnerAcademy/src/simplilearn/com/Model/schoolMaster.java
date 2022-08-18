package simplilearn.com.Model;

public class schoolMaster {

	protected int id;
	protected String schoolcode;
	protected String schoolname;
	public schoolMaster() {
	}

    public schoolMaster(int id) {
    	this.id = id;
    	}
    public schoolMaster(String schoolcode, String schoolname) {
        super();
        this.schoolcode = schoolcode;
        this.schoolname = schoolname;
       
    }
    public schoolMaster(String schoolname) {
        super();
        
        this.schoolname = schoolname;
       
    }
	public schoolMaster(int id,String schoolcode, String schoolname) {
		// TODO Auto-generated constructor stub
		 super();
		    this.id = id;
	        this.schoolcode = schoolcode;
	        this.schoolname = schoolname;
	        
	}
	
	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getscode() {
        return schoolcode;
    }
    public void setscode(String schoolcode) {
        this.schoolcode = schoolcode;
    }
    public String getsName() {
        return schoolname;
    }
    public void setsName(String schoolname) {
        this.schoolname = schoolname;
    }
    
   

}
