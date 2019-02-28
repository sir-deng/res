package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.ac.b;
import com.tencent.mm.ac.e;
import com.tencent.mm.f.a.rl;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.pluginsdk.ui.GetHdHeadImageGalleryView;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.y.ar;
import com.tencent.mm.y.as;
import com.tencent.mm.y.q;

public class PreviewHdHeadImg extends MMActivity {
    private GetHdHeadImageGalleryView ops;
    private final int qnr = 1;
    private final int qns = 2;
    private e qnt;
    private String qnu;
    private String username;

    static /* synthetic */ void b(PreviewHdHeadImg previewHdHeadImg) {
        String str = com.tencent.mm.compatible.util.e.gJf + "hdImg_" + g.s(previewHdHeadImg.username.getBytes()) + System.currentTimeMillis() + ".jpg";
        FileOp.deleteFile(str);
        FileOp.x(previewHdHeadImg.qnu, str);
        d.b(str, previewHdHeadImg.mController.xRr);
        Toast.makeText(previewHdHeadImg.mController.xRr, previewHdHeadImg.mController.xRr.getString(R.l.enM, new Object[]{com.tencent.mm.compatible.util.e.gJf}), 1).show();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected final int getLayoutId() {
        return R.i.dlA;
    }

    protected final void initView() {
        setMMTitle(R.l.eLk);
        this.username = q.FY();
        this.ops = (GetHdHeadImageGalleryView) findViewById(R.h.ckv);
        this.ops.username = this.username;
        bre();
        addIconOptionMenu(0, R.g.bDJ, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(PreviewHdHeadImg.this, com.tencent.mm.ui.widget.g.zCt, false);
                gVar.rQF = new c() {
                    public final void a(n nVar) {
                        nVar.eT(1, R.l.eLl);
                        if (b.a(PreviewHdHeadImg.this.username, true, -1) != null) {
                            nVar.eT(2, R.l.enL);
                        }
                    }
                };
                gVar.rQG = new p.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 1:
                                a.ihO.d(PreviewHdHeadImg.this);
                                return;
                            case 2:
                                PreviewHdHeadImg.b(PreviewHdHeadImg.this);
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
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                PreviewHdHeadImg.this.finish();
                return true;
            }
        });
    }

    private void bre() {
        as.Hm();
        if (com.tencent.mm.y.c.isSDCardAvailable()) {
            Bitmap a = b.a(this.username, true, -1);
            if (a == null) {
                a = BitmapFactory.decodeResource(getResources(), R.g.bBC);
            }
            if (a == null || a.isRecycled()) {
                x.i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is not in the cache, use default avatar", this.username);
            } else {
                x.i("MicroMsg.PreviewHdHeadImg", "The avatar of %s is in the cache", this.username);
                this.ops.setThumbImage(a);
            }
            com.tencent.mm.ac.n.JF();
            Bitmap jh = com.tencent.mm.ac.d.jh(this.username);
            if (jh == null || jh.isRecycled()) {
                this.qnt = new e();
                this.qnt.a(this.username, new e.b() {
                    public final int ba(int i, int i2) {
                        PreviewHdHeadImg.this.qnt.JJ();
                        x.i("MicroMsg.PreviewHdHeadImg", "onSceneEnd: errType=%d, errCode=%d", Integer.valueOf(i), Integer.valueOf(i2));
                        if (i == 0 && i2 == 0) {
                            com.tencent.mm.ac.n.JF();
                            Bitmap jh = com.tencent.mm.ac.d.jh(PreviewHdHeadImg.this.username);
                            if (jh != null) {
                                PreviewHdHeadImg previewHdHeadImg = PreviewHdHeadImg.this;
                                com.tencent.mm.ac.n.JF();
                                previewHdHeadImg.d(jh, com.tencent.mm.ac.d.x(PreviewHdHeadImg.this.username, true));
                            } else {
                                PreviewHdHeadImg.this.d(a, null);
                            }
                        } else {
                            PreviewHdHeadImg.this.d(a, null);
                        }
                        return 0;
                    }
                });
                return;
            }
            x.i("MicroMsg.PreviewHdHeadImg", "The HDAvatar of %s is already exists", this.username);
            com.tencent.mm.ac.n.JF();
            d(jh, com.tencent.mm.ac.d.x(this.username, true));
            return;
        }
        u.fJ(this.mController.xRr);
        d(com.tencent.mm.ac.n.JF().bg(this.mController.xRr), null);
    }

    private void d(Bitmap bitmap, String str) {
        if (bitmap != null) {
            try {
                Bitmap createBitmap;
                if (bitmap.getWidth() < 480) {
                    float width = 480.0f / ((float) bitmap.getWidth());
                    Matrix matrix = new Matrix();
                    matrix.postScale(width, width);
                    createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                } else {
                    createBitmap = bitmap;
                }
                x.d("MicroMsg.PreviewHdHeadImg", "dkhdbm old[%d %d] new[%d %d]", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(createBitmap.getWidth()), Integer.valueOf(createBitmap.getHeight()));
                this.ops.N(createBitmap);
                this.ops.qnu = str;
                this.qnu = str;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.PreviewHdHeadImg", e, "", new Object[0]);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.PreviewHdHeadImg", "onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i2 == -1) {
            switch (i) {
                case 2:
                    if (intent != null) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 1);
                        intent2.putExtra("CropImage_Filter", true);
                        com.tencent.mm.ac.n.JF();
                        intent2.putExtra("CropImage_OutputPath", com.tencent.mm.ac.d.x(q.FY() + ".crop", true));
                        intent2.putExtra("CropImage_ImgPath", null);
                        com.tencent.mm.pluginsdk.n nVar = com.tencent.mm.plugin.setting.a.ihN;
                        as.Hm();
                        nVar.a((Activity) this, intent, intent2, com.tencent.mm.y.c.Fp(), 4, null);
                        return;
                    }
                    return;
                case 4:
                    new ag(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            com.tencent.mm.sdk.b.b rlVar = new rl();
                            rlVar.fKc.fKe = true;
                            com.tencent.mm.sdk.b.a.xmy.m(rlVar);
                        }
                    });
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                        if (stringExtra == null) {
                            x.e("MicroMsg.PreviewHdHeadImg", "crop picture failed");
                            return;
                        } else {
                            new com.tencent.mm.pluginsdk.model.p(this.mController.xRr, stringExtra).c(1, new Runnable() {
                                public final void run() {
                                    x.d("MicroMsg.PreviewHdHeadImg", "updateHeadImg hasUin:%b user:%s", Boolean.valueOf(as.Hp()), q.FY());
                                    if (as.Hp()) {
                                        ar.hhz.hP(b.iZ(q.FY()));
                                    }
                                    PreviewHdHeadImg.this.bre();
                                }
                            });
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        } else if (i == 2 || i == 4) {
            new ag(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    com.tencent.mm.sdk.b.b rlVar = new rl();
                    rlVar.fKc.fKe = true;
                    com.tencent.mm.sdk.b.a.xmy.m(rlVar);
                }
            });
        }
    }
}
