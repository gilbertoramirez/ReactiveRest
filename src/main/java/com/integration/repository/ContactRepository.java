package com.integration.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.integration.model.Contact;

@Repository
public interface ContactRepository extends ReactiveMongoRepository<Contact, Serializable>{

	public abstract Contact findByName(String name);
}
