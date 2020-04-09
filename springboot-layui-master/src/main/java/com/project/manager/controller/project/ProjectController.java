package com.project.manager.controller.project;


import com.project.manager.common.IStatusMessage;
import com.project.manager.common.utils.StringUtils;
import com.project.manager.dto.ProjectSearchDTO;
import com.project.manager.pojo.BaseProjectInfo;
import com.project.manager.pojo.BaseProjectNode;
import com.project.manager.pojo.BaseProjectUser;
import com.project.manager.response.PageDataResult;
import com.project.manager.response.ResponseResult;
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
import java.util.*;


/**
 *
 */
@Controller
@RequestMapping("project")
public class ProjectController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${finalReportPath}")
    private String finalReportPath;

    @Value("${technicalReportPath}")
    private String technicalReportPath;

    @Value("${nodeAttachmentPath}")
    private String nodeAttachmentPath;

    @Value("${projectReportPath}")
    private String projectReportPath;

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

    @RequestMapping("projectNodeManage")
    public String scheduleManage() {
        logger.info("进入项目进度管理");
        return "/project/projectNodeManage";
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
    public Map<String,Object> addProjectNode(BaseProjectNode projectNode) {
        logger.info("项目结点管理[新增或更新]！project:" + projectNode);
        Map<String,Object> data = new HashMap();
        if(projectNode.getId() == null){
            data = baseProjectService.addProjectNode(projectNode);
        }else{
            data = baseProjectService.updateProjectNode(projectNode);
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

        if (null == pageNum) {
            pageNum = 1;
        }
        if (null == pageSize) {
            pageSize = 10;
        }
        // 获取用户列表
        pdr = baseProjectService.getProjectList(projectSearchDTO, pageNum, pageSize);
        logger.info("项目列表查询=pdr:" + pdr);


        return pdr;
    }

    @RequestMapping(value = "/getProjectUserList", method = RequestMethod.POST)
    @ResponseBody
    public PageDataResult getProjectUserList(@RequestParam("pageNum") Integer pageNum,
                                         @RequestParam("pageSize") Integer pageSize, ProjectSearchDTO projectSearchDTO) {
        logger.info("分页查询人员信息列表！搜索条件：project search：" + projectSearchDTO + ",pageNum:" + pageNum
                + ",每页记录数量pageSize:" + pageSize);
        PageDataResult pdr = new PageDataResult();

        if (null == pageNum) {
            pageNum = 1;
        }
        if (null == pageSize) {
            pageSize = 10;
        }
        // 获取用户列表
        pdr = baseProjectService.getProjectUserList(projectSearchDTO, pageNum, pageSize);
        logger.info("项目列表查询=pdr:" + pdr);


        return pdr;
    }

    @RequestMapping(value = "/getProjectNodeList", method = RequestMethod.POST)
    @ResponseBody
    public PageDataResult getProjectNodeList(@RequestParam("pageNum") Integer pageNum,
                                           @RequestParam("pageSize") Integer pageSize, ProjectSearchDTO projectSearchDTO) {
        logger.info("分页查询项目结点！搜索条件：project search：" + projectSearchDTO + ",pageNum:" + pageNum
                + ",每页记录数量pageSize:" + pageSize);
        PageDataResult pdr = new PageDataResult();

        if (null == pageNum) {
            pageNum = 1;
        }
        if (null == pageSize) {
            pageSize = 10;
        }
        // 获取用户列表
        pdr = baseProjectService.getProjectNodeList(projectSearchDTO, pageNum, pageSize);
        logger.info("项目结点查询=pdr:" + pdr);


        return pdr;
    }

    @RequestMapping(value = "/delProject", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> delProject(@RequestParam("id") Integer id) {
        Map<String, Object> data = new HashMap<>();
        if (id == null) {
            data.put("code",0);
            data.put("msg","删除项目失败,项目id为空");
            logger.error("删除项目失败");
            return data;
        }
        data = baseProjectService.delProject(id);
        logger.info("删除项目！id:" + id);
        return data;
    }

    @RequestMapping(value = "/delProjectUser", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> delProjectUser(@RequestParam("id") Integer id) {
        Map<String, Object> data = new HashMap<>();
        logger.info("删除项目！id:" + id);
        if (id == null) {
            data.put("code",0);
            data.put("msg","删除人员失败,人员id为空");
            logger.error("删除人员失败");
            return data;
        }
        data = baseProjectService.delProjectUser(id);

        return data;
    }

    @RequestMapping(value = "/delProjectNode", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> delProjectNode(@RequestParam("id") Integer id) {
        logger.info("删除项目！id:" + id);
        Map<String, Object> data = new HashMap<>();
        if (id == null) {
            data.put("code",0);
            data.put("msg","删除节点失败,节点id为空");
            logger.error("删除节点失败");
            return data;
        }

        data = baseProjectService.delProjectNode(id);
        return data;
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        ResponseResult result = new ResponseResult();
        try {
            String name = file.getOriginalFilename();
            String type = request.getParameter("type");
            String filePath = null;
            if (type.equals("uploadTechnicalReport")) {
                filePath = technicalReportPath + name;
            } else if (type.equals("uploadFinalReport")) {
                filePath = finalReportPath + name;
            } else if (type.equals("uploadNodeAttachment")) {
                filePath = nodeAttachmentPath + name;
            }  else if (type.equals("uploadProjectReport")) {
                filePath = projectReportPath + name;
            } else {
                result.setStatusMessage(IStatusMessage.SystemStatus.PARAM_ERROR);
            }
            logger.info("附件路径:" + filePath);

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
            result.setMessage("上传成功");
            result.setObj(name);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode("404");
            result.setMessage("上传失败：" + e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/downloadFile", method = RequestMethod.GET)
    @ResponseBody
    public void downloadFile(HttpServletRequest request, HttpServletResponse response) {
        ServletOutputStream outputStream = null;
        FileInputStream inputStream = null;
        try {
            logger.info("请求地址：" + request.getRequestURI());
            String id = request.getParameter("id");
            String type = request.getParameter("type");

            boolean fileExist = true;
            if (StringUtils.isNull(id) || StringUtils.isNull(type)) {
                logger.error("下载失败,附件文件不存在");
                fileExist = false;
            }
            String fileName = null;
            String path = null;
            if (type.equals("nodeAttachment")) {
                BaseProjectNode projectNode = baseProjectService.getProjectNode(Integer.valueOf(id));
                fileName = projectNode.getNodeAttachment();
                path = nodeAttachmentPath;
            } else if (type.equals("finalReport")) {
                BaseProjectInfo info = baseProjectService.getProjectByProjectId(Integer.valueOf(id));
                fileName = info.getFinalReport();
                path = finalReportPath;
            } else if (type.equals("technicalReport")) {
                BaseProjectInfo info = baseProjectService.getProjectByProjectId(Integer.valueOf(id));
                fileName = info.getTechnicalReport();
                path = technicalReportPath;
            }  else if (type.equals("projectReport")) {
                BaseProjectInfo info = baseProjectService.getProjectByProjectId(Integer.valueOf(id));
                fileName = info.getTechnicalReport();
                path = technicalReportPath;
            }else {
                logger.error("下载失败,下在类型不存在");
                fileExist = false;
            }

            if (StringUtils.isNull(fileName) || !fileExist) {
                logger.error("下载失败,文件不存在");
                response.setContentType("text/html;charset=UTF-8");
                response.setCharacterEncoding("UTF-8");
                PrintWriter writer = response.getWriter();
                writer.write("<script type=\"text/javascript\">alert('file not found');window.history.back(-1);</script>");
                writer.flush();
                writer.close();
                return;
            }
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "No-cache");

            String filePath = path + fileName;

            inputStream = new FileInputStream(filePath);
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


    @GetMapping("/getProjectUsers")
    @ResponseBody
    public List<BaseProjectUser> getProjectUsers(){
        logger.info("获取用户列表");
        return baseProjectService.getProjectUsers();
    }

}
