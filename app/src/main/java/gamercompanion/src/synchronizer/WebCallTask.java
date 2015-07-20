package gamercompanion.src.synchronizer;

import android.os.AsyncTask;

import com.google.common.base.Strings;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.io.InputStream;

import gamercompanion.src.utils.Unit;
import gamercompanion.src.utils.tryUtil.Try;

import static gamercompanion.src.error.ErrorUtil.*;

/**
 * Implements the rest call to a website
 */
public class WebCallTask extends AsyncTask<Void, Void, String> {

    public WebCall _webCall;

    public WebCallTask(WebCall webCall)
    {
        _webCall = webCall;
    }

    protected String getASCIIContentFromEntity(HttpEntity entity) throws IllegalStateException, IOException {
        InputStream in = entity.getContent();
        StringBuffer out = new StringBuffer();
        int n = 1;
        while (n>0) {
            byte[] b = new byte[4096];
            n =  in.read(b);
            if (n>0) out.append(new String(b, 0, n));
        }
        return out.toString();
    }


    @Override
    protected String doInBackground(Void... params) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpContext localContext = new BasicHttpContext();

        HttpGet httpGet = new HttpGet(_webCall.getUrl());
        String text = null;
        try {
            Synchronizer.registerTask();
            HttpResponse response = httpClient.execute(httpGet, localContext);

            HttpEntity entity = response.getEntity();

            text = getASCIIContentFromEntity(entity);

        } catch (Exception e) {
            return e.getLocalizedMessage();
        }
        finally {
            httpClient.getConnectionManager().shutdown();
        }
        return text;
    }

    protected void onPostExecute(String results) {
        if (!Strings.isNullOrEmpty(results)) {
            Try<Unit> unitTry = _webCall.computeResult(results);
            if(!unitTry.isSuccess())
            {
                showWarning("the webcall "+_webCall.getUrl()+" failed!: "+unitTry.failure().getMessage());
            }
            Synchronizer.finishTask();
        }
        else
        {
            showWarning("the webcall "+_webCall.getUrl()+" failed!");
        }
    }
}