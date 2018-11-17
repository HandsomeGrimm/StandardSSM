package grimm.study.globalExceptionHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import grimm.study.vo.MessageVo;

/**
 * @author HandsomeGrimm
 * @email labilabizy@163.com
 * @date 2018-09-21
 * @time 下午2:51:56
 */
@Component
@ControllerAdvice
public class GlobalExceptionHandler {

	public Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = Exception.class)
	public @ResponseBody String ExceptionHandler(Exception e) {
		ExceptionVo exceptionVo = (ExceptionVo) e;

		System.out.println("==========" + exceptionVo.getCause() + "===========");
		System.out.println("==========" + exceptionVo.getMessageVo().toString() + "===========");

		log.info("------进入全局异常处理---------");

		MessageVo messageVo = new MessageVo();
		Gson gson = new GsonBuilder().serializeNulls().create();
		String json = null;

//		retVo.setStatuscode("1");
//		retVo.setStatusinfo("Server Error");

		messageVo = exceptionVo.getMessageVo();

		json = gson.toJson(messageVo);

		return json;
	}
}
