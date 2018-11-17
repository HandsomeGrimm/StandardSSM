package grimm.study.globalExceptionHandler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import grimm.study.model.SysLog;
import grimm.study.service.SysLogService;
import grimm.study.utils.IPUtil;

/**
 * @author HandsomeGrimm
 * @email labilabizy@163.com
 * @date 2018-09-21
 * @time 下午1:50:12
 */
@Aspect
@Component
public class SystemLogHandler {
	public Logger log = LoggerFactory.getLogger(SystemLogHandler.class);

	private static SysLog sysLog = new SysLog();
	@Autowired
	SysLogService sysLogService;

	@Autowired(required = false)
	private HttpServletRequest request;

	@Pointcut("execution(public * com.idsbg.it.plm.controller..*.*(..))")
	public void webRquestLog() {
	}

	/*
	 * @Before("webRquestLog()") public void doBefore(JoinPoint joinPoint) {
	 * 
	 * log.info("-----------------------------------");
	 * 
	 * // 日志类型 sysLog.setType("info");
	 * 
	 * // IP地址 String ip = IPUtil.getIpAddr(request); sysLog.setIp(ip);
	 * log.info("----IP------" + ip);
	 * 
	 * // 请求地址 String uri = request.getRequestURI(); sysLog.setUri(uri);
	 * log.info("---------URI---------" + uri);
	 * 
	 * // 方法名 String method = joinPoint.getSignature().getName();
	 * sysLog.setMethod(method); log.info("---------METHOD---------" + method);
	 * 
	 * // 获取请求参数 Object[] params = joinPoint.getArgs(); String paramsStr = ""; for
	 * (Object param : params) { paramsStr += (param + ","); }
	 * sysLog.setParams(paramsStr); log.info("---------PARAM----------" +
	 * paramsStr);
	 * 
	 * String message = Arrays.toString(joinPoint.getArgs());
	 * sysLog.setMessage(message); log.info("--------MESSAGE----------" + message);
	 * 
	 * sysLog.setCtime(new Date());
	 * 
	 * // String param = request.getParameterMap().toString(); }
	 */

	@AfterThrowing(pointcut = "webRquestLog()", throwing = "e")
	public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {

		log.info("进入日志切面异常通知");
		// 日志类型
		sysLog.setType("error");

		// IP地址
		String ip = IPUtil.getIpAddr(request);
		sysLog.setIp(ip);

		// 请求地址
		String uri = request.getRequestURI();
		sysLog.setUri(uri);

		// 请求方式
		String method = request.getMethod();
		sysLog.setMethod(method);

		// 获取请求参数
		Object[] params = joinPoint.getArgs();
		String paramsStr = "";
		for (Object param : params) {
			paramsStr += (param + ",");
		}
		sysLog.setParams(paramsStr);

		sysLog.setMessage(e.getCause().toString());

		sysLog.setCtime(new Date());

		// 数据库插入
		sysLogService.logInsert(sysLog);

		log.info("日志插入----->" + sysLog.toString());
	}

	@Around("webRquestLog()")
	public Object around(ProceedingJoinPoint pjd) throws Throwable {
		Object object = pjd.proceed();

		log.info("进入日志切面环绕通知");

		// 日志类型
		sysLog.setType("info");

		// IP
		String ip = IPUtil.getIpAddr(request);
		sysLog.setIp(ip);
		log.info("----IP------" + ip);

		// 请求地址
		String uri = request.getRequestURI();
		sysLog.setUri(uri);
		log.info("---------URI---------" + uri);

		// 请求方式
		String method = request.getMethod();
		sysLog.setMethod(method);
		log.info("---------METHOD---------" + method);

		// 获取请求参数
		Object[] params = pjd.getArgs();

		String paramsStr = "";
		for (Object param : params) {
			paramsStr += (param + ",");
		}
		sysLog.setParams(paramsStr);
		log.info("---------PARAM----------" + paramsStr);

		sysLog.setCtime(new Date());

		// ###################上面代码为方法执行前#####################

		// 执行方法，获取返回参数
		String message = pjd.proceed(params).toString();
		sysLog.setMessage(message);
		log.info("--------MESSAGE----------" + message);

		// ###################下面代码为方法执行后#####################

		System.out.println(sysLog.toString());

		// 数据库插入
		sysLogService.logInsert(sysLog);

		log.info("日志插入----->" + sysLog.toString());

		return object;
	}
}
