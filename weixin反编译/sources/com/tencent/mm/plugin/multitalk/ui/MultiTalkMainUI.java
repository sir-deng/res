package com.tencent.mm.plugin.multitalk.ui;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.f.a.jr;
import com.tencent.mm.plugin.multitalk.a.i;
import com.tencent.mm.plugin.multitalk.a.m;
import com.tencent.mm.plugin.multitalk.a.o;
import com.tencent.mm.plugin.multitalk.ui.widget.c;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.plugin.multitalk.ui.widget.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@a(3)
public class MultiTalkMainUI extends MMActivity implements com.tencent.mm.plugin.multitalk.a.a {
    protected ag lKV;
    private c oNj;
    private f oNk;
    private boolean oNl;
    private boolean oNm = true;
    private boolean oNn = false;
    private Runnable oNo = new Runnable() {
        public final void run() {
            o.bdB().bdj();
        }
    };
    private boolean oNp;
    private BroadcastReceiver oNq = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction()) && o.bdB().oLM == e.Inviting) {
                o.bdB().stopRing();
                MultiTalkMainUI.this.oNm = false;
            }
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        int intExtra = getIntent().getIntExtra("enterMainUiSource", 0);
        if (intExtra == 1 || intExtra == 2) {
            overridePendingTransition(R.a.bqk, R.a.bpQ);
        } else {
            overridePendingTransition(R.a.bqD, R.a.bqE);
        }
        getWindow().addFlags(6946944);
        o.bdB().aTG();
        if (o.bdB().bcZ()) {
            this.oNj = new c(this);
            this.oNk = new f(this);
            o.bdB().gW(o.bdB().oLI);
            o.bdB().oLV = this;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            registerReceiver(this.oNq, intentFilter);
            this.oNn = true;
            this.lKV = new ag();
            as.Hn().xP();
            if (!com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 82, "", "")) {
                x.i("MicroMsg.MT.MultiTalkMainUI", "has not audio record permission!");
                return;
            }
            return;
        }
        finish();
        if (intExtra == 2) {
            getIntent().getStringExtra("enterMainUiWxGroupId");
        }
    }

    protected final int getLayoutId() {
        return R.i.doD;
    }

    protected void onResume() {
        super.onResume();
        switch (o.bdB().oLM) {
            case Inviting:
                this.oNk.oOj.setVisibility(8);
                this.oNj.n(o.bdB().oLN);
                if (ao.is4G(this)) {
                    o.bdz().z(this);
                } else if (ao.is2G(this) || ao.is3G(this)) {
                    o.bdz().y(this);
                }
                if (this.oNm) {
                    o.bdB().gX(false);
                    break;
                }
                break;
            case Starting:
            case Creating:
                this.oNj.bdH();
                this.oNk.o(o.bdB().oLN);
                if (ao.is4G(this)) {
                    o.bdz().z(this);
                } else if (ao.is2G(this) || ao.is3G(this)) {
                    o.bdz().y(this);
                }
                o.bdB().gX(true);
                break;
            case Talking:
                this.oNj.bdH();
                this.oNk.o(o.bdB().oLN);
                break;
        }
        if (o.bdB().bda()) {
            if (o.bdB().bcX()) {
                this.oNk.a(null, true);
            }
            this.lKV.postDelayed(this.oNo, 2000);
        }
    }

    protected void onPause() {
        PowerManager powerManager = (PowerManager) ad.getContext().getSystemService("power");
        boolean z = (hasWindowFocus() || !((KeyguardManager) ad.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) && powerManager.isScreenOn();
        this.oNl = z;
        x.i("MicroMsg.MT.MultiTalkMainUI", "onPause, screenOn: %b", Boolean.valueOf(this.oNl));
        if (o.bdB().bda()) {
            o.bdB().bdk();
            this.oNk.gY(true);
        }
        super.onPause();
    }

    protected void onDestroy() {
        if (this.oNp) {
            o.bdB().gV(false);
        }
        if (this.oNn) {
            unregisterReceiver(this.oNq);
        }
        super.onDestroy();
    }

    protected void onStop() {
        if (!this.oNp && this.oNl) {
            o.bdB().gV(false);
        }
        super.onStop();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            h.a((Context) this, R.l.ewB, R.l.ewg, R.l.dDX, R.l.dEy, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    o.bdB().c(false, false, false);
                }
            }, null);
            return true;
        }
        if (o.bdB().oLM == e.Inviting) {
            if (i == 25 || i == 24) {
                o.bdB().stopRing();
                this.oNm = false;
                return true;
            }
        } else if (i == 25) {
            as.Hn().fA(aUy());
            return true;
        } else if (i == 24) {
            as.Hn().fz(aUy());
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    private static int aUy() {
        if (as.Hn().xS()) {
            return as.Hn().ye();
        }
        if (o.bdB().nIN.aiV()) {
            return 0;
        }
        return 3;
    }

    public final void bdG() {
        this.oNp = true;
        Intent intent = new Intent(this, MultiTalkAddMembersUI.class);
        List arrayList = new ArrayList();
        for (MultiTalkGroupMember multiTalkGroupMember : o.bdB().oLN.zZG) {
            if (multiTalkGroupMember.status == 10 || multiTalkGroupMember.status == 1) {
                arrayList.add(multiTalkGroupMember.zZH);
            }
        }
        intent.putExtra("titile", getString(R.l.ewh));
        intent.putExtra("chatroomName", o.bdB().oLN.zZE);
        intent.putExtra("always_select_contact", bi.d(arrayList, ","));
        intent.putExtra("key_need_gallery", false);
        startActivityForResult(intent, 1);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.MT.MultiTalkMainUI", "onActivityResult " + i + " resultCode " + i2);
        super.onActivityResult(i, i2, intent);
        this.oNp = false;
        if (i2 == -1 && i == 1) {
            String stringExtra = intent.getStringExtra("Select_Contact");
            x.i("MicroMsg.MT.MultiTalkMainUI", "add member " + stringExtra);
            List F = bi.F(stringExtra.split(","));
            if (F != null) {
                com.tencent.mm.plugin.multitalk.a.e bdB = o.bdB();
                if (bdB.bcZ()) {
                    stringExtra = bdB.oLN.zZC;
                    if (bi.oN(stringExtra)) {
                        stringExtra = bdB.oLN.zZD;
                    }
                    o.bdA().oLv.u(stringExtra, F);
                }
            }
        }
    }

    public final void bcx() {
        switch (o.bdB().oLM) {
            case Inviting:
                this.oNj.n(o.bdB().oLN);
                return;
            case Starting:
            case Creating:
            case Talking:
                this.oNk.o(o.bdB().oLN);
                return;
            default:
                return;
        }
    }

    public final void aZD() {
        this.oNj.bdH();
        this.oNk.o(o.bdB().oLN);
    }

    public final void aTN() {
        b jrVar = new jr();
        jrVar.fBl.action = 0;
        com.tencent.mm.sdk.b.a.xmy.m(jrVar);
        this.oNk.gZ(true);
        o.bdB().oLV = null;
        o.bdB().stopRing();
        finish();
    }

    public final void bcw() {
        as.Hn().xQ();
        com.tencent.mm.sdk.f.e.post(new Runnable() {
            public final void run() {
                e.this.nIN.stop();
                e.this.nIN.e(R.k.dAw, false, 0);
            }
        }, "MultiTalkManager_play_end_sound");
        b jrVar = new jr();
        jrVar.fBl.action = 0;
        com.tencent.mm.sdk.b.a.xmy.m(jrVar);
        this.oNk.gZ(false);
        o.bdB().oLV = null;
        o.bdB().stopRing();
        finish();
    }

    public final void onError(int i) {
        if (i == -1700) {
            f fVar = this.oNk;
            x.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onSwitchVideoDisabled");
            fVar.gY(false);
            o.bdB().ty(1);
            fVar.oOn.setChecked(false);
        }
    }

    public final void bcy() {
        x.i("MicroMsg.MT.MultiTalkMainUI", "onVideoGroupMemberChange, SubCoreMultiTalk.getMultiTalkManager().getCurrentVideoUserSet().size(): " + o.bdB().oLL.size());
        if (o.bdB().bda()) {
            if (o.bdB().oLL.size() > 0) {
                i.bds();
                o.bdB().bdj();
            } else {
                o.bdB().bdk();
            }
            f fVar = this.oNk;
            HashSet hashSet = new HashSet();
            hashSet.addAll(o.bdB().oLL);
            if (o.bdB().bcY()) {
                fVar.c(hashSet);
            }
        }
    }

    public final void gQ(boolean z) {
        if (o.bdB().bda()) {
            this.oNk.oOo.setChecked(z);
        }
    }

    public final void gR(boolean z) {
        if (o.bdB().bda()) {
            this.oNk.oOp.setChecked(z);
        }
    }

    public final void cU(int i, int i2) {
        if (o.bdB().bda()) {
            f fVar = this.oNk;
            f.a aVar = (f.a) fVar.Gn(q.FY()).getTag();
            if (!i.tz(i2)) {
                if (i.tz(i)) {
                    fVar.oOn.setChecked(false);
                    aVar.oOC.bdL();
                    fVar.oOm.setVisibility(8);
                    if (fVar.oOx.equals(q.FY()) && fVar.oOi.getVisibility() == 0) {
                        fVar.oOx = "";
                        fVar.oOh.setVisibility(0);
                        fVar.oOi.setVisibility(8);
                    }
                }
                fVar.gY(false);
            } else if (i.tz(i2) && !i.tz(i)) {
                fVar.oOn.setChecked(true);
                aVar.oOC.bdM();
                aVar.oOF.setVisibility(8);
                ah.h(new b(aVar), 1500);
                fVar.oOm.setVisibility(0);
            }
            HashSet hashSet = new HashSet();
            hashSet.addAll(o.bdB().oLL);
            if (i.tA(i2)) {
                if (i.tA(i2) && !i.tA(i)) {
                    fVar.c(hashSet);
                }
            } else if (i.tA(i)) {
                fVar.bdI();
            }
        }
    }

    public final void a(String str, int[] iArr, int i, int i2, int i3) {
        if (o.bdB().bda()) {
            this.oNk.a(str, iArr, i, i2, 0, i3);
        }
    }

    public final void a(String str, Bitmap bitmap, int i, int i2) {
        this.oNk.a(str, bitmap, i, i2);
    }

    public final int FT(String str) {
        RelativeLayout Gn = this.oNk.Gn(str);
        return Gn == null ? -1 : ((f.a) Gn.getTag()).oOC.position;
    }

    public final void a(e eVar) {
        if (eVar == e.Talking) {
            f fVar = this.oNk;
            if (fVar.oOz > 0) {
                fVar.oOz = System.currentTimeMillis();
            }
        }
    }

    public final void a(i.a aVar) {
        if (aVar == i.a._4G) {
            o.bdz().z(this);
        } else if (aVar == i.a._3GOr_2G) {
            o.bdz().y(this);
        } else if (aVar == i.a.None) {
            com.tencent.mm.at.a.a(this, R.l.eVP, null);
        }
    }

    public final void aTO() {
        f.a aVar;
        f fVar = this.oNk;
        long j = (long) o.bdB().oLP;
        fVar.ljv.setText(String.format("%02d:%02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)}));
        com.tencent.mm.plugin.multitalk.a.e bdB = o.bdB();
        String str = bdB.oLN.zZC;
        if (bi.oN(str)) {
            str = bdB.oLN.zZD;
        }
        List abv = o.bdA().oLv.abv(str);
        if (abv != null) {
            Iterator it = fVar.oOs.iterator();
            while (it.hasNext()) {
                aVar = (f.a) ((RelativeLayout) it.next()).getTag();
                if (abv.contains(aVar.oOC.username)) {
                    aVar.oOD.setVisibility(0);
                } else {
                    aVar.oOD.setVisibility(8);
                }
            }
        }
        bdB = o.bdB();
        str = bdB.oLN.zZC;
        if (bi.oN(str)) {
            str = bdB.oLN.zZD;
        }
        if (m.oMX == null) {
            m.oMX = new m();
        }
        m mVar = m.oMX;
        List arrayList = new ArrayList();
        mVar.oMY = com.tencent.wecall.talkroom.model.c.cIA().acE(str);
        if (mVar.oMY != null) {
            for (av avVar : mVar.oMY.cIx()) {
                int i = avVar.nJK;
                if (i >= 0) {
                    byte[] bArr = new byte[4];
                    if (o.bdA().oLv.setAppCmd(10, bArr, i) < 0) {
                        x.d("MicroMsg.Multitalk.VoipNetStatusChecker", "get netStatus failed memberId :%d", Integer.valueOf(i));
                        i = -1;
                    } else {
                        i = bi.aI(bArr);
                        x.d("MicroMsg.Multitalk.VoipNetStatusChecker", "netStatus: %d", Integer.valueOf(i));
                    }
                    Object obj = (i == -1 || i >= 5) ? null : 1;
                    if (obj != null) {
                        arrayList.add(avVar.zXO);
                    }
                }
            }
        }
        Iterator it2 = fVar.oOs.iterator();
        while (it2.hasNext()) {
            aVar = (f.a) ((RelativeLayout) it2.next()).getTag();
            if (arrayList.contains(aVar.oOC.username)) {
                aVar.oOE.setVisibility(0);
            } else {
                aVar.oOE.setVisibility(8);
            }
        }
    }

    public final boolean bcz() {
        if (this.oNk == null || this.oNk.oOu == null) {
            return false;
        }
        return true;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
            x.e("MicroMsg.MT.MultiTalkMainUI", "[multitalk]onRequestPermissionsResult %d data is invalid", Integer.valueOf(i));
            return;
        }
        x.d("MicroMsg.MT.MultiTalkMainUI", "[multitalk] onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 82:
                if (iArr[0] == 0) {
                    x.d("MicroMsg.MT.MultiTalkMainUI", "granted record audio!");
                    return;
                } else {
                    h.a((Context) this, getString(R.l.eAd), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            MultiTalkMainUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }
}
