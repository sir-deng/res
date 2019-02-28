package com.tencent.mm.bf.a;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

public final class a {
    int iaG = 0;
    int iaH = 0;
    int iaI = 0;
    short[] iaJ;

    public a(int i) {
        if (i <= 1) {
            i = WXMediaMessage.TITLE_LENGTH_LIMIT;
        }
        this.iaJ = new short[i];
    }

    final int b(short[] sArr, int i) {
        int length;
        if (i > sArr.length) {
            length = sArr.length;
        } else {
            length = i;
        }
        if (length == 0) {
            return 0;
        }
        int length2 = this.iaJ.length;
        if (length >= this.iaI) {
            length = this.iaI;
        }
        if (length <= length2 - this.iaG) {
            System.arraycopy(this.iaJ, this.iaG, sArr, 0, length);
            this.iaG += length;
            if (this.iaG >= length2) {
                this.iaG = 0;
            }
        } else {
            length2 -= this.iaG;
            System.arraycopy(this.iaJ, this.iaG, sArr, 0, length2);
            int i2 = length - length2;
            System.arraycopy(this.iaJ, 0, sArr, length2, i2);
            this.iaG = i2;
        }
        this.iaI -= length;
        return length;
    }
}
