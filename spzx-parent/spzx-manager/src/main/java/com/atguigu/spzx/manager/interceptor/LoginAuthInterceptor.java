package com.atguigu.spzx.manager.interceptor;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.atguigu.spzx.model.entity.system.SysUser;
import com.atguigu.spzx.model.vo.common.Result;
import com.atguigu.spzx.model.vo.common.ResultCodeEnum;
import com.atguigu.spzx.utils.AuthContextUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

@Component
public class LoginAuthInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1 获取请求方式
        //如果请求方式是options 预检请求，直接放行
        String method = request.getMethod();
        if("OPTIONS".equals(method)) {
            return true;
        }

        //2 从请求头获取token
        String token = request.getHeader("token");

        //3 如果token为空，返回错误提示
        if(StrUtil.isEmpty(token)) {
            responseNoLoginInfo(response);
            return false;
        }

        //4 如果token不为空，拿着token查询redis
        String userInfoString = redisTemplate.opsForValue().get("user:login" + token);

        //5 如果redis查询不到数据，返回错误提示
        if(StrUtil.isEmpty(userInfoString)) {
            responseNoLoginInfo(response);
            return false;
        }

        //6 如果redis查询到用户信息，把用户信息放到ThreadLocal里面
        SysUser sysUser = JSON.parseObject(userInfoString, SysUser.class);
        AuthContextUtil.set(sysUser);

        //7 把redis用户信息数据更新过期时间
        redisTemplate.expire("user:login" + token,30, TimeUnit.MINUTES);

        //8 放行
        return true;
    }

    //响应208状态码给前端
    private void responseNoLoginInfo(HttpServletResponse response) {
        Result<Object> result = Result.build(null, ResultCodeEnum.LOGIN_AUTH);
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(JSON.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) writer.close();
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        //ThreadLocal删除
        AuthContextUtil.remove();
    }
}
