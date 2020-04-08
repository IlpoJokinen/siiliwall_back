package com.siili.wall;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testShouldReturnBoard1() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/boards",
                String.class)).contains("Board1");
    }

    @Test
    public void testShouldReturnColumn1() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/columns",
                String.class)).contains("Column1");
    }

    @Test
    public void testShouldReturnCard1() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/cards",
                String.class)).contains("Card1");
    }
}
