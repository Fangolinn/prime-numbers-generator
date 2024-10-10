package prime_numbers.service;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class PrimeServiceTest {

    private final PrimesService primeService = new PrimesService();

    @Test
    void testCalculatePrimes() {
        List<Integer> primes = primeService.calculatePrimes(10);
        assertEquals(List.of(2, 3, 5, 7), primes, "Prime numbers up to 10 should be [2, 3, 5, 7]");
    }

    @Test
    void testCalculatePrimesForLowLimit() {
        List<Integer> primes = primeService.calculatePrimes(1);
        assertTrue(primes.isEmpty(), "There should be no primes for limit 1");
    }

    @Test
    void testCalculatePrimesForNegativeLimit() {
        List<Integer> primes = primeService.calculatePrimes(-1);
        assertTrue(primes.isEmpty(), "There should be no primes for a negative limit");
    }
}

