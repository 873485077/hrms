package org.java.web;

import org.java.entity.StaffDemand;
import org.java.service.DepartmentService;
import org.java.service.EmployProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：方裕森
 * @date ：2019-08-16 15:42
 * @description：${DESCRIPTION}
 * @modified By：
 * @version:
 */
@Controller
public class StaffDemandController {

    @Autowired
    private EmployProcessService service;
    @Autowired
    private DepartmentService departmentService; //流程定义服务

    /**
     * 跳转 增/删/改方法
     * @param mode
     * @param model
     * @return
     */
    @RequestMapping("/addStaffDemand/{mode}")
    public String addStaffDemand(@PathVariable("mode") String mode, Model model){
        model.addAttribute("mode", mode);
        System.out.println("模式是:"+mode);
        return "/recruitment/addStaffDemand";
    }

    /**
     * 添加员工需求征集审核表
     */
    @RequestMapping("/addStaffDemand/commit/{mode}")
    public String addStaffDemand(@RequestParam Map map,HttpSession session,@PathVariable("mode") String mode){
        System.out.println("addStaffDemand-"+mode);
        //通过service层实现 1/启动流程实例 2/向数据表添加一条业务数据
        //获取用户名,create_user是数据表对应的字段
        String createUser = (String) session.getAttribute("username");
        map.put("creatUser", createUser);
        //拼接薪资范围
        String salary_range = map.get("salary_min") + "-" + map.get("salary_max");
        map.put("salaryRange", salary_range);

        switch (mode){
            case "add":
                int staffDemandCount = service.createStaffDemand(map);//调用service层
                if (staffDemandCount>0){
                    System.out.println("添加员工需求征集审核表 - 成功");
                }else{
                    System.out.println("添加员工需求征集审核表 - 成功");
                }
                break;
            case "detail":
                System.out.println("准备修改信息");
                break;
            case "del":
                System.out.println("准备删除信息");
        }



        return "redirect:/forward/recruitment/addStaffDemand";

    }


    /**
     * 这是职员征集表的数据表格，调用的请求，会自动传入两个参数进来（page和limit），需要返回map
     *
     * 要绑定到数据表格，必须要有以下四个变量
     * code:状态 ，     0：正常   1：异常
     * msg:消息-------------出错以后的消息
     * count:数据表中的总条数-----------用于分页
     * data:要绑定到table上的数据-------二维结构(集合包含集合即可) list<info>       list<map>
     *     page:当前页
     *     limit:每一页要显示的条数
     */
    @GetMapping("/getStaffDemandApproving")  //未提交的申请表
    @ResponseBody
    public Map<String,Object> getStaffDemandApproving(Integer page,Integer limit){
        System.out.println("数据表格正在请求数据。。。。。。");
        int count =departmentService.getStaffDemandCount();
        List<StaffDemand> list = departmentService.getStaffDemand(page, limit);

        Map<String, Object> map = new HashMap<String,Object>(){
            {
                put("code",0);
                put("msg","");
                put("count", count);
                put("data", list);
            }
        };
        System.out.println(map);
        return map;
    }

    @GetMapping("/getStaffDemandApproved")   //已提交的申请表
    @ResponseBody
    public Map<String,Object> getStaffDemandApproved(Integer page,Integer limit){
        System.out.println("数据表格正在请求数据。。。。2。");
        int count =departmentService.getStaffDemandApprovedCount();
        List<StaffDemand> approvedList = departmentService.getStaffDemandApproved(page, limit);

        Map<String, Object> approvedMap = new HashMap<String,Object>(){
            {
                put("code",0);
                put("msg","");
                put("count", count);
                put("data", approvedList);
            }
        };
        return approvedMap;
    }

}
