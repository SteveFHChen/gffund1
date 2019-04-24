package com.ycnet.dbank.web.config;

/**
 * 系统错误码定义，和application_errors_${locale}.properties文件配合使用，达到错误码国际化的目的
 *
 * 错误码定义规则：业务系统DBK(3位) + 业务实体或者某种错误类型(2位)+错误码序号(四位)
 * User: guozp
 * Date: 14-3-11
 * Time: 上午12:15
 */
public interface DbankErrorCode {

//~~~~~~系统级别错误：99
	//DBK999999 = 系统错误
	String SYSTEM_ERR = "DBK999999";

//~~~~~~实体person错误：01

}
