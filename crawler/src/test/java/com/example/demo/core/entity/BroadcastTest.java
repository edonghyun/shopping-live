package com.example.demo.core.entity;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
class BroadcastTest {
    @Test
    public void saveBroadcastTest() {
        Broadcast broadcast = Broadcast.builder()
                .remoteId("testRemoteId")
                .provider("testProvider")
                .extraData("test")
                .build();

        assertEquals(
            "testProvider",
            broadcast.getProvider()
        );
        assertEquals(
                "testRemoteId",
                broadcast.getRemoteId()
        );
        assertEquals(
                "test",
                broadcast.getExtraData()
        );
    }
}