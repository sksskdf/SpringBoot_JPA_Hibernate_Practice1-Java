package com.har.springbootjpa3.repository.support;

import com.har.springbootjpa3.entity.Staff;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class StaffRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory jpaQueryFactory;

    public StaffRepositorySupport(JPAQueryFactory jpaQueryFactory){
        super(Staff.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }
}
