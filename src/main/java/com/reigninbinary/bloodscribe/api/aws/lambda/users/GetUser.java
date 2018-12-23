package com.reigninbinary.bloodscribe.api.aws.lambda.users;

import com.amazonaws.services.lambda.runtime.Context;

import com.google.gson.Gson;
import com.reigninbinary.bloodscribe.api.UserApi;
import com.reigninbinary.bloodscribe.api.aws.lambda.LambdaHandlerBase;
import com.reigninbinary.bloodscribe.db.dto.User;
import com.reigninbinary.cloud.aws.lambda.LambdaProxyInput;
import com.reigninbinary.cloud.aws.lambda.LambdaProxyOutput;


public class GetUser extends LambdaHandlerBase {
	
	@Override
	public LambdaProxyOutput handleRequest(LambdaProxyInput lambdaProxyInput, Context context) throws Exception {
		
		int idUser = Integer.parseInt(lambdaProxyInput.getPathParam("userid"));

		User user = new UserApi().getUserById(idUser);
		
		return new LambdaProxyOutput(new Gson().toJson(user));
	}
}
