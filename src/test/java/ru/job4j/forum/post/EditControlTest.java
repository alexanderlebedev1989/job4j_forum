package ru.job4j.forum.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostServiceJdbc;

import java.util.Calendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class EditControlTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostServiceJdbc postServiceJdbc;

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessage() throws Exception {
        Post post = Post.of(1, "test", Calendar.getInstance());
        given(postServiceJdbc.findByIdPost(1)).willReturn(post);
        this.mockMvc.perform(post("/edit?id=" + post.getId())
                .param("name",
                        "newTest").param("description",
                         "desc"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        verify(postServiceJdbc).savePost(post);
        assertThat(post.getName(), is("newTest"));
    }
}
