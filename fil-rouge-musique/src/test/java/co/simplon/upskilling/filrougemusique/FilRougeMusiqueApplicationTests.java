package co.simplon.upskilling.filrougemusique;


import co.simplon.upskilling.filrougemusique.model.TestRestResponsePage;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FilRougeMusiqueApplicationTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void getPublications() {
        TestRestResponsePage publications = this.testRestTemplate.getForObject("/api/publications", TestRestResponsePage.class);

//        Map params = new HashMap();
//        ResponseEntity<Page> publications = this.testRestTemplate.exchange("/api/publications", HttpMethod.GET, null, Page.class, params);

        // a non null page should be returned
        assertThat(publications).isNotNull();
    }
}
