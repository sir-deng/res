package com.tencent.mm.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.u;
import com.tencent.mm.af.y;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.gx;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.mz;
import com.tencent.mm.protocal.c.na;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.account.SimpleLoginUI;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.ArrayList;
import java.util.LinkedList;

public class CheckCanSubscribeBizUI extends MMActivity implements e, a, b {
    private String appId;
    private int cPf;
    private String extInfo;
    private int fromScene;
    private String fue;
    private boolean hjU = false;
    private String mTU;
    private int scene;
    private String toUserName;
    private boolean xMA = false;
    private boolean xMB = false;
    private String xMC;
    private int xMD = 0;
    private int xMw;
    private LinkedList<bet> xMx;
    private boolean xMy = false;
    private boolean xMz = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        if (!as.Ho() || as.Cz()) {
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class), getIntent());
            finish();
            return;
        }
        as.CN().a(605, (e) this);
        as.Hm();
        c.Ff().a(this);
        y.Ml().c(this);
        if (adC()) {
            String str = this.appId;
            String str2 = this.toUserName;
            String str3 = this.extInfo;
            int i = this.xMw;
            LinkedList linkedList = this.xMx;
            String str4 = this.fue;
            int i2 = this.cPf;
            int i3 = this.scene;
            com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
            aVar.hnT = new mz();
            aVar.hnU = new na();
            aVar.uri = "/cgi-bin/micromsg-bin/checkcansubscribebiz";
            aVar.hnS = 605;
            com.tencent.mm.ad.b Kf = aVar.Kf();
            mz mzVar = (mz) Kf.hnQ.hnY;
            mzVar.nkU = str;
            mzVar.npV = str2;
            mzVar.nqi = str3;
            mzVar.wct = i;
            mzVar.wcu = linkedList;
            mzVar.wcv = null;
            mzVar.wcw = str4;
            mzVar.vON = i2;
            mzVar.sfa = i3;
            x.i("MicroMsg.CheckCanSubscribeBizUI", "appId(%s) , toUsername(%s) , extInfo(%s) , packNum(%d), scene(%d)", str, str2, str3, Integer.valueOf(i), Integer.valueOf(i3));
            u.a(Kf, new u.a() {
                public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                    na naVar = (na) bVar.hnR.hnY;
                    CheckCanSubscribeBizUI.this.mTU = naVar.wcx;
                    if (i == 0 && i2 == 0 && !bi.oN(naVar.wcx) && !bi.oN(naVar.npV)) {
                        CheckCanSubscribeBizUI.this.toUserName = naVar.npV;
                        CheckCanSubscribeBizUI.this.xMC = naVar.wcy;
                        CheckCanSubscribeBizUI.this.cmD();
                    } else if (t.a.a(CheckCanSubscribeBizUI.this, i, i2, str, 7)) {
                        CheckCanSubscribeBizUI.this.setResult(5);
                        CheckCanSubscribeBizUI.this.finish();
                    } else {
                        CheckCanSubscribeBizUI.this.cmF();
                        CheckCanSubscribeBizUI.this.setResult(3);
                        CheckCanSubscribeBizUI.this.finish();
                    }
                    return 0;
                }
            });
            return;
        }
        setResult(2);
        cmG();
        finish();
    }

    public void onStart() {
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.xMx != null) {
            this.xMx.clear();
        }
        if (as.Hp()) {
            as.CN().b(605, (e) this);
            y.Ml().j(this);
            as.Hm();
            c.Ff().b(this);
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.dmB;
    }

    private boolean adC() {
        Intent intent = getIntent();
        if (intent == null) {
            x.e("MicroMsg.CheckCanSubscribeBizUI", "intent is null.");
            return false;
        }
        this.appId = intent.getStringExtra("appId");
        this.toUserName = intent.getStringExtra("toUserName");
        if (bi.oN(this.toUserName)) {
            x.e("MicroMsg.CheckCanSubscribeBizUI", "toUserName is null.");
            return false;
        }
        this.extInfo = intent.getStringExtra("extInfo");
        this.cPf = intent.getIntExtra("source", -1);
        this.scene = intent.getIntExtra("scene", 0);
        this.xMD = intent.getIntExtra("jump_profile_type", 0);
        switch (this.cPf) {
            case 1:
                if (!bi.oN(this.appId)) {
                    this.fromScene = 68;
                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("androidPackNameList");
                    if (stringArrayListExtra != null && stringArrayListExtra.size() != 0) {
                        this.xMx = new LinkedList();
                        for (int i = 0; i < stringArrayListExtra.size(); i++) {
                            String str = (String) stringArrayListExtra.get(i);
                            if (!bi.oN(str)) {
                                x.i("MicroMsg.CheckCanSubscribeBizUI", "packName(%d) : %s", Integer.valueOf(i), str);
                                this.xMx.add(n.oK(str));
                            }
                        }
                        if (this.xMx.size() != 0) {
                            this.xMw = this.xMx.size();
                            break;
                        }
                        x.e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is nil.");
                        return false;
                    }
                    x.e("MicroMsg.CheckCanSubscribeBizUI", "androidPackNameList is null or nil.");
                    return false;
                }
                x.e("MicroMsg.CheckCanSubscribeBizUI", "appId is null.");
                return false;
                break;
            case 2:
                this.fromScene = 69;
                break;
            default:
                x.e("MicroMsg.CheckCanSubscribeBizUI", "source(%d) is invalidated.", Integer.valueOf(this.cPf));
                return false;
        }
        this.fue = intent.getStringExtra("fromURL");
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.CheckCanSubscribeBizUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        if (kVar.getType() == 605) {
            return;
        }
        if (kVar.getType() == 233) {
            as.CN().b(233, (e) this);
            if (i == 0 && i2 == 0) {
                l lVar = (l) kVar;
                int RN = lVar.RN();
                x.i("MicroMsg.CheckCanSubscribeBizUI", "geta8key, action code = %d", Integer.valueOf(RN));
                if (RN == 15) {
                    x.d("MicroMsg.CheckCanSubscribeBizUI", "actionCode = %s, url = %s", Integer.valueOf(RN), lVar.RL());
                    com.tencent.mm.sdk.b.b gxVar = new gx();
                    gxVar.fxW.actionCode = RN;
                    gxVar.fxW.result = r1;
                    gxVar.fxW.context = this;
                    com.tencent.mm.sdk.b.a.xmy.a(gxVar, Looper.myLooper());
                    finish();
                    return;
                }
                cmF();
                return;
            }
            cmF();
            return;
        }
        x.e("MicroMsg.CheckCanSubscribeBizUI", "un support scene type : %d", Integer.valueOf(kVar.getType()));
    }

    private synchronized void cmD() {
        x.i("MicroMsg.CheckCanSubscribeBizUI", "dealSuccess..,canJump = " + this.xMy);
        Intent intent;
        if (this.scene == 1) {
            intent = new Intent();
            intent.putExtra("rawUrl", this.xMC);
            d.b(this, "webview", ".ui.tools.WebViewUI", intent);
            finish();
        } else if (this.scene == 0 && this.xMD == 1) {
            if (this.xMA) {
                x.i("MicroMsg.CheckCanSubscribeBizUI", "has jump ignore this scene");
            } else {
                this.xMA = true;
                as.CN().a(233, (e) this);
                as.CN().a(new l(this.extInfo, null, 4, (int) System.currentTimeMillis(), new byte[0]), 0);
            }
        } else if (cmE() && this.xMy) {
            if (!this.xMA) {
                x.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ChattingUI");
                intent = new Intent().putExtra("Chat_User", this.toUserName);
                intent.putExtra("finish_direct", true);
                if (bi.oN(this.toUserName)) {
                    com.tencent.mm.ui.contact.e.a(intent, this.toUserName);
                }
                intent.setClass(this, ChattingUI.class);
                if (!this.xMz) {
                    setResult(-1);
                    this.xMA = true;
                    startActivity(intent);
                    finish();
                }
            }
        } else if (this.xMy && !this.xMA) {
            x.i("MicroMsg.CheckCanSubscribeBizUI", "jump to ContactInfoUI");
            as.Hm();
            ag Xv = c.Ff().Xv(this.toUserName);
            Intent intent2 = new Intent();
            intent2.putExtra("Contact_Scene", this.fromScene);
            intent2.putExtra("Verify_ticket", this.mTU);
            if (Xv != null) {
                intent2.putExtra("Contact_Alias", Xv.vU());
                intent2.putExtra("Contact_Nick", Xv.field_nickname);
                intent2.putExtra("Contact_Signature", Xv.signature);
                intent2.putExtra("Contact_RegionCode", Xv.fXq);
                intent2.putExtra("Contact_Sex", Xv.fXa);
                intent2.putExtra("Contact_VUser_Info", Xv.fXp);
                intent2.putExtra("Contact_VUser_Info_Flag", Xv.field_verifyFlag);
                intent2.putExtra("Contact_KWeibo_flag", Xv.field_weiboFlag);
                intent2.putExtra("Contact_KWeibo", Xv.fXo);
                intent2.putExtra("Contact_KWeiboNick", Xv.field_weiboNickname);
            }
            com.tencent.mm.ui.contact.e.l(intent2, this.toUserName);
            if (!this.xMz) {
                setResult(-1);
                this.xMA = true;
                d.b(this, "profile", ".ui.ContactInfoUI", intent2);
                finish();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean cmE() {
        /*
        r7 = this;
        r0 = 0;
        r1 = 1;
        monitor-enter(r7);
        com.tencent.mm.y.as.Hm();	 Catch:{ all -> 0x008c }
        r2 = com.tencent.mm.y.c.Ff();	 Catch:{ all -> 0x008c }
        r3 = r7.toUserName;	 Catch:{ all -> 0x008c }
        r4 = r2.Xv(r3);	 Catch:{ all -> 0x008c }
        if (r4 == 0) goto L_0x0017;
    L_0x0012:
        r2 = r4.gKO;	 Catch:{ all -> 0x008c }
        r2 = (int) r2;	 Catch:{ all -> 0x008c }
        if (r2 != 0) goto L_0x00b4;
    L_0x0017:
        r2 = "MicroMsg.CheckCanSubscribeBizUI";
        r3 = "contact is null.";
        com.tencent.mm.sdk.platformtools.x.w(r2, r3);	 Catch:{ all -> 0x008c }
        r2 = r1;
    L_0x0021:
        r3 = 0;
        if (r2 != 0) goto L_0x002a;
    L_0x0024:
        r3 = r7.toUserName;	 Catch:{ all -> 0x008c }
        r3 = com.tencent.mm.af.f.jV(r3);	 Catch:{ all -> 0x008c }
    L_0x002a:
        if (r3 == 0) goto L_0x0032;
    L_0x002c:
        r5 = r3.Le();	 Catch:{ all -> 0x008c }
        if (r5 == 0) goto L_0x0050;
    L_0x0032:
        r2 = "MicroMsg.CheckCanSubscribeBizUI";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x008c }
        r6 = "BizInfo(";
        r5.<init>(r6);	 Catch:{ all -> 0x008c }
        r3 = r5.append(r3);	 Catch:{ all -> 0x008c }
        r5 = ") is null or should update.";
        r3 = r3.append(r5);	 Catch:{ all -> 0x008c }
        r3 = r3.toString();	 Catch:{ all -> 0x008c }
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);	 Catch:{ all -> 0x008c }
        r2 = r1;
    L_0x0050:
        r3 = r7.xMB;	 Catch:{ all -> 0x008c }
        if (r3 == 0) goto L_0x007b;
    L_0x0054:
        if (r4 != 0) goto L_0x0065;
    L_0x0056:
        r1 = 0;
        r7.xMy = r1;	 Catch:{ all -> 0x008c }
        r1 = 5;
        r7.setResult(r1);	 Catch:{ all -> 0x008c }
        r7.cmG();	 Catch:{ all -> 0x008c }
        r7.finish();	 Catch:{ all -> 0x008c }
    L_0x0063:
        monitor-exit(r7);
        return r0;
    L_0x0065:
        r2 = 1;
        r7.xMy = r2;	 Catch:{ all -> 0x008c }
        r2 = 1;
        r7.hjU = r2;	 Catch:{ all -> 0x008c }
        r2 = r4.field_type;	 Catch:{ all -> 0x008c }
        r2 = com.tencent.mm.k.a.ga(r2);	 Catch:{ all -> 0x008c }
        if (r2 == 0) goto L_0x0063;
    L_0x0073:
        r0 = 1;
        r7.xMy = r0;	 Catch:{ all -> 0x008c }
        r0 = 1;
        r7.hjU = r0;	 Catch:{ all -> 0x008c }
        r0 = r1;
        goto L_0x0063;
    L_0x007b:
        if (r2 == 0) goto L_0x009f;
    L_0x007d:
        r1 = r7.xMy;	 Catch:{ all -> 0x008c }
        if (r1 == 0) goto L_0x008f;
    L_0x0081:
        r1 = 5;
        r7.setResult(r1);	 Catch:{ all -> 0x008c }
        r7.cmG();	 Catch:{ all -> 0x008c }
        r7.finish();	 Catch:{ all -> 0x008c }
        goto L_0x0063;
    L_0x008c:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
    L_0x008f:
        r1 = com.tencent.mm.y.ak.a.hhv;	 Catch:{ all -> 0x008c }
        r2 = r7.toUserName;	 Catch:{ all -> 0x008c }
        r3 = "";
        r4 = new com.tencent.mm.ui.CheckCanSubscribeBizUI$1;	 Catch:{ all -> 0x008c }
        r4.<init>();	 Catch:{ all -> 0x008c }
        r1.a(r2, r3, r4);	 Catch:{ all -> 0x008c }
        goto L_0x0063;
    L_0x009f:
        r2 = r4.field_type;	 Catch:{ all -> 0x008c }
        r2 = com.tencent.mm.k.a.ga(r2);	 Catch:{ all -> 0x008c }
        if (r2 != 0) goto L_0x0073;
    L_0x00a7:
        r1 = "MicroMsg.CheckCanSubscribeBizUI";
        r2 = "is not contact.";
        com.tencent.mm.sdk.platformtools.x.w(r1, r2);	 Catch:{ all -> 0x008c }
        r1 = 1;
        r7.xMy = r1;	 Catch:{ all -> 0x008c }
        goto L_0x0063;
    L_0x00b4:
        r2 = r0;
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.CheckCanSubscribeBizUI.cmE():boolean");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            this.xMz = true;
            if (this.xMA) {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void cmF() {
        Toast.makeText(this, getString(R.l.eSX), 1).show();
        aFD();
    }

    private void cmG() {
        Toast.makeText(this, R.l.eEq, 1).show();
        aFD();
    }

    private void aFD() {
        if (this.cPf == 1) {
            LauncherUI.fs(this);
        }
    }

    public final void a(final String str, com.tencent.mm.sdk.e.l lVar) {
        new com.tencent.mm.sdk.platformtools.ag().post(new Runnable() {
            public final void run() {
                x.d("MicroMsg.CheckCanSubscribeBizUI", "onNotifyChange toUserName = " + CheckCanSubscribeBizUI.this.toUserName + ", userName = " + str);
                if (CheckCanSubscribeBizUI.this.toUserName.equals(str)) {
                    CheckCanSubscribeBizUI.this.xMy = true;
                    if (!CheckCanSubscribeBizUI.this.hjU) {
                        CheckCanSubscribeBizUI.this.cmD();
                    }
                }
            }
        });
    }

    public final void a(int i, m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            x.d("MicroMsg.CheckCanSubscribeBizUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), mVar, obj);
            return;
        }
        a((String) obj, null);
    }
}
