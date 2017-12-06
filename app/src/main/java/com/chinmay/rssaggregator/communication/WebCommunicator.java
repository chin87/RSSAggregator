package com.chinmay.rssaggregator.communication;

import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import java.util.concurrent.Executors;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by chinmaydeshpande on 06/12/17.
 */

public class WebCommunicator {
	private static Retrofit mRetrofit;
	private static final String mEndpoint = "http://";
	private static Retrofit getRetrofitBuilder(){
		if( mRetrofit == null ){
			mRetrofit = new Retrofit.Builder()
					.baseUrl(mEndpoint)
					.client(new OkHttpClient())
					.addConverterFactory(
							SimpleXmlConverterFactory.createNonStrict(
									new Persister(new AnnotationStrategy()
									)
							)
					)
					.callbackExecutor(Executors.newSingleThreadExecutor())
					.build();
		}
		return mRetrofit;
	}

	private void fetchFeed(String url){
		Retrofit retrofit = getRetrofitBuilder();
	}

}
