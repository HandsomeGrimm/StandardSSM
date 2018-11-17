package grimm.study.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import grimm.study.mapper.SysLogMapper;
import grimm.study.model.SysLog;
import grimm.study.service.SysLogService;

/**
 * @author HandsomeGrimm
 * @email labilabizy@163.com
 * @date 2018-11-17
 * @time 下午1:45:07
 */
@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {

	@Autowired
	SysLogMapper sysLogMapper;

	@Override
	public int logInsert(SysLog sysLog) {
		return sysLogMapper.insertSelective(sysLog);
	}

}
