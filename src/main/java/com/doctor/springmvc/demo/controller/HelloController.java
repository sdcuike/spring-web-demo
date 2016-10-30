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
package com.doctor.springmvc.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.doctor.springmvc.extend.RequestDecryptBody;
import com.doctor.springmvc.extend.ResponseEncryptBody;

/**
 * @author sdcuike
 *
 *         Created At 2016年8月28日 下午11:44:00
 */
@Controller
@RequestMapping(value = "/app", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
public class HelloController {

    @RequestMapping(value = "/hello", method = { RequestMethod.POST })
    @ResponseBody
    public String hello() {
        return "hello web";
    }

    @RequestMapping(value = "/hello1", method = { RequestMethod.POST })
    @ResponseBody
    public Message hello1(@RequestDecryptBody Message message) {
        return message;
    }

    @RequestMapping(value = "/hello2", method = { RequestMethod.POST })
    @ResponseEncryptBody
    public Message hello2(@RequestDecryptBody Message message) {
        return message;
    }

    @RequestMapping(value = "/hello3", method = { RequestMethod.POST })
    @ResponseEncryptBody
    public Message hello3(@RequestBody Message message) {
        return message;
    }

    @RequestMapping(value = "/hello4", method = { RequestMethod.POST })
    @ResponseEncryptBody
    public Map<String, Object> hello4(@RequestDecryptBody Map<String, Object> message) {
        return message;
    }

    @RequestMapping(value = "/hello5", method = { RequestMethod.POST })
    @ResponseEncryptBody
    public List<Object> hello5(@RequestDecryptBody List<Object> message) {
        return message;
    }

    public static class Message {
        private String name;
        private int    age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return JSON.toJSONString(this);
        }
    }
}
