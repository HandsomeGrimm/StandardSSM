package grimm.study.service;

import grimm.study.model.User;
import grimm.study.vo.MessageVo;

/**
 * @author HandsomeGrimm
 * @email labilabizy@163.com
 * @date 2018-10-26
 * @time 上午9:41:42
 */
public interface UserService {
	public MessageVo getUsersByID(Long id);

	/**
	 * @param uiv
	 * @return
	 */
	public MessageVo getUserInfo(User user);

}
