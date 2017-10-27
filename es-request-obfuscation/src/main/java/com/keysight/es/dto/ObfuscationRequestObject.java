package com.keysight.es.dto;

import com.keysight.es.entities.RequestApprovalEntity;
import lombok.Data;

@Data
public class ObfuscationRequestObject {
    String userName;
    String projectName;
    boolean chkContainIP;
    boolean chkExportToExternal;
    boolean chkWinDesktopApplication;
    boolean chkWinCEApplication;
    boolean chkShouldObfuscate;
    boolean chkObfuscateAll;

    public RequestApprovalEntity convertToRequestApprovalEntity()
    {
        RequestApprovalEntity rae=new RequestApprovalEntity();
        rae.setUserName(this.userName);
        rae.setProjectName(this.projectName);
        rae.setContainIP(this.chkContainIP);
        rae.setExportToExternal(this.chkExportToExternal);
        rae.setWinDesktopApplication(this.chkWinDesktopApplication);
        rae.setWinCEApplication(this.chkWinCEApplication);
        rae.setShouldObfuscate(this.chkShouldObfuscate);
        rae.setObfuscateAll(this.chkObfuscateAll);
        return rae;
    }
}
