package com.isyscore.version.api.bo;

import lombok.Data;

@Data
public class ServiceDetailBO {

    // Service 属性

    private Integer serviceId;

    private String serviceName;

    private String function;

    private Double serviceProgress;

    private String codeBranch;

    private String serviceTag;

    private String manager;

    private String domain;

    private String isCloud;

    private Integer localContainerPort;

    private Integer cloudContainerPort;

    private Integer localPort;

    private Integer cloudPort;

    private String serviceKind;

    private String githubLocation;

    private String configLocal;

    private String configCloud;

    private String isServer;

    private String dependency;

    private Integer loadPriority;

    private Integer duplication;

    private String logDir;

    private String dataDir;

    private String remarks;


    // 从属 module 属性

    private Integer moduleId;

    private String moduleName;

    private String moduleVersion;

    private Double moduleProgress;


}
