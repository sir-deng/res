package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public class BioHelperUI extends MMActivity {
    private String jPV;
    private int lPJ;
    private String liu;
    private int mType;
    private String nRP;
    private String vpY;
    private b vpZ;

    private class c implements b {
        private int itU;

        private c() {
        }

        /* synthetic */ c(BioHelperUI bioHelperUI, byte b) {
            this();
        }

        public final void ad(Intent intent) {
            if (intent != null) {
                this.itU = intent.getIntExtra("kscene_type", 73);
            }
        }

        public final String caJ() {
            return BioHelperUI.this.getString(R.l.dMt);
        }

        public final int caK() {
            return R.g.bHk;
        }

        public final String caL() {
            return BioHelperUI.this.getString(R.l.dMs);
        }

        public final String caM() {
            return BioHelperUI.this.getString(R.l.dMp);
        }

        public final void eo(Context context) {
            Intent intent = new Intent();
            intent.putExtra("kscene_type", this.itU);
            intent.putExtra("Kusername", BioHelperUI.this.jPV);
            intent.putExtra("Kvertify_key", BioHelperUI.this.liu);
            d.b(context, "voiceprint", ".ui.VoiceLoginUI", intent, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }

        public final void d(int i, int i2, Intent intent) {
            int i3 = 0;
            if (i2 == -1) {
                if (i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
                    String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
                    String str = "MicroMsg.BioHelperUI";
                    String str2 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d";
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.valueOf(bi.oN(stringExtra));
                    if (!bi.oN(stringExtra)) {
                        i3 = stringExtra.length();
                    }
                    objArr[1] = Integer.valueOf(i3);
                    x.d(str, str2, objArr);
                    Intent intent2 = new Intent();
                    intent2.putExtra("VoiceLoginAuthPwd", stringExtra);
                    intent2.putExtra("KVoiceHelpCode", BioHelperUI.this.lPJ);
                    BioHelperUI.this.setResult(-1, intent2);
                }
                BioHelperUI.this.finish();
            }
        }
    }

    private interface b {
        void ad(Intent intent);

        String caJ();

        int caK();

        String caL();

        String caM();

        void d(int i, int i2, Intent intent);

        void eo(Context context);
    }

    private class a implements b {
        private a() {
        }

        /* synthetic */ a(BioHelperUI bioHelperUI, byte b) {
            this();
        }

        public final void ad(Intent intent) {
        }

        public final String caJ() {
            return BioHelperUI.this.getString(R.l.dMq);
        }

        public final int caK() {
            return R.g.bCc;
        }

        public final String caL() {
            return BioHelperUI.this.getString(R.l.dMr);
        }

        public final String caM() {
            return BioHelperUI.this.getString(R.l.dMo);
        }

        public final void eo(Context context) {
            Intent intent = new Intent();
            intent.putExtra("k_user_name", BioHelperUI.this.jPV);
            intent.putExtra("k_purpose", 2);
            intent.putExtra("k_need_signature", true);
            intent.putExtra("k_ticket", BioHelperUI.this.liu);
            d.b(BioHelperUI.this.mController.xRr, "facedetect", ".ui.FaceDetectUI", intent, 1025);
        }

        public final void d(int i, int i2, Intent intent) {
            int i3 = 0;
            if (i2 == 2 && intent != null) {
                BioHelperUI.this.finish();
                String stringExtra = intent.getStringExtra("KFaceLoginAuthPwd");
                String str = "MicroMsg.BioHelperUI";
                String str2 = "hy: secondary check onActivityResult, do faceprint auth, authPwd is null:%b, authPwd.len:%d";
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(bi.oN(stringExtra));
                if (!bi.oN(stringExtra)) {
                    i3 = stringExtra.length();
                }
                objArr[1] = Integer.valueOf(i3);
                x.i(str, str2, objArr);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        b bVar = null;
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("k_type", 1);
        x.i("MicroMsg.BioHelperUI", "hy: starting to bio helper ui, type: %d", Integer.valueOf(this.mType));
        this.jPV = bi.aD(getIntent().getStringExtra("Kusername"), null);
        this.liu = bi.aD(getIntent().getStringExtra("Kvertify_key"), null);
        this.vpY = bi.aD(getIntent().getStringExtra("KVoiceHelpUrl"), null);
        this.nRP = bi.aD(getIntent().getStringExtra("KVoiceHelpWording"), null);
        this.lPJ = getIntent().getIntExtra("KVoiceHelpCode", 0);
        if (this.mType == 0) {
            bVar = new c();
        } else if (this.mType == 1) {
            bVar = new a();
        } else {
            x.e("MicroMsg.BioHelperUI", "hy: invalid type!!!");
        }
        this.vpZ = bVar;
        if (this.vpZ == null || bi.oN(this.jPV) || bi.oN(this.liu)) {
            x.w("MicroMsg.BioHelperUI", "type or username or ticket is null and finish");
            finish();
            return;
        }
        TextView textView = (TextView) findViewById(R.h.bNM);
        if (bi.oN(this.nRP)) {
            textView.setText(this.vpZ.caM());
        } else {
            textView.setText(this.nRP);
        }
        setMMTitle(this.vpZ.caJ());
        ((ImageView) findViewById(R.h.bNK)).setImageResource(this.vpZ.caK());
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BioHelperUI.this.finish();
                return true;
            }
        });
        this.vpZ.ad(getIntent());
        Button button = (Button) findViewById(R.h.bNN);
        button.setText(this.vpZ.caL());
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                BioHelperUI.this.vpZ.eo(BioHelperUI.this);
            }
        });
        findViewById(R.h.bNL).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", new StringBuilder(BioHelperUI.this.vpY).toString());
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("needRedirect", false);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vHy);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vHv);
                d.b(BioHelperUI.this, "webview", ".ui.tools.WebViewUI", intent);
                BioHelperUI.this.finish();
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.dbt;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.BioHelperUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (intent != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        this.vpZ.d(i, i2, intent);
    }
}
