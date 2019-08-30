package org.java.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 郑志高
 * @Date: 2019/8/19 08 49
 * @Description: 描述信息
 */

@Controller
public class TaxController {
    /**
     *
     * @param salary  本月工资
     * @param premium  各项社会保险费
     * @param deduct    专项附加费
     * @pay     税后工资
     * @percent     预扣税率
     * 预扣预缴税额=（累计预扣预缴应纳税所得额×预扣率-速算扣除数)-累计减免税额-累计已预扣预缴税额
     *
     * 累计预扣预缴应纳税所得额=累计收入-累计免税收入-累计减除费用-累计专项扣除-累计专项附加扣除-累计依法确定的其他扣除
     */
    @RequestMapping("/tax")
    public String tax( Double salary,
                       Double premium,
                      Double deduct,
                      Double late,
                      Double leave,
                      Double absenteeism,
                      Double personalDay,
                      Double workovertime,
                      Model model){

        model.addAttribute("salary",salary);
        //应纳税所得额（taxable） = 本月工资 - 5000 - 各项社会保险费 -专项附加费
        double taxable = salary - 5000 - premium - deduct;
        model.addAttribute("taxable",taxable);
        //需要缴税的金额
        double jsq;
        if (taxable<36000){
            jsq=taxable*0.03-0;
            double  pay = salary-premium-jsq;
            model.addAttribute("jsq",jsq);
            model.addAttribute("pay",pay);
            double payroll = pay - late - leave - absenteeism - personalDay + workovertime ;
            model.addAttribute("payroll",payroll);

        }else if (taxable>36000 && taxable<144000){
            jsq=taxable*0.1-2520;
            double  pay = salary-premium-jsq;
            model.addAttribute("jsq",jsq);
            model.addAttribute("pay",pay);
            double payroll = pay - late - leave - absenteeism - personalDay + workovertime ;
            model.addAttribute("payroll",payroll);
        }else if (taxable>144000 && taxable<300000){
            jsq=taxable*0.2-16920;
            double  pay = salary-premium-jsq;
            model.addAttribute("jsq",jsq);
            model.addAttribute("pay",pay);
            double payroll = pay - late - leave - absenteeism - personalDay + workovertime ;
            model.addAttribute("payroll",payroll);
        }else if(taxable>300000 && taxable<420000){
            jsq=taxable*0.25-31-31920;
            double  pay = salary-premium-jsq;
            model.addAttribute("jsq",jsq);
            model.addAttribute("pay",pay);
            double payroll = pay - late - leave - absenteeism - personalDay + workovertime ;
            model.addAttribute("payroll",payroll);
        }else if (taxable>420000 && taxable<660000){
            jsq=taxable*0.3-52920;
            double  pay = salary-premium-jsq;
            model.addAttribute("jsq",jsq);
            model.addAttribute("pay",pay);
            double payroll = pay - late - leave - absenteeism - personalDay + workovertime ;
            model.addAttribute("payroll",payroll);
        }else if (taxable>660000 && taxable<960000){
            jsq=taxable*0.35-85920;
            double  pay = salary-premium-jsq;
            model.addAttribute("jsq",jsq);
            model.addAttribute("pay",pay);
            double payroll = pay - late - leave - absenteeism - personalDay + workovertime ;
            model.addAttribute("payroll",payroll);
        }else if (taxable>960000){
            jsq=taxable*0.45-181920;
            double  pay = salary-premium-jsq;
            model.addAttribute("jsq",jsq);
            model.addAttribute("pay",pay);
            double payroll = pay - late - leave - absenteeism - personalDay + workovertime ;
            model.addAttribute("payroll",payroll);
        }

        double percent = 0;
        if (taxable<36000){
            percent=3;
            model.addAttribute("percent",percent);
        }else if (taxable>36000 && taxable<144000){
            percent=10;
            model.addAttribute("percent",percent);
        }else if (taxable>144000 && taxable<300000){
            percent=20;
            model.addAttribute("percent",percent);
        }else if (taxable>300000 && taxable<420000){
            percent=25;
            model.addAttribute("percent",percent);
        }else if (taxable>420000 && taxable<660000){
            percent=30;
            model.addAttribute("percent",percent);
        }else if (taxable>660000 && taxable<960000){
            percent=35;
            model.addAttribute("percent",percent);
        }else if (taxable>960000){
            percent=45;
            model.addAttribute("percent",percent);
        }

        if (salary<5000){
            return "/Tax";
        }



        return "/jieguo";
    }



}
