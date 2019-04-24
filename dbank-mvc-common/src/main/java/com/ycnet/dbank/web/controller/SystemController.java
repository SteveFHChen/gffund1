package com.ycnet.dbank.web.controller;

import com.ycnet.mirage.context.MirageErrorCode;
import com.ycnet.mirage.context.MirageException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 系统级controller
 * Created with IntelliJ IDEA.
 * User: guozp
 * Date: 14-3-24
 * Time: 下午8:31
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class SystemController extends BaseController {
    /**
     * 跳到登录页面
     * @return
     */
    @RequestMapping("/login")
    public Map<String, Object> showLoginForm(){
        throw new MirageException(MirageErrorCode.SERVICE_NEED_AUTH);
    }

    /**
     * 退出
     */
    @RequestMapping("/logout/success")
    public Map<String,Object> logout() {
        Map<String, Object> success = new HashMap<String, Object>();
        success.put("result", "success");
        return success;
    }

}
