package com.tencent.mm.plugin.emoji.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ap.o;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.ct;
import com.tencent.mm.f.a.ob;
import com.tencent.mm.plugin.emoji.a.f;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.j;
import com.tencent.mm.plugin.emoji.f.k;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.model.h.a;
import com.tencent.mm.plugin.emoji.model.h.b;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ai;
import com.tencent.mm.pluginsdk.ui.chat.l;
import com.tencent.mm.pluginsdk.ui.emoji.MMEmojiView;
import com.tencent.mm.protocal.c.abu;
import com.tencent.mm.protocal.c.aca;
import com.tencent.mm.protocal.c.ace;
import com.tencent.mm.protocal.c.st;
import com.tencent.mm.protocal.c.sx;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CustomSmileyPreviewUI extends MMActivity implements OnItemClickListener, e, a, b {
    private ListView Fv;
    private final String TAG = "MicroMsg.emoji.CustomSmileyPreviewUI";
    private String frQ;
    private EmojiInfo kvY;
    private g lGA;
    f lGH;
    private View lGI;
    private ImageView lGJ;
    private TextView lGK;
    private TextView lGL;
    private abu lGM;
    private st lGN = new st();
    private String lGO;
    private TextView lGP;
    private h lGQ;
    private aca lGR;
    private final int lGS = 131077;
    private long lGT;
    String lGU;
    private String lGV;
    private c lGW = new c<ob>() {
        {
            this.xmG = ob.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ob obVar = (ob) bVar;
            if (CustomSmileyPreviewUI.this.lGT != 0 && obVar.fGN.fGQ == CustomSmileyPreviewUI.this.lGT) {
                x.i("MicroMsg.emoji.CustomSmileyPreviewUI", "msg is revoked.");
                com.tencent.mm.ui.base.h.a(CustomSmileyPreviewUI.this.mController.xRr, obVar.fGN.fGO, "", CustomSmileyPreviewUI.this.getString(R.l.dSU), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (dialogInterface != null) {
                            dialogInterface.dismiss();
                        }
                        CustomSmileyPreviewUI.this.finish();
                    }
                });
            }
            return false;
        }
    };
    protected final int lGo = 131074;
    private final int lGp = 131075;
    private final int lGq = 131076;
    private final String lGr = "product_id";
    private final String lGs = "progress";
    private final String lGt = DownloadInfo.STATUS;
    private c lGz = new c<ct>() {
        {
            this.xmG = ct.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ct ctVar = (ct) bVar;
            if (!(ctVar == null || bi.oN(CustomSmileyPreviewUI.this.frQ) || !CustomSmileyPreviewUI.this.frQ.equals(ctVar.frP.frQ))) {
                CustomSmileyPreviewUI customSmileyPreviewUI = CustomSmileyPreviewUI.this;
                String str = ctVar.frP.frQ;
                int i = ctVar.frP.status;
                int i2 = ctVar.frP.progress;
                x.d("MicroMsg.emoji.CustomSmileyPreviewUI", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", str, Integer.valueOf(i), Integer.valueOf(i2), ctVar.frP.frR);
                if (i == 6) {
                    Message obtain = Message.obtain();
                    obtain.getData().putString("product_id", str);
                    obtain.getData().putInt("progress", i2);
                    obtain.what = 131075;
                    if (customSmileyPreviewUI.mHandler != null) {
                        customSmileyPreviewUI.mHandler.sendMessage(obtain);
                    }
                } else {
                    x.i("MicroMsg.emoji.CustomSmileyPreviewUI", "product status:%d", Integer.valueOf(i));
                    Message obtain2 = Message.obtain();
                    obtain2.getData().putString("product_id", str);
                    obtain2.getData().putInt(DownloadInfo.STATUS, i);
                    obtain2.what = 131076;
                    if (customSmileyPreviewUI.mHandler != null) {
                        customSmileyPreviewUI.mHandler.sendMessage(obtain2);
                    }
                }
                if (!(customSmileyPreviewUI.lGH == null || customSmileyPreviewUI.lGH.lAm == null)) {
                    com.tencent.mm.plugin.emoji.a.a.f yA = customSmileyPreviewUI.lGH.lAm.yA(str);
                    if (yA != null) {
                        yA.lAB = r4;
                    }
                }
            }
            return false;
        }
    };
    ag mHandler = new ag() {
        public final void handleMessage(Message message) {
            int i;
            String string;
            switch (message.what) {
                case 2:
                    CustomSmileyPreviewUI.this.a(CustomSmileyPreviewUI.this.frQ, CustomSmileyPreviewUI.this.kvY);
                    return;
                case 131075:
                    i = message.getData().getInt("progress");
                    string = message.getData().getString("product_id");
                    if (bi.oN(string)) {
                        x.w("MicroMsg.emoji.CustomSmileyPreviewUI", "product id is null.");
                        return;
                    } else if (CustomSmileyPreviewUI.this.lGH != null && CustomSmileyPreviewUI.this.lGH.lAm != null) {
                        CustomSmileyPreviewUI.this.lGH.bf(string, i);
                        CustomSmileyPreviewUI.this.lGH.amN();
                        return;
                    } else {
                        return;
                    }
                case 131076:
                    i = message.getData().getInt(DownloadInfo.STATUS);
                    string = message.getData().getString("product_id");
                    if (bi.oN(string)) {
                        x.w("MicroMsg.emoji.CustomSmileyPreviewUI", "product id is null.");
                        return;
                    } else if (CustomSmileyPreviewUI.this.lGH != null && CustomSmileyPreviewUI.this.lGH.lAm != null) {
                        CustomSmileyPreviewUI.this.lGH.be(string, i);
                        return;
                    } else {
                        return;
                    }
                case 131077:
                    if (CustomSmileyPreviewUI.this.lGP != null) {
                        CustomSmileyPreviewUI.this.lGP.setText(((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yF(CustomSmileyPreviewUI.this.kvY.Nx()));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    static /* synthetic */ void a(CustomSmileyPreviewUI customSmileyPreviewUI, String str) {
        Intent intent = new Intent();
        intent.putExtra("showShare", true);
        intent.putExtra("rawUrl", str);
        d.b(customSmileyPreviewUI, "webview", ".ui.tools.WebViewUI", intent);
        com.tencent.mm.plugin.report.service.g.pWK.h(12789, Integer.valueOf(4), customSmileyPreviewUI.kvY.Nx(), Integer.valueOf(1), customSmileyPreviewUI.kvY.field_designerID, customSmileyPreviewUI.kvY.field_groupId, "", "", "", "", customSmileyPreviewUI.kvY.field_activityid);
    }

    static /* synthetic */ void f(CustomSmileyPreviewUI customSmileyPreviewUI) {
        customSmileyPreviewUI.kvY = i.aCl().lCw.YB(customSmileyPreviewUI.kvY.Nx());
        com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(customSmileyPreviewUI, com.tencent.mm.ui.widget.g.zCt, false);
        gVar.rQF = new p.c() {
            public final void a(n nVar) {
                if (!(CustomSmileyPreviewUI.this.kvY.field_catalog == EmojiInfo.xIN || CustomSmileyPreviewUI.this.kvY.clk())) {
                    nVar.eT(0, R.l.dCM);
                }
                if (CustomSmileyPreviewUI.this.kvY.field_catalog == EmojiInfo.xIN || bi.oN(CustomSmileyPreviewUI.this.kvY.field_groupId) || (!bi.oN(CustomSmileyPreviewUI.this.kvY.field_groupId) && ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yL(CustomSmileyPreviewUI.this.kvY.field_groupId))) {
                    nVar.eT(1, R.l.eET);
                }
                nVar.eT(2, R.l.eac);
            }
        };
        gVar.rQG = new p.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 0:
                        Context context = CustomSmileyPreviewUI.this;
                        EmojiInfo YB = i.aCl().lCw.YB(context.getIntent().getStringExtra("custom_smiley_preview_md5"));
                        if (YB == null) {
                            x.w("MicroMsg.emoji.CustomSmileyPreviewUI", "[cpan] save custom emoji failed. emoji is null.");
                            return;
                        } else if (YB.field_catalog == EmojiInfo.xIJ) {
                            return;
                        } else {
                            if (YB.field_catalog == EmojiInfo.xIN) {
                                com.tencent.mm.ui.base.h.bu(context, context.getString(R.l.dDW));
                                return;
                            } else {
                                i.aCh().a(context.mController.xRr, YB, 4, context.lGU);
                                return;
                            }
                        }
                    case 1:
                        CustomSmileyPreviewUI.n(CustomSmileyPreviewUI.this);
                        return;
                    case 2:
                        CustomSmileyPreviewUI.o(CustomSmileyPreviewUI.this);
                        return;
                    default:
                        return;
                }
            }
        };
        gVar.bUX();
    }

    static /* synthetic */ void n(CustomSmileyPreviewUI customSmileyPreviewUI) {
        String stringExtra = customSmileyPreviewUI.getIntent().getStringExtra("custom_smiley_preview_md5");
        int intExtra = customSmileyPreviewUI.getIntent().getIntExtra("CropImage_CompressType", 0);
        int intExtra2 = customSmileyPreviewUI.getIntent().getIntExtra("CropImage_Msg_Id", -1);
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", stringExtra);
        intent.putExtra("Retr_Msg_Id", intExtra2);
        intent.putExtra("Retr_Msg_Type", 5);
        intent.putExtra("Retr_Compress_Type", intExtra);
        com.tencent.mm.plugin.emoji.b.ihN.l(intent, customSmileyPreviewUI);
        com.tencent.mm.plugin.report.service.g.pWK.h(12789, Integer.valueOf(1), customSmileyPreviewUI.kvY.Nx(), Integer.valueOf(1), customSmileyPreviewUI.kvY.field_designerID, customSmileyPreviewUI.kvY.field_groupId, customSmileyPreviewUI.lGU, "", "", "", customSmileyPreviewUI.kvY.field_activityid);
    }

    static /* synthetic */ void o(CustomSmileyPreviewUI customSmileyPreviewUI) {
        Intent intent = new Intent();
        ArrayList arrayList = new ArrayList();
        arrayList.add(customSmileyPreviewUI.lGV);
        intent.putStringArrayListExtra("k_outside_expose_proof_item_list", arrayList);
        intent.putExtra("k_username", customSmileyPreviewUI.lGU);
        intent.putExtra("k_expose_msg_id", customSmileyPreviewUI.lGT);
        intent.putExtra("k_expose_msg_type", 47);
        intent.putExtra("showShare", false);
        intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(51)}));
        d.b(customSmileyPreviewUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    protected final int getLayoutId() {
        return R.i.dfu;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as.CN().a(412, (e) this);
        as.CN().a(521, (e) this);
        as.CN().a(411, (e) this);
        as.CN().a((int) ai.CTRL_BYTE, (e) this);
        as.CN().a(368, (e) this);
        com.tencent.mm.sdk.b.a.xmy.b(this.lGz);
        com.tencent.mm.sdk.b.a.xmy.b(this.lGW);
        initView();
    }

    protected void onResume() {
        super.onResume();
    }

    public void onStart() {
        super.onStart();
    }

    public void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        as.CN().b(412, (e) this);
        as.CN().b(521, (e) this);
        as.CN().b(411, (e) this);
        as.CN().b((int) ai.CTRL_BYTE, (e) this);
        as.CN().b(368, (e) this);
        com.tencent.mm.sdk.b.a.xmy.c(this.lGz);
        com.tencent.mm.sdk.b.a.xmy.c(this.lGW);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle("");
        String stringExtra = getIntent().getStringExtra("custom_smiley_preview_md5");
        this.lGT = getIntent().getLongExtra("msg_id", 0);
        this.lGU = getIntent().getStringExtra("msg_sender");
        this.lGV = getIntent().getStringExtra("msg_content");
        x.d("MicroMsg.emoji.CustomSmileyPreviewUI", "[initView] md5:%s", stringExtra);
        Object oM = bi.oM(stringExtra);
        if (TextUtils.isEmpty(oM)) {
            x.e("MicroMsg.emoji.CustomSmileyPreviewUI", "CustomSmileyPreviewUI ini fail md5 is fail");
            finish();
        }
        this.lGP = (TextView) findViewById(R.h.cak);
        final MMEmojiView mMEmojiView = (MMEmojiView) findViewById(R.h.cal);
        if (com.tencent.mm.sdk.a.b.cfx()) {
            mMEmojiView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    Toast.makeText(CustomSmileyPreviewUI.this.mController.xRr, "isHevc:" + mMEmojiView.vzm, 0).show();
                }
            });
        }
        if (mMEmojiView == null) {
            x.e("MicroMsg.emoji.CustomSmileyPreviewUI", "CustomSmileyPreviewUI ini fail emojiView is null.");
            finish();
            return;
        }
        String str;
        String str2;
        boolean z;
        com.tencent.mm.plugin.report.service.g gVar;
        Object[] objArr;
        this.kvY = i.aCl().lCw.YB(oM);
        if (this.kvY.clk()) {
            InputStream bk = EmojiInfo.bk(this, this.kvY.getName());
            if (bk != null) {
                mMEmojiView.a(bk, this.kvY.getName());
            } else {
                str = "MicroMsg.emoji.CustomSmileyPreviewUI";
                str2 = "input stream is null. emoji name is:%s";
                Object[] objArr2 = new Object[1];
                objArr2[0] = this.kvY == null ? "null" : this.kvY.getName();
                x.e(str, str2, objArr2);
            }
        } else {
            mMEmojiView.a(this.kvY, "");
            if (!(this.kvY == null || this.kvY.clp())) {
                com.tencent.mm.plugin.emoji.e.c.aBv();
                com.tencent.mm.plugin.emoji.e.c.a(this.kvY, true);
            }
        }
        CharSequence yF = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yF(this.kvY.Nx());
        if (!(this.lGP == null || bi.oN(yF))) {
            this.lGP.setText(yF);
            mMEmojiView.setContentDescription(yF);
        }
        str2 = getIntent().getStringExtra("custom_smiley_preview_appid");
        String stringExtra2 = getIntent().getStringExtra("custom_smiley_preview_appname");
        TextView textView = (TextView) findViewById(R.h.bLi);
        com.tencent.mm.pluginsdk.model.app.f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(str2, true);
        str = (aZ == null || aZ.field_appName == null || aZ.field_appName.trim().length() <= 0) ? stringExtra2 : aZ.field_appName;
        if (str2 != null && str2.length() > 0) {
            if (str == null || str.trim().length() == 0 || str.equals("weixinfile") || str.equals("invalid_appname")) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                textView.setText(getString(R.l.dTm, new Object[]{com.tencent.mm.pluginsdk.model.app.g.a(this.mController.xRr, aZ, str)}));
                textView.setVisibility(0);
                l.b bVar = new l.b();
                bVar.appId = str2;
                bVar.fFG = "message";
                textView.setTag(bVar);
                textView.setOnClickListener(new l(this));
                Bitmap b = com.tencent.mm.pluginsdk.model.app.g.b(str2, 2, com.tencent.mm.bu.a.getDensity(this));
                if (b == null || b.isRecycled()) {
                    a(this, textView, BitmapFactory.decodeResource(getResources(), R.g.bEn));
                } else {
                    a(this, textView, b);
                }
                setBackBtn(new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        CustomSmileyPreviewUI.this.finish();
                        return true;
                    }
                });
                if (this.kvY.field_catalog != EmojiInfo.xIN || this.kvY.clk()) {
                    z = false;
                } else {
                    z = true;
                }
                if (this.kvY.field_catalog == EmojiInfo.xIN || bi.oN(this.kvY.field_groupId) || (!bi.oN(this.kvY.field_groupId) && ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yL(this.kvY.field_groupId))) {
                    z = true;
                }
                addIconOptionMenu(0, R.g.bDJ, new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        CustomSmileyPreviewUI.f(CustomSmileyPreviewUI.this);
                        return true;
                    }
                });
                showOptionMenu(z);
                this.lGI = findViewById(R.h.caW);
                this.lGJ = (ImageView) this.lGI.findViewById(R.h.cbb);
                this.lGK = (TextView) this.lGI.findViewById(R.h.cbk);
                this.lGL = (TextView) this.lGI.findViewById(R.h.caZ);
                this.lGI.setVisibility(8);
                if (!(this.kvY == null || bi.oN(this.kvY.field_designerID))) {
                    this.lGM = i.aCl().lCC.YF(this.kvY.field_designerID);
                    as.CN().a(new com.tencent.mm.plugin.emoji.f.i(this.kvY.field_designerID), 0);
                }
                if (!(this.kvY == null || bi.oN(this.kvY.field_activityid))) {
                    this.lGR = i.aCl().lCz.YL(this.kvY.field_activityid);
                    stringExtra = this.kvY.field_activityid;
                    stringExtra2 = this.kvY.field_md5;
                    if (this.lGR == null && (this.lGR == null || this.lGR.wrE == null || ((long) this.lGR.wrE.whi) >= System.currentTimeMillis() / 1000)) {
                        x.i("MicroMsg.emoji.CustomSmileyPreviewUI", "no need to load emoji activity");
                    } else {
                        as.CN().a(new j(stringExtra, stringExtra2), 0);
                    }
                }
                aDj();
                this.lGI.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        if (CustomSmileyPreviewUI.this.lGM == null || CustomSmileyPreviewUI.this.lGM.wrA == null) {
                            x.i("MicroMsg.emoji.CustomSmileyPreviewUI", "simple designer info is null");
                            return;
                        }
                        Intent intent = new Intent();
                        intent.setClass(CustomSmileyPreviewUI.this.mController.xRr, EmojiStoreV2DesignerUI.class);
                        intent.putExtra(OpenSDKTool4Assistant.EXTRA_UIN, CustomSmileyPreviewUI.this.lGM.wrA.wrt);
                        intent.putExtra("name", CustomSmileyPreviewUI.this.lGM.wrA.nkW);
                        intent.putExtra("headurl", CustomSmileyPreviewUI.this.lGM.wrA.whR);
                        intent.putExtra("extra_scence", 9);
                        CustomSmileyPreviewUI.this.mController.xRr.startActivity(intent);
                    }
                });
                gVar = com.tencent.mm.plugin.report.service.g.pWK;
                objArr = new Object[5];
                objArr[0] = Integer.valueOf(2);
                objArr[1] = this.frQ;
                objArr[2] = oM;
                if (this.kvY != null) {
                    stringExtra = "";
                } else {
                    stringExtra = this.kvY.field_designerID;
                }
                objArr[3] = stringExtra;
                if (this.kvY != null) {
                    stringExtra = "";
                } else {
                    stringExtra = this.kvY.field_activityid;
                }
                objArr[4] = stringExtra;
                gVar.h(12067, objArr);
            }
        }
        textView.setVisibility(8);
        this.frQ = this.kvY.field_groupId;
        as.CN().a(new k(this.frQ), 0);
        this.Fv = (ListView) findViewById(16908298);
        this.lGH = new f(this.mController.xRr);
        this.lGH.lAn = this;
        this.lGH.lzG = true;
        this.lGH.lzJ = false;
        this.Fv.setOnItemClickListener(this);
        this.Fv.setAdapter(this.lGH);
        this.lGH.lAl = this.Fv;
        if (!bi.oN(this.frQ)) {
            com.tencent.mm.storage.emotion.i YH = i.aCl().lCA.YH(this.frQ);
            if (!(YH == null || YH.field_content == null)) {
                ace ace = new ace();
                try {
                    ace.aH(YH.field_content);
                    this.lGN = ace.wrI;
                    this.lGO = YH.field_lan;
                } catch (Throwable e) {
                    x.e("MicroMsg.emoji.CustomSmileyPreviewUI", "exception:%s", bi.i(e));
                }
            }
            if (this.lGN == null || bi.oN(this.lGO) || !this.lGO.equalsIgnoreCase(w.eM(this.mController.xRr))) {
                as.CN().a(new com.tencent.mm.plugin.emoji.f.l(this.frQ, 1), 0);
            } else {
                com.tencent.mm.plugin.emoji.a.a.c aDk = aDk();
                if (this.lGH != null) {
                    this.lGH.a(aDk);
                }
                as.CN().a(new com.tencent.mm.plugin.emoji.f.l(this.frQ, 1, this.lGN.kzy), 0);
            }
        }
        this.lGQ = new h();
        this.lGQ.kgx = this;
        this.lGQ.lDw = this.lGH;
        this.lGQ.lDz = 9;
        this.lGQ.lDC = this;
        a(this.frQ, this.kvY);
        setBackBtn(/* anonymous class already generated */);
        if (this.kvY.field_catalog != EmojiInfo.xIN) {
        }
        z = false;
        z = true;
        addIconOptionMenu(0, R.g.bDJ, /* anonymous class already generated */);
        showOptionMenu(z);
        this.lGI = findViewById(R.h.caW);
        this.lGJ = (ImageView) this.lGI.findViewById(R.h.cbb);
        this.lGK = (TextView) this.lGI.findViewById(R.h.cbk);
        this.lGL = (TextView) this.lGI.findViewById(R.h.caZ);
        this.lGI.setVisibility(8);
        this.lGM = i.aCl().lCC.YF(this.kvY.field_designerID);
        as.CN().a(new com.tencent.mm.plugin.emoji.f.i(this.kvY.field_designerID), 0);
        this.lGR = i.aCl().lCz.YL(this.kvY.field_activityid);
        stringExtra = this.kvY.field_activityid;
        stringExtra2 = this.kvY.field_md5;
        if (this.lGR == null) {
        }
        as.CN().a(new j(stringExtra, stringExtra2), 0);
        aDj();
        this.lGI.setOnClickListener(/* anonymous class already generated */);
        gVar = com.tencent.mm.plugin.report.service.g.pWK;
        objArr = new Object[5];
        objArr[0] = Integer.valueOf(2);
        objArr[1] = this.frQ;
        objArr[2] = oM;
        if (this.kvY != null) {
            stringExtra = this.kvY.field_designerID;
        } else {
            stringExtra = "";
        }
        objArr[3] = stringExtra;
        if (this.kvY != null) {
            stringExtra = this.kvY.field_activityid;
        } else {
            stringExtra = "";
        }
        objArr[4] = stringExtra;
        gVar.h(12067, objArr);
    }

    private void aDj() {
        this.mHandler.post(new Runnable() {
            public final void run() {
                if (CustomSmileyPreviewUI.this.lGR != null && CustomSmileyPreviewUI.this.lGR.wrE != null) {
                    CustomSmileyPreviewUI.this.lGI.setVisibility(0);
                    CustomSmileyPreviewUI.this.lGK.setText(CustomSmileyPreviewUI.this.lGR.wrE.nkW);
                    if (bi.oN(CustomSmileyPreviewUI.this.lGR.wrE.nlA)) {
                        CustomSmileyPreviewUI.this.lGJ.setVisibility(8);
                    } else {
                        CustomSmileyPreviewUI.this.lGJ.setVisibility(0);
                        o.PG().a(CustomSmileyPreviewUI.this.lGR.wrE.nlA, CustomSmileyPreviewUI.this.lGJ, com.tencent.mm.plugin.emoji.e.f.cp(CustomSmileyPreviewUI.this.kvY.field_groupId, CustomSmileyPreviewUI.this.lGR.wrE.nlA));
                    }
                    CustomSmileyPreviewUI.this.lGL.setText(R.l.dZH);
                    CustomSmileyPreviewUI.this.lGI.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            CustomSmileyPreviewUI.a(CustomSmileyPreviewUI.this, CustomSmileyPreviewUI.this.lGR.wrE.whh);
                        }
                    });
                    CustomSmileyPreviewUI.this.Fv.setVisibility(8);
                } else if (CustomSmileyPreviewUI.this.lGM == null || CustomSmileyPreviewUI.this.lGM.wrA == null) {
                    CustomSmileyPreviewUI.this.lGI.setVisibility(8);
                } else {
                    CustomSmileyPreviewUI.this.lGI.setVisibility(0);
                    CustomSmileyPreviewUI.this.lGK.setText(CustomSmileyPreviewUI.this.lGM.wrA.nkW);
                    o.PG().a(CustomSmileyPreviewUI.this.lGM.wrA.whR, CustomSmileyPreviewUI.this.lGJ, com.tencent.mm.plugin.emoji.e.f.co(CustomSmileyPreviewUI.this.kvY.field_groupId, CustomSmileyPreviewUI.this.lGM.wrA.whR));
                    CustomSmileyPreviewUI.this.Fv.setVisibility(8);
                }
            }
        });
    }

    private static void a(CustomSmileyPreviewUI customSmileyPreviewUI, TextView textView, Bitmap bitmap) {
        Drawable bitmapDrawable = new BitmapDrawable(bitmap);
        int dimension = (int) customSmileyPreviewUI.getResources().getDimension(R.f.bvt);
        bitmapDrawable.setBounds(0, 0, dimension, dimension);
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
    }

    public final void a(int r8, int r9, java.lang.String r10, com.tencent.mm.ad.k r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r3 = 2;
        r6 = 1;
        r5 = 0;
        r0 = r11.getType();
        switch(r0) {
            case 239: goto L_0x0141;
            case 368: goto L_0x014e;
            case 411: goto L_0x012e;
            case 412: goto L_0x000b;
            case 521: goto L_0x011b;
            default: goto L_0x000a;
        };
    L_0x000a:
        return;
    L_0x000b:
        r11 = (com.tencent.mm.plugin.emoji.f.l) r11;
        if (r8 != 0) goto L_0x008a;
    L_0x000f:
        if (r9 != 0) goto L_0x0087;
    L_0x0011:
        r0 = r11.aCz();
        r7.lGN = r0;
        r0 = r7.lGN;
        if (r0 == 0) goto L_0x005c;
    L_0x001b:
        r0 = r7.frQ;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x005c;
    L_0x0023:
        r0 = r7.frQ;
        r1 = r7.lGN;
        r1 = r1.vPI;
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x005c;
    L_0x002f:
        r0 = r7.aDk();
        r1 = r7.lGH;
        if (r1 == 0) goto L_0x003c;
    L_0x0037:
        r1 = r7.lGH;
        r1.a(r0);
    L_0x003c:
        r0 = r7.mHandler;
        r0.sendEmptyMessage(r5);
        r0 = "MicroMsg.emoji.CustomSmileyPreviewUI";
        r1 = new java.lang.StringBuilder;
        r2 = "[onSceneEnd]";
        r1.<init>(r2);
        r2 = r7.lGN;
        r2 = r2.vPI;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        goto L_0x000a;
    L_0x005c:
        r1 = "MicroMsg.emoji.CustomSmileyPreviewUI";
        r2 = "[onSceneEnd no same product id] cureent:%s,scene:%s";
        r3 = new java.lang.Object[r3];
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r4 = r7.frQ;
        r0 = r0.append(r4);
        r0 = r0.toString();
        r3[r5] = r0;
        r0 = r7.lGN;
        if (r0 != 0) goto L_0x0082;
    L_0x0079:
        r0 = "";
    L_0x007c:
        r3[r6] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);
        goto L_0x000a;
    L_0x0082:
        r0 = r7.lGN;
        r0 = r0.vPI;
        goto L_0x007c;
    L_0x0087:
        if (r9 != r6) goto L_0x000a;
    L_0x0089:
        goto L_0x000a;
    L_0x008a:
        r0 = 5;
        if (r9 != r0) goto L_0x000a;
    L_0x008d:
        r0 = r7.lGN;
        if (r0 == 0) goto L_0x00ef;
    L_0x0091:
        r0 = r11.aCz();
        if (r0 == 0) goto L_0x00ef;
    L_0x0097:
        r0 = r7.frQ;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x00ef;
    L_0x009f:
        r0 = r7.frQ;
        r1 = r7.lGN;
        r1 = r1.vPI;
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00ef;
    L_0x00ab:
        r0 = r7.lGN;
        r0 = r0.whA;
        r1 = r11.aCz();
        r1 = r1.whA;
        if (r0 == r1) goto L_0x00ef;
    L_0x00b7:
        r0 = r7.lGN;
        r1 = r11.aCz();
        r1 = r1.whA;
        r0.whA = r1;
        r0 = r7.aDk();
        r1 = r7.lGH;
        if (r1 == 0) goto L_0x00ce;
    L_0x00c9:
        r1 = r7.lGH;
        r1.a(r0);
    L_0x00ce:
        r0 = r7.mHandler;
        r0.sendEmptyMessage(r5);
        r0 = "MicroMsg.emoji.CustomSmileyPreviewUI";
        r1 = new java.lang.StringBuilder;
        r2 = "[onSceneEnd]";
        r1.<init>(r2);
        r2 = r7.lGN;
        r2 = r2.vPI;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        goto L_0x000a;
    L_0x00ef:
        r1 = "MicroMsg.emoji.CustomSmileyPreviewUI";
        r2 = "[onSceneEnd no same product id or PackFlag is same.] cureent:%s,scene:%s";
        r3 = new java.lang.Object[r3];
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r4 = r7.frQ;
        r0 = r0.append(r4);
        r0 = r0.toString();
        r3[r5] = r0;
        r0 = r7.lGN;
        if (r0 != 0) goto L_0x0116;
    L_0x010c:
        r0 = "";
    L_0x010f:
        r3[r6] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);
        goto L_0x000a;
    L_0x0116:
        r0 = r7.lGN;
        r0 = r0.vPI;
        goto L_0x010f;
    L_0x011b:
        if (r9 != 0) goto L_0x000a;
    L_0x011d:
        r0 = r7.mHandler;
        r0.sendEmptyMessage(r3);
        r0 = r7.mHandler;
        r1 = 131077; // 0x20005 float:1.83678E-40 double:6.47606E-319;
        r2 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r0.sendEmptyMessageDelayed(r1, r2);
        goto L_0x000a;
    L_0x012e:
        r11 = (com.tencent.mm.plugin.emoji.f.n) r11;
        r0 = com.tencent.mm.plugin.emoji.model.i.aCl();
        r0 = r0.lCz;
        r1 = 12;
        r2 = r11.aCB();
        r0.a(r1, r2);
        goto L_0x000a;
    L_0x0141:
        r11 = (com.tencent.mm.plugin.emoji.f.i) r11;
        r0 = r11.aCx();
        r7.lGM = r0;
        r7.aDj();
        goto L_0x000a;
    L_0x014e:
        if (r9 != 0) goto L_0x0183;
    L_0x0150:
        r11 = (com.tencent.mm.plugin.emoji.f.j) r11;
        r0 = r11.gLB;
        r0 = r0.hnR;
        r0 = r0.hnY;
        r0 = (com.tencent.mm.protocal.c.aca) r0;
        if (r0 == 0) goto L_0x017c;
    L_0x015c:
        r1 = r0.wrE;
        if (r1 == 0) goto L_0x017c;
    L_0x0160:
        r1 = r0.wrE;
        r2 = java.lang.System.currentTimeMillis();
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r2 / r4;
        r2 = (int) r2;
        r3 = r0.wrE;
        r3 = r3.whi;
        r2 = r2 + r3;
        r1.whi = r2;
        r1 = com.tencent.mm.plugin.emoji.model.i.aCl();
        r1 = r1.lCz;
        r2 = r11.lEF;
        r1.a(r2, r0);
    L_0x017c:
        r7.lGR = r0;
        r7.aDj();
        goto L_0x000a;
    L_0x0183:
        r0 = "MicroMsg.emoji.CustomSmileyPreviewUI";
        r1 = "get activity failed.";
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
        goto L_0x000a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI.a(int, int, java.lang.String, com.tencent.mm.ad.k):void");
    }

    private com.tencent.mm.plugin.emoji.a.a.c aDk() {
        List arrayList = new ArrayList();
        sx sxVar = new sx();
        sxVar.whD = this.lGN.whD;
        sxVar.nlA = this.lGN.nlA;
        sxVar.whv = this.lGN.whv;
        sxVar.whA = this.lGN.whA;
        sxVar.whw = this.lGN.whw;
        sxVar.whE = this.lGN.whE;
        sxVar.whz = this.lGN.whz;
        sxVar.why = this.lGN.why;
        sxVar.whG = this.lGN.whG;
        sxVar.whH = this.lGN.whH;
        sxVar.vPI = this.lGN.vPI;
        arrayList.add(new com.tencent.mm.plugin.emoji.a.a.f(sxVar));
        return new com.tencent.mm.plugin.emoji.a.a.c(arrayList);
    }

    private void a(String str, EmojiInfo emojiInfo) {
        if (!bi.oN(str) && emojiInfo != null) {
            if (!bi.oN(str) && emojiInfo.field_catalog != EmojiGroupInfo.xIF && emojiInfo.field_catalog != EmojiGroupInfo.xIE && ((emojiInfo.field_type != EmojiInfo.xIR || emojiInfo.field_type != EmojiInfo.xIS) && i.aCl().lCy.Yy(str))) {
                if (this.Fv != null) {
                    this.Fv.setVisibility(0);
                }
                if (this.lGH == null) {
                    return;
                }
                if (i.aCl().lCy.Yz(str)) {
                    this.lGH.lzH = true;
                } else {
                    this.lGH.lzH = false;
                }
            } else if (this.Fv != null) {
                this.Fv.setVisibility(8);
            }
        }
    }

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        String str = "MicroMsg.emoji.CustomSmileyPreviewUI";
        String str2 = "[onProductClick] productId:%s, productPrice:%s, productStatus:%d";
        Object[] objArr = new Object[3];
        objArr[0] = aVar.aBa();
        objArr[1] = TextUtils.isEmpty(aVar.aBc()) ? "" : aVar.aBc();
        objArr[2] = Integer.valueOf(aVar.aBb());
        x.i(str, str2, objArr);
        this.lGQ.a(aVar);
    }

    public final void J(String str, String str2, String str3) {
        this.lGA = new g(str, str2, str3);
        as.CN().a(this.lGA, 0);
    }

    public final void aCd() {
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.lGH != null && i >= 0 && i < this.lGH.getCount()) {
            com.tencent.mm.plugin.emoji.a.a.f oY = this.lGH.oY(i);
            Intent intent = new Intent();
            intent.setClass(this, EmojiStoreDetailUI.class);
            sx sxVar = oY.lAy;
            if (sxVar == null) {
                intent = null;
            } else {
                intent.putExtra("extra_id", sxVar.vPI);
                intent.putExtra("extra_name", sxVar.whv);
                intent.putExtra("extra_copyright", sxVar.whF);
                intent.putExtra("extra_coverurl", sxVar.whD);
                intent.putExtra("extra_description", sxVar.whw);
                intent.putExtra("extra_price", sxVar.why);
                intent.putExtra("extra_type", sxVar.whz);
                intent.putExtra("extra_flag", sxVar.whA);
                intent.putExtra("preceding_scence", 4);
                intent.putExtra("call_by", 1);
                intent.putExtra("download_entrance_scene", 9);
                intent.putExtra("check_clickflag", true);
                intent.putExtra("extra_status", oY.mStatus);
                intent.putExtra("extra_progress", oY.sm);
                String stringExtra = getIntent().getStringExtra("to_talker_name");
                if (!bi.oN(stringExtra)) {
                    intent.putExtra("to_talker_name", stringExtra);
                }
            }
            startActivity(intent);
        }
    }
}
