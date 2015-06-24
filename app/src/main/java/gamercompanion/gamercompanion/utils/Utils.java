package gamercompanion.gamercompanion.utils;

import android.view.View;
import android.widget.RelativeLayout;


import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by dklemm on 12.06.15.
 */
//TODO refactor
public class Utils {
//    public static void CopyStream(InputStream is, OutputStream os)
//    {
//        final int buffer_size=1024;
//        try
//        {
//            byte[] bytes=new byte[buffer_size];
//            for(;;)
//            {
//                int count=is.read(bytes, 0, buffer_size);
//                if(count==-1)
//                    break;
//                os.write(bytes, 0, count);
//            }
//        }
//        catch(Exception ex){}
//    }
//
//    public static void layoutAddElement(View element, int centerInParent, int marginLeft, int marginTop, int marginRight, int marginBottom) {
//        // Defining the layout parameters of the Button
//        RelativeLayout.LayoutParams buttonLayoutParameters = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
//
//        // Add Margin to the LayoutParameters
//        buttonLayoutParameters.setMargins(marginLeft, marginTop, marginRight, marginBottom);
//
//        // Add Rule to Layout
//        buttonLayoutParameters.addRule(centerInParent);
//
//        // Setting the parameters on the Button
//        element.setLayoutParams(buttonLayoutParameters);
//    }
//
//    public static void addElementLayout(View element, int centerInParent) {
//        // Just call the other AddButtonLayout Method with Margin 0
//        layoutAddElement(element, centerInParent, 0, 0, 0, 0);
//    }
//
//    public static String parsePlatformURLString(Platforms platform) {
//        if(platform.equals(Platforms.PS4))
//            return "playstation-4";
//        if(platform.equals(Platforms.WIIU))
//            return "wii-u";
//        if(platform.equals(Platforms.TDS))
//            return "3ds";
//        return "playstation-4";
//
//    }
}
