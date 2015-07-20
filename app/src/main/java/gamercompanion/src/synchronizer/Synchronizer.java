package gamercompanion.src.synchronizer;

import android.app.ProgressDialog;

import com.google.common.base.Supplier;

import gamercompanion.src.activities.controlling.ActivityController;
import gamercompanion.src.dataObjects.plugin.Plugin;
import gamercompanion.src.dataOperator.PluginOperator;
import static gamercompanion.src.error.ErrorUtil.*;
import gamercompanion.src.utils.Unit;
import gamercompanion.src.utils.tryUtil.Try;

/**
 * Synchronizes Website data witch local database
 */
public class Synchronizer {

    private static final ProgressDialog _progressBar = new ProgressDialog(ActivityController.get_activeActivity());
    private static int _finishedTasks;
    private static int _allTasks;

    public static Unit synchronize() {
        // prepare for a progress bar dialog
        Try<Unit> progressBarTry = setUpProgressBar();
        if(!progressBarTry.isSuccess())
        {
            showWarning("Could not display ProgressBar: "+progressBarTry.failure().getMessage());
            return Unit.VALUE;
        }
        for(Plugin p: PluginOperator.activatedPluginsByPriority())
        {
            Try<Unit> unitTry = p.executeTasks();
            if(!unitTry.isSuccess())
            {
                handleError(unitTry.failure(), p.pluginName());
            }
        }
        return Unit.VALUE;
    }

    private static final void handleError(Throwable failure, String pluginName) {
        if(failure.getMessage() == null)
        {
            showWarning("Could not synchronize Plugin: "+pluginName+": Maybe there are no webtasks for it or it returns null?");
        }
        else
        {
            showWarning("Could not synchronize Plugin: "+pluginName+": "+failure.getMessage());
        }
    }

    public static final void registerTask()
    {
        _allTasks++;
    }

    public static final void finishTask()
    {
        //TODO check if really 100/100 is reached!
        _finishedTasks++;
        Integer progress = computeProgress();
        _progressBar.setProgress(progress);
        if(progress >= 100)
        {
            _progressBar.dismiss();
        }
    }

    private static Integer computeProgress() {
        return Math.round(((float)_finishedTasks/(float)_allTasks)*100);
    }

    public static ProgressDialog _progressBar() {
        return _progressBar;
    }

    private static final Try<Unit> setUpProgressBar()
    {
        return Try.of(new Supplier<Unit>() {
            @Override
            public Unit get() {
                // prepare for a progress bar dialog
                _progressBar.setCancelable(true);
                _progressBar.setMessage("Synchronize with the Web ...");
                _progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                _progressBar.setProgress(0);
                _progressBar.setMax(100);
                _progressBar.show();
                return Unit.VALUE;
            }
        });
    }
}
