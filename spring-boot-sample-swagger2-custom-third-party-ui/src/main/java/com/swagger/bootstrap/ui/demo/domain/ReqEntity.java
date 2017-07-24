/*
 * Copyright (C) 2017 Zhejiang DRORE Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.drore.com.
 * Developer Web Site: http://open.drore.com.
 */

package com.swagger.bootstrap.ui.demo.domain;

import io.swagger.annotations.ApiModelProperty;

/***
 *
 * @since:swagger-bootstrap-ui-demo 1.0
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a> 
 * 2017/07/03 14:58
 */
public class ReqEntity {
    private String name;
    @ApiModelProperty(value = "222",example = "555")
    private String tel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
