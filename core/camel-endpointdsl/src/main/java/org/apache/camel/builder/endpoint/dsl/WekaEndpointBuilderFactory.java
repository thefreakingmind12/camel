/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.builder.endpoint.dsl;

import javax.annotation.Generated;
import org.apache.camel.builder.EndpointConsumerBuilder;
import org.apache.camel.builder.EndpointProducerBuilder;
import org.apache.camel.builder.endpoint.AbstractEndpointBuilder;

/**
 * The camel-weka component provides Data Mining functionality through Weka.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.maven.packaging.EndpointDslMojo")
public interface WekaEndpointBuilderFactory {


    /**
     * Builder for endpoint for the Weka component.
     */
    public interface WekaEndpointBuilder extends EndpointProducerBuilder {
        default AdvancedWekaEndpointBuilder advanced() {
            return (AdvancedWekaEndpointBuilder) this;
        }
        /**
         * The Weka filter/classifier spec (i.e. Name Options).
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: producer
         */
        default WekaEndpointBuilder apply(String apply) {
            doSetProperty("apply", apply);
            return this;
        }
        /**
         * Whether the producer should be started lazy (on the first message).
         * By starting lazy you can use this to allow CamelContext and routes to
         * startup in situations where a producer may otherwise fail during
         * starting and cause the route to fail being started. By deferring this
         * startup to be lazy then the startup failure can be handled during
         * routing messages via Camel's routing error handlers. Beware that when
         * the first message is processed then creating and starting the
         * producer may take a little time and prolong the total processing time
         * of the processing.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Default: false
         * Group: producer
         */
        default WekaEndpointBuilder lazyStartProducer(boolean lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
        /**
         * Whether the producer should be started lazy (on the first message).
         * By starting lazy you can use this to allow CamelContext and routes to
         * startup in situations where a producer may otherwise fail during
         * starting and cause the route to fail being started. By deferring this
         * startup to be lazy then the startup failure can be handled during
         * routing messages via Camel's routing error handlers. Beware that when
         * the first message is processed then creating and starting the
         * producer may take a little time and prolong the total processing time
         * of the processing.
         * 
         * The option will be converted to a <code>boolean</code> type.
         * 
         * Default: false
         * Group: producer
         */
        default WekaEndpointBuilder lazyStartProducer(String lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
        /**
         * An optional in/out path for the read/write commands.
         * 
         * The option is a: <code>java.lang.String</code> type.
         * 
         * Group: producer
         */
        default WekaEndpointBuilder path(String path) {
            doSetProperty("path", path);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint for the Weka component.
     */
    public interface AdvancedWekaEndpointBuilder
            extends
                EndpointProducerBuilder {
        default WekaEndpointBuilder basic() {
            return (WekaEndpointBuilder) this;
        }
        /**
         * Whether the endpoint should use basic property binding (Camel 2.x) or
         * the newer property binding with additional capabilities.
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Default: false
         * Group: advanced
         */
        default AdvancedWekaEndpointBuilder basicPropertyBinding(
                boolean basicPropertyBinding) {
            doSetProperty("basicPropertyBinding", basicPropertyBinding);
            return this;
        }
        /**
         * Whether the endpoint should use basic property binding (Camel 2.x) or
         * the newer property binding with additional capabilities.
         * 
         * The option will be converted to a <code>boolean</code> type.
         * 
         * Default: false
         * Group: advanced
         */
        default AdvancedWekaEndpointBuilder basicPropertyBinding(
                String basicPropertyBinding) {
            doSetProperty("basicPropertyBinding", basicPropertyBinding);
            return this;
        }
        /**
         * Sets whether synchronous processing should be strictly used, or Camel
         * is allowed to use asynchronous processing (if supported).
         * 
         * The option is a: <code>boolean</code> type.
         * 
         * Default: false
         * Group: advanced
         */
        default AdvancedWekaEndpointBuilder synchronous(boolean synchronous) {
            doSetProperty("synchronous", synchronous);
            return this;
        }
        /**
         * Sets whether synchronous processing should be strictly used, or Camel
         * is allowed to use asynchronous processing (if supported).
         * 
         * The option will be converted to a <code>boolean</code> type.
         * 
         * Default: false
         * Group: advanced
         */
        default AdvancedWekaEndpointBuilder synchronous(String synchronous) {
            doSetProperty("synchronous", synchronous);
            return this;
        }
    }

    public interface WekaBuilders {
        /**
         * Weka (camel-weka)
         * The camel-weka component provides Data Mining functionality through
         * Weka.
         * 
         * Category: Datamining
         * Since: 3.1
         * Maven coordinates: org.apache.camel:camel-weka
         * 
         * Syntax: <code>weka:cmd</code>
         * 
         * Path parameter: filter
         * The filter command
         * 
         * Path parameter: version
         * The version command
         */
        default WekaEndpointBuilder weka(String path) {
            return WekaEndpointBuilderFactory.weka(path);
        }
    }
    /**
     * Weka (camel-weka)
     * The camel-weka component provides Data Mining functionality through Weka.
     * 
     * Category: Datamining
     * Since: 3.1
     * Maven coordinates: org.apache.camel:camel-weka
     * 
     * Syntax: <code>weka:cmd</code>
     * 
     * Path parameter: filter
     * The filter command
     * 
     * Path parameter: version
     * The version command
     */
    static WekaEndpointBuilder weka(String path) {
        class WekaEndpointBuilderImpl extends AbstractEndpointBuilder implements WekaEndpointBuilder, AdvancedWekaEndpointBuilder {
            public WekaEndpointBuilderImpl(String path) {
                super("weka", path);
            }
        }
        return new WekaEndpointBuilderImpl(path);
    }
}