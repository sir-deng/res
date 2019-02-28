package oicq.wlogin_sdk.a;

import oicq.wlogin_sdk.tools.util;

public final class ai extends a {
    public int AGR;
    public int AGS;
    public int AGT;

    public ai() {
        this.AGR = 0;
        this.AGS = 0;
        this.AGT = 0;
        this.AFz = 326;
    }

    public final Boolean cKK() {
        if (this.AGj < 12) {
            return Boolean.valueOf(false);
        }
        int Y = util.Y(this.AFt, this.AGi + 4);
        if (this.AGj < Y + 12) {
            return Boolean.valueOf(false);
        }
        this.AGR = Y;
        Y = util.Y(this.AFt, (this.AGi + 6) + this.AGR);
        if (this.AGj < (this.AGR + 12) + Y) {
            return Boolean.valueOf(false);
        }
        this.AGS = Y;
        Y = util.Y(this.AFt, ((this.AGi + 10) + this.AGR) + this.AGS);
        if (this.AGj < ((this.AGR + 12) + this.AGS) + Y) {
            return Boolean.valueOf(false);
        }
        this.AGT = Y;
        return Boolean.valueOf(true);
    }
}
