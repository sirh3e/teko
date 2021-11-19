package sirh3e.dev.rust;

import java.util.function.Function;

public class Result<TOk, TErr> {

    private final TOk _ok;
    private final boolean _isOk;
    private final TErr _err;

    private Result(TOk ok, TErr err) {
        if (ok != null) {
            this._ok = ok;
            this._isOk = true;
            this._err = null;
        } else {
            this._ok = null;
            this._isOk = false;
            this._err = err;
        }
    }

    public <T> Result<T, TErr> map(Function<TOk, T> map) {
        return this._isOk
                ? Factory.fromOk(map.apply(this._ok))
                : Factory.fromErr(this._err);
    }

    public boolean isOk() {
        return this._isOk;
    }

    public boolean isErr() {
        return !isOk();
    }

    public TOk unwrap() {
        if (this._isOk) {
            return this._ok;
        }
        throw new RuntimeException();
    }

    public TOk unwrapOr(TOk ok) {
        return isOk() ? this._ok : ok;
    }

    public final static class Factory {
        public static <TOk, TErr> Result<TOk, TErr> fromOk(TOk ok) {
            return new Result<TOk, TErr>(ok, null);
        }

        public static <TOk, TErr> Result<TOk, TErr> fromErr(TErr err) {
            return new Result<TOk, TErr>(null, err);
        }
    }
}
