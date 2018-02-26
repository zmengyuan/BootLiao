package com.imooc.gril;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> grilList() {
      return girlRepository.findAll();
    }

    /**
     * 增加一个女生
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping (value = "/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                          @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     * 查询一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);

    }
    /**
     * 更新一个女生
     * @param id
     * @param cupSize
     * @param age
     * @return
     * 使用postman put方式，不能使用form-data，要使用x-www-form-urlencoded
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }
    /**
     * 删除一个女生
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    /**
     * 根据年龄查询
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable ("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }
}
