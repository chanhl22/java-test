package hello.javatest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class Study1Test {

    @Test
    @DisplayName("스터디 만들기")
    void create_new_study_1() {
        Study study = new Study();
        assertNotNull(study);
        assertEquals(StudyStatus.DRAFT, study.getStatus(),
                () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + " 상태다.");
    }

    @Test
    @DisplayName("스터디 만들기 assertAll")
    void create_new_study_2() {
        Study study = new Study(10);

        assertAll(
                () -> assertNotNull(study),
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(),
                        () -> "스터디를 처음 만들면 상태값이" + StudyStatus.DRAFT + " 상태다."),
                () -> assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0보다 커야 한다.")
        );
    }

    @Test
    @DisplayName("스터디 만들기 assertThrows")
    void create_new_study_3() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Study(-10));
        assertEquals("limit은 0보다 커야 한다.", exception.getMessage());
    }

    @Test
    @DisplayName("스터디 만들기 assertTimeout")
    void create_new_study_4() {
        assertTimeout(Duration.ofSeconds(10), () -> new Study(10));

//        assertTimeout(Duration.ofMillis(100), () -> {
//            new Study(10);
//            Thread.sleep(300);
//        });

//        assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
//            new Study(10);
//            Thread.sleep(300);
//        });
    }

    @Test
    @Disabled
    void create_new_study_again() {
        System.out.println("create1");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("before each");
    }

    @AfterEach
    void AfterEach() {
        System.out.println("After each");
    }
}