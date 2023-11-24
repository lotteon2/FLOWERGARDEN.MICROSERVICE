package com.bit.lot.flower.auth.common.config;

import com.bit.lot.flower.auth.common.interceptor.CommonLogoutInterceptor;
import com.bit.lot.flower.auth.common.security.TokenHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

  private final TokenHandler tokenHandler;

  @Bean
  public CommonLogoutInterceptor commonLogoutInterceptor(){
    return new CommonLogoutInterceptor(tokenHandler);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(commonLogoutInterceptor()).pathMatcher(new AntPathMatcher("**/logout"));
  }



}