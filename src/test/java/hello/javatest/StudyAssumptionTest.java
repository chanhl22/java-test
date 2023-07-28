package hello.javatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class Study2Test {

    @Test
    @DisplayName("로컬인 경우에만 테스트를 실행 - assumeTrue")
    void local_env_1() {
        String test_env = System.getenv("TEST_ENV");
        System.out.println(test_env);
        assumeTrue("LOCAL".equalsIgnoreCase(test_env));

        Study study = new Study(10);
        assertThat(study.getLimit()).isGreaterThan(0);
    }

    @Test
    @DisplayName("로컬인 경우에만 테스트를 실행 - assumingThat")
    void local_env_2() {
        String test_env = System.getenv("TEST_ENV");
        System.out.println(test_env);

        assumingThat("LOCAL".equalsIgnoreCase(test_env), () -> {
            System.out.println("local");
            Study study = new Study(100);
            assertThat(study.getLimit()).isGreaterThan(0);
        });

        assumingThat("OTHER".equalsIgnoreCase(test_env), () -> {
            System.out.println("other");
            Study study = new Study(10);
            assertThat(study.getLimit()).isGreaterThan(0);
        });
    }

    @Test
    @DisplayName("OS에 따라서 테스트 여부 결정하기 - Enabled___")
    @EnabledOnOs({OS.MAC, OS.WINDOWS})
    void os_1() {
        System.out.println("1");
    }

    @Test
    @DisplayName("OS에 따라서 테스트 여부 결정하기 - Disabled___")
    @DisabledOnOs({OS.MAC, OS.WINDOWS})
    void os_2() {
        System.out.println("2");
    }

    @Test
    @DisplayName("자바 버전에 따라서 테스트 여부 결정하기 - Enabled___")
    @EnabledOnJre({JRE.JAVA_8, JRE.JAVA_9, JRE.JAVA_10, JRE.JAVA_11})
    void Jre_1() {
        System.out.println("1");
    }

    @Test
    @DisplayName("특정 환경 변수인 경우 - Enabled___")
    @EnabledIfEnvironmentVariable(named = "TEST_ENV", matches = "LOCAL")
    void environment_variable_1() {
        System.out.println("1");
    }
}