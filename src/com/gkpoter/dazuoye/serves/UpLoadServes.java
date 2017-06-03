package com.gkpoter.dazuoye.serves;

import com.gkpoter.dazuoye.model.BaseModel;

import java.io.File;

/**
 * Created by 12153 on 2017/6/3.
 */
public class UpLoadServes {

    public BaseModel upLoad(Integer userid, File videoFile, String title, String subject){
        return new BaseModel(0,"暂时无法上传");
    }

}
