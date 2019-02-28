package com.tencent.mm.plugin.record.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.f.a.ca;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.f.a.mr;
import com.tencent.mm.f.a.mt;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.ui.RecordMsgImageUI;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.y.as;
import com.tencent.mm.y.u;
import java.util.HashMap;
import java.util.Map;

public final class a implements b {
    private ListView Fv;
    l jqz;
    OnLongClickListener mCu = new OnLongClickListener() {
        private Context context;
        private f mwn;
        private com.tencent.mm.plugin.record.ui.a.b pMp;
        private uz pMq;
        private String path;

        public final boolean onLongClick(View view) {
            if (view != null) {
                this.context = view.getContext();
                this.pMp = (com.tencent.mm.plugin.record.ui.a.b) view.getTag();
                this.mwn = this.pMp.pLp;
                this.pMq = this.pMp.fvZ;
            }
            com.tencent.mm.sdk.b.b fwVar = new fw();
            fwVar.fwl.type = 2;
            fwVar.fwl.fwn = this.pMp.fvZ;
            com.tencent.mm.sdk.b.a.xmy.m(fwVar);
            this.path = fwVar.fwm.path;
            if (e.bO(this.path)) {
                if (a.this.jqz == null) {
                    a.this.jqz = new l(this.context);
                }
                a.this.jqz.rQF = new c() {
                    public final void a(n nVar) {
                        if (AnonymousClass2.this.pMq.wkV == 0) {
                            if (AnonymousClass2.this.mwn.aIq()) {
                                nVar.f(2, AnonymousClass2.this.context.getString(R.l.egM));
                            }
                            if (AnonymousClass2.this.mwn.aIr()) {
                                nVar.f(1, AnonymousClass2.this.context.getString(R.l.ego));
                            }
                            nVar.f(3, AnonymousClass2.this.context.getString(R.l.egH));
                            mt mtVar = (mt) a.this.mya.get(AnonymousClass2.this.path);
                            if (mtVar == null) {
                                com.tencent.mm.sdk.b.b mrVar = new mr();
                                mrVar.fFv.filePath = AnonymousClass2.this.path;
                                com.tencent.mm.sdk.b.a.xmy.m(mrVar);
                            } else if (!bi.oN(mtVar.fFy.result)) {
                                nVar.f(4, AnonymousClass2.this.context.getString(com.tencent.mm.plugin.scanner.a.aF(mtVar.fFy.fqW, mtVar.fFy.result) ? R.l.eCE : R.l.eCD));
                            }
                        }
                    }
                };
                a.this.jqz.rQG = new d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        Intent intent;
                        switch (menuItem.getItemId()) {
                            case 1:
                                intent = new Intent();
                                intent.putExtra("Ksnsupload_type", 0);
                                intent.putExtra("sns_kemdia_path", AnonymousClass2.this.path);
                                String hC = u.hC("fav_");
                                u.GQ().t(hC, true).o("prePublishId", "fav_");
                                intent.putExtra("reportSessionId", hC);
                                com.tencent.mm.bl.d.b(AnonymousClass2.this.context, "sns", ".ui.SnsUploadUI", intent);
                                return;
                            case 2:
                                intent = new Intent();
                                intent.putExtra("Retr_File_Name", AnonymousClass2.this.path);
                                intent.putExtra("Retr_Compress_Type", 0);
                                intent.putExtra("Retr_Msg_Type", 0);
                                com.tencent.mm.bl.d.a(AnonymousClass2.this.context, ".ui.transmit.MsgRetransmitUI", intent);
                                return;
                            case 3:
                                if (!com.tencent.mm.platformtools.d.a(AnonymousClass2.this.path, AnonymousClass2.this.context, R.l.dYb)) {
                                    Toast.makeText(AnonymousClass2.this.context, AnonymousClass2.this.context.getString(R.l.egG), 1).show();
                                    return;
                                }
                                return;
                            case 4:
                                mt mtVar = (mt) a.this.mya.get(AnonymousClass2.this.path);
                                if (mtVar != null) {
                                    com.tencent.mm.sdk.b.b caVar = new ca();
                                    caVar.fqV.activity = (Activity) AnonymousClass2.this.context;
                                    caVar.fqV.fpo = mtVar.fFy.result;
                                    caVar.fqV.fqW = mtVar.fFy.fqW;
                                    caVar.fqV.fqX = mtVar.fFy.fqX;
                                    com.tencent.mm.sdk.b.a.xmy.m(caVar);
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    }
                };
                a.this.jqz.bCH();
            } else {
                x.w("MicroMsg.ImageViewWrapper", "file not exists");
            }
            return true;
        }
    };
    private OnClickListener myR = new OnClickListener() {
        public final void onClick(View view) {
            com.tencent.mm.plugin.record.ui.a.b bVar = (com.tencent.mm.plugin.record.ui.a.b) view.getTag();
            Intent intent;
            switch (bVar.bjS) {
                case 0:
                    intent = new Intent(view.getContext(), RecordMsgImageUI.class);
                    intent.putExtra("message_id", bVar.frh);
                    intent.putExtra("record_data_id", bVar.fvZ.mBr);
                    intent.putExtra("record_xml", bVar.fFB);
                    if ((view.getContext() instanceof Activity) && ((Activity) view.getContext()).getIntent() != null) {
                        Bundle bundleExtra = ((Activity) view.getContext()).getIntent().getBundleExtra("_stat_obj");
                        if (bundleExtra != null) {
                            intent.putExtra("_stat_obj", bundleExtra);
                        }
                    }
                    view.getContext().startActivity(intent);
                    return;
                case 1:
                    intent = new Intent();
                    intent.putExtra("key_detail_info_id", bVar.pLp.field_localId);
                    intent.putExtra("key_detail_data_id", bVar.fvZ.mBr);
                    com.tencent.mm.bl.d.b(view.getContext(), "favorite", ".ui.FavImgGalleryUI", intent, 1);
                    return;
                default:
                    return;
            }
        }
    };
    Map<String, mt> mya = new HashMap();
    private com.tencent.mm.sdk.b.c myb = new com.tencent.mm.sdk.b.c<mt>() {
        {
            this.xmG = mt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            mt mtVar = (mt) bVar;
            a.this.mya.put(mtVar.fFy.filePath, mtVar);
            if (a.this.jqz != null && a.this.jqz.rQE.isShowing()) {
                a.this.mCu.onLongClick(null);
            }
            return true;
        }
    };
    com.tencent.mm.plugin.record.ui.h.a pLK;
    int pMn;

    public a(com.tencent.mm.plugin.record.ui.h.a aVar, ListView listView) {
        this.pLK = aVar;
        this.Fv = listView;
        com.tencent.mm.sdk.b.a.xmy.b(this.myb);
    }

    public final View dq(Context context) {
        View inflate = View.inflate(context, R.i.dqD, null);
        this.pMn = com.tencent.mm.bu.a.fromDPToPix(context, 200);
        return inflate;
    }

    public final void a(View view, int i, final com.tencent.mm.plugin.record.ui.a.b bVar) {
        final ImageView imageView = (ImageView) view.findViewById(R.h.cHc);
        imageView.setTag(bVar);
        imageView.setOnClickListener(this.myR);
        if (bVar.bjS == 1) {
            imageView.setOnLongClickListener(this.mCu);
        }
        com.tencent.mm.plugin.record.ui.h.a.b bVar2 = new com.tencent.mm.plugin.record.ui.h.a.b();
        if (bVar.bjS == 0) {
            bVar2.pLM = bVar.frh;
        } else if (bVar.bjS == 1) {
            bVar2.pLM = bVar.pLp.field_localId;
        }
        bVar2.fvZ = bVar.fvZ;
        bVar2.fwc = true;
        bVar2.maxWidth = this.pMn;
        Bitmap a = this.pLK.a(bVar2);
        if (a != null) {
            x.d("MicroMsg.ImageViewWrapper", "get from dataId %s, cache %s", bVar2.fvZ.mBr, a);
            a(imageView, a, R.k.dyJ, bVar.fvZ.mBr);
            return;
        }
        as.Dt().F(new Runnable() {
            public final void run() {
                int i;
                int i2;
                Bitmap a;
                com.tencent.mm.plugin.record.ui.a.a aVar = (com.tencent.mm.plugin.record.ui.a.a) bVar;
                if (aVar.bjS == 0) {
                    if (h.g(aVar.fvZ, aVar.frh)) {
                        i = R.k.dAE;
                    }
                    i = -1;
                } else {
                    if (aVar.bjS == 1 && bi.oN(aVar.fvZ.wjN)) {
                        i = R.k.dAE;
                    }
                    i = -1;
                }
                if (i == -1) {
                    i2 = R.k.dyJ;
                } else {
                    i2 = i;
                }
                aVar = (com.tencent.mm.plugin.record.ui.a.a) bVar;
                com.tencent.mm.plugin.record.ui.h.a aVar2 = a.this.pLK;
                int i3 = a.this.pMn;
                com.tencent.mm.plugin.record.ui.h.a.b bVar = new com.tencent.mm.plugin.record.ui.h.a.b();
                bVar.fvZ = aVar.fvZ;
                bVar.fwc = false;
                bVar.maxWidth = i3;
                com.tencent.mm.plugin.record.ui.h.a.c cVar = new com.tencent.mm.plugin.record.ui.h.a.c();
                cVar.fvZ = aVar.fvZ;
                Bitmap a2;
                if (aVar.bjS == 0) {
                    if (!h.g(aVar.fvZ, aVar.frh)) {
                        bVar.pLM = aVar.frh;
                        a2 = aVar2.a(bVar);
                        if (a2 == null) {
                            cVar.pLM = aVar.frh;
                            a = aVar2.a(cVar);
                        }
                        a = a2;
                    }
                    a = null;
                } else {
                    if (aVar.bjS == 1) {
                        bVar.pLM = aVar.pLp.field_localId;
                        bVar.fwd = false;
                        a2 = aVar2.a(bVar);
                        if (a2 == null) {
                            cVar.pLM = aVar.pLp.field_localId;
                            a = aVar2.a(cVar);
                        }
                        a = a2;
                    }
                    a = null;
                }
                ah.y(new Runnable() {
                    public final void run() {
                        a.this.a(imageView, a, i2, bVar.fvZ.mBr);
                    }
                });
            }

            public final String toString() {
                return super.toString() + "|fillView";
            }
        });
    }

    final void a(ImageView imageView, Bitmap bitmap, int i, String str) {
        if (!((com.tencent.mm.plugin.record.ui.a.b) imageView.getTag()).fvZ.mBr.equals(str)) {
            x.d("MicroMsg.ImageViewWrapper", "scroll over to next img. old tag %s, now tag %s", str, imageView.getTag());
        } else if (bitmap == null) {
            LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.height = 200;
            layoutParams.width = 280;
            imageView.setImageResource(i);
            imageView.setBackgroundResource(R.e.bsZ);
        } else {
            Bitmap createBitmap;
            int i2;
            x.d("MicroMsg.ImageViewWrapper", "update view bmp[%d, %d], iv[%d, %d]", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), Integer.valueOf(imageView.getWidth()), Integer.valueOf(imageView.getHeight()));
            LayoutParams layoutParams2 = imageView.getLayoutParams();
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float f;
            float f2;
            if (height >= width) {
                f = ((float) height) / ((float) width);
                if (((double) f) > 2.5d) {
                    createBitmap = Bitmap.createBitmap(bitmap, 0, (bitmap.getHeight() - ((int) (((float) bitmap.getWidth()) * 2.5f))) / 2, bitmap.getWidth(), (int) (((float) bitmap.getWidth()) * 2.5f));
                    f2 = 2.5f;
                } else {
                    f2 = f;
                    createBitmap = bitmap;
                }
                if (f2 <= 2.0f) {
                    width = com.tencent.mm.bu.a.ab(imageView.getContext(), R.f.bux);
                    i2 = (int) (((float) width) / f2);
                } else {
                    i2 = com.tencent.mm.bu.a.ab(imageView.getContext(), R.f.buy);
                    width = (int) (((float) i2) * f2);
                }
            } else {
                f = ((float) width) / ((float) height);
                if (((double) f) > 2.5d) {
                    createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - ((int) (((float) bitmap.getHeight()) * 2.5f))) / 2, 0, (int) (((float) bitmap.getHeight()) * 2.5f), bitmap.getHeight());
                    f2 = 2.5f;
                } else {
                    f2 = f;
                    createBitmap = bitmap;
                }
                if (f2 <= 2.0f) {
                    i2 = com.tencent.mm.bu.a.ab(imageView.getContext(), R.f.bux);
                    width = (int) (((float) i2) / f2);
                } else {
                    width = com.tencent.mm.bu.a.ab(imageView.getContext(), R.f.buy);
                    i2 = (int) (((float) width) * f2);
                }
            }
            layoutParams2.width = i2;
            layoutParams2.height = width;
            imageView.setScaleType(ScaleType.FIT_XY);
            com.tencent.mm.sdk.platformtools.l.k(imageView, i2, width);
            if (imageView.getLayerType() == 1) {
                this.Fv.setLayerType(1, null);
            }
            imageView.setImageBitmap(createBitmap);
            imageView.setBackgroundResource(0);
        }
    }

    public final void destroy() {
        com.tencent.mm.sdk.b.a.xmy.c(this.myb);
    }

    public final void pause() {
    }
}
