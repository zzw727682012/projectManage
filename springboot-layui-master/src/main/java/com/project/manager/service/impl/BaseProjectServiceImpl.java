package com.project.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.manager.common.utils.DateRange;
import com.project.manager.common.utils.DateUtils;
import com.project.manager.common.utils.StringUtils;
import com.project.manager.dao.BaseProjectInfoMapper;
import com.project.manager.dao.BaseProjectNodeMapper;
import com.project.manager.dao.BaseProjectUserMapper;
import com.project.manager.dto.BasePersonnelInfoDTO;
import com.project.manager.dto.BaseProjectInfoDTO;
import com.project.manager.dto.BaseProjectNodeInfoDTO;
import com.project.manager.dto.ProjectSearchDTO;
import com.project.manager.pojo.BaseProjectInfo;
import com.project.manager.pojo.BaseProjectNode;
import com.project.manager.pojo.BaseProjectUser;
import com.project.manager.response.PageDataResult;
import com.project.manager.service.BaseProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BaseProjectServiceImpl implements BaseProjectService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseProjectInfoMapper baseProjectInfoMapper;

    @Autowired
    private BaseProjectUserMapper baseProjectUserMapper;

    @Autowired
    private BaseProjectNodeMapper baseProjectNodeMapper;

    @Override
    public Map<String, Object> addProject(BaseProjectInfo projectInfo) {
        Map<String,Object> data = new HashMap();
        try {
            BaseProjectInfo old = baseProjectInfoMapper.getProjectByProjectName(projectInfo.getProjectName(),null);

            if (old != null) {
                data.put("code",0);
                data.put("msg","项目已存在！");
                logger.error("项目[新增]，结果=项目已存在！");
                return data;
            }

            projectInfo.setCreateTime(DateUtils.getCurrentDate());
            int result = baseProjectInfoMapper.insert(projectInfo);

            if (result == 0) {
                data.put("code",0);
                data.put("msg","新增项目失败！");
                logger.error("项目[新增]，结果=新增失败！");
                return data;
            }

            data.put("code",1);
            data.put("msg","新增成功！");
            logger.info("项目[新增]，结果=新增成功！");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("项目[新增]异常！", e);
            data.put("code",1);
            data.put("msg","项目新增异常" + e.getMessage());
            return data;
        }
        return data;
    }

    @Override
    public Map<String, Object> addProjectUser(BaseProjectUser baseProjectUser) {
        Map<String,Object> data = new HashMap();
        try {
            baseProjectUser.setCreateTime(DateUtils.getCurrentDate());
            int result = baseProjectUserMapper.insert(baseProjectUser);
            if(result == 0){
                data.put("code",0);
                data.put("msg","新增人员失败！");
                logger.error("人员[新增]，结果=新增失败！");
                return data;
            }

            data.put("code",1);
            data.put("msg","新增成功！");
            logger.info("人员[新增]，结果=新增成功！");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("人员[新增]异常！", e);
            return data;
        }
        return data;
    }

    @Override
    public BaseProjectInfo getProjectByProjectId(Integer id) {

        return baseProjectInfoMapper.getProjectByProjectName(null, id);
    }

    @Override
    public Map<String, Object> updateProjectUser(BaseProjectUser baseProjectUser) {
        Map<String,Object> data = new HashMap();

        try {
            int result = baseProjectUserMapper.updateProject(baseProjectUser);
            if(result == 0){
                data.put("code",0);
                data.put("msg","编辑人员信息失败");
                logger.error("编辑人员信息失败");
                return data;
            }
            data.put("code",1);
            data.put("msg","编辑人员信息成功");
            logger.info("编辑人员信息成功");
        } catch (Exception e) {
            data.put("code",0);
            data.put("msg","编辑人员信息失败");
            logger.error("编辑人员信息失败" + e.getMessage());
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public Map<String, Object> delProjectUser(Integer id) {
        Map<String,Object> data = new HashMap();
        try {
            List<BaseProjectInfo> infos = baseProjectInfoMapper.getProjectByUserId(id);
            if (infos != null && infos.size() > 0) {
                data.put("code",0);
                data.put("msg","删除失败,该人员是项目主导人或参研人！");
                logger.error("删除人员失败");
                return data;
            }
            int result = baseProjectUserMapper.deleteProjectPersonnel(id);
            if(result == 0){
                data.put("code",0);
                data.put("msg","删除人员失败");
                logger.error("删除人员失败");
                return data;
            }
            data.put("code",1);
            data.put("msg","删除人员成功");
            logger.info("删除人员成功");
        } catch (Exception e) {
            data.put("code",0);
            data.put("msg","删除人员失败");
            logger.error("删除人员失败" + e.getMessage());
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public Map<String, Object> addProjectNode(BaseProjectNode projectPlan) {
        Map<String,Object> data = new HashMap();
        try {
            BaseProjectInfo info = baseProjectInfoMapper.getProjectByProjectName(projectPlan.getProjectName(), null);
            info.setNodeCount(info.getNodeCount() == null ? 1 : info.getNodeCount() + 1);
            projectPlan.setProjectManagerId(info.getProjectManagerId());
            projectPlan.setProjectId(info.getId());
            projectPlan.setCreateTime(DateUtils.getNowDateString());
            int result = baseProjectNodeMapper.insert(projectPlan);
            if(result == 0){
                data.put("code",0);
                data.put("msg","新增项目结点失败！");
                logger.error("新增项目结点[新增]，结果=新增失败！");
                return data;
            }
            updateProject(info);
            data.put("code",1);
            data.put("msg","新增成功！");
            logger.info("新增项目结点[新增]，结果=新增成功！");
        } catch (Exception e) {
            e.printStackTrace();
            data.put("code",0);
            data.put("msg","新增项目结点失败！" + e);
            logger.error("新增项目结点 [新增]异常！", e.getMessage());
            return data;
        }
        return data;
    }

    @Override
    public BaseProjectNode getProjectNode(Integer id) {
        return baseProjectNodeMapper.getProjectNodeById(id);
    }

    @Override
    public Map<String, Object> delProjectNode(Integer id) {
        Map<String,Object> data = new HashMap();

        try {
            BaseProjectNode projectNode = getProjectNode(id);
            BaseProjectInfo info = baseProjectInfoMapper.getProjectByProjectName(projectNode.getProjectName(), projectNode.getId());
            int result = baseProjectNodeMapper.deleteProjectNode(id);
            if(result == 0){
                data.put("code",0);
                data.put("msg","删除节点失败");
                logger.error("删除节点失败");
                return data;
            }
            info.setNodeCount(info.getNodeCount() == null ? 0 : info.getNodeCount() - 1);
            updateProject(info);
            data.put("code",1);
            data.put("msg","删除节点成功");
            logger.info("删除节点成功");
        } catch (Exception e) {
            data.put("code",0);
            data.put("msg","删除节点失败");
            logger.error("删除节点失败" + e.getMessage());
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public Map<String, Object> updateProjectNode(BaseProjectNode projectNode) {
        Map<String,Object> data = new HashMap();
        try {
            int result = baseProjectNodeMapper.updateProjectNode(projectNode);
            if(result == 0){
                data.put("code",0);
                data.put("msg","更新项目结点失败！");
                logger.error("更新项目结点[更新]，结果=新增失败！");
                return data;
            }
            data.put("code",1);
            data.put("msg","更新成功！");
            logger.info("更新项目结点[更新]，结果=新增成功！");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("更新项目结点 [更新]异常！", e.getMessage());
            data.put("code",0);
            data.put("msg","更新项目结点失败！" + e.getMessage());
            return data;
        }
        return data;
    }

    @Override
    public List<BaseProjectInfo> getProjects() {
        return baseProjectInfoMapper.getProjects();
    }

    @Override
    public List<BaseProjectUser> getProjectUsers() {
        return baseProjectUserMapper.getProjectUsers();
    }

    @Override
    public Map<String, Object> updateProject(BaseProjectInfo projectInfo) {
        Map<String,Object> data = new HashMap();
        Integer id = projectInfo.getId();
        BaseProjectInfo  old = baseProjectInfoMapper.getProjectByProjectName(null, id);
        if(old == null){
            data.put("code",0);
            data.put("msg","项目不存在！");
            logger.error("项目[更新]，结果=项目不存在！");
            return data;
        }
        int result = baseProjectInfoMapper.updateProject(projectInfo);
        if(result == 0){
            data.put("code",0);
            data.put("msg","更新失败！");
            logger.error("项目[更新]，结果=更新失败！");
            return data;
        }
        data.put("code",1);
        data.put("msg","更新成功！");
        logger.info("项目[更新]，结果=更新成功！");
        return data;
    }

    @Override
    public PageDataResult getProjectNodeList(ProjectSearchDTO projectSearchDTO, Integer pageNum, Integer pageSize) {
        PageDataResult pageDataResult = new PageDataResult();
        if (projectSearchDTO.getS_dateRange() != null) {
            projectSearchDTO.setS_expirationTime(DateUtils.dateRange(DateRange.getDateRange(projectSearchDTO.getS_dateRange())));
        }
        logger.info(projectSearchDTO.toString());
        List<BaseProjectNodeInfoDTO> projectPlans = baseProjectNodeMapper.getProjectNodeList(projectSearchDTO);
        logger.info(projectPlans.toString());
        PageHelper.startPage(pageNum, pageSize);

        if(projectPlans.size() != 0){
            PageInfo<BaseProjectNodeInfoDTO> pageInfo = new PageInfo<BaseProjectNodeInfoDTO>(projectPlans);
            pageDataResult.setList(projectPlans);
            pageDataResult.setTotals((int) pageInfo.getTotal());
        }

        return pageDataResult;
    }

    @Override
    public PageDataResult getProjectList(ProjectSearchDTO projectSearchDTO, Integer pageNum, Integer pageSize) {
        PageDataResult pageDataResult = new PageDataResult();
        if (projectSearchDTO.getS_dateRange() != null) {
            projectSearchDTO.setS_expirationTime(DateUtils.dateRange(DateRange.getDateRange(projectSearchDTO.getS_dateRange())));
        }
        List<BaseProjectInfoDTO> baseProjectInfoDTOList = baseProjectInfoMapper.getProjectList(projectSearchDTO);

        for (BaseProjectInfoDTO dto: baseProjectInfoDTOList) {
            if (StringUtils.isNotNull(dto.getProjectResearchers())){
                String[] ids = dto.getProjectResearchers().split(",");
                List<String> nameList = new ArrayList<>();
                for (String id: ids) {
                    if (StringUtils.isNotNull(id)) {
                        BaseProjectUser user = baseProjectUserMapper.getProjectUserById(Integer.valueOf(id));
                        nameList.add(user.getUserName());
                    }
                }
                dto.setProjectResearchersName(nameList.toString());
            } else {
                continue;
            }
        }
        PageHelper.startPage(pageNum, pageSize);

        if(baseProjectInfoDTOList.size() != 0){
            PageInfo<BaseProjectInfoDTO> pageInfo = new PageInfo<>(baseProjectInfoDTOList);
            pageDataResult.setList(baseProjectInfoDTOList);
            pageDataResult.setTotals((int) pageInfo.getTotal());
        }

        return pageDataResult;
    }

    @Override
    public PageDataResult getProjectUserList(ProjectSearchDTO projectSearchDTO, Integer pageNum, Integer pageSize) {
        PageDataResult pageDataResult = new PageDataResult();
        List<BasePersonnelInfoDTO> basePersonnelInfoDTOS = baseProjectUserMapper.getPersonnelList(projectSearchDTO);
        logger.info(basePersonnelInfoDTOS.toString());
        PageHelper.startPage(pageNum, pageSize);

        if(basePersonnelInfoDTOS.size() != 0){
            PageInfo<BasePersonnelInfoDTO> pageInfo = new PageInfo<>(basePersonnelInfoDTOS);
            pageDataResult.setList(basePersonnelInfoDTOS);
            pageDataResult.setTotals((int) pageInfo.getTotal());
        }

        return pageDataResult;
    }

    @Override
    public Map<String, Object> delProject(Integer id) {
        Map<String, Object> data = new HashMap<>();
        try {
            int result = baseProjectInfoMapper.deleteProject(id);
            int re = baseProjectNodeMapper.deleteNodeByProjectId(id);
            if(result == 0 || re == 0){
                data.put("code",0);
                data.put("msg","删除项目失败");
                logger.error("删除项目失败");
                return data;
            }
            data.put("code",1);
            data.put("msg","删除项目成功");
            logger.info("删除项目成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除项目异常！", e);
        }
        return data;
    }
}
