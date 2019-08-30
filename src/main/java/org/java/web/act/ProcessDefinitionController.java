package org.java.web.act;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：方裕森
 * @date ：2019-08-24 18:32
 * @description：${DESCRIPTION}
 * @modified By：
 * @version: 上传部署activit的流程定义
 */
@Controller
public class ProcessDefinitionController {

    @Autowired
    private RepositoryService repositoryService;  //储存服务


    /**
     * 部署流程定义
     * @return
     */
    @Transactional
    @RequestMapping("/act/deploy")
    @ResponseBody
    public String deploy(@RequestParam("pngFile") MultipartFile pngFile, @RequestParam("bpmnFile") MultipartFile bpmnFile) throws IOException {
        System.out.println(">>> 进入工作流程部署方法");

        //获得文件名
        String pngName = pngFile.getOriginalFilename();
        String bpmnName = bpmnFile.getOriginalFilename();
        System.out.println(pngName);
        System.out.println(bpmnName);
        //把上传的两个文件,转换成输入流
        InputStream pngIn = pngFile.getInputStream();
        InputStream bpmnIn = bpmnFile.getInputStream();

        //通过RepositoryService创建部署对象,将这两个文件部署到数据库中
        DeploymentBuilder deployment = repositoryService.createDeployment();
        deployment.addInputStream(pngName, pngIn)
                .addInputStream(bpmnName, bpmnIn)
                .deploy();

        return "1";
    }

    /**
     * 显示所有的流程定义
     * @return
     */
    @GetMapping("/showProcess")
    public String showProcessDefinition(Model model) {
        System.out.println(">>>  进入showProces");
        //通过repositoryService创建流程定义的查询接口
        ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();
        //获取数据集合
        List<ProcessDefinition> list = query.list();

        model.addAttribute("list",list );
        for (ProcessDefinition processDefinition : list) {
            System.out.println(processDefinition);
        }

        return "/act/showProcessDefinition"; //跳转页面

    }

    /**
     * 显示所有的流程定义
     * layer数据表格接口(查询流程定义)
     * @return
     */
    @GetMapping("/showProcess1")
    @ResponseBody
    public Map<String, Object> showProcessDefinition1(Integer page,Integer limit) {
        System.out.println(">>>  进入showProces-1  /");
        page=(page-1)*limit;//分页起始页码
        //通过repositoryService创建流程定义的查询接口
        ProcessDefinitionQuery query = repositoryService.createProcessDefinitionQuery();
        //设置条件
        query.orderByProcessDefinitionKey().desc();
        query.orderByProcessDefinitionVersion().desc();
        //获得流程定义条数
        int count = query.list().size();
        //获取流程定义集合
        List<ProcessDefinition> processDefinitionList = query.listPage(page, limit);
        //处理集合的数据(ProcessDefinition),取出数据重新封装成map集合
        List<Map<String, Object>> list= new ArrayList<>();
        for (ProcessDefinition definition : processDefinitionList) { //遍历流程定义集合
            list.add(new HashMap<String, Object>() {
                {
                    put("id", definition.getId());
                    put("deploymentId", definition.getDeploymentId());
                    put("version", definition.getVersion());
                    put("key", definition.getKey());
                    put("resourceName", definition.getResourceName());
                    put("diagramResourceName", definition.getDiagramResourceName());
                }
            });
        }
        System.out.println(">>>  数据条数为:"+ count);
        //申明要返回的类型
        Map<String, Object> map = new HashMap<String,Object>(){
            {
                put("code",0);
                put("msg","");
                put("count", count);
                put("data", list);
            }
        };
        return map; //跳转页面

    }


    /**
     * 删除流程定义
     * @param deploymentId
     * @return
     */
    @Transactional
    @GetMapping("/act/del/{deploymentId}")
    @ResponseBody
    public String delProcessDefinition(@PathVariable("deploymentId") String deploymentId){
        System.out.println("删除了流程定义, ID为:"+deploymentId);
        repositoryService.deleteDeployment(deploymentId,true);
        return "1";
    }

    @RequestMapping("/showResource/{deploymentId}/{resourceName}")
    public void showResource(@PathVariable("deploymentId") String deploymentId
                                , @PathVariable("resourceName") String resourceName
                                , HttpServletResponse response) throws IOException {

        System.out.println("得到数据:"+deploymentId+"  ,  "+resourceName);
        //通过repositoryService从数据库中加载资源, 返回输入流, (bpmn或者png)
        InputStream in =repositoryService.getResourceAsStream(deploymentId,resourceName );

        //产生一个输出流,输出到客户端来显示
        OutputStream out = response.getOutputStream();

        //创建字节数组, 充当数据缓存区, 用于保存已读取的数据
        byte[] b = new byte[8192];

        //定义变量, 保存, 已写到数据缓冲区的长度
        int len=0;

        //通过循环, 一边把输入流的数据读写到换数据缓冲区,一边把缓冲区的数据输出到客户端显示
        while((len=in.read(b,0,8192))!=-1){
            System.out.println("数据流长度:"+len);
            out.write(b,0,len);
        }
        out.close();
        in.close();

    }

}
