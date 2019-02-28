package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.List;

public class MultiTalkRoomPopupNav extends LinearLayout {
    public LinearLayout xTI;
    public View xTJ;
    public TextView xTK;
    public TextView xTL;
    public TextView xTM;
    public String xTN;
    public String xTO;
    public boolean xTP;
    public int xTQ = b.xUa;
    public a xTR;
    private final int xTS = 6;
    public LinearLayout xTT;
    public boolean xTU = false;
    public com.tencent.mm.at.b xTV = new com.tencent.mm.at.b();

    class a {
        private Button mpV;
        TextView titleView;
        LinearLayout xTX;

        /* synthetic */ a(MultiTalkRoomPopupNav multiTalkRoomPopupNav, boolean z, byte b) {
            this(z);
        }

        private a(boolean z) {
            this.mpV = (Button) MultiTalkRoomPopupNav.this.findViewById(R.h.cxT);
            this.titleView = (TextView) MultiTalkRoomPopupNav.this.findViewById(R.h.cyf);
            this.xTX = (LinearLayout) MultiTalkRoomPopupNav.this.findViewById(R.h.cxW);
            if (z) {
                this.xTX.setBackgroundResource(R.g.bDR);
                this.mpV.setTextColor(MultiTalkRoomPopupNav.this.getResources().getColor(R.e.btm));
                return;
            }
            this.xTX.setBackgroundResource(R.g.bDQ);
            this.mpV.setTextColor(MultiTalkRoomPopupNav.this.getResources().getColor(R.e.brF));
        }
    }

    enum b {
        ;

        static {
            xTY = 1;
            xTZ = 2;
            xUa = 3;
            xUb = new int[]{xTY, xTZ, xUa};
        }
    }

    static /* synthetic */ void YY(String str) {
        x.i("MicroMsg.MultiTalkRoomPopupNav", "when only on menber do clear banner!");
        com.tencent.mm.pluginsdk.q.a.vjf.Gg(str);
        x.i("MicroMsg.MultiTalkRoomPopupNav", "when only on member do exit talk!");
        if (!com.tencent.mm.pluginsdk.q.a.vjf.Ge(str)) {
            x.i("MicroMsg.MultiTalkRoomPopupNav", "when only on member do exit talk failure! groupId:" + str);
        }
    }

    static /* synthetic */ void a(MultiTalkRoomPopupNav multiTalkRoomPopupNav) {
        int i = 0;
        g gVar;
        Object[] objArr;
        if (multiTalkRoomPopupNav.xTN == null || multiTalkRoomPopupNav.xTO == null) {
            x.e("MicroMsg.MultiTalkRoomPopupNav", "groupUserName or currentSenderUserName is null! groupUserName:" + multiTalkRoomPopupNav.xTN + ",currentSenderUserName:" + multiTalkRoomPopupNav.xTO);
        } else if (!multiTalkRoomPopupNav.xTN.toLowerCase().endsWith("@chatroom") || multiTalkRoomPopupNav.xTP) {
            String str = multiTalkRoomPopupNav.xTN;
            if (com.tencent.mm.pluginsdk.q.a.vjf == null || !com.tencent.mm.pluginsdk.q.a.vjf.FY(str)) {
                x.e("MicroMsg.MultiTalkRoomPopupNav", "dealWithMultiTalkroomClick multiTalkInfo is null!");
                h.b(multiTalkRoomPopupNav.getContext(), ad.getContext().getString(R.l.ewV), null, true);
                multiTalkRoomPopupNav.coj();
                gVar = g.pWK;
                objArr = new Object[7];
                objArr[0] = Integer.valueOf(4);
                objArr[1] = Integer.valueOf(multiTalkRoomPopupNav.xTQ == b.xTY ? 1 : 0);
                objArr[2] = Integer.valueOf(0);
                objArr[3] = Integer.valueOf(1);
                objArr[4] = multiTalkRoomPopupNav.xTN;
                objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.xTV.field_roomId);
                objArr[6] = Long.valueOf(multiTalkRoomPopupNav.xTV.field_roomKey);
                gVar.h(13945, objArr);
                return;
            }
            List Ga = com.tencent.mm.pluginsdk.q.a.vjf.Ga(str);
            if (Ga.size() == 0) {
                x.e("MicroMsg.MultiTalkRoomPopupNav", "dealWithMultiTalkroomClick multiTalkMemberList is empty!");
                h.b(multiTalkRoomPopupNav.getContext(), ad.getContext().getString(R.l.ewV), null, true);
                multiTalkRoomPopupNav.coj();
                gVar = g.pWK;
                objArr = new Object[7];
                objArr[0] = Integer.valueOf(4);
                objArr[1] = Integer.valueOf(multiTalkRoomPopupNav.xTQ == b.xTY ? 1 : 0);
                objArr[2] = Integer.valueOf(0);
                objArr[3] = Integer.valueOf(1);
                objArr[4] = multiTalkRoomPopupNav.xTN;
                objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.xTV.field_roomId);
                objArr[6] = Long.valueOf(multiTalkRoomPopupNav.xTV.field_roomKey);
                gVar.h(13945, objArr);
                return;
            }
            if (Ga.size() == 1) {
                x.i("MicroMsg.MultiTalkRoomPopupNav", "just one now member now! wait for back service process!");
            }
            String string;
            List m;
            if (multiTalkRoomPopupNav.xTQ == b.xTZ) {
                multiTalkRoomPopupNav.xTU = true;
                Intent intent = new Intent();
                intent.putExtra("enterMainUiSource", 2);
                intent.putExtra("enterMainUiWxGroupId", str);
                d.b(ad.getContext(), "multitalk", ".ui.MultiTalkMainUI", intent);
                gVar = g.pWK;
                objArr = new Object[7];
                objArr[0] = Integer.valueOf(4);
                objArr[1] = Integer.valueOf(multiTalkRoomPopupNav.xTQ == b.xTY ? 1 : 0);
                objArr[2] = Integer.valueOf(0);
                objArr[3] = Integer.valueOf(0);
                objArr[4] = multiTalkRoomPopupNav.xTN;
                objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.xTV.field_roomId);
                objArr[6] = Long.valueOf(multiTalkRoomPopupNav.xTV.field_roomKey);
                gVar.h(13945, objArr);
            } else if (multiTalkRoomPopupNav.xTQ == b.xTY) {
                if (com.tencent.mm.pluginsdk.q.a.vjf.dx(str, multiTalkRoomPopupNav.xTO) != null) {
                    string = ad.getContext().getString(R.l.ebO, new Object[]{com.tencent.mm.pluginsdk.q.a.vjf.gw(com.tencent.mm.pluginsdk.q.a.vjf.dx(str, multiTalkRoomPopupNav.xTO))});
                    m = m(Ga, multiTalkRoomPopupNav.xTO);
                    Ga.size();
                    multiTalkRoomPopupNav.d(string, m, str);
                }
                gVar = g.pWK;
                objArr = new Object[7];
                objArr[0] = Integer.valueOf(4);
                objArr[1] = Integer.valueOf(multiTalkRoomPopupNav.xTQ == b.xTY ? 1 : 0);
                objArr[2] = Integer.valueOf(0);
                objArr[3] = Integer.valueOf(0);
                objArr[4] = multiTalkRoomPopupNav.xTN;
                objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.xTV.field_roomId);
                objArr[6] = Long.valueOf(multiTalkRoomPopupNav.xTV.field_roomKey);
                gVar.h(13945, objArr);
            } else if (com.tencent.mm.pluginsdk.q.a.vjf.bdo()) {
                h.b(multiTalkRoomPopupNav.getContext(), ad.getContext().getString(R.l.ewF), null, true);
                gVar = g.pWK;
                objArr = new Object[7];
                objArr[0] = Integer.valueOf(4);
                objArr[1] = Integer.valueOf(multiTalkRoomPopupNav.xTQ == b.xTY ? 1 : 0);
                objArr[2] = Integer.valueOf(0);
                objArr[3] = Integer.valueOf(1);
                objArr[4] = multiTalkRoomPopupNav.xTN;
                objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.xTV.field_roomId);
                objArr[6] = Long.valueOf(multiTalkRoomPopupNav.xTV.field_roomKey);
                gVar.h(13945, objArr);
            } else if (Ga.size() >= 9) {
                h.b(multiTalkRoomPopupNav.getContext(), ad.getContext().getString(R.l.ewH, new Object[]{Integer.valueOf(9)}), null, true);
                g gVar2 = g.pWK;
                Object[] objArr2 = new Object[7];
                objArr2[0] = Integer.valueOf(4);
                if (multiTalkRoomPopupNav.xTQ == b.xTY) {
                    i = 1;
                }
                objArr2[1] = Integer.valueOf(i);
                objArr2[2] = Integer.valueOf(1);
                objArr2[3] = Integer.valueOf(1);
                objArr2[4] = multiTalkRoomPopupNav.xTN;
                objArr2[5] = Integer.valueOf(multiTalkRoomPopupNav.xTV.field_roomId);
                objArr2[6] = Long.valueOf(multiTalkRoomPopupNav.xTV.field_roomKey);
                gVar2.h(13945, objArr2);
            } else {
                string = ad.getContext().getString(R.l.ewZ);
                m = m(Ga, "");
                Ga.size();
                multiTalkRoomPopupNav.d(string, m, str);
                g.pWK.h(13945, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), multiTalkRoomPopupNav.xTN, Integer.valueOf(multiTalkRoomPopupNav.xTV.field_roomId), Long.valueOf(multiTalkRoomPopupNav.xTV.field_roomKey));
            }
        } else {
            h.b(multiTalkRoomPopupNav.getContext(), ad.getContext().getString(R.l.ewM), null, true);
            multiTalkRoomPopupNav.coj();
            com.tencent.mm.pluginsdk.q.a.vjf.iI(multiTalkRoomPopupNav.xTN);
            gVar = g.pWK;
            objArr = new Object[7];
            objArr[0] = Integer.valueOf(4);
            objArr[1] = Integer.valueOf(multiTalkRoomPopupNav.xTQ == b.xTY ? 1 : 0);
            objArr[2] = Integer.valueOf(0);
            objArr[3] = Integer.valueOf(1);
            objArr[4] = multiTalkRoomPopupNav.xTN;
            objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.xTV.field_roomId);
            objArr[6] = Long.valueOf(multiTalkRoomPopupNav.xTV.field_roomKey);
            gVar.h(13945, objArr);
        }
    }

    static /* synthetic */ void a(MultiTalkRoomPopupNav multiTalkRoomPopupNav, String str) {
        x.i("MicroMsg.MultiTalkRoomPopupNav", "now try enter multitalk:" + str);
        g gVar;
        Object[] objArr;
        if (com.tencent.mm.pluginsdk.q.a.vjf.Gf(str)) {
            com.tencent.mm.pluginsdk.q.a.vjf.Gd(str);
            gVar = g.pWK;
            objArr = new Object[7];
            objArr[0] = Integer.valueOf(1);
            objArr[1] = Integer.valueOf(multiTalkRoomPopupNav.xTQ == b.xTY ? 1 : 0);
            objArr[2] = Integer.valueOf(0);
            objArr[3] = Integer.valueOf(0);
            objArr[4] = multiTalkRoomPopupNav.xTN;
            objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.xTV.field_roomId);
            objArr[6] = Long.valueOf(multiTalkRoomPopupNav.xTV.field_roomKey);
            gVar.h(13945, objArr);
            return;
        }
        x.e("MicroMsg.MultiTalkRoomPopupNav", "try enter fail!" + str);
        Toast.makeText(ad.getContext(), ad.getContext().getString(R.l.ewu), 0).show();
        gVar = g.pWK;
        objArr = new Object[7];
        objArr[0] = Integer.valueOf(1);
        objArr[1] = Integer.valueOf(multiTalkRoomPopupNav.xTQ == b.xTY ? 1 : 0);
        objArr[2] = Integer.valueOf(0);
        objArr[3] = Integer.valueOf(1);
        objArr[4] = multiTalkRoomPopupNav.xTN;
        objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.xTV.field_roomId);
        objArr[6] = Long.valueOf(multiTalkRoomPopupNav.xTV.field_roomKey);
        gVar.h(13945, objArr);
    }

    @TargetApi(11)
    public MultiTalkRoomPopupNav(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    public MultiTalkRoomPopupNav(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    private void initView() {
        inflate(getContext(), R.i.doE, this);
        this.xTI = (LinearLayout) findViewById(R.h.cyd);
        this.xTJ = findViewById(R.h.cyc);
        this.xTK = (TextView) findViewById(R.h.cyg);
        this.xTL = (TextView) findViewById(R.h.cyh);
        this.xTM = (TextView) findViewById(R.h.cyi);
        this.xTT = (LinearLayout) findViewById(R.h.cxY);
        this.xTI.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (com.tencent.mm.pluginsdk.q.a.vje != null && com.tencent.mm.pluginsdk.q.a.vjf.aW(MultiTalkRoomPopupNav.this.getContext())) {
                    x.d("MicroMsg.MultiTalkRoomPopupNav", "is voip talking");
                } else if (com.tencent.mm.pluginsdk.q.a.vje == null || !com.tencent.mm.pluginsdk.q.a.vje.aWq()) {
                    MultiTalkRoomPopupNav.a(MultiTalkRoomPopupNav.this);
                } else {
                    Toast.makeText(ad.getContext(), ad.getContext().getString(R.l.epF), 0).show();
                    x.d("MicroMsg.MultiTalkRoomPopupNav", "is show loation");
                }
            }
        });
    }

    public final void YX(String str) {
        this.xTJ.setBackgroundResource(R.g.bDQ);
        this.xTK.setTextColor(getResources().getColor(R.e.btm));
        this.xTK.setText(str);
        if (this.xTT == null || this.xTT.getVisibility() != 0) {
            this.xTK.setVisibility(0);
            this.xTM.setVisibility(8);
            this.xTL.setVisibility(8);
            this.xTT.setVisibility(8);
        }
    }

    public final void coj() {
        this.xTU = false;
        setVisibility(8);
        if (this.xTR != null) {
            this.xTR.xTX.setVisibility(8);
        }
    }

    private void d(String str, List<String> list, final String str2) {
        boolean z;
        this.xTJ.setVisibility(8);
        this.xTI.setVisibility(8);
        if (this.xTQ == b.xTY) {
            z = true;
        } else {
            z = false;
        }
        this.xTR = new a(this, z, (byte) 0);
        if (com.tencent.mm.pluginsdk.q.a.vjf != null) {
            a aVar = this.xTR;
            OnClickListener anonymousClass2 = new OnClickListener() {
                public final void onClick(View view) {
                    int i = 0;
                    x.i("MicroMsg.MultiTalkRoomPopupNav", "click enter button..");
                    if (str2 != null) {
                        if (com.tencent.mm.pluginsdk.q.a.vjf.bdo()) {
                            x.e("MicroMsg.MultiTalkRoomPopupNav", "now is in other voip..");
                            h.b(MultiTalkRoomPopupNav.this.getContext(), ad.getContext().getString(R.l.ewF), null, true);
                            return;
                        }
                        List Ga = com.tencent.mm.pluginsdk.q.a.vjf.Ga(MultiTalkRoomPopupNav.this.xTN);
                        if (Ga.size() == 1) {
                            MultiTalkRoomPopupNav.YY(str2);
                            g.pWK.h(13945, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), MultiTalkRoomPopupNav.this.xTN, Integer.valueOf(MultiTalkRoomPopupNav.this.xTV.field_roomId), Long.valueOf(MultiTalkRoomPopupNav.this.xTV.field_roomKey));
                        } else if (Ga.size() >= 9) {
                            x.e("MicroMsg.MultiTalkRoomPopupNav", "now is up to the limit,memberList size:" + Ga.size());
                            h.b(MultiTalkRoomPopupNav.this.getContext(), ad.getContext().getString(R.l.ewH, new Object[]{Integer.valueOf(9)}), null, true);
                            g gVar = g.pWK;
                            Object[] objArr = new Object[7];
                            objArr[0] = Integer.valueOf(1);
                            if (MultiTalkRoomPopupNav.this.xTQ == b.xTY) {
                                i = 1;
                            }
                            objArr[1] = Integer.valueOf(i);
                            objArr[2] = Integer.valueOf(1);
                            objArr[3] = Integer.valueOf(1);
                            objArr[4] = MultiTalkRoomPopupNav.this.xTN;
                            objArr[5] = Integer.valueOf(MultiTalkRoomPopupNav.this.xTV.field_roomId);
                            objArr[6] = Long.valueOf(MultiTalkRoomPopupNav.this.xTV.field_roomKey);
                            gVar.h(13945, objArr);
                            return;
                        } else if (com.tencent.mm.pluginsdk.q.a.vjf.bdn()) {
                            x.e("MicroMsg.MultiTalkRoomPopupNav", "now is inviting other people voip..");
                            h.b(MultiTalkRoomPopupNav.this.getContext(), ad.getContext().getString(R.l.ewE), null, true);
                            g gVar2 = g.pWK;
                            Object[] objArr2 = new Object[7];
                            objArr2[0] = Integer.valueOf(1);
                            objArr2[1] = Integer.valueOf(MultiTalkRoomPopupNav.this.xTQ == b.xTY ? 1 : 0);
                            objArr2[2] = Integer.valueOf(0);
                            objArr2[3] = Integer.valueOf(1);
                            objArr2[4] = MultiTalkRoomPopupNav.this.xTN;
                            objArr2[5] = Integer.valueOf(MultiTalkRoomPopupNav.this.xTV.field_roomId);
                            objArr2[6] = Long.valueOf(MultiTalkRoomPopupNav.this.xTV.field_roomKey);
                            gVar2.h(13945, objArr2);
                            return;
                        } else {
                            MultiTalkRoomPopupNav.a(MultiTalkRoomPopupNav.this, str2);
                        }
                    }
                    MultiTalkRoomPopupNav.this.xTR.xTX.setVisibility(8);
                    MultiTalkRoomPopupNav.this.xTI.setVisibility(0);
                    MultiTalkRoomPopupNav.this.xTJ.setVisibility(0);
                    MultiTalkRoomPopupNav.this.xTT.setVisibility(8);
                }
            };
            OnClickListener anonymousClass3 = new OnClickListener() {
                public final void onClick(View view) {
                    int i = 1;
                    x.i("MicroMsg.MultiTalkRoomPopupNav", "click cancel button..");
                    if (MultiTalkRoomPopupNav.this.xTQ == b.xTY) {
                        x.i("MicroMsg.MultiTalkRoomPopupNav", "reject multiTalk!");
                        boolean Gc = com.tencent.mm.pluginsdk.q.a.vjf.Gc(str2);
                        com.tencent.mm.pluginsdk.q.a.vjf.Gd(str2);
                        g gVar = g.pWK;
                        Object[] objArr = new Object[7];
                        objArr[0] = Integer.valueOf(3);
                        objArr[1] = Integer.valueOf(1);
                        objArr[2] = Integer.valueOf(0);
                        if (Gc) {
                            i = 0;
                        }
                        objArr[3] = Integer.valueOf(i);
                        objArr[4] = MultiTalkRoomPopupNav.this.xTN;
                        objArr[5] = Integer.valueOf(MultiTalkRoomPopupNav.this.xTV.field_roomId);
                        objArr[6] = Long.valueOf(MultiTalkRoomPopupNav.this.xTV.field_roomKey);
                        gVar.h(13945, objArr);
                    } else {
                        g.pWK.h(13945, Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), MultiTalkRoomPopupNav.this.xTN, Integer.valueOf(MultiTalkRoomPopupNav.this.xTV.field_roomId), Long.valueOf(MultiTalkRoomPopupNav.this.xTV.field_roomKey));
                    }
                    MultiTalkRoomPopupNav.this.xTR.xTX.setVisibility(8);
                    MultiTalkRoomPopupNav.this.xTI.setVisibility(0);
                    MultiTalkRoomPopupNav.this.xTJ.setVisibility(0);
                    MultiTalkRoomPopupNav.this.xTT.setVisibility(8);
                }
            };
            aVar.titleView.setText(str);
            aVar.xTX.setVisibility(0);
            aVar.xTW.xTT.setVisibility(0);
            aVar.xTW.xTT.removeAllViews();
            for (String str3 : list) {
                View imageView = new ImageView(aVar.xTW.getContext());
                LayoutParams layoutParams = new LinearLayout.LayoutParams(com.tencent.mm.bu.a.fromDPToPix(ad.getContext(), 26), com.tencent.mm.bu.a.fromDPToPix(ad.getContext(), 26));
                layoutParams.rightMargin = com.tencent.mm.bu.a.fromDPToPix(ad.getContext(), 10);
                imageView.setScaleType(ScaleType.FIT_CENTER);
                imageView.setLayoutParams(layoutParams);
                aVar.xTW.xTT.addView(imageView);
                com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str3, 0.1f, false);
            }
            ((Button) aVar.xTW.findViewById(R.h.cxU)).setOnClickListener(anonymousClass2);
            ((Button) aVar.xTW.findViewById(R.h.cxT)).setOnClickListener(anonymousClass3);
        }
    }

    public final void db(List<String> list) {
        if (this.xTT != null && this.xTT.getVisibility() == 0) {
            this.xTT.removeAllViews();
            for (String str : list) {
                View imageView = new ImageView(getContext());
                LayoutParams layoutParams = new LinearLayout.LayoutParams(com.tencent.mm.bu.a.fromDPToPix(ad.getContext(), 26), com.tencent.mm.bu.a.fromDPToPix(ad.getContext(), 26));
                layoutParams.rightMargin = com.tencent.mm.bu.a.fromDPToPix(ad.getContext(), 10);
                imageView.setScaleType(ScaleType.FIT_CENTER);
                imageView.setLayoutParams(layoutParams);
                this.xTT.addView(imageView);
                com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str, 0.1f, false);
            }
        }
    }

    public static List<String> m(List<String> list, String str) {
        List<String> arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        if (!(str == null || str == "")) {
            for (String str2 : list) {
                if (!(str2 == null || str2.equals(str))) {
                    arrayList2.add(str2);
                }
            }
            List list2 = arrayList2;
        }
        for (String str22 : list2) {
            arrayList.add(str22);
        }
        return arrayList;
    }
}
