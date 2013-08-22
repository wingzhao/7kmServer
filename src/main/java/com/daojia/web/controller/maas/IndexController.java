/**
 * 
 */
package com.daojia.web.controller.maas;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.daojia.web.controller.BaseController;

/**
 * 后台管理首页. 主要负责导航
 * 
 * @author zhaolei
 * 2013年8月23日 上午1:26:25
 *
 */
@RequestMapping(value="/maas")
public class IndexController extends BaseController {
	
	/**
	 * 后台管理导航
	 *
	 * @author zhaolei
	 * 2013年8月23日 上午1:32:54
	 *
	 * @return
	 */
	public ModelAndView index(){
		return null;
	}

}
