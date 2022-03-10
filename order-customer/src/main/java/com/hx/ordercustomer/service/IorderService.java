package com.hx.ordercustomer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value="eureka-client-service-provider",fallback=WebFirstFeignFallback.class)
public interface IorderService {
    @GetMapping("health")
    public String getServiceInfo();
}
