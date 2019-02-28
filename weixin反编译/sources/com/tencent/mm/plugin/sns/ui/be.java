package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.h.e;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.apl;
import com.tencent.mm.protocal.c.bmn;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.s;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class be implements z {
    private String appName = "";
    private String fGh = "";
    private MMActivity fnF;
    private String rAK = "";
    private int rym;
    private b rys = null;
    private boolean rzG = false;
    private boolean rzH = false;
    private WXMediaMessage rzI = null;

    public be(MMActivity mMActivity) {
        this.fnF = mMActivity;
    }

    public final void F(Bundle bundle) {
        this.rys = b.q(this.fnF.getIntent());
        this.rAK = this.fnF.getIntent().getStringExtra("Kdescription");
        this.fGh = bi.aD(this.fnF.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = bi.aD(this.fnF.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.rzG = this.fnF.getIntent().getBooleanExtra("KThrid_app", false);
        this.rzH = this.fnF.getIntent().getBooleanExtra("KSnsAction", false);
        this.rym = this.fnF.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.rzI = new Req(this.fnF.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
    }

    public final void G(Bundle bundle) {
    }

    public final boolean bzT() {
        return true;
    }

    public final View bzU() {
        return null;
    }

    public final boolean a(int i, int i2, i iVar, String str, List<String> list, apl apl, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        ae.bwb();
        aw a = av.a(this.rzI, str, this.fGh, this.appName);
        if (a == null) {
            x.e("MicroMsg.TextWidget", "packHelper == null, %s, %s", this.fGh, this.appName);
            return false;
        }
        pInt.value = a.afu;
        if (i3 > a.qWI) {
            a.xe(4);
        }
        a.xi(this.rym);
        if (this.rzG) {
            a.xi(5);
        }
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            LinkedList linkedList2 = new LinkedList();
            List GO = s.GO();
            for (String str3 : list) {
                if (!GO.contains(str3)) {
                    bmn bmn = new bmn();
                    bmn.kyG = str3;
                    linkedList.add(bmn);
                }
            }
        }
        a.aj(linkedList);
        if (iVar != null) {
            a.ek(iVar.token, iVar.wFv);
        }
        a.a(apl);
        if (z) {
            a.xj(1);
        } else {
            a.xj(0);
        }
        a.bO(list2).xg(i);
        a.e(null, null, null, i4, i5);
        if (this.rzH && this.rzI != null) {
            a.Lf(this.rzI.mediaTagName);
            a.V(this.fGh, this.rzI.messageExt, this.rzI.messageAction);
        }
        int commit = a.commit();
        if (this.rys != null) {
            this.rys.iz(commit);
            e.rjJ.c(this.rys);
        }
        ae.bwb().buT();
        this.fnF.finish();
        return false;
    }

    public final boolean a(int i, Intent intent) {
        return false;
    }

    public final boolean bzV() {
        return false;
    }
}
