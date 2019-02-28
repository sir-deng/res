package com.tencent.mm.plugin.gallery.ui;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiDestroyInstanceAudio;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.m;
import com.tencent.mm.plugin.gallery.stub.GalleryStubService;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.MMViewPager;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

@a(19)
@TargetApi(16)
public class ImagePreviewUI extends MMActivity {
    private ServiceConnection lwY = new ServiceConnection() {
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            x.d("MicroMsg.ImagePreviewUI", "onServiceConnected");
            ImagePreviewUI.this.mXv = com.tencent.mm.plugin.gallery.stub.a.a.Q(iBinder);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            x.d("MicroMsg.ImagePreviewUI", "onServiceDisconnected");
            ImagePreviewUI.this.mXv = null;
        }
    };
    private com.tencent.mm.plugin.gallery.stub.a mXv = null;
    private ArrayList<MediaItem> mXw;
    private HashMap<String, Integer> mYA = new HashMap();
    private boolean mYT;
    private TextView mYc;
    private boolean mYi = true;
    private boolean mYm;
    private int mYp;
    private long mYu = 0;
    private ArrayList<String> mZA;
    private ArrayList<String> mZB;
    private Integer mZC;
    private ImageButton mZD;
    private TextView mZE;
    private al mZF;
    private ImageButton mZG;
    private TextView mZH;
    private ViewGroup mZI;
    private ViewGroup mZJ;
    private boolean mZK = true;
    private boolean mZL = true;
    private int mZM = 0;
    private TextView mZN;
    private TextView mZO;
    private TextView mZP;
    private TextView mZQ;
    private View mZR;
    private TextView mZS;
    private ProgressBar mZT;
    boolean mZU = false;
    private HashSet<String> mZV;
    private c mZx;
    private MMViewPager mZy;
    private RecyclerView mZz;

    static /* synthetic */ void a(ImagePreviewUI imagePreviewUI, int i) {
        MediaItem qQ = imagePreviewUI.mZx.qQ(i);
        if (qQ != null) {
            imagePreviewUI.c(qQ);
        }
    }

    static /* synthetic */ void a(ImagePreviewUI imagePreviewUI, final int i, String str) {
        if (str != null) {
            f fVar = (f) imagePreviewUI.mZz.fn();
            if (imagePreviewUI.mYT) {
                final int indexOf = imagePreviewUI.mZB.contains(str) ? imagePreviewUI.mZB.indexOf(str) : -1;
                x.i("MicroMsg.ImagePreviewUI", "[notifyRecycleViewWhenPageSelected] :%s indexInBar:%s %s", Integer.valueOf(i), Integer.valueOf(indexOf), Boolean.valueOf(imagePreviewUI.mYT));
                fVar.cI(indexOf, i);
                fVar.UR.notifyChanged();
                if (indexOf != -1) {
                    imagePreviewUI.mZz.postDelayed(new Runnable() {
                        public final void run() {
                            ImagePreviewUI.this.mZz.smoothScrollToPosition(indexOf);
                        }
                    }, 66);
                    return;
                }
                return;
            }
            x.i("MicroMsg.ImagePreviewUI", "[notifyRecycleViewWhenPageSelected] :%s %s", Integer.valueOf(i), imagePreviewUI.mZC);
            fVar.cI(i, i);
            fVar.b(imagePreviewUI.mZC.intValue(), new Object());
            fVar.b(i, new Object());
            imagePreviewUI.mZz.postDelayed(new Runnable() {
                public final void run() {
                    ImagePreviewUI.this.mZz.smoothScrollToPosition(i);
                }
            }, 66);
        }
    }

    static /* synthetic */ void a(ImagePreviewUI imagePreviewUI, Intent intent, boolean z, boolean z2) {
        intent.putExtra("CropImage_Compress_Img", z ? true : z2);
        ArrayList aPe = imagePreviewUI.aPe();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (aPe == null || aPe.size() <= 0) {
            x.i("MicroMsg.ImagePreviewUI", "no img selected. keep current ui.");
            return;
        }
        Iterator it = aPe.iterator();
        while (it.hasNext()) {
            Object obj = (String) it.next();
            MediaItem BY = c.BY(obj);
            if (BY == null || BY.getType() != 2) {
                if (!(BY == null || BY.getType() == 2 || !BY.mMimeType.equals("edit") || bi.oN(BY.mWQ))) {
                    obj = BY.mWQ;
                }
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        if (z && arrayList.size() == 0 && arrayList2.size() == 1) {
            MediaItem BY2 = c.BY((String) arrayList2.get(0));
            if (BY2 == null || !(BY2 instanceof VideoMediaItem) || ((VideoMediaItem) BY2).hQf == -1) {
                x.e("MicroMsg.ImagePreviewUI", "dealWithSend VideoMediaItem not found.");
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("K_SEGMENTVIDEOPATH", BY2.hQc);
                intent2.putExtra("KSEGMENTVIDEOTHUMBPATH", BY2.mqO);
                d.b(imagePreviewUI, "mmsight", ".segment.VideoCompressUI", intent2, 4371);
                return;
            }
        }
        intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList);
        intent.putStringArrayListExtra("key_select_video_list", arrayList2);
        boolean booleanExtra = imagePreviewUI.getIntent().getBooleanExtra("isTakePhoto", false);
        if (booleanExtra && imagePreviewUI.aPe().size() > 0) {
            Parcelable Vp = ExifHelper.Vp((String) imagePreviewUI.aPe().get(0));
            Intent intent3 = new Intent(imagePreviewUI, ImagePreviewUI.class);
            x.d("MicroMsg.ImagePreviewUI", "findlatlng %s", r0);
            if (Vp != null) {
                x.d("MicroMsg.ImagePreviewUI", "findlatlng %f %f", Float.valueOf(Vp.fAo), Float.valueOf(Vp.hDw));
                intent3.putExtra("KlatLng", Vp);
            }
        }
        x.d("MicroMsg.ImagePreviewUI", "summersafecdn send image, previewImageCount:%d, chooseForTimeline:%b, forTimeline:%b, beCompress:%b", Integer.valueOf(c.aOs()), Boolean.valueOf(imagePreviewUI.mYi), Boolean.valueOf(z), Boolean.valueOf(z2));
        try {
            imagePreviewUI.mXv.ap(11610, (imagePreviewUI.mYi ? 3 : 2) + "," + c.aOs());
        } catch (Throwable e) {
            x.e("MicroMsg.ImagePreviewUI", "report error, %s", e.getMessage());
            x.printErrStackTrace("MicroMsg.ImagePreviewUI", e, "", new Object[0]);
        }
        c.aOr();
        x.d("MicroMsg.ImagePreviewUI", "isTaskPhoto ? " + booleanExtra + " | isPreviewPhoto ? " + intent.getBooleanExtra("isPreviewPhoto", false));
        intent.putExtra("isTakePhoto", booleanExtra);
        String stringExtra = imagePreviewUI.getIntent().getStringExtra("GalleryUI_ToUser");
        if (bi.oN(imagePreviewUI.getIntent().getStringExtra("GalleryUI_FromUser")) || "medianote".equals(stringExtra)) {
            imagePreviewUI.setResult(-1, intent);
            imagePreviewUI.finish();
        } else if (bi.Wz() - imagePreviewUI.mYu < 1000) {
            x.w("MicroMsg.ImagePreviewUI", "sendimg btn event frequence limit");
        } else {
            imagePreviewUI.mYu = bi.Wz();
            x.i("MicroMsg.ImagePreviewUI", "switch to SendImgProxyUI");
            intent.setClassName(imagePreviewUI, "com.tencent.mm.ui.chatting.SendImgProxyUI");
            intent.putExtra("GalleryUI_FromUser", imagePreviewUI.getIntent().getStringExtra("GalleryUI_FromUser"));
            intent.putExtra("GalleryUI_ToUser", imagePreviewUI.getIntent().getStringExtra("GalleryUI_ToUser"));
            intent.putExtra("CropImage_limit_Img_Size", 26214400);
            imagePreviewUI.startActivityForResult(intent, 4369);
        }
    }

    static /* synthetic */ void a(ImagePreviewUI imagePreviewUI, boolean z) {
        if (z) {
            imagePreviewUI.fullScreenNoTitleBar(false);
            imagePreviewUI.fw(z);
            imagePreviewUI.fx(true);
            return;
        }
        imagePreviewUI.fullScreenNoTitleBar(true);
        imagePreviewUI.fw(z);
        imagePreviewUI.fx(false);
    }

    static /* synthetic */ void n(ImagePreviewUI imagePreviewUI) {
        String str;
        String stringExtra = imagePreviewUI.getIntent().getStringExtra("GalleryUI_FromUser");
        String stringExtra2 = imagePreviewUI.getIntent().getStringExtra("GalleryUI_ToUser");
        Intent intent = new Intent();
        x.i("MicroMsg.ImagePreviewUI", "edit image path:%s mPosition:%s", imagePreviewUI.mZx.kF(imagePreviewUI.mZC.intValue()), imagePreviewUI.mZC);
        intent.putExtra("GalleryUI_FromUser", stringExtra);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        intent.putExtra("from_scene", c.aOl().aOO());
        intent.putExtra("preview_image_list", ((f) imagePreviewUI.mZz.fn()).nah);
        if (c.aOl().aOO() == 4) {
            intent.putExtra("from_scene", 289);
        } else if (c.aOl().aOO() == 3) {
            intent.putExtra("from_scene", JsApiDestroyInstanceAudio.CTRL_INDEX);
        }
        intent.putExtra("preview_select_image_list", imagePreviewUI.mZB);
        MediaItem qQ = imagePreviewUI.mZx.qQ(imagePreviewUI.mZC.intValue());
        if (qQ != null) {
            x.i("MicroMsg.ImagePreviewUI", "[gotoPhotoEditUI] raw:%s orignal:%s", qQ.mWP, qQ.hQc);
            str = qQ.mWP;
            if (bi.oN(str)) {
                str = qQ.hQc;
                intent.putExtra("after_photo_edit", "");
            } else {
                intent.putExtra("after_photo_edit", qQ.hQc);
            }
        } else {
            x.i("MicroMsg.ImagePreviewUI", "[gotoPhotoEditUI] item == null mPosition:%s", imagePreviewUI.mZC);
            str = imagePreviewUI.mZx.kF(imagePreviewUI.mZC.intValue());
            qQ = MediaItem.a(1, (long) imagePreviewUI.mZC.intValue(), str, str, "edit");
            ArrayList arrayList = new ArrayList();
            arrayList.add(qQ);
            c.w(arrayList);
        }
        intent.putExtra("before_photo_edit", str);
        d.b(imagePreviewUI, "photoedit", ".ui.MMNewPhotoEditUI", intent, 4372);
    }

    static /* synthetic */ void v(ImagePreviewUI imagePreviewUI) {
        if (imagePreviewUI.mZF == null || imagePreviewUI.mZF.cgx()) {
            imagePreviewUI.mZF = new al(new al.a() {
                public final boolean uG() {
                    boolean z;
                    ImagePreviewUI imagePreviewUI = ImagePreviewUI.this;
                    if (ImagePreviewUI.this.mZL) {
                        z = false;
                    } else {
                        z = true;
                    }
                    imagePreviewUI.mZL = z;
                    ImagePreviewUI.a(ImagePreviewUI.this, ImagePreviewUI.this.mZL);
                    return false;
                }
            }, false);
            imagePreviewUI.mZF.K(350, 350);
            return;
        }
        imagePreviewUI.mZF.TN();
    }

    @TargetApi(16)
    public void onCreate(Bundle bundle) {
        final long Wz = bi.Wz();
        super.onCreate(bundle);
        fullScreenNoTitleBar(true);
        new ag().post(new Runnable() {
            public final void run() {
                ImagePreviewUI.a(ImagePreviewUI.this, true);
                c.aOm().qF(-8);
                x.v("MicroMsg.ImagePreviewUI", "test oncreate post: %d", Long.valueOf(bi.bB(Wz)));
            }
        });
        bindService(new Intent(this.mController.xRr, GalleryStubService.class), this.lwY, 1);
        initView();
        x.v("MicroMsg.ImagePreviewUI", "test oncreate: %d", Long.valueOf(bi.bB(Wz)));
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        if (this.mZF != null) {
            this.mZF.TN();
        }
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.dlM;
    }

    protected final void dealContentView(View view) {
        if (b.aK(this)) {
            setContentView(view);
            return;
        }
        ae.c(ae.a(getWindow(), null), this.mController.xRd);
        ((ViewGroup) this.mController.xRd.getParent()).removeView(this.mController.xRd);
        ((ViewGroup) getWindow().getDecorView()).addView(this.mController.xRd, 0);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void initView() {
        /*
        r10 = this;
        r9 = 2;
        r8 = 8;
        r1 = 1;
        r2 = 0;
        r0 = com.tencent.mm.R.h.ckz;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.mZO = r0;
        r0 = com.tencent.mm.R.h.ckB;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.mZP = r0;
        r0 = com.tencent.mm.R.h.crF;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.mZQ = r0;
        r0 = com.tencent.mm.R.h.crG;
        r0 = r10.findViewById(r0);
        r10.mZR = r0;
        r0 = r10.mZR;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$21;
        r3.<init>();
        r4 = 100;
        r0.postDelayed(r3, r4);
        r0 = com.tencent.mm.R.h.ckA;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.mZS = r0;
        r0 = com.tencent.mm.R.h.cVb;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.ProgressBar) r0;
        r10.mZT = r0;
        r0 = r10.getIntent();
        r3 = "max_select_count";
        r4 = 9;
        r0 = r0.getIntExtra(r3, r4);
        r10.mYp = r0;
        r0 = com.tencent.mm.plugin.gallery.model.c.aOl();
        r0 = r0.aOO();
        r3 = 4;
        if (r0 != r3) goto L_0x0108;
    L_0x0065:
        r0 = r1;
    L_0x0066:
        r10.mYi = r0;
        r3 = r10.getIntent();
        r0 = "preview_image_list";
        r0 = r3.getStringArrayListExtra(r0);
        r10.mZA = r0;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r10.mZB = r0;
        r0 = r10.mZA;
        if (r0 == 0) goto L_0x0087;
    L_0x0080:
        r0 = r10.mZB;
        r4 = r10.mZA;
        r0.addAll(r4);
    L_0x0087:
        r0 = com.tencent.mm.plugin.gallery.model.c.aOn();
        r10.mXw = r0;
        r0 = "preview_all";
        r4 = r3.getBooleanExtra(r0, r2);
        r5 = "MicroMsg.ImagePreviewUI";
        r6 = "preview all[%B] mediaitems is null[%B]";
        r7 = new java.lang.Object[r9];
        r0 = java.lang.Boolean.valueOf(r4);
        r7[r2] = r0;
        r0 = r10.mXw;
        if (r0 != 0) goto L_0x010b;
    L_0x00a6:
        r0 = r1;
    L_0x00a7:
        r0 = java.lang.Boolean.valueOf(r0);
        r7[r1] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r5, r6, r7);
        if (r4 == 0) goto L_0x00dc;
    L_0x00b2:
        r0 = r10.mXw;
        if (r0 == 0) goto L_0x00dc;
    L_0x00b6:
        r10.mYT = r1;
        r0 = "preview_position";
        r0 = r3.getIntExtra(r0, r2);
        r0 = java.lang.Integer.valueOf(r0);
        r10.mZC = r0;
        r0 = "MicroMsg.ImagePreviewUI";
        r4 = "start position=%d";
        r5 = new java.lang.Object[r1];
        r6 = r10.mZC;
        r5[r2] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r0, r4, r5);
        r0 = r10.mZC;
        r0 = r0.intValue();
        if (r0 >= 0) goto L_0x00e2;
    L_0x00dc:
        r0 = java.lang.Integer.valueOf(r2);
        r10.mZC = r0;
    L_0x00e2:
        r0 = r10.mZC;
        r0 = r0.intValue();
        com.tencent.mm.plugin.gallery.model.c.qA(r0);
        r0 = r10.mYT;
        if (r0 != 0) goto L_0x010d;
    L_0x00ef:
        r0 = r10.mZB;
        if (r0 == 0) goto L_0x00fb;
    L_0x00f3:
        r0 = r10.mZB;
        r0 = r0.size();
        if (r0 != 0) goto L_0x010d;
    L_0x00fb:
        r0 = "MicroMsg.ImagePreviewUI";
        r1 = "not preview all items and imagepaths is null or empty";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r10.finish();
    L_0x0107:
        return;
    L_0x0108:
        r0 = r2;
        goto L_0x0066;
    L_0x010b:
        r0 = r2;
        goto L_0x00a7;
    L_0x010d:
        r0 = com.tencent.mm.R.h.cBW;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.ImageButton) r0;
        r10.mZD = r0;
        r0 = com.tencent.mm.R.h.cBX;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.mYc = r0;
        r0 = com.tencent.mm.R.h.cVa;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.mZE = r0;
        r0 = "send_raw_img";
        r0 = r3.getBooleanExtra(r0, r2);
        r10.mYm = r0;
        r0 = "query_source_type";
        r0 = r3.getIntExtra(r0, r2);
        r10.mZM = r0;
        r0 = r10.mYm;
        if (r0 == 0) goto L_0x0388;
    L_0x0141:
        r0 = r10.mZD;
        r3 = com.tencent.mm.R.k.dAC;
        r0.setImageResource(r3);
    L_0x0148:
        r0 = r10.mZB;
        if (r0 == 0) goto L_0x016d;
    L_0x014c:
        r0 = r10.mZB;
        r0 = r0.size();
        if (r0 != r1) goto L_0x016d;
    L_0x0154:
        r0 = r10.mZB;
        r0 = r0.get(r2);
        r0 = (java.lang.String) r0;
        r3 = ".jpg";
        r3 = r0.endsWith(r3);
        if (r3 == 0) goto L_0x016d;
    L_0x0165:
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$10;
        r3.<init>(r0);
        com.tencent.mm.sdk.platformtools.ah.y(r3);
    L_0x016d:
        r0 = r10.mYc;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = r10.mController;
        r4 = r4.xRr;
        r5 = com.tencent.mm.R.l.elu;
        r4 = r4.getString(r5);
        r3 = r3.append(r4);
        r3 = r3.toString();
        r0.setText(r3);
        r0 = r10.mZD;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$22;
        r3.<init>();
        r0.setOnClickListener(r3);
        r0 = r10.mZE;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$23;
        r3.<init>();
        r0.setOnClickListener(r3);
        r0 = r10.mZS;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$24;
        r3.<init>();
        r0.setOnClickListener(r3);
        r0 = r10.mYc;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$25;
        r3.<init>();
        r0.setOnClickListener(r3);
        r0 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$26;
        r0.<init>();
        r10.setBackBtn(r0);
        r0 = r10.aPd();
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$27;
        r3.<init>();
        r4 = com.tencent.mm.ui.p.b.xSe;
        r10.a(r2, r0, r3, r4);
        r0 = com.tencent.mm.R.h.cCE;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.ImageButton) r0;
        r10.mZG = r0;
        r0 = r10.mZG;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$2;
        r3.<init>();
        r0.setOnClickListener(r3);
        r0 = com.tencent.mm.R.h.cCF;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.mZH = r0;
        r0 = r10.mZH;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$3;
        r3.<init>();
        r0.setOnClickListener(r3);
        r0 = r10.mYp;
        if (r0 != r1) goto L_0x01fd;
    L_0x01f3:
        r0 = r10.mZG;
        r0.setVisibility(r8);
        r0 = r10.mZH;
        r0.setVisibility(r8);
    L_0x01fd:
        r0 = com.tencent.mm.R.h.cab;
        r0 = r10.findViewById(r0);
        r0 = (android.view.ViewGroup) r0;
        r10.mZI = r0;
        r0 = com.tencent.mm.R.h.cky;
        r0 = r10.findViewById(r0);
        r0 = (android.view.ViewGroup) r0;
        r10.mZJ = r0;
        r0 = r10.mZI;
        if (r0 == 0) goto L_0x0224;
    L_0x0215:
        r0 = r10.mZI;
        r0.setVisibility(r8);
        r0 = r10.mZI;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$4;
        r3.<init>();
        r0.setOnClickListener(r3);
    L_0x0224:
        r0 = r10.mZJ;
        if (r0 == 0) goto L_0x0237;
    L_0x0228:
        r0 = r10.mZJ;
        r0.setVisibility(r8);
        r0 = r10.mZJ;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$5;
        r3.<init>();
        r0.setOnClickListener(r3);
    L_0x0237:
        r0 = com.tencent.mm.R.h.cCD;
        r0 = r10.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r10.mZN = r0;
        r0 = r10.mZN;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$6;
        r3.<init>();
        r0.setOnClickListener(r3);
        r0 = com.tencent.mm.R.h.cpx;
        r0 = r10.findViewById(r0);
        r0 = (android.support.v7.widget.RecyclerView) r0;
        r10.mZz = r0;
        r0 = r10.mZz;
        r0 = r0.Ur;
        r4 = 66;
        r0.UX = r4;
        r0 = r10.mZz;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$7;
        r3.<init>();
        r0.a(r3);
        r0 = new com.tencent.mm.plugin.gallery.ui.g;
        r0.<init>(r10);
        r0.setOrientation(r2);
        r3 = r10.mZz;
        r3.a(r0);
        r0 = r10.getResources();
        r0 = r0.getDisplayMetrics();
        r0 = r0.widthPixels;
        r0 = r0 / 7;
        r3 = new com.tencent.mm.plugin.gallery.ui.f;
        r4 = r10.mZB;
        r5 = r10.mYT;
        r3.<init>(r10, r4, r0, r5);
        r0 = r10.mZz;
        r0.a(r3);
        r0 = r10.mZz;
        r4 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$8;
        r4.<init>();
        r0.post(r4);
        r0 = r10.mZB;
        r0 = r0.size();
        if (r0 <= 0) goto L_0x0391;
    L_0x02a0:
        r0 = r10.mZz;
        r0.setVisibility(r2);
    L_0x02a5:
        r0 = r10.mZz;
        r4 = new android.support.v7.widget.v;
        r4.<init>();
        r0.a(r4);
        r0 = r3.nao;
        r4 = r10.mZz;
        r0.A(r4);
        r0 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$9;
        r0.<init>();
        r3.nai = r0;
        r0 = com.tencent.mm.R.h.ckv;
        r0 = r10.findViewById(r0);
        r0 = (com.tencent.mm.ui.base.MMViewPager) r0;
        r10.mZy = r0;
        r0 = r10.mZy;
        r0.setVerticalFadingEdgeEnabled(r2);
        r0 = r10.mZy;
        r0.setHorizontalFadingEdgeEnabled(r2);
        r0 = r10.mZy;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$13;
        r3.<init>();
        r0.yng = r3;
        r0 = r10.mZy;
        r3 = new com.tencent.mm.plugin.gallery.ui.ImagePreviewUI$14;
        r3.<init>();
        r0.yne = r3;
        r0 = new com.tencent.mm.plugin.gallery.ui.c;
        r0.<init>(r10);
        r10.mZx = r0;
        r0 = r10.mZz;
        r0 = r0.fn();
        r0 = (com.tencent.mm.plugin.gallery.ui.f) r0;
        r3 = r10.mZx;
        r0.naf = r3;
        r0 = "";
        r3 = r10.mYT;
        if (r3 != 0) goto L_0x0398;
    L_0x02fd:
        r3 = r10.mZx;
        r4 = r10.mZA;
        r3.B(r4);
        r3 = r10.mZx;
        r3.mYT = r2;
        r3 = r10.mZA;
        r3 = r3.size();
        if (r3 <= 0) goto L_0x03df;
    L_0x0310:
        r0 = r10.mZA;
        r3 = r10.mZC;
        r3 = r3.intValue();
        r0 = r0.get(r3);
        r0 = (java.lang.String) r0;
        r3 = r0;
    L_0x031f:
        r0 = r10.mZy;
        r4 = r10.mZx;
        r0.a(r4);
        r0 = r10.mZy;
        r4 = r10.mZC;
        r4 = r4.intValue();
        r0.ah(r4);
        r0 = r10.aPe();
        r4 = r10.mZx;
        r5 = r10.mZC;
        r5 = r5.intValue();
        r4 = r4.kF(r5);
        r4 = r0.indexOf(r4);
        r0 = r10.mZz;
        r0 = r0.fn();
        r0 = (com.tencent.mm.plugin.gallery.ui.f) r0;
        r5 = r10.mZC;
        r5 = r5.intValue();
        r0.cI(r4, r5);
        r0 = com.tencent.mm.plugin.gallery.model.c.BY(r3);
        r10.a(r3, r0);
        r10.c(r0);
        r0 = "%d/%d";
        r3 = new java.lang.Object[r9];
        r4 = r10.mZC;
        r4 = r4.intValue();
        r4 = r4 + 1;
        r4 = java.lang.Integer.valueOf(r4);
        r3[r2] = r4;
        r2 = r10.mZx;
        r2 = r2.getCount();
        r2 = java.lang.Integer.valueOf(r2);
        r3[r1] = r2;
        r0 = java.lang.String.format(r0, r3);
        r10.setMMTitle(r0);
        goto L_0x0107;
    L_0x0388:
        r0 = r10.mZD;
        r3 = com.tencent.mm.R.k.dAB;
        r0.setImageResource(r3);
        goto L_0x0148;
    L_0x0391:
        r0 = r10.mZz;
        r0.setVisibility(r8);
        goto L_0x02a5;
    L_0x0398:
        r3 = r10.mZx;
        r4 = r10.mXw;
        r5 = r3.mXw;
        r5.clear();
        r5 = r3.mXw;
        r5.addAll(r4);
        r3.reset();
        r3.notifyDataSetChanged();
        r3 = r10.mZx;
        r3.mYT = r1;
        r3 = r10.mZC;
        r3 = r3.intValue();
        r4 = r10.mXw;
        r4 = r4.size();
        if (r3 < r4) goto L_0x03c4;
    L_0x03be:
        r3 = java.lang.Integer.valueOf(r2);
        r10.mZC = r3;
    L_0x03c4:
        r3 = r10.mXw;
        r3 = r3.size();
        if (r3 <= 0) goto L_0x03df;
    L_0x03cc:
        r0 = r10.mXw;
        r3 = r10.mZC;
        r3 = r3.intValue();
        r0 = r0.get(r3);
        r0 = (com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem) r0;
        r0 = r0.hQc;
        r3 = r0;
        goto L_0x031f;
    L_0x03df:
        r3 = r0;
        goto L_0x031f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.initView():void");
    }

    private void Cc(String str) {
        if (this.mZB.contains(str)) {
            this.mZG.setImageResource(R.k.dya);
            do {
            } while (this.mZB.remove(str));
            a(this.mZB.size(), this.mZC.intValue(), str, 1);
        } else if (this.mZB.size() >= this.mYp) {
            h.bu(this.mController.xRr, getResources().getQuantityString(R.j.duH, this.mYp, new Object[]{Integer.valueOf(this.mYp)}));
            this.mZG.setImageResource(R.k.dya);
        } else {
            this.mZB.add(str);
            this.mZG.setImageResource(R.k.dxZ);
            a(this.mZB.size(), this.mZC.intValue(), str, 0);
        }
    }

    protected void onActivityResult(int i, int i2, final Intent intent) {
        x.i("MicroMsg.ImagePreviewUI", "test onActivityResult");
        if (i == 4371) {
            if (i2 == -1) {
                setResult(-1, intent);
                finish();
            } else if (this.mZB.size() > 0) {
                Cc((String) this.mZB.get(0));
            } else {
                x.e("MicroMsg.ImagePreviewUI", "selectedPath has unexpected size() [%d]", Integer.valueOf(this.mZB.size()));
            }
        } else if (i == 4370) {
            if (i2 == -1) {
                setResult(-1, intent);
            }
            if (intent != null) {
                setResult(-1, intent.putExtra("GalleryUI_IsSendImgBackground", true));
                finish();
            }
        }
        if (i == 4372) {
            if (i2 == -1 && intent != null) {
                this.mZU = true;
                String stringExtra = intent.getStringExtra("before_photo_edit");
                Iterator it = c.aOp().iterator();
                while (it.hasNext()) {
                    if (stringExtra.equals(((Bundle) it.next()).getString("before_photo_edit"))) {
                        it.remove();
                    }
                }
                c.aOp().add(intent.getBundleExtra("report_info"));
                String stringExtra2 = intent.getStringExtra("after_photo_edit");
                String stringExtra3 = intent.getStringExtra("tmp_photo_edit");
                x.i("MicroMsg.ImagePreviewUI", "rawEditPhotoPath:%s lastEditPhotoPath;%s", stringExtra, stringExtra2);
                if (this.mZA != null) {
                    this.mZA.clear();
                    Collection stringArrayListExtra = intent.getStringArrayListExtra("preview_image_list");
                    if (stringArrayListExtra != null) {
                        this.mZA.addAll(stringArrayListExtra);
                    }
                    MediaItem qQ = this.mZx.qQ(this.mZC.intValue());
                    if (qQ == null) {
                        x.e("MicroMsg.ImagePreviewUI", "item is null!!! mPosition:%s rawEditPhotoPath:%s lastEditPhotoPath:%s", this.mZC, stringExtra, stringExtra2);
                        return;
                    }
                    qQ.mWP = stringExtra;
                    qQ.hQc = stringExtra2;
                    qQ.mqO = stringExtra2;
                    qQ.mWQ = stringExtra3;
                    qQ.mMimeType = "edit";
                    c.aOo().add(qQ);
                    c.aOk().a(new com.tencent.mm.plugin.gallery.model.b.b() {
                        public final void BX(String str) {
                            new ag(ImagePreviewUI.this.getMainLooper()).post(new Runnable() {
                                public final void run() {
                                    ImagePreviewUI.this.mZx.B(ImagePreviewUI.this.mZA);
                                    f fVar = (f) ImagePreviewUI.this.mZz.fn();
                                    Collection r = ImagePreviewUI.this.mZA;
                                    fVar.nah.clear();
                                    fVar.nah.addAll(r);
                                    fVar.UR.notifyChanged();
                                    Collection stringArrayListExtra = intent.getStringArrayListExtra("preview_select_image_list");
                                    ImagePreviewUI.this.mZB.clear();
                                    if (stringArrayListExtra != null) {
                                        ImagePreviewUI.this.mZB.addAll(stringArrayListExtra);
                                    }
                                    ImagePreviewUI.this.updateOptionMenuText(0, ImagePreviewUI.this.aPd());
                                    ImagePreviewUI.this.mYc.setText(ImagePreviewUI.this.mController.xRr.getString(R.l.elu) + "");
                                }
                            });
                            com.tencent.mm.plugin.gallery.model.b bVar = c.aOk().mWb;
                            if (bVar.hmK != null && bVar.hmK.contains(this)) {
                                bVar.hmK.remove(this);
                            }
                        }
                    });
                    c.aOk().b(stringExtra2, qQ.getType(), stringExtra2, qQ.mWR);
                    x.i("MicroMsg.ImagePreviewUI", "photo_edit_back!");
                }
            }
        } else if (intent != null) {
            setResult(-1, intent.putExtra("GalleryUI_IsSendImgBackground", true));
            finish();
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    private String aPd() {
        switch (c.aOl().aOO()) {
            case 4:
            case 7:
            case 8:
            case 13:
                if (this.mZB.size() == 0 || this.mYp <= 1) {
                    return getString(R.l.elw);
                }
                return getString(R.l.elw) + "(" + this.mZB.size() + "/" + this.mYp + ")";
            case 11:
                return getString(R.l.ebt);
            default:
                if (this.mZB.size() == 0 || this.mYp <= 1) {
                    return getString(R.l.dGL);
                }
                return getString(R.l.elq, new Object[]{Integer.valueOf(this.mZB.size()), Integer.valueOf(this.mYp)});
        }
    }

    private ArrayList<String> aPe() {
        if (this.mYT) {
            return this.mZB;
        }
        ArrayList<String> arrayList = new ArrayList(this.mZB.size());
        Iterator it = this.mZA.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (this.mZB.contains(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    private void fw(boolean z) {
        if (c.aOl().aOO() != 4) {
            if (this.mZx == null) {
                x.i("MicroMsg.ImagePreviewUI", "[setTopTipVisibility] adapter == null");
                return;
            }
            final MediaItem qQ = this.mZx.qQ(this.mZC.intValue());
            if (!z || qQ == null) {
                this.mZR.setVisibility(8);
            } else {
                this.mZR.postDelayed(new Runnable() {
                    public final void run() {
                        ImagePreviewUI.this.c(qQ);
                    }
                }, 400);
            }
        }
    }

    private void fx(boolean z) {
        View findViewById;
        x.d("MicroMsg.ImagePreviewUI", "setFooterVisibility() called with: visible = [" + z + "], selectedNormalFooter = " + this.mZK);
        if (this.mZK) {
            findViewById = findViewById(R.h.cab);
        } else {
            findViewById = findViewById(R.h.cky);
        }
        if (findViewById == null) {
            String str;
            String str2 = "MicroMsg.ImagePreviewUI";
            String str3 = "set footer[%s] visibility[%B], but footerbar null";
            Object[] objArr = new Object[2];
            if (this.mZK) {
                str = "normal";
            } else {
                str = "edit_tips";
            }
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(z);
            x.w(str2, str3, objArr);
        } else if (!z || findViewById.getVisibility() != 0) {
            if (z || findViewById.getVisibility() != 8) {
                if (z) {
                    findViewById.setVisibility(0);
                    findViewById.startAnimation(AnimationUtils.loadAnimation(this, R.a.bpZ));
                } else {
                    findViewById.setVisibility(8);
                    findViewById.startAnimation(AnimationUtils.loadAnimation(this, R.a.bqa));
                }
                if (z && this.mZz.getVisibility() == 8 && this.mZB.size() > 0) {
                    this.mZz.setVisibility(0);
                    this.mZz.startAnimation(AnimationUtils.loadAnimation(this, R.a.bpZ));
                } else if (!z && this.mZz.getVisibility() == 0) {
                    this.mZz.setVisibility(8);
                    this.mZz.startAnimation(AnimationUtils.loadAnimation(this, R.a.bqa));
                }
            }
        }
    }

    private void goBack() {
        boolean z = true;
        Intent intent = new Intent();
        boolean z2 = !this.mYm;
        String str = "CropImage_Compress_Img";
        if (!this.mYi) {
            z = z2;
        }
        intent.putExtra(str, z);
        intent.putStringArrayListExtra("preview_image_list", aPe());
        intent.putExtra("show_photo_edit_tip", this.mZU);
        setResult(0, intent);
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (c.aOl().aOO() == 3 && getIntent().getBooleanExtra("preview_image", false) && getIntent().getIntExtra("max_select_count", 0) == 1) {
            x.i("MicroMsg.ImagePreviewUI", "clear photo edit cache!");
            sendBroadcast(new Intent("com.tencent.mm.plugin.photoedit.action.clear"));
        }
        if (this.mZx != null) {
            this.mZx.release();
        }
        c.w(null);
        unbindService(this.lwY);
    }

    private void a(String str, MediaItem mediaItem) {
        if (mediaItem != null && mediaItem.getType() == 2 && (c.aOl().aOO() == 4 || c.aOl().aOO() == 13)) {
            boolean z;
            if (mediaItem == null || mediaItem.getType() != 1 || mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
                this.mZN.setVisibility(8);
            } else {
                this.mZN.setVisibility(0);
            }
            VideoMediaItem videoMediaItem = (VideoMediaItem) mediaItem;
            enableOptionMenu(false);
            this.mZK = false;
            this.mZI.setVisibility(8);
            this.mZJ.setVisibility(0);
            this.mZS.setVisibility(8);
            if (FileOp.mi(str) > 1073741824) {
                this.mZO.setText(getString(R.l.elC));
                this.mZP.setText(getString(R.l.elB));
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                if (bi.oN(videoMediaItem.hQd)) {
                    enableOptionMenu(false);
                    this.mZK = true;
                    this.mZI.setVisibility(0);
                    this.mZJ.setVisibility(8);
                    this.mZE.setVisibility(8);
                    b(str, mediaItem);
                    Cd(str);
                    Runnable mVar = new m(str, this.mZC.intValue(), videoMediaItem, new m.a() {
                        public final void a(m mVar) {
                            if (mVar.position == ImagePreviewUI.this.mZC.intValue()) {
                                ImagePreviewUI.this.a(mVar.path, mVar.mXp);
                            }
                        }
                    });
                    if (e.V(mVar)) {
                        x.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", str);
                        return;
                    }
                    e.post(mVar, "video_analysis");
                    return;
                }
                x.d("MicroMsg.ImagePreviewUI", "got MediaItem directly path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", videoMediaItem.hQc, Integer.valueOf(videoMediaItem.hQf), Integer.valueOf(videoMediaItem.videoHeight), Integer.valueOf(videoMediaItem.videoWidth));
                a(str, videoMediaItem);
                return;
            }
            return;
        }
        this.mZK = true;
        this.mZI.setVisibility(0);
        this.mZJ.setVisibility(8);
        this.mZT.setVisibility(8);
        b(str, mediaItem);
        Cd(str);
        enableOptionMenu(true);
        this.mZE.setVisibility(8);
        if (mediaItem == null || mediaItem.getType() != 1 || mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
            boolean booleanExtra = getIntent().getBooleanExtra("preview_image", false);
            x.i("MicroMsg.ImagePreviewUI", "QuerySource:%s isPreViewImage:%s  path:%s", Integer.valueOf(c.aOl().aOO()), Boolean.valueOf(booleanExtra), str);
            if (mediaItem != null || bi.oN(str)) {
                this.mZN.setVisibility(8);
                return;
            } else {
                this.mZN.setVisibility(0);
                return;
            }
        }
        this.mZN.setVisibility(0);
    }

    private void a(String str, VideoMediaItem videoMediaItem) {
        enableOptionMenu(false);
        this.mZK = false;
        this.mZI.setVisibility(8);
        this.mZJ.setVisibility(0);
        this.mZS.setVisibility(8);
        if (c.aOl().aOO() == 13) {
            this.mZJ.setVisibility(8);
            this.mZI.setVisibility(8);
            this.mZO.setVisibility(8);
            this.mZP.setVisibility(8);
            enableOptionMenu(true);
            return;
        }
        boolean z;
        if (videoMediaItem == null || videoMediaItem.videoWidth <= 0 || videoMediaItem.videoHeight <= 0 || ((float) videoMediaItem.videoWidth) / ((float) videoMediaItem.videoHeight) > 3.0f || ((float) videoMediaItem.videoWidth) / ((float) videoMediaItem.videoHeight) < 0.5f) {
            if (videoMediaItem != null) {
                x.d("MicroMsg.ImagePreviewUI", "check ratio faild width = [%d], height = [%d]", Integer.valueOf(videoMediaItem.videoWidth), Integer.valueOf(videoMediaItem.videoHeight));
            }
            this.mZO.setText(getString(R.l.elz));
            this.mZP.setText(getString(R.l.elA));
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            x.d("MicroMsg.ImagePreviewUI", "updateBottomLayoutCheckFormat() called with: item = [%s]", videoMediaItem);
            if (!(videoMediaItem == null || bi.oN(videoMediaItem.hQc))) {
                String str2 = videoMediaItem.hQc;
                if (bi.oN(str2)) {
                    z = true;
                } else {
                    if (this.mZV == null) {
                        this.mZV = new HashSet();
                        this.mZV.add(".h264");
                        this.mZV.add(".h26l");
                        this.mZV.add(".264");
                        this.mZV.add(".avc");
                        this.mZV.add(".mov");
                        this.mZV.add(".mp4");
                        this.mZV.add(".m4a");
                        this.mZV.add(".3gp");
                        this.mZV.add(".3g2");
                        this.mZV.add(".mj2");
                        this.mZV.add(".m4v");
                    }
                    str2 = str2.trim();
                    int lastIndexOf = str2.lastIndexOf(".");
                    z = (lastIndexOf < 0 || lastIndexOf >= str2.length()) ? true : !this.mZV.contains(str2.substring(lastIndexOf));
                }
                if (!z && "video/avc".equalsIgnoreCase(videoMediaItem.hQd) && (bi.oN(videoMediaItem.hQe) || "audio/mp4a-latm".equalsIgnoreCase(videoMediaItem.hQe))) {
                    z = false;
                    if (!z) {
                        x.d("MicroMsg.ImagePreviewUI", "check duration %d", Integer.valueOf(videoMediaItem.hQf));
                        if (c.aOl().aOO() != 13) {
                            if (videoMediaItem.hQf <= 1000) {
                                this.mZO.setText(getString(R.l.elG));
                                this.mZP.setText(getString(R.l.elF));
                                z = true;
                            } else if (videoMediaItem.hQf >= 300000) {
                                this.mZO.setText(getString(R.l.elE));
                                this.mZP.setText(getString(R.l.elD));
                                z = true;
                            } else if (videoMediaItem.hQf >= 10500) {
                                this.mZO.setText(getString(R.l.elt));
                                this.mZP.setText(getString(R.l.els));
                                this.mZS.setVisibility(0);
                                z = true;
                            }
                            if (z) {
                                enableOptionMenu(true);
                                this.mZK = true;
                                this.mZI.setVisibility(0);
                                this.mZJ.setVisibility(8);
                                this.mZE.setVisibility(0);
                                this.mZT.setVisibility(8);
                                b(str, (MediaItem) videoMediaItem);
                                Cd(str);
                            }
                        }
                        z = false;
                        if (z) {
                            enableOptionMenu(true);
                            this.mZK = true;
                            this.mZI.setVisibility(0);
                            this.mZJ.setVisibility(8);
                            this.mZE.setVisibility(0);
                            this.mZT.setVisibility(8);
                            b(str, (MediaItem) videoMediaItem);
                            Cd(str);
                        }
                    }
                }
            }
            String str3 = "MicroMsg.ImagePreviewUI";
            String str4 = "check video format failed, dst format [video/avc], video format [%s]";
            Object[] objArr = new Object[1];
            objArr[0] = videoMediaItem == null ? null : videoMediaItem.hQd;
            x.d(str3, str4, objArr);
            this.mZO.setText(getString(R.l.elx));
            this.mZP.setText(getString(R.l.ely));
            z = true;
            if (!z) {
                x.d("MicroMsg.ImagePreviewUI", "check duration %d", Integer.valueOf(videoMediaItem.hQf));
                if (c.aOl().aOO() != 13) {
                    if (videoMediaItem.hQf <= 1000) {
                        this.mZO.setText(getString(R.l.elG));
                        this.mZP.setText(getString(R.l.elF));
                        z = true;
                    } else if (videoMediaItem.hQf >= 300000) {
                        this.mZO.setText(getString(R.l.elE));
                        this.mZP.setText(getString(R.l.elD));
                        z = true;
                    } else if (videoMediaItem.hQf >= 10500) {
                        this.mZO.setText(getString(R.l.elt));
                        this.mZP.setText(getString(R.l.els));
                        this.mZS.setVisibility(0);
                        z = true;
                    }
                    if (z) {
                        enableOptionMenu(true);
                        this.mZK = true;
                        this.mZI.setVisibility(0);
                        this.mZJ.setVisibility(8);
                        this.mZE.setVisibility(0);
                        this.mZT.setVisibility(8);
                        b(str, (MediaItem) videoMediaItem);
                        Cd(str);
                    }
                }
                z = false;
                if (z) {
                    enableOptionMenu(true);
                    this.mZK = true;
                    this.mZI.setVisibility(0);
                    this.mZJ.setVisibility(8);
                    this.mZE.setVisibility(0);
                    this.mZT.setVisibility(8);
                    b(str, (MediaItem) videoMediaItem);
                    Cd(str);
                }
            }
        }
    }

    private void c(MediaItem mediaItem) {
        if (mediaItem == null) {
            x.e("MicroMsg.ImagePreviewUI", "[updateTopTip] null == item");
        } else if (mediaItem.getType() == 2) {
            VideoMediaItem videoMediaItem = (VideoMediaItem) mediaItem;
            if (bi.oN(videoMediaItem.hQd)) {
                Runnable mVar = new m(mediaItem.hQc, this.mZC.intValue(), videoMediaItem, new m.a() {
                    public final void a(m mVar) {
                        if (mVar.position == ImagePreviewUI.this.mZC.intValue()) {
                            if (mVar.mXp.hQf >= 300000 || (mVar.mXp.hQf > 0 && mVar.mXp.hQf < 1000)) {
                                ImagePreviewUI.this.mZR.setVisibility(0);
                                ImagePreviewUI.this.mZQ.setText(mVar.mXp.hQf >= 300000 ? ImagePreviewUI.this.getString(R.l.elD) : ImagePreviewUI.this.getString(R.l.elF));
                                ImagePreviewUI.this.mZH.setEnabled(false);
                                ImagePreviewUI.this.mZG.setEnabled(false);
                                ImagePreviewUI.this.mZH.setTextColor(ImagePreviewUI.this.getResources().getColor(R.e.bul));
                                if (ImagePreviewUI.this.mZB.size() == 0) {
                                    ImagePreviewUI.this.enableOptionMenu(false);
                                    return;
                                }
                                return;
                            }
                            ImagePreviewUI.this.mZH.setEnabled(true);
                            ImagePreviewUI.this.mZG.setEnabled(true);
                            ImagePreviewUI.this.mZH.setTextColor(ImagePreviewUI.this.getResources().getColor(R.e.buk));
                            ImagePreviewUI.this.mZR.setVisibility(8);
                        }
                    }
                });
                if (e.V(mVar)) {
                    x.d("MicroMsg.ImagePreviewUI", "analysis of path[%s] has already been added in ThreadPool", mediaItem.hQc);
                    return;
                } else {
                    e.post(mVar, "video_analysis");
                    return;
                }
            }
            x.d("MicroMsg.ImagePreviewUI", "path [%s], durationMs [%d], videoHeight[%d], videoWidth [%d]", videoMediaItem.hQc, Integer.valueOf(videoMediaItem.hQf), Integer.valueOf(videoMediaItem.videoHeight), Integer.valueOf(videoMediaItem.videoWidth));
            if (videoMediaItem.hQf >= 300000 || (videoMediaItem.hQf > 0 && videoMediaItem.hQf < 1000)) {
                this.mZR.setVisibility(0);
                this.mZQ.setText(videoMediaItem.hQf >= 300000 ? getString(R.l.elD) : getString(R.l.elF));
                this.mZH.setEnabled(false);
                this.mZG.setEnabled(false);
                this.mZH.setTextColor(getResources().getColor(R.e.bul));
                if (this.mZB.size() == 0) {
                    enableOptionMenu(false);
                    return;
                }
                return;
            }
            this.mZH.setEnabled(true);
            this.mZG.setEnabled(true);
            this.mZH.setTextColor(getResources().getColor(R.e.buk));
            this.mZR.setVisibility(8);
        } else if (mediaItem.getType() == 1 && !mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
            this.mZH.setEnabled(true);
            this.mZG.setEnabled(true);
            this.mZH.setTextColor(getResources().getColor(R.e.buk));
            if (this.mYm && this.mZB.contains(mediaItem.hQc) && FileOp.mi(mediaItem.hQc) > 26214400) {
                this.mZR.setVisibility(0);
                this.mZQ.setText(getString(R.l.elK));
                return;
            }
            this.mZR.setVisibility(8);
        } else if (mediaItem.getType() == 1 && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
            com.tencent.mm.plugin.gif.e eVar = new com.tencent.mm.plugin.gif.e(mediaItem.hQc);
            int bN = com.tencent.mm.a.e.bN(mediaItem.hQc);
            try {
                if ((!this.mZB.contains(mediaItem.hQc) || bN == 0 || bN <= this.mXv.zM()) && eVar.nEp[0] <= this.mXv.zL() && eVar.nEp[1] <= this.mXv.zL()) {
                    this.mZH.setTextColor(getResources().getColor(R.e.buk));
                    this.mZH.setEnabled(true);
                    this.mZG.setEnabled(true);
                    return;
                }
                this.mZH.setTextColor(getResources().getColor(R.e.bul));
                this.mZH.setEnabled(false);
                this.mZG.setEnabled(false);
            } catch (Throwable e) {
                x.e("MicroMsg.ImagePreviewUI", bi.i(e));
            }
        }
    }

    private void b(String str, MediaItem mediaItem) {
        if (mediaItem != null && mediaItem.getType() == 2 && c.aOl().aOO() == 4) {
            this.mZG.setVisibility(8);
            this.mZH.setVisibility(8);
            return;
        }
        if (this.mYp == 1) {
            this.mZG.setVisibility(8);
            this.mZH.setVisibility(8);
        } else {
            this.mZG.setVisibility(0);
            this.mZH.setVisibility(0);
        }
        if (this.mZB.contains(str)) {
            this.mZG.setImageResource(R.k.dxZ);
        } else {
            this.mZG.setImageResource(R.k.dya);
        }
    }

    private void Cd(String str) {
        Boolean valueOf;
        Boolean.valueOf(false);
        switch (c.aOl().aOO()) {
            case 4:
            case 7:
            case 13:
                valueOf = Boolean.valueOf(true);
                break;
            default:
                valueOf = Boolean.valueOf(false);
                break;
        }
        MediaItem BY = c.BY(str);
        if (BY != null && BY.getType() == 2) {
            valueOf = Boolean.valueOf(true);
        }
        if (BY == null && p.Vw(str)) {
            valueOf = Boolean.valueOf(true);
        } else if (BY != null && BY.mMimeType.equalsIgnoreCase("image/gif")) {
            valueOf = Boolean.valueOf(true);
        }
        if (valueOf.booleanValue()) {
            this.mZD.setVisibility(8);
            this.mYc.setVisibility(8);
            return;
        }
        this.mZD.setVisibility(0);
        this.mYc.setVisibility(0);
    }

    private void a(int i, int i2, String str, int i3) {
        x.i("MicroMsg.ImagePreviewUI", "count:%s selectPosition:%s", Integer.valueOf(i), Integer.valueOf(i2));
        if (-1 != i2 && !this.mYT) {
            this.mZz.fn().b(i2, Integer.valueOf(i2));
        } else if (-1 != i2) {
            if (i3 == 0 && i > 0) {
                ((f) this.mZz.fn()).nah.add(str);
                ((f) this.mZz.fn()).cI(i - 1, this.mZC.intValue());
                this.mZz.fn().bk(i - 1);
                this.mZz.smoothScrollToPosition(i - 1);
            } else if (i3 == 1) {
                int indexOf = ((f) this.mZz.fn()).nah.indexOf(str);
                if (-1 != indexOf) {
                    ((f) this.mZz.fn()).nah.remove(indexOf);
                    this.mZz.fn().bl(indexOf);
                }
            }
        }
        int i4;
        if (c.aOl().aOO() == 13) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        MediaItem qQ = this.mZx.qQ(this.mZC.intValue());
        if (i == 0 || ((this.mYi || i4 != 0) && this.mZx != null && qQ != null && qQ.getType() == 2)) {
            this.mZz.setVisibility(8);
        } else {
            this.mZz.setVisibility(0);
        }
    }
}
