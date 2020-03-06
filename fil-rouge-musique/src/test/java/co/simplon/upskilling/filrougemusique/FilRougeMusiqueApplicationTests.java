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
import org.springframework.jdbc.support.incrementer.AbstractDataFieldMaxValueIncrementer;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

//    @Test
//    void addPublication() {
//        AppUser appUser=new AppUser("Andrea","andrea.jouanin.devweb@gmail.com");
//        Artist artist=new Artist("Fat Boy Slim");
//        Publication publicationTest = new Publication(appUser,artist,null,null,null);
//        HttpEntity<Publication> publicationTestHttpEntity = new HttpEntity<Publication>(publicationTest);
//        ResponseEntity<Publication> responseEntity = this.testRestTemplate.postForEntity("/api/publications", publicationTestHttpEntity, Publication.class);
//        Publication createdPublicationTest = responseEntity.getBody();
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(createdPublicationTest.getArtist()).isEqualTo(artist);
//    }
//    //{"id":99,"appUser":{"id":1,"nickName":"Andrea","email":"andrea.jouanin.devweb@gmail.com","authorities":[{"id":1,"authority":"ADMIN"}]},"artist":{"id":10,"name":"Fred Bueno and his Fuckin Fuckers Band from Bdx"},"date":"2020-03-04T23:00:00.000+0000","artwork":null,"title":null,"snippet":null}

    @Test
    void deleteOnePublication() {
        this.testRestTemplate.delete("/api/publications/1", Publication.class);
    }
}
