package hello.javatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class Study3Test {

    @Test
    @DisplayName("스터디 만들기 fast")
    @Tag("fast")
    void tag_1() {
        Study study = new Study(10);
        assertThat(study.getLimit()).isGreaterThan(0);
    }

    @Test
    @DisplayName("스터디 만들기 slow")
    @Tag("slow")
    void tag_2() {
        Study study = new Study(10);
        assertThat(study.getLimit()).isGreaterThan(0);
    }
}