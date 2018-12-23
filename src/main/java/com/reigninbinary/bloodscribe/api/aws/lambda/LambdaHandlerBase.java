package com.reigninbinary.bloodscribe.api.aws.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.reigninbinary.cloud.aws.lambda.LambdaProxyHandler;
import com.reigninbinary.cloud.aws.lambda.LambdaProxyHandlerFactory;
import com.reigninbinary.cloud.aws.lambda.LambdaProxyHandlerImpl;
import com.reigninbinary.cloud.aws.lambda.LambdaProxyInput;
import com.reigninbinary.cloud.aws.lambda.LambdaProxyOutput;


public abstract class LambdaHandlerBase
				extends LambdaProxyHandlerImpl 
				implements LambdaProxyHandler, LambdaProxyHandlerFactory {

	public LambdaHandlerBase() {
		
		setHandlerFactory(this);
	}

	@Override
	public LambdaProxyHandler getHandler(LambdaProxyInput input) throws Exception {

		return this;
	}
	
	@Override
	public abstract LambdaProxyOutput handleRequest(LambdaProxyInput lambdaProxyInput, Context context) throws Exception;
}
