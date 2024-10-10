package prime_numbers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import prime_numbers.service.PrimesService;

/**
 * REST controller that handles HTTP requests for prime number calculations.
 * Provides an endpoint to retrieve a list of prime numbers up to a specified limit (inclusive).
 */
@RestController
@Slf4j
public class PrimesController {
    private final PrimesService primeService;

    @Autowired
    public PrimesController(PrimesService primeService) {
        this.primeService = primeService;
    }

    @GetMapping("/primes")
    public List<Integer> getPrimes(@RequestParam int limit) {
        log.debug("Hit on /primes endpoint with limit {}", limit);
        return primeService.calculatePrimes(limit);
    }
}
