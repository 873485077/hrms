package org.java.web;

import org.java.entity.StaffDemand;
import org.java.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    private DepartmentService departmentService;

    /**
     * 添加员工需求征集审核表
     * @param model
     * @param map
     * @return
     */
    @PostMapping("/addStaffDemand")
    public String addStaffDemand(Model model,@RequestParam Map map){

        System.out.println(map);
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
    @GetMapping("/getStaffDemandApproving")
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
        return map;
    }

    @GetMapping("/getStaffDemandApproved")
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
