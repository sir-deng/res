package com.tencent.mm.ui.f.a;

public final class d extends Throwable {
    public int mErrorCode = 0;
    public String zle;

    public d(String str) {
        super(str);
    }

    public d(String str, String str2, int i) {
        super(str);
        this.zle = str2;
        this.mErrorCode = i;
    }
}
