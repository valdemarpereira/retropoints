package com.valdemar.retropoints.endpoint;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.valdemar.retropoints.domain.Retropoint;
import com.valdemar.retropoints.domain.TeamMember;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RetropointControllerTest {
//https://github.com/spring-guides/gs-accessing-mongodb-data-rest/blob/master/complete/src/test/java/hello/ApplicationTests.java

   // private MediaType contentType = new MediaType("application", "hal+json");;

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;


    private Retropoint testData;


//    @Autowired
//    void setConverters(HttpMessageConverter<?>[] converters) {
//
//        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
//                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
//                .findAny()
//                .orElse(null);
//
//        assertNotNull("the JSON message converter must not be null",
//                this.mappingJackson2HttpMessageConverter);
//    }


    @Before
    public void setup(){

        testData = new Retropoint(1, "Bla", false, LocalDate.now().toString(), TeamMember.of("Valdemar Pereira", "valdemar", "valdemar@gmail.com"));
    }

    @Test
    public void testPing() throws Exception {
        this.mockMvc
                .perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("I'm Alive"));
    }

    @Test
    public void shouldCreateRetropoint() throws Exception {
        this.mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(testData)))
                .andExpect(jsonPath("$.retropoint.retropoint").value("Bla"))

        ;
    }

    @Test
    public void envEndpointNotHidden() throws Exception {

        MvcResult result = this.mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(testData)))
                .andReturn();


        String content = result.getResponse().getContentAsString();

        String uri = JsonPath.parse(content).read("$._links.self").toString();


        Traverson traverson = new Traverson(new URI(uri), MediaTypes.HAL_JSON);
//        String greeting = traverson.follow("self").toObject("$.content");
//        assertThat(greeting).isEqualTo("Hello, World!");

        String ds = "dsd";
    }

    @Test
    public void shouldRetrieveEntity() throws Exception {

        MvcResult mvcResult = mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(testData)))
                .andExpect(
                status().isCreated()).andReturn();

        String location = mvcResult.getResponse().getHeader("Location");
        mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
                jsonPath("$.firstName").value("Frodo")).andExpect(
                jsonPath("$.lastName").value("Baggins"));
    }


    private String toJson(Object obj) throws JsonProcessingException {
        return mapper.writeValueAsString(obj);
    }

/*
    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
*/
    /*
     @Test
    public void noParamGreetingShouldReturnDefaultMessage() throws Exception {

        this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello, World!"));
    }

    @Test
    public void paramGreetingShouldReturnTailoredMessage() throws Exception {

        this.mockMvc.perform(get("/greeting").param("name", "Spring Community"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.content").value("Hello, Spring Community!"));
    }
     */

}