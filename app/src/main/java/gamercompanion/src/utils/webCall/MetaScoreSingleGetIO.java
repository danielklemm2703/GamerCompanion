package gamercompanion.src.utils.webCall;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.io.InputStream;

import gamercompanion.src.utils.webCall.imageLoader.ImageLoader;

//TODO refactor
public class MetaScoreSingleGetIO {//extends AsyncTask<Void, Void, String> {

//    public Platforms _platform;
//    public UrlCall _urlCall;
//    public Activity _activity;
//    public String _add;
//
//    public MetaScoreSingleGetIO(Platforms platform, Activity activity, UrlCall urlCall, String add)
//    {
//        _platform = platform;
//        _activity = activity;
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
//
//        String url = URLParser.getUrl(_urlCall, _add);
//        HttpGet httpGet = new HttpGet(url);
//        String text = null;
//        try {
//            HttpResponse response = httpClient.execute(httpGet, localContext);
//            HttpEntity entity = response.getEntity();
//            text = getASCIIContentFromEntity(entity);
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
//            ExtendedGameObject extendedGameObject = ParsingOperations.parseExtendedGameObject(DetailsActivity._game, results);
//
//            TextView title = (TextView)_activity.findViewById(DetailsActivity.TITLE_TEXT_ID);
//            title.setText(extendedGameObject.getName());
//            title.setTextSize((float) 24);
//            title.setTypeface(null, Typeface.BOLD);
//            Utils.layoutAddElement(title, RelativeLayout.ALIGN_PARENT_TOP, 20, 20, 20, 20);
//
//            TextView developer = (TextView)_activity.findViewById(DetailsActivity.DEVELOPER_TEXT_ID);
//            developer.setText(extendedGameObject.get_developer());
//            Utils.layoutAddElement(developer, RelativeLayout.ALIGN_PARENT_RIGHT, 20, 230, 20, 230);
//
//            TextView metaScore = (TextView)_activity.findViewById(DetailsActivity.METASCORE_TEXT_ID);
//            metaScore.setText("" + extendedGameObject.getMetascore());
//            Utils.layoutAddElement(metaScore, RelativeLayout.ALIGN_PARENT_RIGHT, 20, 330, 20, 330);
//
//            TextView releaseDate = (TextView)_activity.findViewById(DetailsActivity.RELEASE_DATE_TEXT_ID);
//            releaseDate.setText(extendedGameObject.get_releaseDate());
//            Utils.layoutAddElement(releaseDate, RelativeLayout.ALIGN_PARENT_RIGHT, 20, 430, 20, 430);
//
//            TextView genre = (TextView)_activity.findViewById(DetailsActivity.GENRE_TEXT_ID);
//            genre.setText(extendedGameObject.get_genre());
//            Utils.layoutAddElement(genre, RelativeLayout.ALIGN_PARENT_RIGHT, 20, 530, 20, 530);
//
//            TextView rating = (TextView)_activity.findViewById(DetailsActivity.RATING_TEXT_ID);
//            rating.setText(extendedGameObject.get_rating());
//            Utils.layoutAddElement(rating, RelativeLayout.ALIGN_PARENT_RIGHT, 20, 630, 20, 630);
//
//            //load and set Image
//            int loader = R.drawable.loader;
//            String image_url = extendedGameObject.get_imageURL();
//            ImageLoader imgLoader = new ImageLoader(_activity.getApplicationContext());
//            ImageView image = (ImageView)_activity.findViewById(DetailsActivity.IMAGE_ID);
//            imgLoader.DisplayImage(image_url, loader, image);
//
//        }
//    }
}
