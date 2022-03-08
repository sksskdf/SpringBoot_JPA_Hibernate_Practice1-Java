package com.har.springbootjpa3.repository;

import com.har.springbootjpa3.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store,Long> {
    Store findByName(String name);
}
