package com.project.manager.dao;


import com.project.manager.dto.BaseProjectInfoDTO;
import com.project.manager.dto.ProjectSearchDTO;
import com.project.manager.pojo.BaseProjectInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mapper.MyMapper;
import java.util.List;

@Repository
public interface BaseProjectInfoMapper extends MyMapper<BaseProjectInfo> {

    int updateProject(BaseProjectInfo baseProjectInfo);

    BaseProjectInfo getProjectByNameOrCode(@Param("projectName")String name, @Param("projectCode")String code);

    BaseProjectInfo getProjectByProjectName(@Param("projectName")String projectName, @Param("id") Integer id);

    List<BaseProjectInfo> getProjects();

    List<BaseProjectInfoDTO> getProjectList(ProjectSearchDTO projectSearchDTO);

    int deleteProject(@Param("id") Integer id);

}
