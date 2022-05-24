package cn.myjszl.common.base.handler;

import cn.myjszl.common.base.model.ResultMsg;
import cn.myjszl.common.base.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author   
 *这个接口当用户未通过认证访问受保护的资源时，
 * 将会调用其中的commence()方法进行处理，比如客户端携带的token被篡改，因此我们需要自定义一个AuthenticationEntryPoint返回特定的提示信息
 */
@Component
@Slf4j
public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        ResponseUtils.result(response,new ResultMsg(403,"无权限访问，请先登录！",null));
    }
}