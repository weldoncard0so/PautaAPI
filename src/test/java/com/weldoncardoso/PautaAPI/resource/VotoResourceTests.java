package com.weldoncardoso.PautaAPI.resource;

import com.weldoncardoso.PautaAPI.domain.voto.Voto;
import com.weldoncardoso.PautaAPI.service.VotoService;
import com.weldoncardoso.PautaAPI.web.rest.VotoResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import static com.weldoncardoso.PautaAPI.builders.voto.VotoBuilder.umVoto;
import static com.weldoncardoso.PautaAPI.builders.voto.VotoDTOBuilder.umVotoDTO;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.ArgumentMatchers.any;

@WebMvcTest(controllers = VotoResource.class)
public class VotoResourceTests {

    @Autowired
    private VotoResource votoResource;

    @MockBean
    private VotoService votoService;

    @BeforeEach
    public void setUp() {
        standaloneSetup(votoResource);
    }

    @Test
    @DisplayName("deve cadastrar voto com sucesso")
    public void deveCadastrarVotoComSucesso() {
        Mockito.when(this.votoService.cadastrar(any(Voto.class))).thenReturn(umVoto());

        given().contentType(JSON)
                .header("Api-Version", 1)
                .body(umVotoDTO())
                .when()
                .post("/votos", umVotoDTO())
                .then().log().all()
                .statusCode(HttpStatus.CREATED.value());
    }
}
