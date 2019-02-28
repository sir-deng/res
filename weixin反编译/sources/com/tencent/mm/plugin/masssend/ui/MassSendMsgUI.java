package com.tencent.mm.plugin.masssend.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.aq.b;
import com.tencent.mm.bl.d;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.network.ab;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.model.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.c.aqp;
import com.tencent.mm.protocal.c.ara;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MassSendMsgUI extends MMActivity implements e {
    private static String ots = "";
    private String filePath;
    private TextView nQV;
    private ChatFooter osJ;
    private String osL;
    private List<String> osM;
    private boolean osN = false;
    private TextView otr;
    private i ott;
    private b otu;
    private a otv = new a() {
        public final void aZt() {
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.l.evd), 0).show();
        }

        public final void aZu() {
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.l.euR), 0).show();
        }

        public final void aZv() {
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.l.evb), 0).show();
        }

        public final void aZw() {
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.l.euX), 0).show();
        }

        public final void aZx() {
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.l.euR), 0).show();
        }

        public final void sI(int i) {
            switch (i) {
                case 0:
                    File file = new File(com.tencent.mm.compatible.util.e.gJf);
                    if (file.exists() || file.mkdir()) {
                        x.i("MicroMsg.MassSendMsgUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(MassSendMsgUI.this.mController.xRr, "android.permission.CAMERA", 16, "", "")), bi.chl(), MassSendMsgUI.this.mController.xRr);
                        if (com.tencent.mm.pluginsdk.g.a.a(MassSendMsgUI.this.mController.xRr, "android.permission.CAMERA", 16, "", "")) {
                            MassSendMsgUI.this.asx();
                            return;
                        }
                        return;
                    }
                    Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.l.dTp), 1).show();
                    return;
                case 1:
                    k.a(MassSendMsgUI.this, 1, 1, 0, 3, false, null);
                    return;
                default:
                    return;
            }
        }

        public final void b(f fVar) {
        }

        public final void aZy() {
            com.tencent.mm.plugin.masssend.a.ihN.av(MassSendMsgUI.this);
        }

        public final void aZz() {
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.l.euR), 0).show();
        }

        public final void aZA() {
        }

        public final void aZB() {
            Intent intent = new Intent();
            intent.putExtra("preceding_scence", 13);
            d.b(MassSendMsgUI.this, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
        }

        public final void sJ(int i) {
            MassSendMsgUI.d(MassSendMsgUI.this);
        }

        public final void aZC() {
            Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.l.euY), 0).show();
        }

        public final void aZD() {
        }

        public final void aZE() {
        }

        public final void aZF() {
        }

        public final void aZG() {
        }
    };
    private r tipDialog = null;

    static /* synthetic */ void a(MassSendMsgUI massSendMsgUI, String str, int i) {
        com.tencent.mm.plugin.masssend.a.a aVar = new com.tencent.mm.plugin.masssend.a.a();
        aVar.oss = massSendMsgUI.osL;
        aVar.ost = massSendMsgUI.osM.size();
        aVar.filename = str;
        aVar.osu = i;
        aVar.osx = 2;
        aVar.msgType = 43;
        final com.tencent.mm.ad.k fVar = new com.tencent.mm.plugin.masssend.a.f(aVar, massSendMsgUI.osN);
        as.CN().a(fVar, 0);
        if (massSendMsgUI.tipDialog != null && massSendMsgUI.tipDialog.isShowing()) {
            massSendMsgUI.tipDialog.setOnCancelListener(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    as.CN().c(fVar);
                }
            });
        }
    }

    static /* synthetic */ void d(MassSendMsgUI massSendMsgUI) {
        x.i("MicroMsg.MassSendMsgUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(massSendMsgUI, "android.permission.CAMERA", 18, "", "")), bi.chl(), massSendMsgUI);
        if (com.tencent.mm.pluginsdk.g.a.a(massSendMsgUI, "android.permission.CAMERA", 18, "", "")) {
            x.i("MicroMsg.MassSendMsgUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(massSendMsgUI, "android.permission.RECORD_AUDIO", 18, "", "")), bi.chl(), massSendMsgUI);
            if (com.tencent.mm.pluginsdk.g.a.a(massSendMsgUI, "android.permission.RECORD_AUDIO", 18, "", "")) {
                g.pWK.h(13822, Integer.valueOf(1), Integer.valueOf(1));
                k.a((Context) massSendMsgUI, 8, new Intent(), 1, massSendMsgUI.osL, 0);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as.CN().a((int) JsApiChooseMedia.CTRL_INDEX, (e) this);
        this.osN = getIntent().getBooleanExtra("mass_send_again", false);
        this.osL = getIntent().getStringExtra("mass_send_contact_list");
        String str = this.osL;
        this.osM = new ArrayList();
        if (!(str == null || str.equals(""))) {
            String[] split = str.split(";");
            if (split != null && split.length > 0) {
                this.osM = bi.F(split);
            }
        }
        initView();
    }

    protected void onResume() {
        super.onResume();
        if (this.osJ != null) {
            this.osJ.p(ots, -1, true);
            this.osJ.a(this.mController.xRr, (Activity) this);
        }
    }

    public static void EQ(String str) {
        ots = str;
    }

    protected void onDestroy() {
        as.CN().b((int) JsApiChooseMedia.CTRL_INDEX, (e) this);
        super.onDestroy();
        if (this.osJ != null) {
            this.osJ.destroy();
        }
    }

    protected void onPause() {
        this.osJ.aKv();
        this.osJ.onPause();
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.dnk;
    }

    protected final void initView() {
        CharSequence spannableString;
        boolean z = false;
        setMMTitle(R.l.dnk);
        this.otr = (TextView) findViewById(R.h.cvt);
        this.nQV = (TextView) findViewById(R.h.cvs);
        TextView textView = this.otr;
        int textSize = (int) this.otr.getTextSize();
        if (this.osM == null) {
            spannableString = new SpannableString("");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < this.osM.size(); i++) {
                String gw = com.tencent.mm.y.r.gw((String) this.osM.get(i));
                if (i == this.osM.size() - 1) {
                    stringBuilder.append(gw);
                } else {
                    stringBuilder.append(gw + ",  ");
                }
            }
            spannableString = com.tencent.mm.pluginsdk.ui.d.i.c(this, stringBuilder.toString(), textSize);
        }
        textView.setText(spannableString);
        this.nQV.setText(getResources().getQuantityString(R.j.duM, this.osM.size(), new Object[]{Integer.valueOf(this.osM.size())}));
        this.osJ = (ChatFooter) findViewById(R.h.cyL);
        ((MassSendLayout) findViewById(R.h.cvx)).jRL = this.osJ.vwH;
        this.osJ.CH(R.h.cvx);
        this.otu = new b(this, this.osJ, this.osL, this.osM, this.osN);
        this.osJ.vwP = this.otu;
        this.osJ.b(new d(this));
        ChatFooter chatFooter = this.osJ;
        as.Hm();
        int intValue = ((Integer) c.Db().get(18, Integer.valueOf(-1))).intValue();
        if (intValue == -1) {
            intValue = 1;
        }
        chatFooter.ab(intValue, true);
        this.osJ.Tf("masssendapp");
        this.osJ.vwD.refresh();
        as.Hm();
        if (((Boolean) c.Db().get(66832, Boolean.valueOf(false))).booleanValue()) {
            this.osJ.ccy();
            this.osJ.ccu();
        }
        this.osJ.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String valueOf = String.valueOf(charSequence);
                final String substring = valueOf.substring(i, i + i3);
                if ((MassSendMsgUI.this.ott == null || !MassSendMsgUI.this.ott.isShowing()) && p.Vu(substring)) {
                    Bitmap d = com.tencent.mm.sdk.platformtools.d.d(substring, 300, 300, false);
                    if (d == null) {
                        x.e("MicroMsg.MassSendMsgUI", "showAlert fail, bmp is null");
                        return;
                    }
                    View imageView = new ImageView(MassSendMsgUI.this);
                    imageView.setImageBitmap(d);
                    int dimensionPixelSize = MassSendMsgUI.this.getResources().getDimensionPixelSize(R.f.bvw);
                    imageView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                    MassSendMsgUI.this.ott = h.a(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.l.dTh), imageView, MassSendMsgUI.this.getString(R.l.dGf), MassSendMsgUI.this.getString(R.l.dEy), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent();
                            intent.putExtra("CropImage_OutputPath", substring);
                            MassSendMsgUI.this.O(intent);
                        }
                    }, null);
                    String str = valueOf.substring(0, i) + valueOf.substring(i + i3);
                    MassSendMsgUI.this.osJ.p(str, -1, false);
                    MassSendMsgUI.ots = str;
                }
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.osJ.cct();
        this.osJ.ccl();
        this.osJ.ccs();
        this.osJ.cco();
        this.osJ.ccr();
        this.osJ.lq(true);
        this.osJ.a(this.otv);
        ChatFooter chatFooter2 = this.osJ;
        d.cdJ();
        if (b.PV() || (q.Gj() & 33554432) != 0) {
            z = true;
        }
        chatFooter2.lr(z);
        this.osJ.ccn();
        this.osJ.ccx();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                MassSendMsgUI.this.finish();
                return true;
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || keyEvent.getAction() != 0 || !this.osJ.ccA()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.osJ.ccC();
        return true;
    }

    private void asx() {
        if (!k.c((Activity) this, com.tencent.mm.compatible.util.e.gJf, "microMsg." + System.currentTimeMillis() + ".jpg", 2)) {
            Toast.makeText(this, getString(R.l.eJI), 1).show();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.MassSendMsgUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    asx();
                    return;
                } else {
                    h.a((Context) this, getString(R.l.ezZ), getString(R.l.eAg), getString(R.l.esG), getString(R.l.cancel), false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            MassSendMsgUI.this.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            default:
                return;
        }
    }

    private void N(Intent intent) {
        String stringExtra = intent.getStringExtra("VideoRecorder_FileName");
        int intExtra = intent.getIntExtra("VideoRecorder_VideoLength", 0);
        com.tencent.mm.plugin.masssend.a.a aVar = new com.tencent.mm.plugin.masssend.a.a();
        aVar.oss = this.osL;
        aVar.ost = this.osM.size();
        aVar.filename = stringExtra;
        aVar.osu = intExtra;
        aVar.msgType = 43;
        final com.tencent.mm.ad.k fVar = new com.tencent.mm.plugin.masssend.a.f(aVar, this.osN);
        as.CN().a(fVar, 0);
        Context context = this.mController.xRr;
        getString(R.l.dGZ);
        this.tipDialog = h.a(context, getString(R.l.eKs), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                as.CN().c(fVar);
            }
        });
    }

    private void O(Intent intent) {
        String stringExtra = intent.getStringExtra("CropImage_OutputPath");
        if (stringExtra != null) {
            int i = q.a(stringExtra, null, intent.getBooleanExtra("CropImage_Compress_Img", true)) ? 1 : 0;
            com.tencent.mm.plugin.masssend.a.h.aZj();
            com.tencent.mm.plugin.masssend.a.a j = com.tencent.mm.plugin.masssend.a.b.j(stringExtra, this.osL, this.osM.size(), i);
            if (j != null) {
                final com.tencent.mm.ad.k fVar = new com.tencent.mm.plugin.masssend.a.f(j, this.osN, i);
                as.CN().a(fVar, 0);
                Context context = this.mController.xRr;
                getString(R.l.dGZ);
                this.tipDialog = h.a(context, getString(R.l.eKs), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        as.CN().c(fVar);
                    }
                });
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.MassSendMsgUI", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            Context applicationContext;
            switch (i) {
                case 1:
                    if (intent == null) {
                        return;
                    }
                    if (intent.getBooleanExtra("is_video", false)) {
                        String stringExtra = intent.getStringExtra("video_full_path");
                        Intent intent2 = new Intent();
                        intent2.setData(Uri.parse("file://" + stringExtra));
                        P(intent2);
                        return;
                    }
                    Intent intent3 = new Intent();
                    intent3.putExtra("CropImageMode", 4);
                    intent3.putExtra("CropImage_Filter", true);
                    n nVar = com.tencent.mm.plugin.masssend.a.ihN;
                    as.Hm();
                    nVar.a((Activity) this, intent, intent3, c.Fp(), 4, null);
                    return;
                case 2:
                    applicationContext = getApplicationContext();
                    as.Hm();
                    this.filePath = k.b(applicationContext, intent, c.Fp());
                    if (this.filePath != null) {
                        Intent intent4 = new Intent();
                        intent4.putExtra("CropImageMode", 4);
                        intent4.putExtra("CropImage_Filter", true);
                        intent4.putExtra("CropImage_ImgPath", this.filePath);
                        com.tencent.mm.plugin.masssend.a.ihN.a(this.mController.xRr, intent4, 4);
                        return;
                    }
                    return;
                case 4:
                    O(intent);
                    return;
                case 5:
                    N(intent);
                    return;
                case 6:
                    P(intent);
                    return;
                case 7:
                    if (intent == null) {
                        return;
                    }
                    if (intent.getBooleanExtra("from_record", false)) {
                        N(intent);
                        return;
                    } else {
                        P(intent);
                        return;
                    }
                case 8:
                    SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult == null) {
                        return;
                    }
                    String str;
                    if (sightCaptureResult.owf) {
                        str = sightCaptureResult.own;
                        if (!bi.oN(str)) {
                            try {
                                boolean z = sightCaptureResult.owg;
                                x.i("MicroMsg.MassSendMsgUI", "doSendChattingImage, path: %s", str);
                                com.tencent.mm.plugin.masssend.a.h.aZj();
                                com.tencent.mm.plugin.masssend.a.a j = com.tencent.mm.plugin.masssend.a.b.j(str, this.osL, this.osM.size(), 0);
                                if (j != null) {
                                    final com.tencent.mm.ad.k fVar = new com.tencent.mm.plugin.masssend.a.f(j, this.osN, 0);
                                    as.CN().a(fVar, 0);
                                    applicationContext = this.mController.xRr;
                                    getString(R.l.dGZ);
                                    this.tipDialog = h.a(applicationContext, getString(R.l.eKs), true, new OnCancelListener() {
                                        public final void onCancel(DialogInterface dialogInterface) {
                                            as.CN().c(fVar);
                                        }
                                    });
                                    return;
                                }
                                return;
                            } catch (Exception e) {
                                x.e("MicroMsg.MassSendMsgUI", "doSendChattingImage error: %s", e.getMessage());
                                return;
                            }
                        }
                        return;
                    }
                    x.i("MicroMsg.MassSendMsgUI", "video path %s thumb path ", sightCaptureResult.owh, sightCaptureResult.owi);
                    o.Ub();
                    str = s.nx(sightCaptureResult.owj);
                    if (!sightCaptureResult.owh.equals(str)) {
                        x.i("MicroMsg.MassSendMsgUI", "filepath not videopath and move it %s %s", sightCaptureResult.owh, str);
                        FileOp.at(sightCaptureResult.owh, str);
                    }
                    str = sightCaptureResult.owj;
                    final int i3 = sightCaptureResult.owl;
                    final com.tencent.mm.modelvideo.c cVar = new com.tencent.mm.modelvideo.c();
                    getString(R.l.dGZ);
                    this.tipDialog = h.a((Context) this, getString(R.l.dHn), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            cVar.hVc = null;
                        }
                    });
                    com.tencent.mm.sdk.f.e.post(new Runnable() {
                        public final void run() {
                            VideoTransPara Nb = com.tencent.mm.modelcontrol.d.Na().Nb();
                            aqp aqp = new aqp();
                            aqp.wEa = true;
                            if (l.a(str, Nb, aqp, new com.tencent.mm.plugin.mmsight.model.d() {
                                public final boolean aZH() {
                                    return false;
                                }
                            })) {
                                l.b(str, Nb, aqp, new com.tencent.mm.plugin.mmsight.model.d() {
                                    public final boolean aZH() {
                                        return false;
                                    }
                                });
                            }
                            ah.y(new Runnable() {
                                public final void run() {
                                    MassSendMsgUI.a(MassSendMsgUI.this, str, i3);
                                }
                            });
                        }
                    }, "MassSend_Remux");
                    return;
                default:
                    x.e("MicroMsg.MassSendMsgUI", "onActivityResult: not found this requestCode");
                    return;
            }
        }
    }

    private void P(final Intent intent) {
        if (ab.bC(this)) {
            Q(intent);
        } else {
            h.a((Context) this, R.l.eTp, R.l.dGZ, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    MassSendMsgUI.this.Q(intent);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }

    private void Q(Intent intent) {
        final com.tencent.mm.modelvideo.c cVar = new com.tencent.mm.modelvideo.c();
        getString(R.l.dGZ);
        this.tipDialog = h.a((Context) this, getString(R.l.dHn), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                cVar.hVc = null;
            }
        });
        cVar.a(this, intent, new com.tencent.mm.modelvideo.c.a() {
            public final void b(int i, final String str, final String str2, final int i2) {
                x.d("MicroMsg.MassSendMsgUI", "onImportFinish, ret: %s, fileName: %s, importPath: %s", Integer.valueOf(i), str, str2);
                if (i >= 0 || i == -50002) {
                    com.tencent.mm.sdk.f.e.post(new Runnable() {
                        public final void run() {
                            if (MassSendMsgUI.this.dp(str, str2)) {
                                ah.y(new Runnable() {
                                    public final void run() {
                                        MassSendMsgUI.a(MassSendMsgUI.this, str, i2);
                                    }
                                });
                            } else {
                                ah.y(new Runnable() {
                                    public final void run() {
                                        Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.l.eTo), 0).show();
                                        if (MassSendMsgUI.this.tipDialog != null) {
                                            MassSendMsgUI.this.tipDialog.dismiss();
                                            MassSendMsgUI.this.tipDialog = null;
                                        }
                                    }
                                });
                            }
                        }
                    }, "MassSend_Remux");
                    return;
                }
                Toast.makeText(MassSendMsgUI.this, MassSendMsgUI.this.getString(R.l.eTn), 0).show();
                if (MassSendMsgUI.this.tipDialog != null) {
                    MassSendMsgUI.this.tipDialog.dismiss();
                    MassSendMsgUI.this.tipDialog = null;
                }
            }
        });
    }

    private boolean dp(String str, String str2) {
        double d;
        boolean is2G = ao.is2G(this);
        int i = is2G ? 10485760 : 26214400;
        if (is2G) {
            d = 60000.0d;
        } else {
            d = 300000.0d;
        }
        x.i("MicroMsg.MassSendMsgUI", "check remuxing, ret %d", Integer.valueOf(SightVideoJNI.shouldRemuxing(str2, 660, 500, i, d, Constants.MAX_BUFFER_SIZE)));
        switch (SightVideoJNI.shouldRemuxing(str2, 660, 500, i, d, Constants.MAX_BUFFER_SIZE)) {
            case -6:
            case -5:
            case -4:
            case -3:
            case -2:
            case -1:
                return false;
            case 0:
                String ny;
                Bitmap createVideoThumbnail;
                o.Ub();
                String nx = s.nx(str);
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(str2);
                x.i("MicroMsg.MassSendMsgUI", "start remux, targetPath: %s", nx);
                int i2 = bi.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
                int i3 = bi.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
                int i4 = 0;
                i = i3;
                int i5 = i2;
                while (i4 < 3) {
                    if (i5 % 2 != 0 || i % 2 != 0) {
                        return false;
                    }
                    if ((i5 < i || (i5 > 640 && i > 480)) && (i5 > i || (i5 > 480 && i > 640))) {
                        i /= 2;
                        i4++;
                        i5 /= 2;
                    }
                    mediaMetadataRetriever.release();
                    if (SightVideoJNI.remuxing(str2, nx, i5, i, com.tencent.mm.plugin.sight.base.b.qzb, com.tencent.mm.plugin.sight.base.b.qza, 8, 2, 25.0f, com.tencent.mm.plugin.sight.base.b.qzc, null, 0, false) >= 0) {
                        x.w("MicroMsg.MassSendMsgUI", "remuxing video error");
                        return false;
                    }
                    ER(nx);
                    o.Ub();
                    ny = s.ny(str);
                    if (!FileOp.bO(ny)) {
                        x.i("MicroMsg.MassSendMsgUI", "thumb not exist create one, thumbPath: %s", ny);
                        try {
                            createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(nx, 1);
                            if (createVideoThumbnail != null) {
                                com.tencent.mm.sdk.platformtools.d.a(createVideoThumbnail, 60, CompressFormat.JPEG, ny, true);
                            }
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.MassSendMsgUI", e, "", new Object[0]);
                            x.e("MicroMsg.MassSendMsgUI", "create thumb error: %s", e.getMessage());
                        }
                    }
                    x.i("MicroMsg.MassSendMsgUI", "do remux, targetPath: %s, outputWidth: %s, outputHeight: %s, retDuration: %s", nx, Integer.valueOf(i5), Integer.valueOf(i), Integer.valueOf(i2));
                    return true;
                }
                i = i3;
                i5 = i2;
                mediaMetadataRetriever.release();
                if (SightVideoJNI.remuxing(str2, nx, i5, i, com.tencent.mm.plugin.sight.base.b.qzb, com.tencent.mm.plugin.sight.base.b.qza, 8, 2, 25.0f, com.tencent.mm.plugin.sight.base.b.qzc, null, 0, false) >= 0) {
                    ER(nx);
                    o.Ub();
                    ny = s.ny(str);
                    if (FileOp.bO(ny)) {
                        x.i("MicroMsg.MassSendMsgUI", "thumb not exist create one, thumbPath: %s", ny);
                        createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(nx, 1);
                        if (createVideoThumbnail != null) {
                            com.tencent.mm.sdk.platformtools.d.a(createVideoThumbnail, 60, CompressFormat.JPEG, ny, true);
                        }
                    }
                    x.i("MicroMsg.MassSendMsgUI", "do remux, targetPath: %s, outputWidth: %s, outputHeight: %s, retDuration: %s", nx, Integer.valueOf(i5), Integer.valueOf(i), Integer.valueOf(i2));
                    return true;
                }
                x.w("MicroMsg.MassSendMsgUI", "remuxing video error");
                return false;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                o.Ub();
                ER(s.nx(str));
                return true;
            default:
                return false;
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ad.k kVar) {
        x.i("MicroMsg.MassSendMsgUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (this.otu != null) {
            b bVar = this.otu;
            if (bVar.tipDialog != null) {
                bVar.tipDialog.dismiss();
                bVar.tipDialog = null;
            }
        }
        if (i == 0 && i2 == 0) {
            ots = "";
            Intent intent = new Intent(this, MassSendHistoryUI.class);
            intent.addFlags(67108864);
            startActivity(intent);
            finish();
        } else if (i == 4 && i2 == -24) {
            x.e("MicroMsg.MassSendMsgUI", "onSceneEnd, masssend err spam");
            Toast.makeText(this, R.l.euV, 0).show();
        } else {
            if (i == 2 || i == 1 || i == 3) {
                this.osJ.p(ots, -1, true);
            }
            com.tencent.mm.plugin.masssend.a.ihO.a(this.mController.xRr, i, i2, str);
            switch (i2) {
                case -71:
                    int i3 = ((ara) ((com.tencent.mm.plugin.masssend.a.f) kVar).gLB.hnR.hnY).wEK;
                    h.a((Context) this, getString(R.l.evc, new Object[]{Integer.valueOf(i3)}), getString(R.l.dGZ), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            MassSendMsgUI.this.finish();
                        }
                    });
                    return;
                case -34:
                    Toast.makeText(this, R.l.euU, 0).show();
                    return;
                default:
                    Toast.makeText(this, R.l.eKq, 0).show();
                    return;
            }
        }
    }

    private static void ER(String str) {
        long bN = (long) com.tencent.mm.a.e.bN(str);
        int e = bi.e((Integer) g.a((int) (bN / 1024), new int[]{WXMediaMessage.TITLE_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2048, 5120, 8192, 10240, 15360, 20480}, (int) an.CTRL_INDEX, 255));
        g.pWK.a(106, (long) e, 1, false);
        g.pWK.a(106, 246, 1, false);
        x.d("MicroMsg.MassSendMsgUI", "report video size res : " + e + " hadCompress : true fileLen : " + (bN / 1024) + "K");
    }
}
