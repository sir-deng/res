package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ad extends a {
    public int AGL;

    public ad() {
        this.AGL = 0;
        this.AFz = 312;
    }

    public final Boolean cKK() {
        if (this.AGj < 4) {
            return Boolean.valueOf(false);
        }
        this.AGL = util.Z(this.AFt, this.AGi);
        if (this.AGj < (this.AGL * 10) + 4) {
            return Boolean.valueOf(false);
        }
        return Boolean.valueOf(true);
    }

    public final int cKL() {
        for (int i = 0; i < this.AGL; i++) {
            if (util.Y(this.AFt, (this.AGi + 4) + (i * 10)) == 266) {
                return util.Z(this.AFt, ((i * 10) + (this.AGi + 4)) + 2);
            }
        }
        return 0;
    }
}
