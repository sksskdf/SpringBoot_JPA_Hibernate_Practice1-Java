package com.har.springbootjpa3.repository.support;

import com.har.springbootjpa3.entity.Staff;
import com.har.springbootjpa3.entity.Store;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.har.springbootjpa3.entity.QStore.store;
import static com.har.springbootjpa3.entity.QStaff.staff;

@Repository
public class StoreRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory jpaQueryFactory;

    public StoreRepositorySupport(JPAQueryFactory jpaQueryFactory){
        super(Store.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public Store findOneByName(String name) {
        return jpaQueryFactory
                .selectFrom(store)
                .where(store.name.eq(name))
                .fetchOne();
    }

    public List<Staff> findStaffsByName(String name) {
        return jpaQueryFactory
                .select(Projections.fields(Staff.class,
                        staff.id
                        , staff.age
                        , staff.name
                ))
                .from(store)
                .join(store.staff, staff)		// 1)
                .where(store.name.eq(name))
                .fetch();
    }
    /*public List<Staff> findStaffsByName(String name) {
        return jpaQueryFactory
                .select(Projections.fields(Staff.class,
                        staff.id
                        , staff.age
                        , staff.name
                ))
                .from(store)
                .join(staff)
                .on(store.id.eq(staff.storeId))
                .where(store.name.eq(name))
                .fetch();
    }*/
}
