package com.learning.supermarket.freshmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.supermarket.freshmarket.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
