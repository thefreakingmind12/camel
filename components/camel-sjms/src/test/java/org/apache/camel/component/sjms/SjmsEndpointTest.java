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
package org.apache.camel.component.sjms;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.ExchangePattern;
import org.apache.camel.ResolveEndpointFailedException;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class SjmsEndpointTest extends CamelTestSupport {

    @Override
    protected boolean useJmx() {
        return true;
    }

    @Test
    public void testDefaults() throws Exception {
        Endpoint endpoint = context.getEndpoint("sjms:test");
        assertNotNull(endpoint);
        assertTrue(endpoint instanceof SjmsEndpoint);
        SjmsEndpoint sjms = (SjmsEndpoint) endpoint;
        assertEquals(sjms.getEndpointUri(), "sjms://test");
        assertEquals(sjms.createExchange().getPattern(), ExchangePattern.InOnly);
    }

    @Test
    public void testQueueEndpoint() throws Exception {
        Endpoint sjms = context.getEndpoint("sjms:queue:test");
        assertNotNull(sjms);
        assertEquals(sjms.getEndpointUri(), "sjms://queue:test");
        assertTrue(sjms instanceof SjmsEndpoint);
    }

    @Test
    public void testJndiStyleEndpointName() throws Exception {
        SjmsEndpoint sjms = context.getEndpoint("sjms:/jms/test/hov.t1.dev:topic", SjmsEndpoint.class);
        assertNotNull(sjms);
        assertFalse(sjms.isTopic());
        assertEquals("/jms/test/hov.t1.dev:topic", sjms.getDestinationName());
    }

    @Test
    public void testSetTransacted() throws Exception {
        Endpoint endpoint = context.getEndpoint("sjms:queue:test?transacted=true");
        assertNotNull(endpoint);
        assertTrue(endpoint instanceof SjmsEndpoint);
        SjmsEndpoint qe = (SjmsEndpoint) endpoint;
        assertTrue(qe.isTransacted());
    }

    @Test
    public void testAsyncProducer() throws Exception {
        Endpoint endpoint = context.getEndpoint("sjms:queue:test?synchronous=true");
        assertNotNull(endpoint);
        assertTrue(endpoint instanceof SjmsEndpoint);
        SjmsEndpoint qe = (SjmsEndpoint) endpoint;
        assertTrue(qe.isSynchronous());
    }

    @Test
    public void testReplyTo() throws Exception {
        String replyTo = "reply.to.queue";
        Endpoint endpoint = context.getEndpoint("sjms:queue:test?replyTo=" + replyTo);
        assertNotNull(endpoint);
        assertTrue(endpoint instanceof SjmsEndpoint);
        SjmsEndpoint qe = (SjmsEndpoint) endpoint;
        assertEquals(qe.getReplyTo(), replyTo);
        assertEquals(qe.createExchange().getPattern(), ExchangePattern.InOut);
    }

    @Test
    public void testDefaultExchangePattern() throws Exception {
        try {
            SjmsEndpoint sjms = (SjmsEndpoint) context.getEndpoint("sjms:queue:test");
            assertNotNull(sjms);
            assertEquals(ExchangePattern.InOnly, sjms.getExchangePattern());
            // assertTrue(sjms.createExchange().getPattern().equals(ExchangePattern.InOnly));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getLocalizedMessage());
        }
    }

    @Test
    public void testInOnlyExchangePattern() throws Exception {
        try {
            Endpoint sjms = context.getEndpoint("sjms:queue:test?exchangePattern=" + ExchangePattern.InOnly);
            assertNotNull(sjms);
            assertTrue(sjms.createExchange().getPattern().equals(ExchangePattern.InOnly));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getLocalizedMessage());
        }
    }

    @Test
    public void testInOutExchangePattern() throws Exception {
        try {
            Endpoint sjms = context.getEndpoint("sjms:queue:test?exchangePattern=" + ExchangePattern.InOut);
            assertNotNull(sjms);
            assertTrue(sjms.createExchange().getPattern().equals(ExchangePattern.InOut));
        } catch (Exception e) {
            fail("Exception thrown: " + e.getLocalizedMessage());
        }
    }

    @Test
    public void testUnsupportedMessageExchangePattern() throws Exception {
        assertThrows(ResolveEndpointFailedException.class,
                () -> context.getEndpoint("sjms:queue:test2?messageExchangePattern=OutOnly"));
    }

    @Test
    public void testReplyToAndMEPMatch() throws Exception {
        String replyTo = "reply.to.queue";
        Endpoint endpoint = context
                .getEndpoint("sjms:queue:test?replyTo=" + replyTo + "&exchangePattern=" + ExchangePattern.InOut);
        assertNotNull(endpoint);
        assertTrue(endpoint instanceof SjmsEndpoint);
        SjmsEndpoint qe = (SjmsEndpoint) endpoint;
        assertEquals(qe.getReplyTo(), replyTo);
        assertEquals(qe.createExchange().getPattern(), ExchangePattern.InOut);
    }

    @Test
    public void testDestinationName() throws Exception {
        Endpoint endpoint = context.getEndpoint("sjms:queue:test?synchronous=true");
        assertNotNull(endpoint);
        assertTrue(endpoint instanceof SjmsEndpoint);
        SjmsEndpoint qe = (SjmsEndpoint) endpoint;
        assertTrue(qe.isSynchronous());
    }

    @Override
    protected CamelContext createCamelContext() throws Exception {
        CamelContext camelContext = super.createCamelContext();

        ActiveMQConnectionFactory connectionFactory
                = new ActiveMQConnectionFactory("vm://broker?broker.persistent=false&broker.useJmx=false");
        SjmsComponent component = new SjmsComponent();
        component.setConnectionFactory(connectionFactory);
        camelContext.addComponent("sjms", component);

        return camelContext;
    }
}
