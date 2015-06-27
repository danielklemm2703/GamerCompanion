package gamercompanion.src.dataObjects.gameProgress;

/**
 * DaO of StandardGameProgress
 */
public class StandardGameProgress extends GameProgress {
    public StandardProgress _progress;

    public StandardGameProgress(StandardProgress progress)
    {
        _progress = progress;
    }
}
