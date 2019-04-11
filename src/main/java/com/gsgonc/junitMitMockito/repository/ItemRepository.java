package com.gsgonc.junitMitMockito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gsgonc.junitMitMockito.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {

}
