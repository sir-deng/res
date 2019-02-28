package com.tencent.mm.plugin.appbrand.report.a;

import com.tencent.mm.plugin.appbrand.e;

public final class k {
    public String appId;
    public int fJh;
    public int foh;
    public final String frp;
    public final e iua;
    public String jNL;
    public volatile long jOm;
    public volatile boolean jOn = false;
    public int jOo;
    public int jOp;
    public long jOq;
    public long jOr;
    public int scene;

    public k(e eVar) {
        this.iua = eVar;
        this.frp = eVar.isR.iub;
    }

    public final String toString() {
        return "kv_14576{, networkType='" + this.jNL + '\'' + ", appId='" + this.appId + '\'' + ", appVersion=" + this.fJh + ", appState=" + this.foh + ", scene=" + this.scene + ", sessionId='" + this.frp + '\'' + ", is_download_code=" + this.jOo + ", is_load_x5=" + this.jOp + ", cost_time=" + this.jOq + ", event_time=" + this.jOr + '}';
    }
}
