package grimm.study.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grimm.study.mapper.UserMapper;
import grimm.study.service.UserService;
import grimm.study.vo.MessageVo;

/**
 * @author HandsomeGrimm
 * @email labilabizy@163.com
 * @date 2018-10-26
 * @time 上午9:45:08
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired(required = true)
	UserMapper userMapper;

	@Override
	public MessageVo getUsersByID(Long id) {
		MessageVo messageVo = new MessageVo();
		try {
			messageVo.setCode(0);
			messageVo.setInfo("success");
			messageVo.setData(userMapper.selectUserByID(id));
			return messageVo;
		} catch (Exception e) {
			messageVo.setCode(1);
			messageVo.setInfo("failed");
			messageVo.setData(e.getMessage());
			return messageVo;
		}
	}

}
