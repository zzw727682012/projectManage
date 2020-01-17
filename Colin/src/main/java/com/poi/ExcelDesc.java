package com.poi;

import java.lang.annotation.*;

/**
 * @author : liuc
 * @date : 2019/3/18 11:37
 * @description : 描述excel输出
 */
@Documented
@Inherited
@Target(ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ExcelDesc {

    /** 字段名 */
    String name();

    /** 格式 */
    FormatEnum format() default FormatEnum.STRING;

}
