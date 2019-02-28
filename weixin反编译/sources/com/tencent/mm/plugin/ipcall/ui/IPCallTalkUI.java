package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.ipcall.a.c.b;
import com.tencent.mm.plugin.ipcall.a.f;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;

@a(3)
public class IPCallTalkUI extends MMActivity implements j.a {
    private String nPg;
    private String nPh;
    private String nPi;
    private String nPj;
    private int nPk;
    private int nPl;
    private j nSV;
    private String nqW;

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getSupportActionBar().hide();
        getWindow().addFlags(6946944);
        this.nqW = getIntent().getStringExtra("IPCallTalkUI_nickname");
        this.nPg = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
        this.nPh = getIntent().getStringExtra("IPCallTalkUI_contactId");
        this.nPi = getIntent().getStringExtra("IPCallTalkUI_countryCode");
        this.nPj = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
        this.nPk = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
        this.nPl = getIntent().getIntExtra("IPCallTalkUI_countryType", 0);
        x.i("MicroMsg.IPCallTalkUI", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername:%s, mDialScene:%d ,mCountryType:%d", this.nqW, this.nPg, this.nPh, this.nPi, this.nPj, Integer.valueOf(this.nPk), Integer.valueOf(this.nPl));
        x.i("MicroMsg.IPCallTalkUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 80, null, null)), bi.chl());
        if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 80, null, null)) {
            init();
        }
    }

    private void init() {
        this.nSV = new j(this);
        this.nSV.nTG = this;
        j jVar = this.nSV;
        String str = this.nqW;
        String str2 = this.nPg;
        String str3 = this.nPh;
        String str4 = this.nPi;
        String str5 = this.nPj;
        int i = this.nPk;
        int i2 = this.nPl;
        jVar.nTM = jVar.nTE.getIntent().getBooleanExtra("IPCallTalkUI_isFromMiniNotification", false);
        x.i("MicroMsg.TalkUIController", "onCreate, mNickname: %s, mPhoneNumber: %s, mContactId: %s, mCountryCode: %s, toUsername: %s, isFromMinimize: %b", str, str2, str3, str4, str5, Boolean.valueOf(jVar.nTM));
        jVar.nTu = (ImageView) jVar.nTE.findViewById(R.h.cQs);
        jVar.ikl = (ImageView) jVar.nTE.findViewById(R.h.cQr);
        jVar.nTs = (EditText) jVar.nTE.findViewById(R.h.cQw);
        jVar.ikq = (TextView) jVar.nTE.findViewById(R.h.cQz);
        jVar.nTt = (TextView) jVar.nTE.findViewById(R.h.cQx);
        jVar.nTv = (IPCallFuncButton) jVar.nTE.findViewById(R.h.cQv);
        jVar.nTw = (IPCallFuncButton) jVar.nTE.findViewById(R.h.cQt);
        jVar.nTx = (IPCallFuncButton) jVar.nTE.findViewById(R.h.cQy);
        jVar.nTy = (ImageButton) jVar.nTE.findViewById(R.h.cQu);
        jVar.nTB = (ImageButton) jVar.nTE.findViewById(R.h.crj);
        jVar.nTz = (TextView) jVar.nTE.findViewById(R.h.cXK);
        jVar.nTA = jVar.nTE.findViewById(R.h.cXL);
        jVar.nMK = (DialPad) jVar.nTE.findViewById(R.h.cbV);
        String str6;
        if (jVar.nTM) {
            jVar.nqW = i.aUe().nIw.fqG;
            jVar.nTD = i.aUe().nIw.nJG;
            jVar.nPj = i.aUe().nIw.fHE;
            jVar.nPh = i.aUe().nIw.fJt;
            jVar.nPg = i.aUe().nIw.nJF;
            jVar.nTC = i.aUe().nIw.nJI;
            x.i("MicroMsg.TalkUIController", "restoreParam nickname:%s,fianlPhoneNumber:%s,toUserName:%s,contactId:%s,phoneNumber:%s,phoneType:%d", jVar.nqW, jVar.nTD, jVar.nPj, jVar.nPh, jVar.nPg, Integer.valueOf(jVar.nTC));
            jVar.aVm();
            jVar.aVn();
            i.aUi();
            x.i("MicroMsg.TalkUIController", f.stateToString(i.aUi().nIg));
            jVar.rY(i.aUi().nIg);
            str6 = i.aUe().nIw.nJG;
            str = i.aUe().nIw.nJH;
            if (!bi.oN(str)) {
                jVar.DE(str);
                jVar.nTt.setText(com.tencent.mm.plugin.ipcall.b.a.DO(str));
            } else if (!bi.oN(str6)) {
                jVar.DE(str6);
                jVar.nTt.setText(com.tencent.mm.plugin.ipcall.b.a.DO(str6));
            }
            if (i.aUi().aTZ()) {
                IPCallFuncButton iPCallFuncButton = jVar.nTx;
                i.aUh();
                iPCallFuncButton.setChecked(com.tencent.mm.plugin.ipcall.a.b.a.xX());
                jVar.nTv.setChecked(i.aUh().nJS.kYN);
            }
        } else if (i.aUi().aTY()) {
            h.a(jVar.nTE, R.l.epK, R.l.dGZ, false, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    j.this.nTE.finish();
                }
            });
        } else {
            jVar.aVm();
            jVar.nqW = str;
            jVar.nPg = str2;
            jVar.nPh = str3;
            jVar.nPi = str4;
            jVar.nPk = i;
            jVar.nPl = i2;
            if (!bi.oN(jVar.nPg)) {
                jVar.nPg = c.DS(jVar.nPg);
            }
            if (bi.oN(jVar.nPi)) {
                if (com.tencent.mm.plugin.ipcall.b.a.DM(jVar.nPg)) {
                    str6 = com.tencent.mm.plugin.ipcall.b.a.DK(jVar.nPg);
                    if (bi.oN(str6)) {
                        jVar.nPg = com.tencent.mm.plugin.ipcall.b.a.DN(jVar.nPg);
                    } else {
                        jVar.nPg = com.tencent.mm.plugin.ipcall.b.a.DP(jVar.nPg);
                        jVar.nPi = str6;
                    }
                }
                jVar.nPi = c.aVu();
            }
            x.i("MicroMsg.TalkUIController", "final mCountryCode: %s", jVar.nPi);
            com.tencent.mm.plugin.ipcall.a.c aTQ = com.tencent.mm.plugin.ipcall.a.c.aTQ();
            str = jVar.nPi;
            if (!aTQ.isInit) {
                aTQ.fT(false);
            }
            if (!bi.oN(str)) {
                i.aUm().x(bi.getInt(str.replace("+", ""), 0), bi.Wy());
                aTQ.aTS();
            }
            if (bi.oN(jVar.nqW)) {
                jVar.nqW = com.tencent.mm.plugin.ipcall.b.a.al(jVar.nTE, jVar.nPg);
            }
            jVar.nPj = str5;
            if (bi.oN(jVar.nPi) || com.tencent.mm.plugin.ipcall.b.a.DM(jVar.nPg)) {
                jVar.nTD = jVar.nPg;
            } else {
                jVar.nTD = jVar.nPi + jVar.nPg;
                if (!jVar.nTD.startsWith("+")) {
                    jVar.nTD = "+" + jVar.nTD;
                }
            }
            x.i("MicroMsg.TalkUIController", "final call mPhoneNumber: %s", jVar.nTD);
            if (com.tencent.mm.plugin.ipcall.a.c.aTQ().rI(bi.getInt(jVar.nPi, -1))) {
                g.pWK.k(12058, jVar.nPi);
                h.a(jVar.nTE, jVar.nTE.getString(R.l.dNv), jVar.nTE.getString(R.l.dNw), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        j.this.nTE.finish();
                        j.this.nTE = null;
                    }
                });
            } else if (ao.isNetworkConnected(jVar.nTE)) {
                long j = jVar.nTE.getSharedPreferences("IPCall_LastInputPref", 0).getLong("IPCall_LastInvite", -1);
                if (j <= System.currentTimeMillis() || j == -1) {
                    jVar.aVn();
                    if (!(jVar.nTM && i.aUi().aTY())) {
                        b aUg;
                        jVar.nTC = com.tencent.mm.plugin.ipcall.b.a.dg(jVar.nPh, jVar.nPg);
                        jVar.rY(1);
                        com.tencent.mm.plugin.ipcall.c cVar = jVar.nTF;
                        str = jVar.nqW;
                        str2 = jVar.nPg;
                        str3 = jVar.nPj;
                        str4 = jVar.nTD;
                        str5 = jVar.nPh;
                        i = jVar.nTC;
                        i2 = jVar.nPk;
                        int i3 = jVar.nPl;
                        if (i.aUi().aTY()) {
                            x.i("MicroMsg.IPCallManager", "startIPCall, already start!");
                        } else {
                            x.i("MicroMsg.IPCallManager", "startIPCall");
                            i.aUe().nIn = cVar;
                            i.aUf().nKs = cVar;
                            i.aUi().nIg = -1;
                            cVar.aCt();
                            cVar.nHI = (TelephonyManager) ad.getContext().getSystemService("phone");
                            cVar.nHI.listen(cVar.nHJ, 32);
                            com.tencent.mm.sdk.b.a.xmy.b(cVar.nHK);
                            x.d("MicroMsg.IPCallRecordStorageLogic", "recordStartCall, phoneNumber: %s, contactId: %s", str4, str5);
                            k kVar = new k();
                            kVar.field_phonenumber = str4;
                            if (bi.oN(str5)) {
                                kVar.field_addressId = -1;
                            } else {
                                com.tencent.mm.plugin.ipcall.a.g.c Di = i.aUk().Di(str5);
                                if (Di == null || Di.xrR == -1) {
                                    kVar.field_addressId = -1;
                                } else {
                                    kVar.field_addressId = Di.xrR;
                                }
                            }
                            if (i != -1) {
                                kVar.field_phoneType = i;
                            } else {
                                kVar.field_phoneType = -1;
                            }
                            kVar.field_calltime = bi.Wy();
                            kVar.field_status = 1;
                            if (!i.aUl().b((com.tencent.mm.sdk.e.c) kVar)) {
                                kVar = null;
                            }
                            cVar.nHG = kVar;
                            com.tencent.mm.plugin.ipcall.c.hbP.postDelayed(cVar.nHM, 1754);
                            cVar.nHH = false;
                            aUg = i.aUg();
                            x.d("MicroMsg.IPCallReportHelper", "reset");
                            aUg.nKu = 0;
                            aUg.nKv = 0;
                            aUg.nKw = 0;
                            aUg.nKx = 0;
                            aUg.nKy = 0;
                            aUg.nKz = 0;
                            aUg.nKA = 0;
                            aUg.nKB = 0;
                            aUg.nKC = 0;
                            aUg.nKD = 0;
                            aUg.nJe = 0;
                            aUg.nJf = 0;
                            aUg.nKE = 0;
                            aUg.int = "";
                            aUg.nKF = 0;
                            aUg.nKG = "";
                            aUg.nKI = 0;
                            aUg.nKH = 0;
                            aUg.nHP = 0;
                            aUg.nKJ = 0;
                            aUg.nKK = 0;
                            aUg.nKP = 0;
                            aUg.nKO = 0;
                            aUg.nKL = "";
                            aUg.nKM = "";
                            aUg.countryCode = "";
                            aUg.nKQ = 0;
                            aUg.nKR = 0;
                            aUg.nKS = 0;
                            aUg.nKT = 0;
                            aUg.nKU = 0;
                            i.aUi().nIg = -1;
                            x.d("MicroMsg.IPCallManager", "startIPCall, username: %s, phoneNumber: %s", str3, str4);
                            com.tencent.mm.plugin.ipcall.a.g aUe = i.aUe();
                            x.d("MicroMsg.IPCallSvrLogic", "startIPCall, toUsername: %s, toPhoneNumber: %s", str3, str4);
                            aUe.fEQ = false;
                            aUe.nIx = false;
                            aUe.nIi = 0;
                            aUe.nIj = 0;
                            aUe.nIk = 0;
                            aUe.nIl = false;
                            aUe.nIm = false;
                            aUe.nIy = false;
                            aUe.nIw = new com.tencent.mm.plugin.ipcall.a.a.c();
                            aUe.nIw.fqG = str;
                            aUe.nIw.nJF = str2;
                            aUe.nIw.fJt = str5;
                            aUe.nIw.nJG = str4;
                            aUe.nIw.fHE = str3;
                            aUe.nIw.nJh = (int) System.currentTimeMillis();
                            aUe.nIw.nJi = i2;
                            aUe.nIw.nJj = i3;
                            aUe.nIw.nJI = i;
                            aUe.nIo.a(aUe.nIw);
                            aUe.nIt.a(aUe.nIw);
                            x.i("MicroMsg.IPCallSvrLogic", "startIPCallInternal, inviteId: %d", Integer.valueOf(aUe.nIw.nJh));
                            i.aUi().rJ(1);
                            com.tencent.mm.plugin.ipcall.a.c.a aUf = i.aUf();
                            if (aUf.nKr) {
                                x.d("MicroMsg.IPCallEngineManager", "already start engine");
                            } else {
                                aUf.aUB();
                                x.i("MicroMsg.IPCallEngineManager", "start engine");
                                if (aUf.nKn.oCT) {
                                    aUf.nKn.jq(false);
                                    aUf.nKn.reset();
                                }
                                aUf.nKn.sui = 1;
                                long currentTimeMillis = System.currentTimeMillis();
                                v2protocal v2protocal = aUf.nKn;
                                v2protocal.netType = com.tencent.mm.plugin.voip.b.a.getNetType(ad.getContext());
                                if (v2protocal.netType == 5) {
                                    v2protocal.netType = 4;
                                }
                                v2protocal.svc = new int[(v2protocal.defaultWidth * v2protocal.defaultHeight)];
                                as.Hm();
                                v2protocal.sug = com.tencent.mm.y.c.Cn();
                                i = m.yw();
                                if ((i & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
                                    d.t(ad.getContext(), "libvoipCodec_v7a.so");
                                    com.tencent.mm.plugin.voip.b.a.eB("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v7a.so... ");
                                } else if ((i & WXMediaMessage.TITLE_LENGTH_LIMIT) != 0) {
                                    d.t(ad.getContext(), "libvoipCodec.so");
                                    com.tencent.mm.plugin.voip.b.a.eB("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec.so... ");
                                } else {
                                    d.t(ad.getContext(), "libvoipCodec_v5.so");
                                    com.tencent.mm.plugin.voip.b.a.eB("MicroMsg.Voip", "dlopen /data/data/com.tencent.mm/lib/libvoipCodec_v5.so... ");
                                }
                                i2 = VERSION.SDK_INT;
                                i3 = OpenGlRender.bJn();
                                Display defaultDisplay = ((WindowManager) ad.getContext().getSystemService("window")).getDefaultDisplay();
                                int width = defaultDisplay.getWidth();
                                int init = v2protocal.init(v2protocal.netType, 65538, (v2protocal.defaultWidth << 16) | v2protocal.defaultHeight, (width << 16) | defaultDisplay.getHeight(), v2protocal.sug, i | ((i2 << 16) | (i3 << 24)), e.hbu + "app_lib/", 4);
                                com.tencent.mm.plugin.voip.b.a.eB("MicroMsg.Voip", "protocal init ret :" + init + ",uin= " + v2protocal.sug);
                                v2protocal.oCT = true;
                                if (init < 0) {
                                    v2protocal.reset();
                                }
                                j = System.currentTimeMillis();
                                x.d("MicroMsg.IPCallEngineManager", "protocal init finish, ret: %d, used %dms", Integer.valueOf(init), Long.valueOf(j - currentTimeMillis));
                                if (aUf.nKn.field_capInfo != null && aUf.nKn.exchangeCabInfo(aUf.nKn.field_capInfo, aUf.nKn.field_capInfo.length) < 0) {
                                    x.e("MicroMsg.IPCallEngineManager", "exchangeCabInfo failed");
                                    i.aUg().nKD = 24;
                                }
                                if (init < 0) {
                                    x.e("MicroMsg.IPCallEngineManager", "engine init failed!");
                                }
                                aUf.nKn.sui = 1;
                                aUf.nKr = true;
                            }
                            com.tencent.mm.plugin.ipcall.c.hbP.removeCallbacks(cVar.nHL);
                            com.tencent.mm.plugin.ipcall.c.hbP.postDelayed(cVar.nHL, 60000);
                        }
                        x.i("MicroMsg.TalkUIController", "startLaunchTalk, callNumber: %s", jVar.nTD);
                        aUg = i.aUg();
                        str = jVar.nPi;
                        x.d("MicroMsg.IPCallReportHelper", "setCountryCode: %s", str);
                        if (!bi.oN(str)) {
                            aUg.countryCode = str;
                        }
                    }
                    jVar.nTO = false;
                    return;
                }
                x.i("MicroMsg.TalkUIController", "onDisasterHappen");
                h.a(jVar.nTE, jVar.nTE.getString(R.l.eqP, new Object[]{String.valueOf(((j - r6) / 1000) + 1)}), jVar.nTE.getString(R.l.eqK), jVar.nTE.getString(R.l.eqL), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        j.this.nTE.finish();
                    }
                });
            } else {
                Toast.makeText(jVar.nTE, R.l.eVP, 1).show();
                jVar.nTE.finish();
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        setScreenEnable(true);
        if (this.nSV != null) {
            j jVar = this.nSV;
            x.i("MicroMsg.TalkUIController", "onDestroy");
            jVar.nTF.nHF = null;
            i.aUh().fnF = null;
            i.aUh().nJX = null;
            i.aUh().a(null);
            com.tencent.mm.plugin.ipcall.a.b.b aUh = i.aUh();
            aUh.nJT.nKk = null;
            com.tencent.mm.plugin.ipcall.a.b.d dVar = aUh.nJT;
            dVar.kIB.cgS();
            dVar.kIF.cgT();
            jVar.nTE = null;
            jVar.nTG = null;
        }
    }

    protected final int getLayoutId() {
        return R.i.dmj;
    }

    public final void gl(boolean z) {
        if (z) {
            ah.h(new Runnable() {
                public final void run() {
                    IPCallTalkUI.this.setResult(-1, new Intent());
                    IPCallTalkUI.this.finish();
                }
            }, 3000);
        }
    }

    public void onBackPressed() {
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.nSV != null) {
            boolean z;
            if (i.aUi().aTZ()) {
                int aUy;
                if (i == 25) {
                    aUy = i.aUh().aUy();
                    if (aUy != -1) {
                        as.Hn().fA(aUy);
                        z = true;
                        if (z) {
                            return true;
                        }
                    }
                } else if (i == 24) {
                    aUy = i.aUh().aUy();
                    if (aUy != -1) {
                        as.Hn().fz(aUy);
                        z = true;
                        if (z) {
                            return true;
                        }
                    }
                }
            }
            z = false;
            if (z) {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    protected void onPause() {
        x.d("MicroMsg.IPCallTalkUI", "onPause");
        super.onPause();
        if (this.nSV != null) {
            x.d("MicroMsg.TalkUIController", "onPause");
        }
    }

    protected void onResume() {
        x.d("MicroMsg.IPCallTalkUI", "onResume");
        super.onResume();
        if (this.nSV != null) {
            x.d("MicroMsg.TalkUIController", "onResume");
            as.getNotification().cancel(42);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.IPCallTalkUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 80:
                if (iArr[0] == 0) {
                    init();
                    return;
                } else {
                    h.a((Context) this, getString(R.l.eAd), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            IPCallTalkUI.this.finish();
                            IPCallTalkUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            IPCallTalkUI.this.finish();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }
}
