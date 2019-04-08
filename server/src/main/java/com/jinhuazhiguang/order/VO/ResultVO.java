package com.jinhuazhiguang.order.VO;

import lombok.Data;

/**
 * @Desc : http请求返回的最外层对象
 * @auth : pdp
 * @date : 2019/04/05 16:20
 */
@Data
public class ResultVO<T> {

    /** @Desc : 错误码 */
    private Integer code;

    /** @Desc : 提示信息 */
    private String msg;

    /** @Desc : 具体内容 */
    private T data;
}
