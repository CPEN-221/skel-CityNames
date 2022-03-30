package citynetwork;

import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(20)
public class Task3Tests {

    @ParameterizedTest
    @MethodSource("buildCityNetProvider")
    public void test_buildCityNetwork(List<String> cityNames, int numCities) {
        assertTimeoutPreemptively(Duration.ofSeconds(20), () -> {
            CityNetwork cityNetwork = CityNetwork.buildNetwork(cityNames);
            assertTrue(cityNetwork.checkRep());
            assertEquals(numCities, cityNetwork._cities.size());
        });
    }

    private static Stream<Arguments> buildCityNetProvider() {
        return Stream.of(
            Arguments.of(
                List.of("VANCOUVER", "PARIS"),
                2
            ),
            Arguments.of(
                List.of("NEW YORK", "NEW DELHI", "NEWARK"),
                3
            ),
            Arguments.of(
                List.of("MADRAS", "MADRID"),
                2
            ),
            Arguments.of(
                List.of("JERUSALEM", "ULM", "JERICHO"),
                2
            ),
            Arguments.of(
                // The input list can have the
                // same name occur more than once.
                // Therefore, only one of the repeated
                // names can make it into the CityNetwork.
                List.of("NEW YORK", "NEW YORK"),
                1
            ),
            Arguments.of(
                List.of("NN", "NNN", "NNNN", "NNNNN"),
                1
            ),
            Arguments.of(
                List.of("LONDON", "LONDONDERRY", "LONDON HEATHROW", "BAGSHOT ROW", "HOBBITON", "THE TWO RIVERS", "EMONDS FIELD", "ARRAKIS", "PLANET ARRAKIS"),
                7
            ),
            Arguments.of(
                List.of("NEW DELHI", "NEW YORK", "NEWARK", "NEWTON", "RENTON", "DELTA", "DETROIT", "HANGZHOU", "GUANGZHOU"),
                9
            ),
            Arguments.of(
                List.of("NEW DELHI", "NEW YORK", "NEWARK", "NEWTON", "RENTON", "DELTA", "DETROIT", "HANGZHOU", "GUANGZHOU", "NEW ARK", "NEWTON DELTA"),
                9
            )
        );
    }
}
