package com.projectcollege;

import com.projectcollege.сontroller.MessageController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.EntityManager;

import static org.hamcrest.CoreMatchers.containsString;
 import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoginTest {

    @Autowired
    private MessageController messageController;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void test()throws Exception{
        assertThat(messageController).isNotNull();
    }
    @Autowired
    private EntityManager em;

    @Test
    public void testMock()throws Exception{
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(" ")))
                .andExpect(content().string(containsString("Please, login")));

    }

    @Test
    public void loginTest()throws Exception{
        this.mockMvc.perform(get("/main"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    /*
    @Test
    public void correctLoginTest() throws Exception{
        this.mockMvc.perform(formLogin().user("jo").password("123"))
        .andDo(print())
        .andExpect(status().is3xxRedirection())
        .andExpect(redirectedUrl("/"));
    }
    */

    @Test
    public void badCreditionals()throws Exception{
        this.mockMvc.perform(post("/login").param("user","Jacky"))
                .andDo(print())
                .andExpect(status().isForbidden());
    }


}
