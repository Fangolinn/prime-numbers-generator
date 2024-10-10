package prime_numbers.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * Service class for calculating prime numbers up to a given limit (inclusive).
 * Utilizes the Sieve of Eratosthenes algorithm to find all prime numbers up to the specified limit.
 */
@Service
@Slf4j
public class PrimesService {
    public List<Integer> calculatePrimes(int limit) {
        log.debug("Calculating prime numbers up to {}", limit);

        if (limit < 2) {
            return new ArrayList<>();
        }

        boolean[] isPrime = new boolean[limit + 1];
        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }

        for (int p = 2; p * p <= limit; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= limit; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        log.debug("Found {} prime numbers - {}", primes.size(), primes);

        return primes;
    }
}
