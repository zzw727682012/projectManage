package com.project.manager.service;


import com.project.manager.dto.ProjectSearchDTO;
import com.project.manager.pojo.BaseProjectInfo;
import com.project.manager.pojo.BaseProjectPlan;
import com.project.manager.pojo.BaseProjectUser;
import com.project.manager.response.PageDataResult;

import java.util.List;
import java.util.Map;

public interface BaseProjectService {
    Map<String,Object> addProject(BaseProjectInfo projectInfo);

    Map<String,Object> updateProject(BaseProjectInfo projectInfo);

    Map<String, Object> delProject(Integer id);

    PageDataResult getProjectList(ProjectSearchDTO projectSearchDTO, Integer pageNum, Integer pageSize);

    PageDataResult getProjectUserList(ProjectSearchDTO projectSearchDTO, Integer pageNum, Integer pageSize);

    PageDataResult getProjectPlanList(ProjectSearchDTO projectSearchDTO, Integer pageNum, Integer pageSize);

    BaseProjectInfo getProjectByProjectId(Integer id);

    Map<String, Object> addProjectUser(BaseProjectUser baseProjectUser);

    Map<String,Object> updateProjectUser(BaseProjectUser baseProjectUser);

    Map<String, Object> delProjectUser(Integer id);

    Map<String,Object> addProjectNode(BaseProjectPlan projectPlan);

    Map<String,Object> updateProjectNode(BaseProjectPlan projectPlan);

    List<BaseProjectInfo> getProjects();

    List<BaseProjectUser>getProjectUsers();
}
