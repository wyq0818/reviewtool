package com.reviewtool.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @ClassName WebConfig
 * @Author wuyongqiang
 * @Date 2018/8/16 10:53
 * @Version 1.0
 **/
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    public static String LOGIN_USER = "loginUser";

    public WebConfig() {
        super();
    }
    //因为新加了拦截器，这里需要重新设置资源地址
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations(
                "classpath:/static/");
        registry.addResourceHandler("/templates/**").addResourceLocations(
                "classpath:/templates/");

        super.addResourceHandlers(registry);
    }

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截规则：除了login，其他都拦截判断,excludePathPatterns是排除拦截的路径，一个是登录验证地址，一个是登录页
        registry.addInterceptor(new
                LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/index","/system/user/validate");
        super.addInterceptors(registry);
    }
}
