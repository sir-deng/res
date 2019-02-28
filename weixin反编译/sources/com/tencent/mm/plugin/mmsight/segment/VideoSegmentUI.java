package com.tencent.mm.plugin.mmsight.segment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.FileEntry;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.k.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.base.h;
import com.tencent.wcdb.FileUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@com.tencent.mm.ui.base.a(3)
public class VideoSegmentUI extends MMActivity {
    private String fwx;
    private int hQf;
    private ProgressDialog inI = null;
    private RelativeLayout mDg;
    private Surface mSurface;
    private com.tencent.mm.remoteservice.d mlo = new com.tencent.mm.remoteservice.d(this);
    private String oDh = "";
    private com.tencent.mm.plugin.mmsight.segment.a.c.a oFA = new com.tencent.mm.plugin.mmsight.segment.a.c.a() {
        private Runnable oFD;

        public final void tp(int i) {
            if (VideoSegmentUI.this.oFt != null) {
                if (this.oFD != null) {
                    ((View) VideoSegmentUI.this.oFt).removeCallbacks(this.oFD);
                }
                this.oFD = new c(VideoSegmentUI.this.oFt, i, VideoSegmentUI.this.hQf);
                ((View) VideoSegmentUI.this.oFt).post(this.oFD);
            }
        }
    };
    private com.tencent.mm.plugin.mmsight.segment.a.a.d oFB = new com.tencent.mm.plugin.mmsight.segment.a.a.d() {
        public final void Q(int i, int i2, int i3) {
            if (i <= 0 || i2 <= 0) {
                x.e("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged wrong size (%d, %d) invoked = %b", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(VideoSegmentUI.this.oFy));
            } else if (VideoSegmentUI.this.oFy) {
                x.e("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged surface has invoked");
            } else {
                x.i("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged (%d, %d)", Integer.valueOf(i), Integer.valueOf(i2));
                VideoSegmentUI.this.oFy = true;
                if (i2 <= 0 || i <= 0) {
                    x.e("MicroMsg.VideoSegmentUI", "This video has wrong size (%dx%d)", Integer.valueOf(i), Integer.valueOf(i2));
                    VideoSegmentUI.this.oFx = true;
                    VideoSegmentUI.this.finish();
                    VideoSegmentUI.b(VideoSegmentUI.this);
                    return;
                }
                Runnable aVar = new a(VideoSegmentUI.this, VideoSegmentUI.this.mDg, i2, i, i3, new b(VideoSegmentUI.this, (byte) 0), (byte) 0);
                if (VideoSegmentUI.this.mDg.getWidth() <= 0 || VideoSegmentUI.this.mDg.getHeight() <= 0) {
                    x.i("MicroMsg.VideoSegmentUI", "post init surface task after root measured.");
                    VideoSegmentUI.this.mDg.post(aVar);
                    return;
                }
                aVar.run();
            }
        }
    };
    private String oFp = null;
    private f oFq;
    private com.tencent.mm.plugin.mmsight.segment.a.c oFr;
    private boolean oFs = false;
    private c oFt;
    private CountDownLatch oFu = new CountDownLatch(2);
    private int oFv = 10000;
    private boolean oFw = false;
    private boolean oFx = false;
    private boolean oFy = false;
    private com.tencent.mm.plugin.mmsight.segment.c.b oFz = new com.tencent.mm.plugin.mmsight.segment.c.b() {
        public final void A(float f, float f2) {
            if (VideoSegmentUI.this.oFr != null) {
                int e = VideoSegmentUI.this.hQf;
                VideoSegmentUI.this.oFr.setLoop((int) (((float) e) * f), (int) (((float) e) * f2));
                VideoSegmentUI.this.oFr.seekTo((int) (((float) e) * f));
            }
        }

        public final void bbH() {
            if (VideoSegmentUI.this.oFr != null) {
                VideoSegmentUI.this.oFr.pause();
            }
        }

        public final void B(float f, float f2) {
            if (VideoSegmentUI.this.oFr != null) {
                int e = (int) (((float) VideoSegmentUI.this.hQf) * f);
                VideoSegmentUI.this.oFr.setLoop(e, (int) (((float) VideoSegmentUI.this.hQf) * f2));
                VideoSegmentUI.this.oFr.seekTo(e);
            }
        }

        public final void C(float f, float f2) {
            if ((f2 - f) * ((float) VideoSegmentUI.this.hQf) <= ((float) VideoSegmentUI.this.oFv)) {
                VideoSegmentUI.this.enableOptionMenu(true);
            } else {
                VideoSegmentUI.this.enableOptionMenu(false);
            }
        }
    };
    private VideoTransPara oxX;

    private class b implements SurfaceTextureListener {
        private b() {
        }

        /* synthetic */ b(VideoSegmentUI videoSegmentUI, byte b) {
            this();
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            String str = "MicroMsg.VideoSegmentUI";
            String str2 = "TextureViewCallback create needResume[%b] segmentPlayer is null[%b]";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(VideoSegmentUI.this.oFw);
            objArr[1] = Boolean.valueOf(VideoSegmentUI.this.oFr == null);
            x.i(str, str2, objArr);
            VideoSegmentUI.this.mSurface = new Surface(surfaceTexture);
            if (VideoSegmentUI.this.oFr == null && VideoSegmentUI.this.oFw) {
                x.i("MicroMsg.VideoSegmentUI", "MediaPlayer resume");
                try {
                    VideoSegmentUI.this.a(false, VideoSegmentUI.this.mSurface);
                    if (!(VideoSegmentUI.this.oFt == null || VideoSegmentUI.this.oFr == null)) {
                        VideoSegmentUI.this.oFr.setLoop((int) (((float) VideoSegmentUI.this.hQf) * VideoSegmentUI.this.oFt.bbF()), (int) (((float) VideoSegmentUI.this.hQf) * VideoSegmentUI.this.oFt.bbG()));
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.VideoSegmentUI", e, "ResumeMediaPlayer error %s", e.getMessage());
                }
                VideoSegmentUI.this.oFw = false;
            }
            VideoSegmentUI.this.oFu.countDown();
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            x.i("MicroMsg.VideoSegmentUI", "TextureViewCallback.surfaceDestroyed %s", bi.chl());
            try {
                if (VideoSegmentUI.this.oFr != null) {
                    x.i("MicroMsg.VideoSegmentUI", "TextureViewCallback MediaPlayer pause");
                    VideoSegmentUI.this.oFr.release();
                    VideoSegmentUI.this.oFr = null;
                    VideoSegmentUI.this.oFw = true;
                }
                VideoSegmentUI.this.mSurface = null;
            } catch (Exception e) {
            }
            return false;
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    private class a implements Runnable {
        private Context context;
        private ViewGroup oDd;
        private int oFH;
        private int oFI;
        private int oFJ;
        private b oFK;

        /* synthetic */ a(VideoSegmentUI videoSegmentUI, ViewGroup viewGroup, int i, int i2, int i3, b bVar, byte b) {
            this(viewGroup, i, i2, i3, bVar);
        }

        private a(ViewGroup viewGroup, int i, int i2, int i3, b bVar) {
            this.oFH = i;
            this.oFI = i2;
            this.oFJ = i3;
            this.context = viewGroup.getContext();
            this.oDd = viewGroup;
            this.oFK = bVar;
        }

        public final void run() {
            if (!VideoSegmentUI.this.isFinishing()) {
                View anonymousClass1 = new MMTextureView(this.context) {
                    protected final void onMeasure(int i, int i2) {
                        x.d("MicroMsg.VideoSegmentUI", "onMeasure video size[%d, %d, %d] spec[%d, %d]", Integer.valueOf(a.this.oFI), Integer.valueOf(a.this.oFH), Integer.valueOf(a.this.oFJ), Integer.valueOf(View.getDefaultSize(1, i)), Integer.valueOf(View.getDefaultSize(1, i2)));
                        if (a.this.oFJ == 90 || a.this.oFJ == 270) {
                            Matrix matrix = new Matrix();
                            matrix.set(getMatrix());
                            int defaultSize = View.getDefaultSize(1, i);
                            int defaultSize2 = View.getDefaultSize(1, i2);
                            float f = ((float) defaultSize) / 2.0f;
                            float f2 = ((float) defaultSize2) / 2.0f;
                            float f3 = ((float) defaultSize2) / ((float) defaultSize);
                            matrix.postRotate((float) a.this.oFJ, f, f2);
                            matrix.postScale(1.0f / f3, f3, f, f2);
                            setTransform(matrix);
                            x.i("MicroMsg.VideoSegmentUI", "rotate transform mDegrees[%d] screenSize[%d, %d]", Integer.valueOf(a.this.oFJ), Integer.valueOf(defaultSize), Integer.valueOf(defaultSize2));
                        }
                        super.onMeasure(i, i2);
                    }
                };
                int width = this.oDd.getWidth();
                int aa = com.tencent.mm.bu.a.aa(this.context, com.tencent.mm.plugin.mmsight.segment.k.b.oDU);
                int top = ((View) VideoSegmentUI.this.oFt).getTop() - (aa * 2);
                int i = this.oFI;
                int i2 = this.oFH;
                Point point = new Point();
                float f = ((float) i2) / ((float) i) > ((float) top) / ((float) width) ? ((float) top) / ((float) i2) : ((float) width) / ((float) i);
                point.x = (int) (((float) i) * f);
                point.y = (int) (f * ((float) i2));
                x.i("MicroMsg.VideoSegmentUI", "rawWidth %d rawHeight %d  rawDegress %d padding %d validWidth %d validHeight %d scaled %s", Integer.valueOf(this.oFI), Integer.valueOf(this.oFH), Integer.valueOf(this.oFJ), Integer.valueOf(aa), Integer.valueOf(width), Integer.valueOf(top), point.toString());
                if (point.x <= 0 || point.y <= 0) {
                    x.e("MicroMsg.VideoSegmentUI", "rawWidth %d rawHeight %d padding %d validWidth %d validHeight %d scaled %s", Integer.valueOf(this.oFI), Integer.valueOf(this.oFH), Integer.valueOf(aa), Integer.valueOf(width), Integer.valueOf(top), point.toString());
                    if (this.oFK != null) {
                        b bVar = this.oFK;
                        x.e("MicroMsg.VideoSegmentUI", "TextureViewCallback error");
                        bVar.oFC.oFx = true;
                        bVar.oFC.finish();
                        VideoSegmentUI.b(bVar.oFC);
                        return;
                    }
                    return;
                }
                LayoutParams layoutParams = new RelativeLayout.LayoutParams(point.x, point.y);
                aa += (int) (((float) (top - point.y)) / 2.0f);
                layoutParams.topMargin = aa;
                layoutParams.bottomMargin = aa;
                width = (int) (((float) (width - point.x)) / 2.0f);
                layoutParams.leftMargin = width;
                layoutParams.rightMargin = width;
                anonymousClass1.setSurfaceTextureListener(this.oFK);
                this.oDd.addView(anonymousClass1, 0, layoutParams);
            }
        }
    }

    private class d implements Runnable {
        private d() {
        }

        /* synthetic */ d(VideoSegmentUI videoSegmentUI, byte b) {
            this();
        }

        public final void run() {
            boolean await;
            try {
                await = VideoSegmentUI.this.oFu.await(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                x.e("MicroMsg.VideoSegmentUI", "count down latch error %s", e);
                await = false;
            }
            if (await) {
                try {
                    if (!(VideoSegmentUI.this.oFx || VideoSegmentUI.this.isFinishing() || VideoSegmentUI.this.mSurface == null || !VideoSegmentUI.this.mSurface.isValid())) {
                        if (VideoSegmentUI.this.oFr != null) {
                            VideoSegmentUI.this.oFr.a(null);
                            VideoSegmentUI.this.oFr.a(null);
                            VideoSegmentUI.this.oFr.release();
                            VideoSegmentUI.this.oFr = null;
                        }
                        try {
                            VideoSegmentUI.this.a(false, VideoSegmentUI.this.mSurface);
                            VideoSegmentUI.this.oFr.setSurface(VideoSegmentUI.this.mSurface);
                            ah.y(new Runnable() {
                                public final void run() {
                                    if (VideoSegmentUI.this.oFx || VideoSegmentUI.this.isFinishing() || VideoSegmentUI.this.oFt == null || VideoSegmentUI.this.oFr == null) {
                                        x.i("MicroMsg.VideoSegmentUI", "waiting end, main thread, activity not valid.");
                                        return;
                                    }
                                    ((View) VideoSegmentUI.this.oFt).setAlpha(0.0f);
                                    ((View) VideoSegmentUI.this.oFt).setVisibility(0);
                                    ((View) VideoSegmentUI.this.oFt).animate().setDuration(300).setStartDelay(200).alpha(1.0f);
                                    float bbF = VideoSegmentUI.this.oFt.bbF();
                                    float bbG = VideoSegmentUI.this.oFt.bbG();
                                    if ((bbG - bbF) * ((float) VideoSegmentUI.this.hQf) <= ((float) VideoSegmentUI.this.oFv)) {
                                        VideoSegmentUI.this.enableOptionMenu(true);
                                    }
                                    VideoSegmentUI.this.oFr.setLoop((int) (bbF * ((float) VideoSegmentUI.this.hQf)), (int) (bbG * ((float) VideoSegmentUI.this.hQf)));
                                }
                            });
                            return;
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.VideoSegmentUI", e2, "init segmentPlayer second time %s", e2.getMessage());
                            VideoSegmentUI.this.finish();
                            return;
                        }
                    }
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.VideoSegmentUI", e22, "Finished when init", new Object[0]);
                    VideoSegmentUI.this.finish();
                    return;
                }
            }
            String str = "MicroMsg.VideoSegmentUI";
            String str2 = "Waiting Prepared error result[%b] needFinish[%b] isFinishing[%b] mSurface is null[%b]";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(await);
            objArr[1] = Boolean.valueOf(VideoSegmentUI.this.oFx);
            objArr[2] = Boolean.valueOf(VideoSegmentUI.this.isFinishing());
            objArr[3] = Boolean.valueOf(VideoSegmentUI.this.mSurface == null);
            x.w(str, str2, objArr);
            VideoSegmentUI.this.finish();
        }
    }

    private static class c implements Runnable {
        private int hQf;
        private WeakReference<c> hlN;
        private int oFM;

        public c(c cVar, int i, int i2) {
            this.hlN = new WeakReference(cVar);
            this.oFM = i;
            this.hQf = i2;
        }

        public final void run() {
            c cVar = (c) this.hlN.get();
            if (cVar != null) {
                cVar.al(((float) this.oFM) / ((float) this.hQf));
            }
        }
    }

    static /* synthetic */ void a(VideoSegmentUI videoSegmentUI) {
        boolean z = false;
        videoSegmentUI.setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                VideoSegmentUI.this.finish();
                VideoSegmentUI.b(VideoSegmentUI.this);
                return true;
            }
        });
        videoSegmentUI.setMMTitle(f.oDZ);
        videoSegmentUI.a(0, com.tencent.mm.bu.a.ac(videoSegmentUI.mController.xRr, f.dFw), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                VideoSegmentUI.c(VideoSegmentUI.this);
                return true;
            }
        }, com.tencent.mm.ui.p.b.xSe);
        videoSegmentUI.enableOptionMenu(false);
        Intent intent = videoSegmentUI.getIntent();
        if (intent == null || bi.oN(intent.getStringExtra("key_video_path"))) {
            String str = "MicroMsg.VideoSegmentUI";
            String str2 = "is Intent null ? %b, is path null ? %b";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(intent == null);
            if (intent == null || intent.getStringExtra("key_video_path") == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            x.e(str, str2, objArr);
            videoSegmentUI.finish();
            return;
        }
        videoSegmentUI.oFp = intent.getStringExtra("key_video_path");
        x.i("MicroMsg.VideoSegmentUI", "selectVideoPath: %s", videoSegmentUI.oFp);
        if (videoSegmentUI.oFp == null || videoSegmentUI.oFp.length() == 0) {
            x.e("MicroMsg.VideoSegmentUI", "Please pick a video first");
            return;
        }
        videoSegmentUI.initView();
        try {
            videoSegmentUI.a(true, null);
            videoSegmentUI.oFt.a(new com.tencent.mm.plugin.mmsight.segment.c.a() {
                public final void gJ(boolean z) {
                    if (z) {
                        Toast.makeText(VideoSegmentUI.this, f.oEa, 1).show();
                        x.e("MicroMsg.VideoSegmentUI", "Not Supported init SegmentSeekBar failed.");
                        VideoSegmentUI.this.oFx = true;
                        VideoSegmentUI.this.finish();
                        VideoSegmentUI.b(VideoSegmentUI.this);
                        return;
                    }
                    if (!(VideoSegmentUI.this.isFinishing() || VideoSegmentUI.this.oFt == null)) {
                        VideoSegmentUI.this.hQf = VideoSegmentUI.this.oFt.getDurationMs();
                        x.i("MicroMsg.VideoSegmentUI", "SeekBar.onPrepared success %d", Integer.valueOf(VideoSegmentUI.this.hQf));
                        try {
                            if (VideoSegmentUI.this.oFr != null) {
                                VideoSegmentUI.this.oFr.setLoop((int) (((float) VideoSegmentUI.this.hQf) * VideoSegmentUI.this.oFt.bbF()), (int) (((float) VideoSegmentUI.this.hQf) * VideoSegmentUI.this.oFt.bbG()));
                            }
                        } catch (Exception e) {
                        }
                    }
                    VideoSegmentUI.this.oFu.countDown();
                }
            });
            videoSegmentUI.oFt.a(videoSegmentUI.oFz);
            videoSegmentUI.oFt.FR(videoSegmentUI.oFp);
            videoSegmentUI.oFq = new p();
            e.a(new d(videoSegmentUI, (byte) 0), "waiting_for_component_prepared.");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VideoSegmentUI", e, "MediaPlayer set data source error : [%s]", e.getMessage());
            videoSegmentUI.finish();
        }
    }

    static /* synthetic */ void a(VideoSegmentUI videoSegmentUI, boolean z, String str) {
        if (z) {
            Intent intent = new Intent();
            intent.putExtra("K_SEGMENTVIDEOPATH", videoSegmentUI.oDh);
            intent.putExtra("KSEGMENTVIDEOTHUMBPATH", videoSegmentUI.fwx);
            videoSegmentUI.setResult(-1, intent);
            videoSegmentUI.finish();
            return;
        }
        x.e("MicroMsg.VideoSegmentUI", "Clip not success. %s", str);
    }

    static /* synthetic */ void b(VideoSegmentUI videoSegmentUI) {
        int i = 0;
        while (true) {
            try {
                if (((long) i) < videoSegmentUI.oFu.getCount()) {
                    videoSegmentUI.oFu.countDown();
                    i++;
                } else {
                    return;
                }
            } catch (Exception e) {
                x.e("MicroMsg.VideoSegmentUI", "ensureNotWaiting e : %s", e);
                return;
            }
        }
    }

    static /* synthetic */ void c(VideoSegmentUI videoSegmentUI) {
        videoSegmentUI.oDh = CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_output_" + System.currentTimeMillis() + ".mp4";
        videoSegmentUI.fwx = CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_thumb_" + System.currentTimeMillis() + ".jpg";
        e.post(new Runnable() {
            public final void run() {
                List<FileEntry> F = FileOp.F(CaptureMMProxy.getInstance().getAccVideoPath(), false);
                if (F != null && F.size() != 0) {
                    for (FileEntry fileEntry : F) {
                        if (fileEntry.name != null && ((fileEntry.name.contains("vsg_output_") && !fileEntry.name.contains(VideoSegmentUI.this.oDh)) || (fileEntry.name.contains("vsg_thumb_") && !fileEntry.name.contains(VideoSegmentUI.this.fwx)))) {
                            com.tencent.mm.loader.stub.b.deleteFile(fileEntry.name);
                        }
                    }
                }
            }
        }, "delete_old_temp_video_file");
        if (bi.oN(videoSegmentUI.oDh) || bi.oN(videoSegmentUI.fwx)) {
            x.e("MicroMsg.VideoSegmentUI", "Create output file failed.");
            return;
        }
        videoSegmentUI.oxX = CaptureMMProxy.getInstance().getSnsAlbumVideoTransPara();
        if (videoSegmentUI.oxX == null) {
            x.e("MicroMsg.VideoSegmentUI", "VideoTransPara not provided.");
        } else if (videoSegmentUI.oFp == null) {
            x.e("MicroMsg.VideoSegmentUI", "Please pick a video first");
        } else if (videoSegmentUI.oFu.getCount() != 0) {
            x.e("MicroMsg.VideoSegmentUI", "Not prepared right now, please try again.");
        } else {
            x.i("MicroMsg.VideoSegmentUI", "Start to process video");
            videoSegmentUI.getString(f.dGZ);
            videoSegmentUI.inI = h.a((Context) videoSegmentUI, videoSegmentUI.getString(f.dHn), false, null);
            videoSegmentUI.oFt.gI(true);
            e.post(new Runnable() {
                public final void run() {
                    boolean z = true;
                    String str = null;
                    try {
                        VideoSegmentUI.this.oFr.stop();
                        int e = VideoSegmentUI.this.hQf;
                        long Wz = bi.Wz();
                        VideoSegmentUI.this.oFq.a(VideoSegmentUI.this.oFp, VideoSegmentUI.this.oDh, VideoSegmentUI.this.oxX);
                        if (VideoSegmentUI.this.oFq.z((long) (VideoSegmentUI.this.oFt.bbF() * ((float) e)), (long) (((float) e) * VideoSegmentUI.this.oFt.bbG())) < 0) {
                            x.i("MicroMsg.VideoSegmentUI", "clip failed! %s", Integer.valueOf(VideoSegmentUI.this.oFq.z((long) (VideoSegmentUI.this.oFt.bbF() * ((float) e)), (long) (((float) e) * VideoSegmentUI.this.oFt.bbG()))));
                            ah.y(new Runnable() {
                                public final void run() {
                                    if (VideoSegmentUI.this.inI != null) {
                                        VideoSegmentUI.this.inI.dismiss();
                                    }
                                    if (VideoSegmentUI.this.oFt != null) {
                                        VideoSegmentUI.this.oFt.gI(false);
                                    }
                                    Toast.makeText(VideoSegmentUI.this, f.oEa, 1).show();
                                }
                            });
                            return;
                        }
                        Bitmap mD = com.tencent.mm.plugin.mmsight.d.mD(VideoSegmentUI.this.oDh);
                        if (mD != null) {
                            PInt pInt = new PInt();
                            PInt pInt2 = new PInt();
                            if (com.tencent.mm.plugin.mmsight.d.a(mD.getWidth(), mD.getHeight(), VideoSegmentUI.this.oxX.hwa, pInt, pInt2)) {
                                mD = Bitmap.createScaledBitmap(mD, pInt.value, pInt2.value, true);
                            }
                            x.i("MicroMsg.VideoSegmentUI", "getBitmap size = [%d, %d]", Integer.valueOf(mD.getWidth()), Integer.valueOf(mD.getHeight()));
                            com.tencent.mm.sdk.platformtools.d.a(mD, 80, CompressFormat.JPEG, VideoSegmentUI.this.fwx, true);
                            x.i("MicroMsg.VideoSegmentUI", "create video thumb. use %dms", Long.valueOf(bi.bB(Wz)));
                        } else {
                            x.e("MicroMsg.VideoSegmentUI", "getVideoThumb failed!");
                        }
                        ah.y(new Runnable() {
                            public final void run() {
                                if (VideoSegmentUI.this.inI != null) {
                                    VideoSegmentUI.this.inI.dismiss();
                                }
                                if (VideoSegmentUI.this.oFt != null) {
                                    VideoSegmentUI.this.oFt.gI(false);
                                }
                                VideoSegmentUI.a(VideoSegmentUI.this, z, str);
                            }
                        });
                    } catch (Throwable e2) {
                        Throwable th = e2;
                        str = th.getMessage();
                        x.printErrStackTrace("MicroMsg.VideoSegmentUI", th, "UnexpectedException when clip : [%s]", th.getMessage());
                        z = false;
                    }
                }
            }, "clip_video");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(FileUtils.S_IWUSR);
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.mlo));
        this.mlo.I(new Runnable() {
            public final void run() {
                x.i("MicroMsg.VideoSegmentUI", "has connect");
                if (CaptureMMProxy.getInstance() != null) {
                    q.eK(CaptureMMProxy.getInstance().getDeviceInfoConfig());
                }
                VideoSegmentUI.a(VideoSegmentUI.this);
            }
        });
    }

    protected final void initView() {
        this.oFt = (c) findViewById(com.tencent.mm.plugin.mmsight.segment.k.c.oDV);
        this.mDg = (RelativeLayout) findViewById(com.tencent.mm.plugin.mmsight.segment.k.c.cIB);
    }

    private void a(boolean z, Surface surface) {
        if (this.oFr != null) {
            x.e("MicroMsg.VideoSegmentUI", "initSegmentPlayer not null, you can not init segmentPlayer");
            return;
        }
        this.oFr = new com.tencent.mm.plugin.mmsight.segment.a.c();
        this.oFs = false;
        this.oFr.setDataSource(this.oFp);
        this.oFr.a(new com.tencent.mm.plugin.mmsight.segment.a.a.a() {
            public final boolean cT(int i, int i2) {
                x.e("MicroMsg.VideoSegmentUI", "MediaPlayer on error what = %d extra = %d", Integer.valueOf(i), Integer.valueOf(i2));
                VideoSegmentUI.this.oFx = true;
                VideoSegmentUI.this.finish();
                VideoSegmentUI.b(VideoSegmentUI.this);
                return true;
            }
        });
        if (z) {
            this.oFr.a(this.oFB);
        }
        this.oFr.setAudioStreamType(3);
        this.oFr.setLooping(true);
        if (surface != null) {
            this.oFr.setSurface(surface);
        }
        this.oFr.oFA = this.oFA;
        this.oFr.a(new com.tencent.mm.plugin.mmsight.segment.a.a.b() {
            public final void bz(Object obj) {
                x.i("MicroMsg.VideoSegmentUI", "MediaPlayer.onPrepared start %s", obj);
                try {
                    if (VideoSegmentUI.this.oFr != null) {
                        VideoSegmentUI.this.oFs = true;
                        VideoSegmentUI.this.oFr.start();
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.VideoSegmentUI", e, "hy: exception when onPrepared waiting for starting", new Object[0]);
                }
            }
        });
        this.oFr.prepareAsync();
        this.oFr.a(new com.tencent.mm.plugin.mmsight.segment.a.a.c() {
            public final void bA(Object obj) {
                try {
                    if (VideoSegmentUI.this.oFr != null) {
                        VideoSegmentUI.this.oFr.start();
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.VideoSegmentUI", e, "hy: exception when onSeekComplete waiting for starting", new Object[0]);
                }
            }
        });
    }

    protected void onResume() {
        if (this.oFr != null && this.oFs) {
            x.i("MicroMsg.VideoSegmentUI", "onResume start player");
            this.oFr.start();
        }
        super.onResume();
    }

    protected void onPause() {
        if (this.oFr != null) {
            x.i("MicroMsg.VideoSegmentUI", "onPause pause player");
            this.oFr.pause();
        }
        super.onPause();
    }

    protected void onDestroy() {
        x.i("MicroMsg.VideoSegmentUI", "onDestroy");
        super.onDestroy();
        getWindow().clearFlags(FileUtils.S_IWUSR);
        this.mlo.release();
        if (this.oFt != null) {
            this.oFt.release();
        }
        if (this.oFr != null) {
            this.oFr.release();
        }
        if (this.mSurface != null) {
            this.mSurface.release();
        }
        if (this.oFq != null) {
            this.oFq.release();
        }
        j.oAr.Ez();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.mmsight.segment.k.d.oDW;
    }
}
