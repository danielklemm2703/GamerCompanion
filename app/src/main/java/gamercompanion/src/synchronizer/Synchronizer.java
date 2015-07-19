package gamercompanion.src.synchronizer;

import gamercompanion.src.dataObjects.plugin.Plugin;
import gamercompanion.src.dataOperator.PluginOperator;
import static gamercompanion.src.error.ErrorUtil.*;
import gamercompanion.src.utils.Unit;
import gamercompanion.src.utils.tryUtil.Try;

/**
 * Synchronizes Website data witch local database
 */
public class Synchronizer {
    public static Unit synchronize() {
        for(Plugin p: PluginOperator.activatedPluginsByPriority())
        {
            Try<Unit> unitTry = p.executeTasks();
            if(!unitTry.isSuccess())
            {
                if(unitTry.failure().getMessage() == null)
                {
                    showWarning("Could not synchronize Plugin: "+p.pluginName()+": Maybe there are no webtasks for it or it returns null?");
                }
                else
                {
                    showWarning("Could not synchronize Plugin: "+p.pluginName()+": "+unitTry.failure().getMessage());
                }
            }
        }
        return Unit.VALUE;
    }
}
