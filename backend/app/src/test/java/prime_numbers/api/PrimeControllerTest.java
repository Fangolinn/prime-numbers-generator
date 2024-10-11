package prime_numbers.api;

import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PrimesControllerTest {

	@Autowired
	private MockMvc mvc;

    /**
     * Test if the API correctly returns a list of primes up to the given limit. 
     * 
     * The limit is inclusive.
     */
    @ParameterizedTest
    @CsvSource({
        "-1, '[]'",
        "1, '[]'",
        "10, '[2,3,5,7]'",
        "11, '[2,3,5,7,11]'" 
    })
    void getPrimes(int limit, String expectedResponse) throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/primes?limit=" + limit))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(expectedResponse)));
    }

    /**
     * Test if the API correctly returns a 400 Bad Request when the limit is an invalid type.
     */
    @Test
    void getPrimesInvalidLimit() throws Exception {
        String limit = "abc";

        mvc.perform(MockMvcRequestBuilders.get("/primes?limit=" + limit))
                .andExpect(status().isBadRequest());
    }
}
