package hello.javatest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StudyInstanceTest {

    int value = 0;

    @Test
    void create_new_study_1() {
        Study study = new Study(value++);
        System.out.println(value);
        System.out.println(this);
    }

    @Test
    void create_new_study_2() {
        Study study = new Study(value++);
        System.out.println(value);
        System.out.println(this);
    }

    @Test
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