package com.hx.orderweb.platform;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component //该拦截器注入到spring容器中，否则该拦截器不起作用
public class LoginFilter extends ZuulFilter {
    @Override
    /**
       需要拦截的服务类型-前置拦截
       功能：处理请求参数和请求头等内容
     */
    public String filterType() {
        return FilterConstants.PRE_TYPE;  //“pre”
    }

    @Override
    /**
     * 拦截顺序，
     */
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    /**
     * 是否需要拦截：我们应该设置为返回true,需要拦截请求
     *              否则我们写该拦截器就没有意义了。
     */
    public boolean shouldFilter() {
        return true;
    }

    @Override
    /**
     * 拦截器要实现的功能就写在该run方法中，
     *  此次需要拦截请求参数中带有access_token的请求，
     *  如果次参数为null或"",就返回403，请求错误，驳回请求
     */
    public Object run() throws ZuulException {
        //获取请求的上下文信息
        RequestContext ctx = RequestContext.getCurrentContext();
        //获取request
        HttpServletRequest request = ctx.getRequest();
        //获取请求参数access_token
        String access_token = request.getParameter("access_token");
        //判断是否存在
        if(StringUtils.isBlank(access_token)){
            //不存在，未登录，则拦截
            ctx.setSendZuulResponse(false);
            //返回403
            ctx.setResponseStatusCode(HttpStatus.SC_FORBIDDEN);
        }
        return null;
    }
}
