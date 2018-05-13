/*
package com.fable.esb.modules.user.controller;

import com.fable.esb.modules.user.domain.Users;
import com.fable.esb.modules.user.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

*/
/*
 * 文件名：UserController
 * 版权：Copyright © Fable  Data Technology NanJing Co , Ltd.
 * 描述：〈一句话功能简述〉
 * 创建人： wanghaichun
 * 创建时间：2017-08-18 01:21 PM
 *//*

@Slf4j
@Controller
@Api(value = "用户管理", description = "用户管理")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    @ApiOperation(value = "新增用户", notes = "新增用户")
    @ResponseBody
    public Users save(){
        log.info("save开始");
        Users users = userService.save(new Users());
        log.info("save结束");
        return users;
    }
}
*/
