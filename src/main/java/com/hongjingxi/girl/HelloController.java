package com.hongjingxi.girl;

import com.hongjingxi.girl.entity.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
   /* @Value("${cupSize}")
    private String cupSize;
    @Value("${age}")
    private int age;
    @Value("${content}")
    private String content;*/

   /* @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String say(){
        //return cupSize +"," + age;
        return content;
    }*/

   @Autowired
    private GirlProperties girlProperties;

   @RequestMapping(value = "/girl", method = RequestMethod.GET)
   @ResponseBody
    public String getGirl(){
       return girlProperties.toString();
   }

   @GetMapping(value = "/say")
    public String say(@RequestParam(value = "id", required = false, defaultValue = "0") Integer myId){
       return "id :" + myId;
   }


}
