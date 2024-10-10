package prime_numbers.api;

import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;
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

    @Test
    void getPrimes() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/primes?limit=10"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[2,3,5,7]")));
    }

    @Test
    void getPrimesForLowLimit() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/primes?limit=1"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }

    @Test
    void getPrimesForNegativeLimit() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/primes?limit=-1"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }
}
