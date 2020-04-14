import java.io.*;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.PrintWriter;
import java.util.*; 

class MyException extends Exception{
	   /*
	    * It's user defined execption class
	 */
	private static final long serialVersionUID = 1L;
	String str1;
	   /*
	    * here I am copying the message that we are passing while
	    * throwing the exception to a string and then displaying 
	    * that string along with the message.
	    */
	   MyException(String str2) {
		str1=str2;
	   }
	   public String toString(){ 
		return ("MyException Occurred: " + str1) ;
	   }
}

class Hospital implements HospitalInfo {
	
    List <Doctor> doctorList = new ArrayList<Doctor>();
    List <Patient> patientList = new ArrayList<Patient>();
    Scanner scan = new Scanner(System.in);
    
    static int docId = 1; //takes care of Doctor's ID in files
    static int PatID = 1; //takes care of patient's ID
    
    public void getHospitalInfo() {
    	System.out.println("\n\n\n");
        System.out.println("\t\t\t************ WELCOME TO HOSPITAL MANAGEMENT SYSTEM  *******************");
        System.out.println("\n\n\n");
    	System.out.println("ID of Hospital :"+ hospitalID);
    	System.out.println("Name of Hospital :"+ hospitalName);
    	System.out.println("Address : "+hospitalAddress+"\n\n\n");
    }
    //Getter and setter methods
    void addDoctor(Doctor o)
    {
        doctorList.add(o);
        System.out.println(o.toString());
        System.out.println("Are data is correct , wanna save it in file ?Y/N");
        String c = scan.next();
        if(c.toLowerCase().equals("y")) {
        	saveInFile(o);
        }
    }
    
    //Adding doctor to the hospital and saving it in a file Using FileWriter
    public void saveInFile(Doctor obj) {
    	try {
    	FileWriter fw = new FileWriter("D:\\JavaEclipse\\eclipse\\Hospital Management System\\src\\Hospitaldata\\doctors.csv",true);
       	 StringBuilder sb = new StringBuilder();
       	 sb.append("\n");
   		 sb.append(docId);
   		 sb.append(",");
   		 sb.append(obj.getDoctorName());
   		 sb.append(",");
   		 sb.append(obj.getDoctorspeciality());
   		 sb.append("\n");
   		 docId++;
     
       	 fw.write(sb.toString());
       	 fw.close();
       	 System.out.println("Successfully intered data");
       }
       catch(Exception e) {
       	//Execption should here
       	System.out.println(e.toString());
       }
    }
    
    //Adding patient to hospital and in File using FileWriter
    void addPatient(Patient o,String joindate)
    {
        patientList.add(o);
        try {
        	FileWriter fw = new FileWriter("D:\\JavaEclipse\\eclipse\\Hospital Management System\\src\\Hospitaldata\\patients.csv",true);
          	 StringBuilder sb = new StringBuilder();

      		 sb.append("\n");
      		 sb.append(PatID);
      		 sb.append(",");
      		 sb.append(o.getPatientName());
      		 sb.append(",");
      		 sb.append(o.getAge());
      		 sb.append(",");
     		 sb.append(o.getGender());
     		 sb.append(",");
     		 sb.append(o.getDisease());
			 sb.append(",");
			 sb.append(o.joindate);
      		 sb.append("\n");
      		 PatID++;
      	 
          	 fw.write(sb.toString());
          	 fw.close();
          	 System.out.println("Successfully intered data");
          	      	 
          }
          catch(Exception e) {
          	//Execption should here
          	System.out.println(e.toString());
          }
        

    }
        
    

    public void showDoctors()
    {
        try {
        	//
        	Scanner sc = new Scanner(new File("D:\\JavaEclipse\\eclipse\\Hospital Management System\\src\\Hospitaldata\\doctors.csv"));  
        	sc.useDelimiter(",");   //sets the delimiter pattern
        	while (sc.hasNext())  //returns a boolean value  
        	{  
        	
        		System.out.print(sc.next()+" ");  //find and returns the next complete token from this scanner  
        	}   
        	sc.close();
        }catch(FileNotFoundException e) {
        	//sOMETHING HAPPEND
        	System.out.println("Something is wrong!! "+e.toString());
        }
        
    }
    
    public void showPatients()
    {
    	
    	try {
        	//
        	Scanner sc = new Scanner(new File("D:\\JavaEclipse\\eclipse\\Hospital Management System\\src\\Hospitaldata\\patients.csv"));  
        	sc.useDelimiter(",");   //sets the delimiter pattern
        	while (sc.hasNext())  //returns a boolean value  
        	{  
        	
        		System.out.print(sc.next()+" ");  //find and returns the next complete token from this scanner  
        	}   
        	sc.close();
        }catch(FileNotFoundException e) {
        	//sOMETHING HAPPEND
        	System.out.println("Something is wrong!! "+e.toString());
        }
	}

    public void assignDoctor()
    {
        for (Patient x: patientList)
        {      
            for (Doctor y: doctorList)
            {     
                if (x.getDisease().equals("eye"))
                {
                    if (y.getDoctorspeciality().equals("Opthalmologist"))
                    {
                        y.addPatientsToDoctor(x);
                    }
                }
                if (x.getDisease().equals("heart patient"))
                {
                    if (y.getDoctorspeciality().equals("Surgeon"))
                    {
                        y.addPatientsToDoctor(x);
                    }
                }

                if (x.getDisease().equals("earnose"))
                {
                    if (y.getDoctorspeciality().equals("ENT"))
                    {
                        y.addPatientsToDoctor(x);
                    }
                }

            }
        }

    }
}