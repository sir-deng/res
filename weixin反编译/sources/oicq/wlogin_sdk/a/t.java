package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class t extends a {
    public int AGF;

    public t() {
        this.AGF = 0;
        this.AFz = 282;
    }

    public final Boolean cKK() {
        if (this.AGj < 5) {
            return Boolean.valueOf(false);
        }
        int X = util.X(this.AFt, ((this.AGi + 2) + 1) + 1);
        if (this.AGj < X + 5) {
            return Boolean.valueOf(false);
        }
        this.AGF = X;
        return Boolean.valueOf(true);
    }
}
