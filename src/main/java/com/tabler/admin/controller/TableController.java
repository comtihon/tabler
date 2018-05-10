package com.tabler.admin.controller;

import com.tabler.admin.controller.dto.ResultDto;
import com.tabler.admin.controller.dto.TableDto;
import com.tabler.admin.full.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

@RestController
public class TableController {

    @Autowired
    private TableService tableService;

    @RequestMapping(path = "/api/v1/table", method = RequestMethod.POST)
    public CompletableFuture<ResponseEntity<?>> createTable(@Valid @RequestBody TableDto table) {
        CompletableFuture<Long> respond = tableService.createTable(table);
        return respond.thenApply(id -> new ResponseEntity<>(new ResultDto(id), HttpStatus.CREATED));
    }
}
