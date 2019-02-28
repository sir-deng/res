package com.tencent.mm.compatible.h;

import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public int frq;
    public String gIR;
    public long gIS;
    public int gIT;

    public a() {
        this.gIR = null;
        this.gIS = -1;
        this.gIT = -1;
        this.frq = -1;
        this.gIR = null;
        this.gIS = -1;
        this.gIT = -1;
        this.frq = -1;
    }

    public final String zi() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.gIR);
        stringBuffer.append(",");
        stringBuffer.append(this.gIS);
        stringBuffer.append(",");
        stringBuffer.append(this.gIT);
        stringBuffer.append(",");
        stringBuffer.append(this.frq);
        x.d("MicroMsg.AudioRecorderInfo", " getStatInfo " + stringBuffer.toString());
        return stringBuffer.toString();
    }
}
