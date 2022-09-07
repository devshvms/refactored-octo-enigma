package in.dev.shvms.refactoredoctoenigma.customActuatorEndpoint;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class ActuatorInfoAddonTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void contribute() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/actuator/info").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("RefactoredOctoEnigma")))
                .andExpect(jsonPath("$.version", is("v1.0.0")))
                .andExpect(jsonPath("$.server_timestamp", isA(String.class)));
    }
}