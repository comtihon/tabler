package com.tabler.admin.full;

import com.tabler.admin.controller.dto.ResultDto;
import com.tabler.admin.controller.dto.TableDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreateTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void createTable() {
        TableDto table = new TableDto("dummy table");
        ResponseEntity<ResultDto> result = this.restTemplate.postForEntity(
                "http://localhost:" + port + "/api/v1/table", table, ResultDto.class);
        Assert.assertEquals(HttpStatus.CREATED, result.getStatusCode());
        Assert.assertEquals(Long.valueOf(1), result.getBody().getId());
    }

    @Test
    public void createWithWrongData() {
        TableDto table = new TableDto(null);
        ResponseEntity<Map> result = this.restTemplate.postForEntity(
                "http://localhost:" + port + "/api/v1/table", table, Map.class);
        Assert.assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
        List errors = (List) result.getBody().get("errors");
        Assert.assertEquals(1, errors.size());
        Map error = (Map) errors.get(0);
        Assert.assertEquals("must not be null", error.get("defaultMessage"));
        Assert.assertEquals("name", error.get("field"));
    }
}
