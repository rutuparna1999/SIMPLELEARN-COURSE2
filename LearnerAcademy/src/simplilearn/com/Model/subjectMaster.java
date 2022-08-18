package simplilearn.com.Model;

public class subjectMaster {

	protected int id;
	protected String classcode;
	protected String subCode;
	protected String subName;
	public subjectMaster() {
	}

    public subjectMaster(int id) {
    	this.id = id;
    	}
    public subjectMaster(String classcode, String subCode, String subName) {
        super();
        this.classcode = classcode;
        this.subCode = subCode;
        this.subName = subName;
       
    }
    public subjectMaster(String subName) {
        super();
        
        this.subName = subName;
       
    }
	public subjectMaster(int id,String classcode, String subCode, String subName) {
		// TODO Auto-generated constructor stub
		 super();
		    this.id = id;
	        this.classcode = classcode;
	        this.subCode = subCode;
	        this.subName = subName;
	        
	}
	
	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getccode() {
        return classcode;
    }
    public void setccode(String classcode) {
        this.classcode = classcode;
    }
    public String getscode() {
        return subCode;
    }
    public void setscode(String subCode) {
        this.subCode = subCode;
    }
    public String getsName() {
        return subName;
    }
    public void setsName(String subName) {
        this.subName = subName;
    }
    
   


}

