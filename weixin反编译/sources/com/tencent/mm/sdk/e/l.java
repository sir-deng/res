package com.tencent.mm.sdk.e;

public final class l {
    public String fpd;
    public int jcn;
    public Object obj;
    public j xsg;

    public l() {
        this.fpd = null;
        this.xsg = null;
        this.jcn = -1;
        this.obj = null;
    }

    public l(String str) {
        this.fpd = str;
        this.xsg = null;
        this.jcn = -1;
        this.obj = null;
    }

    public final String toString() {
        return "MStorageEventData [event=" + this.fpd + ", eventId=" + this.jcn + ", stg=" + this.xsg + ", obj=" + this.obj + "]";
    }
}
