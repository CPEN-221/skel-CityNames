package citynetwork;

import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

@Timeout(20)
public class Task2Tests {

    @ParameterizedTest
    @MethodSource("verifyCityNetworkProvider")
    public void test_verifyCityNetwork(CityNetwork citynet, boolean expResult) {
        assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
            assertEquals(expResult, citynet.checkRep());
        });
    }

    private static CityNetwork buildArbitraryNetwork(String... strings) {
        CityNetwork citynet = new CityNetwork();
        for (int idx = 0; idx < strings.length; idx += 2) {
            citynet._cities.add(
                new CityTLA(strings[idx], strings[idx + 1])
            );
        }
        return citynet;
    }

    private static Stream<Arguments> verifyCityNetworkProvider() {
        return Stream.of(
            Arguments.of(
                buildArbitraryNetwork(
                    "VANCOUVER", "VAN",
                    "TORONTO", "TOR",
                    "PARIS", "PAR"),
                true
            ),
            Arguments.of(
                    buildArbitraryNetwork(
                        "VANCOUVER", "VAN",
                        "NEW YORK", "NYR",
                        "NEW DELHI", "DEL"
                    ),
                true
            ),
            Arguments.of(
                buildArbitraryNetwork(
                    "FRANKFURT", "FRA",
                    "ZURICH", "ZRH",
                    "LONDON HEATHROW", "LHR"
                ),
                true
            ),
            Arguments.of(
                buildArbitraryNetwork(
                    "FRANKFURT", "FRA",
                    "ZURICH", "ZRH",
                    "LONDON", "LHR"
                ),
                false
            ),
            Arguments.of(
                buildArbitraryNetwork(
                    "JERUSALEM", "JER",
                    "JERICHO", "JEC",
                    "SALEM", "SEM"
                ),
                false
            ),
            Arguments.of(
                buildArbitraryNetwork(
                    "JERUSALEM", "JEU",
                    "JERICHO", "JEC",
                    "SALOME", "LME"
                ),
                true
            ),
            Arguments.of(
                buildArbitraryNetwork(
                    "NEW DELHI", "DEL",
                    "NEW YORK", "YOR",
                    "NEWARK", "EWA",
                    "NEWTON", "EWO"
                ),
                false
            ),
            Arguments.of(
                buildArbitraryNetwork(
                    "NEW DELHI", "DHI",
                    "NEW YORK", "YOR",
                    "NEWARK", "EWA",
                    "NEWTON", "EWT",
                    "RENTON", "RNT",
                    "DELTA", "LTA",
                    "DETROIT", "ROI",
                    "HANGZHOU", "HGZ",
                    "GUANGZHOU", "GGZ"
                ),
                true
            ),
            Arguments.of(
                buildArbitraryNetwork(
                    "NEW DELHI", "DHI",
                    "NEW YORK", "YOR",
                    "NEWARK", "EWA",
                    "NEWTON", "EWT",
                    "RENTON", "RNT",
                    "DELTA", "DEL",
                    "DETROIT", "DET"
                ),
                false
            )
        );
    }
}
