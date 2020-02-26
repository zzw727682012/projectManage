package com.project.manager.dao;

import com.project.manager.dto.ProjectSearchDTO;
import com.project.manager.pojo.BaseProjectPlan;
import org.springframework.stereotype.Repository;
import tk.mapper.MyMapper;

import java.util.List;

@Repository
public interface BaseProjectPlanMapper extends MyMapper<BaseProjectPlan> {

    List<BaseProjectPlan> getProjectPlanList(ProjectSearchDTO projectSearchDTO);

    int updateProjectPlan(BaseProjectPlan baseProjectPlan);

}
