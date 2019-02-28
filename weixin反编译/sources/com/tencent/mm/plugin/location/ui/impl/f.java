package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.protocal.c.awg;

public final class f {
    public double bhC;
    public double bhD;
    public String hMN;
    public String jyE;
    public String mName;
    public String odg;
    public String odh;
    public String odi;
    public String odj;
    public String odk;
    public String odl;
    public String odm;
    public String odn;
    public String odo;
    public Addr odp;
    public String odq;
    public int odr = -1;
    public int type;

    public f(awg awg, String str) {
        this.mName = awg.nkW;
        this.odg = awg.wKq;
        this.bhD = awg.vUF;
        this.bhC = awg.vUG;
        this.odh = awg.wKr;
        this.odi = awg.oVe;
        this.odj = awg.wKs;
        this.odk = awg.hxf;
        this.jyE = awg.hxg;
        this.odl = awg.wfC;
        this.odm = awg.wfD;
        this.odn = awg.wKt;
        this.odq = str;
        this.odp = new Addr();
        this.odp.hzf = this.odg;
        this.odp.hzh = this.jyE;
        this.odp.hzi = this.jyE;
        this.odp.hzj = this.odl;
        this.odp.hzl = this.odn;
        this.odp.hzo = this.mName;
        this.odp.hzg = this.odk;
        this.odp.hzr = (float) awg.vUF;
        this.odp.hzq = (float) awg.vUG;
        this.type = 0;
    }
}
