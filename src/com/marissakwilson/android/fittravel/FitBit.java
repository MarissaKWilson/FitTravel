package com.marissakwilson.android.fittravel;



public class FitBit{
	
	private int mDistance;
	private boolean mUserMetric;
	private int mStrideLength;
	
	public int getDistance() {
		return mDistance;
	}

	public boolean isUserMetric() {
		return mUserMetric;
	}

	public int getStrideLength() {
		return mStrideLength;
	}

	//Temp values until OAuth is working
	public FitBit() {
		mDistance = 3012;
		mUserMetric = true;
		mStrideLength = 55;
	}

//	@Override
//	protected Object doInBackground(Object... arg0) {
//
//		// Instantiate the Choreo, using a previously instantiated TembooSession object, eg:
//		 TembooSession session;
//		try {
//			session = new TembooSession("mkw4262", "myFirstApp", "8334b7cfdf2247cda198b5e9e0ef60e8");
//		
//
//		InitializeOAuth initializeOAuthChoreo = new InitializeOAuth(session);
//
//		// Get an InputSet object for the choreo
//		InitializeOAuthInputSet initializeOAuthInputs = initializeOAuthChoreo.newInputSet();
//
//		// Set inputs
//		initializeOAuthInputs.set_ConsumerSecret("7d3b4bf3fae84867951f5c3f2c9d97e1");
//		initializeOAuthInputs.set_ConsumerKey("be70df3c413b4154b72498c4e0f56936");
//
//		// Execute Choreo
//		InitializeOAuthResultSet initializeOAuthResults = initializeOAuthChoreo.execute(initializeOAuthInputs);
//		
//		// Instantiate the Choreo, using a previously instantiated TembooSession object, eg:
//		// TembooSession session = new TembooSession("mkw4262", "myFirstApp", "8334b7cfdf2247cda198b5e9e0ef60e8");
//
//		FinalizeOAuth finalizeOAuthChoreo = new FinalizeOAuth(session);
//
//		// Get an InputSet object for the choreo
//		FinalizeOAuthInputSet finalizeOAuthInputs = finalizeOAuthChoreo.newInputSet();
//
//		// Set inputs
//		finalizeOAuthInputs.set_CallbackID("7ce82936-bac7-431f-974a-481589169c62");
//		finalizeOAuthInputs.set_OAuthTokenSecret("eb679c2ad71b370e4ab0817966e24111");
//		finalizeOAuthInputs.set_ConsumerSecret("7d3b4bf3fae84867951f5c3f2c9d97e1");
//		finalizeOAuthInputs.set_ConsumerKey("be70df3c413b4154b72498c4e0f56936");
//
//		// Execute Choreo
//		FinalizeOAuthResultSet finalizeOAuthResults = finalizeOAuthChoreo.execute(finalizeOAuthInputs);
//		} catch (TembooException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}

}
