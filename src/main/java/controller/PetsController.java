package controller;

import dataModel.Pet;
import dataModel.Status;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import responseDataModal.PetPResponse;

import java.io.PrintStream;
import java.util.List;

import static io.restassured.RestAssured.given;
import static utils.Properties.baseUri;

public class PetsController {
    public static String PET_ENDPOINT = baseUri + "/pet";
    private RequestSpecification requestSpecification;
    PrintStream captor;

    public PetsController() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(baseUri);
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.log(LogDetail.ALL);
        requestSpecification = requestSpecBuilder.build();
    }

    public Response addNewPet(Pet pet, PrintStream captor) {
        return given(requestSpecification).filter(new RequestLoggingFilter(captor))
                .body(pet)
                .post(PET_ENDPOINT);
    }

    public List<Pet> getPetsByStatus(Status status, PrintStream captor) {
        return given(requestSpecification)
                .filter(new RequestLoggingFilter(captor))
                .queryParam("status", status.toString())
                .get(PET_ENDPOINT + "/findByStatus")
                .then().log().all()
                .extract().body()
                .jsonPath().getList("", Pet.class);
    }

    public Response updatePet(Pet pet,PrintStream captor) {
        return given(requestSpecification).filter(new RequestLoggingFilter(captor))
                .body(pet)
                .put(PET_ENDPOINT);
    }

    public PetPResponse findPet(Pet pet) {
        return given(requestSpecification)
                .pathParam("petId", pet.getId())
                .get(PET_ENDPOINT + "/{petId}").as(PetPResponse.class);
    }


}
