package com.tencent.mm.plugin.photoedit.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.api.e;
import com.tencent.mm.api.j;
import com.tencent.mm.api.l;
import com.tencent.mm.api.m;
import com.tencent.mm.api.m.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiCreateAudioInstance;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiDestroyInstanceAudio;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetAudioState;
import com.tencent.mm.plugin.photoedit.PhotoEditProxy;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.r;
import java.util.ArrayList;

@a(19)
public class MMNewPhotoEditUI extends MMActivity implements e {
    private r jqf = null;
    private int kKY;
    private m oIZ;
    private String piV;
    private String piW;
    private String piX;
    private boolean piY;
    private boolean piZ;
    private final d pja = new d(this);
    private PhotoEditProxy pjb;
    private Dialog pjc;

    static /* synthetic */ void a(MMNewPhotoEditUI mMNewPhotoEditUI) {
        Intent intent = mMNewPhotoEditUI.getIntent();
        mMNewPhotoEditUI.piV = intent.getStringExtra("before_photo_edit");
        mMNewPhotoEditUI.piW = intent.getStringExtra("after_photo_edit");
        mMNewPhotoEditUI.kKY = intent.getIntExtra("from_scene", 0);
        mMNewPhotoEditUI.piZ = intent.getBooleanExtra("from_scene_small_preview", false);
        mMNewPhotoEditUI.piY = mMNewPhotoEditUI.pjb.isAutoSave();
    }

    static /* synthetic */ void b(MMNewPhotoEditUI mMNewPhotoEditUI, int i) {
        int i2 = 0;
        if (mMNewPhotoEditUI.kKY == JsApiDestroyInstanceAudio.CTRL_INDEX || mMNewPhotoEditUI.kKY == JsApiCreateAudioInstance.CTRL_INDEX) {
            i2 = 1;
        } else if (mMNewPhotoEditUI.kKY == 4 || mMNewPhotoEditUI.kKY == JsApiGetAudioState.CTRL_INDEX) {
            i2 = 2;
        }
        g.pWK.h(13858, Integer.valueOf(i2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(i));
        int sZ = mMNewPhotoEditUI.oIZ.sU().sZ();
        int sY = mMNewPhotoEditUI.oIZ.sU().sY();
        int ta = mMNewPhotoEditUI.oIZ.sU().ta();
        int tb = mMNewPhotoEditUI.oIZ.sU().tb();
        boolean td = mMNewPhotoEditUI.oIZ.sU().td();
        boolean te = mMNewPhotoEditUI.oIZ.sU().te();
        int tc = mMNewPhotoEditUI.oIZ.sU().tc();
        String str = "MicroMsg.MMNewPhotoEditUI";
        String str2 = "[reportPhotoEdit] emojiCount:%s,textCount:%s,mosaicCount:%s,penCount:%s,isCrop:%s,undoCount:%s,mSmallPreview:%s isRotaion:%s";
        Object[] objArr = new Object[8];
        objArr[0] = Integer.valueOf(sZ);
        objArr[1] = Integer.valueOf(sY);
        objArr[2] = Integer.valueOf(ta);
        objArr[3] = Integer.valueOf(tb);
        objArr[4] = Integer.valueOf(td ? 1 : 0);
        objArr[5] = Integer.valueOf(tc);
        objArr[6] = Integer.valueOf(mMNewPhotoEditUI.piZ ? 5 : 4);
        objArr[7] = Boolean.valueOf(te);
        x.i(str, str2, objArr);
        g gVar = g.pWK;
        objArr = new Object[11];
        objArr[0] = Integer.valueOf(0);
        objArr[1] = Integer.valueOf(1);
        objArr[2] = Integer.valueOf(sZ);
        objArr[3] = Integer.valueOf(sY);
        objArr[4] = Integer.valueOf(ta);
        objArr[5] = Integer.valueOf(tb);
        objArr[6] = Integer.valueOf(td ? 1 : 0);
        objArr[7] = Integer.valueOf(tc);
        objArr[8] = Integer.valueOf(1);
        objArr[9] = Integer.valueOf(mMNewPhotoEditUI.piZ ? 5 : 4);
        objArr[10] = Integer.valueOf(te ? 1 : 0);
        gVar.h(13857, objArr);
    }

    static /* synthetic */ void b(MMNewPhotoEditUI mMNewPhotoEditUI, String str) {
        Intent intent = new Intent();
        intent.putExtra("scene", 8);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("image_path", str);
        intent.putExtra("Retr_Msg_Type", 0);
        com.tencent.mm.bl.d.a((Context) mMNewPhotoEditUI, ".ui.transmit.SelectConversationUI", intent, 1);
    }

    static /* synthetic */ void d(MMNewPhotoEditUI mMNewPhotoEditUI, String str) {
        Object obj;
        x.i("MicroMsg.MMNewPhotoEditUI", "[gotoImagePreviewUI] :%s", str);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList stringArrayListExtra = mMNewPhotoEditUI.getIntent().getStringArrayListExtra("preview_image_list");
        ArrayList stringArrayListExtra2 = mMNewPhotoEditUI.getIntent().getStringArrayListExtra("preview_select_image_list");
        int i = 0;
        while (stringArrayListExtra != null && i < stringArrayListExtra.size()) {
            obj = (String) stringArrayListExtra.get(i);
            if (obj.equalsIgnoreCase(bi.oM(mMNewPhotoEditUI.piV)) || obj.equalsIgnoreCase(bi.oM(mMNewPhotoEditUI.piW))) {
                obj = str;
            }
            arrayList.add(obj);
            i++;
        }
        i = 0;
        while (stringArrayListExtra2 != null && i < stringArrayListExtra2.size()) {
            obj = (String) stringArrayListExtra2.get(i);
            if (obj.equalsIgnoreCase(bi.oM(mMNewPhotoEditUI.piV)) || obj.equalsIgnoreCase(bi.oM(mMNewPhotoEditUI.piW))) {
                obj = str;
            }
            arrayList2.add(obj);
            i++;
        }
        String str2 = null;
        if (!mMNewPhotoEditUI.piY) {
            str2 = mMNewPhotoEditUI.pjb.getFullPath("photoEdited_" + System.currentTimeMillis());
            k.r(str, str2, false);
        }
        FileOp.deleteFile(mMNewPhotoEditUI.piW);
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("max_select_count", mMNewPhotoEditUI.getIntent().getIntExtra("max_select_count", 9));
        intent.putExtra("isPreviewPhoto", true);
        intent.putExtra("before_photo_edit", mMNewPhotoEditUI.piV);
        intent.putExtra("after_photo_edit", str);
        intent.putExtra("tmp_photo_edit", str2);
        Bundle bundle = new Bundle();
        bundle.putString("before_photo_edit", mMNewPhotoEditUI.piV);
        bundle.putString("after_photo_edit", str);
        bundle.putInt("report_info_emotion_count", mMNewPhotoEditUI.oIZ.sU().sZ());
        bundle.putInt("report_info_text_count", mMNewPhotoEditUI.oIZ.sU().sY());
        bundle.putInt("report_info_mosaic_count", mMNewPhotoEditUI.oIZ.sU().ta());
        bundle.putInt("report_info_doodle_count", mMNewPhotoEditUI.oIZ.sU().tb());
        bundle.putBoolean("report_info_iscrop", mMNewPhotoEditUI.oIZ.sU().td());
        bundle.putInt("report_info_undo_count", mMNewPhotoEditUI.oIZ.sU().tc());
        bundle.putBoolean("report_info_is_rotation", mMNewPhotoEditUI.oIZ.sU().te());
        intent.putExtra("report_info", bundle);
        str2 = mMNewPhotoEditUI.getIntent().getStringExtra("GalleryUI_FromUser");
        String stringExtra = mMNewPhotoEditUI.getIntent().getStringExtra("GalleryUI_ToUser");
        if (!bi.oN(str2)) {
            intent.putExtra("GalleryUI_FromUser", str2);
        }
        if (!bi.oN(stringExtra)) {
            intent.putExtra("GalleryUI_ToUser", stringExtra);
        }
        intent.putStringArrayListExtra("preview_image_list", arrayList);
        intent.putStringArrayListExtra("preview_select_image_list", arrayList2);
        mMNewPhotoEditUI.setResult(-1, intent);
        mMNewPhotoEditUI.ec(false);
        mMNewPhotoEditUI.finish();
    }

    protected final int getLayoutId() {
        return R.i.dpf;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mController.i(true, 0);
        this.pjb = new PhotoEditProxy(this.pja);
        this.pja.I(new Runnable() {
            public final void run() {
                x.i("MicroMsg.MMNewPhotoEditUI", "connected!!!");
                MMNewPhotoEditUI.a(MMNewPhotoEditUI.this);
                MMNewPhotoEditUI.this.initView();
            }
        });
    }

    protected final void initView() {
        FrameLayout frameLayout = (FrameLayout) findViewById(R.h.content);
        this.oIZ = m.fdT.sV();
        m mVar = this.oIZ;
        m.a.a aVar = new m.a.a();
        boolean z = (this.kKY == JsApiCreateAudioInstance.CTRL_INDEX || this.kKY == JsApiGetAudioState.CTRL_INDEX) ? false : true;
        aVar.fdV = z;
        aVar.fdX = true;
        aVar.fdU = c.fea;
        aVar.path = this.piV;
        mVar.a(aVar.th());
        View ai = this.oIZ.ai(this.mController.xRr);
        ai.a(this);
        frameLayout.addView(ai, new LayoutParams(-1, -1));
        ai.fdI = new l() {
            public final void a(com.tencent.mm.api.d dVar) {
                x.i("MicroMsg.MMNewPhotoEditUI", "[onSelectedFeature] features:%s", dVar.name());
            }

            public final void a(com.tencent.mm.api.d dVar, int i) {
                x.i("MicroMsg.MMNewPhotoEditUI", "[onSelectedDetailFeature] features:%s index:%s", dVar.name(), Integer.valueOf(i));
            }

            public final void aF(boolean z) {
                if (z) {
                    MMNewPhotoEditUI.this.showVKB();
                } else {
                    MMNewPhotoEditUI.this.df(MMNewPhotoEditUI.this.mController.contentView);
                }
            }
        };
    }

    protected void onDestroy() {
        super.onDestroy();
        this.oIZ.onDestroy();
        this.pja.release();
    }

    public void onBackPressed() {
        if (!this.oIZ.sT()) {
            if (this.kKY == JsApiDestroyInstanceAudio.CTRL_INDEX || this.kKY == JsApiCreateAudioInstance.CTRL_INDEX) {
                g.pWK.h(13859, Integer.valueOf(1), Integer.valueOf(2));
            } else if (this.kKY == 4 || this.kKY == JsApiGetAudioState.CTRL_INDEX) {
                g.pWK.h(13859, Integer.valueOf(2), Integer.valueOf(2));
            } else {
                g.pWK.h(13859, Integer.valueOf(0), Integer.valueOf(2));
            }
            finish();
        }
    }

    public final void onFinish() {
        if (this.kKY == JsApiDestroyInstanceAudio.CTRL_INDEX || this.kKY == JsApiCreateAudioInstance.CTRL_INDEX) {
            g.pWK.h(13859, Integer.valueOf(1), Integer.valueOf(1));
        } else if (this.kKY == 4 || this.kKY == JsApiGetAudioState.CTRL_INDEX) {
            g.pWK.h(13859, Integer.valueOf(2), Integer.valueOf(1));
        } else {
            g.pWK.h(13859, Integer.valueOf(0), Integer.valueOf(1));
        }
        if (this.kKY == JsApiCreateAudioInstance.CTRL_INDEX || this.kKY == JsApiGetAudioState.CTRL_INDEX) {
            com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(this.mController.xRr);
            lVar.rQF = new p.c() {
                public final void a(n nVar) {
                    nVar.f(0, MMNewPhotoEditUI.this.getString(R.l.eET));
                    nVar.f(1, MMNewPhotoEditUI.this.getString(R.l.eAq));
                    nVar.f(2, MMNewPhotoEditUI.this.getString(R.l.eHr));
                }
            };
            lVar.rQG = new p.d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    MMNewPhotoEditUI.this.uT(i);
                }
            };
            h.a(this.mController.xRr, lVar.bCH());
            return;
        }
        uT(-1);
    }

    public final void sX() {
        onBackPressed();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1 && intent != null) {
            x.d("MicroMsg.MMNewPhotoEditUI", "select %s for sending imagePath:%s", intent.getStringExtra("Select_Conv_User"), this.piX);
            this.pjc = h.a(this.mController.xRr, getString(R.l.eAn), false, null);
            this.pjb.sendImage(intent.getStringExtra("custom_send_text"), this.piX, this.pjb.getSelfUsername(), r0);
            this.pjc.dismiss();
            if (this.piY) {
                com.tencent.mm.platformtools.d.b(this.piX, this);
            } else {
                FileOp.deleteFile(this.piX);
            }
            finish();
        } else if (intent == null && !bi.oN(this.piX) && this.kKY == JsApiCreateAudioInstance.CTRL_INDEX) {
            FileOp.deleteFile(this.piX);
        }
    }

    private void uT(final int i) {
        ec(true);
        this.oIZ.a(new j() {
            public final void b(Exception exception) {
                MMNewPhotoEditUI.this.ec(false);
                x.e("MicroMsg.MMNewPhotoEditUI", "[onRefreshed] %s", exception);
                Toast.makeText(MMNewPhotoEditUI.this, MMNewPhotoEditUI.this.getResources().getString(R.l.ecv), 1).show();
                MMNewPhotoEditUI.this.setResult(0);
                MMNewPhotoEditUI.this.finish();
            }

            public final void a(Bitmap bitmap, boolean z) {
                x.i("MicroMsg.MMNewPhotoEditUI", "[onSuccess] w:%s h:%s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                try {
                    String oF = com.tencent.mm.platformtools.d.oF("jpg");
                    com.tencent.mm.sdk.platformtools.d.a(bitmap, 100, CompressFormat.PNG, oF, true);
                    x.i("MicroMsg.MMNewPhotoEditUI", "[onSuccess] photoPath:%s", oF);
                    if (MMNewPhotoEditUI.this.piY) {
                        com.tencent.mm.platformtools.d.b(oF, MMNewPhotoEditUI.this);
                    }
                    if (!(i == 0 || bitmap.isRecycled())) {
                        bitmap.recycle();
                    }
                    MMNewPhotoEditUI.this.piX = oF;
                    if (MMNewPhotoEditUI.this.kKY != JsApiCreateAudioInstance.CTRL_INDEX && MMNewPhotoEditUI.this.kKY != JsApiGetAudioState.CTRL_INDEX) {
                        MMNewPhotoEditUI.d(MMNewPhotoEditUI.this, oF);
                    } else if (i == 0) {
                        MMNewPhotoEditUI.b(MMNewPhotoEditUI.this, oF);
                        MMNewPhotoEditUI.this.ec(false);
                        MMNewPhotoEditUI.b(MMNewPhotoEditUI.this, 1);
                    } else if (i == 1) {
                        MMNewPhotoEditUI.this.pjb.doFav(oF);
                        MMNewPhotoEditUI.b(MMNewPhotoEditUI.this, 2);
                        Toast.makeText(MMNewPhotoEditUI.this.mController.xRr, MMNewPhotoEditUI.this.getString(R.l.eeP), 1).show();
                        MMNewPhotoEditUI.this.ec(false);
                        MMNewPhotoEditUI.this.finish();
                    } else if (i == 2) {
                        Toast.makeText(MMNewPhotoEditUI.this.mController.xRr, MMNewPhotoEditUI.this.getString(R.l.eeh, new Object[]{com.tencent.mm.compatible.util.e.gJf}), 1).show();
                        MMNewPhotoEditUI.b(MMNewPhotoEditUI.this, 3);
                        MMNewPhotoEditUI.this.ec(false);
                        MMNewPhotoEditUI.this.finish();
                    }
                } catch (Exception e) {
                    b(e);
                }
            }
        });
    }

    private void ec(boolean z) {
        x.i("MicroMsg.MMNewPhotoEditUI", "[setProgress] isVisible:%s", Boolean.valueOf(z));
        if (z) {
            this.jqf = r.b(this, getString(R.l.eid), true, 0, null);
        } else if (this.jqf != null && this.jqf.isShowing()) {
            this.jqf.dismiss();
            this.jqf = null;
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
