package com.har.springbootjpa3.jpa;

import com.har.springbootjpa3.entity.Staff;
import com.har.springbootjpa3.entity.Store;
import com.har.springbootjpa3.repository.StaffRepository;
import com.har.springbootjpa3.repository.StoreRepository;
import com.har.springbootjpa3.repository.support.StoreRepositorySupport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("local")
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class StoreRepositorySupportTest {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private StoreRepositorySupport storeRepositorySupport;

    @Test
    void findOneByNameTest() {
        //g
        Store store = Store.builder()
                .id(3L)
                .address("주소3")
                .name("스토어3")
                .build();
        storeRepository.save(store);
        //w
        Store rsByStore = storeRepositorySupport.findOneByName("스토어3");
        //t
        Assertions.assertEquals("스토어3", rsByStore.getName());
    }

    @Test
    void findStaffsByNameTest() {
        //given
        final Long staffId1 = 1L;
        final String staffName1 = "staffName1";
        final Integer age1 = 31;


        final Long staffId2 = 2L;
        final String staffName2 = "staffName2";
        final Integer age2 = 41;

        final Long id = 1L;
        final String address = "주소4";
        final String name = "스토어4";

        Staff staff1 = Staff.builder()
                .id(staffId1)
                .name(staffName1)
                .age(age1)
                .build();

        Staff staff2 = Staff.builder()
                .id(staffId2)
                .name(staffName2)
                .age(age2)
                .build();


        Store store = Store.builder()
                .id(id)
                .address(address)
                .name(name)
                .staff(Arrays.asList(staff1,staff2))
                .build();

        storeRepository.save(store);

        //when
        List<Staff> staffs = storeRepositorySupport.findStaffsByName(name);

        //then
        assertThat(staffs.size()).isGreaterThan(0);
        assertThat(staffs.get(0).getName()).isEqualTo(staffName1);
        assertThat(staffs.get(1).getName()).isEqualTo(staffName2);
    }
}
