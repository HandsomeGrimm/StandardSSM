package grimm.study.vo;

import lombok.Data;

/**
 * @author HandsomeGrimm
 * @email labilabizy@163.com
 * @date 2018-11-05
 * @time 下午3:26:31
 */
@Data
public class UserInfoVo {

	private Long id;

	private String passWord;

	// 0为密码。1为人脸
	private Integer type;

}
