package com.project.manager.dao;

import com.project.manager.dto.BasePersonnelInfoDTO;
import com.project.manager.dto.ProjectSearchDTO;
import com.project.manager.pojo.BaseProjectUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mapper.MyMapper;

import java.util.List;

@Repository
public interface BaseProjectUserMapper extends MyMapper<BaseProjectUser> {

    List<BasePersonnelInfoDTO> getPersonnelList(ProjectSearchDTO projectSearchDTO);

    int deleteProjectPersonnel(@Param("id")Integer id);

    int updateProject(BaseProjectUser baseProjectUser);

    BaseProjectUser getProjectUserById(@Param("id")Integer id);

    List<BaseProjectUser> getProjectUsers();

    int insertUser(BaseProjectUser baseProjectUser);
}
