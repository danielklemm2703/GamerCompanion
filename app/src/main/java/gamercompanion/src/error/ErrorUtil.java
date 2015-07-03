package gamercompanion.src.error;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import gamercompanion.src.activities.controlling.ControlledActivity;

/**
 * This class is intended to show all error types including the corresponding message
 */
public class ErrorUtil {

    private static final String CLOSE_APP_BUTTON_TEXT = "Close App";
    private static final String OK_BUTTON_TEXT = "OK";

    private static final DialogInterface.OnClickListener _cancelDialogListener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            dialog.cancel();
        }
    };

    private static final DialogInterface.OnClickListener _closeAppListener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            System.exit(0);
        }
    };

    private static final void setErrorBuilder(MessageType type, String text, boolean cancelable, ControlledActivity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(text);
        builder.setCancelable(cancelable);
        builder.setTitle(type._name);

        setButtons(builder, type);

        AlertDialog alert11 = builder.create();
        alert11.show();
    }

    private static final void setButtons(AlertDialog.Builder builder, MessageType type) {
        if(type.equals(MessageType.ERROR))
        {
            builder.setNegativeButton(CLOSE_APP_BUTTON_TEXT, _closeAppListener);
        }
        if(type.equals(MessageType.INFO))
        {
            builder.setPositiveButton(OK_BUTTON_TEXT,_cancelDialogListener);
        }
        if(type.equals(MessageType.WARNING))
        {
            builder.setPositiveButton(OK_BUTTON_TEXT, _cancelDialogListener);
            builder.setNegativeButton(CLOSE_APP_BUTTON_TEXT,_closeAppListener);
        }
    }

    public static final void showCriticalError(final ControlledActivity activity, String errorText) {
        setErrorBuilder(MessageType.ERROR, errorText, false, activity);
    }

    public static final void showWarning(final ControlledActivity activity, String warningText) {
        setErrorBuilder(MessageType.WARNING, warningText, true, activity);
    }

    public static final void showInfo(final ControlledActivity activity, String infoText) {
        setErrorBuilder(MessageType.WARNING, infoText, true, activity);
    }
}
