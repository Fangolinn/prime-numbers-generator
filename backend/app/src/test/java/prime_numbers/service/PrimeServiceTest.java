package prime_numbers.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class PrimeServiceTest {

    private final PrimesService primeService = new PrimesService();

    /**
     * Test the calculation of prime numbers up to the given limit. 
     * 
     * The limit is inclusive.
     */
    @ParameterizedTest
    @CsvSource({
        "10, '2,3,5,7'",
        "11, '2,3,5,7,11'" 
    })
    void testCalculatePrimes(int limit, String expectedOutput) {
        log.info("limit: {}, expectedOutput: {}", limit, expectedOutput);

        List<Integer> expectedOutputList = Stream.of(expectedOutput.split(",")) 
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        List<Integer> primes = primeService.calculatePrimes(limit);
        assertEquals(expectedOutputList, primes, String.format("Prime numbers up to %d should be [%s]", limit, expectedOutput));
    }

    /**
     * Test the calculation of prime numbers for a low limit, where there are no prime numbers.
     */
    @Test
    void testCalculatePrimesForLowLimit() {
        int limit = 1;

        List<Integer> primes = primeService.calculatePrimes(limit);
        assertTrue(primes.isEmpty(), "There should be no primes for limit 1");
    }

    /**
     * Test the calculation of prime numbers for a negative limit, where there are no prime numbers.
     */
    @Test
    void testCalculatePrimesForNegativeLimit() {
        int limit = -1;

        List<Integer> primes = primeService.calculatePrimes(limit);
        assertTrue(primes.isEmpty(), "There should be no primes for a negative limit");
    }
}

