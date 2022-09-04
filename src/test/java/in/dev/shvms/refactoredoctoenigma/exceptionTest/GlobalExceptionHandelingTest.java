package in.dev.shvms.refactoredoctoenigma.exceptionTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GlobalExceptionHandelingTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void exceptionHandelingTest404() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/exception/404").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void exceptionHandelingTest500() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/exception/500").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError());
    }
    @Test
    public void exceptionHandelingTestInvalidCode() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/exception/50o").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(equalTo("{\"httpStatus\":\"BAD_REQUEST\",\"errorMsg\":\"Expecting HTTP-CODE not 50o\"}")));
    }

}
