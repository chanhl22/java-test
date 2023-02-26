package hello.javatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class Study5Test {

    @DisplayName("10번 반복 테스트 1")
    @RepeatedTest(10)
    void repeat_test_1() {
        System.out.println("test");
    }

    @DisplayName("10번 반복 테스트 2")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void repeat_test_2(RepetitionInfo repetitionInfo) {
        System.out.println("test " + repetitionInfo.getCurrentRepetition() + "/" + repetitionInfo.getTotalRepetitions());
    }

    @DisplayName("반복 테스트 3")
    @ParameterizedTest
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요."})
    void parameterized_test_1(String message) {
        System.out.println(message);
    }

    @DisplayName("반복 테스트 4")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요."})
    void parameterized_test_2(String message) {
        System.out.println(message);
    }
}