package com.isyscore.version.entity;

import lombok.Data;

@Data
public class Module {

    private Integer moduleId;

    private String moduleName;

    private String moduleVersion;

    private Double moduleProgress;
}
