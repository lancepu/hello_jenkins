package com.trilogyed.rsvp.dao;

import com.trilogyed.rsvp.model.Rsvp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RsvpDaoTest {

    @Autowired
    RsvpDao dao;

    @Before
    public void setUp() throws Exception {

        List<Rsvp> rsvps = dao.getAllRsvps();

        rsvps.stream()
                .forEach(rsvp -> dao.deleteRsvp(rsvp.getId()));
    }

    @Test
    public void addGetDeleteRsvp() {
        Rsvp rsvp = new Rsvp("John Doe", 2);
        rsvp = dao.addRsvp(rsvp);
        Rsvp fromDao = dao.getRsvp(rsvp.getId());
        assertEquals(fromDao, rsvp);
        dao.deleteRsvp(rsvp.getId());
        fromDao = dao.getRsvp(rsvp.getId());
        assertNull(fromDao);
    }

    @Test
    public void getAllRsvps() {
        Rsvp rsvp = new Rsvp("Sally Smith", 4);
        dao.addRsvp(rsvp);

        rsvp = new Rsvp("George Smith", 3);
        dao.addRsvp(rsvp);

        List<Rsvp> rsvps = dao.getAllRsvps();

        assertEquals(2, rsvps.size());
    }

    @Test
    public void updateRsvp() {
        Rsvp rsvp = new Rsvp("Joe Jones", 5);
        rsvp = dao.addRsvp(rsvp);
        rsvp.setGuestName("NEW NAME");
        dao.updateRsvp(rsvp);
        Rsvp fromDao = dao.getRsvp(rsvp.getId());
        assertEquals(rsvp, fromDao);
    }

}