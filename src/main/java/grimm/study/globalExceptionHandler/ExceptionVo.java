package grimm.study.globalExceptionHandler;

import grimm.study.vo.MessageVo;

/**
 * @author HandsomeGrimm
 * @email labilabizy@163.com
 * @date 2018-11-15
 * @time 下午12:02:25
 */
public class ExceptionVo extends Exception {

	private static final long serialVersionUID = 1L;

	private MessageVo messageVo;

	public ExceptionVo() {
		super();
	}

	public ExceptionVo(Throwable throwable) {
		super(throwable);
	}

	/**
	 * @param returnVo
	 */
	public ExceptionVo(MessageVo messageVo) {
		super();
		this.messageVo = messageVo;
	};

	public ExceptionVo(Throwable throwable, MessageVo messageVo) {
		super(throwable);
		this.messageVo = messageVo;
	}

	public MessageVo getMessageVo() {
		return messageVo;
	}

	public void setMessageVo(MessageVo messageVo) {
		this.messageVo = messageVo;
	}

}
