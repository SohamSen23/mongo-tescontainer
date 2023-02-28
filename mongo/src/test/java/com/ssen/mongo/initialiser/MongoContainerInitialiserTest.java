package com.ssen.mongo.initialiser;

import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.MongoDBContainer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoContainerInitialiserTest {

    @ClassRule
    public static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2").withEnv("MONGO_INITDB_DATABASE","local")
            .withEnv("MONGO_INIT_ROOT_USERNAME","admin").withEnv("MONGO_INIT_ROOT_PASSWORD","admin");

    static {
        mongoDBContainer.start();
    }

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry registry) {
        registry.add("mongodatasource.port", () -> mongoDBContainer.getFirstMappedPort());
    }
}
