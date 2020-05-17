package com.isyscore.version.api.bo;


import com.isyscore.version.entity.Os;
import lombok.Data;

import java.util.List;

@Data
public class SABo {

    private Integer id;

    private Integer moduleId;

    private String moduleName;

    private String moduleVersion;

    private Double moduleProgress;

    private String serviceName;

    private Double serviceProgress;

    private String function;

    private String codeBranch;

    private String serviceTag;

    private String manager;

    private List<Os> osLst;

    private List<String> os;
}
