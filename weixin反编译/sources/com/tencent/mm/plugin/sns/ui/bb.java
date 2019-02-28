package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.tencent.mm.bz.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.f.a.ln;
import com.tencent.mm.f.a.rv;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.base.u;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bb implements com.tencent.mm.plugin.sns.model.av.a, b {
    protected String filePath;
    private String jPV;
    private Activity mActivity;
    protected ListView nQn;
    private String nqW;
    protected MMPullDownView otm;
    public int qUk = 0;
    private boolean qXf = false;
    private String rOd;
    private boolean rOe;
    private int rOf;
    protected LoadingMoreView rRh;
    private int rRi = 0;
    private boolean rRj = false;
    protected boolean rRk = false;
    public int rRl = 0;
    a rRm;
    private String rRn;
    com.tencent.mm.modelsns.b rRo = null;
    protected SnsHeader rhb;
    private boolean rzo;
    protected r tipDialog = null;
    protected String title;

    public interface a {
        void M(int i, boolean z);

        void a(int i, List<Integer> list, List<Integer> list2);

        void bCt();

        ListView bCu();

        MMPullDownView bCv();

        boolean bCw();

        void bCx();

        void bCy();

        int getType();

        void iQ(boolean z);

        void ye(int i);
    }

    static /* synthetic */ void e(bb bbVar) {
        View inflate = LayoutInflater.from(bbVar.mActivity).inflate(g.qLi, (ViewGroup) bbVar.mActivity.findViewById(f.qLi));
        u uVar = new u(bbVar.mActivity);
        uVar.setGravity(48, 0, BackwardSupportUtil.b.b(bbVar.mActivity, 200.0f));
        uVar.duration = 1000;
        uVar.setView(inflate);
        uVar.cancel();
        uVar.fia.TN();
        uVar.las = ((int) (uVar.duration / 70)) + 1;
        uVar.fia.K(70, 70);
    }

    public bb(Activity activity) {
        this.mActivity = activity;
    }

    public final void onCreate() {
        this.qUk = this.mActivity.getWindowManager().getDefaultDisplay().getHeight();
        ae.bwc().start();
        this.nQn = this.rRm.bCu();
        this.nQn.post(new Runnable() {
            public final void run() {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                bb.this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                ae.bvU();
                com.tencent.mm.plugin.sns.storage.r.dF(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
        });
        x.i("MicroMsg.SnsActivity", "list is null ? " + (this.nQn != null));
        this.nQn.setScrollingCacheEnabled(false);
        this.rhb = new SnsHeader(this.mActivity);
        this.rhb.rHJ = new com.tencent.mm.plugin.sns.ui.SnsHeader.a() {
            public final boolean eW(long j) {
                if (bb.this.rzo || bb.this.rRm.getType() == 1) {
                    bb.this.yi(2);
                } else {
                    m mVar = new m();
                    mVar.field_snsId = j;
                    mVar.field_userName = bb.this.jPV;
                    bpb SH = e.SH();
                    SH.kyG = bb.this.jPV;
                    mVar.c(SH);
                    m KQ = ai.KQ(bb.this.jPV);
                    x.d("MicroMsg.SnsActivity", "friend like %s", bb.this.jPV);
                    if (KQ == null) {
                        com.tencent.mm.plugin.sns.model.al.a.a(mVar, 1, "");
                    } else if (KQ.byZ()) {
                        com.tencent.mm.plugin.sns.model.al.a.a(mVar, 1, "");
                    } else {
                        com.tencent.mm.plugin.sns.model.al.a.a(mVar, 5, "");
                    }
                    k LV = ae.bwj().LV(bb.this.jPV);
                    LV.field_local_flag |= 2;
                    ae.bwj().c(LV);
                    bb.e(bb.this);
                }
                return false;
            }

            public final boolean bBF() {
                bb.this.rRm.bCy();
                return false;
            }
        };
        this.rRh = new LoadingMoreView(this.mActivity);
        this.nQn.addHeaderView(this.rhb);
        this.nQn.addFooterView(this.rRh);
        this.nQn.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                bb.this.rRm.ye(i);
                if (i == 0) {
                    com.tencent.mm.sdk.b.b rvVar = new rv();
                    rvVar.fKt.type = 5;
                    rvVar.fKt.fKu = bb.this.nQn.getFirstVisiblePosition();
                    rvVar.fKt.fKv = bb.this.nQn.getLastVisiblePosition();
                    rvVar.fKt.fKw = bb.this.nQn.getHeaderViewsCount();
                    com.tencent.mm.sdk.b.a.xmy.m(rvVar);
                    if ((bb.this.mActivity instanceof SnsTimeLineUI) && ((SnsTimeLineUI) bb.this.mActivity).rFX != null) {
                        ((SnsTimeLineUI) bb.this.mActivity).rFX.buI();
                    }
                }
                if (i == 2) {
                    d.cmf().dh(bb.class.getName() + bb.this.rRm.getType() + ".Listview", 4);
                    bb.this.iQ(true);
                    return;
                }
                bb.this.iQ(false);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                bb.this.rRl = (i + i2) - 1;
                if (bb.this.nQn.getLastVisiblePosition() == bb.this.nQn.getCount() - 1 && bb.this.nQn.getCount() != bb.this.rRi) {
                    x.d("MicroMsg.SnsActivity", "now refresh count: %s", Integer.valueOf(bb.this.nQn.getCount()));
                    bb.this.rRi = bb.this.nQn.getCount();
                    bb.this.rRm.bCt();
                }
            }
        });
        this.otm = this.rRm.bCv();
        x.i("MicroMsg.SnsActivity", "pullDownView is null ? " + (this.otm != null));
        this.otm.ykU = new MMPullDownView.g() {
            public final boolean azU() {
                bb.this.rRm.bCx();
                return true;
            }
        };
        this.otm.mw(false);
        this.otm.mt(false);
        this.otm.ylg = new c() {
            public final boolean azT() {
                View childAt = bb.this.nQn.getChildAt(bb.this.nQn.getChildCount() - 1);
                if (childAt == null || childAt.getBottom() > bb.this.nQn.getHeight() || bb.this.nQn.getLastVisiblePosition() != bb.this.nQn.getAdapter().getCount() - 1) {
                    return false;
                }
                return true;
            }
        };
        this.otm.ylh = new MMPullDownView.d() {
            public final boolean azS() {
                View childAt = bb.this.nQn.getChildAt(bb.this.nQn.getFirstVisiblePosition());
                if (childAt == null || childAt.getTop() != 0) {
                    return false;
                }
                return true;
            }
        };
        this.otm.mu(false);
        this.otm.ykV = new MMPullDownView.e() {
            public final boolean azR() {
                x.e("MicroMsg.SnsActivity", "bottomLoad  isAll:" + bb.this.rRk);
                if (!bb.this.rRk) {
                    bb.this.rRm.bCt();
                }
                return true;
            }
        };
        this.otm.ylw = true;
        MMPullDownView mMPullDownView = this.otm;
        mMPullDownView.bgColor = Color.parseColor("#f4f4f4");
        mMPullDownView.yly = mMPullDownView.bgColor;
        this.title = this.mActivity.getIntent().getStringExtra("sns_title");
        SnsHeader snsHeader = this.rhb;
        Object obj = bi.oN(this.jPV) ? this.rOd : this.jPV;
        String str = this.rOd;
        CharSequence charSequence = this.nqW;
        CharSequence charSequence2 = this.rRn;
        if (obj == null || str == null) {
            x.e("MicroMsg.SnsHeader", "userName or selfName is null ");
        } else {
            snsHeader.userName = obj.trim();
            snsHeader.gAM = str.trim();
            snsHeader.fva = str.equals(obj);
            x.d("MicroMsg.SnsHeader", "userNamelen " + obj.length() + "  " + obj);
            snsHeader.rHI.kxN.setText(obj);
            if (!(snsHeader.rHI == null || snsHeader.rHI.ikl == null)) {
                com.tencent.mm.pluginsdk.ui.a.b.b(snsHeader.rHI.ikl, snsHeader.userName, true);
            }
            if (obj != null && obj.length() > 0) {
                snsHeader.rHI.kxN.setText(i.a(snsHeader.context, com.tencent.mm.plugin.sns.data.i.A(charSequence)));
                snsHeader.rHI.rwW.setText(i.b(snsHeader.context, charSequence2, snsHeader.rHI.rwW.getTextSize()));
            }
            snsHeader.rHI.ikl.setContentDescription(snsHeader.context.getString(j.qQm, new Object[]{snsHeader.rHI.kxN.getText()}));
        }
        SnsHeader snsHeader2 = this.rhb;
        int type = this.rRm.getType();
        snsHeader2.type = type;
        if (type == 1 && snsHeader2.rHI.rwW != null) {
            snsHeader2.rHI.rwW.setVisibility(8);
        }
        this.rhb.bBD();
        if (VERSION.SDK_INT < 11) {
            x.d("MicroMsg.SnsActivity", "sdk not support dragdrop event");
        } else {
            new Runnable() {
                public final void run() {
                    OnDragListener anonymousClass1 = new OnDragListener() {
                        public final boolean onDrag(View view, DragEvent dragEvent) {
                            int i = 0;
                            switch (dragEvent.getAction()) {
                                case 1:
                                case 2:
                                case 4:
                                case 5:
                                    x.i("MicroMsg.SnsActivity", "ACTION: [%s]", Integer.valueOf(dragEvent.getAction()));
                                    return true;
                                case 3:
                                    x.i("MicroMsg.SnsActivity", "ACTION_DROP");
                                    ClipData clipData = dragEvent.getClipData();
                                    if (clipData == null) {
                                        return true;
                                    }
                                    int itemCount = clipData.getItemCount();
                                    ArrayList arrayList = new ArrayList();
                                    while (i < itemCount) {
                                        Item itemAt = clipData.getItemAt(i);
                                        if (itemAt == null) {
                                            x.e("MicroMsg.SnsActivity", "item == null");
                                        } else if (itemAt.getIntent() != null) {
                                            bb.this.mActivity.startActivity(itemAt.getIntent());
                                        } else if (itemAt.getUri() != null) {
                                            l lVar = new l(bb.this.mActivity, itemAt.getUri());
                                            if (lVar.fileType != 0 && lVar.filePath != null) {
                                                switch (lVar.fileType) {
                                                    case 3:
                                                        arrayList.add(lVar.filePath);
                                                        break;
                                                    default:
                                                        break;
                                                }
                                            }
                                            x.e("MicroMsg.SnsActivity", "get file path failed");
                                        }
                                        i++;
                                    }
                                    if (arrayList.size() < 0) {
                                        x.e("MicroMsg.SnsActivity", "no image file available");
                                        return true;
                                    }
                                    Intent intent = new Intent(bb.this.mActivity, SnsUploadUI.class);
                                    intent.putExtra("KSnsPostManu", true);
                                    intent.putExtra("KTouchCameraTime", bi.Wx());
                                    intent.putStringArrayListExtra("sns_kemdia_path_list", arrayList);
                                    intent.setAction("android.intent.action.SEND");
                                    intent.addCategory("android.intent.category.DEFAULT");
                                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                    intent.putExtra("android.intent.extra.TEXT", "");
                                    intent.putExtra("Ksnsupload_empty_img", true);
                                    if (bb.this.rzo) {
                                        intent.putExtra("Ksnsupload_source", 11);
                                    }
                                    intent.setType("image/*");
                                    bb.this.mActivity.startActivity(intent);
                                    return true;
                                default:
                                    x.e("MicroMsg.SnsActivity", "Unknown action type received by OnDragListener.");
                                    return false;
                            }
                        }
                    };
                    if (bb.this.rhb != null) {
                        bb.this.rhb.setOnDragListener(anonymousClass1);
                    }
                }
            }.run();
        }
        ae.bwb().gDT.add(this);
        av.qYx++;
        ae.bwa().a((b) this);
    }

    public final void iQ(boolean z) {
        this.rRm.iQ(z);
    }

    public final void a(String str, String str2, String str3, String str4, boolean z, boolean z2, int i) {
        this.rOd = str;
        this.jPV = str2;
        this.nqW = str3;
        this.rRn = str4;
        this.rOe = z;
        this.rzo = z2;
        this.rOf = i;
    }

    public static void onResume() {
        ae.bwa().J(2, false);
        com.tencent.mm.pluginsdk.wallet.i.CU(7);
        com.tencent.mm.sdk.b.b lnVar = new ln();
        lnVar.fDI.fDJ = true;
        com.tencent.mm.sdk.b.a.xmy.a(lnVar, Looper.getMainLooper());
        x.d("MicroMsg.SnsActivity", "SnsActivity req pause auto download logic");
    }

    public static void onPause() {
        com.tencent.mm.sdk.b.b lnVar = new ln();
        lnVar.fDI.fDJ = false;
        com.tencent.mm.sdk.b.a.xmy.a(lnVar, Looper.getMainLooper());
        x.d("MicroMsg.SnsActivity", "AppAttachDownloadUI cancel pause auto download logic");
    }

    protected final void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.SnsActivity", "onAcvityResult requestCode:" + i);
        if (i2 == -1) {
            int a;
            switch (i) {
                case 2:
                    if (intent != null) {
                        com.tencent.mm.kernel.g.Dr();
                        a = bi.a((Integer) com.tencent.mm.kernel.g.Dq().Db().get(68393, null), 0);
                        com.tencent.mm.kernel.g.Dr();
                        com.tencent.mm.kernel.g.Dq().Db().set(68393, Integer.valueOf(a + 1));
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 4);
                        intent2.putExtra("CropImage_Filter", true);
                        intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                        com.tencent.mm.plugin.sns.c.a.ihN.a(this.mActivity, intent, intent2, ae.getAccSnsTmpPath(), 4, new com.tencent.mm.ui.tools.a.a() {
                            public final String Mz(String str) {
                                return ae.getAccSnsTmpPath() + com.tencent.mm.a.g.s((bb.this.filePath + System.currentTimeMillis()).getBytes());
                            }
                        });
                        return;
                    }
                    return;
                case 4:
                    if (intent != null) {
                        this.filePath = intent.getStringExtra("CropImage_OutputPath");
                        V(intent);
                        return;
                    }
                    return;
                case 5:
                    this.filePath = com.tencent.mm.pluginsdk.ui.tools.k.b(this.mActivity.getApplicationContext(), intent, ae.getAccSnsTmpPath());
                    x.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_TAKE_PHOTO  filePath" + this.filePath);
                    if (this.filePath != null) {
                        com.tencent.mm.kernel.g.Dr();
                        a = bi.a((Integer) com.tencent.mm.kernel.g.Dq().Db().get(68392, null), 0);
                        com.tencent.mm.kernel.g.Dr();
                        com.tencent.mm.kernel.g.Dq().Db().set(68392, Integer.valueOf(a + 1));
                        this.qXf = true;
                        V(intent);
                        return;
                    }
                    return;
                case 6:
                    x.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_UPLOAD_MEDIA");
                    if (intent != null) {
                        this.rRm.a(intent.getIntExtra("sns_local_id", -1), null, null);
                        ae.bwb().buT();
                        return;
                    }
                    return;
                case 7:
                    x.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_CHANGE_BG");
                    this.rhb.bBD();
                    ae.bwb().buT();
                    return;
                case 8:
                    if (intent != null) {
                        x.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_GALLERY_OP");
                        SnsCmdList snsCmdList = (SnsCmdList) intent.getParcelableExtra("sns_cmd_list");
                        if (snsCmdList != null) {
                            this.rRm.a(-1, snsCmdList.qWR, snsCmdList.qWS);
                            return;
                        }
                        return;
                    }
                    return;
                case 9:
                    ae.bwb().buT();
                    BackwardSupportUtil.c.a(this.nQn);
                    return;
                case 10:
                    if (intent != null && i2 == -1) {
                        Cursor managedQuery = this.mActivity.managedQuery(intent.getData(), null, null, null, null);
                        if (managedQuery.moveToFirst()) {
                            this.mActivity.startActivity(new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/" + managedQuery.getString(managedQuery.getColumnIndexOrThrow("_id")))));
                            return;
                        }
                        return;
                    }
                    return;
                case 12:
                    a = intent.getIntExtra("sns_gallery_op_id", -1);
                    if (a > 0) {
                        x.d("MicroMsg.SnsActivity", "notify cause by del item");
                        SnsCmdList snsCmdList2 = new SnsCmdList();
                        snsCmdList2.wL(a);
                        this.rRm.a(-1, snsCmdList2.qWR, snsCmdList2.qWS);
                        return;
                    }
                    return;
                case 13:
                    ae.bwk().avc();
                    return;
                case 14:
                    new ag(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            com.tencent.mm.plugin.sns.c.a.ihO.up();
                        }
                    });
                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                    if ((stringArrayListExtra == null || stringArrayListExtra.size() <= 0) && bi.oN(intent.getStringExtra("K_SEGMENTVIDEOPATH"))) {
                        Serializable stringArrayListExtra2 = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                        if (stringArrayListExtra2 == null || stringArrayListExtra2.size() == 0) {
                            x.i("MicroMsg.SnsActivity", "no image selected");
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        Iterator it = stringArrayListExtra2.iterator();
                        while (it.hasNext()) {
                            if (Exif.fromFile((String) it.next()).getLocation() != null) {
                                arrayList.add(String.format("%s\n%f\n%f", new Object[]{(String) it.next(), Double.valueOf(Exif.fromFile((String) it.next()).getLocation().latitude), Double.valueOf(Exif.fromFile((String) it.next()).getLocation().longitude)}));
                            }
                        }
                        this.qXf = intent.getBooleanExtra("isTakePhoto", false);
                        Intent intent3 = new Intent(this.mActivity, SnsUploadUI.class);
                        intent3.putExtra("KSnsPostManu", true);
                        intent3.putExtra("KTouchCameraTime", bi.Wx());
                        if (this.rRo != null) {
                            this.rRo.b(intent3, "intent_key_StatisticsOplog");
                            this.rRo = null;
                        }
                        if (this.rzo) {
                            intent3.putExtra("Ksnsupload_source", 11);
                        }
                        int intExtra = intent.getIntExtra("CropImage_filterId", 0);
                        intent3.putExtra("sns_kemdia_path_list", stringArrayListExtra2);
                        intent3.putExtra("KFilterId", intExtra);
                        if (this.qXf) {
                            intent3.putExtra("Kis_take_photo", true);
                        }
                        intent3.putStringArrayListExtra("sns_media_latlong_list", arrayList);
                        x.d("MicroMsg.SnsActivity", "shared type %d", Integer.valueOf(intent3.getIntExtra("Ksnsupload_type", -1)));
                        this.mActivity.startActivityForResult(intent3, 6);
                        return;
                    }
                    String stringExtra;
                    if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                        stringExtra = intent.getStringExtra("K_SEGMENTVIDEOPATH");
                    } else {
                        stringExtra = (String) stringArrayListExtra.get(0);
                    }
                    String stringExtra2 = intent.getStringExtra("KSEGMENTVIDEOTHUMBPATH");
                    if (bi.oN(stringExtra2) || !FileOp.bO(stringExtra2)) {
                        stringExtra2 = ae.getAccSnsTmpPath() + com.tencent.mm.a.g.bV(stringExtra);
                        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                        try {
                            mediaMetadataRetriever.setDataSource(stringExtra);
                            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0);
                            if (frameAtTime == null) {
                                x.e("MicroMsg.SnsActivity", "get bitmap error");
                                try {
                                    mediaMetadataRetriever.release();
                                    return;
                                } catch (Exception e) {
                                    return;
                                }
                            }
                            x.i("MicroMsg.SnsActivity", "getBitmap1 %d %d", Integer.valueOf(frameAtTime.getWidth()), Integer.valueOf(frameAtTime.getHeight()));
                            com.tencent.mm.sdk.platformtools.d.a(frameAtTime, 80, CompressFormat.JPEG, stringExtra2, true);
                            Options Vq = com.tencent.mm.sdk.platformtools.d.Vq(stringExtra2);
                            x.i("MicroMsg.SnsActivity", "getBitmap2 %d %d", Integer.valueOf(Vq.outWidth), Integer.valueOf(Vq.outHeight));
                            try {
                                mediaMetadataRetriever.release();
                            } catch (Exception e2) {
                            }
                        } catch (Exception e3) {
                            x.e("MicroMsg.SnsActivity", "savebitmap error %s", e3.getMessage());
                            try {
                                mediaMetadataRetriever.release();
                            } catch (Exception e4) {
                            }
                        } catch (Throwable th) {
                            try {
                                mediaMetadataRetriever.release();
                            } catch (Exception e5) {
                            }
                            throw th;
                        }
                    }
                    x.i("MicroMsg.SnsActivity", "video path %s thumb path %s and %s %s ", stringExtra, stringExtra2, Long.valueOf(FileOp.mi(stringExtra)), Long.valueOf(FileOp.mi(stringExtra2)));
                    Intent intent4 = new Intent();
                    intent4.putExtra("KSightPath", stringExtra);
                    intent4.putExtra("KSightThumbPath", stringExtra2);
                    intent4.putExtra("sight_md5", com.tencent.mm.a.g.bV(stringExtra));
                    intent4.putExtra("KSnsPostManu", true);
                    intent4.putExtra("KTouchCameraTime", bi.Wx());
                    intent4.putExtra("Ksnsupload_type", 14);
                    intent4.putExtra("Kis_take_photo", false);
                    com.tencent.mm.bl.d.b(this.mActivity, "sns", ".ui.SnsUploadUI", intent4);
                    return;
                case 15:
                    return;
                case 17:
                    SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult == null) {
                        return;
                    }
                    if (sightCaptureResult.owf) {
                        this.filePath = sightCaptureResult.own;
                        if (!bi.oN(this.filePath)) {
                            this.qXf = true;
                            V(intent);
                            return;
                        }
                        return;
                    }
                    x.i("MicroMsg.SnsActivity", "video path %s thumb path ", sightCaptureResult.owh, sightCaptureResult.owi);
                    Intent intent5 = new Intent();
                    intent5.putExtra("KSightPath", sightCaptureResult.owh);
                    intent5.putExtra("KSightThumbPath", sightCaptureResult.owi);
                    if (bi.oN(sightCaptureResult.owk)) {
                        intent5.putExtra("sight_md5", com.tencent.mm.a.g.bV(sightCaptureResult.owh));
                    } else {
                        intent5.putExtra("sight_md5", sightCaptureResult.owk);
                    }
                    intent5.putExtra("KSnsPostManu", true);
                    intent5.putExtra("KTouchCameraTime", bi.Wx());
                    intent5.putExtra("Ksnsupload_type", 14);
                    intent5.putExtra("Kis_take_photo", false);
                    try {
                        byte[] toByteArray = sightCaptureResult.owm.toByteArray();
                        if (toByteArray != null) {
                            intent5.putExtra("KMMSightExtInfo", toByteArray);
                        }
                    } catch (Exception e6) {
                        x.i("MicroMsg.SnsActivity", "put sight extinfo to snsuploadui error: %s", e6.getMessage());
                    }
                    com.tencent.mm.bl.d.b(this.mActivity, "sns", ".ui.SnsUploadUI", intent5);
                    return;
                default:
                    x.e("MicroMsg.SnsActivity", "onActivityResult: not found this requestCode");
                    return;
            }
        } else if (i == 5 || i == 2 || i == 4) {
            new ag(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    com.tencent.mm.plugin.sns.c.a.ihO.up();
                }
            });
        }
    }

    private void V(Intent intent) {
        new ag(Looper.getMainLooper()).post(new Runnable() {
            public final void run() {
                com.tencent.mm.plugin.sns.c.a.ihO.up();
            }
        });
        x.d("MicroMsg.SnsActivity", "onActivityResult CONTEXT_CHOSE_IMAGE_CONFIRM");
        x.d("MicroMsg.SnsActivity", "CONTEXT_CHOSE_IMAGE_CONFIRM filePath " + this.filePath);
        if (this.filePath != null) {
            int intExtra;
            String str = "pre_temp_sns_pic" + com.tencent.mm.a.g.s((this.filePath + System.currentTimeMillis()).getBytes());
            com.tencent.mm.plugin.sns.storage.r.Y(ae.getAccSnsTmpPath(), this.filePath, str);
            this.filePath = ae.getAccSnsTmpPath() + str;
            x.d("MicroMsg.SnsActivity", "newPath " + this.filePath);
            if (intent != null) {
                intExtra = intent.getIntExtra("CropImage_filterId", 0);
            } else {
                intExtra = 0;
            }
            Intent intent2 = new Intent(this.mActivity, SnsUploadUI.class);
            intent2.putExtra("KSnsPostManu", true);
            intent2.putExtra("KTouchCameraTime", bi.Wx());
            if (this.rRo != null) {
                this.rRo.b(intent2, "intent_key_StatisticsOplog");
                this.rRo = null;
            }
            intent2.putExtra("sns_kemdia_path", this.filePath);
            intent2.putExtra("KFilterId", intExtra);
            if (this.qXf) {
                intent2.putExtra("Kis_take_photo", true);
            }
            if (this.rzo) {
                intent2.putExtra("Ksnsupload_source", 11);
            }
            this.mActivity.startActivityForResult(intent2, 6);
            this.qXf = false;
        }
    }

    protected final boolean yi(final int i) {
        int i2 = 3;
        com.tencent.mm.kernel.g.Dr();
        if (com.tencent.mm.kernel.g.Dq().isSDCardAvailable()) {
            x.d("MicroMsg.SnsActivity", "selectPhoto " + i);
            if (i == 2) {
                Intent intent = new Intent();
                intent.putExtra("username", this.rOd);
                intent.setClass(this.mActivity, SettingSnsBackgroundUI.class);
                this.mActivity.startActivityForResult(intent, 7);
                return true;
            } else if (i != 1) {
                return true;
            } else {
                com.tencent.mm.kernel.g.Dr();
                int a = bi.a((Integer) com.tencent.mm.kernel.g.Dq().Db().get(68385, null), 0);
                com.tencent.mm.kernel.g.Dr();
                int a2 = bi.a((Integer) com.tencent.mm.kernel.g.Dq().Db().get(68386, null), 0);
                if (!this.rRj && a < 3 && a2 == 0) {
                    this.rRj = true;
                    Context context = this.mActivity;
                    OnClickListener anonymousClass4 = new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.kernel.g.Dr();
                            int a = bi.a((Integer) com.tencent.mm.kernel.g.Dq().Db().get(68386, null), 0) + 1;
                            com.tencent.mm.kernel.g.Dr();
                            com.tencent.mm.kernel.g.Dq().Db().set(68386, Integer.valueOf(a));
                            bb.this.yi(i);
                        }
                    };
                    com.tencent.mm.ui.base.i.a aVar = new com.tencent.mm.ui.base.i.a(context);
                    aVar.ES(j.qSN);
                    aVar.Zn(context.getString(j.qSO) + "\n\n" + context.getString(j.qSP));
                    aVar.EV(j.qST).a(anonymousClass4);
                    aVar.a(new com.tencent.mm.plugin.sns.ui.bc.AnonymousClass1());
                    aVar.ale().show();
                    return true;
                } else if (this.mActivity.getSharedPreferences(ad.cgf(), 0).getString("gallery", "1").equalsIgnoreCase("0")) {
                    com.tencent.mm.pluginsdk.ui.tools.k.a(this.mActivity, 2, null);
                    return true;
                } else {
                    a2 = com.tencent.mm.j.g.Af().getInt("SnsCanPickVideoFromAlbum", 1);
                    x.i("MicroMsg.SnsActivity", "takeVideo %d", Integer.valueOf(a2));
                    if (com.tencent.mm.platformtools.r.igH) {
                        a2 = 0;
                    }
                    if (a2 != 1 && a2 == 0) {
                        i2 = 1;
                    }
                    com.tencent.mm.pluginsdk.ui.tools.k.a(this.mActivity, 14, 9, 4, i2, false, null);
                    return true;
                }
            }
        }
        u.fJ(this.mActivity);
        return false;
    }

    public final void onDestroy() {
        if (this.rhb != null) {
            SnsHeader snsHeader = this.rhb;
            if (!(snsHeader.rHN == null || snsHeader.rHN.isRecycled())) {
                snsHeader.rHN.recycle();
            }
        }
        com.tencent.mm.kernel.g.Dr();
        if (com.tencent.mm.kernel.g.Do().CF()) {
            ae.bwc().K(this.mActivity);
            ae.bwa().b((b) this);
        }
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        com.tencent.mm.kernel.g.Dr();
        if (com.tencent.mm.kernel.g.Do().CF()) {
            ae.bwb().gDT.remove(this);
            av.qYx--;
        }
        this.rRh.setVisibility(8);
        ab.bAo();
        com.tencent.mm.kernel.g.Dr();
        if (com.tencent.mm.kernel.g.Do().CF()) {
            ae.bwc().start();
        }
        this.nQn.setAdapter(null);
    }

    public final void Ky(String str) {
    }

    public final void aF(String str, boolean z) {
    }

    public final void buX() {
        this.rhb.bBD();
    }

    protected final void iJ(boolean z) {
        x.d("MicroMsg.SnsActivity", "snsactivty onIsAll ");
        this.rRh.iJ(z);
    }

    protected final void xN(int i) {
        x.d("MicroMsg.SnsActivity", "snsactivty onIsRecent ");
        this.rRh.xN(i);
    }

    public final void M(int i, boolean z) {
        this.rRm.M(i, z);
    }

    public final void bwO() {
        if (this.rhb != null) {
            this.rhb.bBD();
        }
    }

    public final void aE(String str, boolean z) {
        if (this.rRm.getType() == 1 && this.nQn != null && this.nQn.getAdapter() != null && (this.nQn.getAdapter() instanceof ax)) {
            ((ax) this.nQn.getAdapter()).notifyDataSetChanged();
        }
    }

    public final ListView bCu() {
        return this.rRm.bCu();
    }
}
