package simplilearn.com.Model;

public class subjecttoteacher {

	protected int id;
	protected String subcode;
	protected String teachercode;
	protected String classcode;
	public subjecttoteacher() {
	}

    public subjecttoteacher(int id) {
    	this.id = id;
    	}
    public subjecttoteacher(String subcode, String teachercode) {
        super();
        this.subcode = subcode;
        this.teachercode = teachercode;
       
    }
    
	public subjecttoteacher(int id,String subcode, String teachercode) {
		// TODO Auto-generated constructor stub
		 super();
		    this.id = id;
	        this.subcode = subcode;
	        this.teachercode = teachercode;
	        
	}
	public subjecttoteacher(int id,String subcode, String teachercode,String classcode) {
		// TODO Auto-generated constructor stub
		 super();
		    this.id = id;
	        this.subcode = subcode;
	        this.teachercode = teachercode;
	        this.classcode = classcode;
	        
	}
	
	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getscode() {
        return subcode;
    }
    public void setscode(String subcode) {
        this.subcode = subcode;
    }
    public String gettcode() {
        return teachercode;
    }
    public void settcode(String teachercode) {
        this.teachercode = teachercode;
    }
    public String getclasscode() {
        return classcode;
    }
    public void setclasscode(String classcode) {
        this.classcode = classcode;
    }
    
   


}
