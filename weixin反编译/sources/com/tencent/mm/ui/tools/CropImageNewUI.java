package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.chatting.ImageDownloadUI;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.tools.CropImageView.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.lang.reflect.Array;
import junit.framework.Assert;

public class CropImageNewUI extends MMActivity {
    private String filePath;
    private int kKY = 0;
    private final int zqd = 1;
    private final int zqe = 0;
    private int zqf;
    private int zqg = 0;
    private FilterImageView zqh;
    private LinearLayout zqi;
    private CropImageView zqj;
    private ImageView zqk;
    private View zql;
    private int zqm = 0;
    private boolean zqn = false;
    private boolean zqo = false;
    private boolean zqp = false;

    static /* synthetic */ void a(CropImageNewUI cropImageNewUI, CropImageView cropImageView, View view) {
        x.d("MicroMsg.CropImageUI", "doCropImage" + cropImageNewUI.zqp);
        if (cropImageView != null && view != null) {
            if (cropImageNewUI.zqp) {
                x.d("MicroMsg.CropImageUI", "isCroping");
                return;
            }
            cropImageNewUI.zqp = true;
            Bitmap createBitmap = d.createBitmap(cropImageView.mZu.getWidth(), cropImageView.mZu.getHeight(), Config.ARGB_8888);
            if (createBitmap == null) {
                cropImageNewUI.setResult(-1);
                cropImageNewUI.finish();
                return;
            }
            Canvas canvas = new Canvas(createBitmap);
            canvas.translate((float) cropImageView.getScrollX(), (float) cropImageView.getScrollY());
            cropImageView.draw(canvas);
            float[] fArr = new float[9];
            cropImageView.getImageMatrix().getValues(fArr);
            int left = view.getLeft();
            int top = view.getTop();
            int width = view.getWidth();
            Math.abs(fArr[0] != 0.0f ? fArr[0] : fArr[1]);
            float[][] b = n.b(b(cropImageView.getImageMatrix()));
            try {
                createBitmap = cropImageNewUI.kKY == 1 ? a(b, (float) left, (float) (((int) (((double) width) * 0.125d)) + top), (float) (left + width), (float) ((top + width) - ((int) (((double) width) * 0.125d))), cropImageView) : a(b, (float) left, (float) top, (float) (left + width), (float) (top + width), cropImageView);
            } catch (Throwable th) {
                createBitmap = null;
            }
            if (createBitmap == null) {
                x.e("MicroMsg.CropImageUI", "doCropImage: error");
            } else {
                x.d("MicroMsg.CropImageUI", "bm w: " + createBitmap.getWidth() + " " + createBitmap.getHeight());
                if (cropImageNewUI.kKY != 1) {
                    int width2 = createBitmap.getWidth();
                    int height = createBitmap.getHeight();
                    if (width2 != height) {
                        createBitmap = width2 > height ? Bitmap.createBitmap(createBitmap, (width2 - height) / 2, 0, height, height) : Bitmap.createBitmap(createBitmap, 0, (height - width2) / 2, width2, width2);
                    }
                }
                String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_OutputPath");
                if (stringExtra == null) {
                    stringExtra = e.gJf + g.s((cropImageNewUI.filePath + System.currentTimeMillis()).getBytes()) + "_crop.jpg";
                }
                if (cropImageNewUI.a(createBitmap, stringExtra, true)) {
                    Intent intent = new Intent();
                    intent.putExtra("CropImage_OutputPath", stringExtra);
                    if (cropImageNewUI.zqh != null) {
                        intent.putExtra("CropImage_filterId", cropImageNewUI.zqh.qWY);
                    }
                    cropImageNewUI.setResult(-1, intent);
                    cropImageNewUI.finish();
                }
            }
            cropImageNewUI.setResult(-1);
            cropImageNewUI.finish();
        }
    }

    static /* synthetic */ void a(CropImageNewUI cropImageNewUI, boolean z) {
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_OutputPath");
        if (t.oN(stringExtra)) {
            stringExtra = cropImageNewUI.filePath;
        } else {
            byte[] d = FileOp.d(cropImageNewUI.filePath, 0, -1);
            FileOp.b(stringExtra, d, d.length);
        }
        Intent intent = new Intent();
        intent.putExtra("CropImage_Compress_Img", z);
        intent.putExtra("CropImage_OutputPath", stringExtra);
        intent.putExtra("CropImage_rotateCount", cropImageNewUI.zqj.fzM % 4);
        if (cropImageNewUI.zqh != null) {
            intent.putExtra("CropImage_filterId", cropImageNewUI.zqh.qWY);
        }
        intent.putExtra("from_source", cropImageNewUI.getIntent().getIntExtra("from_source", 0));
        cropImageNewUI.setResult(-1, intent);
        cropImageNewUI.finish();
    }

    static /* synthetic */ void d(CropImageNewUI cropImageNewUI) {
        if (cropImageNewUI.zqh.zrk == null) {
            cropImageNewUI.zqh.dw(cropImageNewUI.filePath, cropImageNewUI.zqm);
        }
        cropImageNewUI.zqi.setVisibility(8);
        cropImageNewUI.zqh.setVisibility(0);
        cropImageNewUI.zqk.setTag(Integer.valueOf(cropImageNewUI.zqk.getVisibility()));
        cropImageNewUI.zqk.setVisibility(8);
        cropImageNewUI.zqj.setVisibility(8);
    }

    static /* synthetic */ void g(CropImageNewUI cropImageNewUI) {
        cropImageNewUI.zqh.dw(cropImageNewUI.filePath, cropImageNewUI.zqm);
        cropImageNewUI.zqi.setVisibility(8);
        cropImageNewUI.zqh.setVisibility(0);
        cropImageNewUI.zqk.setTag(Integer.valueOf(cropImageNewUI.zqk.getVisibility()));
        cropImageNewUI.zqk.setVisibility(8);
        cropImageNewUI.zqj.setVisibility(8);
        cropImageNewUI.zqh.findViewById(R.h.bZR).setVisibility(4);
    }

    static /* synthetic */ void h(CropImageNewUI cropImageNewUI) {
        x.d("MicroMsg.CropImageUI", "doShowOrNot");
        if (cropImageNewUI.zqi.getVisibility() == 0) {
            cropImageNewUI.zqi.setVisibility(4);
        } else if (cropImageNewUI.zqi.getVisibility() == 4) {
            cropImageNewUI.zqi.setVisibility(0);
        }
    }

    static /* synthetic */ void k(CropImageNewUI cropImageNewUI) {
        int[] cyy = cropImageNewUI.cyy();
        Bitmap fi = cropImageNewUI.fi(cyy[2], cyy[3]);
        Bitmap fi2 = cropImageNewUI.fi(cyy[0], cyy[1]);
        if (cropImageNewUI.zqm != 0) {
            Bitmap bitmap = fi;
            fi = fi2;
            fi2 = bitmap;
        }
        x.d("MicroMsg.CropImageUI", "docrop degree:" + cropImageNewUI.zqm);
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_bg_vertical");
        String stringExtra2 = cropImageNewUI.getIntent().getStringExtra("CropImage_bg_horizontal");
        if (cropImageNewUI.a(fi, stringExtra, true) && cropImageNewUI.a(fi2, stringExtra2, true)) {
            Intent intent = new Intent();
            intent.putExtra("CropImage_bg_vertical", stringExtra);
            intent.putExtra("CropImage_bg_horizontal", stringExtra2);
            if (cropImageNewUI.zqh != null) {
                intent.putExtra("CropImage_filterId", cropImageNewUI.zqh.qWY);
            }
            cropImageNewUI.setResult(-1, intent);
        } else {
            cropImageNewUI.setResult(-1);
        }
        cropImageNewUI.finish();
    }

    static /* synthetic */ void l(CropImageNewUI cropImageNewUI) {
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_OutputPath");
        String str = null;
        Intent intent = new Intent();
        if (cropImageNewUI.zqg == 0) {
            try {
                String s = g.s((System.currentTimeMillis()).getBytes());
                d.a(cropImageNewUI.zqj.mZu, 100, CompressFormat.PNG, stringExtra + s, false);
                str = g.s(FileOp.d(stringExtra + s, 0, (int) FileOp.mi(stringExtra + s)));
                if (com.tencent.mm.a.e.bO(stringExtra + str)) {
                    x.i("MicroMsg.CropImageUI", "file is exist. need no to copy!");
                    b.deleteFile(stringExtra + s);
                } else {
                    FileOp.g(stringExtra, s, str);
                }
                intent.putExtra("emoji_type", 0);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CropImageUI", e, "", new Object[0]);
                cropImageNewUI.setResult(-2);
            }
        } else if (cropImageNewUI.zqg == 1) {
            byte[] d = FileOp.d(cropImageNewUI.filePath, 0, -1);
            str = g.s(d);
            if (com.tencent.mm.a.e.bO(stringExtra + str)) {
                x.i("MicroMsg.CropImageUI", "file is exist. need no to copy!");
            } else {
                FileOp.b(stringExtra + str, d, d.length);
            }
            intent.putExtra("emoji_type", 1);
        }
        intent.putExtra("CropImage_OutputPath", stringExtra + str);
        if (cropImageNewUI.zqh != null) {
            intent.putExtra("CropImage_filterId", cropImageNewUI.zqh.qWY);
        }
        cropImageNewUI.setResult(-1, intent);
        cropImageNewUI.finish();
    }

    static /* synthetic */ void m(CropImageNewUI cropImageNewUI) {
        String[] strArr = (cropImageNewUI.zqn || cropImageNewUI.zqo) ? new String[]{cropImageNewUI.getString(R.l.dYc)} : new String[]{cropImageNewUI.getString(R.l.dYc)};
        h.a((Context) cropImageNewUI, "", strArr, "", false, new c() {
            public final void jo(int i) {
                switch (i) {
                    case 0:
                        CropImageNewUI.u(CropImageNewUI.this);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    static /* synthetic */ void n(CropImageNewUI cropImageNewUI) {
        Context context = cropImageNewUI;
        h.a(context, "", new String[]{cropImageNewUI.getString(R.l.eET), cropImageNewUI.getString(R.l.eHt)}, "", false, new c() {
            public final void jo(int i) {
                switch (i) {
                    case 0:
                        CropImageNewUI.s(CropImageNewUI.this);
                        return;
                    case 1:
                        k.h(CropImageNewUI.this.getIntent().getStringExtra("CropImage_ImgPath"), CropImageNewUI.this);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    static /* synthetic */ void r(CropImageNewUI cropImageNewUI) {
        long longExtra = cropImageNewUI.getIntent().getLongExtra("CropImage_Msg_Id", 0);
        long longExtra2 = cropImageNewUI.getIntent().getLongExtra("CropImage_Msg_Svr_Id", 0);
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_Username");
        Intent intent = new Intent(cropImageNewUI, ImageDownloadUI.class);
        intent.putExtra("img_msg_id", longExtra);
        intent.putExtra("img_server_id", longExtra2);
        intent.putExtra("img_download_compress_type", 1);
        intent.putExtra("img_download_username", stringExtra);
        cropImageNewUI.startActivity(intent);
    }

    static /* synthetic */ void s(CropImageNewUI cropImageNewUI) {
        String stringExtra = cropImageNewUI.getIntent().getStringExtra("CropImage_ImgPath");
        int intExtra = cropImageNewUI.getIntent().getIntExtra("CropImage_CompressType", 0);
        int intExtra2 = cropImageNewUI.getIntent().getIntExtra("CropImage_Msg_Id", -1);
        Intent intent = new Intent(cropImageNewUI, MsgRetransmitUI.class);
        intent.putExtra("Retr_File_Name", stringExtra);
        intent.putExtra("Retr_Msg_Id", intExtra2);
        intent.putExtra("Retr_Msg_Type", 0);
        intent.putExtra("Retr_Compress_Type", intExtra);
        cropImageNewUI.startActivity(intent);
    }

    static /* synthetic */ void u(CropImageNewUI cropImageNewUI) {
        long mi = FileOp.mi(cropImageNewUI.filePath) / 1024;
        h.a((Context) cropImageNewUI, cropImageNewUI.getString(R.l.dYa, new Object[]{Long.toString(mi)}), cropImageNewUI.getString(R.l.dGZ), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                CropImageNewUI.a(CropImageNewUI.this, false);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.dft;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        initView();
    }

    public void onResume() {
        super.onResume();
        setRequestedOrientation(1);
    }

    public void onDestroy() {
        if (this.zqj != null) {
            CropImageView cropImageView = this.zqj;
            if (!(cropImageView.mZu == null || cropImageView.mZu.isRecycled())) {
                x.i("MicroMsg.CropImageView", "recycle bitmap:%s", cropImageView.mZu.toString());
                cropImageView.mZu.recycle();
            }
        }
        if (this.zqh != null) {
            FilterImageView filterImageView = this.zqh;
            filterImageView.zrg = null;
            if (!(filterImageView.zrk == null || filterImageView.zrk.isRecycled())) {
                x.i("MicroMsg.FilterView", "recycle bitmap:%s", filterImageView.zrk.toString());
                filterImageView.zrk.recycle();
            }
            filterImageView.zrk = null;
        }
        super.onDestroy();
        x.appenderClose();
        Process.killProcess(Process.myPid());
    }

    protected final void initView() {
        setMMTitle("");
        this.zqi = (LinearLayout) findViewById(R.h.cab);
        this.zqk = (ImageView) findViewById(R.h.caa);
        com.tencent.mm.platformtools.e.bC(this.zqk);
        this.zql = findViewById(R.h.bZU);
        this.zqf = getIntent().getIntExtra("CropImageMode", 0);
        Assert.assertTrue("the image mode must be set", this.zqf != 0);
        this.kKY = getIntent().getIntExtra("CropImage_from_scene", 0);
        final boolean booleanExtra = getIntent().getBooleanExtra("CropImage_Filter", false);
        final boolean booleanExtra2 = getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false);
        if (booleanExtra) {
            b(new Runnable() {
                public final void run() {
                    boolean z = false;
                    if (CropImageNewUI.this.zqh != null) {
                        if (CropImageNewUI.this.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
                            Editor edit = CropImageNewUI.this.getSharedPreferences(ad.cgf(), 0).edit();
                            String str = "CropImage_Filter_Show";
                            if (CropImageNewUI.this.zqh.findViewById(R.h.bZR).getVisibility() == 0) {
                                z = true;
                            }
                            edit.putBoolean(str, z);
                            edit.commit();
                        }
                        String stringExtra = CropImageNewUI.this.getIntent().getStringExtra("CropImage_OutputPath");
                        if (stringExtra == null) {
                            stringExtra = e.gJf + g.s((CropImageNewUI.this.filePath + System.currentTimeMillis()).getBytes()) + "_fiter.jpg";
                        }
                        Intent intent = new Intent();
                        intent.putExtra("CropImage_Compress_Img", true);
                        if (CropImageNewUI.this.zqh != null) {
                            intent.putExtra("CropImage_filterId", CropImageNewUI.this.zqh.qWY);
                        }
                        if (CropImageNewUI.this.zqh.qWY == 0) {
                            intent.putExtra("CropImage_OutputPath", CropImageNewUI.this.filePath);
                            CropImageNewUI.this.setResult(-1, intent);
                        } else if (CropImageNewUI.this.a(CropImageNewUI.this.zqh.zrk, stringExtra, false)) {
                            intent.putExtra("CropImage_OutputPath", stringExtra);
                            CropImageNewUI.this.setResult(-1, intent);
                        } else {
                            CropImageNewUI.this.setResult(-1);
                        }
                        CropImageNewUI.this.finish();
                    }
                }
            }, new Runnable() {
                public final void run() {
                    if (CropImageNewUI.this.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
                        CropImageNewUI.this.finish();
                        return;
                    }
                    CropImageNewUI.this.zqh.setVisibility(8);
                    CropImageNewUI.this.zqi.setVisibility(0);
                    CropImageNewUI.this.zqk.setVisibility(((Integer) CropImageNewUI.this.zqk.getTag()).intValue());
                    CropImageNewUI.this.zqj.setVisibility(0);
                }
            });
        }
        this.zqp = false;
        this.zqj = (CropImageView) findViewById(R.h.cac);
        com.tencent.mm.platformtools.e.bC(this.zqj);
        this.zqj.post(new Runnable() {
            public final void run() {
                if (!CropImageNewUI.this.cyx()) {
                    return;
                }
                if (!CropImageNewUI.this.zqn && !CropImageNewUI.this.zqo && CropImageNewUI.this.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
                    CropImageNewUI.d(CropImageNewUI.this);
                    if (!CropImageNewUI.this.getSharedPreferences(ad.cgf(), 0).getBoolean("CropImage_Filter_Show", true)) {
                        CropImageNewUI.this.zqh.findViewById(R.h.bZR).setVisibility(4);
                    }
                } else if (1 == CropImageNewUI.this.zqf) {
                    CropImageNewUI.g(CropImageNewUI.this);
                }
            }
        });
        this.zqj.zqS = new a() {
            public final void cyz() {
                CropImageNewUI.h(CropImageNewUI.this);
            }
        };
        ((Button) findViewById(R.h.cad)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CropImageView j = CropImageNewUI.this.zqj;
                if (j.mZu == null) {
                    x.w("MicroMsg.CropImageView", "rotate not done! cause: btmp is null!");
                    return;
                }
                float[] fArr = new float[]{(float) (j.mZu.getWidth() / 2), (float) (j.mZu.getHeight() / 2)};
                j.getImageMatrix().mapPoints(fArr);
                j.getImageMatrix().postRotate(90.0f, fArr[0], fArr[1]);
                j.setImageBitmap(j.mZu);
                j.invalidate();
                j.fzM++;
            }
        });
        Button button = (Button) findViewById(R.h.cae);
        button.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CropImageNewUI.this.zqj.cyB();
            }
        });
        Button button2 = (Button) findViewById(R.h.caf);
        button2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CropImageNewUI.this.zqj.cyC();
            }
        });
        final al alVar = new al(new al.a() {
            public final boolean uG() {
                CropImageNewUI.this.zqj.cyB();
                return true;
            }
        }, true);
        final al alVar2 = new al(new al.a() {
            public final boolean uG() {
                CropImageNewUI.this.zqj.cyC();
                return true;
            }
        }, true);
        button.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        alVar.K(200, 200);
                        break;
                    case 1:
                        alVar.TN();
                        break;
                }
                return false;
            }
        });
        button2.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        alVar2.K(200, 200);
                        break;
                    case 1:
                        alVar2.TN();
                        break;
                }
                return false;
            }
        });
        int i = R.l.dYd;
        switch (this.zqf) {
            case 1:
                b(new Runnable() {
                    public final void run() {
                        CropImageNewUI.a(CropImageNewUI.this, CropImageNewUI.this.zqh.zrj, CropImageNewUI.this.zqh.zrh);
                        CropImageNewUI.this.finish();
                    }
                }, new Runnable() {
                    public final void run() {
                        CropImageNewUI.this.finish();
                    }
                });
                FilterImageView filterImageView = this.zqh;
                if (filterImageView.zrj != null) {
                    filterImageView.zrj.zqw = false;
                }
                filterImageView = this.zqh;
                if (filterImageView.zrj != null) {
                    filterImageView.zrj.setScaleType(ScaleType.MATRIX);
                    filterImageView.zrj.cyA();
                }
                filterImageView = this.zqh;
                if (filterImageView.zri != null) {
                    filterImageView.zri.setVisibility(0);
                }
                if (this.kKY == 1) {
                    filterImageView = this.zqh;
                    int i2 = R.g.bEh;
                    if (filterImageView.zri != null) {
                        filterImageView.zri.setBackgroundResource(i2);
                        break;
                    }
                }
                break;
            case 2:
                this.zqj.zqT = false;
                findViewById(R.h.bZQ).setVisibility(8);
                findViewById(R.h.bZW).setVisibility(8);
                break;
            case 3:
                this.zqi.setVisibility(8);
                break;
            case 5:
                int intExtra = getIntent().getIntExtra("CropImage_CompressType", 1);
                boolean booleanExtra3 = getIntent().getBooleanExtra("CropImage_BHasHD", false);
                if (intExtra != 1 && booleanExtra3) {
                    findViewById(R.h.bZW).setVisibility(0);
                    button = (Button) findViewById(R.h.bZX);
                    button.setBackgroundResource(R.g.bAg);
                    button.setPadding(25, 8, 25, 8);
                    button.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            CropImageNewUI.r(CropImageNewUI.this);
                        }
                    });
                    break;
                }
                findViewById(R.h.bZW).setVisibility(8);
                break;
                break;
        }
        x.d("MicroMsg.CropImageUI", "mode is  " + this.zqf);
        OnMenuItemClickListener anonymousClass17 = new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (!booleanExtra || !booleanExtra2) {
                    switch (CropImageNewUI.this.zqf) {
                        case 1:
                            if (CropImageNewUI.this.zqh == null) {
                                CropImageNewUI.a(CropImageNewUI.this, CropImageNewUI.this.zqj, CropImageNewUI.this.zql);
                                break;
                            }
                            CropImageNewUI.a(CropImageNewUI.this, CropImageNewUI.this.zqh.zrj, CropImageNewUI.this.zql);
                            break;
                        case 2:
                            CropImageNewUI.k(CropImageNewUI.this);
                            break;
                        case 3:
                            CropImageNewUI.l(CropImageNewUI.this);
                            break;
                        case 4:
                            CropImageNewUI.m(CropImageNewUI.this);
                            break;
                        case 5:
                            CropImageNewUI.n(CropImageNewUI.this);
                            break;
                    }
                }
                CropImageNewUI.a(CropImageNewUI.this, true);
                return true;
            }
        };
        if (this.zqf == 5) {
            addIconOptionMenu(0, R.g.bDJ, anonymousClass17);
        } else if (this.zqf == 4) {
            addIconOptionMenu(0, R.g.bDJ, anonymousClass17);
            findViewById(R.h.bZW).setVisibility(0);
            button = (Button) findViewById(R.h.bZX);
            button.setText(R.l.dXZ);
            button.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    CropImageNewUI.a(CropImageNewUI.this, true);
                }
            });
        } else {
            a(0, getString(i), anonymousClass17, p.b.xSe);
        }
        if (booleanExtra && booleanExtra2) {
            a(0, getString(R.l.dXZ), anonymousClass17, p.b.xSe);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                CropImageNewUI.this.finish();
                return true;
            }
        });
        if (this.zqf == 6) {
            findViewById(R.h.bZW).setVisibility(8);
            a(0, getString(R.l.dYd), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(CropImageNewUI.this, com.tencent.mm.ui.widget.g.zCt, false);
                    gVar.rQF = new com.tencent.mm.ui.base.p.c() {
                        public final void a(n nVar) {
                            nVar.eT(0, R.l.dYg);
                            nVar.eT(1, R.l.dYk);
                        }
                    };
                    gVar.rQG = new com.tencent.mm.ui.base.p.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            Intent intent;
                            switch (menuItem.getItemId()) {
                                case 0:
                                    intent = new Intent();
                                    intent.putExtra("CropImage_OutputPath", CropImageNewUI.this.getIntent().getStringExtra("CropImage_OutputPath"));
                                    intent.putExtra("OP_CODE", 1);
                                    CropImageNewUI.this.setResult(-1, intent);
                                    CropImageNewUI.this.finish();
                                    return;
                                case 1:
                                    intent = new Intent();
                                    intent.putExtra("CropImage_OutputPath", CropImageNewUI.this.getIntent().getStringExtra("CropImage_OutputPath"));
                                    intent.putExtra("OP_CODE", 2);
                                    CropImageNewUI.this.setResult(-1, intent);
                                    CropImageNewUI.this.finish();
                                    return;
                                default:
                                    return;
                            }
                        }
                    };
                    gVar.bUX();
                    return true;
                }
            }, p.b.xSe);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        x.d("MicroMsg.CropImageUI", "onConfigurationChanged, config.orientation = " + configuration.orientation);
        if (configuration.orientation == 1 || configuration.orientation == 2) {
            x.v("MicroMsg.CropImageUI", "onConfigurationChanged");
            this.zqj.post(new Runnable() {
                public final void run() {
                    CropImageNewUI.this.cyx();
                }
            });
        }
        super.onConfigurationChanged(configuration);
    }

    private boolean cyx() {
        View findViewById;
        if (1 != this.zqf) {
            findViewById = findViewById(R.h.bZT);
        } else if (this.zqh != null) {
            findViewById = this.zqh.zrh;
        } else {
            findViewById = findViewById(R.h.bZU);
        }
        int width = findViewById.getWidth();
        int height = findViewById.getHeight();
        x.v("MicroMsg.CropImageUI", "scrWidth:" + width + " scrHeight:" + height);
        this.filePath = getIntent().getStringExtra("CropImage_ImgPath");
        if (FileOp.bO(this.filePath)) {
            boolean z;
            int i;
            Bitmap decodeFile;
            int i2;
            float f;
            int i3 = 960;
            int i4 = 960;
            if (this.zqf == 2) {
                z = true;
                i3 = height;
                i = width;
            } else if (this.zqf == 3) {
                Options options = new Options();
                options.inJustDecodeBounds = true;
                decodeFile = BitmapFactory.decodeFile(this.filePath, options);
                if (decodeFile != null) {
                    decodeFile.recycle();
                }
                int i5 = options.outWidth;
                i2 = options.outHeight;
                f = 1.0f;
                if (i5 <= 640 && i2 <= 640) {
                    i3 = i2;
                    i = i5;
                } else if (i5 > i2) {
                    f = ((float) i2) / ((float) i5);
                    i = 640;
                    i3 = (int) (((float) i2) * f);
                } else {
                    f = ((float) i5) / ((float) i2);
                    i3 = 640;
                    i = (int) (960.0f * f);
                }
                x.d("MicroMsg.CropImageUI", "w:%d h:%d width:%d height:%d scale:%f", Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(i3), Float.valueOf(f));
                Button button = (Button) findViewById(R.h.bZX);
                if (button != null) {
                    button.setVisibility(8);
                }
                z = false;
            } else if (this.zqf == 1) {
                Options options2 = new Options();
                options2.inJustDecodeBounds = true;
                Bitmap decodeFile2 = BitmapFactory.decodeFile(this.filePath, options2);
                if (decodeFile2 != null) {
                    x.i("MicroMsg.CropImageUI", "recycle bitmap:%s", decodeFile2.toString());
                    decodeFile2.recycle();
                }
                if (options2.outWidth > options2.outHeight) {
                    i3 = (int) ((((double) (options2.outWidth * 960)) * 1.0d) / ((double) options2.outHeight));
                    if (i3 > 1920) {
                        i3 = 1920;
                    }
                } else {
                    i4 = (int) ((((double) (options2.outHeight * 960)) * 1.0d) / ((double) options2.outWidth));
                    if (i4 > 1920) {
                        i4 = 1920;
                    }
                }
                i = i3;
                i3 = i4;
                z = false;
            } else {
                Options options3 = new Options();
                options3.inJustDecodeBounds = true;
                d.c(options3);
                Bitmap decodeFile3 = BitmapFactory.decodeFile(this.filePath, options3);
                if (decodeFile3 != null) {
                    x.i("MicroMsg.CropImageUI", "recycle bitmap:%s", decodeFile3.toString());
                    decodeFile3.recycle();
                }
                boolean z2 = t.bt(options3.outWidth, options3.outHeight) && options3.outWidth > 480;
                this.zqn = z2;
                z2 = t.bs(options3.outWidth, options3.outHeight) && options3.outHeight > 480;
                this.zqo = z2;
                if (this.zqn || this.zqo) {
                    i4 = options3.outHeight;
                    i3 = options3.outWidth;
                }
                x.e("MicroMsg.CropImageUI", "width is " + i3 + " height is " + i4);
                i = i3;
                i3 = i4;
                z = false;
            }
            this.zqm = ExifHelper.Vo(this.filePath);
            if (this.zqm == 90 || this.zqm == 270) {
                int i6 = i;
                i = i3;
                i3 = i6;
            }
            decodeFile = d.d(this.filePath, i3, i, z);
            byte[] d = FileOp.d(this.filePath, 0, 10);
            if (com.tencent.mm.sdk.platformtools.p.bq(d)) {
                this.zqg = 1;
            } else {
                this.zqg = 0;
            }
            if (decodeFile == null) {
                finish();
                return false;
            }
            float height2;
            float f2;
            x.d("temBmp crop", "h:" + decodeFile.getHeight() + "w: " + decodeFile.getWidth());
            Bitmap b = d.b(decodeFile, (float) this.zqm);
            Matrix matrix = new Matrix();
            matrix.reset();
            float f3 = 1.0f;
            if (z) {
                f = ((float) b.getWidth()) / ((float) width);
                height2 = ((float) b.getHeight()) / ((float) height);
                f2 = f < height2 ? f : height2;
                f = width > height ? (float) height : (float) width;
                height2 = f / ((float) b.getWidth());
                f /= (float) b.getHeight();
                if (height2 > f) {
                    f = height2;
                }
                if (((double) f2) < 1.0d) {
                    matrix.postScale(f, f);
                }
            } else {
                f = ((float) b.getWidth()) / ((float) b.getHeight());
                f2 = ((float) b.getHeight()) / ((float) b.getWidth());
                x.v("MicroMsg.CropImageUI", "whDiv is " + f + " hwDiv is " + f2);
                if (f2 >= 2.0f && b.getHeight() >= 480) {
                    f2 = ((float) b.getWidth()) / ((float) width);
                    f = ((float) width) / ((float) b.getWidth());
                    if (1 == this.zqf) {
                        f2 = ((float) height) / ((float) b.getHeight());
                        if (f <= f2) {
                            f = f2;
                        }
                        matrix.postScale(f, f);
                        matrix.postTranslate(((((float) width) - (f * ((float) b.getWidth()))) / 2.0f) + ((float) findViewById.getLeft()), (float) findViewById.getTop());
                    } else if (((double) f2) > 1.0d) {
                        matrix.postScale(f, f);
                        b.getHeight();
                        matrix.postTranslate((((float) width) - (f * ((float) b.getWidth()))) / 2.0f, 0.0f);
                    } else {
                        matrix.postScale(1.0f, 1.0f);
                        if (3 == this.zqf) {
                            matrix.postTranslate((float) ((width - b.getWidth()) / 2), (float) ((height - b.getHeight()) / 2));
                        } else {
                            matrix.postTranslate((float) ((width - b.getWidth()) / 2), 0.0f);
                        }
                    }
                } else if (f < 2.0f || b.getWidth() < 480) {
                    f = ((float) width) / ((float) b.getWidth());
                    f2 = ((float) height) / ((float) b.getHeight());
                    float f4 = f < f2 ? f : f2;
                    if (f <= f2) {
                        f = f2;
                    }
                    if (1 == this.zqf) {
                        matrix.postScale(f, f);
                        matrix.postTranslate(((((float) width) - (((float) b.getWidth()) * f)) / 2.0f) + ((float) findViewById.getLeft()), ((((float) height) - (f * ((float) b.getHeight()))) / 2.0f) + ((float) findViewById.getTop()));
                    } else if (this.zqg == 1) {
                        CropImageView cropImageView = this.zqj;
                        String str = this.filePath;
                        try {
                            cropImageView.yod = true;
                            cropImageView.yoe = com.tencent.mm.ui.e.b.c.fV(str, str);
                            cropImageView.setImageDrawable(cropImageView.yoe);
                        } catch (Exception e) {
                            cropImageView.yod = false;
                        }
                        this.zqj.cyD();
                        this.zqj.cyE();
                        f = ((float) this.zqj.cyD()) / ((float) width);
                        height2 = ((float) this.zqj.cyE()) / ((float) height);
                        if (f <= height2) {
                            f = height2;
                        }
                        if (((double) f) > 1.0d) {
                            matrix.postScale(f, f);
                        } else {
                            f = 1.0f;
                        }
                        matrix.postTranslate((((float) width) - (((float) this.zqj.cyD()) * f)) / 2.0f, (((float) height) - (f * ((float) this.zqj.cyE()))) / 2.0f);
                    } else {
                        f = ((float) b.getWidth()) / ((float) width);
                        height2 = ((float) b.getHeight()) / ((float) height);
                        if (f <= height2) {
                            f = height2;
                        }
                        if (((double) f) > 1.0d) {
                            matrix.postScale(f4, f4);
                            f3 = f4;
                        }
                        matrix.postTranslate((((float) width) - (((float) b.getWidth()) * f3)) / 2.0f, (((float) height) - (((float) b.getHeight()) * f3)) / 2.0f);
                    }
                } else {
                    f = ((float) b.getHeight()) / 480.0f;
                    f2 = 480.0f / ((float) b.getHeight());
                    if (1 == this.zqf) {
                        f = ((float) width) / ((float) b.getWidth());
                        f2 = ((float) height) / ((float) b.getHeight());
                        if (f <= f2) {
                            f = f2;
                        }
                        matrix.postScale(f, f);
                        matrix.postTranslate(((((float) width) - (((float) b.getWidth()) * f)) / 2.0f) + ((float) findViewById.getLeft()), ((((float) height) - (f * ((float) b.getHeight()))) / 2.0f) + ((float) findViewById.getTop()));
                    } else if (((double) f) > 1.0d) {
                        matrix.postScale(f, f2);
                        matrix.postTranslate(0.0f, (float) ((height - 480) / 2));
                    } else {
                        matrix.postScale(1.0f, 1.0f);
                        f = (float) ((height - b.getHeight()) / 2);
                        x.d("MicroMsg.CropImageUI", " offsety " + f);
                        matrix.postTranslate(0.0f, f);
                    }
                }
            }
            if (1 == this.zqf) {
                if (this.zqh != null) {
                    FilterImageView filterImageView = this.zqh;
                    if (filterImageView.zrj != null) {
                        filterImageView.zrj.setImageMatrix(matrix);
                    }
                    this.zqh.zrk = b;
                }
            } else if (this.zqg != 1) {
                this.zqj.setImageMatrix(matrix);
                this.zqj.setImageBitmap(b);
            }
            if (this.zqf == 3) {
                if (com.tencent.mm.sdk.platformtools.p.bq(d)) {
                    this.zqg = 1;
                    try {
                        Drawable cW = com.tencent.mm.plugin.gif.b.aSR().cW(this.filePath, this.filePath);
                        this.zqj.setImageDrawable(cW);
                        cW.start();
                        matrix.reset();
                        i2 = cW.getIntrinsicWidth();
                        i = cW.getIntrinsicHeight();
                        f = ((float) width) / ((float) i2);
                        height2 = ((float) height) / ((float) i);
                        f2 = f < height2 ? f : height2;
                        f = ((float) i2) / ((float) width);
                        height2 = ((float) i) / ((float) height);
                        if (f <= height2) {
                            f = height2;
                        }
                        if (((double) f) > 1.0d) {
                            matrix.postScale(f2, f2);
                            matrix.postTranslate((((float) width) - (((float) i2) * f2)) / 2.0f, (((float) height) - (f2 * ((float) i))) / 2.0f);
                        } else {
                            matrix.postTranslate((float) ((width - i2) / 2), (float) ((height - i) / 2));
                        }
                        this.zqj.setImageMatrix(matrix);
                    } catch (Throwable e2) {
                        x.e("MicroMsg.CropImageUI", bi.i(e2));
                    }
                } else {
                    this.zqg = 0;
                }
                return true;
            }
            if (this.zqn || this.zqo) {
                findViewById(R.h.cad).setVisibility(8);
            }
            if (getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
                findViewById(R.h.bZW).setVisibility(8);
            }
            return true;
        }
        finish();
        return false;
    }

    private void b(Runnable runnable, Runnable runnable2) {
        this.zqh = (FilterImageView) findViewById(R.h.bZS);
        com.tencent.mm.platformtools.e.bC(this.zqh);
        this.zqh.zrn = runnable;
        this.zqh.zro = runnable2;
    }

    private int[] cyy() {
        int i;
        DisplayMetrics displayMetrics;
        int i2;
        int max;
        int i3;
        int i4;
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i5 = rect.top;
        x.e("MicroMsg.CropImageUI", "window TitleBar.h:" + i5);
        if (i5 == 0) {
            try {
                Class cls = Class.forName("com.android.internal.R$dimen");
                i5 = getResources().getDimensionPixelSize(t.getInt(cls.getField("status_bar_height").get(cls.newInstance()).toString(), 0));
                x.e("MicroMsg.CropImageUI", "sbar:" + i5);
                i = i5;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CropImageUI", e, "", new Object[0]);
            }
            displayMetrics = new DisplayMetrics();
            ((WindowManager) getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            i2 = (int) (((double) (67.0f * displayMetrics.density)) / 1.5d);
            i5 = Math.min(this.zql.getWidth(), this.zql.getHeight());
            max = Math.max(this.zql.getWidth(), this.zql.getHeight());
            i3 = max - (i2 * 2);
            i4 = (max + i) + i2;
            max = (i5 - (i2 * 2)) - i;
            if (this.zqm != 0) {
                i5 += i + (i2 * 2);
                i = max + i2;
            } else {
                i = max;
            }
            return new int[]{i5, i3, i, i4};
        }
        i = i5;
        displayMetrics = new DisplayMetrics();
        ((WindowManager) getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        i2 = (int) (((double) (67.0f * displayMetrics.density)) / 1.5d);
        i5 = Math.min(this.zql.getWidth(), this.zql.getHeight());
        max = Math.max(this.zql.getWidth(), this.zql.getHeight());
        i3 = max - (i2 * 2);
        i4 = (max + i) + i2;
        max = (i5 - (i2 * 2)) - i;
        if (this.zqm != 0) {
            i = max;
        } else {
            i5 += i + (i2 * 2);
            i = max + i2;
        }
        return new int[]{i5, i3, i, i4};
    }

    private Bitmap fi(int i, int i2) {
        Bitmap d = d.d(this.filePath, i2, i, true);
        if (this.zqm != 0) {
            Matrix matrix = new Matrix();
            matrix.reset();
            matrix.setRotate((float) this.zqm, (float) (d.getWidth() / 2), (float) (d.getHeight() / 2));
            Bitmap createBitmap = Bitmap.createBitmap(d, 0, 0, d.getWidth(), d.getHeight(), matrix, true);
            if (d != createBitmap) {
                x.i("MicroMsg.CropImageUI", "recycle bitmap:%s", d.toString());
                d.recycle();
            }
            d = createBitmap;
        }
        x.d("MicroMsg.CropImageUI", "getcrop degree:" + this.zqm);
        return d;
    }

    private static Bitmap a(float[][] fArr, float f, float f2, float f3, float f4, CropImageView cropImageView) {
        if (cropImageView == null) {
            return null;
        }
        float[] fArr2 = new float[]{f3, f4, 1.0f};
        float[] a = n.a(fArr, new float[]{f, f2, 1.0f});
        float[] a2 = n.a(fArr, fArr2);
        int min = (int) Math.min(a[0], a2[0]);
        int min2 = (int) Math.min(a[1], a2[1]);
        if (min < 0) {
            min = 0;
        }
        if (min2 < 0) {
            min2 = 0;
        }
        int abs = (int) Math.abs(a[0] - a2[0]);
        int abs2 = (int) Math.abs(a[1] - a2[1]);
        Matrix matrix = new Matrix();
        switch (cropImageView.fzM % 4) {
            case 0:
                matrix.setRotate(0.0f, (float) (abs / 2), (float) (abs2 / 2));
                break;
            case 1:
                matrix.setRotate(90.0f, (float) (abs / 2), (float) (abs2 / 2));
                break;
            case 2:
                matrix.setRotate(180.0f, (float) (abs / 2), (float) (abs2 / 2));
                break;
            case 3:
                matrix.setRotate(270.0f, (float) (abs / 2), (float) (abs2 / 2));
                break;
        }
        Bitmap bitmap = cropImageView.mZu;
        if (min + abs > bitmap.getWidth()) {
            abs = bitmap.getWidth() - min;
        }
        if (min2 + abs2 > bitmap.getHeight()) {
            abs2 = bitmap.getHeight() - min2;
        }
        x.i("MicroMsg.CropImageUI", "rawWidth:%d, rawHeigth:%d, originalLX:%d, originalTY:%d, realWidth:%d, realHeight:%d", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(min), Integer.valueOf(min2), Integer.valueOf(abs), Integer.valueOf(abs2));
        return Bitmap.createBitmap(bitmap, min, min2, abs, abs2, matrix, true);
    }

    private boolean a(Bitmap bitmap, String str, boolean z) {
        if (!(str == null || str.equals(""))) {
            try {
                if (this.kKY == 1) {
                    d.a(bitmap, 30, CompressFormat.JPEG, str, z);
                    return true;
                }
                d.a(bitmap, 100, CompressFormat.PNG, str, z);
                return true;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CropImageUI", e, "", new Object[0]);
                x.e("MicroMsg.CropImageUI", "saveBitmapToImage failed:" + e.toString());
            }
        }
        return false;
    }

    private static float[][] b(Matrix matrix) {
        float[][] fArr = (float[][]) Array.newInstance(Float.TYPE, new int[]{3, 3});
        float[] fArr2 = new float[9];
        matrix.getValues(fArr2);
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                fArr[i][i2] = fArr2[(i * 3) + i2];
            }
        }
        return fArr;
    }
}
