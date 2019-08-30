package org.java.web;

import org.java.service.Insurance_typeService;
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
 * @Date: 2019/8/22 14 35
 * @Description: 描述信息
 */

@Controller
public class Insurance_typeController {
    @Autowired
    private Insurance_typeService service;

    @RequestMapping(value = {"insurance_type","insurance_type/{page}"})
    public String insurance_type(Model model, @PathVariable(value = "page",required = false) Integer page){
      if (page==null){
          page=1;//如果没有指定当前页，默认为第一页
      }
      int rows = 3; //默认每一页显示五条数据

        int count = service.getCount();//得到数据总条数

        int maxPage=count % rows ==0 ? count/rows:count/rows+1;

        List<Map> list = service.findInsurance_typeMapper(page,rows);
        model.addAttribute("list",list);

        //把分页的四个值存放到model
        model.addAttribute("page",page);
        model.addAttribute("rows",rows);
        model.addAttribute("count",count);
        model.addAttribute("maxPage",maxPage);
        return "/insurance_type";
    }

    @RequestMapping("/save")
    public String save(@RequestParam Map map){
        //获得insurance_type_id，判断是否有值，如果有为修改，没有为添加
        Object insurance_type_id = map.get("insurance_type_id");

        if (insurance_type_id==null || insurance_type_id.equals("")){
            service.add(map);
        }else {
            service.update(map);
        }


        return "redirect:/insurance_type";
    }
    @GetMapping("modify/{insurance_type_id}")
    public String modify(@PathVariable("insurance_type_id") int insurance_type_id,Model model){

        Map m = service.findById(insurance_type_id);
        model.addAttribute("m",m);

        return "/insurance_typeAdd";

    }

    @GetMapping("del/{insurance_type_id}")
    public String del(@PathVariable("insurance_type_id") int insurance_type_id) {

        service.del(insurance_type_id);

        return "redirect:/insurance_type";
    }
}
