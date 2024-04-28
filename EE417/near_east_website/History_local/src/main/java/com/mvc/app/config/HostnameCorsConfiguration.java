package com.mvc.app.config;

import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.cors.CorsConfiguration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class HostnameCorsConfiguration extends CorsConfiguration {
    private List<String> allowedOrigins;
    private List<String> allowedHostnames;

    public HostnameCorsConfiguration(List<String>allowedHostnames, List<String> allowedOrigins) {
        super();
        this.allowedHostnames = allowedHostnames;
        this.allowedOrigins = allowedOrigins;
        super.setAllowedOrigins(allowedOrigins);
    }


    @Override
    public String checkOrigin(String requestOrigin) {
        String hostname = getHostname(requestOrigin);
        String isAcceptedHost = checkHostname(hostname);
        if(isAcceptedHost != null) {
            return requestOrigin;
        }

        return super.checkOrigin(requestOrigin);
    }

    private String checkHostname(@Nullable String requestHost) {
        if (!StringUtils.hasText(requestHost)) {
            return null;
        }
        if (ObjectUtils.isEmpty(this.allowedHostnames)) {
            return null;
        }

        if (allowedHostnames.contains(ALL)) {
            if (getAllowCredentials() != Boolean.TRUE) {
                return ALL;
            }
            else {
                return requestHost;
            }
        }
        for (String allowedHost : this.allowedHostnames) {
            if (requestHost.equalsIgnoreCase(allowedHost)) {
                return requestHost;
            }
        }

        return null;
    }
    private String getHostname(String requestOrigin) {
        try {
            String fullHostname = new URL(requestOrigin).getHost();
            String[] hostnameParts = fullHostname.split("\\.");
            if(hostnameParts.length > 2) {
                return hostnameParts[hostnameParts.length - 2] + "." + hostnameParts[hostnameParts.length - 1];
            } else return fullHostname;
        } catch (MalformedURLException e) {
        //TODO:
        }

        return null;
    }
}
