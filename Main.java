import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*; 

abstract class Main extends Hospital {
	public static String joindate;
	public static void main (String args[])  {
        
		Hospital h1= new Hospital();
        h1.getHospitalInfo();
        
        int choice=0;
        Doctor o = new Doctor("Dr. Subhash Chandra","Corona");
        Doctor o1 = new Doctor("Dr. Vimal kumar","Cancer");
        Doctor o2 = new Doctor("Dr. Roshani","Cough");
        Doctor o3 = new Doctor("Dr. Ashwini","Fever");
        
        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
        joindate = formatter.format(currentDate.getTime());
        
        boolean wantToExit = false;
        do {
            System.out.print("\n Press 1 To add a new Doctor \n Press 2 To show all the doctors.\n Press 3 To Register new patient \n Press 4 To Assign doctor to patients\n Press 5 To show all patients \n");
            Scanner scan = new Scanner (System.in);
            choice = scan.nextInt();
            
            switch (choice){
                case 1:
                	String password = "scdev";
                	try {
                		System.out.println(" You want to Administration Access , write your password :");
                		String interedPassword = scan.next();
                		if(password.equals(interedPassword)) {
                			h1.addDoctor(o);
                            h1.addDoctor(o1);
                            h1.addDoctor(o2);
                            h1.addDoctor(o3);	
                		}else {
                			throw new MyException(" OOO....Sorry but you did it wrong , try again...!");
                		}
                	}
                	catch(MyException exp){
                		System.out.println("Catch Block") ;
                		System.out.println(exp) ;
                	}
                	
                    break;                
                case 2:{   
                	h1.showDoctors();
                    break;
                }    
                case 3:{
                        System.out.println("Enter Name : ");
                        String name = scan.next();
                        
                        System.out.println("Enter Age in years: ");
                        int age = scan.nextInt();

                        System.out.println("Enter Gender : ");
                        String gender = scan.next();

                        System.out.println("Enter problem specification : Corona | Cancer | Cough | Fever");
                        String Disease = scan.next();

                        Patient ob = new Patient(name, age, gender, Disease);
                        h1.addPatient(ob,joindate);
                        
                        h1.showPatients();
                        break;
                }   
                case 4:{
                    h1.assignDoctor();
                    break;
                }
                case 5:{
                    h1.showPatients();
                    break;
                }
            }
            System.out.println("\n Want to check something else ? Y/N :");
            String c = scan.next();
            if(c.toLowerCase().equals("n")){
                System.out.println("\nOkay Bye:)");
                wantToExit = true;
            }
        } while(wantToExit != true);
    }
}