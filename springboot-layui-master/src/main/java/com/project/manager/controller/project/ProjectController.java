package com.project.manager.controller.project;


import com.project.manager.dto.ProjectSearchDTO;
import com.project.manager.pojo.BaseProjectInfo;
import com.project.manager.pojo.BaseProjectPlan;
import com.project.manager.pojo.BaseProjectUser;
import com.project.manager.response.PageDataResult;
import com.project.manager.service.BaseProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 *
 */
@Controller
@RequestMapping("project")
public class ProjectController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${projectAccessory}")
    private String accessoryPath;

    @Value("${userPhoto}")
    private String photoPath;

    @Autowired
    private BaseProjectService baseProjectService;

    @RequestMapping("projectManage")
    public String projectManage() {
        logger.info("进入项目基本信息");
        return "/project/projectManage";
    }

    @RequestMapping("projectUserManage")
    public String personnelManage() {
        logger.info("进入项目人员管理");
        return "/project/projectUserManage";
    }

    @RequestMapping("scheduleManage")
    public String scheduleManage() {
        logger.info("进入项目进度管理");
        return "/project/scheduleManage";
    }

    @RequestMapping("amountManage")
    public String amountManage() {
        logger.info("进入项目经费管理");
        return "/project/amountManage";
    }

    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addProject(BaseProjectInfo projectInfo) {
        logger.info("项目管理[新增或更新]！project:" + projectInfo);
        Map<String,Object> data = new HashMap();
        if(projectInfo.getId() == null){
            data = baseProjectService.addProject(projectInfo);
        }else{
            data = baseProjectService.updateProject(projectInfo);
        }
        return data;
    }

    @RequestMapping(value = "/addProjectUser", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addProjectUser(BaseProjectUser baseProjectUser) {
        logger.info("人员信息管理[新增或更新]！project:" + baseProjectUser);
        Map<String,Object> data = new HashMap();
        if(baseProjectUser.getId() == null){
            data = baseProjectService.addProjectUser(baseProjectUser);
        }else{
            data = baseProjectService.updateProjectUser(baseProjectUser);
        }
        return data;
    }

    @RequestMapping(value = "/addProjectNode", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addProjectNode(BaseProjectPlan projectPlan) {
        logger.info("项目结点管理[新增或更新]！project:" + projectPlan);
        Map<String,Object> data = new HashMap();
        if(projectPlan.getId() == null){
            data = baseProjectService.addProjectNode(projectPlan);
        }else{
            data = baseProjectService.updateProjectNode(projectPlan);
        }
        return data;
    }

    @GetMapping("/getProjects")
    @ResponseBody
    public List<BaseProjectInfo> getProjects(){
        logger.info("获取项目列表");
        return baseProjectService.getProjects();
    }
    @RequestMapping(value = "/getProjectList", method = RequestMethod.POST)
    @ResponseBody
    public PageDataResult getProjectList(@RequestParam("pageNum") Integer pageNum,
                                      @RequestParam("pageSize") Integer pageSize, ProjectSearchDTO projectSearchDTO) {
        logger.info("分页查询项目列表！搜索条件: project search：" + projectSearchDTO + ",pageNum:" + pageNum
                + ",每页记录数量pageSize:" + pageSize);
        PageDataResult pdr = new PageDataResult();
        try {
            if(null == pageNum) {
                pageNum = 1;
            }
            if(null == pageSize) {
                pageSize = 10;
            }
            // 获取用户列表
            pdr = baseProjectService.getProjectList(projectSearchDTO, pageNum ,pageSize);
            logger.info("项目列表查询=pdr:" + pdr);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("项目列表查询异常！", e);
        }
        return pdr;
    }

    @RequestMapping(value = "/getProjectUserList", method = RequestMethod.POST)
    @ResponseBody
    public PageDataResult getProjectUserList(@RequestParam("pageNum") Integer pageNum,
                                         @RequestParam("pageSize") Integer pageSize, ProjectSearchDTO projectSearchDTO) {
        logger.info("分页查询人员信息列表！搜索条件：project search：" + projectSearchDTO + ",pageNum:" + pageNum
                + ",每页记录数量pageSize:" + pageSize);
        PageDataResult pdr = new PageDataResult();
        try {
            if(null == pageNum) {
                pageNum = 1;
            }
            if(null == pageSize) {
                pageSize = 10;
            }
            // 获取用户列表
            pdr = baseProjectService.getProjectUserList(projectSearchDTO, pageNum ,pageSize);
            logger.info("项目列表查询=pdr:" + pdr);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("项目列表查询异常！", e);
        }
        return pdr;
    }

    @RequestMapping(value = "/getProjectPlanList", method = RequestMethod.POST)
    @ResponseBody
    public PageDataResult getProjectPlanList(@RequestParam("pageNum") Integer pageNum,
                                           @RequestParam("pageSize") Integer pageSize, ProjectSearchDTO projectSearchDTO) {
        logger.info("分页查询项目结点！搜索条件：project search：" + projectSearchDTO + ",pageNum:" + pageNum
                + ",每页记录数量pageSize:" + pageSize);
        PageDataResult pdr = new PageDataResult();
        try {
            if(null == pageNum) {
                pageNum = 1;
            }
            if(null == pageSize) {
                pageSize = 10;
            }
            // 获取用户列表
            pdr = baseProjectService.getProjectPlanList(projectSearchDTO, pageNum ,pageSize);
            logger.info("项目结点查询=pdr:" + pdr);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("项目结点查询查询异常！", e);
        }
        return pdr;
    }

    @RequestMapping(value = "/delProject", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> delProject(@RequestParam("id") Integer id) {
        logger.info("删除项目！id:" + id);
        Map<String, Object> data = new HashMap<>();
        data = baseProjectService.delProject(id);

        return data;
    }

    @RequestMapping(value = "/delProjectUser", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> delProjectUser(@RequestParam("id") Integer id) {
        logger.info("删除项目！id:" + id);
        Map<String, Object> data = new HashMap<>();
        data = baseProjectService.delProjectUser(id);

        return data;
    }

    @RequestMapping(value = "/uploadProjectAccessory", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> uploadProjectAccessory(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        Map<String, Object> data = new HashMap<>();
        try {
            String name = file.getOriginalFilename();

            logger.info("附件路径:" + accessoryPath + name);

            String filePath = accessoryPath + name;
            filePath = filePath.replace("\\", "/");
            File tempFile = new File(filePath);
            if (!tempFile.getParentFile().exists()) {
                tempFile.getParentFile().mkdir();
            }
            if (tempFile.exists()) {
                tempFile.delete();
            }
            tempFile.createNewFile();
            file.transferTo(tempFile);
            data.put("code", 1);
            data.put("msg", "上传成功");
            data.put("path", name);
        } catch (Exception e) {
            e.printStackTrace();
            data.put("code", 0);
            data.put("msg", "上传失败");
        }
        return data;
    }


    @RequestMapping(value = "/downloadProjectAccessory", method = RequestMethod.GET)
    @ResponseBody
    public void downloadProjectAccessory(HttpServletRequest request, HttpServletResponse response) {
        ServletOutputStream outputStream = null;
        FileInputStream inputStream = null;
        try {
            logger.info("请求地址：" + request.getRequestURI());
            String id = request.getParameter("projectId");
            if (id == null || "".equals(id)) {
                logger.error("下载失败附件文件不存在");
                return;
            }
            BaseProjectInfo info = baseProjectService.getProjectByProjectId(Integer.valueOf(id));
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(info.getProjectAccessory(), "UTF-8"));
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "No-cache");

            String fileName = accessoryPath + info.getProjectAccessory();
            inputStream = new FileInputStream(fileName);
            outputStream = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, len);
            }

            logger.info("下载成功" + response.getHeader("Content-Disposition"));
        } catch (Exception e) {
            e.printStackTrace();
          logger.error("下载失败" + e.getMessage());
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @RequestMapping(value = "/uploadPhoto", method = {RequestMethod.POST})
    @ResponseBody
    public Map<String, Object> uploadPhoto(@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> map2=new HashMap<>();
        Map<String,Object> map=new HashMap<>();
        String prefix="";
        String dateStr="";
        String uploadDir="uploadDir";//这个文件夹是创建在:helloworld/target/helloworld/statics/uploadDir,以及helloworld/statics/uploadDir处
        //保存上传
        OutputStream out = null;
        InputStream fileInput=null;
        try{
            if(file!=null){
                String originalName = file.getOriginalFilename();
                prefix=originalName.substring(originalName.lastIndexOf(".")+1);
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
                dateStr = format.format(new Date());
                String filepath = request.getServletContext().getRealPath("/statics/"+ uploadDir+"/" + dateStr + "." + prefix) ;
                filepath = filepath.replace("/", "\\");//java中路径转码
                File files=new File(filepath);
                //打印查看上传路径
                System.out.println(filepath);
                if(!files.getParentFile().exists()){
                    files.getParentFile().mkdirs();
                }
                file.transferTo(files);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try {
                if(out!=null){
                    out.close();
                }
                if(fileInput!=null){
                    fileInput.close();
                }
            } catch (IOException e) {
            }
        }
        map.put("code",0);
        map.put("msg","");
        map.put("data",map2);
        map2.put("src","../../../statics/"+uploadDir +"/"+ dateStr + "." + prefix);
        return map;
    }

    @GetMapping("/getProjectUsers")
    @ResponseBody
    public List<BaseProjectUser> getProjectUsers(){
        logger.info("获取用户列表");
        return baseProjectService.getProjectUsers();
    }

}
