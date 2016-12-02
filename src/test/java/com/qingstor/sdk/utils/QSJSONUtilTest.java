// +-------------------------------------------------------------------------
// | Copyright (C) 2016 Yunify, Inc.
// +-------------------------------------------------------------------------
// | Licensed under the Apache License, Version 2.0 (the "License");
// | you may not use this work except in compliance with the License.
// | You may obtain a copy of the License in the LICENSE file, or at:
// |
// | http://www.apache.org/licenses/LICENSE-2.0
// |
// | Unless required by applicable law or agreed to in writing, software
// | distributed under the License is distributed on an "AS IS" BASIS,
// | WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// | See the License for the specific language governing permissions and
// | limitations under the License.
// +-------------------------------------------------------------------------

package com.qingstor.sdk.utils;

import com.qingstor.sdk.service.Bucket;

import static org.junit.Assert.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class QSJSONUtilTest {

	@Test
	public void testJson() {
		JSONObject convertObj = QSJSONUtil.convertJSONObject("{'testString':'test','testInt':123,'testList':[{'test':'test'}]}");
		Assert.assertEquals(QSJSONUtil.toString(convertObj,"testString"),"test");
		Assert.assertEquals(QSJSONUtil.toInt(convertObj,"testInt"),123);
		Assert.assertEquals(QSJSONUtil.toObject(convertObj,"testList").getClass().getName(),"org.json.JSONArray");
	}


	@Test
	public void testFillValueJson() {
		ParamTestModel output = new ParamTestModel();
		QSJSONUtil.jsonFillValue2Object("{'action':'testowner','instance_set':[{'description':'testgrantee'}]}",output);
		Assert.assertEquals(output.getAction(),"testowner");
		Assert.assertEquals(output.getInstanceSet().get(0).getDescription(),"testgrantee");
	}

}