package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.d.a;
import com.tencent.mm.ac.e;
import com.tencent.mm.ac.n;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import junit.framework.Assert;

public class FriendPreference extends Preference implements a {
    private int fDx;
    private MMActivity fnF;
    private TextView ikn;
    private x jQP;
    private boolean lXm;
    private long ppA;
    private long ppB;
    private String ppC;
    private TextView ppv;
    private ImageView ppw;
    private ImageView ppx;
    private b ppy;
    private String ppz;

    public final /* synthetic */ CharSequence getSummary() {
        return this.ppv.getText().toString();
    }

    static /* synthetic */ void a(FriendPreference friendPreference, String str) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
        friendPreference.fnF.startActivity(intent);
    }

    static /* synthetic */ void a(FriendPreference friendPreference, final String str, final String str2) {
        if (bi.oN(str) || bi.oN(str2)) {
            Toast.makeText(friendPreference.mContext, friendPreference.mContext.getString(R.l.dWw), 0).show();
            return;
        }
        n.JF();
        Bitmap jh = d.jh(str);
        if (jh == null) {
            Toast.makeText(friendPreference.mContext, friendPreference.mContext.getString(R.l.dWx), 0).show();
            final e eVar = new e();
            eVar.a(str, new e.b() {
                public final int ba(int i, int i2) {
                    eVar.JJ();
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.FriendPreference", "onSceneEnd: errType=%d, errCode=%d", Integer.valueOf(i), Integer.valueOf(i2));
                    if (i == 0 && i2 == 0) {
                        n.JF();
                        if (FriendPreference.this.q(str2, d.jh(str))) {
                            Toast.makeText(FriendPreference.this.mContext, FriendPreference.this.mContext.getString(R.l.dWy), 0).show();
                            return 0;
                        }
                    }
                    Toast.makeText(FriendPreference.this.mContext, FriendPreference.this.mContext.getString(R.l.dWw), 0).show();
                    return 0;
                }
            });
        } else if (friendPreference.q(str2, jh)) {
            Toast.makeText(friendPreference.mContext, friendPreference.mContext.getString(R.l.dWy), 0).show();
        } else {
            Toast.makeText(friendPreference.mContext, friendPreference.mContext.getString(R.l.dWw), 0).show();
        }
    }

    public FriendPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fnF = (MMActivity) context;
        init();
    }

    public FriendPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.dnz);
        setWidgetLayoutResource(R.i.doj);
        init();
    }

    private void init() {
        this.lXm = false;
        this.jQP = null;
        this.ppy = null;
        this.ppz = "";
        this.ppA = 0;
        this.ppB = 0;
        this.fDx = 0;
        this.ppC = "";
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.dnF, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        this.ikn = (TextView) view.findViewById(R.h.title);
        this.ppv = (TextView) view.findViewById(R.h.summary);
        this.ppw = (ImageView) view.findViewById(R.h.cpm);
        this.ppx = (ImageView) view.findViewById(R.h.cwR);
        this.lXm = true;
        initView();
        super.onBindView(view);
    }

    private void initView() {
        Bitmap aP;
        InputStream inputStream;
        Bitmap decodeStream;
        Bitmap createScaledBitmap;
        if (this.jQP == null || !this.lXm) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.FriendPreference", "initView : contact = " + this.jQP + " bindView = " + this.lXm);
        } else if (this.ppA != -1 && new o(this.ppA).longValue() > 0) {
            setWidgetLayoutResource(R.i.dok);
            if (this.jQP == null || !this.lXm) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.FriendPreference", "initView : contact = " + this.jQP + " bindView = " + this.lXm);
                return;
            }
            this.fDx = 2;
            this.ikn.setText(this.mContext.getString(R.l.dVt));
            this.ppv.setText(bi.oM(this.ppz) + " " + new o(this.ppA).longValue());
            aP = com.tencent.mm.ac.b.aP(this.ppA);
            if (aP == null) {
                inputStream = null;
                try {
                    inputStream = this.mContext.getResources().openRawResource(R.k.dyz);
                    decodeStream = com.tencent.mm.compatible.g.a.decodeStream(inputStream);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e) {
                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.FriendPreference", e, "", new Object[0]);
                        }
                    }
                } catch (Throwable e2) {
                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.FriendPreference", e2, "", new Object[0]);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            decodeStream = aP;
                        } catch (Throwable e22) {
                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.FriendPreference", e22, "", new Object[0]);
                            decodeStream = aP;
                        }
                    }
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e3) {
                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.FriendPreference", e3, "", new Object[0]);
                        }
                    }
                }
                if (decodeStream != null) {
                    createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, 48, 48, false);
                    if (createScaledBitmap != decodeStream) {
                        decodeStream.recycle();
                    }
                    this.ppw.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(createScaledBitmap, true, 0.0f));
                }
                as.Hm();
                if (!c.isSDCardAvailable()) {
                    this.ppw.setBackgroundDrawable(com.tencent.mm.bu.a.b(this.fnF, R.k.bBC));
                }
            }
            decodeStream = aP;
            if (decodeStream != null) {
                createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, 48, 48, false);
                if (createScaledBitmap != decodeStream) {
                    decodeStream.recycle();
                }
                this.ppw.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(createScaledBitmap, true, 0.0f));
            }
            as.Hm();
            if (!c.isSDCardAvailable()) {
                this.ppw.setBackgroundDrawable(com.tencent.mm.bu.a.b(this.fnF, R.k.bBC));
            }
        } else if (this.ppy != null) {
            setWidgetLayoutResource(R.i.dod);
            if (this.jQP == null || !this.lXm) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.FriendPreference", "initView : contact = " + this.jQP + " bindView = " + this.lXm);
            } else if (this.ppy != null) {
                this.fDx = 1;
                this.ikn.setText(this.mContext.getString(R.l.dVs));
                final Object obj = bi.oM(this.ppy.Nz()) + " " + bi.oM(this.ppy.NF()).replace(" ", "");
                this.ppv.setText(obj);
                createScaledBitmap = m.a(this.ppy.Ny(), this.mContext);
                if (createScaledBitmap == null) {
                    this.ppw.setImageDrawable(com.tencent.mm.bu.a.b(this.fnF, R.k.dyy));
                } else {
                    this.ppw.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(Bitmap.createScaledBitmap(createScaledBitmap, 48, 48, false), true, 0.0f));
                }
                as.Hm();
                if (c.Ff().Xr(this.ppy.getUsername())) {
                    this.ppx.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            String[] stringArray;
                            if (FriendPreference.this.ppy == null || bi.oN(FriendPreference.this.ppy.hnc)) {
                                stringArray = FriendPreference.this.fnF.getResources().getStringArray(R.c.bqY);
                            } else {
                                stringArray = FriendPreference.this.fnF.getResources().getStringArray(R.c.bqX);
                            }
                            if (com.tencent.mm.plugin.profile.a.ihO.us()) {
                                List F = bi.F(stringArray);
                                F.add(FriendPreference.this.fnF.getResources().getString(R.l.dSE));
                                stringArray = (String[]) F.toArray(new String[F.size()]);
                                g.pWK.h(11621, Integer.valueOf(2), Integer.valueOf(3));
                            }
                            h.a(FriendPreference.this.fnF, null, stringArray, null, new h.c() {
                                public final void jo(int i) {
                                    switch (i) {
                                        case 0:
                                            if (obj != null && obj.length() != 0) {
                                                int lastIndexOf = obj.lastIndexOf(32) + 1;
                                                if (lastIndexOf > 0) {
                                                    FriendPreference.a(FriendPreference.this, obj.substring(lastIndexOf));
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        case 1:
                                            if (obj != null && obj.length() != 0) {
                                                String substring = obj.substring(0, obj.lastIndexOf(32));
                                                if (substring != null && substring.length() != 0) {
                                                    s.b(FriendPreference.this.jQP, substring.trim());
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        case 2:
                                            if (stringArray != null && stringArray.length > 2 && FriendPreference.this.ppy != null && FriendPreference.this.jQP != null) {
                                                if (!(FriendPreference.this.ppy == null || bi.oN(FriendPreference.this.ppy.hnc))) {
                                                    FriendPreference.a(FriendPreference.this, FriendPreference.this.jQP.field_username, FriendPreference.this.ppy.hnc);
                                                    return;
                                                }
                                            }
                                            return;
                                            break;
                                        case 3:
                                            break;
                                        default:
                                            return;
                                    }
                                    Intent intent = new Intent();
                                    Bundle bundle = new Bundle();
                                    bundle.putInt("fromScene", 2);
                                    intent.putExtra("reportArgs", bundle);
                                    com.tencent.mm.plugin.profile.a.ihN.k(intent, FriendPreference.this.fnF);
                                }
                            });
                        }
                    });
                } else {
                    this.ppx.setVisibility(4);
                }
            }
        } else if (this.ppB > 0) {
            if (this.jQP == null || !this.lXm) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.FriendPreference", "initView : contact = " + this.jQP + " bindView = " + this.lXm);
                return;
            }
            this.fDx = 3;
            this.ikn.setText(this.mContext.getString(R.l.eoh));
            this.ppv.setText(bi.oM(this.jQP.fXb));
            aP = com.tencent.mm.ac.b.iU(this.ppB);
            if (aP == null) {
                inputStream = null;
                try {
                    inputStream = this.mContext.getResources().openRawResource(R.k.dyz);
                    decodeStream = com.tencent.mm.compatible.g.a.decodeStream(inputStream);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e32) {
                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.FriendPreference", e32, "", new Object[0]);
                        }
                    }
                } catch (Throwable e222) {
                    com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.FriendPreference", e222, "", new Object[0]);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                            decodeStream = aP;
                        } catch (Throwable e2222) {
                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.FriendPreference", e2222, "", new Object[0]);
                            decodeStream = aP;
                        }
                    }
                } catch (Throwable th2) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e322) {
                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.FriendPreference", e322, "", new Object[0]);
                        }
                    }
                }
                if (decodeStream != null) {
                    createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, 48, 48, false);
                    if (createScaledBitmap != decodeStream) {
                        decodeStream.recycle();
                    }
                    this.ppw.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(createScaledBitmap, true, 0.0f));
                }
                as.Hm();
                if (!c.isSDCardAvailable()) {
                    this.ppw.setBackgroundDrawable(com.tencent.mm.bu.a.b(this.fnF, R.k.bBC));
                }
            }
            decodeStream = aP;
            if (decodeStream != null) {
                createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, 48, 48, false);
                if (createScaledBitmap != decodeStream) {
                    decodeStream.recycle();
                }
                this.ppw.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(createScaledBitmap, true, 0.0f));
            }
            as.Hm();
            if (!c.isSDCardAvailable()) {
                this.ppw.setBackgroundDrawable(com.tencent.mm.bu.a.b(this.fnF, R.k.bBC));
            }
        } else if (TextUtils.isEmpty(this.ppC)) {
            Assert.assertTrue(false);
        } else if (this.jQP == null || !this.lXm) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.FriendPreference", "initView : contact = " + this.jQP + " bindView = " + this.lXm);
        } else {
            this.fDx = 3;
            this.ikn.setText(this.mContext.getString(R.l.eDl));
            this.ppv.setText(bi.oM(this.ppC));
            this.ppw.setVisibility(8);
        }
    }

    private boolean q(String str, Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return m.a(str, this.mContext, byteArrayOutputStream.toByteArray());
    }

    public final boolean asz() {
        n.JF().e(this);
        return true;
    }

    public final void jk(String str) {
        long iW = com.tencent.mm.ac.b.iW(str);
        if (iW > 0 && this.ppA == iW && com.tencent.mm.ac.b.a(str, false, -1) != null) {
            initView();
        }
        if (com.tencent.mm.ac.b.iV(str) == this.ppB && com.tencent.mm.ac.b.a(str, false, -1) != null) {
            initView();
        }
    }
}
