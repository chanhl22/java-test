package hello.javatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class Study4Test {

    @FastTest
    @DisplayName("스터디 만들기 fast")
    void tag_1() {
        Study study = new Study(10);
        assertThat(study.getLimit()).isGreaterThan(0);
    }

    @SlowTest
    @DisplayName("스터디 만들기 slow")
    void tag_2() {
        Study study = new Study(10);
        assertThat(study.getLimit()).isGreaterThan(0);
    }
}