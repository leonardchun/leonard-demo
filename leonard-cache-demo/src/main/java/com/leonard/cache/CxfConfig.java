
package com.leonard.cache;

import com.google.common.collect.Lists;
import com.leonard.cache.modules.webservice.service.ITrafficViolationService;
import com.leonard.cache.modules.webservice.service.IdentityWebserviceService;
import com.leonard.cache.modules.webservice.service.impl.PictureServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.spring.boot.autoconfigure.CxfProperties;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

import javax.xml.ws.Endpoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Configuration
public class CxfConfig {

    @Autowired
    private Bus bus;

    @Autowired
    private IdentityWebserviceService identityWebserviceService;

    @Autowired
    private ITrafficViolationService trafficViolationService;

/*    @Autowired(required = false)
    private IPictureService pictureService;*/

    @Autowired
    private CxfProperties properties;
    @Bean
    public PictureServiceImpl layout() {
        return new PictureServiceImpl();
    }


    @Bean(name = "cxfServletRegistration")
    public ServletRegistrationBean cxfServletRegistration() {
        String urlMapping = getServiceMapping(properties);
        CXFServlet cxfServlet = new CXFServlet();
        ServletRegistrationBean registration = new ServletRegistrationBean(
                cxfServlet, urlMapping);
        CxfProperties.Servlet servletProperties = this.properties.getServlet();
        registration.setLoadOnStartup(servletProperties.getLoadOnStartup());
        for (Map.Entry<String, String> entry : servletProperties.getInit().entrySet()) {
            registration.addInitParameter(entry.getKey(), entry.getValue());
        }
        return registration;
    }

    private String getServiceMapping(CxfProperties cxfProperties) {
        String path = cxfProperties.getPath();
        return path.endsWith("/") ? path + "*" : path + "/*";
    }

    @Bean
    public FilterRegistrationBean webServiceFilterRegistration() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new OpenEntityManagerInViewFilter());
        filterRegistrationBean.addServletRegistrationBeans(cxfServletRegistration());
        filterRegistrationBean.setUrlPatterns(Lists.newArrayList(getServiceMapping(properties)));
        return filterRegistrationBean;
    }


    @Bean(name = "opu")
    public List<Endpoint> resServiceEndpoint() {
        EndpointImpl endpoint1 = new EndpointImpl(bus, trafficViolationService);
        endpoint1.publish("/trafficViolationService");

        EndpointImpl endpoint2 = new EndpointImpl(bus, identityWebserviceService);
        endpoint2.publish("/identityWebserviceService");

        EndpointImpl endpoint3 = new EndpointImpl(bus, layout());
        endpoint3.publish("/interface/test");

        List<Endpoint> endpoints = new ArrayList<Endpoint>();
        endpoints.add(endpoint1);
        endpoints.add(endpoint2);
        endpoints.add(endpoint3);
        return endpoints;
    }
}


