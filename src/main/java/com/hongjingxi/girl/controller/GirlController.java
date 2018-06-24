package com.hongjingxi.girl.controller;


import com.hongjingxi.girl.entity.Girl;
import com.hongjingxi.girl.service.GirlRepository;
import com.hongjingxi.girl.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService service;

    @GetMapping("/list")
    public List<Girl> getGirlList() {
        return girlRepository.findAll();
    }

    @PostMapping(value = "/save")
    public Girl seveGirl(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setName(name);
        girl.setAge(age);

        return girlRepository.save(girl);

    }

    @GetMapping("/girl/{id}")
    public Optional<Girl> getGirl(@PathVariable Integer id) {
        return girlRepository.findById(id);

    }

    @PutMapping("/update")
    public Girl updateGirl(@RequestParam("name") String name, @RequestParam("age") Integer age, @RequestParam("id") Integer id){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setName(name);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    @PostMapping("/delete")
    public void deleteGirl(@RequestParam("id") Integer id){
      girlRepository.deleteById(id);
    }

    @GetMapping("/girl/age")
    public List<Girl> getGirlByAge(@RequestParam Integer age){
        return girlRepository.findByAge(age);
    }

    @RequestMapping("/girl/two")
    @ResponseBody
    public void addGirlTwo(){
        service.addGirlTwo();
    }

}
