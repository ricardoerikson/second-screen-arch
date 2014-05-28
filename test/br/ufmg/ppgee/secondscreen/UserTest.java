package br.ufmg.ppgee.secondscreen;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {

    @Test
    public void testNewUser() {
	HttpURLConnection conn = null;
	int responseCode = 0;
	try {
	    URL url = new URL("http://localhost:8888/user/new");
	    Map<String, Object> params = new HashMap<String, Object>();
	    params.put("username", "user1");
	    params.put("password", "abcdef");
	    byte[] postData = paramsToBytes(params);
	    conn = (HttpURLConnection) url.openConnection();
	    conn.setRequestMethod("POST");
	    conn.setRequestProperty("Content-Type",
		    "application/x-www-form-urlencoded");
	    conn.setRequestProperty("Content-Length",
		    String.valueOf(postData.length));
	    conn.setDoOutput(true);

	    DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
	    wr.write(postData);
	    wr.flush();
	    wr.close();
	} catch (MalformedURLException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {
		responseCode = conn.getResponseCode();
		conn.disconnect();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
	Assert.assertEquals(responseCode, 200);
    }

    public byte[] paramsToBytes(Map<String, Object> params)
	    throws UnsupportedEncodingException {
	StringBuilder postData = new StringBuilder();
	for (Map.Entry<String, Object> param : params.entrySet()) {
	    if (postData.length() != 0)
		postData.append("&");
	    postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
	    postData.append("=");
	    postData.append(URLEncoder.encode(String.valueOf(param.getValue()),
		    "UTF-8"));
	}
	return postData.toString().getBytes("UTF-8");
    }

}
