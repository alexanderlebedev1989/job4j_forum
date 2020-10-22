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
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostServiceJdbc;

import java.util.Calendar;
import java.util.List;

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
public class CreateCommentControlTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostServiceJdbc postServiceJdbc;

    @MockBean
    private Post post;



    @Test
    @WithMockUser
    public void shouldReturnDefaultMessage() throws Exception {
        given(postServiceJdbc.findByIdPost(1)).willReturn(post);
        this.mockMvc.perform(post("/addComment")
                .param("id", "1")
                .param("description", "desc"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Comment> argument = ArgumentCaptor.forClass(Comment.class);
        verify(postServiceJdbc).saveComment(argument.capture());
        assertThat(argument.getValue().getDescription(), is("desc"));





    }


}
