package com.tabler.admin.repository;

import com.tabler.admin.entity.Desk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeskRepositoryService {

    @Autowired
    private DeskRepository deskRepository;

    public Desk save(Desk desk) {
        return deskRepository.save(desk);
    }
}
