package com.producer.stockcheck;

import lombok.Data;

/**
 * Author: Simple Zhou
 * <p>
 * Date: 2019/11/18
 * <p>
 * Description: ${DESCRIPTION}
 */

@Data
public class ContentDto {

    private Permission permission;


    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }



}
