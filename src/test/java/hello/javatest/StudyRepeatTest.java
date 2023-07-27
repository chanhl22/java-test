package hello.javatest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyRepeatTest {

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

    @DisplayName("반복 테스트 5")
    @ParameterizedTest
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요."})
    @EmptySource
    @NullSource
    @NullAndEmptySource
    void parameterized_test_3(String message) {
        System.out.println(message);
    }

    @DisplayName("반복 테스트 6")
    @ParameterizedTest
    @ValueSource(ints = {10, 20, 40})
    void parameterized_test_4(Integer limit) {
        System.out.println(limit);
    }

    @DisplayName("반복 테스트 7")
    @ParameterizedTest
    @ValueSource(ints = {10, 20, 40})
    void parameterized_test_4(@ConvertWith(StudyCustom.class) Study study) {
        System.out.println(study.getLimit());
    }

    static class StudyCustom extends SimpleArgumentConverter {
        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            assertEquals(Study.class, targetType, "Can only convert to Study");
            return new Study(Integer.parseInt(source.toString()));
        }
    }

    @DisplayName("반복 테스트 8")
    @ParameterizedTest
    @CsvSource({"10, '자바 스터디'", "20, 스프링"})
    void parameterized_test_5(Integer limit, String name) {
        Study study = new Study(limit, name);
        System.out.println(study);
    }

    @DisplayName("반복 테스트 9")
    @ParameterizedTest
    @CsvSource({"10, '자바 스터디'", "20, 스프링"})
    void parameterized_test_6(ArgumentsAccessor argumentsAccessor) {
        Study study = new Study(argumentsAccessor.getInteger(0), argumentsAccessor.getString(1));
        System.out.println(study);
    }

    @DisplayName("반복 테스트 10")
    @ParameterizedTest
    @CsvSource({"10, '자바 스터디'", "20, 스프링"})
    void parameterized_test_7(@AggregateWith(StudyAggregator.class) Study study) {
        System.out.println(study);
    }

    static class StudyAggregator implements ArgumentsAggregator {
        @Override
        public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext context) throws ArgumentsAggregationException {
            return new Study(accessor.getInteger(0), accessor.getString(1));
        }
    }
}