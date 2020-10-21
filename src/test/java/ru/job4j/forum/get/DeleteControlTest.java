package ru.job4j.forum.get;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostServiceJdbc;
import java.util.Calendar;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class DeleteControlTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostServiceJdbc postServiceJdbc;

    @Test
    @WithMockUser
    public void whenDeletePostWhenReturnIndex() throws Exception {
        Post post = Post.of(1, "test", Calendar.getInstance());
        given(postServiceJdbc.findByIdPost(1)).willReturn(post);
        this.mockMvc.perform(get("/delete?id=" + post.getId()))
                .andDo(print())
                .andExpect(status().is(302))
                .andExpect(view().name("redirect:/index"));
    }
}
