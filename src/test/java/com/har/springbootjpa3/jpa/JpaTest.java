package com.har.springbootjpa3.jpa;

import com.har.springbootjpa3.entity.Staff;
import com.har.springbootjpa3.entity.Store;
import com.har.springbootjpa3.repository.StaffRepository;
import com.har.springbootjpa3.repository.StoreRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

@ActiveProfiles("local")
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JpaTest {

    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private StaffRepository staffRepository;

    @Test
    void entity저장후조회(){
        //g
        Store store = Store.builder()
                .id(1L)
                .name("스토어1")
                .address("주소1")
                .build();
        storeRepository.save(store);
        //w
        Store resultStore = storeRepository.findByName("스토어1");
        //t
        Assertions.assertEquals(resultStore.getName(),"스토어1");
    }
    @Test
    @DisplayName("초기 테스트 시 entity저장후조회 테스트 먼저 진행 후 테스트")
    void entity수정(){
        //g
        Store store = Store.builder()
                .id(1L)
                .name("스토어2")
                .address("주소2")
                .build();
        //w
        Store updateStore = storeRepository.save(store);
        //t
        Assertions.assertEquals(updateStore.getName(),"스토어2");
    }
    @Test
    @DisplayName("Store, Staff Entity 저장")
    void entity저장(){
        //g
        Staff staff = Staff.builder()
                .id(1L)
                .name("스탭1")
                .age(25)
                .build();
        Store store = Store.builder()
                .id(1L)
                .name("스토어1")
                .address("스토어주소")
                .staff(Arrays.asList(staff))
                .build();
        //w
        Store saveStore = storeRepository.save(store); //연관관계인 Staff도 같이 저장됨 , store안에 staff객체가 들어있어서
        //t
        Assertions.assertEquals(saveStore.getName(),"스토어1");//저장 확인


        Staff staff2 = staffRepository.findByName("스탭1");
        Assertions.assertEquals(staff2.getName(),"스탭1");
    }
}
