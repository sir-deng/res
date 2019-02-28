package com.tencent.mm.plugin.mmsight.segment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Toast;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.ui.VideoSeekBarEditorView;
import com.tencent.mm.plugin.u.a.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.a;

@a(3)
public class MMSightEditUI extends MMActivity {
    private String fwx;
    private d mlo = new d(ad.getContext());
    private ViewGroup oDd;
    private VideoPlayerTextureView oDe;
    private VideoSeekBarEditorView oDf;
    private com.tencent.mm.plugin.mmsight.ui.a oDg;
    private String oDh;
    private boolean oDi = false;
    private boolean oDj = false;
    private f.a oDk = new f.a() {
        public final void onError(int i, int i2) {
            x.e("MicroMsg.MMSightEditUI", "%d on error what %d extra %d", Integer.valueOf(MMSightEditUI.this.hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
        }

        public final void hY() {
            if (MMSightEditUI.this.oDe != null) {
                MMSightEditUI.this.oDe.start();
                MMSightEditUI.this.oDe;
                MMSightEditUI.this.oDe.setAlpha(1.0f);
                ah.h(new Runnable() {
                    public final void run() {
                        MMSightEditUI.i(MMSightEditUI.this);
                    }
                }, 300);
            }
        }

        public final void vi() {
            MMSightEditUI.this.oDe.c(0.0d, true);
        }

        public final int ck(int i, int i2) {
            return 0;
        }

        public final void cl(int i, int i2) {
        }
    };
    private VideoTransPara oxX;
    private String videoPath;

    static /* synthetic */ void a(MMSightEditUI mMSightEditUI) {
        if (MMActivity.ft(mMSightEditUI)) {
            mMSightEditUI.cnM();
            mMSightEditUI.Ek(0);
        }
        mMSightEditUI.oDd = (ViewGroup) mMSightEditUI.findViewById(com.tencent.mm.plugin.u.a.d.cIB);
        mMSightEditUI.oDe = (VideoPlayerTextureView) mMSightEditUI.findViewById(com.tencent.mm.plugin.u.a.d.oKy);
        mMSightEditUI.oDf = (VideoSeekBarEditorView) mMSightEditUI.findViewById(com.tencent.mm.plugin.u.a.d.oKz);
        mMSightEditUI.videoPath = mMSightEditUI.getIntent().getStringExtra("key_video_path");
        mMSightEditUI.oxX = (VideoTransPara) mMSightEditUI.getIntent().getParcelableExtra("key_video_para");
        mMSightEditUI.oDi = mMSightEditUI.getIntent().getBooleanExtra("key_need_clip_video_first", false);
        if (bi.oN(mMSightEditUI.videoPath)) {
            x.e("MicroMsg.MMSightEditUI", "error!, videoPath is null!!");
            return;
        }
        if (mMSightEditUI.oxX == null) {
            x.e("MicroMsg.MMSightEditUI", "videoTransPara is null!, use SnsAlbumVideoTransPara");
            mMSightEditUI.oxX = CaptureMMProxy.getInstance().getSnsAlbumVideoTransPara();
        }
        x.i("MicroMsg.MMSightEditUI", "videoTransPara: %s", mMSightEditUI.oxX);
        mMSightEditUI.oDe.setAlpha(0.0f);
        mMSightEditUI.oDe.setVideoPath(mMSightEditUI.videoPath);
        mMSightEditUI.oDe.cdw();
        mMSightEditUI.oDe.qAJ = mMSightEditUI.oDk;
        mMSightEditUI.oDh = CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_output_" + System.currentTimeMillis() + ".mp4";
        mMSightEditUI.fwx = CaptureMMProxy.getInstance().getAccVideoPath() + "vsg_thumb_" + System.currentTimeMillis() + ".jpg";
        if (ae.fz(mMSightEditUI)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) mMSightEditUI.oDf.getLayoutParams();
            marginLayoutParams.bottomMargin += ae.fy(mMSightEditUI);
            mMSightEditUI.oDf.setLayoutParams(marginLayoutParams);
        }
    }

    static /* synthetic */ void i(MMSightEditUI mMSightEditUI) {
        mMSightEditUI.oDg = new com.tencent.mm.plugin.mmsight.ui.a();
        mMSightEditUI.oDg.oHt = true;
        mMSightEditUI.oDg.oHx = 2;
        mMSightEditUI.oDg.oHr = new com.tencent.mm.plugin.mmsight.ui.a.a() {
            public final void bbK() {
                x.i("MicroMsg.MMSightEditUI", "onEditFinish");
                try {
                    MMSightEditUI.this.oDj = true;
                    if (MMSightEditUI.this.oDg != null) {
                        MMSightEditUI.this.oDg.gN(false);
                        MMSightEditUI.this.oDg.release();
                        MMSightEditUI.this.oDg = null;
                    }
                    Bitmap mD = com.tencent.mm.plugin.mmsight.d.mD(MMSightEditUI.this.oDh);
                    if (mD != null) {
                        PInt pInt = new PInt();
                        PInt pInt2 = new PInt();
                        if (com.tencent.mm.plugin.mmsight.d.a(mD.getWidth(), mD.getHeight(), MMSightEditUI.this.oxX.hwa, pInt, pInt2)) {
                            mD = Bitmap.createScaledBitmap(mD, pInt.value, pInt2.value, true);
                        }
                        x.i("MicroMsg.MMSightEditUI", "getBitmap size = [%d, %d]", Integer.valueOf(mD.getWidth()), Integer.valueOf(mD.getHeight()));
                        com.tencent.mm.sdk.platformtools.d.a(mD, 80, CompressFormat.JPEG, MMSightEditUI.this.fwx, true);
                        Intent intent = new Intent();
                        intent.putExtra("K_SEGMENTVIDEOPATH", MMSightEditUI.this.oDh);
                        intent.putExtra("KSEGMENTVIDEOTHUMBPATH", MMSightEditUI.this.fwx);
                        MMSightEditUI.this.setResult(-1, intent);
                        MMSightEditUI.this.finish();
                        return;
                    }
                    x.e("MicroMsg.MMSightEditUI", "getVideoThumb failed!");
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MMSightEditUI", e, "save video thumb error", new Object[0]);
                    Toast.makeText(MMSightEditUI.this, com.tencent.mm.plugin.u.a.f.oEa, 1).show();
                    MMSightEditUI.this.finish();
                }
            }

            public final void bbL() {
                x.i("MicroMsg.MMSightEditUI", "onExitEdit");
                if (MMSightEditUI.this.oDg != null) {
                    MMSightEditUI.this.oDg.gN(true);
                    MMSightEditUI.this.oDg.release();
                    MMSightEditUI.this.oDg = null;
                }
                MMSightEditUI.this.finish();
            }

            public final void onError() {
                if (MMSightEditUI.this.oDg != null) {
                    MMSightEditUI.this.oDg.release();
                    MMSightEditUI.this.oDg = null;
                }
                ah.y(new Runnable() {
                    public final void run() {
                        Toast.makeText(MMSightEditUI.this, com.tencent.mm.plugin.u.a.f.oEa, 1).show();
                    }
                });
            }
        };
        mMSightEditUI.oDg.oHw = mMSightEditUI.oDh;
        mMSightEditUI.oDg.a(mMSightEditUI, WXMediaMessage.TITLE_LENGTH_LIMIT, mMSightEditUI.videoPath, mMSightEditUI.oDf, mMSightEditUI.oDe, mMSightEditUI.oDd, mMSightEditUI.oxX, mMSightEditUI.oDi);
    }

    public void onCreate(Bundle bundle) {
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().addFlags(2097280);
        if (com.tencent.mm.compatible.util.d.fN(19)) {
            getWindow().setFlags(201327616, 201327616);
            com.tencent.mm.plugin.mmsight.d.gF(true);
        } else {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            com.tencent.mm.plugin.mmsight.d.gF(false);
        }
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.mlo));
        final long Wz = bi.Wz();
        this.mlo.I(new Runnable() {
            public final void run() {
                x.i("MicroMsg.MMSightEditUI", "connect cost %sms", Long.valueOf(bi.bB(Wz)));
                if (CaptureMMProxy.getInstance() != null) {
                    q.eK(CaptureMMProxy.getInstance().getDeviceInfoConfig());
                }
                MMSightEditUI.a(MMSightEditUI.this);
            }
        });
    }

    protected final int getLayoutId() {
        return e.oKE;
    }

    protected final int getForceOrientation() {
        return 1;
    }

    public void onBackPressed() {
        if (this.oDg == null || !this.oDg.aeX()) {
            super.onBackPressed();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.oDe != null) {
            this.oDe.pause();
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.oDe != null) {
            this.oDe.start();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.oDe != null) {
            this.oDe.stop();
        }
        if (this.oDg != null) {
            if (this.oDj) {
                com.tencent.mm.plugin.mmsight.a.a.a(new com.tencent.mm.plugin.mmsight.a.a.a(this.oDg.scene));
            }
            this.oDg.release();
        }
    }
}
