package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.plugin.qqmail.b.p;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.pluginsdk.model.f;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AttachDownloadPage extends MMActivity {
    private long fxb;
    private long hVV = 0;
    private int hVl = 0;
    private TextView ikq;
    private TextView jQO;
    private ProgressBar lFV;
    private Button mBH;
    private Button mBJ;
    private View mBM;
    private String ptN;
    private String puB;
    private long pvI;
    private MMImageView pvT;
    private ImageView pvU;
    private ImageView pvV;
    private TextView pvW;
    private String pvX;
    private int pvY;
    private boolean pvZ = false;
    private String pwa;
    private boolean pwb = true;
    private int retryCount = 0;

    static /* synthetic */ void a(AttachDownloadPage attachDownloadPage, String str) {
        b cgVar = new cg();
        f.a(cgVar, 9, str, e.bR(str), "");
        cgVar.frk.activity = attachDownloadPage;
        cgVar.frk.frr = 6;
        a.xmy.m(cgVar);
    }

    static /* synthetic */ void b(AttachDownloadPage attachDownloadPage, String str) {
        String bQ = e.bQ(str);
        if (bQ != null && bQ.length() != 0) {
            com.tencent.mm.pluginsdk.ui.tools.a.b(attachDownloadPage, str, bQ, 3);
        }
    }

    static /* synthetic */ void g(AttachDownloadPage attachDownloadPage) {
        if (attachDownloadPage.pvZ) {
            Intent intent = new Intent(attachDownloadPage.mController.xRr, CompressPreviewUI.class);
            intent.putExtra("mail_id", attachDownloadPage.ptN);
            intent.putExtra("attach_id", attachDownloadPage.puB);
            intent.putExtra("attach_size", attachDownloadPage.fxb);
            intent.putExtra("attach_name", attachDownloadPage.pwa);
            attachDownloadPage.mController.xRr.startActivity(intent);
            return;
        }
        String[] strArr = new String[]{"mailid=" + attachDownloadPage.ptN, "attachid=" + attachDownloadPage.puB, "texttype=html"};
        Intent intent2 = new Intent();
        intent2.putExtra("uri", "/cgi-bin/viewdocument");
        intent2.putExtra("params", strArr);
        intent2.putExtra("baseurl", p.bkU());
        intent2.putExtra("method", "get");
        intent2.putExtra("singleColumn", FileExplorerUI.Ts(attachDownloadPage.pwa));
        intent2.putExtra("title", attachDownloadPage.pwa);
        intent2.setClass(attachDownloadPage, MailWebViewUI.class);
        attachDownloadPage.startActivity(intent2);
    }

    static /* synthetic */ void j(AttachDownloadPage attachDownloadPage) {
        long length = new File(attachDownloadPage.hr(true)).length();
        x.d("MicroMsg.AttachDownloadPage", "cur download size:" + length);
        attachDownloadPage.hVV = length;
        attachDownloadPage.lFV.setProgress((int) ((100 * length) / attachDownloadPage.fxb));
        attachDownloadPage.pvW.setText(attachDownloadPage.getString(R.l.euf, new Object[]{bi.by(length), bi.by(attachDownloadPage.fxb)}));
        if (attachDownloadPage.hVl != 1 || attachDownloadPage.pvI == 0) {
            attachDownloadPage.pvW.setVisibility(8);
        } else {
            attachDownloadPage.pvW.setVisibility(0);
        }
    }

    protected final int getLayoutId() {
        return R.i.daJ;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pvY = getIntent().getIntExtra("is_preview", 0);
        this.pvZ = getIntent().getBooleanExtra("is_compress", false);
        this.pwa = getIntent().getStringExtra("attach_name");
        this.ptN = getIntent().getStringExtra("mail_id");
        this.puB = getIntent().getStringExtra("attach_id");
        this.fxb = getIntent().getLongExtra("total_size", 0);
        w.bkZ();
        this.pvX = p.getDownloadPath();
        setMMTitle(this.pwa);
        initView();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        w.bkZ().cancel(this.pvI);
    }

    protected final void initView() {
        this.pvT = (MMImageView) findViewById(R.h.ccV);
        this.mBM = findViewById(R.h.ccM);
        this.lFV = (ProgressBar) findViewById(R.h.ccL);
        this.pvU = (ImageView) findViewById(R.h.ccQ);
        this.pvV = (ImageView) findViewById(R.h.ccO);
        this.pvW = (TextView) findViewById(R.h.bLo);
        this.mBH = (Button) findViewById(R.h.bLq);
        this.mBJ = (Button) findViewById(R.h.bLn);
        this.ikq = (TextView) findViewById(R.h.bLp);
        this.jQO = (TextView) findViewById(R.h.bLr);
        if (FileExplorerUI.Ts(this.pwa)) {
            this.pvT.setBackgroundResource(R.k.dyE);
        } else if (FileExplorerUI.Tt(this.pwa)) {
            this.pvT.setImageResource(R.k.dvL);
        } else {
            int Sd = r.Sd(e.bQ(this.pwa));
            if (Sd > 0) {
                this.pvT.setImageResource(Sd);
            } else {
                this.pvT.setImageResource(R.k.dvI);
            }
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AttachDownloadPage.this.finish();
                return true;
            }
        });
        addIconOptionMenu(0, R.k.dAb, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                h.a(AttachDownloadPage.this, "", new String[]{AttachDownloadPage.this.getString(R.l.eAq)}, "", false, new c() {
                    public final void jo(int i) {
                        switch (i) {
                            case 0:
                                AttachDownloadPage.a(AttachDownloadPage.this, AttachDownloadPage.this.hr(false));
                                return;
                            default:
                                return;
                        }
                    }
                });
                return true;
            }
        });
        enableOptionMenu(false);
        blj();
        if (this.hVl == 1) {
            ble();
        } else {
            blf();
        }
    }

    private void ble() {
        this.mBM.setVisibility(0);
        this.mBH.setVisibility(8);
        this.mBJ.setVisibility(8);
        this.pvU.setVisibility(0);
        this.pvV.setVisibility(8);
        this.pvW.setVisibility(8);
        this.ikq.setVisibility(8);
        this.jQO.setVisibility(8);
        this.pvU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AttachDownloadPage.this.hVl = 2;
                w.bkZ().cancel(AttachDownloadPage.this.pvI);
                AttachDownloadPage.this.pvI = 0;
                AttachDownloadPage.this.blf();
            }
        });
        this.pvV.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AttachDownloadPage.this.retryCount = 0;
                AttachDownloadPage.this.blg();
            }
        });
    }

    private void blf() {
        if (this.pvY == 1) {
            if (FileExplorerUI.Ts(this.pwa)) {
                if (this.hVl == 3) {
                    Intent intent = new Intent();
                    intent.putExtra("key_favorite", true);
                    intent.putExtra("key_favorite_source_type", 9);
                    intent.putExtra("key_image_path", hr(false));
                    com.tencent.mm.plugin.qqmail.a.a.ihN.d(this.mController.xRr, intent);
                    finish();
                    return;
                } else if (this.hVl == 0 || this.pwb) {
                    this.retryCount = 0;
                    this.pwb = false;
                    blg();
                    ble();
                    return;
                }
            }
            this.mBM.setVisibility(8);
            this.ikq.setVisibility(0);
            this.pvW.setVisibility(8);
            this.mBH.setVisibility(0);
            this.mBJ.setVisibility(8);
            this.jQO.setVisibility(0);
            this.mBH.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AttachDownloadPage.g(AttachDownloadPage.this);
                }
            });
            if (this.hVl == 3) {
                this.ikq.setText(R.l.euj);
                this.jQO.setText(R.l.eug);
                this.jQO.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AttachDownloadPage.b(AttachDownloadPage.this, AttachDownloadPage.this.hr(false));
                    }
                });
                enableOptionMenu(true);
                return;
            }
            this.ikq.setText(R.l.euj);
            if (this.hVl == 2) {
                this.jQO.setText(R.l.eui);
            } else {
                this.jQO.setText(R.l.euh);
            }
            this.jQO.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AttachDownloadPage.this.retryCount = 0;
                    AttachDownloadPage.this.blg();
                    AttachDownloadPage.this.ble();
                }
            });
        } else if (this.pvY == 0) {
            this.mBM.setVisibility(8);
            this.mBH.setVisibility(8);
            this.mBJ.setVisibility(0);
            this.pvW.setVisibility(8);
            this.ikq.setVisibility(0);
            this.jQO.setVisibility(8);
            if (this.hVl == 3) {
                this.mBJ.setText(R.l.eue);
                enableOptionMenu(true);
            } else if (this.hVl == 2) {
                this.mBJ.setText(R.l.euk);
            } else {
                this.mBJ.setText(R.l.euc);
            }
            this.ikq.setText(R.l.eud);
            this.mBJ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (AttachDownloadPage.this.hVl == 3) {
                        AttachDownloadPage.b(AttachDownloadPage.this, AttachDownloadPage.this.hr(false));
                        return;
                    }
                    AttachDownloadPage.this.ble();
                    AttachDownloadPage.this.retryCount = 0;
                    AttachDownloadPage.this.blg();
                }
            });
        }
    }

    private void blg() {
        blj();
        if (this.hVl == 4) {
            if (this.retryCount < 5) {
                this.retryCount++;
                blg();
            } else {
                blf();
            }
        } else if (this.hVl == 3) {
            e.g(this.pvX, blh() + ".temp", blh());
            this.hVl = 3;
            blf();
        }
        Map hashMap = new HashMap();
        hashMap.put("mailid", this.ptN);
        hashMap.put("attachid", this.puB);
        hashMap.put("username", "");
        hashMap.put("offset", this.hVV);
        hashMap.put("datalen", this.fxb);
        hashMap.put("default_attach_name", blh() + ".temp");
        p.c cVar = new p.c();
        cVar.puT = false;
        cVar.puU = false;
        this.pvI = w.bkZ().a("/cgi-bin/mmdownload", hashMap, cVar, new p.a() {
            public final void onProgress(int i) {
                x.d("MicroMsg.AttachDownloadPage", "download progress : " + i);
                AttachDownloadPage.j(AttachDownloadPage.this);
                AttachDownloadPage.this.hVl = 1;
            }

            public final void onSuccess(String str, Map<String, String> map) {
                e.g(AttachDownloadPage.this.pvX, AttachDownloadPage.this.blh() + ".temp", AttachDownloadPage.this.blh());
                AttachDownloadPage.this.hVl = 3;
                Toast.makeText(AttachDownloadPage.this, AttachDownloadPage.this.getString(R.l.dZu) + " : " + AttachDownloadPage.this.hr(false), 5000).show();
                AttachDownloadPage.this.blf();
            }

            public final void onError(int i, String str) {
                AttachDownloadPage.this.hVl = 4;
                if (AttachDownloadPage.this.retryCount < 5) {
                    AttachDownloadPage.this.retryCount = AttachDownloadPage.this.retryCount + 1;
                    AttachDownloadPage.this.blg();
                    return;
                }
                AttachDownloadPage.this.blf();
            }

            public final void onComplete() {
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.tencent.mm.pluginsdk.ui.tools.a.a(this, i, i2, intent, true, R.l.dZp, R.l.dZq, 3);
    }

    private String blh() {
        String substring;
        int hashCode = this.puB.hashCode() & 65535;
        int lastIndexOf = this.pwa.lastIndexOf(".");
        String str = "";
        if (lastIndexOf != -1) {
            substring = this.pwa.substring(0, lastIndexOf);
            str = this.pwa.substring(lastIndexOf, this.pwa.length());
        } else {
            substring = this.pwa;
        }
        return String.format("%s_%d%s", new Object[]{substring, Integer.valueOf(hashCode), str});
    }

    private String hr(boolean z) {
        return this.pvX + blh() + (!z ? "" : ".temp");
    }

    private String bli() {
        return this.pvX + this.pwa;
    }

    private void blj() {
        if (e.bO(hr(true))) {
            this.hVV = (long) e.bN(hr(true));
            this.hVl = 2;
        } else if (e.bO(hr(false))) {
            this.hVl = 3;
        } else if (!e.bO(bli())) {
            this.hVV = 0;
            this.hVl = 0;
        } else if (((long) e.bN(bli())) == this.fxb) {
            e.g(this.pvX, this.pwa, blh());
            this.hVl = 3;
        } else if (((long) e.bN(bli())) > this.fxb) {
            com.tencent.mm.loader.stub.b.deleteFile(bli());
            this.hVV = 0;
            this.hVl = 4;
        } else {
            this.hVV = 0;
            this.hVl = 0;
        }
    }
}
