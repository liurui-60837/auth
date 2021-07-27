package com.imooc.auth.auth.controller;

import com.imooc.auth.auth.Utls.ResultVOUtil;
import com.imooc.auth.auth.model.UserInfo;
import com.imooc.auth.auth.service.UserService;
import com.imooc.auth.auth.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ResultVO<Map<String,String>> create(String userId){
        ResultVO<Map<String,String>> resultVO = new ResultVO<>();
        UserInfo userInfo = userService.findUserById(userId);
        if(userInfo==null){
            resultVO.setState(false);
            resultVO.setMsg("用户不存在");
            return resultVO;
        }
        resultVO.setState(true);
        return resultVO;
    }
}
