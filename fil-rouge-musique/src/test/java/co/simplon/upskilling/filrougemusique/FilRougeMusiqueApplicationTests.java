package co.simplon.upskilling.filrougemusique;

import co.simplon.upskilling.filrougemusique.model.Title;
import javafx.beans.binding.Bindings;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FilRougeMusiqueApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getTitles() {
        // When retrieving titles from /api/title
        List<Title> titles = this.restTemplate.getForObject("/api/title", List.class);

        // Then a non null list should be returned
     //   assertThat(titles).isNotNull();
    }

//    private Bindings assertThat(List<?> cities) {
//    }


    @Test
    void contextLoads() {
    }

}
