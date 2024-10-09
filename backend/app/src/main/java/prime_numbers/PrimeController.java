package prime_numbers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class PrimeController {
    private final PrimeService primeService;

    @Autowired
    public PrimeController(PrimeService primeService) {
        this.primeService = primeService;
    }

    @GetMapping("/primes")
    public List<Integer> getPrimes(@RequestParam int limit) {
        log.debug("Hit on /primes endpoint with limit {}", limit);
        return primeService.calculatePrimes(limit);
    }
}
