package com.tabler.admin.full;

import com.tabler.admin.controller.dto.TableDto;
import com.tabler.admin.entity.Desk;
import com.tabler.admin.repository.DeskRepositoryService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class TableService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private DeskRepositoryService deskRepositoryService;


    @Async
    public CompletableFuture<Long> createTable(TableDto transaction) {
        Desk saved = deskRepositoryService.save(modelMapper.map(transaction, Desk.class));
        return CompletableFuture.completedFuture(saved.getDeskId());
    }
}
