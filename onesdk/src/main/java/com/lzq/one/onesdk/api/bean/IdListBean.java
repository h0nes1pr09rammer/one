package com.lzq.one.onesdk.api.bean;

import java.util.List;

/**
 * Created by CTWLPC on 2017/10/19.
 */

public class IdListBean {

    /**
     * res : 0
     * data : ["3528","3520","3519","3517","3516","3515","3514","3513","3476","3505"]
     */

    private int res;
    private List<String> data;

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
