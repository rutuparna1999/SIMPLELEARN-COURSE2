package simplilearn.com.Model;

public class classMaster {

	protected int id;
	protected String classcode;
	protected String classname;
	public classMaster() {
	}

    public classMaster(int id) {
    	this.id = id;
    	}
    public classMaster(String classcode, String classname) {
        super();
        this.classcode = classcode;
        this.classname = classname;
       
    }
    public classMaster(String classname) {
        super();
        
        this.classname = classname;
       
    }
	public classMaster(int id,String classcode, String classname) {
		// TODO Auto-generated constructor stub
		 super();
		    this.id = id;
	        this.classcode = classcode;
	        this.classname = classname;
	        
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
    public String getcName() {
        return classname;
    }
    public void setcName(String classname) {
        this.classname = classname;
    }
    
   


}
