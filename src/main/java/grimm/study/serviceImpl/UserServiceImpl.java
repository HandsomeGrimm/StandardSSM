package grimm.study.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grimm.study.mapper.UserMapper;
import grimm.study.model.User;
import grimm.study.service.UserService;
import grimm.study.vo.MessageVo;
import grimm.study.vo.UserInfoVo;
import lombok.extern.slf4j.Slf4j;

/**
 * @author HandsomeGrimm
 * @email labilabizy@163.com
 * @date 2018-10-26
 * @time 上午9:45:08
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired(required = true)
	UserMapper userMapper;

	@Override
	public MessageVo getUsersByID(Long id) {
		MessageVo messageVo = new MessageVo();
		try {
			messageVo.setCode("0");
			messageVo.setInfo("success");
			messageVo.setData(userMapper.selectUserByID(id));
			return messageVo;
		} catch (Exception e) {
			log.info("=========" + e.getMessage());
			messageVo.setCode("1");
			messageVo.setInfo("failed");
			messageVo.setData(e.getMessage());
			return messageVo;
		}
	}

	@Override
	public MessageVo getUserInfo(User user) {
		UserInfoVo uiv = new UserInfoVo();
		uiv.setId(user.getId());
		uiv.setPassWord(user.getPassWd());
		uiv.setType(0);
		MessageVo messageVo = new MessageVo();
		if (uiv.getType().equals(0)) {
			try {
				messageVo.setCode("0");
				messageVo.setInfo("success");
				messageVo.setData("");

				userMapper.selectUserInfo(uiv);

			} catch (Exception e) {
				log.info("========" + e.getMessage());
				messageVo.setCode("1");
				messageVo.setInfo("failed");
				messageVo.setData(e.getMessage());
			}

			return messageVo;
		} else {
			return null;
		}

	}

}
