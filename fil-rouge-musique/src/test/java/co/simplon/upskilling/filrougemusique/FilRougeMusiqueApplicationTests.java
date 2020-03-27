package co.simplon.upskilling.filrougemusique;

import co.simplon.upskilling.filrougemusique.model.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import co.simplon.upskilling.filrougemusique.service.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FilRougeMusiqueApplicationTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private AppUserServiceImpl appUserService;
    @Autowired
    private ArtistServiceImpl artistService;

    @Test
    void getPublications() {
        TestRestResponsePage publications = this.testRestTemplate.getForObject("/api/publications", TestRestResponsePage.class);

//        Map params = new HashMap();
//        ResponseEntity<Page> publications = this.testRestTemplate.exchange("/api/publications", HttpMethod.GET, null, Page.class, params);

        // a non null page should be returned
        assertThat(publications).isNotNull();
    }

    @Test
    void getPublicationsWithPageable() {
        TestRestResponsePage publications = this.testRestTemplate.getForObject("/api/publications?pageNumber=0&pageSize=10", TestRestResponsePage.class);

        // a non null page should be returned
        assertThat(publications).isNotNull();
    }

    @Test
    void getPublicationsbyArtistWithPageable() {
        TestRestResponsePage publications = this.testRestTemplate.getForObject("/api/publications/byartist/1?pageNumber=0&pageSize=10", TestRestResponsePage.class);

        // a non null page should be returned
        assertThat(publications).isNotNull();
    }

    @Test
    void addPublication() {
        Publication publicationTest = new Publication();
        publicationTest.setAppUser(this.appUserService.getOneAppUserByNickname("Franck").get());
        publicationTest.setArtist(this.artistService.getArtistByName("Pixies"));
        publicationTest.setArtwork(null);
        publicationTest.setDate(null);
        publicationTest.setSnippet(null);
        publicationTest.setTitle(null);
        HttpEntity<Publication> publicationTestHttpEntity = new HttpEntity<Publication>(publicationTest);
        ResponseEntity<Publication> responseEntity = this.testRestTemplate.postForEntity("/api/publications", publicationTestHttpEntity, Publication.class);
        Publication createdPublicationTest = responseEntity.getBody();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(createdPublicationTest.getArtist().getName()).isEqualTo("Pixies");
    }

    @Test
    void deleteOnePublication() {
        this.testRestTemplate.delete("/api/publications/1", Publication.class);
    }
}
