import org.joda.time.DateTime;
import java.util.ArrayList;

public class StudentRegistrationDriver {

    public static void main(String[] args){

        ArrayList<Course> courses = create_courses(); // Creating a list of courses
        ArrayList<Module> modules = create_modules(); // Creating a list of modules

        // Dividing modules into 3 sets for adding each set into each course
        ArrayList<Module> module_set_1 = new ArrayList<>();
        ArrayList<Module> module_set_2 = new ArrayList<>();
        ArrayList<Module> module_set_3 = new ArrayList<>();
        for(int i = 0; i < modules.size(); i+=3){
            module_set_1.add(modules.get(i));
            module_set_2.add(modules.get(i+1));
            module_set_3.add(modules.get(i+2));
        }

        // Adding 1st set of modules to 1st course
        for(Module module: module_set_1) {
            courses.get(0).addModules(module);
        }
        // Adding 2nd set of modules to 2nd course
        for(Module module: module_set_2) {
            courses.get(1).addModules(module);
        }
        // Adding 3rd set of modules to 3rd course
        for(Module module: module_set_3) {
            courses.get(2).addModules(module);
        }

        // Creating a list of student using the sets of modules and courses
        ArrayList<Student> students = create_students(module_set_1, module_set_2, module_set_3, courses);
        // Printing details of all the students
        print_student_details(students);
        // Printing details of all the courses
        print_course_details(courses);
    }

    public static ArrayList<Course> create_courses(){

        ArrayList<Course> courses = new ArrayList<>();
        String[] course_names = {"IT", "ECE", "EEE"};

        for (String course_name : course_names) {
            courses.add(new Course(course_name, DateTime.parse("2021-09-06"), DateTime.parse("2022-05-30")));
        }
        return courses;
    }

    public static ArrayList<Module> create_modules(){

        ArrayList<Module> modules = new ArrayList<>();
        String[] module_names = {"CT417", "MM123", "EE342", "EM444", "EE431", "CS450", "ME427", "EC411", "EE420"};

        for (String module_name : module_names) {
            modules.add(new Module(module_name));
        }

        return modules;
    }

    public static ArrayList<Student> create_students(ArrayList<Module> module_set_1, ArrayList<Module> module_set_2, ArrayList<Module> module_set_3, ArrayList<Course> courses){

        ArrayList<Student> students = new ArrayList<>();
        String[] student_names = {"Abishek", "Patrick", "Sam", "Rohan", "Jack", "Emanuel", "Daniel", "Emma", "Mathew", "Ramya", "Rosy", "Bruce"};
        int[] student_ages = {20, 20, 21, 19, 20, 20, 19, 21, 21, 21, 20, 20};
        String[] student_dobs = {"08/12/2000", "01/1/2000", "05/10/2001", "12/11/2000", "12/1/2001", "09/2/2001", "05/10/1999", "02/5/1999", "07/12/1999", "31/7/1999", "02/11/2000", "26/10/2000"};
        int[] student_ids = {18280072, 12321321, 21345287, 23891764, 23143563, 20012327, 78787878, 98989898, 13121322, 21321312, 31232111, 21213212};

        for(int i = 0; i < (student_names.length ); i += 3 ){
            students.add(new Student(student_names[i], student_ages[i], student_dobs[i], student_ids[i], courses.get(0), module_set_1));
            students.add(new Student(student_names[i+1], student_ages[i+1], student_dobs[i+1], student_ids[i+1], courses.get(1), module_set_2));
            students.add(new Student(student_names[i+2], student_ages[i+2], student_dobs[i+2], student_ids[i+2], courses.get(2), module_set_3));
        }

        return students;
    }

    public static void print_student_details(ArrayList<Student> students){

        System.out.println("\n-------- Students --------");
        for (Student student:students) {
            System.out.println("Student name  : " + student.getName());
            System.out.println("Student Age   : " + student.getAge());
            System.out.println("Student DOB   : " + student.getDob());
            System.out.println("Student ID    : " + student.getId());
            System.out.println("Course taken  : " + student.getCourse().getCourse_name());
            System.out.println("Modules taken : " + student.getModules().get(0).getModuleName());
            for(int i=1; i < student.getModules().size(); i++) {
                System.out.println("                " + student.getModules().get(i).getModuleName());
            }
            System.out.println("--------------------------");
        }
    }

    public static void print_course_details(ArrayList<Course> courses){
        System.out.println("\n------- Courses -------");
        for (Course course: courses){
            System.out.println("Course Name : " + course.getCourse_name());
            System.out.println("Start Date  : " + course.getAcademic_start_date().toString("dd/MM/yy"));
            System.out.println("End Date    : " + course.getAcademic_end_date().toString("dd/MM/yy"));
            System.out.println("Modules     : " + course.getModules().get(0).getModuleName());
            for(int i=1; i < course.getModules().size(); i++) {
                System.out.println("              " + course.getModules().get(i).getModuleName());
            }
            System.out.println("-----------------------");
        }
    }
}