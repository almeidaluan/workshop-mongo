package com.br.workshopmongo.workshopmongo.resource;

import com.br.workshopmongo.workshopmongo.domain.Post;
import com.br.workshopmongo.workshopmongo.domain.User;
import com.br.workshopmongo.workshopmongo.dto.AuthorDTO;
import com.br.workshopmongo.workshopmongo.dto.CommentDTO;
import com.br.workshopmongo.workshopmongo.repository.PostRepository;
import com.br.workshopmongo.workshopmongo.service.PostService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PostResourceTest {

    @MockBean
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {


    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findAllPosts() throws Exception{

    }

    @Test
    public void findById() throws Exception{

//        AuthorDTO author = new AuthorDTO();
//        author.setId("5c8182614c6f061582bee662");
//        author.setName("Maria Brown");
//
//        AuthorDTO author02 = new AuthorDTO();
//        author.setId("5c8182614c6f061582bee663");
//        author.setName("Alex Green");
//
//
//        CommentDTO comment = new CommentDTO();
//        comment.setId("1");
//        comment.setText("Boa viagem mano!");
//        comment.setDate("21/03/2018");
//        comment.setAuthorDTO(author02);

        Post post = Post.builder().id("5c8182614c6f061582bee665").title("Partiu viagem")
                .date("21/03/2018").body("Vou viajar para São Paulo. Abraços!").build();

        when(postService.findById(anyString())).thenReturn(post);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/posts/5c8182614c6f061582bee665")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void findByAllShouldReturnOk() throws Exception{

        this.mockMvc.perform(MockMvcRequestBuilders.get("/posts"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void findByTitle() {
    }

    @Test
    public void findByTitleOrBody() {
    }

    @Test
    public void savePost() {
    }
}