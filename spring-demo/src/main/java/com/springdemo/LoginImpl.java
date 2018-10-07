package com.springdemo;

import org.springframework.stereotype.Component;

/**
 * <br>登录接口实现</br>
 *
 * @author 515203
 * @version 1.0
 * @email zhoulinwen@dafycredit.com
 * @date 2018/9/20 15:42
 * @since 1.0
 */
@Component
public class LoginImpl implements Login{

	@Override
	public String loginCheck(String userName, String password) {
		System.out.println("userName:" + userName + "===== password:" + password);

		return "success";
	}
}