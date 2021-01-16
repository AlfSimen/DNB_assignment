package com.alfsimen.dnb.reservations;

import com.alfsimen.dnb.reservations.dto.RoomDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class ReservationIntegrationTests {

    public static final ParameterizedTypeReference<List<RoomDto>> RESPONSE_TYPE_LIST_ROOM_DTO = new ParameterizedTypeReference<>() {
    };
    public static final String USERNAME = "admin";
    public static final String PASSWORD = "password";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("getAllRooms() should return all the rooms in the db")
    void getAllRooms() {
        String uriString = UriComponentsBuilder.fromUriString("/admin/room")
                .toUriString();
        ResponseEntity<List<RoomDto>> response = restTemplate
                .withBasicAuth(USERNAME, PASSWORD)
                .exchange(uriString, HttpMethod.GET, null, RESPONSE_TYPE_LIST_ROOM_DTO);

        List<RoomDto> allRooms = response.getBody();
        assertThat(allRooms)
                .isNotNull()
                .extracting(RoomDto::getName).containsExactly("Grand", "Piano", "Cozy", "Business");
    }

    @Test
    @DisplayName("getRoomByFloorId() should return only the rooms belonging to the given floor id")
    void getRoomByFloorId() {
        String uriString = UriComponentsBuilder.fromUriString("/admin/floor/{id}")
                .buildAndExpand(2L)
                .toUriString();
        ResponseEntity<List<RoomDto>> response = restTemplate
                .withBasicAuth(USERNAME, PASSWORD)
                .exchange(uriString, HttpMethod.GET, null, RESPONSE_TYPE_LIST_ROOM_DTO);

        List<RoomDto> roomByFloorId = response.getBody();
        assertThat(roomByFloorId)
                .isNotNull()
                .extracting(RoomDto::getName).containsExactly("Cozy", "Business");
    }

    @Test
    @DisplayName("Given a wrong password it should give 401 UNAUTHORIZED")
    void wrongAuthShouldNotGiveAccess() {
        String uriString = UriComponentsBuilder.fromUriString("/admin/floor/{id}")
                .buildAndExpand(1L)
                .toUriString();
        ResponseEntity<List<RoomDto>> response = restTemplate
                .withBasicAuth(USERNAME, "wrongPassword")
                .exchange(uriString, HttpMethod.GET, null, RESPONSE_TYPE_LIST_ROOM_DTO);

        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }
}
