package constructor;
import java.util.*;

class Student {
    private String name;
    private int rollNo;
    private double marks;

    public String getName() 
    {
    	return name; 
    }
    public void setName(String name) 
    { 
    	this.name = name; 
    }
    public int getRollNo() 
    { 
    	return rollNo; 
    }
    public void setRollNo(int rollNo) 
    { 
    	this.rollNo = rollNo; 
    }
    public double getMarks() 
    { 
    	return marks; 
    }
    public void setMarks(double marks) 
    { 
    	this.marks = marks; 
    }
    Student() {
        System.out.println("Default Constructor Called");
    }
    Student(String name, int rollNo, double marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.setMarks(marks);
    }
    void displayInfo(){
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Marks: " + marks);
    }
}

public class StudentApplication {
    void menu() {
        System.out.println("\nMenu");
        System.out.println("1. Add Student");
        System.out.println("2. Display All");
        System.out.println("3. Display One");
        System.out.println("4. Delete");
        System.out.println("5. Modify");
        System.out.println("6. Sort by Marks");
        System.out.println("0. Exit");
    }

    public static void main(String[] args) {
        StudentApplication obj = new StudentApplication();
        Student [] students = new Student[10]; 
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            obj.menu();
            System.out.print("Enter your choice: ");   
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    for(int i=0;i<students.length;i++){
                        if(students[i]==null){
                            System.out.print("Enter Name: ");                  
                            String name = sc.next();
                            System.out.print("Enter Roll No: ");
                            int rollNo = sc.nextInt();
                            System.out.print("Enter Marks: ");                  
                            double marks = sc.nextDouble();
                            students[i]= new Student(name,rollNo,marks);
                            System.out.println("Student added!");
                            break; 
                        }
                    }
                    break;
                case 2:
                    System.out.println("Student Details:");
                    for(Student s : students){
                        if(s!=null){
                            s.displayInfo();
                            System.out.println("-----");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter Roll No to search: ");
                    int searchRollNo = sc.nextInt();
                    boolean found = false;
                    for(Student s : students){
                        if(s!=null && s.getRollNo() == searchRollNo){
                            s.displayInfo();
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Student not found.");
                    break;
                case 4:
                    System.out.print("Enter Roll No to delete: ");
                    int delRollNo = sc.nextInt();
                    boolean deleted = false;
                    for(int i=0;i<students.length;i++){
                        if(students[i]!=null && students[i].getRollNo() == delRollNo){
                            for(int j=i;j<students.length-1;j++){
                                students[j] = students[j+1];
                            }
                            students[students.length-1] = null;
                            deleted = true;
                            System.out.println("Student deleted.");
                            break;
                        }
                    }
                    if(!deleted) System.out.println("Student not found.");
                    break;
                case 5:
                    System.out.print("Enter Roll No to modify: ");
                    int modRollNo = sc.nextInt();
                    Student toModify = null;
                    for(Student s : students){
                        if(s!=null && s.getRollNo()==modRollNo){
                            toModify = s; 
                            break;
                        }
                    }
                    if (toModify==null) {
                        System.out.println("Student not found."); 
                        break;
                    }
                    System.out.println("1. Modify Name");
                    System.out.println("2. Modify RollNo");
                    System.out.println("3. Modify Marks");
                    System.out.println("4. Modify All");
                    int modChoice = sc.nextInt();
                    sc.nextLine();
                    switch(modChoice){
                        case 1:
                            System.out.print("Enter new name: ");
                            toModify.setName(sc.next());
                            break;
                        case 2:
                            System.out.print("Enter new roll no: ");
                            toModify.setRollNo(sc.nextInt());
                            break;
                        case 3:
                            System.out.print("Enter new marks: ");
                            toModify.setMarks(sc.nextDouble());
                            break;
                        case 4:
                            System.out.print("Enter new name: ");
                            toModify.setName(sc.next());
                            System.out.print("Enter new roll no: ");
                            toModify.setRollNo(sc.nextInt());
                            System.out.print("Enter new marks: ");
                            toModify.setMarks(sc.nextDouble());
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    System.out.println("Student modified.");
                    break;
                       case 6:
                    for(int i=0; i<students.length-1; i++){
                        for(int j=i+1;j<students.length;j++){
                            if(students[i]!=null && students[j]!=null
                                && students[i].getMarks() > students[j].getMarks()){
                                Student temp = students[i];
                                students[i] = students[j];
                                students[j] = temp;
                            }
                        }
                    }
                    System.out.println("Sorted by marks.");
                    break;
                	
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
	
        } while (choice != 0);
        sc.close();
    }
}
