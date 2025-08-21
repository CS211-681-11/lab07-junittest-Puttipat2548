package ku.cs.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student s;
    @BeforeEach
    void init(){
        s = new Student("6610404071","Puttpat");
    }

    @Test
    void testChangeName(){
        s.changeName("1234567890");
        assertEquals("1234567890",s.getName());
    }

    @Test
    void testAddScore() {
        s.addScore(40.1);
        assertEquals(40.1 , s.getScore());
    }
    @Test
    void testCalculateGrade() {
        s.addScore(20);
        assertEquals("F" , s.grade());
    }

    @Test
    void testIsId() {
        String IdCheck = "1234567890";
        assertEquals(false , s.isId(IdCheck));
    }

    @Test
    void testIsNameContains(){
        String nameCheck = "Jack";
        assertEquals(false , s.isNameContains(nameCheck));
    }
}