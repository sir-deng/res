package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.be.f;
import com.tencent.mm.be.h;
import com.tencent.mm.be.j;
import com.tencent.mm.be.l;
import com.tencent.mm.f.a.iq;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.f.b.cb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public class FMessageListView extends LinearLayout {
    private Context context;
    private final LayoutParams nxG;
    com.tencent.mm.pluginsdk.ui.preference.a.a vzH;
    private com.tencent.mm.pluginsdk.d.a vzO;
    private com.tencent.mm.sdk.e.j.a vzP;
    private com.tencent.mm.sdk.e.j.a vzQ;
    a vzR;
    a vzS;
    private TextView vzT;

    static class a extends View {
        public a(Context context) {
            super(context);
            setLayoutParams(new LayoutParams(-1, 1));
        }
    }

    static /* synthetic */ void a(FMessageListView fMessageListView, String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.FMessageListView", "updateLbs, id is null");
            return;
        }
        long j;
        try {
            j = bi.getLong(str, 0);
        } catch (Exception e) {
            x.e("MicroMsg.FMessageListView", "updateLbs, id = " + str + ", ex = " + e.getMessage());
            j = 0;
        }
        if (j == 0) {
            x.e("MicroMsg.FMessageListView", "updateLbs fail, sysRowId is invalid");
            return;
        }
        x.d("MicroMsg.FMessageListView", "updateLbs succ, sysRowId = " + j);
        cb hVar = new h();
        if (!l.TF().b(j, (c) hVar)) {
            x.e("MicroMsg.FMessageListView", "updateLbs, get fail, id = " + j);
        } else if (fMessageListView.vzH == null || !fMessageListView.vzH.talker.equals(hVar.field_sayhiuser)) {
            x.d("MicroMsg.FMessageListView", "updateLbs, other talker, no need to process");
        } else {
            if (fMessageListView.vzH.mTU != null && fMessageListView.vzH.mTU.length() > 0) {
                fMessageListView.setVisibility(0);
            }
            fMessageListView.a(b.a(fMessageListView.context, hVar));
        }
    }

    static /* synthetic */ void b(FMessageListView fMessageListView, String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.FMessageListView", "updateFMsg, id is null");
            return;
        }
        long j;
        try {
            j = bi.getLong(str, 0);
        } catch (Exception e) {
            x.e("MicroMsg.FMessageListView", "updateFMsg, id = " + str + ", ex = " + e.getMessage());
            j = 0;
        }
        if (j == 0) {
            x.e("MicroMsg.FMessageListView", "updateFMsg fail, sysRowId is invalid");
            return;
        }
        x.d("MicroMsg.FMessageListView", "updateFMsg succ, sysRowId = " + j);
        f fVar = new f();
        if (!l.TD().b(j, (c) fVar)) {
            x.e("MicroMsg.FMessageListView", "updateFMsg, get fail, id = " + j);
        } else if (fMessageListView.vzH == null || !fMessageListView.vzH.talker.equals(fVar.field_talker)) {
            x.d("MicroMsg.FMessageListView", "updateFMsg, other talker, no need to process");
        } else {
            if (fMessageListView.vzH.mTU != null && fMessageListView.vzH.mTU.length() > 0) {
                fMessageListView.setVisibility(0);
            }
            fMessageListView.a(b.a(fMessageListView.context, fVar));
        }
    }

    static /* synthetic */ void c(FMessageListView fMessageListView, String str) {
        if (str == null || str.length() == 0) {
            x.e("MicroMsg.FMessageListView", "updateShake, id is null");
            return;
        }
        long j;
        try {
            j = bi.getLong(str, 0);
        } catch (Exception e) {
            x.e("MicroMsg.FMessageListView", "updateShake, id = " + str + ", ex = " + e.getMessage());
            j = 0;
        }
        if (j == 0) {
            x.e("MicroMsg.FMessageListView", "updateShake fail, sysRowId is invalid");
            return;
        }
        x.d("MicroMsg.FMessageListView", "updateShake succ, sysRowId = " + j);
        j jVar = new j();
        if (!l.TG().b(j, (c) jVar)) {
            x.e("MicroMsg.FMessageListView", "updateShake, get fail, id = " + j);
        } else if (fMessageListView.vzH == null || !fMessageListView.vzH.talker.equals(jVar.field_sayhiuser)) {
            x.d("MicroMsg.FMessageListView", "updateShake, other talker, no need to process");
        } else {
            if (fMessageListView.vzH.mTU != null && fMessageListView.vzH.mTU.length() > 0) {
                fMessageListView.setVisibility(0);
            }
            fMessageListView.a(b.a(fMessageListView.context, jVar));
        }
    }

    public FMessageListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FMessageListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.vzO = new com.tencent.mm.pluginsdk.d.a() {
            public final void j(b bVar) {
                if (bVar instanceof iq) {
                    FMessageListView.a(FMessageListView.this, ((iq) bVar).fzU.fpd);
                }
            }
        };
        this.vzP = new com.tencent.mm.sdk.e.j.a() {
            public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
                FMessageListView.b(FMessageListView.this, str);
            }
        };
        this.vzQ = new com.tencent.mm.sdk.e.j.a() {
            public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
                FMessageListView.c(FMessageListView.this, str);
            }
        };
        this.nxG = new LayoutParams(-1, -2);
        this.context = context;
        l.TD().c(this.vzP);
        com.tencent.mm.pluginsdk.d.a.a(iq.class.getName(), this.vzO);
        l.TG().c(this.vzQ);
    }

    public final void detach() {
        l.TD().j(this.vzP);
        com.tencent.mm.pluginsdk.d.a.b(iq.class.getName(), this.vzO);
        l.TG().j(this.vzQ);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof a) {
                e eVar = (a) childAt;
                as.CN().b(30, eVar);
                if (eVar.tipDialog != null && eVar.tipDialog.isShowing()) {
                    eVar.tipDialog.dismiss();
                }
            }
        }
        this.vzR = null;
        this.vzS = null;
    }

    public final void a(final b bVar) {
        if (bVar == null) {
            x.e("MicroMsg.FMessageListView", "addItem fail, provider is null");
        } else if (bVar.id <= 0) {
            x.e("MicroMsg.FMessageListView", "addItem fail, systemRowId invalid = " + bVar.id);
        } else {
            int i;
            String string;
            int childCount = getChildCount();
            for (i = 1; i < childCount; i++) {
                View childAt = getChildAt(i);
                if ((childAt instanceof a) && childAt.getTag() != null && childAt.getTag().equals(Long.valueOf(bVar.id))) {
                    x.w("MicroMsg.FMessageListView", "addItem, item repeated, sysRowId = " + bVar.id);
                    return;
                }
            }
            if (bVar.vzX != null) {
                if (this.vzT == null) {
                    this.vzT = (TextView) findViewById(R.h.bXy);
                }
                this.vzT.setText(bVar.vzX);
                this.vzT.setVisibility(0);
            }
            x.d("MicroMsg.FMessageListView", "addItem, current child count = " + childCount);
            if (childCount == 6) {
                x.i("MicroMsg.FMessageListView", "addItem, most 3 FMessageItemView, remove earliest");
                removeViewAt(1);
            }
            if (childCount == 1) {
                x.d("MicroMsg.FMessageListView", "addItem, current child count is 0, add two child view");
                this.vzR = new a(this.context);
                addView(this.vzR);
                this.vzS = new a(this.context);
                this.vzS.Tk("");
                this.vzS.CO(0);
                addView(this.vzS, this.nxG);
                as.Hm();
                ag Xv = com.tencent.mm.y.c.Ff().Xv(bVar.username);
                if (Xv == null || !com.tencent.mm.k.a.ga(Xv.field_type)) {
                    x.d("MicroMsg.FMessageListView", "addItem, reply btn visible, talker = " + bVar.username);
                    this.vzR.setVisibility(0);
                    this.vzS.setVisibility(0);
                } else {
                    x.d("MicroMsg.FMessageListView", "addItem, reply btn gone, talker = " + bVar.username);
                    this.vzR.setVisibility(8);
                    this.vzS.setVisibility(8);
                }
            }
            if (bVar.fMC) {
                string = this.context.getString(R.l.eiw, new Object[]{bVar.hfQ});
                i = 0;
            } else {
                String str;
                if (bVar.fqG == null || bVar.fqG.length() <= 0) {
                    str = bVar.username;
                    as.Hm();
                    com.tencent.mm.k.a Xv2 = com.tencent.mm.y.c.Ff().Xv(bVar.username);
                    if (Xv2 != null && ((int) Xv2.gKO) > 0) {
                        str = Xv2.AX();
                    }
                } else {
                    str = bVar.fqG;
                }
                string = str + ": " + bVar.hfQ;
                i = 1;
            }
            View aVar = new a(this.context);
            aVar.setTag(Long.valueOf(bVar.id));
            aVar.Tk(string);
            aVar.CO(8);
            if (i != 0) {
                aVar.setOnLongClickListener(new OnLongClickListener() {
                    public final boolean onLongClick(View view) {
                        x.d("MicroMsg.FMessageListView", "jacks long click digest");
                        com.tencent.mm.ui.base.h.a(FMessageListView.this.getContext(), null, new String[]{FMessageListView.this.getContext().getString(R.l.dQV)}, new com.tencent.mm.ui.base.h.c() {
                            public final void jo(int i) {
                                switch (i) {
                                    case 0:
                                        ((ClipboardManager) FMessageListView.this.getContext().getSystemService("clipboard")).setText(bVar.hfQ);
                                        return;
                                    default:
                                        return;
                                }
                            }
                        });
                        return true;
                    }
                });
            }
            addView(aVar, getChildCount() - 2, this.nxG);
        }
    }
}
