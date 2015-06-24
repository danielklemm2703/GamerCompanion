package gamercompanion.gamercompanion.utils;

import android.support.annotation.Nullable;

import com.google.common.base.Function;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Implementation of an {@link Try} containing a reference.
 * 
 * @param <T>
 *            type of the containing reference
 */
final class Success<T> extends Try<T> {

    private final T reference;

    Success(final T reference) {
        this.reference = reference;
    }

    @Override
    public boolean equals(@Nullable final Object object) {
        if (object instanceof Success) {
            Success<?> other = (Success<?>) object;
            return reference.equals(other.reference);
        }
        return false;
    }

    @Override
    public Throwable failure() {
        throw new IllegalStateException("throwables instance absent");
    }

    @Override
    public T get() {
        return reference;
    }

    @Override
    public int hashCode() {
        return 0x598df91c + reference.hashCode();
    }

    @Override
    public boolean isSuccess() {
        return true;
    }

    @Override
    public T or(final T defaultValue) {
        checkNotNull(defaultValue, "use Try.orNull() instead of Try.or(null)");
        return reference;
    }

    @Override
    public Try<T> or(final Try<? extends T> secondChoice) {
        checkNotNull(secondChoice);
        return this;
    }

    @Override
    public String toString() {
        return Success.class.getSimpleName() + ".of(" + reference + ")";
    }

    @Override
    public <V> Try<V> transform(final Function<? super T, V> function) {
        return new Success<V>(checkNotNull(function.apply(reference), "the Function passed to Try.transform() must not return null."));
    }
}
