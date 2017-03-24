package com.dwb.middware.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by walis on 2017/3/24.
 */
@ConfigurationProperties(prefix = "springfox.swagger")
public class SpringFoxProperties {

  // doc开关， true 开， false 关
  private boolean docSwitch;

  // 需要过滤的url， like /dwb.*
  private String pathMatch;

  private String pathMapping = "/";

  private String version = "1.0.0";

  private String contactName = "dianwoba";

  private String email = "middleware@dianwoba.com";

  private String title = "dianwoba";

  private String description = "dianwoba webpai";

  public String getPathMapping() {
    return pathMapping;
  }

  public void setPathMapping(String pathMapping) {
    this.pathMapping = pathMapping;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getContactName() {
    return contactName;
  }

  public void setContactName(String contactName) {
    this.contactName = contactName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isDocSwitch() {
    return docSwitch;
  }

  public void setDocSwitch(boolean docSwitch) {
    this.docSwitch = docSwitch;
  }

  public String getPathMatch() {
    return pathMatch;
  }

  public void setPathMatch(String pathMatch) {
    this.pathMatch = pathMatch;
  }
}
