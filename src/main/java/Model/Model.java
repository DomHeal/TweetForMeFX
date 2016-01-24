package Model;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

import java.awt.*;
import java.io.*;
import java.net.URL;

/**
 * Created by Dominic on 21-Jan-16.
 */
public class Model {
    public static Twitter twitter;
    public void connect(){
        final ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("rloRoElkRb5suH6Kck7PjgqCo")
                .setOAuthConsumerSecret("lZbvN35xEyioaxCT3fRnxSRmrzMcnjRAGxkVz40NzFbgRIaHsY");

        try {
            final TwitterFactory tf = new TwitterFactory(cb.build());
            twitter = tf.getInstance();

            AccessToken accessToken = null;
            RequestToken requestToken = twitter.getOAuthRequestToken();
                /* Opens up the URL in default browser set be user */
            try {
                Desktop.getDesktop().browse(new URL(requestToken.getAuthorizationURL()).toURI());
            } catch (final Exception e) {
                //TO-DO
            }
        } catch (TwitterException te) {
            te.printStackTrace();
        }
    }
    public void postTweet(String msg){
        Status status = null;
        try {
            status = twitter.updateStatus(msg);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully updated the status to [" + status.getText() + "].");
    }



}
