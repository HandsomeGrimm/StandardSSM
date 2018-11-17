package grimm.study.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author HandsomeGrimm
 * @email labilabizy@163.com
 * @date 2018-09-14
 * @time 下午2:27:22
 */
public class IPUtil {
	/**
	 * 获取ip地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip != null && !"".equals(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			// 多次反向代理后会有多个ip值，第一个ip才是真实ip
			int index = ip.indexOf(",");
			if (index != -1) {
				return ip.substring(0, index);
			} else {
				return ip;
			}
		}
		ip = request.getHeader("X-Real-IP");
		if (ip != null && !"".equals(ip) && !"unKnown".equalsIgnoreCase(ip)) {
			return ip;
		}
		return request.getRemoteAddr();
	}

}
