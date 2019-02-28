package com.tencent.mm.plugin.emoji.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.f;
import com.tencent.mm.ad.k;
import com.tencent.mm.ap.o;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.chat.l.b;
import com.tencent.mm.pluginsdk.ui.emoji.PreViewEmojiView;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.x.g;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.io.IOException;

public class AppMsgEmojiDownloadUI extends MMActivity implements e, a {
    private String appName;
    private String fEK;
    private au fFE;
    private String fGh;
    private String for;
    private long frh;
    private String fwx;
    private String hcO;
    private ab lFU;
    private ProgressBar lFV;
    private f lFW;
    private TextView lFX;
    private String lFY;
    private PreViewEmojiView lFZ;

    protected final int getLayoutId() {
        return R.i.daz;
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        this.lFY = "da_" + bi.Wy();
        this.frh = getIntent().getLongExtra("msgid", -1);
        if (this.frh == -1) {
            z = false;
        } else {
            as.Hm();
            this.fFE = c.Fh().dI(this.frh);
            if (this.fFE == null || this.fFE.field_msgId == 0 || this.fFE.field_content == null) {
                z = false;
            } else {
                this.fEK = this.fFE.field_content;
                g.a fV = g.a.fV(this.fEK);
                if (fV == null) {
                    z = false;
                } else {
                    this.hcO = fV.hcO;
                    this.for = fV.for;
                    this.fGh = fV.appId;
                    this.appName = com.tencent.mm.pluginsdk.model.app.g.a(this.mController.xRr, com.tencent.mm.pluginsdk.model.app.g.aZ(this.fGh, true), null);
                    this.fwx = this.fFE.field_imgPath;
                }
            }
        }
        if (z) {
            an.aqK().c(this);
            initView();
            this.lFW = new f() {
                public final void a(int i, int i2, k kVar) {
                    float f;
                    if (i2 == 0) {
                        f = 0.0f;
                    } else {
                        f = (((float) i) * 100.0f) / ((float) i2);
                    }
                    AppMsgEmojiDownloadUI.this.pe((int) f);
                }
            };
            if (an.aqK().Se(this.for) == null) {
                long j = this.frh;
                String str = this.fEK;
                StringBuilder stringBuilder = new StringBuilder();
                as.Hm();
                l.c(j, str, stringBuilder.append(c.Fw()).append(this.lFY).toString());
            }
            this.lFU = new ab(this.for, this.lFW, 8);
            as.CN().a(this.lFU, 0);
            return;
        }
        finish();
    }

    protected final void initView() {
        this.lFZ = (PreViewEmojiView) findViewById(R.h.cal);
        this.lFZ.setImageBitmap(o.PC().a(this.fwx, 1.0f, true));
        setMMTitle("");
        this.lFX = (TextView) findViewById(R.h.ccR);
        TextView textView = (TextView) findViewById(R.h.bLi);
        this.appName = com.tencent.mm.pluginsdk.model.app.g.a(this.mController.xRr, com.tencent.mm.pluginsdk.model.app.g.aZ(this.fGh, true), null);
        if (this.fGh != null && this.fGh.length() > 0) {
            String str = this.appName;
            boolean z = (str == null || str.trim().length() == 0 || str.equals("weixinfile") || str.equals("invalid_appname")) ? false : true;
            if (z) {
                textView.setText(getString(R.l.dTm, new Object[]{this.appName}));
                textView.setVisibility(0);
                str = this.fGh;
                b bVar = new b();
                bVar.appId = str;
                bVar.fFG = "message";
                textView.setTag(bVar);
                textView.setOnClickListener(new com.tencent.mm.pluginsdk.ui.chat.l(this));
                Bitmap b = com.tencent.mm.pluginsdk.model.app.g.b(this.fGh, 2, com.tencent.mm.bu.a.getDensity(this));
                if (b == null || b.isRecycled()) {
                    a(this, textView, BitmapFactory.decodeResource(getResources(), R.g.bEn));
                } else {
                    a(this, textView, b);
                }
                this.lFV = (ProgressBar) findViewById(R.h.cdw);
                this.lFV.setMax(100);
                setBackBtn(new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        AppMsgEmojiDownloadUI.this.finish();
                        return true;
                    }
                });
            }
        }
        textView.setVisibility(8);
        this.lFV = (ProgressBar) findViewById(R.h.cdw);
        this.lFV.setMax(100);
        setBackBtn(/* anonymous class already generated */);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 221) {
            if (i == 0 && i2 == 0) {
                pe(this.lFV.getMax());
                return;
            }
            Toast.makeText(this, R.l.dZm, 0).show();
            this.lFV.setVisibility(8);
            this.lFX.setVisibility(8);
            x.e("MicroMsg.emoji.AppMsgEmojiDownloadUI", "onSceneEnd, download fail, errType = " + i + ", errCode = " + i2);
        }
    }

    protected void onPause() {
        super.onPause();
        as.CN().b(221, (e) this);
    }

    protected void onResume() {
        super.onResume();
        as.CN().a(221, (e) this);
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        com.tencent.mm.pluginsdk.model.app.b Se = an.aqK().Se(this.for);
        if (Se == null) {
            x.e("MicroMsg.emoji.AppMsgEmojiDownloadUI", "updateProgress fail");
            return;
        }
        long j = Se.field_totalLen;
        long j2 = Se.field_offset;
        this.lFX.setText(getString(R.l.dZo) + " " + getString(R.l.dZl, new Object[]{bi.by(j2), bi.by(j)}));
        int i = (int) ((Se.field_offset * 100) / Se.field_totalLen);
        x.v("MicroMsg.emoji.AppMsgEmojiDownloadUI", "attach progress:" + i + " offset:" + j2 + " totallen:" + j);
        pe(i);
    }

    private void pe(int i) {
        this.lFV.setProgress(i);
        if (i >= 100) {
            as.Hm();
            String Fw = c.Fw();
            com.tencent.mm.sdk.e.c Se = an.aqK().Se(this.for);
            if (Se == null) {
                x.e("MicroMsg.emoji.AppMsgEmojiDownloadUI", "saveImageAndPreview fail, info is null, attachid = " + this.for + ", msgContent = " + this.fEK);
            } else {
                int bN = com.tencent.mm.a.e.bN(Se.field_fileFullPath);
                Object d = com.tencent.mm.a.e.d(Se.field_fileFullPath, 0, bN);
                String s = com.tencent.mm.a.g.s(d);
                if (!bi.oN(s)) {
                    if (s == null || this.hcO == null || s.equalsIgnoreCase(this.hcO)) {
                        com.tencent.mm.a.e.g(Fw, this.lFY, s);
                        Se.field_fileFullPath = Fw + s;
                        an.aqK().a(Se.field_msgInfoId, Se);
                        Bitmap a = o.PC().a(this.fwx, 1.0f, true);
                        if (a != null) {
                            m(Fw + s + "_thumb", a);
                        }
                        EmojiInfo a2 = p.bq(d) ? i.aCl().lCw.a(s, "", EmojiInfo.xIH, EmojiInfo.xIR, bN, this.fGh, "") : i.aCl().lCw.a(s, "", EmojiInfo.xIH, EmojiInfo.xIS, bN, this.fGh, "");
                        this.lFV.setVisibility(8);
                        this.lFX.setVisibility(8);
                        if (a2 != null) {
                            this.lFZ.cY(a2.clq(), null);
                            this.lFZ.resume();
                        }
                    } else {
                        x.e("MicroMsg.emoji.AppMsgEmojiDownloadUI", "md5 not match!! emoticonmd5 is=" + this.hcO + ", gen md5 is=" + s);
                        x.e("MicroMsg.emoji.AppMsgEmojiDownloadUI", "fileFullPath = " + Se.field_fileFullPath + ", fileLength = " + bN + ", bufLength = " + d.length + ", buf = " + d);
                        Toast.makeText(this, getString(R.l.dZm), 0).show();
                        finish();
                    }
                }
            }
            an.aqK().j(this);
            as.CN().b(221, (e) this);
        }
    }

    private static boolean m(String str, Bitmap bitmap) {
        try {
            d.a(bitmap, 100, CompressFormat.PNG, str, true);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private static void a(AppMsgEmojiDownloadUI appMsgEmojiDownloadUI, TextView textView, Bitmap bitmap) {
        Drawable bitmapDrawable = new BitmapDrawable(bitmap);
        int dimension = (int) appMsgEmojiDownloadUI.getResources().getDimension(R.f.bvt);
        bitmapDrawable.setBounds(0, 0, dimension, dimension);
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
    }

    protected void onDestroy() {
        super.onDestroy();
        as.CN().c(this.lFU);
        an.aqK().j(this);
    }
}
