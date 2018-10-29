package grimm.study.model;

import lombok.Data;

/**
 * @author HandsomeGrimm
 * @email labilabizy@163.com
 * @date 2018-10-26
 * @time 上午9:35:44
 */
@Data
public class User {

	private Long id;

	private String name;

	private String email;

	private String passWd;
}
