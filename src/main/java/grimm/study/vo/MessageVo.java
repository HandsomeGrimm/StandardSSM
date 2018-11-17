package grimm.study.vo;

import lombok.Data;

/**
 * @author HandsomeGrimm
 * @email labilabizy@163.com
 * @date 2018-10-26
 * @time 上午9:52:33
 */
@Data
public class MessageVo {
//	private static final Integer SUCCESS = 0;
//	private static final Integer FAILED = 1;

	private String code;

	private String info;

	private Object data;

	public MessageVo() {

	}

	public MessageVo(String code, String info, Object data) {
		this.code = code;
		this.info = info;
		this.data = data;
	}
}
