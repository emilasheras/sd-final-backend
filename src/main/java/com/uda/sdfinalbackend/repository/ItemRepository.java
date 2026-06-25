package com.uda.sdfinalbackend.repository;

import com.uda.sdfinalbackend.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * What this does: Spring Data JPA generates a full CRUD implementation at runtime from this interface.
 * You get findAll(), save(), count(), deleteById() etc. with no implementation code.
 */
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}