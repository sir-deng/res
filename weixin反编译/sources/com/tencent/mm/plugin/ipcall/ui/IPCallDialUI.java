package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.rx;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.ipcall.a.d.b;
import com.tencent.mm.plugin.ipcall.a.d.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.byd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import java.util.LinkedList;

@a(3)
public class IPCallDialUI extends MMActivity implements e, b.a {
    private TextView ill;
    private DialPad nMK;
    private TextView nML;
    private EditText nMM;
    private View nMN;
    private ImageButton nMO;
    private View nMP;
    private TextView nMQ;
    private TextView nMR;
    private b nPf;
    private String nPg;
    private String nPh;
    private String nPi;
    private String nPj;
    private int nPk = 0;
    private int nPl = 0;
    private int nPm = -1;
    private LinkedList<byd> nPn;
    b nPo;
    c nPp;
    private com.tencent.mm.sdk.b.c nPq = new com.tencent.mm.sdk.b.c<rx>() {
        {
            this.xmG = rx.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            rx rxVar = (rx) bVar;
            if (rxVar instanceof rx) {
                String str = rxVar.fKx.countryCode;
                if (!(IPCallDialUI.this.nPf == null || bi.oN(str))) {
                    IPCallDialUI.this.nPf.Dp(str);
                }
            }
            return false;
        }
    };
    private String nqW;

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.sdk.b.a.xmy.b(this.nPq);
        as.CN().a(807, (e) this);
        as.CN().a(746, (e) this);
        getWindow().addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                IPCallDialUI.this.finish();
                return true;
            }
        }, R.k.byC);
        this.nqW = getIntent().getStringExtra("IPCallTalkUI_nickname");
        this.nPg = getIntent().getStringExtra("IPCallTalkUI_phoneNumber");
        this.nPh = getIntent().getStringExtra("IPCallTalkUI_contactId");
        this.nPi = getIntent().getStringExtra("IPCallTalkUI_countryCode");
        this.nPj = getIntent().getStringExtra("IPCallTalkUI_toWechatUsername");
        this.nPk = getIntent().getIntExtra("IPCallTalkUI_dialScene", 0);
        x.i("MicroMsg.IPCallDialUI", "onCreate nickName:%s, phoneNumber:%s, contactId:%s, countryCode:%s, toUserName:%s, dialScene:%d", this.nqW, this.nPg, this.nPh, this.nPi, this.nPj, Integer.valueOf(this.nPk));
        if (!bi.oN(this.nPg)) {
            this.nPg = com.tencent.mm.plugin.ipcall.b.c.DS(this.nPg);
        }
        if (bi.oN(this.nPi)) {
            if (com.tencent.mm.plugin.ipcall.b.a.DM(this.nPg)) {
                if (bi.oN(com.tencent.mm.plugin.ipcall.b.a.DK(this.nPg))) {
                    this.nPg = com.tencent.mm.plugin.ipcall.b.a.DN(this.nPg);
                } else {
                    x.i("MicroMsg.IPCallDialUI", "country code exist, directly go to talk ui.");
                    this.nPl = 4;
                    Intent intent = new Intent(this, IPCallTalkUI.class);
                    intent.putExtra("IPCallTalkUI_contactId", this.nPh);
                    intent.putExtra("IPCallTalkUI_countryCode", this.nPi);
                    intent.putExtra("IPCallTalkUI_nickname", this.nqW);
                    intent.putExtra("IPCallTalkUI_phoneNumber", this.nPg);
                    intent.putExtra("IPCallTalkUI_dialScene", this.nPk);
                    intent.putExtra("IPCallTalkUI_countryType", this.nPl);
                    startActivityForResult(intent, 1001);
                    finish();
                    return;
                }
            }
            this.nPi = com.tencent.mm.plugin.ipcall.b.c.aVu();
        }
        if (this.nPk != 1) {
            this.nPm = 0;
            this.nPl = 3;
            this.nPo = new b(this.nPg, this.nPi, "", bi.chi(), this.nPk);
            as.CN().a(this.nPo, 0);
        } else {
            this.nPm = -1;
            this.nPl = 4;
        }
        init();
    }

    public void onStart() {
        super.onStart();
        this.nPp = new c();
        as.CN().a(this.nPp, 0);
    }

    protected void onResume() {
        x.d("MicroMsg.IPCallDialUI", "onResume");
        super.onResume();
    }

    protected final int getLayoutId() {
        return R.i.dmh;
    }

    private void init() {
        x.i("MicroMsg.IPCallDialUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 80, null, null)), bi.chl());
        if (com.tencent.mm.pluginsdk.g.a.a(this, "android.permission.RECORD_AUDIO", 80, null, null)) {
            setMMTitle(R.l.eqO);
            setVolumeControlStream(1);
            this.nMK = (DialPad) findViewById(R.h.cbV);
            this.nML = (TextView) findViewById(R.h.bZg);
            this.nMP = findViewById(R.h.bZe);
            this.nMM = (EditText) findViewById(R.h.cCB);
            this.nMN = findViewById(R.h.cCA);
            this.ill = (TextView) findViewById(R.h.cbX);
            this.nMO = (ImageButton) findViewById(R.h.cbF);
            this.nMQ = (TextView) findViewById(R.h.bZi);
            this.nMR = (TextView) findViewById(R.h.cbI);
            this.nPf = new b(this, this.nMM, this.nML, this.nMN, this.nMK, this.nMO, this.ill, this.nMP, this.nMQ, this.nMR);
            this.nPf.nMJ = this;
            if (!bi.oN(this.nPg)) {
                this.nPf.bx(this.nPg, -1);
            }
            if (!bi.oN(this.nPi)) {
                this.nPf.Dp(this.nPi);
            }
            if (!(bi.oN(this.nPg) || bi.oN(this.nPi))) {
                this.nPf.aUS();
            }
            this.nPf.X(this.nPn);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        b bVar = this.nPf;
        x.d("MicroMsg.DialPadController", "onActivityResult");
        if (i == 100 && i2 == 100) {
            String aD = bi.aD(intent.getStringExtra("country_name"), "");
            String aD2 = bi.aD(intent.getStringExtra("couttry_code"), "");
            x.d("MicroMsg.DialPadController", "onActivityResult, countryName: %s, countryCode: %s", aD2, aD);
            if (!bi.oN(aD2) && !bi.oN(aD)) {
                bVar.nMT = aD;
                bVar.nMU = "+" + aD2;
                bVar.nML.setText(bVar.nMU);
                bVar.nMV = bVar.dd(aD2.replace("+", ""), bVar.nMV);
                bVar.bx(bVar.nMV, -1);
                bVar.nMZ = false;
            }
        } else if (i == 1001 && i2 == -1) {
            intent.getBooleanExtra("IPCallTalkUI_TalkIsOverdue", false);
            bVar.fnF.setResult(-1, intent);
            bVar.fnF.finish();
        }
    }

    public final void i(String str, String str2, String str3, String str4) {
        x.i("MicroMsg.IPCallDialUI", "onDial, countryCode: %s, phoneNumber: %s, contactId: %s, nickname: %s", str, str2, str3, str4);
        if (!com.tencent.mm.plugin.ipcall.b.c.cY(this)) {
            return;
        }
        if (com.tencent.mm.plugin.ipcall.a.c.aTQ().rI(bi.getInt(str, -1))) {
            h.b(this, getString(R.l.dNv), getString(R.l.dNw), true);
            g.pWK.k(12058, str);
            return;
        }
        g.pWK.h(12059, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
        Intent intent = new Intent(this, IPCallTalkUI.class);
        intent.putExtra("IPCallTalkUI_contactId", str3);
        intent.putExtra("IPCallTalkUI_countryCode", str);
        intent.putExtra("IPCallTalkUI_nickname", str4);
        intent.putExtra("IPCallTalkUI_phoneNumber", str2);
        intent.putExtra("IPCallTalkUI_dialScene", this.nPk);
        intent.putExtra("IPCallTalkUI_countryType", this.nPl);
        startActivityForResult(intent, 1001);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.nPf != null) {
            this.nPf.nMJ = null;
        }
        com.tencent.mm.sdk.b.a.xmy.c(this.nPq);
        as.CN().b(807, (e) this);
        as.CN().b(746, (e) this);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.IPCallDialUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 80:
                if (iArr[0] == 0) {
                    init();
                    return;
                } else {
                    h.a((Context) this, getString(R.l.eAd), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            IPCallDialUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            IPCallDialUI.this.finish();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof b) {
            if (i == 0 && i2 == 0 && kVar == this.nPo) {
                if (this.nPo.nKY != null) {
                    x.i("MicroMsg.IPCallDialUI", "Response Result:%d,PureNumber:%s,CountryCode:%s", Integer.valueOf(this.nPo.nKY.wcX), this.nPo.nKY.wMV, this.nPo.nKY.nUb);
                }
                if (this.nPm != 2) {
                    this.nPm = 1;
                    this.nPl = 1;
                    b bVar = this.nPo;
                    int i3 = (bVar.nKY == null || bVar.nKY.wcX != 2) ? 0 : 1;
                    if (i3 != 0) {
                        x.i("MicroMsg.IPCallDialUI", "check error show error dialog");
                        return;
                    }
                    bVar = this.nPo;
                    i3 = (bVar.nKY == null || !(bVar.nKY.wcX == 1 || bVar.nKY.wcX == 0)) ? 0 : 1;
                    if (i3 != 0) {
                        if (this.nPo.nKY == null || bi.oN(this.nPo.nKY.nUb)) {
                            x.i("MicroMsg.IPCallDialUI", "response country code is empty, ignore");
                        } else if (this.nPf != null) {
                            x.i("MicroMsg.IPCallDialUI", "response country code:%s, old country code:%s", this.nPo.nKY.nUb, this.nPi);
                            this.nPi = this.nPo.nKY.nUb;
                            this.nPf.Dp(this.nPo.nKY.nUb);
                        }
                    }
                    if (this.nPo.nKY != null && !bi.oN(this.nPo.nKY.wMV) && this.nPf != null) {
                        x.i("MicroMsg.IPCallDialUI", "response number:%s, old number:%s", this.nPo.nKY.wMV, this.nPg);
                        this.nPg = this.nPo.nKY.wMV;
                        this.nPf.bx(this.nPo.nKY.wMV, -1);
                        return;
                    }
                    return;
                }
                x.i("MicroMsg.IPCallDialUI", "NetSceneIPCallCheckNumber onSceneEnd, mCheckNumberStatus = userModify, ignore");
            }
        } else if (kVar instanceof c) {
            if (i == 0 && i2 == 0) {
                this.nPn = ((c) kVar).nLa.wwp;
            } else {
                this.nPn = null;
            }
            if (this.nPf != null) {
                this.nPf.X(this.nPn);
            }
        }
    }

    public final void Dq(String str) {
        x.i("MicroMsg.IPCallDialUI", "onModifyCountryCodeByUser:countryCode:%s,mCountryCode:%s", str, this.nPi);
        if (this.nPm != 2 && this.nPm != -1 && !this.nPi.equals(str)) {
            aVc();
        }
    }

    public final void Dr(String str) {
        x.i("MicroMsg.IPCallDialUI", "onModifyPhoneNumberByUser:phoneNumber:%s,mPhoneNumber:%s", str, this.nPg);
        if (this.nPm != 2 && this.nPm != -1 && !this.nPg.equals(str)) {
            aVc();
        }
    }

    private void aVc() {
        x.i("MicroMsg.IPCallDialUI", "modifyCountryCodeByUsder");
        this.nPm = 2;
        if (this.nPl == 1) {
            this.nPl = 2;
        } else {
            this.nPl = 4;
        }
    }
}
