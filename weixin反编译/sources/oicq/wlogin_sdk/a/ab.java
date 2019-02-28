package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ab extends a {
    public int AGK;

    public ab() {
        this.AGK = 0;
        this.AFz = 306;
    }

    public final Boolean cKK() {
        if (this.AGj < 2) {
            return Boolean.valueOf(false);
        }
        this.AGK = util.Y(this.AFt, this.AGi);
        if (this.AGK + 2 > this.AGj) {
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(true);
    }
}
