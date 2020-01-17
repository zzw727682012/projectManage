package com.producer.stockcheck;

import java.io.Serializable;

import com.producer.stockcheck.HeaderDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Author: Simple Zhou
 * <p>
 * Date: 2019/11/18
 * <p>
 * Description: 响应结果
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BaseResponse<T> implements Serializable {
    private HeaderDto header;
    private T content;

    public HeaderDto getHeader() {
        return header;
    }

    public void setHeader(HeaderDto header) {
        this.header = header;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
