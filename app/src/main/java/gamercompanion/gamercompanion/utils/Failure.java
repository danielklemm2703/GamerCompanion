package gamercompanion.gamercompanion.utils;


import android.support.annotation.Nullable;

import com.google.common.base.Function;
import com.google.common.base.Throwables;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Implementation of an {@link Try} containing a {@link Throwable}.
 * 
 * @param <T>
 *            type of the containing reference
 */
final class Failure<T> extends Try<T> {

    private final Throwable _throwable;

    Failure(final Throwable t) {
        this._throwable = checkNotNull(t);
    }

    @Override
    public boolean equals(@Nullable final Object object) {
        if (object instanceof Failure) {
            Failure<?> other = (Failure<?>) object;
            return _throwable.equals(other._throwable);
        }
        return false;
    }

    @Override
    public Throwable failure() {
        return _throwable;
    }

    @Override
    public T get() {
        throw Throwables.propagate(_throwable);
    }

    @Override
    public int hashCode() {
        return 0x598df91c + _throwable.hashCode();
    }

    @Override
    public boolean isSuccess() {
        return false;
    }

    @Override
    public T or(final T defaultValue) {
        checkNotNull(defaultValue, "Argument 'defaultValue' must not be null");
        return defaultValue;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Try<T> or(final Try<? extends T> secondChoice) {
        // safe covariant cast
        return (Try<T>) checkNotNull(secondChoice);
    }

    @Override
    public String toString() {
        return "Try.failure(" + _throwable + ")";
    }

    @Override
    public <V> Try<V> transform(final Function<? super T, V> function) {
        checkNotNull(function);
        return new Failure<V>(_throwable);
    }
}
