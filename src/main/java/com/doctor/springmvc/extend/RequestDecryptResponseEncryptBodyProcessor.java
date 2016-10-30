/*
 * Copyright 2016    https://github.com/sdcuike Inc. 
 * All rights reserved.
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.doctor.springmvc.extend;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;

/**
 * @author sdcuike
 *
 *         Created At 2016年10月26日 下午11:59:07
 */
public abstract class RequestDecryptResponseEncryptBodyProcessor {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    public final String decryptRequestBody(HttpInputMessage inputMessage, Charset charset) throws IOException {
        InputStream inputStream = inputMessage.getBody();
        String input = IOUtils.toString(inputStream, charset);
        HttpHeaders httpHeaders = inputMessage.getHeaders();
        return doDecryptRequestBody(input, httpHeaders, charset);
    }

    public final String encryptResponseBody(String input, HttpHeaders httpHeaders, Charset charset) {
        return doEncryptResponseBody(input, httpHeaders, charset);
    }

    protected String doDecryptRequestBody(String input, HttpHeaders httpHeaders, Charset charset) {
        return input;
    }

    protected String doEncryptResponseBody(String input, HttpHeaders httpHeaders, Charset charset) {
        return input;
    }

}
