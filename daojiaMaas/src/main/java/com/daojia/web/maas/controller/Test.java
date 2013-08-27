/**
 * 
 */
package com.daojia.web.maas.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * maas的test controller
 * 
 * @author zhaolei 2013年8月28日 上午12:36:00
 * 
 */
@Controller
@RequestMapping(value = "/test")
public class Test {

	@RequestMapping("")
	@ResponseBody
	public Map<String, Object> test() {
		Map<String, Object> relMap = new HashMap<String, Object>();
		relMap.put("relsult", false);
		return relMap;
	}

}
