package com.hongjingxi.girl.service;

import com.hongjingxi.girl.entity.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void addGirlTwo(){
        Girl girlA = new Girl();
        girlA.setName("A");
        girlA.setAge(11);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setName("B");
       // girlB.setAge(111111);
        girlRepository.save(girlB);
    }
}
