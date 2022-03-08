package com.har.springbootjpa3.repository;

import com.har.springbootjpa3.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff,Long> {
    Staff findByName(String name);
}
