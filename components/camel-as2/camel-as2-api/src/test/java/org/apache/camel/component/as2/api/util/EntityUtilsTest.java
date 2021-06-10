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
package org.apache.camel.component.as2.api.util;

import org.apache.camel.component.as2.api.AS2Charset;
import org.apache.camel.component.as2.api.AS2MediaType;
import org.apache.camel.component.as2.api.entity.ApplicationEDIEntity;
import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EntityUtilsTest {

    @Test
    public void testCreateEDIEntityContentTypeWithoutEncoding() throws Exception {
        ContentType ediMessageContentType = ContentType.create(AS2MediaType.APPLICATION_EDIFACT, (String) null);
        String ediMessage = "whatever";
        ApplicationEDIEntity applicationEDIEntity = EntityUtils.createEDIEntity(ediMessage, ediMessageContentType, null, false);
        String actualContentType = applicationEDIEntity.getContentTypeValue();
        Assertions.assertEquals("application/edifact", actualContentType, "content type matches");
    }

    @Test
    public void testCreateEDIEntityContentTypeWithEncoding() throws Exception {
        ContentType ediMessageContentType = ContentType.create(AS2MediaType.APPLICATION_EDIFACT, AS2Charset.US_ASCII);
        String ediMessage = "whatever";
        ApplicationEDIEntity applicationEDIEntity = EntityUtils.createEDIEntity(ediMessage, ediMessageContentType, null, false);
        String actualContentType = applicationEDIEntity.getContentTypeValue();
        Assertions.assertEquals("application/edifact; charset=US-ASCII", actualContentType, "content type matches");
    }
}
