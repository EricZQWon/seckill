package org.seckill.web;

import org.seckill.entity.Seckill;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by dell on 2017/11/22.
 */
@Controller
public class testController {


    @RequestMapping(value = "/Formatter",method = RequestMethod.GET)
    public String after(Seckill seckill, Model model){

//        testFormatter.setDate();
        model.addAttribute("formatter",seckill);
        return "success";
    }



}
