package org.seckill.web;

import org.seckill.SeckillstatusEnum.SeckillstateEnum;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.dto.SeckillResult;
import org.seckill.entity.Seckill;
import org.seckill.entity.Student;
import org.seckill.exception.RepeatkillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by dell on 2017/7/11.
 */
@Controller
@RequestMapping("/seckill") //url Restful风格 /模块/资源/占位符（{}）/细分
public class SeckillController {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillService seckillService;
    //列表页
    @RequestMapping(value = "/list",method= RequestMethod.GET)
    public String list(Model model){

        return "list";
    }
    @RequestMapping(value = "/android-api/user/login")
    @ResponseBody

    public String getStudent(@RequestParam("id")
                              long id,@RequestParam("pwd") String pwd){
        Student student=seckillService.getStudent(id,pwd);
        if (student!=null){
            return student.toString();
        }
        return "登陆失败";
    }

    //详情页
    @RequestMapping(value = "/{seckillId}/detail",method = RequestMethod.GET)
    public String detail(@PathVariable("seckillId") Long seckillId, Model model){
        if(seckillId==null){
            return "redirect:/seckill/list";
        }else{
           Seckill seckill=seckillService.getById(seckillId);
           if(seckill==null){
               return "foward:/seckill/list";
           }
           model.addAttribute("seckill",seckill);
        }
        return  "detail";
    }

    //ajax json
    @RequestMapping(value = "/{seckillId}/exposer",method = RequestMethod.POST
        ,produces = {"application/json;charset=UTF-8"})
    @ResponseBody   //将结果封装为json
    public SeckillResult<Exposer> exposer(Long seckillId){
        SeckillResult<Exposer> result;
        try {
            Exposer exposer=seckillService.exposedSeckillUrl(seckillId);
            result=new SeckillResult<Exposer>(true,exposer);
        } catch (Exception e) {
            logger.error(e.getMessage());
            result=new SeckillResult<Exposer>(false,e.getMessage());
        }
        return result;
    }
    @RequestMapping(value = "/{seckillId}/{md5}/execution",method = RequestMethod.POST
    ,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<SeckillExecution> exceution(@PathVariable("seckillId") Long seckillId,
                                                     @CookieValue(value = "killphone",required = false) Long userPhone
                                                ,@PathVariable("md5") String md5) {
        if (userPhone == null) {
            return new SeckillResult<SeckillExecution>(false, "未注册");
        }
        SeckillResult<SeckillExecution> result;
        try {
            SeckillExecution execution = seckillService.executeSeckill(seckillId, userPhone, md5);
            return new SeckillResult<SeckillExecution>(true, execution);
        } catch (SeckillCloseException e) {
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillstateEnum.END);
            return new SeckillResult<SeckillExecution>(false, execution);
        } catch (RepeatkillException e) {
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillstateEnum.REPEAT_KILL);
            return new SeckillResult<SeckillExecution>(false, execution);
        } catch (Exception e) {
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillstateEnum.INNER_ERROR);
            return new SeckillResult<SeckillExecution>(false, execution);
        }
    }
    @RequestMapping(value = "/time/now",method = RequestMethod.GET)
    public SeckillResult<Long> time(){
        Date now=new Date();
        return new SeckillResult(true,now.getTime());
    }
}
