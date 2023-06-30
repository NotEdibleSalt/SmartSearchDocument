package com.smartsearchdocument.config;


import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import java.util.Optional;
import org.springframework.data.domain.AuditorAware;


public class AuditorAwareImpl implements AuditorAware<String> {


    @Override
    public Optional<String> getCurrentAuditor() {

        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        String loginId = (String) tokenInfo.getLoginId();

        return Optional.ofNullable(loginId);
    }


}
