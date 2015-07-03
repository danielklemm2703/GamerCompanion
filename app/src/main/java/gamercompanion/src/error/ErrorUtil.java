package gamercompanion.src.error;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import gamercompanion.src.activities.controlling.ControlledActivity;

/**
 * Created by dklemm on 03.07.15.
 */
public class ErrorUtil {

    public static void showError(final ControlledActivity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage("Write your message here.");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        builder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder.create();
        alert11.show();
    }
}
