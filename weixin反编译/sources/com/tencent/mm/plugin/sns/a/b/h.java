package com.tencent.mm.plugin.sns.a.b;

import android.os.SystemClock;
import com.tencent.mm.plugin.sns.a.b.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class h {
    public String TAG = "MicroMsg.SnsAdVideoStatistic";
    public long hQq = 0;
    public long hQr = 0;
    public int qVo = 0;
    public int qVp = 0;
    public long qVq = 0;
    public int qVr = 0;
    public int qVs = 0;
    public int qVt = 0;
    public int qVu = 0;
    public boolean qVv = false;
    public a qVw = new a();
    public LinkedList<a> qVx = new LinkedList();
    public long qVy = 0;

    public h(String str) {
        this.TAG = "MicroMsg.SnsAdVideoStatistic:" + str;
    }

    public final void wJ(int i) {
        if (this.qVw.qWu <= 0) {
            this.qVw.qWu = this.qVw.qWy == 0 ? 0 : (int) bi.bB(this.qVw.qWy);
        }
        if (i != 0) {
            this.qVw.qWv = i;
            this.qVy = (long) i;
        }
        x.i(this.TAG, "pushplayitem duration " + this.qVw.qWu + " " + this.qVw.qWx);
        this.qVx.add(this.qVw);
        this.qVw = new a();
    }

    public final String buJ() {
        int i;
        LinkedList linkedList;
        a aVar;
        if (this.qVq == 0) {
            i = 0;
        } else {
            i = (int) bi.bB(this.qVq);
        }
        this.qVp = i;
        x.d(this.TAG, "__staytotaltime " + this.qVq + " " + this.qVp + " clock: " + SystemClock.elapsedRealtime());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<viewinfo>");
        stringBuffer.append("<downloadstatus>");
        stringBuffer.append(this.qVo);
        stringBuffer.append("</downloadstatus>");
        stringBuffer.append("<staytotaltime>");
        stringBuffer.append(this.qVp);
        stringBuffer.append("</staytotaltime>");
        if (this.qVr > 0) {
            stringBuffer.append("<masktotaltime>");
            stringBuffer.append(this.qVr);
            stringBuffer.append("</masktotaltime>");
        }
        LinkedList linkedList2 = this.qVx;
        if (!this.qVv || this.qVx.size() <= 1) {
            linkedList = linkedList2;
        } else {
            a aVar2 = new a();
            for (int i2 = 0; i2 < this.qVx.size(); i2++) {
                aVar = (a) this.qVx.get(i2);
                if (i2 == 0) {
                    aVar2.qWv = aVar.qWv;
                    aVar2.qWw = aVar.qWw;
                    aVar2.qWx = aVar.qWx;
                }
                aVar2.qWt += aVar.qWt;
                aVar2.qWu = aVar.qWu + aVar2.qWu;
            }
            linkedList2 = new LinkedList();
            linkedList2.add(aVar2);
            linkedList = linkedList2;
        }
        stringBuffer.append(String.format("<playitemlist count=\"%d\">", new Object[]{Integer.valueOf(linkedList.size())}));
        for (int i3 = 0; i3 < linkedList.size(); i3++) {
            aVar = (a) linkedList.get(i3);
            stringBuffer.append("<playitem>");
            stringBuffer.append(String.format("<playcount>%d</playcount>", new Object[]{Integer.valueOf(aVar.qWt)}));
            stringBuffer.append(String.format("<playtotaltime>%d</playtotaltime>", new Object[]{Integer.valueOf(aVar.qWu)}));
            stringBuffer.append(String.format("<videototaltime>%d</videototaltime>", new Object[]{Integer.valueOf(aVar.qWv * 1000)}));
            stringBuffer.append(String.format("<playmode>%d</playmode>", new Object[]{Integer.valueOf(aVar.qWw)}));
            stringBuffer.append(String.format("<playorientation>%d</playorientation>", new Object[]{Integer.valueOf(aVar.qWx)}));
            stringBuffer.append("</playitem>");
        }
        stringBuffer.append("</playitemlist>");
        stringBuffer.append("</viewinfo>");
        String stringBuffer2 = stringBuffer.toString();
        x.i(this.TAG, "xml " + stringBuffer2);
        return stringBuffer2;
    }

    public final void buK() {
        this.qVs = 0;
        this.qVt = 0;
        this.qVu = 0;
        Iterator it = this.qVx.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            this.qVs += aVar.qWs;
            this.qVt += aVar.qWt;
            this.qVu = aVar.qWu + this.qVu;
        }
        if (this.qVw != null && !this.qVx.contains(this.qVw)) {
            this.qVs += this.qVw.qWs;
            this.qVt += this.qVw.qWt;
            this.qVu += this.qVw.qWu;
        }
    }

    public final void onResume() {
        if (this.hQq != 0) {
            long bB = bi.bB(this.hQq);
            this.hQr += bB;
            this.hQq = 0;
            if (this.qVw != null) {
                a aVar = this.qVw;
                aVar.qWz = bB + aVar.qWz;
            }
        }
    }
}
