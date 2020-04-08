package com.project.manager.dao;

import com.project.manager.dto.BaseProjectNodeInfoDTO;
import com.project.manager.dto.ProjectSearchDTO;
import com.project.manager.pojo.BaseProjectNode;
import com.project.manager.pojo.BaseProjectUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mapper.MyMapper;

import java.util.List;

@Repository
public interface BaseProjectNodeMapper extends MyMapper<BaseProjectNode> {

    List<BaseProjectNodeInfoDTO> getProjectNodeList(ProjectSearchDTO projectSearchDTO);

    int updateProjectNode(BaseProjectNode baseProjectPlan);

    int deleteProjectNode(@Param("id") Integer id);

    BaseProjectNode getProjectNodeById(@Param("id")Integer id);

    int deleteNodeByProjectId(@Param("projectId") Integer projectId);

}
