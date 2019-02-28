package com.tencent.mm.plugin.sns;

import com.tencent.mm.f.a.ew;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class b extends c<ew> {
    public b() {
        this.xmG = ew.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        boolean z = false;
        ew ewVar = (ew) bVar;
        if (!(ewVar instanceof ew)) {
            x.f("MicroMsg.ExtGetSnsDataEventListener", "mismatched event");
            return false;
        } else if (ewVar.fus.fuu == null) {
            return false;
        } else {
            m mVar = new m();
            mVar.b(ewVar.fus.fuu);
            if (mVar.ruM <= 0) {
                x.e("MicroMsg.ExtGetSnsDataEventListener", "sns == null || sns.getLocalid()<=0");
                return false;
            }
            bpb byF = mVar.byF();
            ewVar.fut.fuz = 0;
            ewVar.fut.fuD = 0;
            ewVar.fut.fuE = 0;
            ewVar.fut.fuB = new LinkedList();
            ewVar.fut.fuC = new LinkedList();
            if (byF.wYj != null) {
                ewVar.fut.fuz = byF.wYj.wfg;
                if (byF.wYj.wfg != 1 && byF.wYj.wfg != 7 && byF.wYj.wfg != 8) {
                    ewVar.fut.fuB.add(byF.wYj.nlE);
                } else if (byF.wYj.wfh != null) {
                    while (true) {
                        boolean z2 = z;
                        if (z2 >= byF.wYj.wfh.size()) {
                            break;
                        }
                        List list = ewVar.fut.fuB;
                        ae.bwc();
                        list.add(g.r((are) byF.wYj.wfh.get(z2)));
                        list = ewVar.fut.fuC;
                        ae.bwc();
                        list.add(g.s((are) byF.wYj.wfh.get(z2)));
                        if (!(z2 || byF.wYj.wfh.get(z2) == null)) {
                            ewVar.fut.fuD = (int) ((are) byF.wYj.wfh.get(z2)).wES.wFF;
                            ewVar.fut.fuE = (int) ((are) byF.wYj.wfh.get(z2)).wES.wFG;
                        }
                        z = z2 + 1;
                    }
                }
            }
            ewVar.fut.fuA = ewVar.fut.fuB.size();
            ewVar.fut.fuw = mVar.ruM;
            ewVar.fut.fuv = mVar.field_userName;
            ewVar.fut.fux = byF.wYg;
            ewVar.fut.fuy = (long) byF.pgR;
            return true;
        }
    }
}
