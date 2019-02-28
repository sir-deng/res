package com.tencent.mm.plugin.record.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.f.a.ca;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.f.a.mr;
import com.tencent.mm.f.a.mt;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.pluginsdk.model.f;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class RecordMsgImageUI extends MMActivity implements c {
    private long frh = -1;
    private l jAo;
    private List<uz> kLl = new LinkedList();
    private MMGestureGallery kXH;
    private d lKE = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            switch (menuItem.getItemId()) {
                case 0:
                    RecordMsgImageUI.f(RecordMsgImageUI.this);
                    return;
                case 1:
                    Activity activity = RecordMsgImageUI.this;
                    cg cgVar = new cg();
                    f.a(cgVar, activity.getIntent().getIntExtra("key_favorite_source_type", 1), activity.bnO());
                    cgVar.frk.frr = 10;
                    cgVar.frk.activity = activity;
                    com.tencent.mm.sdk.b.a.xmy.m(cgVar);
                    return;
                case 2:
                    k.h(RecordMsgImageUI.this.bnO(), RecordMsgImageUI.this.mController.xRr);
                    return;
                case 3:
                    String h = RecordMsgImageUI.this.bnO();
                    if (!bi.oN(h)) {
                        mt mtVar = (mt) RecordMsgImageUI.this.mya.get(h);
                        if (mtVar != null) {
                            ca caVar = new ca();
                            caVar.fqV.activity = RecordMsgImageUI.this;
                            caVar.fqV.fpo = mtVar.fFy.result;
                            caVar.fqV.fqW = mtVar.fFy.fqW;
                            caVar.fqV.fqY = 8;
                            RecordMsgImageUI.a(RecordMsgImageUI.this, caVar);
                            caVar.fqV.fqX = mtVar.fFy.fqX;
                            if (RecordMsgImageUI.this.getIntent() != null) {
                                caVar.fqV.frc = RecordMsgImageUI.this.getIntent().getBundleExtra("_stat_obj");
                            }
                            com.tencent.mm.sdk.b.a.xmy.m(caVar);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private Runnable mxE = new Runnable() {
        public final void run() {
            RecordMsgImageUI.this.pMf.notifyDataSetChanged();
        }
    };
    private Map<String, mt> mya = new HashMap();
    private com.tencent.mm.sdk.b.c myb = new com.tencent.mm.sdk.b.c<mt>() {
        {
            this.xmG = mt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            mt mtVar = (mt) bVar;
            RecordMsgImageUI.this.mya.put(mtVar.fFy.filePath, mtVar);
            if (RecordMsgImageUI.this.jAo != null && RecordMsgImageUI.this.jAo.rQE.isShowing()) {
                RecordMsgImageUI.d(RecordMsgImageUI.this);
            }
            return true;
        }
    };
    private com.tencent.mm.plugin.record.b.f pLY;
    private a pMf;
    private int pMg = 0;
    private String pMh = null;

    private static class a extends BaseAdapter {
        long frh;
        List<uz> kLl;
        com.tencent.mm.plugin.record.b.f pLY;

        private a() {
            this.kLl = new LinkedList();
            this.frh = -1;
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            return vL(i);
        }

        public final int getCount() {
            return this.kLl.size();
        }

        public final uz vL(int i) {
            return (uz) this.kLl.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            com.tencent.mm.plugin.record.b.f fVar = this.pLY;
            uz vL = vL(i);
            long j = this.frh;
            Bitmap a = fVar.a(vL, j, false, false);
            if (a == null) {
                x.d("MicroMsg.RecordMsgImgService", "get image fail, try download, can retry:%B", Boolean.valueOf(fVar.a(vL, j)));
                h.a(vL, j, r0);
            }
            if (a == null) {
                x.w("MicroMsg.ShowImageUI", "get image fail");
                if (view == null || (view instanceof MultiTouchImageView)) {
                    view = View.inflate(viewGroup.getContext(), R.i.dsP, null);
                }
                ((ImageView) view.findViewById(R.h.cpm)).setImageResource(R.k.dyE);
                view.setLayoutParams(new LayoutParams(-1, -1));
            } else {
                Context context = viewGroup.getContext();
                if (view == null || !(view instanceof MultiTouchImageView)) {
                    view = new MultiTouchImageView(context, a.getWidth(), a.getHeight());
                } else {
                    MultiTouchImageView multiTouchImageView = (MultiTouchImageView) view;
                    multiTouchImageView.eV(a.getWidth(), a.getHeight());
                }
                com.tencent.mm.sdk.platformtools.l.k(view, a.getWidth(), a.getHeight());
                view.setLayoutParams(new LayoutParams(-1, -1));
                view.setImageBitmap(a);
                view.ynW = true;
            }
            return view;
        }
    }

    static /* synthetic */ void a(RecordMsgImageUI recordMsgImageUI, ca caVar) {
        int selectedItemPosition = recordMsgImageUI.kXH.getSelectedItemPosition();
        if (-1 == selectedItemPosition) {
            x.w("MicroMsg.ShowImageUI", "error position");
            return;
        }
        uz vL = recordMsgImageUI.pMf.vL(selectedItemPosition);
        if (vL != null) {
            caVar.fqV.imagePath = vL.wjN;
            caVar.fqV.frb = vL.wjP;
        }
    }

    static /* synthetic */ void d(RecordMsgImageUI recordMsgImageUI) {
        final List arrayList = new ArrayList();
        final List arrayList2 = new ArrayList();
        arrayList.add(Integer.valueOf(0));
        arrayList2.add(recordMsgImageUI.getString(R.l.eET));
        arrayList.add(Integer.valueOf(1));
        arrayList2.add(recordMsgImageUI.getString(R.l.eAq));
        arrayList.add(Integer.valueOf(2));
        arrayList2.add(recordMsgImageUI.getString(R.l.eHt));
        String bnO = recordMsgImageUI.bnO();
        mt mtVar = (mt) recordMsgImageUI.mya.get(bnO);
        if (mtVar == null) {
            b mrVar = new mr();
            mrVar.fFv.filePath = bnO;
            com.tencent.mm.sdk.b.a.xmy.m(mrVar);
        } else if (!bi.oN(mtVar.fFy.result)) {
            arrayList.add(Integer.valueOf(3));
            arrayList2.add(recordMsgImageUI.getString(com.tencent.mm.plugin.scanner.a.aF(mtVar.fFy.fqW, mtVar.fFy.result) ? R.l.eCE : R.l.eCD));
        }
        if (!recordMsgImageUI.isFinishing()) {
            if (recordMsgImageUI.jAo == null) {
                recordMsgImageUI.jAo = new l(recordMsgImageUI.mController.xRr);
            }
            recordMsgImageUI.jAo.rQF = new p.c() {
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
            recordMsgImageUI.jAo.rQG = recordMsgImageUI.lKE;
            recordMsgImageUI.jAo.e(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    RecordMsgImageUI.this.jAo = null;
                }
            });
            com.tencent.mm.ui.base.h.a(recordMsgImageUI.mController.xRr, recordMsgImageUI.jAo.bCH());
        }
    }

    static /* synthetic */ void f(RecordMsgImageUI recordMsgImageUI) {
        recordMsgImageUI.pMh = recordMsgImageUI.bnO();
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 0);
        intent.putExtra("image_path", recordMsgImageUI.pMh);
        com.tencent.mm.bl.d.a((Context) recordMsgImageUI, ".ui.transmit.SelectConversationUI", intent, 1001);
    }

    protected final int getLayoutId() {
        return R.i.dsO;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        this.pLY = new com.tencent.mm.plugin.record.b.f();
        this.frh = getIntent().getLongExtra("message_id", -1);
        String stringExtra = getIntent().getStringExtra("record_data_id");
        com.tencent.mm.protocal.b.a.c IP = h.IP(getIntent().getStringExtra("record_xml"));
        if (IP == null) {
            x.w("MicroMsg.ShowImageUI", "get record msg data error, empty");
            finish();
            return;
        }
        Iterator it = IP.hfI.iterator();
        while (it.hasNext()) {
            uz uzVar = (uz) it.next();
            if (uzVar.bjS == 2) {
                this.kLl.add(uzVar);
                if (uzVar.mBr.equals(stringExtra)) {
                    this.pMg = this.kLl.size() - 1;
                }
            }
        }
        if (this.kLl.isEmpty()) {
            x.w("MicroMsg.ShowImageUI", "get image data error, empty");
            finish();
            return;
        }
        this.kXH = (MMGestureGallery) findViewById(R.h.ckv);
        this.kXH.setVerticalFadingEdgeEnabled(false);
        this.kXH.setHorizontalFadingEdgeEnabled(false);
        this.pMf = new a();
        this.pMf.kLl = this.kLl;
        this.pMf.frh = this.frh;
        this.pMf.pLY = this.pLY;
        this.kXH.setAdapter(this.pMf);
        this.kXH.setSelection(this.pMg);
        this.kXH.setOnItemSelectedListener(new OnItemSelectedListener() {
            public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (h.d(RecordMsgImageUI.this.pMf.vL(i), RecordMsgImageUI.this.frh)) {
                    RecordMsgImageUI.this.setMMTitle(String.format("%d/%d", new Object[]{Integer.valueOf(i + 1), Integer.valueOf(RecordMsgImageUI.this.kLl.size())}));
                    RecordMsgImageUI.this.enableOptionMenu(true);
                    return;
                }
                RecordMsgImageUI.this.enableOptionMenu(false);
            }

            public final void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.kXH.zuj = new MMGestureGallery.f() {
            public final void awD() {
                RecordMsgImageUI.this.finish();
            }
        };
        this.kXH.zuk = new MMGestureGallery.c() {
            public final void aJP() {
                RecordMsgImageUI.d(RecordMsgImageUI.this);
            }
        };
        fullScreenNoTitleBar(true);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                RecordMsgImageUI.this.finish();
                return true;
            }
        });
        com.tencent.mm.plugin.record.b.n.getRecordMsgCDNStorage().a((c) this);
        com.tencent.mm.sdk.b.a.xmy.b(this.myb);
    }

    protected void onDestroy() {
        com.tencent.mm.plugin.record.b.n.getRecordMsgCDNStorage().b(this);
        this.pLY.destory();
        com.tencent.mm.sdk.b.a.xmy.c(this.myb);
        super.onDestroy();
    }

    final String bnO() {
        int selectedItemPosition = this.kXH.getSelectedItemPosition();
        if (-1 == selectedItemPosition) {
            x.w("MicroMsg.ShowImageUI", "error position");
            return null;
        }
        x.d("MicroMsg.ShowImageUI", "cur pos %d path %s", Integer.valueOf(selectedItemPosition), h.c(this.pMf.vL(selectedItemPosition), this.frh));
        return h.c(this.pMf.vL(selectedItemPosition), this.frh);
    }

    protected final void dealContentView(View view) {
        ae.c(ae.a(getWindow(), null), this.mController.xRd);
        ((ViewGroup) this.mController.xRd.getParent()).removeView(this.mController.xRd);
        ((ViewGroup) getWindow().getDecorView()).addView(this.mController.xRd, 0);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (1001 == i && -1 == i2) {
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            final String stringExtra2 = intent == null ? null : intent.getStringExtra("custom_send_text");
            if (!bi.oN(stringExtra)) {
                final List F = bi.F(stringExtra.split(","));
                if (bi.cC(F)) {
                    x.w("MicroMsg.ShowImageUI", "want to send record msg, but toUser is null");
                    return;
                }
                final Dialog a = com.tencent.mm.ui.base.h.a(this.mController.xRr, getString(R.l.efM), false, null);
                final Runnable anonymousClass10 = new Runnable() {
                    public final void run() {
                        a.dismiss();
                    }
                };
                as.Dt().F(new Runnable() {
                    public final void run() {
                        for (String str : F) {
                            com.tencent.mm.plugin.messenger.a.f.aZN().a(RecordMsgImageUI.this.mController.xRr, str, RecordMsgImageUI.this.pMh, 0, "", "");
                            com.tencent.mm.plugin.messenger.a.f.aZN().dq(stringExtra2, str);
                        }
                        ah.y(anonymousClass10);
                    }

                    public final String toString() {
                        return super.toString() + "|onActivityResult";
                    }
                });
                return;
            }
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void a(int i, com.tencent.mm.plugin.record.a.f fVar) {
        for (uz uzVar : this.kLl) {
            if (uzVar.mBr.equals(fVar.field_dataId)) {
                ah.y(this.mxE);
                return;
            }
        }
    }
}
