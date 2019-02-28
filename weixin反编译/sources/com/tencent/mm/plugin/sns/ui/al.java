package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import com.tencent.mm.f.a.pk;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.apl;
import com.tencent.mm.protocal.c.bmn;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.y.s;
import java.util.LinkedList;
import java.util.List;

public final class al implements z {
    private String desc = "";
    MMActivity fnF;
    String frM = "";
    private boolean fsk = false;
    String fwx = "";
    ProgressDialog inI = null;
    private View kvL = null;
    ProgressBar lFV;
    private Bitmap rAA = null;
    private c rAD = new c<pk>() {
        {
            this.xmG = pk.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            pk pkVar = (pk) bVar;
            x.i("MicroMsg.SightWidget", "on sight send result callback, type %d", Integer.valueOf(pkVar.fIc.type));
            switch (pkVar.fIc.type) {
                case 1:
                    x.i("MicroMsg.SightWidget", "come event done");
                    al.this.videoPath = pkVar.fIc.videoPath;
                    al.this.frM = pkVar.fIc.fIf;
                    if (al.this.inI != null) {
                        al.this.inI.dismiss();
                    }
                    al.this.rDp.aA(al.this.videoPath, false);
                    al.this.lFV.setVisibility(8);
                    if (pkVar.fIc.fIe && al.this.rAE != null) {
                        al.this.bAL();
                    }
                    x.i("MicroMsg.SightWidget", "mux finish %B videoPath %s %d md5 %s", Boolean.valueOf(pkVar.fIc.fIe), pkVar.fIc.videoPath, Long.valueOf(FileOp.mi(pkVar.fIc.videoPath)), al.this.frM);
                    break;
            }
            return false;
        }
    };
    aw rAE = null;
    private boolean rAz = false;
    a rDp;
    com.tencent.mm.plugin.sight.decode.ui.c rDq = null;
    private int rym;
    private com.tencent.mm.modelsns.b rys = null;
    String videoPath = "";

    public al(MMActivity mMActivity) {
        this.fnF = mMActivity;
    }

    public final void F(Bundle bundle) {
        this.rys = com.tencent.mm.modelsns.b.q(this.fnF.getIntent());
        this.fwx = this.fnF.getIntent().getStringExtra("KSightThumbPath");
        this.videoPath = this.fnF.getIntent().getStringExtra("KSightPath");
        this.frM = this.fnF.getIntent().getStringExtra("sight_md5");
        this.rym = this.fnF.getIntent().getIntExtra("Ksnsupload_source", 0);
        b pkVar = new pk();
        pkVar.fIc.type = 2;
        com.tencent.mm.sdk.b.a.xmy.m(pkVar);
        if (bi.oN(this.videoPath)) {
            this.videoPath = bi.aD(pkVar.fId.fIh, "");
            x.e("MicroMsg.SightWidget", "videoPath is null %s", this.videoPath);
        }
        this.frM = bi.oN(this.frM) ? bi.aD(pkVar.fId.fIf, "") : this.frM;
        x.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", this.fwx, this.videoPath, this.frM);
        com.tencent.mm.sdk.b.a.xmy.b(this.rAD);
    }

    public final void G(Bundle bundle) {
    }

    public final boolean bzT() {
        return true;
    }

    public final View bzU() {
        this.kvL = View.inflate(this.fnF, g.qOv, null);
        this.rDp = (a) this.kvL.findViewById(f.image);
        this.rDp.wB(com.tencent.mm.bu.a.fromDPToPix(this.fnF, 90));
        this.lFV = (ProgressBar) this.kvL.findViewById(f.ctv);
        this.fnF.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        this.kvL.findViewById(f.bTF).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (FileOp.bO(al.this.videoPath)) {
                    if (al.this.rDq != null) {
                        al.this.rDq.dismiss();
                        al.this.rDq = null;
                    }
                    al.this.rDq = new com.tencent.mm.plugin.sight.decode.ui.c(al.this.fnF);
                    com.tencent.mm.plugin.sight.decode.ui.c cVar = al.this.rDq;
                    String str = al.this.videoPath;
                    String str2 = al.this.fwx;
                    cVar.hFn = str;
                    cVar.imagePath = str2;
                    cVar = al.this.rDq;
                    cVar.fKw = 0;
                    cVar.qAb = 0;
                    cVar.mxY = 1;
                    al.this.rDq.show();
                    return;
                }
                x.i("MicroMsg.SightWidget", "click videopath is not exist " + al.this.videoPath);
            }
        });
        x.i("MicroMsg.SightWidget", "videoPath " + this.videoPath + " thumbPath " + this.fwx + " " + FileOp.mi(this.videoPath) + " " + FileOp.mi(this.fwx));
        if (FileOp.bO(this.videoPath)) {
            this.rDp.aA(this.videoPath, false);
            this.lFV.setVisibility(8);
            x.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", this.videoPath, this.frM);
        } else {
            n Kr = i.Kr(this.fwx);
            if (Kr != null) {
                this.rAA = Kr.EJ();
                if (i.m(this.rAA)) {
                    this.rDp.B(this.rAA);
                }
            }
            this.lFV.setVisibility(0);
        }
        return this.kvL;
    }

    public final boolean a(int i, int i2, org.b.d.i iVar, String str, List<String> list, apl apl, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        if (this.rAE != null) {
            return false;
        }
        this.desc = str;
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
        this.rAE = new aw(15);
        pInt.value = this.rAE.afu;
        if (i3 > com.tencent.mm.plugin.sns.c.a.qWI) {
            this.rAE.xe(3);
        }
        aw Le = this.rAE.Le(str);
        LinkedList linkedList3 = new LinkedList();
        Le.a(apl).aj(linkedList).xg(i).xh(i2).bO(list2);
        if (z) {
            this.rAE.xj(1);
        } else {
            this.rAE.xj(0);
        }
        this.rAE.bO(list2).xg(i);
        this.rAE.xi(this.rym);
        this.rAE.e(null, null, null, i4, i5);
        if (FileOp.bO(this.videoPath)) {
            bAL();
            return true;
        }
        x.i("MicroMsg.SightWidget", "commit file is not exist " + this.videoPath);
        Context context = this.fnF;
        this.fnF.getString(j.dGZ);
        this.inI = h.a(context, this.fnF.getString(j.qSk), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                al.this.rAE = null;
            }
        });
        return true;
    }

    final void bAL() {
        if (!this.rAz) {
            if (this.rAE.l(this.videoPath, this.fwx, this.desc, this.frM)) {
                b pkVar = new pk();
                pkVar.fIc.type = 0;
                pkVar.fIc.fIe = true;
                com.tencent.mm.sdk.b.a.xmy.m(pkVar);
                this.rAz = true;
                int commit = this.rAE.commit();
                if (this.rys != null) {
                    this.rys.iz(commit);
                    e.rjJ.c(this.rys);
                }
                ae.bwm().rCB = 0;
                Intent intent = new Intent();
                intent.putExtra("sns_resume_state", false);
                intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                intent.setClass(this.fnF, SnsTimeLineUI.class);
                intent.addFlags(67108864);
                this.fnF.startActivity(intent);
                this.fnF.setResult(-1);
                this.fnF.finish();
                return;
            }
            x.i("MicroMsg.SightWidget", "videopath " + FileOp.mi(this.videoPath) + " thumb: " + FileOp.mi(this.fwx));
            u.makeText(this.fnF, j.eKq, 0).show();
        }
    }

    public final boolean a(int i, Intent intent) {
        return false;
    }

    public final boolean bzV() {
        if (this.inI != null) {
            this.inI.dismiss();
        }
        com.tencent.mm.sdk.b.a.xmy.c(this.rAD);
        if (i.m(this.rAA)) {
            this.rAA.recycle();
        }
        return false;
    }
}
