package com.tencent.mm.plugin.multitalk.ui.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.AnimationDrawable;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ac.n;
import com.tencent.mm.plugin.multitalk.a.d;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.j;
import com.tencent.mm.plugin.multitalk.a.o;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.ui.MMCheckBox;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.y.q;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.pb.talkroom.sdk.g;
import com.tencent.wecall.talkroom.model.TalkRoom;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class f implements OnClickListener, com.tencent.mm.ac.d.a, com.tencent.mm.plugin.voip.video.f {
    i iqG = null;
    public TextView ljv;
    private MultiTalkMainUI oNL;
    private ImageButton oNR;
    c oOA = new c();
    public FrameLayout oOh;
    public FrameLayout oOi;
    public View oOj;
    private View oOk;
    private View oOl;
    public View oOm;
    public MMCheckBox oOn;
    public MMCheckBox oOo;
    public MMCheckBox oOp;
    private int oOq;
    private int oOr;
    public ArrayList<RelativeLayout> oOs = new ArrayList(9);
    private RelativeLayout oOt;
    public com.tencent.mm.plugin.voip.video.a oOu;
    private j oOv;
    private ObservableTextureView oOw;
    public String oOx;
    private int oOy;
    public long oOz;

    public static class a {
        View kbO;
        public MultiTalkVideoView oOC;
        public ImageView oOD;
        public ImageView oOE;
        public TextView oOF;
        ImageView oOG;
    }

    private class b implements Runnable {
        a oOH;

        public b(a aVar) {
            this.oOH = aVar;
        }

        public final void run() {
            this.oOH.oOF.setVisibility(8);
        }
    }

    private class c {
        int h;
        int[] oME;
        int w;

        private c() {
        }

        /* synthetic */ c(f fVar, byte b) {
            this();
        }
    }

    public f(MultiTalkMainUI multiTalkMainUI) {
        RelativeLayout relativeLayout;
        this.oNL = multiTalkMainUI;
        this.ljv = (TextView) multiTalkMainUI.findViewById(R.h.cRz);
        this.oOj = multiTalkMainUI.findViewById(R.h.cQC);
        this.oNR = (ImageButton) multiTalkMainUI.findViewById(R.h.cQB);
        this.oOh = (FrameLayout) multiTalkMainUI.findViewById(R.h.cQD);
        this.oOi = (FrameLayout) multiTalkMainUI.findViewById(R.h.cQA);
        this.oOk = multiTalkMainUI.findViewById(R.h.cya);
        this.oOl = multiTalkMainUI.findViewById(R.h.cxS);
        this.oOn = (MMCheckBox) multiTalkMainUI.findViewById(R.h.cyj);
        this.oOo = (MMCheckBox) multiTalkMainUI.findViewById(R.h.cyb);
        this.oOp = (MMCheckBox) multiTalkMainUI.findViewById(R.h.cxX);
        this.oOm = multiTalkMainUI.findViewById(R.h.cxV);
        this.oOo.setChecked(o.bdB().kYN);
        this.oOp.setChecked(o.bdB().oLI);
        this.oOn.setChecked(o.bdB().bcX());
        this.oOq = com.tencent.mm.bu.a.eB(multiTalkMainUI.mController.xRr);
        this.oOr = b.dh(multiTalkMainUI.mController.xRr);
        x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "talkingAvatarContainerHeight %d", Integer.valueOf(this.oOr));
        this.oNR.setOnClickListener(this);
        this.oOk.setOnClickListener(this);
        this.oOn.setOnClickListener(this);
        this.oOo.setOnClickListener(this);
        this.oOp.setOnClickListener(this);
        this.oOl.setOnClickListener(this);
        this.oOm.setOnClickListener(this);
        n.JF().a((com.tencent.mm.ac.d.a) this);
        for (int i = 8; i >= 0; i--) {
            relativeLayout = (RelativeLayout) LayoutInflater.from(multiTalkMainUI).inflate(R.i.dnc, null);
            a aVar = new a();
            aVar.oOC = (MultiTalkVideoView) relativeLayout.findViewById(R.h.cQE);
            aVar.oOC.index = i;
            aVar.oOC.setOnClickListener(this);
            aVar.kbO = relativeLayout.findViewById(R.h.cvd);
            aVar.oOD = (ImageView) relativeLayout.findViewById(R.h.cWs);
            aVar.oOE = (ImageView) relativeLayout.findViewById(R.h.cyk);
            aVar.oOF = (TextView) relativeLayout.findViewById(R.h.cPY);
            aVar.oOG = (ImageView) relativeLayout.findViewById(R.h.ctA);
            relativeLayout.setTag(aVar);
            relativeLayout.setVisibility(8);
            this.oOs.add(relativeLayout);
            this.oOh.addView(relativeLayout);
        }
        if (this.oOi != null) {
            relativeLayout = (RelativeLayout) LayoutInflater.from(multiTalkMainUI).inflate(R.i.dnc, null);
            a aVar2 = new a();
            aVar2.oOC = (MultiTalkVideoView) relativeLayout.findViewById(R.h.cQE);
            aVar2.oOC.index = 0;
            aVar2.oOC.setOnClickListener(this);
            aVar2.kbO = relativeLayout.findViewById(R.h.cvd);
            aVar2.oOD = (ImageView) relativeLayout.findViewById(R.h.cWs);
            aVar2.oOE = (ImageView) relativeLayout.findViewById(R.h.cyk);
            aVar2.oOF = (TextView) relativeLayout.findViewById(R.h.cPY);
            aVar2.oOG = (ImageView) relativeLayout.findViewById(R.h.ctA);
            relativeLayout.setTag(aVar2);
            relativeLayout.setVisibility(8);
            this.oOt = relativeLayout;
            this.oOi.addView(relativeLayout);
        }
        this.oOi.setVisibility(8);
        if (o.bdB().bcX()) {
            this.oOm.setVisibility(0);
        } else {
            this.oOm.setVisibility(8);
        }
        this.oOx = "";
    }

    public final void o(MultiTalkGroup multiTalkGroup) {
        this.oOj.setVisibility(0);
        LinkedList linkedList = new LinkedList();
        for (MultiTalkGroupMember multiTalkGroupMember : multiTalkGroup.zZG) {
            if (multiTalkGroupMember.status == 10 || multiTalkGroupMember.status == 1) {
                linkedList.add(multiTalkGroupMember);
            }
        }
        Z(linkedList);
    }

    private void Z(LinkedList<MultiTalkGroupMember> linkedList) {
        int i;
        int i2;
        int i3;
        float[] fArr;
        this.oOy = linkedList.size();
        LayoutParams layoutParams = this.oOh.getLayoutParams();
        if (this.oOy <= 4) {
            i = this.oOq / 2;
            i2 = this.oOr / 2 > i ? i : this.oOr / 2;
            layoutParams.height = i2 * 2;
            i3 = i;
            i = i2;
        } else if (this.oOy <= 9) {
            i = this.oOq / 3;
            i2 = this.oOr / 3 > i ? i : this.oOr / 3;
            layoutParams.height = i2 * 3;
            i3 = i;
            i = i2;
        } else {
            x.e("MicroMsg.MT.MultiTalkTalkingUILogic", "onlineUserSize larger than 9, %s", Integer.valueOf(this.oOy));
            return;
        }
        this.oOh.setLayoutParams(layoutParams);
        x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "talkingAvatarWidth: %d | talkingAvatarHeight: %d | size %d", Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(this.oOy));
        HashSet hashSet = new HashSet();
        hashSet.addAll(o.bdB().oLL);
        if (o.bdB().bcX()) {
            hashSet.add(q.FY());
        }
        if (this.oOy <= 4) {
            fArr = com.tencent.mm.plugin.multitalk.a.i.oMt[this.oOy];
        } else {
            fArr = com.tencent.mm.plugin.multitalk.a.i.oMt[5];
        }
        if (fArr != null) {
            i2 = 0;
            while (true) {
                int i4 = i2;
                if (i4 >= fArr.length) {
                    break;
                }
                MultiTalkGroupMember multiTalkGroupMember;
                if (this.oOy > i4 / 2) {
                    multiTalkGroupMember = (MultiTalkGroupMember) linkedList.get(i4 / 2);
                } else {
                    multiTalkGroupMember = null;
                }
                i2 = (int) (fArr[i4] * ((float) i3));
                int i5 = (int) (fArr[i4 + 1] * ((float) i));
                if (this.oOy == 2 && i2 == 0) {
                    i2 = 1;
                }
                if (this.oOy == 4 && r0 == 0) {
                    i2 = 1;
                }
                int i6 = i2;
                RelativeLayout relativeLayout = (RelativeLayout) this.oOs.get(i4 / 2);
                LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.width = i3;
                layoutParams2.height = i;
                layoutParams2.leftMargin = i6;
                layoutParams2.topMargin = i5;
                relativeLayout.setLayoutParams(layoutParams2);
                a(relativeLayout, multiTalkGroupMember, false, hashSet);
                relativeLayout.setVisibility(0);
                i2 = i4 + 2;
            }
        }
        if (this.oOy <= 4) {
            i2 = this.oOy;
            while (true) {
                i = i2;
                if (i >= 9) {
                    break;
                }
                ((RelativeLayout) this.oOs.get(i)).setVisibility(8);
                i2 = i + 1;
            }
        }
        if (o.bdB().bda() && this.oOn != null && !this.oOn.isChecked()) {
            o.bdB().ty(1);
        }
    }

    private static void a(RelativeLayout relativeLayout, MultiTalkGroupMember multiTalkGroupMember, boolean z, HashSet<String> hashSet) {
        a aVar = (a) relativeLayout.getTag();
        if (multiTalkGroupMember != null) {
            aVar.oOC.Go(multiTalkGroupMember.zZH);
            aVar.oOC.position = aVar.oOC.index;
            if (multiTalkGroupMember.status != 10) {
                aVar.kbO.setVisibility(0);
                if (aVar.oOG.getBackground() != null) {
                    aVar.oOG.setVisibility(0);
                    ((AnimationDrawable) aVar.oOG.getBackground()).stop();
                    ((AnimationDrawable) aVar.oOG.getBackground()).start();
                }
            } else {
                aVar.kbO.setVisibility(8);
                a(aVar);
            }
            if (!hashSet.contains(multiTalkGroupMember.zZH) || z) {
                aVar.oOC.bdL();
                return;
            } else {
                aVar.oOC.bdM();
                return;
            }
        }
        aVar.kbO.setVisibility(8);
        a(aVar);
        aVar.oOC.bdN();
    }

    public final RelativeLayout Gn(String str) {
        Iterator it = this.oOs.iterator();
        while (it.hasNext()) {
            RelativeLayout relativeLayout = (RelativeLayout) it.next();
            if (str.equals(((a) relativeLayout.getTag()).oOC.username)) {
                return relativeLayout;
            }
        }
        return null;
    }

    private static int p(boolean z, int i) {
        int i2;
        if (z) {
            i2 = i;
        } else {
            i2 = -1;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.order(ByteOrder.LITTLE_ENDIAN).putInt(i2);
        int appCmd = o.bdA().oLv.setAppCmd(22, allocate.array(), 4);
        if (appCmd >= 0) {
            return appCmd;
        }
        x.e("MicroMsg.MT.MultiTalkTalkingUILogic", "steve:set netBigVideo failed or NO need!, ret:%d, vID:%d, memberId:%d", Integer.valueOf(appCmd), Integer.valueOf(i2), Integer.valueOf(i));
        return -1;
    }

    public final void onClick(View view) {
        MultiTalkGroupMember multiTalkGroupMember = null;
        boolean z = true;
        if (view instanceof MultiTalkVideoView) {
            MultiTalkVideoView multiTalkVideoView = (MultiTalkVideoView) view;
            a aVar;
            if (this.oOi.getVisibility() != 8) {
                if (!multiTalkVideoView.username.equals(q.FY())) {
                    x.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: unsubscribe big video!");
                    o.bdB().FW("");
                    p(false, -1);
                }
                this.oOi.setVisibility(8);
                this.oOh.setVisibility(0);
                if (this.oOt != null) {
                    aVar = (a) this.oOt.getTag();
                    if (aVar != null) {
                        aVar.oOC.bdN();
                    }
                }
                this.oOx = "";
                d.bcW();
            } else if (multiTalkVideoView.bdQ()) {
                int i;
                this.oOi.setVisibility(0);
                this.oOh.setVisibility(8);
                LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.width = this.oOq;
                layoutParams.height = this.oOq;
                layoutParams.leftMargin = 0;
                layoutParams.topMargin = 0;
                this.oOt.setLayoutParams(layoutParams);
                String str = multiTalkVideoView.username;
                for (MultiTalkGroupMember multiTalkGroupMember2 : o.bdB().oLN.zZG) {
                    MultiTalkGroupMember multiTalkGroupMember22;
                    if ((multiTalkGroupMember22.status != 10 && multiTalkGroupMember22.status != 1) || !multiTalkGroupMember22.zZH.equals(str)) {
                        multiTalkGroupMember22 = multiTalkGroupMember;
                    }
                    multiTalkGroupMember = multiTalkGroupMember22;
                }
                TalkRoom acE = com.tencent.wecall.talkroom.model.c.cIA().acE(o.bdB().oLN.zZC);
                if (acE != null) {
                    for (av avVar : acE.cIx()) {
                        if (avVar.zXO.equals(str)) {
                            i = avVar.nJK;
                            break;
                        }
                    }
                }
                i = 0;
                if (!str.equals(q.FY())) {
                    x.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve:click memberId:%d", Integer.valueOf(i));
                    o.bdB().FW(str);
                    p(true, i);
                }
                if (!(ao.is2G(this.oNL) || ao.is3G(this.oNL))) {
                    z = false;
                }
                HashSet hashSet = new HashSet();
                hashSet.addAll(o.bdB().oLL);
                if (o.bdB().bcX()) {
                    hashSet.add(q.FY());
                }
                aVar = (a) this.oOt.getTag();
                aVar.oOC.Go(str);
                aVar.oOC.bdN();
                this.oOt.setTag(aVar);
                a(this.oOt, multiTalkGroupMember, z, hashSet);
                this.oOt.setVisibility(0);
                this.oOx = str;
                d.bcV();
            }
        } else if (view.getId() == R.h.cQB) {
            o.bdB().c(true, false, false);
        } else if (view.getId() == R.h.cya) {
            d.oLC++;
            o.bdB().gV(true);
            d.bcU();
        } else if (view.getId() == R.h.cxX) {
            d.oLE++;
            o.bdB().gW(this.oOp.isChecked());
            if (this.oOp.isChecked()) {
                d.bcP();
            } else {
                d.bcQ();
            }
        } else if (view.getId() == R.h.cyb) {
            d.oLD++;
            e bdB = o.bdB();
            boolean isChecked = this.oOo.isChecked();
            o.bdA().oLv.nT(isChecked);
            bdB.gQ(isChecked);
            if (this.oOo.isChecked()) {
                d.bcN();
            } else {
                d.bcO();
            }
        } else if (view.getId() == R.h.cxV) {
            if (this.oOu != null) {
                this.oOu.bJe();
            }
            d.bcT();
        } else if (view.getId() == R.h.cyj) {
            d.oLF++;
            if (!com.tencent.mm.compatible.f.b.zh()) {
                com.tencent.mm.at.a.a(this.oNL, R.l.eVQ, null);
                this.oOn.setChecked(false);
            } else if (!o.bdB().bda()) {
                this.oOn.setChecked(false);
            } else if (!ao.isNetworkConnected(this.oNL)) {
                com.tencent.mm.at.a.a(this.oNL, R.l.eVP, null);
                this.oOn.setChecked(false);
            } else if (com.tencent.mm.plugin.multitalk.a.i.bdu()) {
                if (this.oOn.isChecked()) {
                    a(null, false);
                    d.bcR();
                } else {
                    gY(false);
                    o.bdB().ty(1);
                    d.bcS();
                }
                this.oOn.setChecked(o.bdB().bcX());
            } else {
                Toast.makeText(this.oNL, R.l.ewj, 1).show();
                this.oOn.setChecked(false);
            }
        } else if (view.getId() == R.h.cxS) {
            d.oLG++;
            this.oNL.bdG();
        }
    }

    public final void c(HashSet<String> hashSet) {
        Iterator it = this.oOs.iterator();
        while (it.hasNext()) {
            a aVar = (a) ((RelativeLayout) it.next()).getTag();
            if (!q.FY().equals(aVar.oOC.username)) {
                if (hashSet.contains(aVar.oOC.username)) {
                    if (!aVar.oOC.bdQ()) {
                        aVar.oOC.bdM();
                    }
                } else if (aVar.oOC.bdQ()) {
                    aVar.oOC.bdL();
                    if (this.oOx.equals(aVar.oOC.username) && this.oOi.getVisibility() == 0) {
                        this.oOx = "";
                        this.oOi.setVisibility(8);
                        this.oOh.setVisibility(0);
                    }
                }
            }
        }
    }

    public final void bdI() {
        Iterator it = this.oOs.iterator();
        while (it.hasNext()) {
            a aVar = (a) ((RelativeLayout) it.next()).getTag();
            if (!q.FY().equals(aVar.oOC.username) && aVar.oOC.bdQ()) {
                aVar.oOC.bdL();
            }
        }
    }

    public final void a(RelativeLayout relativeLayout, boolean z) {
        ViewGroup Gn;
        if (!z) {
            this.oOz = System.currentTimeMillis();
        }
        x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "start capture render");
        if (this.oOi == null || this.oOi.getVisibility() != 0) {
            Gn = Gn(q.FY());
        } else {
            Gn = (ViewGroup) this.oNL.findViewById(R.h.cIH);
        }
        if (Gn != null) {
            if (this.oOw == null) {
                x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "create capture View");
                this.oOw = new ObservableTextureView(this.oNL);
                this.oOw.setLayoutParams(new RelativeLayout.LayoutParams(1, 1));
                Gn.addView(this.oOw);
                this.oOw.setVisibility(0);
            }
            if (this.oOu == null) {
                x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "create capture Render");
                this.oOu = new com.tencent.mm.plugin.voip.video.a(320, 240);
                this.oOu.a((com.tencent.mm.plugin.voip.video.f) this, true);
                this.oOu.a(this.oOw);
                this.oOu.bJf();
                if (!o.bdB().oLK) {
                    this.oOu.bJe();
                }
                x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", Boolean.valueOf(this.oOu.bJi()), Boolean.valueOf(this.oOu.bJj()));
            }
            if (this.oOv == null) {
                this.oOv = new j(this.oNL);
                com.tencent.mm.sdk.f.e.d(new Runnable() {
                    public final void run() {
                        Looper.prepare();
                        x.i("MicroMsg.MT.MultiTalkVideoNativeReceiver", "start native drawer handler");
                        j.this.oMz = new ag();
                        Looper.loop();
                    }
                }, "MultiTalkVideoTaskManager_native_drawer_handler", 1).start();
            }
        }
    }

    public final void gY(boolean z) {
        if (!z && this.oOz != 0 && System.currentTimeMillis() - this.oOz > 0 && o.bdB().bdb()) {
            d.n(System.currentTimeMillis() - this.oOz, com.tencent.mm.plugin.multitalk.a.i.bdq());
            this.oOz = 0;
        }
        x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "stop capture render");
        if (this.oOw != null) {
            ViewParent parent = this.oOw.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.oOw);
            }
            this.oOw = null;
        }
        if (this.oOu != null) {
            this.oOu.bJg();
            com.tencent.mm.plugin.voip.video.a.bJh();
            this.oOu = null;
        }
        if (this.oOv != null) {
            j jVar = this.oOv;
            jVar.oLV = null;
            jVar.oMA.mgx = false;
            jVar.oMA.oME = null;
            if (jVar.oMz != null) {
                jVar.oMz.removeCallbacksAndMessages(null);
                jVar.oMz.getLooper().quit();
                jVar.oMz = null;
            }
            this.oOv = null;
        }
    }

    public final void gZ(boolean z) {
        x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onRefreshed");
        this.oOy = 0;
        if (!z) {
            ah.y(new Runnable() {
                public final void run() {
                    f.this.ljv.setText(R.l.ewk);
                }
            });
        }
        gY(false);
        Iterator it = this.oOs.iterator();
        while (it.hasNext()) {
            ((a) ((RelativeLayout) it.next()).getTag()).oOC.setSurfaceTextureListener(null);
        }
        n.JF().b(this);
    }

    public final void c(byte[] bArr, long j, int i, int i2, int i3) {
        if (o.bdB().bda()) {
            if (this.oOA.oME == null) {
                this.oOA.w = i;
                this.oOA.h = i2;
                this.oOA.oME = new int[(this.oOA.w * this.oOA.h)];
            }
            if (!o.bdB().bcX()) {
                com.tencent.mm.plugin.multitalk.a.i.bds();
                o.bdB().ty(3);
            }
            long currentTimeMillis = System.currentTimeMillis();
            o.bdB().oLK = this.oOu.bJi();
            int i4 = this.oOu.bJi() ? OpenGlRender.sAp : 0;
            int i5 = this.oOu.bJj() ? OpenGlRender.sAo : OpenGlRender.sAn;
            g a = o.bdA().oLv.a(bArr, (int) j, this.oOA.w, this.oOA.h, i3 & 31, this.oOA.oME);
            if (a.ret < 0 || this.oOA.oME == null || a.zZP == 0 || a.zZQ == 0) {
                x.e("MicroMsg.MT.MultiTalkTalkingUILogic", "ret: %d", Integer.valueOf(a.ret));
                return;
            }
            int i6;
            long currentTimeMillis2 = System.currentTimeMillis();
            int i7 = i4 == OpenGlRender.sAp ? 257 : 1;
            if (o.bdB().oLX) {
                i6 = i4 == OpenGlRender.sAp ? 259 : 3;
            } else {
                i6 = i7;
            }
            i7 = o.bdA().oLv.a(bArr, (short) ((int) j), i, i2, i3, i6);
            if (System.currentTimeMillis() - currentTimeMillis > 30) {
                x.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: trans size:%dx%d, total: %d, trans: %d, enc: %d", Integer.valueOf(a.zZP), Integer.valueOf(a.zZQ), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
            }
            if (i7 <= 0) {
                x.v("MicroMsg.MT.MultiTalkTalkingUILogic", "send ret = %d", Integer.valueOf(i7));
            }
            if (this.oOv != null && this.oOA.oME != null) {
                j jVar = this.oOv;
                int[] iArr = this.oOA.oME;
                i7 = a.zZP;
                int i8 = a.zZQ;
                if (iArr == null) {
                    x.e("MicroMsg.MT.MultiTalkVideoNativeReceiver", "onDrawerReady pBuffer is null");
                    return;
                } else if (jVar.oMA.mgx) {
                    x.d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "onDrawerReady busy!!!!");
                    return;
                } else {
                    if (jVar.oMA.oME == null) {
                        jVar.oMA.oME = new int[iArr.length];
                    }
                    jVar.oMA.w = i7;
                    jVar.oMA.h = i8;
                    jVar.oMA.oMC = i3;
                    jVar.oMA.oMD = i4;
                    jVar.oMA.angle = i5;
                    long currentTimeMillis3 = System.currentTimeMillis();
                    i6 = jVar.oMA.h;
                    if (jVar.oMA.h > jVar.oMA.w) {
                        i6 = jVar.oMA.w;
                    }
                    if (jVar.oMA.mZu == null) {
                        jVar.oMA.mZu = Bitmap.createBitmap(i6, i6, Config.RGB_565);
                    }
                    if (jVar.oMA.mZu != null) {
                        jVar.oMA.mZu.setPixels(iArr, jVar.oMA.w - jVar.oMA.h, jVar.oMA.w, 0, 0, i6, i6);
                    }
                    if (System.currentTimeMillis() - currentTimeMillis3 > 30) {
                        x.d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "steve: createBitmap: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                    }
                    if (jVar.oMz != null) {
                        jVar.oMz.post(new com.tencent.mm.plugin.multitalk.a.j.b());
                        return;
                    }
                    return;
                }
            }
            return;
        }
        gY(false);
    }

    public final synchronized void a(String str, int[] iArr, int i, int i2, int i3, int i4) {
        if (this.oOi.getVisibility() == 0) {
            a aVar = (a) this.oOt.getTag();
            if (str.equals(aVar.oOC.username)) {
                aVar.oOC.a(iArr, i, i2, 0, i4);
            }
        } else {
            RelativeLayout Gn = Gn(str);
            if (Gn != null) {
                ((a) Gn.getTag()).oOC.a(iArr, i, i2, 0, i4);
            }
        }
    }

    public final synchronized void a(String str, Bitmap bitmap, int i, int i2) {
        if (this.oOi.getVisibility() == 0) {
            a aVar = (a) this.oOt.getTag();
            if (str.equals(aVar.oOC.username)) {
                aVar.oOC.b(bitmap, i2, i);
            }
        } else {
            RelativeLayout Gn = Gn(str);
            if (Gn != null) {
                ((a) Gn.getTag()).oOC.b(bitmap, i2, i);
            }
        }
    }

    public final void bdJ() {
        x.e("MicroMsg.MT.MultiTalkTalkingUILogic", "onCameraError");
        if (this.iqG == null) {
            this.iqG = com.tencent.mm.at.a.a(this.oNL, R.l.eVQ, new Runnable() {
                public final void run() {
                    f.this.gY(false);
                }
            });
        }
        if (!this.iqG.isShowing()) {
            this.iqG.show();
        }
        o.bdB().ty(1);
    }

    public final void jk(String str) {
        x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "notifyChanged %s", str);
        RelativeLayout Gn = Gn(str);
        if (Gn != null) {
            ((a) Gn.getTag()).oOC.bdK();
        }
    }

    private static void a(a aVar) {
        if (aVar.oOG.getBackground() != null) {
            ((AnimationDrawable) aVar.oOG.getBackground()).stop();
        }
        aVar.oOG.setVisibility(8);
    }
}
