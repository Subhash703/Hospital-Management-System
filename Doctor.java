import java.util.*; 
public class Doctor {

    private String  doctorName;
    private String  doctorSpeciality;

    //Doctor's status will changed when he will be assigned to some patent
    String  doctorStatus;
    List<Patient> doctorPatientList= new ArrayList<Patient>();
    Doctor(String dName, String cc)
    {
        this.doctorName = dName;
        this.doctorSpeciality = cc;
    }
    public String  getDoctorName()
    {
        return doctorName;
    }

    public List<Patient> getDoctorPatientList()
    {   
        return doctorPatientList;
    }

    public void addPatientsToDoctor(Patient o)
    {
        doctorPatientList.add(o);
    }

    String getDoctorspeciality()
    {
        return doctorSpeciality;
    }
    public String toString()
    {
        return (doctorName+" "+doctorSpeciality);
    }
}