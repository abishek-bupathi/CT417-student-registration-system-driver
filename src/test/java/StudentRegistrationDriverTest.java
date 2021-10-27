import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentRegistrationDriverTest {

    @Test
    void create_courses() {

        ArrayList<Course> courses = new ArrayList<>();
        // Creating the expected data from create_course method
        courses.add(new Course("IT", DateTime.parse("2021-09-06"), DateTime.parse("2022-05-30")));
        courses.add(new Course("ECE", DateTime.parse("2021-09-06"), DateTime.parse("2022-05-30")));
        courses.add(new Course("EEE", DateTime.parse("2021-09-06"), DateTime.parse("2022-05-30")));

        for(int i = 0; i < 3; i++) {
            // Checking the names of expected and returned courses
            assertEquals(courses.get(i).getCourse_name(), StudentRegistrationDriver.create_courses().get(i).getCourse_name());
        }
    }
}