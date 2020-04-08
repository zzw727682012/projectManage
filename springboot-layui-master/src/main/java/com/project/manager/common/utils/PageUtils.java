package com.project.manager.common.utils;

import com.project.manager.dto.BasePersonnelInfoDTO;

import java.util.ArrayList;
import java.util.List;

public class PageUtils {

    public static <T>List<T> getPageList(List<T> list, int pageNum, int pageSize) {
        if(list != null && list.size() > 0){
            List<T> pageInfo  = new ArrayList<T>(pageSize);
            int beginIndex = (pageNum-1) * pageSize;
            int i =0;
            while (i<pageSize) {
                if (beginIndex >= list.size()){
                    break;
                }
                pageInfo.add(list.get(beginIndex));
                beginIndex++;
                i++;
            }
            return pageInfo;
        }
        return null;
    }
}
