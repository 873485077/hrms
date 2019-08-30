package org.java.web;

import org.java.service.Insurance_manageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @Author: 郑志高
 * @Date: 2019/8/26 23 13
 * @Description: 描述信息
 */

@Controller
public class insurance_manageController {
    @Autowired
    private Insurance_manageService insurance_manageService;
    @GetMapping(value = {"insurance_manage","insurance_manage/{pageB}"})
    public String insurance_manage(Model model, @PathVariable(value = "pageB",required = false)Integer pageB){
        if (pageB==null){
            pageB=1;//如果没有指定当前页，默认为第一页
        }
        int rowsB = 3;//默认每一页显示三条数据

        int countB = insurance_manageService.getCount();//得到数据总条数

        int maxPageB = countB % rowsB ==0 ? countB / rowsB : countB / rowsB +1;

        List<Map> list = insurance_manageService.findinsurance_manage(pageB,rowsB);
        model.addAttribute("list",list);
        model.addAttribute("pageB",pageB);
        model.addAttribute("rowsB",rowsB);
        model.addAttribute("countB",countB);
        model.addAttribute("maxPageB",maxPageB);
        return "/insurance_manage";
    }

    @RequestMapping("/saveB")
    public String save(@RequestParam Map map){
        //获得insurance_id，判断是否有值，如果有为修改，没有为添加
        Object insurance_id = map.get("insurance_id");

        if (insurance_id==null || insurance_id.equals("")){
            insurance_manageService.add(map);
        }else {
          insurance_manageService.update(map);
        }


        return "redirect:/insurance_manage";
    }

    @GetMapping("modifyB/{insurance_id}")
    public String modify(@PathVariable("insurance_id") int insurance_id,Model model){

        Map m = insurance_manageService.findById(insurance_id);
        model.addAttribute("m",m);

        return "/insurance_manageAdd";

    }

    @GetMapping("delB/{insurance_id}")
    public String del(@PathVariable("insurance_id") int insurance_id) {

        insurance_manageService.del(insurance_id);

        return "redirect:/insurance_manage";
    }
}
