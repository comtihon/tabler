package com.tabler.admin.repository;

import com.tabler.admin.entity.Desk;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DeskRepositoryTest {

    @Autowired
    private DeskRepository deskRepository;

    @Test
    public void testCRUD() {
        Desk saved = deskRepository.save(new Desk(null, "table1"));
        Assert.assertNotNull(saved.getDeskId());
        Assert.assertEquals(Long.valueOf(1), saved.getDeskId());
        Desk saved2 = deskRepository.save(new Desk(null, "table2"));
        Assert.assertEquals(Long.valueOf(2), saved2.getDeskId());

        List<Desk> desks = deskRepository.findAll();
        Assert.assertEquals(2, desks.size());
        Assert.assertEquals(saved, desks.get(0));
        Assert.assertEquals(saved2, desks.get(1));

        Optional<Desk> find = deskRepository.findById(1L);
        Assert.assertEquals(saved, find.orElse(null));
        Assert.assertEquals("table1", saved.getName());

        saved.setName("another name");
        deskRepository.save(saved);
        find = deskRepository.findById(1L);
        Assert.assertEquals("another name", find.map(Desk::getName).orElse(null));

        deskRepository.deleteById(1L);
        find = deskRepository.findById(1L);
        Assert.assertFalse(find.isPresent());
    }
}
