package gamercompanion.src.utils.webCall;

import android.os.AsyncTask;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by dklemm on 11.06.15.
 */
public class MetaScoreAllGetIO {//extends AsyncTask<Void, Void, String> {

//    public Platforms _platform;
//    public UrlCall _urlCall;
//    public MainActivity _mainActivity;
//    public String _add;
//
//    public MetaScoreAllGetIO(Platforms platform, MainActivity mainActivity, UrlCall urlCall, String add)
//    {
//        _platform = platform;
//        _mainActivity = mainActivity;
//        _urlCall = urlCall;
//        _add = add;
//    }
//
//    protected String getASCIIContentFromEntity(HttpEntity entity) throws IllegalStateException, IOException {
//        InputStream in = entity.getContent();
//        StringBuffer out = new StringBuffer();
//        int n = 1;
//        while (n>0) {
//            byte[] b = new byte[4096];
//            n =  in.read(b);
//            if (n>0) out.append(new String(b, 0, n));
//        }
//        return out.toString();
//    }
//
//
//    @Override
//    protected String doInBackground(Void... params) {
//        HttpClient httpClient = new DefaultHttpClient();
//        HttpContext localContext = new BasicHttpContext();
//        String url = URLParser.getUrl(_urlCall, _add);
//
//        HttpGet httpGet = new HttpGet(url);
//        String text = null;
//        try {
//            HttpResponse response = httpClient.execute(httpGet, localContext);
//
//            HttpEntity entity = response.getEntity();
//
//            text = getASCIIContentFromEntity(entity);
//
//        } catch (Exception e) {
//            return e.getLocalizedMessage();
//        }
//        finally {
//            httpClient.getConnectionManager().shutdown();
//        }
//        return text;
//    }
//
//    protected void onPostExecute(String results) {
//        if (results!=null) {
//            GameObjectManager._games = ParsingOperations.parseScores(_platform, results);
//            ArrayList<String> inputList = new ArrayList<String>();
//            for(GameObject item : GameObjectManager._games)
//            {
//                inputList.add(item.toString());
//            }
//
//            StableArrayAdapter listAdapter = new StableArrayAdapter(_mainActivity,
//                    android.R.layout.simple_list_item_1, inputList);
//            MainActivity._listView.setAdapter(listAdapter);
//        }
//    }
}