package citynetwork;

import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

@Timeout(20)
public class Task1Tests {

    @ParameterizedTest
    @MethodSource("verifyCityTLAProvider")
    public void test_verifyCityTLA(CityTLA city, boolean expResult) {
        assertTimeoutPreemptively(Duration.ofSeconds(4), () -> {
            assertEquals(expResult, city.checkRep());
        });
    }

    private static Stream<Arguments> verifyCityTLAProvider() {
        return Stream.of(
                Arguments.of(new CityTLA("VANCOUVER", "VAN"), true),
            Arguments.of(new CityTLA("VANCOUVER", "VVR"), true),
            Arguments.of(new CityTLA("VANCOUVER", "OUR"),
                true),
            Arguments.of(new CityTLA("VANCOUVER", "CNR"), false),
            Arguments.of(new CityTLA("VANCOUVER", "YVR"), false),
            Arguments.of(new CityTLA("NEW DELHI", "NEW"), true),
            Arguments.of(new CityTLA("NEW DELHI", "N D"), false),
            Arguments.of(new CityTLA("LONDON", "LLN"), false),
            Arguments.of(new CityTLA("CASABLANCA", "LAN"), true),
            Arguments.of(new CityTLA("BUENOS AIRES", "BAR"), true),
            Arguments.of(new CityTLA("BUENOS AIRES", "BE "), false),
            Arguments.of(new CityTLA("BUENOS AIRES", "ERE"), true)
        );
    }

}
