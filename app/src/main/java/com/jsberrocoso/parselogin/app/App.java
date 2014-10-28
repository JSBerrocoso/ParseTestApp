package com.jsberrocoso.parselogin.app;
/**
 * Created by jsberrocoso on 28/10/14.
 */


import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class App extends Application {

    private String APPLICATION_ID    = "yourApplicationID";
    private String CLIENT_KEY       = "H6mLVGPVz8v7TaTkXODDawsHV2nYpb5QgNzddhnB";


    public void onCreate() {
        Parse.initialize(this, APPLICATION_ID, CLIENT_KEY);

        // Not implement here!! Only Sample
        createSampleObject();

        // Not Implement here!! Only sample
        loginSample();
    }

    private void loginSample() {
        ParseUser user = new ParseUser();
        user.setUsername("my name");
        user.setPassword("my pass");
        user.setEmail("email@example.com");

// other fields can be set just like with ParseObject
        user.put("phone", "650-555-0000");

        user.signUpInBackground(new SignUpCallback() {

            @Override
            public void done(com.parse.ParseException e) {
                if (e == null) {
                    // Hooray! Let them use the app now.
                } else {
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                }
            }
        });

    }

    private void createSampleObject() {
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("fooFromApp", "barFromApp");
        testObject.saveInBackground();
    }


}
