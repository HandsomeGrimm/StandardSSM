package grimm.study.mapper;

import grimm.study.model.User;

/**
 * @author HandsomeGrimm
 * @email labilabizy@163.com
 * @date 2018-10-26
 * @time 上午9:38:19
 */

public interface UserMapper {
	User selectUserByID(Long id);
}
