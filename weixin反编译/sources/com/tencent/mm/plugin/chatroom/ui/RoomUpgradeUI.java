package com.tencent.mm.plugin.chatroom.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.k.a;
import com.tencent.mm.plugin.chatroom.d.h;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.ak;
import com.tencent.mm.y.ak.b;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public class RoomUpgradeUI extends MMActivity implements e {
    private String chatroomName;
    private ProgressDialog inI = null;
    private q lfE;
    private int lfb;
    private int lfc;
    private View lhU;
    private ImageView lhV;
    private TextView lhW;
    private TextView lhX;
    private TextView lhY;
    private TextView lic;
    private View lid;
    private TextView lie;
    private h lif;
    private String lig;
    private boolean lih;
    private boolean lii;
    private int status;

    static /* synthetic */ void a(RoomUpgradeUI roomUpgradeUI, boolean z) {
        Intent intent = new Intent(roomUpgradeUI, RoomAnnouncementUI.class);
        intent.putExtra("need_bind_mobile", z);
        intent.putExtra("RoomInfo_Id", roomUpgradeUI.chatroomName);
        roomUpgradeUI.startActivityForResult(intent, 600);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Xc();
        initView();
    }

    public void onNewIntent(Intent intent) {
        boolean booleanExtra;
        if (intent.hasExtra("upgrade_success")) {
            booleanExtra = intent.getBooleanExtra("upgrade_success", false);
        } else {
            if (intent.hasExtra("wizard_activity_result_code") && intent.getIntExtra("wizard_activity_result_code", -1) == -1) {
                ayz();
            }
            if (intent.hasExtra("announce_ok")) {
                ayz();
            }
            booleanExtra = false;
        }
        if (booleanExtra) {
            Xc();
            int intExtra = intent.getIntExtra("left_quota", 0);
            ayA();
            this.lie.setVisibility(8);
            this.lfc = intExtra;
            if (this.lfc > 0) {
                this.lhY.setText(getString(R.l.eGF, new Object[]{Integer.valueOf(this.lfc)}));
            } else {
                this.lhY.setText(getString(R.l.eGG));
            }
            if (!this.lii) {
                this.lic.setVisibility(0);
            }
            this.lic.setText(R.l.eGC);
        }
    }

    private void ayz() {
        Intent intent = new Intent(this, RoomAlphaProcessUI.class);
        intent.addFlags(67108864);
        intent.addFlags(65536);
        intent.putExtra("RoomInfo_Id", this.chatroomName);
        startActivity(intent);
    }

    private void Xc() {
        boolean z = true;
        this.chatroomName = getIntent().getStringExtra("room_name");
        x.i("MicroMsg.RoomUpgradeProductsUI", "the roomName is %s", this.chatroomName);
        as.CN().a(519, (e) this);
        as.Hm();
        this.lfE = c.Fo().hG(this.chatroomName);
        if (this.lfE == null) {
            finish();
            return;
        }
        this.lih = com.tencent.mm.y.q.FY().equals(this.lfE.field_roomowner);
        if (w.cfS()) {
            z = false;
        }
        this.lii = z;
    }

    protected final void initView() {
        setMMTitle(R.l.eGz);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                RoomUpgradeUI.this.finish();
                return true;
            }
        });
        this.lhU = findViewById(R.h.cUd);
        this.lid = findViewById(R.h.cUf);
        this.lhV = (ImageView) findViewById(R.h.cUc);
        this.lhW = (TextView) findViewById(R.h.cUe);
        this.lhX = (TextView) findViewById(R.h.cUa);
        this.lhY = (TextView) findViewById(R.h.cUb);
        this.lie = (TextView) findViewById(R.h.cTZ);
        this.lie.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                switch (RoomUpgradeUI.this.status) {
                    case 1:
                        if (RoomUpgradeUI.this.lii) {
                            a.a(RoomUpgradeUI.this, RoomUpgradeUI.this.chatroomName, true);
                            return;
                        } else {
                            RoomUpgradeUI.a(RoomUpgradeUI.this, true);
                            return;
                        }
                    case 2:
                    case 5:
                        if (RoomUpgradeUI.this.lii) {
                            RoomUpgradeUI.this.ayz();
                            return;
                        } else {
                            RoomUpgradeUI.a(RoomUpgradeUI.this, false);
                            return;
                        }
                    default:
                        return;
                }
            }
        });
        this.lic = (TextView) findViewById(R.h.coK);
        this.lic.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (RoomUpgradeUI.this.lic.getVisibility() == 0) {
                    Intent intent = new Intent();
                    RoomUpgradeUI.this.lig = RoomUpgradeUI.this.getString(R.l.dQG, new Object[]{w.cfV()});
                    intent.putExtra("rawUrl", RoomUpgradeUI.this.lig);
                    intent.putExtra("geta8key_username", com.tencent.mm.y.q.FY());
                    intent.putExtra("showShare", false);
                    d.b(RoomUpgradeUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 500);
                }
            }
        });
        if (this.lih) {
            this.inI = com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.ctG), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    if (RoomUpgradeUI.this.lif != null) {
                        as.CN().c(RoomUpgradeUI.this.lif);
                        RoomUpgradeUI.this.lif = null;
                    }
                    RoomUpgradeUI.this.finish();
                }
            });
            this.lif = new h(this.chatroomName);
            as.CN().a(this.lif, 0);
        } else {
            ayA();
            if (!this.lii) {
                this.lic.setVisibility(0);
            }
            this.lic.setText(R.l.eGC);
            this.lie.setVisibility(8);
            this.lhY.setVisibility(8);
        }
        if (this.lii) {
            this.lic.setVisibility(8);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        as.CN().c(this.lif);
        as.CN().b(519, (e) this);
        if (this.inI != null) {
            this.inI.dismiss();
        }
        super.onDestroy();
    }

    private void ayA() {
        final String str = this.lfE.field_roomowner;
        as.Hm();
        a Xv = c.Ff().Xv(str);
        if (Xv == null || ((int) Xv.gKO) > 0) {
            xJ(str);
        } else {
            ak.a.hhv.a(str, this.chatroomName, new b.a() {
                public final void v(String str, boolean z) {
                    if (z) {
                        RoomUpgradeUI.this.lhU.post(new Runnable() {
                            public final void run() {
                                RoomUpgradeUI.this.xJ(str);
                            }
                        });
                    }
                }
            });
        }
        int ciH = this.lfE.ciH();
        this.lhX.setVisibility(0);
        if (ciH <= 40) {
            this.lhX.setText(getString(R.l.eGH, new Object[]{getString(R.l.eGB)}));
            return;
        }
        this.lhX.setText(getString(R.l.eGH, new Object[]{getString(R.l.eGA)}));
    }

    private void xJ(String str) {
        String str2;
        CharSequence charSequence = null;
        as.Hm();
        ag Xv = c.Ff().Xv(str);
        if (Xv == null || ((int) Xv.gKO) <= 0) {
            str2 = null;
        } else {
            str2 = Xv.field_conRemark;
        }
        if (!bi.oN(str2)) {
            Object charSequence2 = str2;
        } else if (this.lfE != null) {
            charSequence2 = this.lfE.gw(str);
        }
        if (bi.oN(charSequence2) && Xv != null && ((int) Xv.gKO) > 0) {
            charSequence2 = Xv.AW();
        }
        if (bi.oN(charSequence2)) {
            charSequence2 = str;
        }
        com.tencent.mm.pluginsdk.ui.a.b.a(this.lhV, str);
        this.lhW.setVisibility(0);
        this.lhW.setText(i.c(this, charSequence2, (int) this.lhW.getTextSize()));
    }

    public final int getLayoutId() {
        return R.i.dcY;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.RoomUpgradeProductsUI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        switch (i) {
            case 400:
                finish();
                return;
            default:
                x.e("MicroMsg.RoomUpgradeProductsUI", "onActivityResult unknow request");
                return;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.RoomUpgradeProductsUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.inI != null) {
            this.inI.dismiss();
        }
        if (i != 0 || i2 != 0) {
            com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.eGE), getString(R.l.dGZ), false, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    RoomUpgradeUI.this.finish();
                }
            });
        } else if (i == 0 && i2 == 0 && kVar.getType() == 519) {
            h hVar = (h) kVar;
            this.status = hVar.status;
            this.lfb = hVar.lfb;
            this.lfc = hVar.lfc;
            ayA();
            this.lhY.setVisibility(0);
            this.lie.setText(getString(R.l.eGy));
            if (this.lfc > 0) {
                this.lhY.setText(getString(R.l.eGF, new Object[]{Integer.valueOf(this.lfc)}));
            } else {
                this.lhY.setText(getString(R.l.eGG));
            }
            if (!this.lii) {
                this.lic.setVisibility(0);
            }
            switch (this.status) {
                case 1:
                case 2:
                case 5:
                    this.lie.setVisibility(0);
                    this.lic.setText(R.l.eGD);
                    return;
                case 3:
                case 4:
                case 6:
                    this.lie.setVisibility(0);
                    this.lie.setEnabled(false);
                    this.lic.setText(R.l.eGD);
                    return;
                case 7:
                    this.lie.setVisibility(8);
                    this.lic.setText(R.l.eGC);
                    this.lie.setEnabled(false);
                    return;
                default:
                    return;
            }
        }
    }
}
