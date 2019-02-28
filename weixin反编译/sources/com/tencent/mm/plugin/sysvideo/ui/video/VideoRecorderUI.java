package com.tencent.mm.plugin.sysvideo.ui.video;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.k.b;
import com.tencent.mm.pluginsdk.k.e;
import com.tencent.mm.pluginsdk.k.f;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.p;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.io.InputStream;

public class VideoRecorderUI extends MMActivity {
    private static VideoRecorderUI sgj;
    private ProgressDialog inI = null;
    private SurfaceView jaC = null;
    private long kJN = -1;
    private al kKh = new al(new a() {
        public final boolean uG() {
            if (VideoRecorderUI.this.kJN == -1) {
                VideoRecorderUI.this.kJN = SystemClock.elapsedRealtime();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - VideoRecorderUI.this.kJN;
            VideoRecorderUI.this.sge.setText(e.iZ((int) (elapsedRealtime / 1000)));
            if (elapsedRealtime > 30000 || elapsedRealtime < 20000) {
                VideoRecorderUI.this.sfZ.setVisibility(8);
            } else {
                long j = (30000 - elapsedRealtime) / 1000;
                VideoRecorderUI.this.sfZ.setVisibility(0);
                VideoRecorderUI.this.sfZ.setText(VideoRecorderUI.this.getResources().getQuantityString(R.j.duX, (int) j, new Object[]{Long.valueOf(j)}));
            }
            if (elapsedRealtime >= 30000) {
                x.v("MicroMsg.VideoRecorderUI", "record stop on countdown");
                VideoRecorderUI.d(VideoRecorderUI.this);
                VideoRecorderUI.this.kJN = -1;
                return false;
            }
            VideoRecorderUI.this.sgh = VideoRecorderUI.this.sgh % 2;
            if (VideoRecorderUI.this.sgh == 0) {
                VideoRecorderUI.this.sgd.setVisibility(4);
            } else {
                VideoRecorderUI.this.sgd.setVisibility(0);
            }
            VideoRecorderUI.this.sgh = VideoRecorderUI.this.sgh + 1;
            return true;
        }
    }, true);
    private boolean qgp;
    private String sfQ = null;
    private SurfaceHolder sfU = null;
    private b sfV;
    private ImageButton sfW;
    private boolean sfX = false;
    private boolean sfY = false;
    private TextView sfZ;
    private LinearLayout sga;
    private ImageView sgb;
    private ImageButton sgc = null;
    private ImageView sgd;
    private TextView sge;
    private TextView sgf;
    private TextView sgg;
    private int sgh = 0;
    private ImageButton sgi;
    private boolean sgk = false;
    private boolean sgl = true;
    private String sgm = null;
    private String sgn = null;
    private View sgo;
    private View sgp;
    private ag sgq = new ag() {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            VideoRecorderUI.this.sgi.setEnabled(true);
        }
    };
    Callback sgr = new Callback() {
        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            x.d("MicroMsg.VideoRecorderUI", "surfaceCreated");
            if (VideoRecorderUI.this.sfV.a(VideoRecorderUI.this, VideoRecorderUI.this.sgk) != 0) {
                VideoRecorderUI.this.bFe();
            }
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            x.d("MicroMsg.VideoRecorderUI", "surfaceDestroyed");
            VideoRecorderUI.this.sgl = true;
            VideoRecorderUI.this.sfV.cax();
        }

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            x.d("MicroMsg.VideoRecorderUI", "surfaceChanged for:" + i + " w:" + i2 + " h:" + i3);
            if (VideoRecorderUI.this.sfV.b(surfaceHolder) != 0) {
                VideoRecorderUI.this.bFe();
            }
            VideoRecorderUI.this.sgk = false;
            VideoRecorderUI.this.sgl = false;
            VideoRecorderUI.x(VideoRecorderUI.this);
        }
    };
    private String talker = null;
    private String videoPath = null;

    static /* synthetic */ void d(VideoRecorderUI videoRecorderUI) {
        Bitmap createVideoThumbnail;
        Throwable e;
        String str;
        TextView textView;
        CharSequence charSequence;
        videoRecorderUI.sfY = false;
        videoRecorderUI.releaseWakeLock();
        videoRecorderUI.sfW.setImageResource(R.g.bHi);
        videoRecorderUI.sfW.setEnabled(false);
        videoRecorderUI.getString(R.l.dGZ);
        videoRecorderUI.inI = h.a((Context) videoRecorderUI, videoRecorderUI.getString(R.l.eTi, new Object[]{Integer.valueOf(0)}), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                x.d("MicroMsg.VideoRecorderUI", "tipDialog onCancel");
                if (VideoRecorderUI.this.sfV != null) {
                    VideoRecorderUI.this.aUB();
                    VideoRecorderUI.this.sga.setVisibility(0);
                    VideoRecorderUI.this.jaC.setVisibility(0);
                }
            }
        });
        long elapsedRealtime = SystemClock.elapsedRealtime() - videoRecorderUI.kJN;
        videoRecorderUI.kKh.TN();
        videoRecorderUI.sfZ.setVisibility(8);
        videoRecorderUI.sfX = true;
        b bVar = videoRecorderUI.sfV;
        if (bVar.oAo != null) {
            try {
                bVar.oAo.stop();
                bVar.oAo.release();
            } catch (Exception e2) {
                x.e("MicroMsg.SceneVideo", "video[tiger] video stop failed");
            }
            bVar.oAo = null;
            bVar.qDx.hXv = (int) (elapsedRealtime / 1000);
            bVar.qDx.hXv = bVar.qDx.hXv > 0 ? bVar.qDx.hXv : 1;
            bVar.qDx.oze = bVar.qDx.hXv * bVar.qDx.fps;
            if (!(!com.tencent.mm.a.e.bO(bVar.qDx.ozd) || com.tencent.mm.a.e.bO(bVar.qDx.ozb) || bVar.context == null)) {
                createVideoThumbnail = d.fN(8) ? ThumbnailUtils.createVideoThumbnail(bVar.qDx.ozd, 1) : null;
                if (createVideoThumbnail != null) {
                    try {
                        x.d("MicroMsg.SceneVideo", "saveBitmapToImage " + bVar.qDx.ozb);
                        e.a(createVideoThumbnail, CompressFormat.JPEG, bVar.qDx.ozb);
                    } catch (Throwable e3) {
                        x.printErrStackTrace("MicroMsg.SceneVideo", e3, "", new Object[0]);
                    }
                } else {
                    InputStream openRawResource;
                    try {
                        openRawResource = bVar.context.getResources().openRawResource(R.g.bBB);
                        try {
                            e.a(BitmapFactory.decodeStream(openRawResource), CompressFormat.JPEG, bVar.qDx.ozb);
                            if (openRawResource != null) {
                                try {
                                    openRawResource.close();
                                } catch (Throwable e32) {
                                    x.printErrStackTrace("MicroMsg.SceneVideo", e32, "", new Object[0]);
                                }
                            }
                        } catch (Exception e4) {
                            e32 = e4;
                            try {
                                x.printErrStackTrace("MicroMsg.SceneVideo", e32, "", new Object[0]);
                                if (openRawResource != null) {
                                    try {
                                        openRawResource.close();
                                    } catch (Throwable e322) {
                                        x.printErrStackTrace("MicroMsg.SceneVideo", e322, "", new Object[0]);
                                    }
                                }
                                if (com.tencent.mm.a.e.bO(bVar.qDx.ozd)) {
                                    bVar.fileSize = com.tencent.mm.a.e.bN(bVar.qDx.ozd);
                                }
                                str = videoRecorderUI.sfV.qDx.ozb;
                                if (str != null) {
                                }
                                createVideoThumbnail = null;
                                if (createVideoThumbnail != null) {
                                    videoRecorderUI.jaC.setVisibility(8);
                                    videoRecorderUI.sgb.setVisibility(0);
                                    videoRecorderUI.sgb.setImageBitmap(createVideoThumbnail);
                                }
                                if (videoRecorderUI.inI != null) {
                                    videoRecorderUI.inI.dismiss();
                                    videoRecorderUI.inI = null;
                                }
                                videoRecorderUI.sfZ.setVisibility(8);
                                videoRecorderUI.sgp.setVisibility(0);
                                textView = videoRecorderUI.sgf;
                                elapsedRealtime = (long) videoRecorderUI.sfV.fileSize;
                                charSequence = (elapsedRealtime >> 20) <= 0 ? (elapsedRealtime >> 9) <= 0 ? elapsedRealtime + "B" : (((float) Math.round((((float) elapsedRealtime) * 10.0f) / 1024.0f)) / 10.0f) + "KB" : (((float) Math.round((((float) elapsedRealtime) * 10.0f) / 1048576.0f)) / 10.0f) + "MB";
                                textView.setText(charSequence);
                                videoRecorderUI.sgg.setText(e.iZ(videoRecorderUI.sfV.qDx.hXv));
                                videoRecorderUI.sga.setVisibility(8);
                                videoRecorderUI.sgc.setVisibility(0);
                                videoRecorderUI.sgo.setVisibility(8);
                                videoRecorderUI.sgi.setVisibility(8);
                                videoRecorderUI.sfW.setVisibility(8);
                                videoRecorderUI.sfW.setEnabled(true);
                                videoRecorderUI.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                                videoRecorderUI.getSupportActionBar().show();
                            } catch (Throwable th) {
                                e322 = th;
                                if (openRawResource != null) {
                                    try {
                                        openRawResource.close();
                                    } catch (Throwable e5) {
                                        x.printErrStackTrace("MicroMsg.SceneVideo", e5, "", new Object[0]);
                                    }
                                }
                                throw e322;
                            }
                        }
                    } catch (Exception e6) {
                        e322 = e6;
                        openRawResource = null;
                    } catch (Throwable th2) {
                        e322 = th2;
                        openRawResource = null;
                        if (openRawResource != null) {
                            openRawResource.close();
                        }
                        throw e322;
                    }
                }
            }
            if (com.tencent.mm.a.e.bO(bVar.qDx.ozd)) {
                bVar.fileSize = com.tencent.mm.a.e.bN(bVar.qDx.ozd);
            }
        }
        str = videoRecorderUI.sfV.qDx.ozb;
        if (str != null || str.length() <= 0) {
            createVideoThumbnail = null;
        } else {
            Bitmap b = BackwardSupportUtil.b.b(str.trim(), com.tencent.mm.bu.a.getDensity(videoRecorderUI));
            if (b != null) {
                int width = b.getWidth();
                int height = b.getHeight();
                int b2 = BackwardSupportUtil.b.b((Context) videoRecorderUI, 224.0f);
                createVideoThumbnail = Bitmap.createScaledBitmap(b, b2, (int) (((float) height) / (((float) width) / ((float) b2))), true);
                if (b != createVideoThumbnail) {
                    x.i("MicroMsg.SceneVideo", "recycle bitmap:%s", b.toString());
                    b.recycle();
                }
            } else {
                createVideoThumbnail = b;
            }
        }
        if (createVideoThumbnail != null) {
            videoRecorderUI.jaC.setVisibility(8);
            videoRecorderUI.sgb.setVisibility(0);
            videoRecorderUI.sgb.setImageBitmap(createVideoThumbnail);
        }
        if (videoRecorderUI.inI != null) {
            videoRecorderUI.inI.dismiss();
            videoRecorderUI.inI = null;
        }
        videoRecorderUI.sfZ.setVisibility(8);
        videoRecorderUI.sgp.setVisibility(0);
        textView = videoRecorderUI.sgf;
        elapsedRealtime = (long) videoRecorderUI.sfV.fileSize;
        if ((elapsedRealtime >> 20) <= 0) {
        }
        textView.setText(charSequence);
        videoRecorderUI.sgg.setText(e.iZ(videoRecorderUI.sfV.qDx.hXv));
        videoRecorderUI.sga.setVisibility(8);
        videoRecorderUI.sgc.setVisibility(0);
        videoRecorderUI.sgo.setVisibility(8);
        videoRecorderUI.sgi.setVisibility(8);
        videoRecorderUI.sfW.setVisibility(8);
        videoRecorderUI.sfW.setEnabled(true);
        videoRecorderUI.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        videoRecorderUI.getSupportActionBar().show();
    }

    static /* synthetic */ void n(VideoRecorderUI videoRecorderUI) {
        videoRecorderUI.mController.hideTitleView();
        videoRecorderUI.sga.setVisibility(0);
        videoRecorderUI.jaC.setVisibility(0);
        videoRecorderUI.sgi.setVisibility(8);
        videoRecorderUI.sgp.setVisibility(8);
        videoRecorderUI.sfY = true;
        videoRecorderUI.sgb.setVisibility(8);
        videoRecorderUI.sgc.setVisibility(8);
        videoRecorderUI.sgo.setVisibility(0);
        videoRecorderUI.sfZ.setVisibility(0);
        videoRecorderUI.kJN = -1;
        videoRecorderUI.kKh.K(300, 300);
        videoRecorderUI.jaC.setKeepScreenOn(true);
        b bVar = videoRecorderUI.sfV;
        SurfaceHolder surfaceHolder = videoRecorderUI.sfU;
        if (surfaceHolder == null) {
            x.e("MicroMsg.SceneVideo", "start fail, holder is null");
            return;
        }
        Surface surface = surfaceHolder.getSurface();
        bVar.vpe = 0;
        bVar.b(surface, bVar.qDx.fps, 0);
    }

    static /* synthetic */ void x(VideoRecorderUI videoRecorderUI) {
        int aHt;
        int aHu;
        LayoutParams layoutParams = (LayoutParams) videoRecorderUI.jaC.getLayoutParams();
        DisplayMetrics displayMetrics = videoRecorderUI.getResources().getDisplayMetrics();
        if (videoRecorderUI.qgp) {
            aHt = videoRecorderUI.sfV.aHt();
            aHu = videoRecorderUI.sfV.aHu();
        } else {
            aHt = videoRecorderUI.sfV.aHu();
            aHu = videoRecorderUI.sfV.aHt();
        }
        x.i("MicroMsg.VideoRecorderUI", "resizeLayout priveview[%d, %d], dm[%d, %d]", Integer.valueOf(aHt), Integer.valueOf(aHu), Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
        if (((float) aHt) / ((float) aHu) > ((float) displayMetrics.widthPixels) / ((float) displayMetrics.heightPixels)) {
            x.i("MicroMsg.VideoRecorderUI", "resizeLayout wider");
            aHu = (int) (((float) aHu) * (((float) displayMetrics.widthPixels) / ((float) aHt)));
            aHt = displayMetrics.widthPixels;
        } else {
            x.i("MicroMsg.VideoRecorderUI", "resizeLayout higher");
            aHt = (int) ((((float) displayMetrics.heightPixels) / ((float) aHu)) * ((float) aHt));
            aHu = displayMetrics.heightPixels;
        }
        x.i("MicroMsg.VideoRecorderUI", "resizeLayout width:%d, height:%d", Integer.valueOf(aHt), Integer.valueOf(aHu));
        layoutParams.width = aHt;
        layoutParams.height = aHu;
        videoRecorderUI.jaC.setLayoutParams(layoutParams);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        p.initLanguage(this);
        sgj = this;
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        getSupportActionBar().hide();
        setMMTitle(R.l.eTE);
        a(0, getString(R.l.dGL), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.putExtra("VideoRecorder_FileName", VideoRecorderUI.this.sfV.filename);
                intent.putExtra("VideoRecorder_VideoLength", VideoRecorderUI.this.sfV.qDx.hXv);
                intent.putExtra("VideoRecorder_ToUser", VideoRecorderUI.this.talker);
                VideoRecorderUI.this.setResult(-1, intent);
                VideoRecorderUI.this.finish();
                return true;
            }
        }, p.b.xSe);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                VideoRecorderUI.this.bFd();
                return true;
            }
        });
        this.talker = getIntent().getStringExtra("VideoRecorder_ToUser");
        this.videoPath = getIntent().getStringExtra("VideoRecorder_VideoPath");
        this.sfQ = getIntent().getStringExtra("VideoRecorder_VideoFullPath");
        this.sgm = getIntent().getStringExtra("VideoRecorder_VideoThumbPath");
        this.sgn = getIntent().getStringExtra("VideoRecorder_FileName");
        x.d("MicroMsg.VideoRecorderUI", "talker :" + this.talker);
        x.d("MicroMsg.VideoRecorderUI", "videoPath :" + this.videoPath + " videoFullPath " + this.sfQ + " videoThumbPath " + this.sgm + " KFileName " + this.sgn);
        initView();
        aUB();
        as.uy().wI();
    }

    public void onStart() {
        super.onStart();
        if (this.qgp) {
            setRequestedOrientation(0);
        } else {
            setRequestedOrientation(1);
        }
    }

    protected void onDestroy() {
        sgj = null;
        x.v("MicroMsg.VideoRecorderUI", "on destroy");
        as.uy().wH();
        super.onDestroy();
    }

    protected final void initView() {
        int i = 1;
        this.jaC = (SurfaceView) findViewById(R.h.cPP);
        this.sga = (LinearLayout) findViewById(R.h.cVv);
        this.sfU = this.jaC.getHolder();
        this.sfU.addCallback(this.sgr);
        this.sfU.setType(3);
        this.sgd = (ImageView) findViewById(R.h.cVy);
        this.sgi = (ImageButton) findViewById(R.h.cVP);
        this.sge = (TextView) findViewById(R.h.cVw);
        this.sgo = findViewById(R.h.cVx);
        this.sgp = findViewById(R.h.cVr);
        this.sge.setText(e.iZ(0));
        this.sfV = new b();
        this.sfZ = (TextView) findViewById(R.h.cVR);
        this.sgf = (TextView) findViewById(R.h.cVz);
        this.sgg = (TextView) findViewById(R.h.cVs);
        this.sfW = (ImageButton) findViewById(R.h.cVQ);
        this.sfW.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                as.Hm();
                if (!c.isSDCardAvailable()) {
                    u.fJ(VideoRecorderUI.this);
                } else if (VideoRecorderUI.this.sfY) {
                    VideoRecorderUI.d(VideoRecorderUI.this);
                } else if (VideoRecorderUI.this.sfX) {
                    h.a(VideoRecorderUI.this, VideoRecorderUI.this.getString(R.l.eTD), VideoRecorderUI.this.getString(R.l.dGZ), new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            VideoRecorderUI.this.sfW.setImageResource(R.g.bHj);
                            VideoRecorderUI.n(VideoRecorderUI.this);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                } else {
                    VideoRecorderUI.this.sfW.setImageResource(R.g.bHj);
                    VideoRecorderUI.n(VideoRecorderUI.this);
                }
            }
        });
        if (com.tencent.mm.compatible.e.d.getNumberOfCameras() > 1) {
            this.sgi.setVisibility(0);
        } else {
            this.sgi.setVisibility(4);
        }
        this.sgi.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                VideoRecorderUI.this.sgi.setEnabled(false);
                VideoRecorderUI.this.sgq.sendEmptyMessageDelayed(0, 3000);
                VideoRecorderUI.this.sgk = true;
                VideoRecorderUI.this.sfV.cax();
                if (VideoRecorderUI.this.sfV.a(VideoRecorderUI.this, VideoRecorderUI.this.sgk) != 0 || VideoRecorderUI.this.sfV.b(VideoRecorderUI.this.sfU) != 0) {
                    VideoRecorderUI.this.bFe();
                }
            }
        });
        this.sgc = (ImageButton) findViewById(R.h.cVo);
        this.sgb = (ImageView) findViewById(R.h.cVu);
        this.sgc.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent(VideoRecorderUI.this, VideoRecorderPreviewUI.class);
                intent.putExtra("VideoRecorder_FileName", VideoRecorderUI.this.sfV.filename);
                intent.putExtra("VideoRecorder_VideoLength", VideoRecorderUI.this.sfV.qDx.hXv);
                intent.putExtra("VideoRecorder_VideoSize", VideoRecorderUI.this.sfV.fileSize);
                intent.putExtra("VideoRecorder_ToUser", VideoRecorderUI.this.talker);
                intent.putExtra("VideoRecorder_VideoFullPath", VideoRecorderUI.this.sfQ);
                VideoRecorderUI.this.startActivityForResult(intent, 0);
                VideoRecorderUI.this.overridePendingTransition(0, 0);
            }
        });
        b bVar = this.sfV;
        int i2 = !this.qgp ? 1 : 0;
        String str = this.videoPath;
        String str2 = this.sfQ;
        String str3 = this.sgm;
        String str4 = this.sgn;
        bVar.hVH = 0;
        if (1 == bVar.hVH) {
            bVar.qDx = com.tencent.mm.pluginsdk.k.a.caw();
        } else {
            bVar.qDx = com.tencent.mm.pluginsdk.k.a.cav();
        }
        if (q.gHH.gIj) {
            bVar.qDx.oyV = q.gHH.mVideoHeight;
            bVar.qDx.oyW = q.gHH.mVideoWidth;
            bVar.qDx.oyU = q.gHH.gIl;
        }
        bVar.filename = str4;
        bVar.qDx.ozd = str2;
        bVar.qDx.ozb = str3;
        bVar.qDx.oza = str + "temp.pcm";
        bVar.qDx.oyZ = str + "temp.yuv";
        bVar.qDx.ozc = str + "temp.vid";
        bVar.qDx.ozf = com.tencent.mm.compatible.e.d.getNumberOfCameras();
        com.tencent.mm.pluginsdk.k.a aVar = bVar.qDx;
        if (i2 == 0) {
            i = 0;
        }
        aVar.fGt = i;
        bVar.qDx.hXv = 0;
        bVar.vpd = new f();
    }

    protected final void dealContentView(View view) {
        ae.c(ae.a(getWindow(), null), this.mController.xRd);
        ((ViewGroup) this.mController.xRd.getParent()).removeView(this.mController.xRd);
        ((ViewGroup) getWindow().getDecorView()).addView(this.mController.xRd, 0);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        x.d("MicroMsg.VideoRecorderUI", "KEYCODE_BACK");
        if (this.sfY) {
            return true;
        }
        bFd();
        return true;
    }

    private void bFd() {
        if (this.sfX) {
            h.a((Context) this, getString(R.l.eTC), getString(R.l.dGZ), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    VideoRecorderUI.this.finish();
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        } else {
            finish();
        }
    }

    private void aUB() {
        getSupportActionBar().hide();
        this.sge.setText(e.iZ(0));
        this.sgo.setVisibility(8);
        this.sgp.setVisibility(8);
        this.sgd.setVisibility(0);
        this.sfX = false;
        this.sga.setVisibility(0);
        this.jaC.setVisibility(0);
        this.sfZ.setVisibility(8);
        this.sgc.setVisibility(8);
        this.sge.setText(e.iZ(0));
        this.sgb.setVisibility(8);
        this.sfW.setEnabled(true);
        this.sgi.setVisibility(0);
    }

    protected void onResume() {
        if (!(this.sgl || (this.sfV.a(this, false) == 0 && this.sfV.b(this.sfU) == 0))) {
            bFe();
        }
        this.sgl = false;
        x.v("MicroMsg.VideoRecorderUI", "onResume");
        super.onResume();
    }

    protected void onPause() {
        if (this.sfY) {
            b bVar = this.sfV;
            if (bVar.oAo != null) {
                bVar.oAo.stop();
                bVar.oAo.release();
                bVar.oAo = null;
            }
            aUB();
            this.sfY = false;
            releaseWakeLock();
            this.sfW.setImageResource(R.g.bHi);
            this.kKh.TN();
            this.sfZ.setVisibility(8);
            this.sga.setVisibility(0);
            this.jaC.setVisibility(0);
        }
        this.sfV.cax();
        x.v("MicroMsg.VideoRecorderUI", "onPause");
        super.onPause();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 0) {
                setResult(-1, intent);
                finish();
            }
            super.onActivityResult(i, i2, intent);
        }
    }

    private void bFe() {
        h.a((Context) this, R.l.eTk, R.l.dGZ, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                VideoRecorderUI.this.sfV.cax();
                VideoRecorderUI.this.finish();
            }
        });
    }

    private void releaseWakeLock() {
        this.jaC.setKeepScreenOn(false);
    }

    protected final int getLayoutId() {
        this.qgp = com.tencent.mm.compatible.e.d.ys();
        if (!this.qgp) {
            return R.i.dtD;
        }
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        setRequestedOrientation(0);
        return R.i.dtE;
    }
}
