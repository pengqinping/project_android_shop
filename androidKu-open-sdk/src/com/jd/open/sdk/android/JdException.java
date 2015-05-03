/*
 * Copyright 2012 360buy, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jd.open.sdk.android;

/**
 * JingDong Exception封装
 */
public class JdException extends Throwable {

	/**
	 * @author Administrator / Never give up, adhere to in the end.
	 * email: pengqinping@gmail.com
	 */
	private static final long serialVersionUID = 8628776606807389260L;
	
	//请求过程中网络错误，
	public static final int ERRORCODE_RESQUEST_NETWORK_ERROR = 100;
	
	//返回结果格式错误，
	public static final int ERRORCODE_RESPONSE_FORMAT_ERROR = 101;
	
	
	private int mErrorCode = 0;

	public JdException(String message) {
		super(message);
	}

	public JdException(String message, int code) {
		super(message);
		mErrorCode = code;
	}

	public int getErrorCode() {
		return mErrorCode;
	}
}

