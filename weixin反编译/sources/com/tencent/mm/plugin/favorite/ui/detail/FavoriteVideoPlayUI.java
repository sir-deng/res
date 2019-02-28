package com.tencent.mm.plugin.favorite.ui.detail;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.ui.base.FavVideoView;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.y.as;
import com.tencent.mm.y.s;
import com.tencent.wcdb.FileUtils;
import java.io.File;

@a(3)
public class FavoriteVideoPlayUI extends MMActivity {
    private boolean fCQ = true;
    private String fwx;
    private String hFn;
    private Bundle kXK;
    private boolean kXL = false;
    private g kXM;
    private int kXN = 0;
    private int kXO = 0;
    private int kXP = 0;
    private int kXQ = 0;
    private String mBr = "";
    private boolean mCM = true;
    private OnLongClickListener mCu = new OnLongClickListener() {
        public final boolean onLongClick(View view) {
            view.getTag();
            l lVar = new l(FavoriteVideoPlayUI.this.mController.xRr);
            lVar.rQF = new c() {
                public final void a(n nVar) {
                    if (FavoriteVideoPlayUI.this.mDk) {
                        if (e.bO(FavoriteVideoPlayUI.this.fwx)) {
                            nVar.add(0, 1, 0, FavoriteVideoPlayUI.this.getString(R.l.egM));
                        }
                        nVar.add(0, 2, 0, FavoriteVideoPlayUI.this.getString(R.l.dSd));
                    }
                }
            };
            lVar.rQG = new d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    switch (menuItem.getItemId()) {
                        case 1:
                            Intent intent = new Intent();
                            intent.putExtra("Select_Conv_Type", 3);
                            intent.putExtra("select_is_ret", true);
                            intent.putExtra("mutil_select_is_ret", true);
                            if (e.bO(FavoriteVideoPlayUI.this.fwx)) {
                                intent.putExtra("image_path", FavoriteVideoPlayUI.this.fwx);
                            } else {
                                intent.putExtra("image_path", FavoriteVideoPlayUI.this.hFn);
                            }
                            intent.putExtra("Retr_Msg_Type", 1);
                            com.tencent.mm.bl.d.a(FavoriteVideoPlayUI.this.mController.xRr, ".ui.transmit.SelectConversationUI", intent, 1);
                            if (FavoriteVideoPlayUI.this.mDl == 0) {
                                com.tencent.mm.plugin.report.service.g.pWK.h(10651, Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(0));
                                return;
                            }
                            return;
                        case 2:
                            j.e(FavoriteVideoPlayUI.this.hFn, FavoriteVideoPlayUI.this);
                            return;
                        default:
                            return;
                    }
                }
            };
            lVar.bCH();
            return true;
        }
    };
    private int mDe;
    private String mDf;
    private RelativeLayout mDg;
    private ImageView mDh;
    private FavVideoView mDi;
    private LinearLayout mDj;
    private boolean mDk = true;
    private int mDl;
    private boolean mDm = false;
    private OnClickListener myR = new OnClickListener() {
        public final void onClick(View view) {
            FavoriteVideoPlayUI.this.awC();
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.hideTitleView();
        if (com.tencent.mm.compatible.util.d.fN(19)) {
            getWindow().setFlags(201327616, 201327616);
        } else {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        this.kXK = bundle;
        getWindow().addFlags(FileUtils.S_IWUSR);
        this.mDk = getIntent().getBooleanExtra("key_detail_data_valid", true);
        this.hFn = getIntent().getStringExtra("key_detail_fav_path");
        this.fwx = getIntent().getStringExtra("key_detail_fav_thumb_path");
        this.mDe = getIntent().getIntExtra("key_detail_fav_video_duration", 0);
        this.mDf = getIntent().getStringExtra("key_detail_statExtStr");
        this.mDl = getIntent().getIntExtra("key_detail_fav_video_scene_from", 0);
        this.fCQ = getIntent().getBooleanExtra("show_share", true);
        this.mDm = getIntent().getBooleanExtra("key_detail_fav_video_show_download_status", false);
        this.mBr = getIntent().getStringExtra("key_detail_data_id");
        if (!e.bO(this.fwx)) {
            Bitmap RX = com.tencent.mm.pluginsdk.model.c.RX(this.hFn);
            if (RX != null) {
                try {
                    x.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: create thumbpath bitmap, saveBitmapToImage ");
                    com.tencent.mm.pluginsdk.k.e.a(RX, CompressFormat.JPEG, this.fwx);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.FavoriteVideoPlayUI", e, "", new Object[0]);
                }
            }
        }
        String str = "MicroMsg.FavoriteVideoPlayUI";
        String str2 = "VideoPlay: init data, isVideoValid: %B. thumbPath: %s, fullPath: %s";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(this.mDk);
        objArr[1] = bi.oN(this.fwx) ? "" : this.fwx;
        objArr[2] = bi.oN(this.hFn) ? "" : this.hFn;
        x.i(str, str2, objArr);
        this.mDg = (RelativeLayout) findViewById(R.h.cVI);
        this.mDi = (FavVideoView) findViewById(R.h.cVJ);
        ImageView imageView = (ImageView) findViewById(R.h.cVD);
        this.mDh = (ImageView) findViewById(R.h.ckx);
        this.mDj = (LinearLayout) findViewById(R.h.cgG);
        if (!(this.mDk || this.mDj == null)) {
            this.mDj.setVisibility(0);
        }
        if (this.mDh != null) {
            this.mDh.setLayerType(2, null);
        }
        if (bi.oN(this.hFn)) {
            b(imageView);
        } else if (FileOp.bO(this.hFn)) {
            this.mDi.hFn = this.hFn;
            x.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay:  videoView.setVideoData(fullPath)");
        } else {
            b(imageView);
        }
        this.mDi.setOnClickListener(this.myR);
        if (this.fCQ) {
            this.mDi.setOnLongClickListener(this.mCu);
        }
        this.kXM = new g(null);
    }

    protected final int getLayoutId() {
        return R.i.dhX;
    }

    private void b(ImageView imageView) {
        FavVideoView favVideoView = this.mDi;
        String str = this.hFn;
        boolean z = this.mDm;
        String str2 = this.mBr;
        favVideoView.hFn = str;
        if (z) {
            favVideoView.kXJ.post(new Runnable() {
                public final void run() {
                    if (!(FavVideoView.this.mBp == null || FavVideoView.this.mBp.getVisibility() == 0)) {
                        FavVideoView.this.mBp.setVisibility(0);
                    }
                    if (FavVideoView.this.mBq != null && FavVideoView.this.mBq.getVisibility() != 8) {
                        FavVideoView.this.mBq.setVisibility(8);
                    }
                }
            });
            favVideoView.mBr = str2;
        }
        if (imageView != null) {
            if (e.bO(this.fwx)) {
                imageView.setImageBitmap(b.b(this.fwx, 1.0f));
            } else {
                imageView.setImageResource(R.g.bAR);
            }
        }
        x.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: fullPath is not null,but not exist videoView.setVideoData(null)");
    }

    public void onStart() {
        Bundle bundle = this.kXK;
        if (!this.kXL) {
            this.kXL = true;
            if (VERSION.SDK_INT >= 12) {
                this.kXN = getIntent().getIntExtra("img_gallery_top", 0);
                this.kXO = getIntent().getIntExtra("img_gallery_left", 0);
                this.kXP = getIntent().getIntExtra("img_gallery_width", 0);
                this.kXQ = getIntent().getIntExtra("img_gallery_height", 0);
                this.kXM.r(this.kXO, this.kXN, this.kXP, this.kXQ);
                if (bundle == null) {
                    this.mDi.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                        public final boolean onPreDraw() {
                            FavoriteVideoPlayUI.this.mDi.getViewTreeObserver().removeOnPreDrawListener(this);
                            FavoriteVideoPlayUI.this.kXM.a(FavoriteVideoPlayUI.this.mDi, FavoriteVideoPlayUI.this.mDh, new g.b() {
                                public final void onAnimationStart() {
                                    if (FavoriteVideoPlayUI.this.mDi != null) {
                                        FavoriteVideoPlayUI.this.mDi.onResume();
                                    }
                                }

                                public final void onAnimationEnd() {
                                }
                            });
                            return true;
                        }
                    });
                }
            }
        }
        super.onStart();
    }

    protected void onResume() {
        if (VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(2048);
        }
        x.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay:  onResume,hadOnStart is %B", Boolean.valueOf(this.mCM));
        if (!this.mCM) {
            this.mDi.onResume();
        }
        this.mCM = false;
        super.onResume();
    }

    protected void onPause() {
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(2048, 2048);
        }
        FavVideoView favVideoView = this.mDi;
        x.i("MicroMsg.FavVideoView", "VideoPlay:   onPause()");
        if (favVideoView.kYP.isPlaying()) {
            x.i("MicroMsg.FavVideoView", "VideoPlay: pausePlay()");
            favVideoView.kYP.pause();
        }
        super.onPause();
    }

    protected void onDestroy() {
        setResult(0, getIntent().putExtra("key_activity_browse_time", cnN()));
        FavVideoView favVideoView = this.mDi;
        x.i("MicroMsg.FavVideoView", "VideoPlay:   onDestroy()");
        favVideoView.kYP.stop();
        ((com.tencent.mm.plugin.record.a.a) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(favVideoView.mBt);
        ((r) com.tencent.mm.kernel.g.k(r.class)).getFavCdnStorage().b(favVideoView.mBt);
        getWindow().clearFlags(FileUtils.S_IWUSR);
        super.onDestroy();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && -1 == i2) {
            String str;
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            if (intent == null) {
                str = null;
            } else {
                str = intent.getStringExtra("custom_send_text");
            }
            final Dialog a = h.a(this.mController.xRr, getString(R.l.efM), false, null);
            Runnable anonymousClass3 = new Runnable() {
                public final void run() {
                    a.dismiss();
                }
            };
            if (!bi.oN(stringExtra)) {
                for (String stringExtra2 : bi.F(stringExtra2.split(","))) {
                    Context context = this.mController.xRr;
                    String str2 = this.hFn;
                    String str3 = this.fwx;
                    int i3 = this.mDe;
                    String str4 = this.mDf;
                    if (context == null) {
                        x.w("MicroMsg.FavSendLogic", "want to send fav video, but context is null");
                    } else if (bi.oN(stringExtra2)) {
                        x.w("MicroMsg.FavSendLogic", "want to send fav video, but to user is null");
                    } else {
                        File file = new File(str2);
                        if (!bi.oN(str2) || file.exists()) {
                            as.Dt().F(new com.tencent.mm.plugin.favorite.a.e.AnonymousClass5(context, stringExtra2, str2, str3, i3, str4, anonymousClass3));
                        } else {
                            x.w("MicroMsg.FavSendLogic", "want to send fav video, but datapath is null or is not exist ");
                        }
                    }
                    if (!bi.oN(str)) {
                        f.aZN().C(stringExtra2, str, s.hs(stringExtra2));
                    }
                }
                com.tencent.mm.ui.snackbar.a.h(this, getString(R.l.eip));
                return;
            }
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void awC() {
        this.mDj.setVisibility(8);
        int width = this.mDg.getWidth();
        int height = this.mDg.getHeight();
        if (!(this.kXP == 0 || this.kXQ == 0)) {
            height = (int) ((((float) width) / ((float) this.kXP)) * ((float) this.kXQ));
        }
        this.kXM.fj(width, height);
        this.kXM.r(this.kXO, this.kXN, this.kXP, this.kXQ);
        this.kXM.a(this.mDi, this.mDh, new g.b() {
            public final void onAnimationStart() {
            }

            public final void onAnimationEnd() {
                new ag().post(new Runnable() {
                    public final void run() {
                        FavoriteVideoPlayUI.this.finish();
                        FavoriteVideoPlayUI.this.overridePendingTransition(0, 0);
                    }
                });
            }
        }, null);
    }

    public void onBackPressed() {
        awC();
    }
}
