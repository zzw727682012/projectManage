package com.poi;

import java.lang.annotation.*;

/**
 * @author : liuc
 * @date : 2019/4/18 16:36
 * @description : sheet页名称
 */
@Documented
@Inherited
@Target(ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface SheetDesc {

}
