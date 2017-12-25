/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.kylin.source.jdbc;

import java.sql.Types;

import org.junit.Assert;
import org.junit.Test;

public class SqlUtilTest {

    @Test
    public void testJdbcTypetoKylinDataType() {
        this.getClass().getClassLoader().toString();
        Assert.assertEquals("double", SqlUtil.jdbcTypetoKylinDataType(Types.FLOAT));
        Assert.assertEquals("varchar", SqlUtil.jdbcTypetoKylinDataType(Types.NVARCHAR));
        Assert.assertEquals("any", SqlUtil.jdbcTypetoKylinDataType(Types.ARRAY));
    }

    @Test
    public void testIsPrecisionApplicable() {
        Assert.assertFalse(SqlUtil.isPrecisionApplicable("boolean"));
        Assert.assertTrue(SqlUtil.isPrecisionApplicable("varchar"));
    }

    @Test
    public void testIsScaleApplicable() {
        Assert.assertFalse(SqlUtil.isScaleApplicable("varchar"));
        Assert.assertTrue(SqlUtil.isScaleApplicable("decimal"));
    }
}