package com.tencent.d.b.a;

import com.tencent.d.a.c.f;

public abstract class e<T> extends com.tencent.d.a.c.e {
    public T AlN;

    e() {
        super(-1);
        this.AlN = null;
    }

    protected e(int i, String str) {
        this(i, str, null);
    }

    protected e(int i, String str, T t) {
        super(i, str);
        this.AlN = null;
        switch (i) {
            case 8:
                this.foE = "get support soter failed remotely";
                break;
            case 9:
                this.foE = "upload app secure key";
                break;
            case 10:
                this.foE = "upload auth key failed";
                break;
            case 14:
                this.foE = "not initialized yet. please make sure you've already called SoterWrapperApi.init(...) and call backed";
                break;
            case 17:
                this.foE = "context instance already released. should not happen normally, you can try to call again";
                break;
            case 18:
                this.foE = "there must be at least 1 fingerprint enrolled in system to complete this process. please check it previously";
                break;
            case 19:
                this.foE = "get challenge failed";
                break;
            case 23:
                this.foE = "upload or verify signature in server side failed";
                break;
        }
        if (!f.oN(str)) {
            this.foE = str;
        }
        this.AlN = t;
    }

    protected e(int i) {
        this(i, "", null);
    }

    protected e(int i, T t) {
        this(0, "", t);
    }

    public String toString() {
        if (this.AlN == null) {
            return super.toString();
        }
        return String.format("total: %s, extData: %s", new Object[]{super.toString(), this.AlN.toString()});
    }
}
