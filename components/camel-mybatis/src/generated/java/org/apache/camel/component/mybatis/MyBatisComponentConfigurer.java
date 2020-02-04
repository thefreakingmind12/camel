/* Generated by camel build tools - do NOT edit this file! */
package org.apache.camel.component.mybatis;

import org.apache.camel.CamelContext;
import org.apache.camel.spi.GeneratedPropertyConfigurer;
import org.apache.camel.support.component.PropertyConfigurerSupport;

/**
 * Generated by camel build tools - do NOT edit this file!
 */
@SuppressWarnings("unchecked")
public class MyBatisComponentConfigurer extends PropertyConfigurerSupport implements GeneratedPropertyConfigurer {

    @Override
    public boolean configure(CamelContext camelContext, Object target, String name, Object value, boolean ignoreCase) {
        if (ignoreCase) {
            return doConfigureIgnoreCase(camelContext, target, name, value);
        } else {
            return doConfigure(camelContext, target, name, value);
        }
    }

    private static boolean doConfigure(CamelContext camelContext, Object target, String name, Object value) {
        switch (name) {
        case "sqlSessionFactory": ((MyBatisComponent) target).setSqlSessionFactory(property(camelContext, org.apache.ibatis.session.SqlSessionFactory.class, value)); return true;
        case "configurationUri": ((MyBatisComponent) target).setConfigurationUri(property(camelContext, java.lang.String.class, value)); return true;
        case "basicPropertyBinding": ((MyBatisComponent) target).setBasicPropertyBinding(property(camelContext, boolean.class, value)); return true;
        case "lazyStartProducer": ((MyBatisComponent) target).setLazyStartProducer(property(camelContext, boolean.class, value)); return true;
        case "bridgeErrorHandler": ((MyBatisComponent) target).setBridgeErrorHandler(property(camelContext, boolean.class, value)); return true;
            default: return false;
        }
    }

    private static boolean doConfigureIgnoreCase(CamelContext camelContext, Object target, String name, Object value) {
        switch (name.toLowerCase()) {
        case "sqlsessionfactory": ((MyBatisComponent) target).setSqlSessionFactory(property(camelContext, org.apache.ibatis.session.SqlSessionFactory.class, value)); return true;
        case "configurationuri": ((MyBatisComponent) target).setConfigurationUri(property(camelContext, java.lang.String.class, value)); return true;
        case "basicpropertybinding": ((MyBatisComponent) target).setBasicPropertyBinding(property(camelContext, boolean.class, value)); return true;
        case "lazystartproducer": ((MyBatisComponent) target).setLazyStartProducer(property(camelContext, boolean.class, value)); return true;
        case "bridgeerrorhandler": ((MyBatisComponent) target).setBridgeErrorHandler(property(camelContext, boolean.class, value)); return true;
            default: return false;
        }
    }

}
