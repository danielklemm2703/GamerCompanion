package gamercompanion.src.dataObjects.gameProgress;

/**
 * Created by dklemm on 26.06.15.
 */
public class StandardGameProgress extends GameProgress {
    private StandardProgress _progress;

    public StandardGameProgress(StandardProgress progress)
    {
        _progress = progress;
    }
}
