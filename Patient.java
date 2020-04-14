import java.util.*; 

interface Pdata{
	
	public String getPatientName();
	public int getAge();
	public String getDisease();
	public String getGender();
}

public class Patient implements Pdata{
    private String patientName;
    private int patientAge;
    private String  patientGender;
    private String disease;
    Patient (String patientName, int patientAge,String patientGender, String disease)
    {
        this.patientName= patientName;
        this.patientGender= patientGender;
        this.patientAge=patientAge;
        this.disease=disease;
    }   
    
    public String getPatientName()
    {
        return patientName;
    }
    public int getAge()
    {
        return patientAge;
    }
    public String getDisease()
    {
        return disease;
    }
    public String getGender() {
    	return patientGender;
    }
    public String toString()
    {
        return (patientName+" "+patientAge+" "+patientGender +" "+ disease);
    }
}