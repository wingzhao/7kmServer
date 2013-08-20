/**
 * 
 */
package com.daojia.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 服务人员Controller
 * 
 * @author zhaolei 2013年8月19日 下午7:14:38
 */
@Controller
@RequestMapping("/worker")
public class WorkerController extends BaseController {

	/**
	 * 测试
	 * 
	 * @author zhaolei 2013年8月19日 下午7:45:41
	 * 
	 * @return
	 */
	@RequestMapping(value="/test")
	@ResponseBody
	public Map<String, Object> test() {
		Map<String, Object> relMap = new HashMap<>();
		relMap.put("relsult", false);
		return relMap;
	}
	
	/**
	 * 获取服务人员信息
	 *
	 * @author zhaolei
	 * 2013年8月20日 下午5:41:40
	 *
	 * @return
	 */
	public Map<String,Object> get(){
		return null;
	}
	
	

}
