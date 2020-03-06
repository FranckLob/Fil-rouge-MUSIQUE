package co.simplon.upskilling.filrougemusique.controller;

import co.simplon.upskilling.filrougemusique.model.Publication;
import co.simplon.upskilling.filrougemusique.service.PublicationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class PublicationControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PublicationService publicationService;

//    @Test
//    public void getPublications() {
//        when(this.publicationService.getAllPublications(1,10)).thenReturn(new PageRequest<>());
//    }
}
