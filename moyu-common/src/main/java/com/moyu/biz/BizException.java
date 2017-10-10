package com.moyu.biz;

import com.moyu.enums.BaseEnum;
import lombok.Data;

/**
 * Created by XianGuo
 * Date: 2017-09-19 19:46
 */
@Data
public class BizException extends RuntimeException {

    private Integer code;

    private String desc;

    public BizException(Integer code, String desc) {
        super(desc);
        this.code = code;
        this.desc = desc;
    }

    public BizException(BaseEnum codeEnum) {
        super(codeEnum.getDesc());
        this.code = codeEnum.getCode();
        this.desc = codeEnum.getDesc();
    }
}
