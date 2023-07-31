package hello.javatest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudyOrderTest {

    int value = 0;

    @Test
    @Order(3)
    void create_new_study_1() {
        Study study = new Study(value++);
        System.out.println(value);
        System.out.println(this);
    }

    @Test
    @Order(1)
    void create_new_study_2() {
        Study study = new Study(value++);
        System.out.println(value);
        System.out.println(this);
    }

    @Test
    @Order(2)
    void create_new_study_3() {
        Study study = new Study(value++);
        System.out.println(value);
        System.out.println(this);
    }

    @BeforeAll
    void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll
    void afterAll() {
        System.out.println("after all");
    }
}