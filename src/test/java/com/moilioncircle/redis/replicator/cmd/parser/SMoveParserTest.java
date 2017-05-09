/*
 * Copyright 2016 leon chen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.moilioncircle.redis.replicator.cmd.parser;

import com.moilioncircle.redis.replicator.cmd.impl.SMoveCommand;
import com.moilioncircle.redis.replicator.cmd.impl.SwapDBCommand;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Leon Chen
 * @since 2.1.0
 */
public class SMoveParserTest {
    @Test
    public void parse() throws Exception {
        SMoveParser parser = new SMoveParser();
        SMoveCommand cmd = parser.parse("smove src des field".split(" "));
        assertEquals("src", cmd.getSource());
        assertEquals("des", cmd.getDestination());
        assertEquals("field", cmd.getMember());
        System.out.println(cmd);

        {
            SwapDBParser parser1 = new SwapDBParser();
            SwapDBCommand cmd1 = parser1.parse("swapdb 0 1".split(" "));
            assertEquals(0, cmd1.getSource());
            assertEquals(1, cmd1.getTarget());
            System.out.println(cmd1);
        }
    }

}