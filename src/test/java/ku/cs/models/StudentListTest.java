package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    StudentList sl = new StudentList();

    @BeforeEach
    void init(){
        sl = new StudentList();
        sl.addNewStudent("111", "Jack", 50);
        sl.addNewStudent("112", "Anna", 60);
        sl.addNewStudent("113", "Tom", 20);
    }

    @Test
    void testAddNewStudent(){
        sl.addNewStudent("114", "Haru", 10);
        sl.addNewStudent("115", "Rin" );
        sl.addNewStudent("116", "Apple", 20);


        Student s1 = sl.findStudentById("114");
        assertNotNull(s1);
        assertEquals("Haru", s1.getName());
        assertEquals(10, s1.getScore());

        Student s2 = sl.findStudentById("115");
        assertNotNull(s2);
        assertEquals("Rin", s2.getName());
        assertEquals(0, s2.getScore()); // score default ของ Rin ถ้าไม่ได้ส่งค่า

        Student s3 = sl.findStudentById("116");
        assertNotNull(s3);
        assertEquals("Apple", s3.getName());
        assertEquals(20, s3.getScore());
    }

    @Test
    void testFindStudentById(){
        sl.addNewStudent("114", "Haru", 10);
        sl.addNewStudent("115", "Rin");

        Student s1 = sl.findStudentById("114");
        assertEquals("Haru", s1.getName());

        Student s2 = sl.findStudentById("115");
        assertEquals("Rin", s2.getName());
    }

    @Test
    void testFilterByName(){
        sl.addNewStudent("114", "Haru", 10);
        sl.addNewStudent("115", "Rin");
        sl.addNewStudent("116", "Haru", 20);
        sl.addNewStudent("117", "Apple");

        StudentList filtered1 = sl.filterByName("Haru");
        assertEquals(2, filtered1.getStudents().size());


        StudentList filtered2 = sl.filterByName("Rin");
        assertEquals(1, filtered2.getStudents().size());

        StudentList filtered3 = sl.filterByName("Mika");
        assertEquals(0, filtered3.getStudents().size());
    }

    @Test
    void testGiveScoreToId() {
        sl.addNewStudent("114", "Haru", 10);
        sl.addNewStudent("115", "Rin");

        sl.giveScoreToId("114", 15);
        Student s1 = sl.findStudentById("114");
        assertEquals(25, s1.getScore());

        sl.giveScoreToId("115", 20);
        Student s2 = sl.findStudentById("115");
        assertEquals(20, s2.getScore());
    }

    @Test
    void testViewGradeOfId(){
        sl.addNewStudent("114", "Haru", 50);
        sl.addNewStudent("115", "Rin",80);

        assertEquals("D", sl.viewGradeOfId("114"));
        assertEquals("A", sl.viewGradeOfId("115"));

    }
}