package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.m;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.List;
import junit.framework.Assert;

public class ProfileMobilePhoneView extends ProfileItemView {
    public TextView jOY;
    private Context mContext;
    public boolean vrA;
    public String vrq;
    public String vrr;
    public String[] vrs;
    public LinearLayout vrz;

    private static class a extends BaseAdapter {
        private Context mContext = null;
        private List<String> nua = null;

        private class a {
            TextView jtn;

            private a() {
            }

            /* synthetic */ a(a aVar, byte b) {
                this();
            }
        }

        public a(Context context, List<String> list) {
            Assert.assertTrue(context != null);
            this.mContext = context;
            this.nua = list;
        }

        public final int getCount() {
            return this.nua == null ? 0 : this.nua.size();
        }

        public final Object getItem(int i) {
            return this.nua.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            Object obj;
            String str = (String) getItem(i);
            if (view == null) {
                view = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.i.ddQ, viewGroup, false);
                a aVar = new a();
                aVar.jtn = (TextView) view.findViewById(R.h.title);
                view.setTag(aVar);
                obj = aVar;
            } else {
                obj = view.getTag();
            }
            ((a) obj).jtn.setText(str);
            return view;
        }
    }

    static /* synthetic */ void a(ProfileMobilePhoneView profileMobilePhoneView, final String str) {
        final m mVar = new m(profileMobilePhoneView.mContext);
        mVar.kUZ = new a(profileMobilePhoneView.mContext, bi.F(!profileMobilePhoneView.vrA ? new String[]{profileMobilePhoneView.mContext.getResources().getString(R.l.dSI)} : new String[]{profileMobilePhoneView.mContext.getResources().getString(R.l.dSI), profileMobilePhoneView.mContext.getResources().getString(R.l.dSJ)}));
        mVar.vDf = new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (mVar != null) {
                    mVar.dismiss();
                }
                Intent intent;
                if (i == 0) {
                    Integer[] numArr;
                    g gVar;
                    Object[] objArr;
                    g gVar2;
                    Integer[] numArr2;
                    int i2;
                    if (bi.oN(ProfileMobilePhoneView.this.vrq)) {
                        numArr = new Object[1];
                        gVar = g.pWK;
                        objArr = numArr;
                    } else {
                        g gVar3 = g.pWK;
                        numArr = new Object[1];
                        if (ProfileMobilePhoneView.this.vrq.equals(str.trim())) {
                            gVar2 = gVar3;
                            numArr2 = numArr;
                            Integer[] numArr3 = numArr;
                            i2 = 1;
                            Integer[] numArr4 = numArr3;
                            numArr2[0] = Integer.valueOf(i2);
                            gVar2.h(12043, numArr4);
                            intent = new Intent("android.intent.action.DIAL");
                            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
                            ProfileMobilePhoneView.this.getContext().startActivity(intent);
                        }
                        gVar = gVar3;
                        numArr2 = numArr;
                    }
                    gVar2 = gVar;
                    Object[] numArr42 = objArr;
                    numArr2 = numArr;
                    i2 = 0;
                    numArr2[0] = Integer.valueOf(i2);
                    gVar2.h(12043, numArr42);
                    intent = new Intent("android.intent.action.DIAL");
                    intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
                    try {
                        ProfileMobilePhoneView.this.getContext().startActivity(intent);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.ProfileMobilePhoneView", e, "Activity not found!", new Object[0]);
                    }
                } else if (1 == i) {
                    g.pWK.h(12059, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    intent = new Intent();
                    intent.putExtra("IPCallTalkUI_phoneNumber", str);
                    d.b(ProfileMobilePhoneView.this.mContext, "ipcall", ".ui.IPCallDialUI", intent);
                }
            }
        };
        mVar.setCancelable(true);
        mVar.show();
    }

    public ProfileMobilePhoneView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProfileMobilePhoneView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.vrA = false;
        this.mContext = context;
    }

    public final int bkr() {
        return R.i.dpR;
    }

    public final void init() {
        this.jOY = (TextView) findViewById(R.h.cCz);
        this.vrz = (LinearLayout) findViewById(R.h.cCy);
        for (int i = 0; i < 5; i++) {
            this.vrz.getChildAt(i).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    ProfileMobilePhoneView.a(ProfileMobilePhoneView.this, ((TextView) view).getText().toString());
                }
            });
        }
    }

    @Deprecated
    public final boolean M(com.tencent.mm.storage.x xVar) {
        return false;
    }

    public final boolean bks() {
        if (this.jOY != null) {
            LayoutParams layoutParams = this.jOY.getLayoutParams();
            layoutParams.width = com.tencent.mm.bu.a.aa(getContext(), R.f.bvc);
            this.jOY.setLayoutParams(layoutParams);
        }
        if (this.vrz != null) {
            int i;
            int i2;
            View childAt;
            int i3;
            if (bi.oN(this.vrq) || !bi.Wx(this.vrq).booleanValue()) {
                if (!(this.vrq == null || bi.Wx(this.vrq).booleanValue())) {
                    x.e("MicroMsg.ProfileMobilePhoneView", "mobile format is error----%s", this.vrq);
                }
                i = 0;
                i2 = 0;
            } else {
                childAt = this.vrz.getChildAt(0);
                if (childAt != null) {
                    childAt.setVisibility(0);
                    ((TextView) childAt).setText(this.vrq);
                }
                i = 1;
                i2 = 1;
            }
            if (!bi.oN(this.vrr)) {
                this.vrs = this.vrr.split(",");
                setVisibility(0);
                while (true) {
                    i3 = i2;
                    if (i3 >= this.vrs.length + i) {
                        break;
                    }
                    childAt = this.vrz.getChildAt(i3);
                    if (childAt != null) {
                        childAt.setVisibility(0);
                        ((TextView) childAt).setText(this.vrs[i3 - i]);
                    }
                    i2 = i3 + 1;
                }
            } else {
                i3 = i2;
            }
            while (i3 < 5) {
                this.vrz.getChildAt(i3).setVisibility(8);
                i3++;
            }
            if (i != 1 && bi.oN(this.vrr)) {
                setVisibility(8);
            }
        }
        return false;
    }
}
