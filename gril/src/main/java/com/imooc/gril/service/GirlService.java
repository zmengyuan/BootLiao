package com.imooc.gril.service;

import com.imooc.gril.domain.Girl;
import com.imooc.gril.enums.ResultEnum;
import com.imooc.gril.exception.GirlException;
import com.imooc.gril.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(17);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("C");
        girlB.setAge(19);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age <10) {
            //返回你还在上小学把 code100
            throw  new GirlException(ResultEnum.PRIMARY_SCHOOL.getCode(),ResultEnum.PRIMARY_SCHOOL.getMsg());
        }else if (age > 10 && age <16) {
            //返回你可能在上初中 code 101
            throw new GirlException(101,"你还在上初中把");
        }
        //>16岁，加钱---可能还有一系列的操作
        //第一种想到的可能是每个else返回不同的数值，然后去controller层处理
        //现在应该尝试用异常来处理
    }

    public Girl findOne(Integer id) {
        return girlRepository.findOne(id);
    }
}
