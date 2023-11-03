package com.xsfh.demo1.core.wrapper;

import com.xsfh.demo1.common.enums.ResponseCode;
import lombok.Data;

/**
 * 包装返回类
 * @param <T>
 */
@Data
public class ResultData<T> {
    private int code;
    private String message;
    private T data;
    private long timestamp;

    public ResultData() {
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * 成功状态
     */
    public static <T>ResultData<T> success(T data){
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(ResponseCode.SUCCESS.getCode());
        resultData.setMessage(ResponseCode.SUCCESS.getMessage());
        resultData.setData(data);
        return resultData;
    }
    /**
     * 失败状态
     */
    public static <T>ResultData<T> fail(int code,String message){
        ResultData<T> resultData = new ResultData();
        resultData.setCode(code);
        resultData.setMessage(message);
        return resultData;
    }


}
