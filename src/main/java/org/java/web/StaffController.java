package org.java.web;

import org.java.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author 安平
 * @date 2019-08-18 10:04
 */
@Controller
public class StaffController {

    @Autowired
    private StaffService service;

    @RequestMapping("/forward/{target}")
    public String forward(@PathVariable("target") String target) {
        return "/" + target;
    }

    @RequestMapping(value = {"/staff_find", "staff_find/{page}"})
    public String init(Model model, @PathVariable(value = "page", required = false) Integer page) {
        //分页需要知道四个值: 当前页，每一页显示的条数据，总条数，最多可分成多少页
        /**
         * page=当前页
         * rows=每一页显示的条数
         * count=总条
         * maxPage=总页数据
         */
        if (page == null) {
            //如果没有指定当前页,则默认为第1页;
            page = 1;
        }
        //每页显示3条数据
        int rows = 3;
        //得到数据的总条数
        int count = service.staffGetCount();
        //最大页数
        int maxPage = count % rows == 0 ? count / rows : count / rows + 1;

        List<Map> list = service.staffFind(page, rows);
        model.addAttribute("list", list);
        //把分页需要的四个参数存放到model中
        model.addAttribute("page", page);
        model.addAttribute("rows", rows);
        model.addAttribute("count", count);
        model.addAttribute("maxPage", maxPage);
        return "/staff/main";
    }

    @RequestMapping("/staff_detail/{staff_number}")
    public String staffDetail(Model model, @PathVariable("staff_number") int staff_number){
        List<Map> list = service.staffDetail(staff_number);
        model.addAttribute("list",list);
        return "/staff/staff_detail";
    }

    @RequestMapping("/staff_add")
    public String staffAdd(@RequestParam Map map){
        service.staffAdd(map);
        return "redirect:/staff_find";
    }

    @RequestMapping("/update_staff/{staff_number}")
    public String updateStaff(Model model, @PathVariable("staff_number") int staff_number){
        Map m = service.updateStaff(staff_number);
        model.addAttribute("m",m);
        return "/staff/staff_update";
    }

    @RequestMapping("/staff_update")
    public String staffUpdate(@RequestParam Map map){
        service.staffUpdate(map);
        return "redirect:/staff_find";
    }


    @RequestMapping("/staff_delete/{staff_number}")
    public String staffDelete(@PathVariable("staff_number") int staff_number){
        service.staffDelete(staff_number);
        return "redirect:/staff_find";
    }

    @RequestMapping(value = {"/contract_find","contract_find/{page}"})
    public String contractFind(Model model, @PathVariable(value = "page", required = false) Integer page){
        if (page == null) {
            //如果没有指定当前页,则默认为第1页;
            page = 1;
        }
        //每页显示5条数据
        int rows = 5;
        //得到数据的总条数
        int count = service.contractGetCount();
        //最大页数
        int maxPage = count % rows == 0 ? count / rows : count / rows + 1;

        List<Map> list = service.contractFind(page, rows);
        model.addAttribute("list",list);
        //把分页需要的四个参数存放到model中
        model.addAttribute("page", page);
        model.addAttribute("rows", rows);
        model.addAttribute("count", count);
        model.addAttribute("maxPage", maxPage);


        return "/staff/contract_find";
    }

    @RequestMapping("/contract_detail/{staff_number}")
    public String contractDetail(Model model, @PathVariable("staff_number") int staff_number){
        List<Map> list = service.contractDetail(staff_number);
        model.addAttribute("list",list);
        return "/staff/contract_detail";
    }

    @RequestMapping(value = {"/demission_find","demission_find/{page}"})
    public String demissionFind(Model model, @PathVariable(value = "page", required = false) Integer page) {
        if (page == null) {
            //如果没有指定当前页,则默认为第1页;
            page = 1;
        }
        //每页显示5条数据
        int rows = 5;
        //得到数据的总条数
        int count = service.demissionGetCount();
        //最大页数
        int maxPage = count % rows == 0 ? count / rows : count / rows + 1;

        List<Map> list = service.demissionFind(page, rows);
        model.addAttribute("list", list);
        //把分页需要的四个参数存放到model中
        model.addAttribute("page", page);
        model.addAttribute("rows", rows);
        model.addAttribute("count", count);
        model.addAttribute("maxPage", maxPage);

        return "/staff/demission_find";
    }


    @RequestMapping("/demission_detail/{staff_number}")
    public String demissionDetail(Model model, @PathVariable("staff_number") int staff_number){
        List<Map> list = service.demissionDetail(staff_number);
        model.addAttribute("list",list);
        return "/staff/demission_detail";
    }

}