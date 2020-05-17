package com.isyscore.version.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Os {

    private String osVersion;

    private String osName;

    private Integer isHistory;

    private Date osDate;

    private Double osProgress;

    private String osRemark;
}
