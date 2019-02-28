package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class g extends a {
    public int AGt;
    public int AGu;
    public int AGv;
    public int AGw;

    public g() {
        this.AGt = 0;
        this.AGu = 0;
        this.AGv = 0;
        this.AGw = 0;
        this.AFz = 261;
    }

    public final Boolean cKK() {
        if (this.AGj < 2) {
            return Boolean.valueOf(false);
        }
        this.AGu = util.Y(this.AFt, this.AGi);
        if (this.AGj < (this.AGu + 2) + 2) {
            return Boolean.valueOf(false);
        }
        this.AGt = util.Y(this.AFt, (this.AGi + 2) + this.AGu);
        if (this.AGj < ((this.AGu + 2) + 2) + this.AGt) {
            return Boolean.valueOf(false);
        }
        this.AGw = this.AGi + 2;
        this.AGv = ((this.AGu + 2) + 2) + this.AGi;
        return Boolean.valueOf(true);
    }
}
