package com.mongoDB.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories

public class MongoDbCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbCrudApplication.class, args);
	}

}
