package com.zxw.util;

import com.zxw.domain.ResultVo;

public class ResultVoUtil {

    //创建成功的返回值
    public static <T>  ResultVo success(T data){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(200);
        resultVo.setMessage("success");
        resultVo.setData(data);
        return resultVo;
    }

    public static ResultVo error(Exception e,int code){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(code);
        resultVo.setMessage(e.getMessage());
        resultVo.setData(null);
        return resultVo;
    }
}
