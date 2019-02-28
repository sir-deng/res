package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.model.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public final class m extends BaseAdapter {
    List<b> kOz = new ArrayList();
    OnClickListener lby;
    boolean lbz = false;
    private Context mContext;

    private class a {
        View kvL;
        TextView laB;
        TextView lbE;
        TextView lbF;
        ImageView lbG;
        CheckBox lbH;

        private a() {
        }

        /* synthetic */ a(m mVar, byte b) {
            this();
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return op(i);
    }

    public m(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.kOz.size();
    }

    private b op(int i) {
        return (b) this.kOz.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        final b op = op(i);
        switch (op.kPL) {
            case 2:
                view = View.inflate(this.mContext, R.i.dbO, null);
                TextView textView = (TextView) view.findViewById(R.h.bPZ);
                TextView textView2 = (TextView) view.findViewById(R.h.bPY);
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.h.cOi);
                if (TextUtils.isEmpty(op.kPP)) {
                    linearLayout.setVisibility(8);
                } else {
                    linearLayout.setTag(op.kPP);
                    linearLayout.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            String str = (String) view.getTag();
                            if (!TextUtils.isEmpty(str)) {
                                String substring;
                                if (str.contains(";")) {
                                    substring = str.substring(0, str.indexOf(";"));
                                } else {
                                    substring = str;
                                }
                                h.a(m.this.mContext, true, substring, "", m.this.mContext.getString(R.l.dUZ), m.this.mContext.getString(R.l.dEy), new DialogInterface.OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        Intent intent = new Intent("android.intent.action.DIAL");
                                        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                        intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(substring).toString()));
                                        m.this.mContext.startActivity(intent);
                                    }
                                }, null);
                            }
                        }
                    });
                    ((ImageView) view.findViewById(R.h.bPX)).setBackgroundColor(l.xu(op.hdx));
                    linearLayout.setVisibility(0);
                }
                textView.setText(op.title);
                textView2.setText(op.kPB);
                break;
            default:
                a aVar;
                boolean z;
                if (view != null) {
                    aVar = (a) view.getTag();
                } else {
                    aVar = null;
                }
                if (view == null || r0 == null) {
                    view = View.inflate(this.mContext, R.i.dbP, null);
                    a aVar2 = new a();
                    aVar2.laB = (TextView) view.findViewById(R.h.bPW);
                    aVar2.lbE = (TextView) view.findViewById(R.h.bPV);
                    aVar2.lbF = (TextView) view.findViewById(R.h.bPS);
                    aVar2.lbG = (ImageView) view.findViewById(R.h.bPU);
                    aVar2.kvL = view.findViewById(R.h.bPR);
                    aVar2.lbH = (CheckBox) view.findViewById(R.h.bPT);
                    view.setTag(aVar2);
                    aVar = aVar2;
                }
                aVar.laB.setText(op.title);
                if (op.kPN) {
                    aVar.lbH.setVisibility(0);
                    aVar.lbH.setChecked(op.kPO);
                    aVar.lbH.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            if (((CheckBox) view).isChecked()) {
                                op.kPO = true;
                            } else {
                                op.kPO = false;
                            }
                        }
                    });
                } else {
                    aVar.lbH.setVisibility(8);
                }
                if (TextUtils.isEmpty(op.kPB)) {
                    aVar.lbE.setVisibility(4);
                } else {
                    aVar.lbE.setVisibility(0);
                    aVar.lbE.setText(op.kPB);
                }
                if ((op.vZQ & 1) > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    aVar.laB.setGravity(17);
                    aVar.laB.setTextColor(this.mContext.getResources().getColor(R.e.btd));
                    aVar.lbE.setVisibility(8);
                } else {
                    aVar.laB.setGravity(3);
                    aVar.laB.setTextColor(this.mContext.getResources().getColor(R.e.bsU));
                }
                if (op.kPM) {
                    aVar.lbF.setVisibility(0);
                } else {
                    aVar.lbF.setVisibility(8);
                }
                aVar.lbE.setTextColor(this.mContext.getResources().getColor(R.e.bsT));
                if (bi.oN(op.pfi)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    aVar.lbG.setVisibility(0);
                    com.tencent.mm.plugin.card.b.m.a(aVar.lbG, op.pfi, com.tencent.mm.bu.a.fromDPToPix(this.mContext, 20), R.g.bDU, false);
                } else {
                    aVar.lbG.setVisibility(8);
                }
                if (i + 1 >= getCount()) {
                    if (i + 1 == getCount()) {
                        if (!this.lbz) {
                            h(aVar.kvL, false);
                            break;
                        }
                        h(aVar.kvL, true);
                        break;
                    }
                }
                a(aVar.kvL, op(i));
                a(aVar.kvL, op(i + 1));
                break;
                break;
        }
        return view;
    }

    private static void a(View view, b bVar) {
        if (bVar != null) {
            h(view, bVar.kPM);
        }
    }

    private static void h(View view, boolean z) {
        Rect rect = new Rect();
        rect.left = view.getPaddingLeft();
        rect.right = view.getPaddingRight();
        rect.top = view.getPaddingTop();
        rect.bottom = view.getPaddingBottom();
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (z) {
            view.setBackgroundResource(R.g.bDK);
        } else {
            view.setBackgroundResource(R.g.bDq);
        }
        view.setLayoutParams(layoutParams);
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
    }
}
