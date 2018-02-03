package com.vigalyn.ms.www.domain;

import java.io.Serializable;

import org.wuwz.poi.annotation.ExportConfig;

import lombok.Data;


/**
 * 用户信息表
 */
@Data
public class UserInfo implements Serializable {

	private static final long serialVersionUID = 2488069532854782654L;

	@ExportConfig("UID")
	private String userId;
	@ExportConfig("用户名")
	private String userName;
	@ExportConfig(value = "性别", convert= "s:1=男,2=女")
	private Integer sex;
	@ExportConfig("年龄")
	private Integer age;
	
	@ExportConfig("公司名")
	private String companyName;
	@ExportConfig("部门代码")
	private String branchCode;
	@ExportConfig("岗位代码")
	private String jobId;
	//固定的映射
	@ExportConfig(value = "类别名称" , convert = "c:com.vigalyn.ms.www.common.excel.convert.CategoryConvert")
	private String category;
	//下拉框
	@ExportConfig(value = "地址" , range = "c:com.vigalyn.ms.www.common.excel.convert.AddrRangeConvert")
	private String addr;
	
}
