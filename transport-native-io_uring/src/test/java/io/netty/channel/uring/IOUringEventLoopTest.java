/*
 * Copyright 2020 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.channel.uring;

import io.netty.channel.EventLoop;
import org.junit.Test;

public class IOUringEventLoopTest {

    @Test
    public void testSubmitMultipleTasksAndEnsureTheseAreExecuted() throws Exception {
        IOUringEventLoopGroup group = new IOUringEventLoopGroup(1);
        try {
            EventLoop loop = group.next();
            loop.submit(new Runnable() {
                @Override
                public void run() {
                }
            }).sync();

            loop.submit(new Runnable() {
                @Override
                public void run() {
                }
            }).sync();
            loop.submit(new Runnable() {
                @Override
                public void run() {
                }
            }).sync();
            loop.submit(new Runnable() {
                @Override
                public void run() {
                }
            }).sync();
        } finally {
            group.shutdownGracefully();
        }
    }
}