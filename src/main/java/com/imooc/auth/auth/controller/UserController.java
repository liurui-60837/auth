package com.imooc.auth.auth.controller;

import com.imooc.auth.auth.Utls.CookieUtil;
import com.imooc.auth.auth.Utls.ResultVOUtil;
import com.imooc.auth.auth.constant.CookieConstant;
import com.imooc.auth.auth.model.UserInfo;
import com.imooc.auth.auth.service.UserService;
import com.imooc.auth.auth.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/seller")
    public ResultVO<Map<String,String>> create(String userId, HttpServletResponse response, HttpServletRequest request){
        ResultVO<Map<String,String>> resultVO = new ResultVO<>();
        //判断是否已经登录
        Cookie cookie =  CookieUtil.get(request,CookieConstant.TOKEN);
        String  redisCookie = redisTemplate.opsForValue().get(CookieConstant.TOKEN);
        if(cookie!=null&&redisCookie!=null){//代表已经登录
            resultVO.setState(true);
            resultVO.setMsg("成功");
            return resultVO;
        }

        //判断 userId 是否存在
        UserInfo userInfo = userService.findUserById(userId);
        if(userInfo==null){
            resultVO.setState(false);
            resultVO.setMsg("用户不存在");
            return resultVO;
        }
        //判断当前登录角色是否正确
        if(!"2".equals(userInfo.getRole())){
            resultVO.setState(false);
            resultVO.setMsg("当前用户不是卖家");
            return resultVO;
        }
        //设置redis key=userId ,value = xyz
        redisTemplate.opsForValue().set("token",userId,CookieConstant.expire, TimeUnit.SECONDS);

        //cookie里设置opeid = xyz
        CookieUtil.set(response, CookieConstant.TOKEN,userId,CookieConstant.expire);
        resultVO.setState(true);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
