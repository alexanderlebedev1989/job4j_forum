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
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class CreateControlTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostServiceJdbc postServiceJdbc;

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(post("/create")
                .param("name",
                        "Куплю ладу-грант. Дорого."))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Post> argument = ArgumentCaptor.forClass(Post.class);
        verify(postServiceJdbc).savePost(argument.capture());
        assertThat(argument.getValue().getName(), is("Куплю ладу-грант. Дорого."));
    }
}
