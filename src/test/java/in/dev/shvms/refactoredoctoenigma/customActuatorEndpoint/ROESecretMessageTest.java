package in.dev.shvms.refactoredoctoenigma.customActuatorEndpoint;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.request.RequestPostProcessor;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ROESecretMessageTest {

    @Autowired
    MockMvc mockMvc;

    private final String secretMessage = "Its working! That is the msg.";

    protected RequestPostProcessor testUser() {
        return user("testUser").password("testPass").roles("USER");
    }

    @Test
    void getMsg() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/actuator/secretMsg")
                        .accept(MediaType.APPLICATION_JSON)
                        .with(testUser()))
                .andExpect(content().string(equalTo("Default Message!")));
    }

    @Test
    void postMsg() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/actuator/secretMsg")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"msg\": " + "\"" + secretMessage + "\"}")
                        .with(testUser()))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("success!")));

        mockMvc.perform(MockMvcRequestBuilders.get("/actuator/secretMsg")
                        .accept(MediaType.APPLICATION_JSON)
                        .with(testUser()))
                .andExpect(content().string(equalTo(secretMessage)));
    }
}