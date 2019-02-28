package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ap.c;
import com.tencent.mm.ap.o;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.apl;
import com.tencent.mm.protocal.c.bmn;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.v;
import com.tencent.mm.y.s;
import java.util.LinkedList;
import java.util.List;

public final class q implements z {
    private String appId = "";
    private String appName = "";
    private String fAn = "";
    private String fHu;
    private MMActivity fnF;
    private int h = -1;
    private String hPT = "";
    private Bitmap hmD = null;
    private TextView ikn = null;
    private View kvL = null;
    private boolean owe = false;
    private String ryj = "";
    private byte[] ryk = null;
    private String ryl;
    private int rym;
    private CdnImageView ryn = null;
    private TextView ryo = null;
    private int ryp;
    private String ryq = "";
    private String ryr = "";
    private b rys = null;
    private String title = "";
    private int w = -1;

    public q(MMActivity mMActivity) {
        this.fnF = mMActivity;
    }

    public final void F(Bundle bundle) {
        this.rys = b.q(this.fnF.getIntent());
        this.w = this.fnF.getIntent().getIntExtra("Ksnsupload_width", -1);
        this.h = this.fnF.getIntent().getIntExtra("Ksnsupload_height", -1);
        this.rym = this.fnF.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.hPT = bi.aD(this.fnF.getIntent().getStringExtra("Ksnsupload_link"), "");
        this.title = bi.aD(this.fnF.getIntent().getStringExtra("Ksnsupload_title"), "");
        this.ryj = bi.aD(this.fnF.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
        this.fAn = this.fnF.getIntent().getStringExtra("KsnsUpload_imgPath");
        this.owe = this.fnF.getIntent().getBooleanExtra("ksnsis_video", false);
        this.fHu = bi.aD(this.fnF.getIntent().getStringExtra("src_username"), "");
        this.ryl = bi.aD(this.fnF.getIntent().getStringExtra("src_displayname"), "");
        this.ryr = bi.aD(this.fnF.getIntent().getStringExtra("KContentObjDesc"), "");
        this.ryq = bi.aD(this.fnF.getIntent().getStringExtra("KUploadProduct_UserData"), "");
        this.appName = bi.aD(this.fnF.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.appId = bi.aD(this.fnF.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.ryp = this.fnF.getIntent().getIntExtra("KUploadProduct_subType", 0);
    }

    public final void G(Bundle bundle) {
    }

    public final boolean bzT() {
        return true;
    }

    public final View bzU() {
        this.kvL = v.fw(this.fnF).inflate(g.qOs, null);
        this.ryn = (CdnImageView) this.kvL.findViewById(f.qIs);
        this.ikn = (TextView) this.kvL.findViewById(f.qLQ);
        this.ryo = (TextView) this.kvL.findViewById(f.qJm);
        if (this.owe) {
            this.kvL.findViewById(f.state).setVisibility(0);
        } else {
            this.kvL.findViewById(f.state).setVisibility(8);
        }
        this.ikn.setText(this.title);
        if (!bi.oN(this.ryj)) {
            this.ryn.setVisibility(0);
            this.ryn.setUrl(this.ryj);
        } else if (bi.by(this.ryk)) {
            this.ryn.setVisibility(8);
        } else {
            this.ryn.setVisibility(0);
            this.hmD = d.bn(this.ryk);
            this.ryn.setImageBitmap(this.hmD);
        }
        i.b(this.ryn, this.fnF);
        return this.kvL;
    }

    public final boolean a(int i, int i2, org.b.d.i iVar, String str, List<String> list, apl apl, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        aw awVar = new aw(22);
        pInt.value = awVar.afu;
        if (i3 > a.qWI) {
            awVar.xe(2);
        }
        if (iVar != null) {
            awVar.ek(iVar.token, iVar.wFv);
        }
        awVar.Lj(this.title).Lh(this.ryr).Li(this.hPT).Le(str);
        boolean z2 = false;
        if (!bi.oN(this.fAn)) {
            z2 = awVar.a(FileOp.d(this.fAn, 0, -1), this.ryr, this.title, this.ryp, this.ryq);
        } else if (!(bi.oN(this.ryj) || o.PB() == null)) {
            o.PB();
            Bitmap iJ = c.iJ(this.ryj);
            if (iJ != null) {
                z2 = awVar.a(d.R(iJ), this.ryr, this.title, this.ryp, this.ryq);
            }
        }
        if (!z2) {
            x.i("MicroMsg.EmotionListShareWidget", "set userData user imgurl ");
            z2 = awVar.b(this.ryj, this.ryj, this.ryr, this.ryp, this.ryq);
        }
        if (!z2) {
            x.e("MicroMsg.EmotionListShareWidget", "set userData faild");
        }
        awVar.xi(this.rym);
        awVar.Lm(this.fHu);
        awVar.Ln(this.ryl);
        awVar.xg(i);
        awVar.e(null, null, null, i4, i5);
        if (z) {
            awVar.xj(1);
        } else {
            awVar.xj(0);
        }
        awVar.bO(list2);
        if (!bi.oN(this.appId)) {
            awVar.Lk(this.appId);
            awVar.Ll(this.appName);
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
        awVar.aj(linkedList);
        awVar.a(apl);
        int commit = awVar.commit();
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
        if (!(this.hmD == null || this.hmD.isRecycled())) {
            this.hmD.recycle();
        }
        return false;
    }
}
