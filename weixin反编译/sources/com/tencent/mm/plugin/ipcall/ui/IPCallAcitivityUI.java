package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

@a(3)
public class IPCallAcitivityUI extends MMActivity {
    private FrameLayout nNi;
    private TextView nNj;
    private TextView nNk;
    private Button nNl;
    private CdnImageView nNm;
    private boolean nNn = false;
    private com.tencent.mm.plugin.ipcall.a.g.a nNo;

    protected final int getForceOrientation() {
        return 1;
    }

    protected final int getLayoutId() {
        return R.i.dml;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        this.mController.hideTitleView();
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
        this.nNi = (FrameLayout) findViewById(R.h.cre);
        this.nNj = (TextView) findViewById(R.h.cri);
        this.nNk = (TextView) findViewById(R.h.crf);
        this.nNl = (Button) findViewById(R.h.crg);
        this.nNm = (CdnImageView) findViewById(R.h.crh);
        as.Hm();
        String str = (String) c.Db().get(w.a.USERFINO_IPCALL_ACTIVITY_STRING, (Object) "");
        if (bi.oN(str)) {
            x.e("MicroMsg.IPCallAcitivityUI", "xml is empty");
            finish();
        } else {
            this.nNo = com.tencent.mm.plugin.ipcall.a.g.a.Dg(str);
            if (this.nNo == null) {
                x.e("MicroMsg.IPCallAcitivityUI", "mMsgInfo is null");
                finish();
            } else {
                this.nNj.setText(this.nNo.fpg);
                this.nNk.setText(this.nNo.nkL);
                this.nNl.setText(this.nNo.nMm);
                this.nNm.setUrl(this.nNo.nMl);
            }
        }
        this.nNi.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                IPCallAcitivityUI.this.finish();
            }
        });
        this.nNl.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (IPCallAcitivityUI.this.nNo.kzz == 1) {
                    x.i("MicroMsg.IPCallAcitivityUI", "click activity, go to IPCallPackageUI");
                    Intent intent = new Intent();
                    intent.setClass(IPCallAcitivityUI.this.mController.xRr, IPCallShareCouponUI.class);
                    IPCallAcitivityUI.this.startActivity(intent);
                    intent = new Intent();
                    intent.setClass(IPCallAcitivityUI.this.mController.xRr, IPCallPackageUI.class);
                    IPCallAcitivityUI.this.startActivity(intent);
                }
                IPCallAcitivityUI.this.nNn = true;
                IPCallAcitivityUI.this.finish();
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                IPCallAcitivityUI.this.finish();
                return true;
            }
        });
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.a.bpQ, R.a.bql);
        if (this.nNn) {
            com.tencent.mm.plugin.ipcall.a.e.c.rN(1);
        } else {
            com.tencent.mm.plugin.ipcall.a.e.c.rN(0);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }
}
