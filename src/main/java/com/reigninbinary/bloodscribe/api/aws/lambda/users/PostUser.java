package com.reigninbinary.bloodscribe.api.aws.lambda.users;

import com.amazonaws.services.lambda.runtime.Context;
import com.google.gson.Gson;
import com.reigninbinary.bloodscribe.api.UserApi;
import com.reigninbinary.bloodscribe.api.aws.lambda.LambdaHandlerBase;
import com.reigninbinary.bloodscribe.db.dto.User;
import com.reigninbinary.cloud.aws.lambda.LambdaProxyInput;
import com.reigninbinary.cloud.aws.lambda.LambdaProxyOutput;

public class PostUser extends LambdaHandlerBase {

	@Override
	public LambdaProxyOutput handleRequest(LambdaProxyInput lambdaProxyInput, Context context) throws Exception {

		User user = new Gson().fromJson(lambdaProxyInput.getBody(), User.class);
		
		new UserApi().saveUser(user);
		
		return new LambdaProxyOutput(new Gson().toJson(user));
	}
}
