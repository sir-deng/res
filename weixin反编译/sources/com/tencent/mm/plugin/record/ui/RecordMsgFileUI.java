package com.tencent.mm.plugin.record.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.bl.d;
import com.tencent.mm.j.g;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.tools.a;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.as;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class RecordMsgFileUI extends MMActivity implements c {
    private long frh;
    private uz fvZ;
    private ag hbP;
    private TextView jIt;
    private f kYP = null;
    private ProgressBar lFV;
    private TextView lmk;
    private Button mBH;
    private Button mBI;
    private Button mBJ;
    private MMImageView mBK;
    private TextView mBL;
    private View mBM;
    private View mBN;
    private boolean mBR = false;
    private boolean mBV = false;
    private boolean mBW = false;
    private String mediaId;
    private com.tencent.mm.plugin.record.b.f pLY;

    static /* synthetic */ void h(RecordMsgFileUI recordMsgFileUI) {
        int i = 1;
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        if (recordMsgFileUI.getType() == 15) {
            i = 11;
            intent.putExtra("image_path", recordMsgFileUI.bnN());
        } else if (recordMsgFileUI.getType() == 4) {
            intent.putExtra("image_path", recordMsgFileUI.bnN());
        } else {
            intent.putExtra("desc_title", recordMsgFileUI.fvZ.title);
            i = 3;
        }
        intent.putExtra("Retr_Msg_Type", i);
        d.a((Context) recordMsgFileUI, ".ui.transmit.SelectConversationUI", intent, 1001);
    }

    protected final int getLayoutId() {
        return R.i.dig;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hbP = new ag();
        this.pLY = new com.tencent.mm.plugin.record.b.f();
        this.frh = getIntent().getLongExtra("message_id", -1);
        String stringExtra = getIntent().getStringExtra("record_data_id");
        com.tencent.mm.protocal.b.a.c IP = h.IP(getIntent().getStringExtra("record_xml"));
        if (IP == null) {
            x.w("MicroMsg.RecordMsgFileUI", "get record msg data error, empty");
            finish();
            return;
        }
        Iterator it = IP.hfI.iterator();
        while (it.hasNext()) {
            uz uzVar = (uz) it.next();
            if (uzVar.mBr.equals(stringExtra)) {
                this.fvZ = uzVar;
            }
        }
        if (this.fvZ == null) {
            x.w("MicroMsg.RecordMsgFileUI", "get data error, empty");
            finish();
            return;
        }
        this.mediaId = h.d(this.fvZ.mBr, this.frh, true);
        this.mBH = (Button) findViewById(R.h.cDw);
        this.mBI = (Button) findViewById(R.h.cBO);
        this.mBJ = (Button) findViewById(R.h.ccy);
        this.mBK = (MMImageView) findViewById(R.h.coQ);
        this.lmk = (TextView) findViewById(R.h.cyG);
        this.jIt = (TextView) findViewById(R.h.cSl);
        this.mBN = findViewById(R.h.ccQ);
        this.mBM = findViewById(R.h.ccM);
        this.lFV = (ProgressBar) findViewById(R.h.ccL);
        this.mBL = (TextView) findViewById(R.h.ccN);
        if (4 == getType()) {
            setMMTitle(R.l.ehf);
        } else if (15 == getType()) {
            setMMTitle(R.l.egN);
            findViewById(R.h.cUP).setBackgroundResource(R.e.black);
        } else {
            setMMTitle(R.l.efK);
        }
        if (getType() == 4) {
            this.mBK.setImageResource(R.k.dvL);
        } else {
            this.mBK.setImageResource(com.tencent.mm.pluginsdk.c.RI(this.fvZ.wkc));
        }
        this.lmk.setText(this.fvZ.title);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                RecordMsgFileUI.this.finish();
                return true;
            }
        });
        this.mBI.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                String c = h.c(RecordMsgFileUI.this.fvZ, RecordMsgFileUI.this.frh);
                new Intent().setAction("android.intent.action.VIEW");
                if (4 == RecordMsgFileUI.this.getType()) {
                    RecordMsgFileUI.this.mBV = false;
                    RecordMsgFileUI.this.aKo();
                    return;
                }
                a.b(RecordMsgFileUI.this, c, RecordMsgFileUI.this.fvZ.wkc, 5);
            }
        });
        final String str = this.fvZ.wjU;
        if (!bi.oN(str)) {
            this.mBH.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    d.b(RecordMsgFileUI.this.mController.xRr, "webview", ".ui.tools.WebViewUI", intent);
                }
            });
        }
        this.mBJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (com.tencent.mm.compatible.util.f.zl()) {
                    h.a(RecordMsgFileUI.this.fvZ, RecordMsgFileUI.this.frh, true);
                    RecordMsgFileUI.this.aKm();
                    return;
                }
                com.tencent.mm.ui.base.h.h(RecordMsgFileUI.this.mController.xRr, R.l.egh, R.l.dGZ);
            }
        });
        this.mBN.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                RecordMsgFileUI.this.aKn();
            }
        });
        if (getType() != 15 || bi.Wo(g.Af().getValue("SightForwardEnable")) == 1) {
            addIconOptionMenu(0, R.g.bDJ, new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(RecordMsgFileUI.this.mController.xRr, com.tencent.mm.ui.widget.g.zCt, false);
                    gVar.rQF = new p.c() {
                        public final void a(n nVar) {
                            nVar.f(0, RecordMsgFileUI.this.getString(R.l.egM));
                        }
                    };
                    gVar.rQG = new p.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            switch (menuItem.getItemId()) {
                                case 0:
                                    if (RecordMsgFileUI.this.getType() == 8) {
                                        String c = h.c(RecordMsgFileUI.this.fvZ, RecordMsgFileUI.this.frh);
                                        if (!e.bO(c)) {
                                            x.e("MicroMsg.RecordMsgFileUI", "share file failed, file not exists");
                                            Toast.makeText(RecordMsgFileUI.this, RecordMsgFileUI.this.getString(R.l.egK), 1).show();
                                            return;
                                        } else if (new File(c).length() > 10485760) {
                                            x.e("MicroMsg.RecordMsgFileUI", "share file failed, file too large");
                                            Toast.makeText(RecordMsgFileUI.this, RecordMsgFileUI.this.getString(R.l.egL), 1).show();
                                            return;
                                        }
                                    }
                                    RecordMsgFileUI.h(RecordMsgFileUI.this);
                                    return;
                                default:
                                    return;
                            }
                        }
                    };
                    gVar.bUX();
                    return true;
                }
            });
        } else {
            x.w("MicroMsg.RecordMsgFileUI", "can not retransmit sight msg");
        }
        if (bi.oN(this.fvZ.wjN) || bi.oN(this.fvZ.wjP)) {
            aKl();
        } else if (h.d(this.fvZ, this.frh)) {
            enableOptionMenu(true);
            bnM();
        } else {
            com.tencent.mm.plugin.record.a.f IO = com.tencent.mm.plugin.record.b.n.getRecordMsgCDNStorage().IO(this.mediaId);
            if (IO == null || 2 == IO.field_status) {
                aKn();
            } else if (4 == IO.field_status) {
                aKl();
            } else if (IO.field_status == 0 || 1 == IO.field_status) {
                aKm();
            } else {
                x.w("MicroMsg.RecordMsgFileUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
                aKn();
            }
            enableOptionMenu(false);
        }
        com.tencent.mm.plugin.record.b.n.getRecordMsgCDNStorage().a((c) this);
    }

    private int getType() {
        int i = this.fvZ.bjS;
        if (i == 15) {
            return 4;
        }
        return i;
    }

    private void aKl() {
        this.mBJ.setVisibility(8);
        this.mBH.setVisibility(8);
        this.mBI.setVisibility(8);
        this.mBM.setVisibility(8);
        this.jIt.setVisibility(0);
        if (this.fvZ.bjS == 4) {
            this.jIt.setGravity(17);
            this.jIt.setText(R.l.egl);
            return;
        }
        this.jIt.setGravity(17);
        this.jIt.setText(R.l.egk);
    }

    private void aKm() {
        this.mBJ.setVisibility(8);
        this.mBH.setVisibility(8);
        this.mBI.setVisibility(8);
        this.jIt.setVisibility(8);
        this.mBM.setVisibility(0);
        b(com.tencent.mm.plugin.record.b.n.getRecordMsgCDNStorage().IO(this.mediaId));
    }

    private void aKn() {
        this.mBM.setVisibility(8);
        this.mBI.setVisibility(8);
        if (bi.oN(this.fvZ.wjU)) {
            this.mBH.setVisibility(8);
        } else {
            this.mBH.setVisibility(0);
        }
        this.mBJ.setVisibility(0);
        this.mBJ.setText(R.l.efU);
        this.jIt.setVisibility(8);
    }

    private void bnM() {
        if (!(getType() != 15 || this.fvZ.wkN == null || bi.oN(this.fvZ.wkN.heZ) || bi.oN(this.fvZ.wkN.hfd))) {
            this.mBW = true;
            this.mBK.setVisibility(8);
            this.mBM.setVisibility(8);
            this.mBJ.setVisibility(8);
            this.mBH.setVisibility(8);
            this.mBI.setVisibility(8);
            this.jIt.setVisibility(8);
            String c = h.c(this.fvZ, this.frh);
            x.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.g.zn() + " initView: fullpath:" + c);
            ViewGroup viewGroup = (ViewGroup) findViewById(R.h.cUP);
            this.kYP = com.tencent.mm.pluginsdk.ui.tools.n.es(this.mController.xRr);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(13);
            viewGroup.addView((View) this.kYP, 0, layoutParams);
            this.kYP.a(new f.a() {
                public final void hY() {
                    x.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.g.zn() + " onPrepared");
                    RecordMsgFileUI.this.kYP.cR(true);
                    RecordMsgFileUI.this.kYP.start();
                }

                public final void onError(int i, int i2) {
                    RecordMsgFileUI.this.kYP.stop();
                    if (!RecordMsgFileUI.this.mBR) {
                        RecordMsgFileUI.this.mBR = true;
                        final Bitmap b = RecordMsgFileUI.this.pLY.b(RecordMsgFileUI.this.fvZ, RecordMsgFileUI.this.frh);
                        final String Uy = RecordMsgFileUI.this.kYP.Uy();
                        b.z(Base64.encodeToString((com.tencent.mm.plugin.sight.base.d.btm() + "[RecordMsgFileUI] on play sight error, what=" + i + ", extra=" + i2 + ", path=" + bi.aD(Uy, "")).getBytes(), 2), "FullScreenPlaySight");
                        ah.y(new Runnable() {
                            public final void run() {
                                ImageView imageView = (ImageView) RecordMsgFileUI.this.findViewById(R.h.cVO);
                                imageView.setImageBitmap(b);
                                imageView.setVisibility(0);
                                Intent intent = new Intent();
                                intent.setAction("android.intent.action.VIEW");
                                intent.setDataAndType(Uri.fromFile(new File(Uy)), "video/*");
                                try {
                                    RecordMsgFileUI.this.startActivity(Intent.createChooser(intent, RecordMsgFileUI.this.getString(R.l.ehf)));
                                } catch (Exception e) {
                                    x.e("MicroMsg.RecordMsgFileUI", "startActivity fail, activity not found");
                                    com.tencent.mm.ui.base.h.h(RecordMsgFileUI.this.mController.xRr, R.l.egf, R.l.egg);
                                }
                            }
                        });
                    }
                }

                public final void vi() {
                }

                public final int ck(int i, int i2) {
                    return 0;
                }

                public final void cl(int i, int i2) {
                }
            });
            x.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.g.zn() + " initView :" + c);
            if (c != null) {
                this.kYP.stop();
                this.kYP.setVideoPath(c);
            }
            x.d("MicroMsg.RecordMsgFileUI", com.tencent.mm.compatible.util.g.zn() + " initView");
            if (as.uy() != null) {
                as.uy().wI();
            }
        }
        if (getType() != 15 && getType() != 4) {
            this.mBM.setVisibility(8);
            this.mBJ.setVisibility(4);
            if (bi.oN(this.fvZ.wjU)) {
                this.mBH.setVisibility(8);
            } else {
                this.mBH.setVisibility(0);
            }
            this.mBI.setVisibility(0);
            this.jIt.setVisibility(0);
        } else if (!this.mBW) {
            this.mBM.setVisibility(8);
            this.mBJ.setVisibility(8);
            this.mBH.setVisibility(8);
            this.mBI.setVisibility(0);
            this.mBI.setText(R.l.efV);
            this.jIt.setVisibility(8);
            aKo();
        }
    }

    protected void onDestroy() {
        if (this.kYP != null) {
            this.kYP.a(null);
            this.kYP.stop();
            this.kYP.onDetach();
            if (as.uy() != null) {
                as.uy().wH();
            }
        }
        super.onDestroy();
        com.tencent.mm.plugin.record.b.n.getRecordMsgCDNStorage().b(this);
        this.pLY.destory();
    }

    protected void onResume() {
        super.onResume();
        if (this.kYP != null) {
            this.kYP.start();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.kYP != null) {
            this.kYP.stop();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        a.a(this, i, i2, intent, true, R.l.dZp, R.l.dZq, 5);
        if (i2 == -1 && i == 1001) {
            String str;
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("custom_send_text");
            }
            final Dialog a = com.tencent.mm.ui.base.h.a(this.mController.xRr, getString(R.l.efM), false, null);
            x.d("MicroMsg.RecordMsgFileUI", "do share msg, fav msg type %d", Integer.valueOf(getType()));
            final Runnable anonymousClass13 = new Runnable() {
                public final void run() {
                    a.dismiss();
                }
            };
            if (!bi.oN(stringExtra)) {
                final List F = bi.F(stringExtra.split(","));
                if (getType() == 4 || getType() == 15) {
                    as.Dt().F(new Runnable() {
                        public final void run() {
                            File file = new File(h.c(RecordMsgFileUI.this.fvZ, RecordMsgFileUI.this.frh));
                            for (String str : F) {
                                if (file.exists()) {
                                    String m = RecordMsgFileUI.this.bnN();
                                    x.d("MicroMsg.RecordMsgFileUI", "sendVideo::data path[%s] thumb path[%s]", file.getAbsolutePath(), m);
                                    if (RecordMsgFileUI.this.getType() == 15) {
                                        com.tencent.mm.plugin.messenger.a.f.aZN().a(RecordMsgFileUI.this.mController.xRr, str, file.getAbsolutePath(), m, 62, RecordMsgFileUI.this.fvZ.duration, "");
                                    } else {
                                        com.tencent.mm.plugin.messenger.a.f.aZN().a(RecordMsgFileUI.this.mController.xRr, str, file.getAbsolutePath(), m, 1, RecordMsgFileUI.this.fvZ.duration, "");
                                    }
                                } else {
                                    String str2 = RecordMsgFileUI.this.fvZ.wjU;
                                    if (!bi.oN(str2)) {
                                        IMediaObject wXVideoObject = new WXVideoObject();
                                        wXVideoObject.videoUrl = str2;
                                        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
                                        str2 = bi.aD(RecordMsgFileUI.this.fvZ.title, RecordMsgFileUI.this.mController.xRr.getResources().getString(R.l.ehf));
                                        wXMediaMessage.mediaObject = wXVideoObject;
                                        wXMediaMessage.title = str2;
                                        wXMediaMessage.description = RecordMsgFileUI.this.fvZ.desc;
                                        wXMediaMessage.thumbData = bi.readFromFile(h.f(RecordMsgFileUI.this.fvZ, RecordMsgFileUI.this.frh));
                                        if (wXMediaMessage.thumbData == null) {
                                            StringBuilder stringBuilder = new StringBuilder();
                                            as.Hm();
                                            wXMediaMessage.thumbData = bi.readFromFile(stringBuilder.append(com.tencent.mm.y.c.FD()).append("web/").append(com.tencent.mm.a.g.s(bi.aD(RecordMsgFileUI.this.fvZ.fra, "").getBytes())).toString());
                                        }
                                        l.a(wXMediaMessage, "", "", str, 3, null);
                                    }
                                }
                                com.tencent.mm.plugin.messenger.a.f.aZN().dq(str, str);
                            }
                            ah.y(anonymousClass13);
                        }

                        public final String toString() {
                            return super.toString() + "|onActivityResult1";
                        }
                    });
                } else {
                    as.Dt().F(new Runnable() {
                        public final void run() {
                            String c = h.c(RecordMsgFileUI.this.fvZ, RecordMsgFileUI.this.frh);
                            IMediaObject wXFileObject = new WXFileObject();
                            wXFileObject.setFilePath(c);
                            WXMediaMessage wXMediaMessage = new WXMediaMessage();
                            wXMediaMessage.mediaObject = wXFileObject;
                            wXMediaMessage.title = RecordMsgFileUI.this.fvZ.title;
                            wXMediaMessage.description = RecordMsgFileUI.this.fvZ.desc;
                            wXMediaMessage.thumbData = bi.readFromFile(h.f(RecordMsgFileUI.this.fvZ, RecordMsgFileUI.this.frh));
                            for (String str : F) {
                                l.a(wXMediaMessage, "", "", str, 3, null);
                                com.tencent.mm.plugin.messenger.a.f.aZN().dq(str, str);
                            }
                            ah.y(anonymousClass13);
                        }

                        public final String toString() {
                            return super.toString() + "|onActivityResult2";
                        }
                    });
                }
            }
        }
    }

    private String bnN() {
        File file = new File(h.f(this.fvZ, this.frh));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        StringBuilder stringBuilder = new StringBuilder();
        as.Hm();
        return stringBuilder.append(com.tencent.mm.y.c.FD()).append("web/").append(com.tencent.mm.a.g.s(bi.aD(this.fvZ.fra, "").getBytes())).toString();
    }

    private void b(com.tencent.mm.plugin.record.a.f fVar) {
        int max;
        int i;
        int i2 = 0;
        if (fVar != null) {
            max = (int) ((((float) fVar.field_offset) / ((float) Math.max(1, fVar.field_totalLen))) * 100.0f);
            i2 = fVar.field_offset;
            i = fVar.field_totalLen;
        } else {
            i = (int) this.fvZ.wki;
            max = 0;
        }
        this.hbP.post(new Runnable() {
            public final void run() {
                RecordMsgFileUI.this.lFV.setProgress(max);
                RecordMsgFileUI.this.mBL.setText(RecordMsgFileUI.this.getString(R.l.efi, new Object[]{bi.ah((float) i2), bi.ah((float) i)}));
            }
        });
    }

    public final void a(int i, com.tencent.mm.plugin.record.a.f fVar) {
        if (fVar == null) {
            x.w("MicroMsg.RecordMsgFileUI", "on cdn info changed, but cdn info is null");
            return;
        }
        x.v("MicroMsg.RecordMsgFileUI", "cur mediaid[%s], notify mediaid[%s]", this.mediaId, fVar.field_mediaId);
        if (this.mediaId.equals(fVar.field_mediaId)) {
            switch (fVar.field_status) {
                case 2:
                    this.hbP.post(new Runnable() {
                        public final void run() {
                            RecordMsgFileUI.this.enableOptionMenu(true);
                            RecordMsgFileUI.this.bnM();
                        }
                    });
                    return;
                case 3:
                    this.hbP.post(new Runnable() {
                        public final void run() {
                            RecordMsgFileUI.this.aKn();
                            com.tencent.mm.ui.base.h.bu(RecordMsgFileUI.this.mController.xRr, RecordMsgFileUI.this.getString(R.l.dZm));
                        }
                    });
                    return;
                case 4:
                    this.hbP.post(new Runnable() {
                        public final void run() {
                            RecordMsgFileUI.this.aKl();
                        }
                    });
                    return;
                default:
                    b(fVar);
                    return;
            }
        }
    }

    private void aKo() {
        if (!this.mBV) {
            this.mBV = true;
            Intent intent = new Intent();
            intent.putExtra("key_detail_fav_path", h.c(this.fvZ, this.frh));
            intent.putExtra("key_detail_fav_thumb_path", h.f(this.fvZ, this.frh));
            intent.putExtra("key_detail_fav_video_duration", this.fvZ.duration);
            intent.putExtra("key_detail_statExtStr", this.fvZ.fHB);
            intent.putExtra("key_detail_fav_video_scene_from", 1);
            d.b(this, "favorite", ".ui.detail.FavoriteVideoPlayUI", intent);
            finish();
        }
    }
}
