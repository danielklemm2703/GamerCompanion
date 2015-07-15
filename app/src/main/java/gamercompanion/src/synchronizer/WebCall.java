package gamercompanion.src.synchronizer;

import gamercompanion.src.utils.Platform;
import gamercompanion.src.utils.Unit;
import gamercompanion.src.utils.tryUtil.Try;

import static com.google.common.base.Preconditions.*;

/**
 * The abstract web call. Every web call needs to implement how to compute the url that should be called by the WebCallTask.
 * Also necessary to compute the result of the web call
 */
public abstract class WebCall {

    private Platform _platform;

    WebCall(Platform platform)
    {
        checkNotNull(platform, "argument 'platform' must not be null");
        _platform = platform;
    }

    public Platform _platform() {
        return _platform;
    }

    public String getUrl() {
        return computeURL();
    }

    abstract public Try<Unit> computeResult(String result);

    abstract public String computeURL();

    abstract public Unit execute();

}
