package com.tencent.mm.plugin.favorite.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.f.a.ca;
import com.tencent.mm.f.a.mr;
import com.tencent.mm.f.a.mt;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.plugin.favorite.ui.base.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.tools.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class FavImgGalleryUI extends MMActivity implements OnItemSelectedListener, i {
    private boolean fCQ = true;
    private l jAo;
    private ArrayList<d> jRO;
    private MMGestureGallery kXH;
    private p.d lKE = new p.d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            d qc = FavImgGalleryUI.this.mxZ.qc(FavImgGalleryUI.this.mxY);
            if (qc != null) {
                String h = j.h(qc.fvZ);
                if (e.bO(h)) {
                    switch (menuItem.getItemId()) {
                        case 0:
                            g.pWK.h(10651, Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(0));
                            if (com.tencent.mm.sdk.platformtools.p.Vw(h)) {
                                Intent intent = new Intent();
                                intent.putExtra("Select_Conv_Type", 3);
                                intent.putExtra("select_is_ret", true);
                                com.tencent.mm.bl.d.a(FavImgGalleryUI.this, ".ui.transmit.SelectConversationUI", intent, 1);
                                return;
                            }
                            com.tencent.mm.plugin.favorite.d.d(h, FavImgGalleryUI.this);
                            return;
                        case 1:
                            com.tencent.mm.plugin.favorite.d.c(h, FavImgGalleryUI.this);
                            g.pWK.h(10651, Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0));
                            return;
                        case 2:
                            com.tencent.mm.plugin.favorite.d.a(h, FavImgGalleryUI.this.getString(R.l.egG), FavImgGalleryUI.this);
                            return;
                        case 3:
                            mt mtVar = (mt) FavImgGalleryUI.this.mya.get(h);
                            if (mtVar != null) {
                                com.tencent.mm.sdk.b.b caVar = new ca();
                                caVar.fqV.activity = FavImgGalleryUI.this;
                                caVar.fqV.fpo = mtVar.fFy.result;
                                caVar.fqV.fqW = mtVar.fFy.fqW;
                                caVar.fqV.fqY = 7;
                                if (!(qc == null || qc.fvZ == null)) {
                                    caVar.fqV.imagePath = qc.fvZ.wjN;
                                    caVar.fqV.frb = qc.fvZ.wjP;
                                }
                                caVar.fqV.fqX = mtVar.fFy.fqX;
                                Bundle bundle = new Bundle(1);
                                bundle.putInt("stat_scene", 5);
                                caVar.fqV.frc = bundle;
                                com.tencent.mm.sdk.b.a.xmy.m(caVar);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                }
                x.w("MicroMsg.FavImgGalleryUI", "file not exists");
            }
        }
    };
    private int mxY = 0;
    private a mxZ;
    private Map<String, mt> mya = new HashMap();
    private c myb = new c<mt>() {
        {
            this.xmG = mt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            mt mtVar = (mt) bVar;
            FavImgGalleryUI.this.mya.put(mtVar.fFy.filePath, mtVar);
            if (FavImgGalleryUI.this.jAo != null && FavImgGalleryUI.this.jAo.rQE.isShowing()) {
                FavImgGalleryUI.a(FavImgGalleryUI.this);
            }
            return true;
        }
    };

    private class b {
        ProgressBar lFV;
        View myg;
        MultiTouchImageView myh;
        ImageView myi;
        TextView myj;
        LinearLayout myk;
        TextView myl;

        private b() {
        }

        /* synthetic */ b(FavImgGalleryUI favImgGalleryUI, byte b) {
            this();
        }
    }

    private class a extends BaseAdapter {
        SparseBooleanArray myf;

        private a() {
            this.myf = new SparseBooleanArray();
        }

        /* synthetic */ a(FavImgGalleryUI favImgGalleryUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            return qc(i);
        }

        public final int getCount() {
            return FavImgGalleryUI.this.jRO.size();
        }

        public final d qc(int i) {
            if (i < FavImgGalleryUI.this.jRO.size()) {
                return (d) FavImgGalleryUI.this.jRO.get(i);
            }
            x.w("MicroMsg.FavImgGalleryUI", "get item fail, position %d error", Integer.valueOf(i));
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                b bVar2 = new b(FavImgGalleryUI.this, (byte) 0);
                view = View.inflate(FavImgGalleryUI.this.mController.xRr, R.i.dhB, null);
                bVar2.myg = view.findViewById(R.h.cpf);
                bVar2.myh = (MultiTouchImageView) view.findViewById(R.h.image);
                bVar2.lFV = (ProgressBar) view.findViewById(R.h.ccX);
                bVar2.myi = (ImageView) view.findViewById(R.h.cRp);
                bVar2.myj = (TextView) view.findViewById(R.h.ccY);
                bVar2.myk = (LinearLayout) view.findViewById(R.h.cgG);
                bVar2.myl = (TextView) view.findViewById(R.h.cgH);
                bVar2.myl.setText(R.l.efa);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            view.setLayoutParams(new LayoutParams(-1, -1));
            d qc = qc(i);
            boolean z = this.myf.get(i, true);
            this.myf.put(i, false);
            Bitmap a = h.a(qc.fvZ, qc.mAQ, z);
            if (qc.mAQ != null) {
                x.i("MicroMsg.FavImgGalleryUI", "index %d item favid %d, localid %d, itemStatus %d", Integer.valueOf(i), Integer.valueOf(qc.mAQ.field_id), Long.valueOf(qc.mAQ.field_localId), Integer.valueOf(qc.mAQ.field_itemStatus));
            }
            if (qc.fvZ != null) {
                x.i("MicroMsg.FavImgGalleryUI", "item dataId %s, item data url %s, key %s, fullsize %d, thumb url %s, key %s, thumb size %d", qc.fvZ.mBr, qc.fvZ.wjN, qc.fvZ.wjP, Long.valueOf(qc.fvZ.wki), qc.fvZ.hcU, qc.fvZ.wjJ, Long.valueOf(qc.fvZ.wkt));
            }
            if (a == null) {
                FavImgGalleryUI.this.enableOptionMenu(false);
                x.w("MicroMsg.FavImgGalleryUI", "get big image fail");
                com.tencent.mm.plugin.fav.a.c Ay = com.tencent.mm.plugin.favorite.h.aIZ().Ay(qc.fvZ != null ? qc.fvZ.mBr : "");
                if (Ay == null) {
                    bVar.myk.setVisibility(8);
                    if (qc.mAQ == null || qc.mAQ.field_id >= 0) {
                        bVar.lFV.setVisibility(8);
                        bVar.myj.setVisibility(8);
                        bVar.myi.setVisibility(8);
                        bVar.myg.setVisibility(0);
                        if (qc.fvZ.wkV != 0) {
                            bVar.myk.setVisibility(0);
                        }
                        b(bVar, a(qc), "");
                    } else {
                        bVar.lFV.setVisibility(0);
                        bVar.myj.setVisibility(0);
                        bVar.myi.setVisibility(0);
                        bVar.myg.setVisibility(8);
                        bVar.myi.setImageBitmap(a(qc));
                        bVar.lFV.setProgress(0);
                        bVar.myj.setText(new StringBuilder("0%").toString());
                    }
                } else {
                    x.i("MicroMsg.FavImgGalleryUI", "fav cdnInfo status %d", Integer.valueOf(Ay.field_status));
                    bVar.lFV.setVisibility(0);
                    bVar.myj.setVisibility(0);
                    bVar.myi.setVisibility(0);
                    bVar.myg.setVisibility(8);
                    bVar.myi.setImageBitmap(a(qc));
                    int i2 = Ay.field_totalLen > 0 ? ((Ay.field_offset * 100) / Ay.field_totalLen) - 1 : 0;
                    if (i2 < 0) {
                        i2 = 0;
                    }
                    bVar.lFV.setProgress(i2);
                    bVar.myj.setText(i2 + "%");
                }
            } else {
                FavImgGalleryUI.this.enableOptionMenu(true);
                if (com.tencent.mm.sdk.platformtools.p.Vw(j.h(qc.fvZ))) {
                    a(bVar, a, j.h(qc.fvZ));
                } else {
                    a(bVar, a, "");
                }
            }
            return view;
        }

        private void a(b bVar, Bitmap bitmap, String str) {
            bVar.lFV.setVisibility(8);
            bVar.myj.setVisibility(8);
            bVar.myi.setVisibility(8);
            bVar.myg.setVisibility(0);
            bVar.myk.setVisibility(8);
            b(bVar, bitmap, str);
        }

        private Bitmap a(d dVar) {
            if (dVar != null) {
                Bitmap a = h.a(dVar.fvZ, dVar.mAQ);
                if (a != null) {
                    return a;
                }
            }
            return com.tencent.mm.compatible.g.a.decodeResource(FavImgGalleryUI.this.getResources(), R.k.dyE);
        }

        private void b(b bVar, Bitmap bitmap, String str) {
            com.tencent.mm.sdk.platformtools.l.k(bVar.myh, bitmap.getWidth(), bitmap.getHeight());
            int width = bVar.myh.getWidth();
            int height = bVar.myh.getHeight();
            Matrix matrix = new Matrix();
            matrix.reset();
            float width2 = ((float) bitmap.getWidth()) / ((float) bitmap.getHeight());
            float height2 = ((float) bitmap.getHeight()) / ((float) bitmap.getWidth());
            x.v("MicroMsg.FavImgGalleryUI", "whDiv is " + width2 + " hwDiv is " + height2);
            if (height2 >= 2.0f && bitmap.getHeight() >= 480) {
                height2 = ((float) width) / ((float) bitmap.getWidth());
                if (((double) (((float) bitmap.getWidth()) / ((float) width))) > 1.0d) {
                    matrix.postScale(height2, height2);
                    bitmap.getHeight();
                    matrix.postTranslate((((float) width) - (height2 * ((float) bitmap.getWidth()))) / 2.0f, 0.0f);
                } else {
                    matrix.postScale(1.0f, 1.0f);
                    matrix.postTranslate((float) ((width - bitmap.getWidth()) / 2), 0.0f);
                }
            } else if (width2 < 2.0f || bitmap.getWidth() < 480) {
                width2 = ((float) width) / ((float) bitmap.getWidth());
                height2 = ((float) height) / ((float) bitmap.getHeight());
                if (width2 >= height2) {
                    width2 = height2;
                }
                height2 = ((float) bitmap.getWidth()) / ((float) width);
                float height3 = ((float) bitmap.getHeight()) / ((float) height);
                if (height2 <= height3) {
                    height2 = height3;
                }
                if (((double) height2) > 1.0d) {
                    matrix.postScale(width2, width2);
                } else {
                    width2 = 1.0f;
                }
                matrix.postTranslate((((float) width) - (((float) bitmap.getWidth()) * width2)) / 2.0f, (((float) height) - (width2 * ((float) bitmap.getHeight()))) / 2.0f);
            } else {
                width2 = ((float) bitmap.getHeight()) / 480.0f;
                height2 = 480.0f / ((float) bitmap.getHeight());
                if (((double) width2) > 1.0d) {
                    matrix.postScale(width2, height2);
                    matrix.postTranslate(0.0f, (float) ((height - 480) / 2));
                } else {
                    matrix.postScale(1.0f, 1.0f);
                    width2 = (float) ((height - bitmap.getHeight()) / 2);
                    x.d("MicroMsg.FavImgGalleryUI", " offsety " + width2);
                    matrix.postTranslate(0.0f, width2);
                }
            }
            bVar.myh.setImageMatrix(matrix);
            bVar.myh.eV(bitmap.getWidth(), bitmap.getHeight());
            bVar.myh.ynW = true;
            if (bi.oN(str)) {
                bVar.myh.setImageBitmap(bitmap);
                return;
            }
            try {
                Drawable cVar = new com.tencent.mm.plugin.gif.c(str);
                MultiTouchImageView multiTouchImageView = bVar.myh;
                multiTouchImageView.yod = true;
                multiTouchImageView.yoe = cVar;
                multiTouchImageView.setImageDrawable(multiTouchImageView.yoe);
                multiTouchImageView = bVar.myh;
                int eB = com.tencent.mm.bu.a.eB(FavImgGalleryUI.this.mController.xRr);
                multiTouchImageView.mdF = com.tencent.mm.bu.a.eC(FavImgGalleryUI.this.mController.xRr);
                multiTouchImageView.mdE = eB;
                bVar.myh.eV(cVar.getIntrinsicWidth(), cVar.getIntrinsicHeight());
                MultiTouchImageView multiTouchImageView2 = bVar.myh;
                if (multiTouchImageView2.yod && multiTouchImageView2.yoe != null) {
                    ((com.tencent.mm.ui.e.b.a) multiTouchImageView2.yoe).start();
                }
                bVar.myh.cqJ();
            } catch (Throwable e) {
                x.e("MicroMsg.FavImgGalleryUI", bi.i(e));
                bVar.myh.setImageBitmap(bitmap);
            }
        }
    }

    static /* synthetic */ void a(FavImgGalleryUI favImgGalleryUI) {
        final List arrayList = new ArrayList();
        final List arrayList2 = new ArrayList();
        d qc = favImgGalleryUI.mxZ.qc(favImgGalleryUI.mxY);
        if (qc != null && qc.fvZ.wkV == 0) {
            if (qc.mAQ != null && qc.mAQ.aIq()) {
                arrayList.add(Integer.valueOf(0));
                arrayList2.add(favImgGalleryUI.getString(R.l.egM));
            }
            if (qc.mAQ != null && qc.mAQ.aIr()) {
                arrayList.add(Integer.valueOf(1));
                arrayList2.add(favImgGalleryUI.getString(R.l.ego));
            }
            arrayList.add(Integer.valueOf(2));
            arrayList2.add(favImgGalleryUI.getString(R.l.egH));
            String h = j.h(qc.fvZ);
            mt mtVar = (mt) favImgGalleryUI.mya.get(h);
            if (mtVar == null) {
                com.tencent.mm.sdk.b.b mrVar = new mr();
                mrVar.fFv.filePath = h;
                com.tencent.mm.sdk.b.a.xmy.m(mrVar);
            } else if (!bi.oN(mtVar.fFy.result)) {
                arrayList.add(Integer.valueOf(3));
                arrayList2.add(favImgGalleryUI.getString(com.tencent.mm.plugin.scanner.a.aF(mtVar.fFy.fqW, mtVar.fFy.result) ? R.l.egu : R.l.egt));
            }
            if (favImgGalleryUI.jAo == null) {
                favImgGalleryUI.jAo = new l(favImgGalleryUI.mController.xRr);
            }
            favImgGalleryUI.jAo.rQF = new p.c() {
                public final void a(n nVar) {
                    nVar.setHeaderTitle((CharSequence) "");
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < arrayList.size()) {
                            nVar.f(((Integer) arrayList.get(i2)).intValue(), (CharSequence) arrayList2.get(i2));
                            i = i2 + 1;
                        } else {
                            return;
                        }
                    }
                }
            };
            favImgGalleryUI.jAo.rQG = favImgGalleryUI.lKE;
            favImgGalleryUI.jAo.e(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    FavImgGalleryUI.this.jAo = null;
                }
            });
            com.tencent.mm.ui.base.h.a(favImgGalleryUI.mController.xRr, favImgGalleryUI.jAo.bCH());
        }
    }

    protected final int getLayoutId() {
        return R.i.dhC;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        this.fCQ = getIntent().getBooleanExtra("show_share", true);
        this.kXH = (MMGestureGallery) findViewById(R.h.ckv);
        this.kXH.setVerticalFadingEdgeEnabled(false);
        this.kXH.setHorizontalFadingEdgeEnabled(false);
        this.kXH.setOnItemSelectedListener(this);
        this.kXH.zuj = new f() {
            public final void awD() {
                FavImgGalleryUI.this.finish();
            }
        };
        if (this.fCQ) {
            this.kXH.zuk = new MMGestureGallery.c() {
                public final void aJP() {
                    if (!FavImgGalleryUI.this.isFinishing() && !FavImgGalleryUI.this.xQV) {
                        FavImgGalleryUI.a(FavImgGalleryUI.this);
                    }
                }
            };
        }
        fullScreenNoTitleBar(true);
        this.jRO = new ArrayList();
        this.mxZ = new a();
        this.kXH.setAdapter(this.mxZ);
        aJO();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                FavImgGalleryUI.this.finish();
                return true;
            }
        });
        com.tencent.mm.sdk.b.a.xmy.b(this.myb);
        setResult(0, getIntent());
    }

    private void aJO() {
        com.tencent.mm.plugin.fav.a.f fVar;
        Object fVar2;
        long longExtra = getIntent().getLongExtra("key_detail_info_id", -1);
        String stringExtra = getIntent().getStringExtra("key_detail_data_id");
        boolean booleanExtra = getIntent().getBooleanExtra("fav_open_from_wnnote", false);
        String stringExtra2 = getIntent().getStringExtra("fav_note_xml");
        List arrayList = new ArrayList();
        com.tencent.mm.plugin.fav.a.f dc = com.tencent.mm.plugin.favorite.h.getFavItemInfoStorage().dc(longExtra);
        String str = "MicroMsg.FavImgGalleryUI";
        String str2 = "show one fav info, local id is %d, get from db ok ? %B";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(longExtra);
        objArr[1] = Boolean.valueOf(dc != null);
        x.i(str, str2, objArr);
        if (!booleanExtra || bi.oN(stringExtra2)) {
            fVar2 = dc;
        } else {
            fVar2 = j.AK(stringExtra2);
        }
        if (fVar2 != null) {
            arrayList.add(fVar2);
        }
        this.jRO.clear();
        int i = -1;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            fVar2 = (com.tencent.mm.plugin.fav.a.f) arrayList.get(i2);
            int size2 = fVar2.field_favProto.wlY.size();
            int i3 = 0;
            while (i3 < size2) {
                int size3;
                uz uzVar = (uz) fVar2.field_favProto.wlY.get(i3);
                if ((uzVar.bjS != 8 || com.tencent.mm.sdk.platformtools.p.Vw(j.h(uzVar))) && (uzVar.bjS == 2 || uzVar.bjS == 8)) {
                    this.jRO.add(new d(fVar2, uzVar));
                    if (stringExtra != null && stringExtra.equals(uzVar.mBr)) {
                        size3 = this.jRO.size() - 1;
                        i3++;
                        i = size3;
                    }
                }
                size3 = i;
                i3++;
                i = size3;
            }
            if (stringExtra == null && fVar2.field_localId == longExtra) {
                i = this.jRO.size() - 1;
            }
        }
        getIntent().removeExtra("key_detail_info_id");
        getIntent().removeExtra("key_detail_data_id");
        this.mxZ.notifyDataSetChanged();
        this.kXH.post(new Runnable() {
            public final void run() {
                if (i != -1) {
                    x.d("MicroMsg.FavImgGalleryUI", "match selection %d", Integer.valueOf(i));
                    FavImgGalleryUI.this.kXH.setSelection(i);
                    FavImgGalleryUI.this.mxY = i;
                } else if (FavImgGalleryUI.this.mxY - 1 >= 0 && FavImgGalleryUI.this.mxY - 1 < FavImgGalleryUI.this.jRO.size()) {
                    x.d("MicroMsg.FavImgGalleryUI", "adjust selection %d, list size %d", Integer.valueOf(FavImgGalleryUI.this.mxY - 1), Integer.valueOf(FavImgGalleryUI.this.jRO.size()));
                    FavImgGalleryUI.this.kXH.setSelection(FavImgGalleryUI.this.mxY - 1);
                    FavImgGalleryUI.this.mxY = FavImgGalleryUI.this.mxY - 1;
                } else if (FavImgGalleryUI.this.jRO.size() > 0) {
                    x.d("MicroMsg.FavImgGalleryUI", "adjust selection fail, set selection 0, list size %d", Integer.valueOf(FavImgGalleryUI.this.jRO.size()));
                    FavImgGalleryUI.this.kXH.setSelection(0);
                    FavImgGalleryUI.this.mxY = 0;
                } else {
                    x.w("MicroMsg.FavImgGalleryUI", "data list size %d, empty, finish", Integer.valueOf(FavImgGalleryUI.this.jRO.size()));
                    FavImgGalleryUI.this.finish();
                }
            }
        });
    }

    protected void onDestroy() {
        getIntent().putExtra("key_activity_browse_time", cnN());
        com.tencent.mm.sdk.b.a.xmy.c(this.myb);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        com.tencent.mm.plugin.favorite.h.aIZ().a(this);
    }

    protected void onPause() {
        super.onPause();
        com.tencent.mm.plugin.favorite.h.aIZ().b((i) this);
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.mxY = i;
        x.d("MicroMsg.FavImgGalleryUI", "pos:" + i);
        if (view instanceof MultiTouchImageView) {
            ((MultiTouchImageView) view).cqG();
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public final void a(final com.tencent.mm.plugin.fav.a.c cVar) {
        if (cVar != null) {
            x.v("MicroMsg.FavImgGalleryUI", "on cdn status changed, status:%d", Integer.valueOf(cVar.field_status));
            d qc = this.mxZ.qc(this.mxY);
            if (qc != null && bi.aD(cVar.field_dataId, "").equals(qc.fvZ.mBr)) {
                ah.y(new Runnable() {
                    public final void run() {
                        int i = 0;
                        View selectedView = FavImgGalleryUI.this.kXH.getSelectedView();
                        if (selectedView != null) {
                            b bVar = (b) selectedView.getTag();
                            int i2 = cVar.field_totalLen > 0 ? ((cVar.field_offset * 100) / cVar.field_totalLen) - 1 : 0;
                            if (i2 >= 0) {
                                i = i2;
                            }
                            bVar.lFV.setProgress(i);
                            bVar.myj.setText(i + "%");
                            if (i >= 100 || cVar.isFinished()) {
                                FavImgGalleryUI.this.mxZ.notifyDataSetChanged();
                            }
                        }
                    }
                });
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (1 == i) {
            if (-1 == i2) {
                d qc = this.mxZ.qc(this.mxY);
                if (qc == null) {
                    x.i("MicroMsg.FavImgGalleryUI", "dataItem is null.");
                    return;
                }
                com.tencent.mm.plugin.favorite.a.d dVar = new com.tencent.mm.plugin.favorite.a.d();
                if (com.tencent.mm.plugin.favorite.a.d.k(qc.mAQ)) {
                    com.tencent.mm.ui.base.h.bu(this.mController.xRr, getString(R.l.dBY));
                    return;
                }
                x.d("MicroMsg.FavImgGalleryUI", "select %s for sending", intent.getStringExtra("Select_Conv_User"));
                final Dialog a = com.tencent.mm.ui.base.h.a(this.mController.xRr, getString(R.l.efM), false, null);
                com.tencent.mm.plugin.favorite.a.e.a(this.mController.xRr, r1, qc.mAQ, qc.fvZ, new Runnable() {
                    public final void run() {
                        a.dismiss();
                        com.tencent.mm.ui.snackbar.a.h(FavImgGalleryUI.this, FavImgGalleryUI.this.getString(R.l.eip));
                    }
                });
            } else {
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
