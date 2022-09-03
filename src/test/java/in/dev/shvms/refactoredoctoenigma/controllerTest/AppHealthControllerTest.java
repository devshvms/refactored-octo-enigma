package in.dev.shvms.refactoredoctoenigma.controllerTest;

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
public class AppHealthControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void indexTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hit success!")));
    }
    @Test
    public void pingTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ping/pinged").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("pinged successful")));
    }

    @Test
    public void pingTest_invalid() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/ping/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }
}
