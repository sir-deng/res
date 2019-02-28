package com.tencent.mm.ui.friend;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.ac.d.a;
import com.tencent.mm.ac.n;
import com.tencent.mm.ad.e;
import com.tencent.mm.f.a.mb;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.tools.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class InviteFriendUI extends MMActivity implements a {
    private ImageView hxJ;
    private String zlJ;
    private int zlK;
    private String zlL;
    private String zlM;
    private String zlN;
    private Button zlO;
    private int zlP;
    private int zlQ;
    private String zlR = null;
    private String zlS = null;

    static /* synthetic */ void c(InviteFriendUI inviteFriendUI) {
        if (inviteFriendUI.zlP > 0 && inviteFriendUI.zlQ > 0) {
            g.pWK.h(10991, Integer.valueOf(inviteFriendUI.zlP), Integer.valueOf(7), Integer.valueOf(inviteFriendUI.zlQ));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.epU);
        Intent intent = getIntent();
        this.zlK = intent.getIntExtra("friend_type", -1);
        this.zlL = intent.getStringExtra("friend_nick");
        this.zlJ = intent.getStringExtra("friend_num");
        this.zlM = intent.getStringExtra("friend_googleID");
        this.zlN = intent.getStringExtra("friend_googleItemID");
        this.zlJ = bi.oM(this.zlJ);
        this.zlR = intent.getStringExtra("friend_linkedInID");
        this.zlS = intent.getStringExtra("friend_linkedInPicUrl");
        initView();
        this.zlP = intent.getIntExtra("search_kvstat_scene", 0);
        this.zlQ = intent.getIntExtra("search_kvstat_position", 0);
    }

    protected void onPause() {
        super.onPause();
        n.JF().e(this);
    }

    protected void onResume() {
        super.onResume();
        n.JF().d(this);
    }

    protected final int getLayoutId() {
        return R.i.dlQ;
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final void initView() {
        Bitmap bitmap = null;
        this.hxJ = (ImageView) findViewById(R.h.cqa);
        TextView textView = (TextView) findViewById(R.h.cqe);
        TextView textView2 = (TextView) findViewById(R.h.cqg);
        TextView textView3 = (TextView) findViewById(R.h.cqf);
        this.zlO = (Button) findViewById(R.h.cqd);
        Button button = (Button) findViewById(R.h.cqh);
        textView.setText(this.zlL);
        textView3.setText(getString(R.l.cqf, new Object[]{this.zlL}));
        if (this.zlK == 1) {
            Bitmap a;
            this.hxJ.setBackgroundDrawable(com.tencent.mm.bu.a.b(this, R.k.dyy));
            textView2.setText(getString(R.l.dFi) + this.zlJ);
            String s = com.tencent.mm.a.g.s(this.zlJ.getBytes());
            as.Hm();
            if (c.isSDCardAvailable()) {
                b kV = af.OJ().kV(s);
                a = kV != null ? m.a(kV.Ny(), this) : null;
            } else {
                a = n.JF().bg(ad.getContext());
            }
            if (a != null) {
                this.hxJ.setImageBitmap(a);
            } else {
                this.hxJ.setImageDrawable(com.tencent.mm.bu.a.b(this, R.k.dyy));
            }
        }
        if (this.zlK == 0) {
            this.hxJ.setBackgroundDrawable(com.tencent.mm.bu.a.b(this, R.k.dyz));
            textView2.setText(getString(R.l.dFk) + this.zlJ);
            long bY = (long) o.bY(this.zlJ);
            if (bY != 0) {
                bitmap = com.tencent.mm.ac.b.aP(bY);
            }
            if (bitmap == null) {
                this.hxJ.setImageDrawable(com.tencent.mm.bu.a.b(this, R.k.dyz));
            } else {
                this.hxJ.setImageBitmap(bitmap);
            }
            button.setVisibility(0);
        }
        if (this.zlK == 2) {
            Bitmap iR;
            this.zlO.setText(R.l.enJ);
            this.hxJ.setBackgroundDrawable(com.tencent.mm.bu.a.b(this, R.g.bBD));
            textView2.setText(getString(R.l.dFc) + this.zlJ);
            as.Hm();
            if (c.isSDCardAvailable()) {
                iR = com.tencent.mm.ac.b.iR(this.zlM);
            } else {
                iR = n.JF().bg(ad.getContext());
            }
            if (iR != null) {
                this.hxJ.setImageBitmap(iR);
            } else {
                this.hxJ.setImageDrawable(com.tencent.mm.bu.a.b(this, R.g.bBD));
            }
            if (TextUtils.isEmpty(this.zlL)) {
                textView.setText(bi.Wy(this.zlJ));
                textView3.setText(getString(R.l.cqf, new Object[]{bi.Wy(this.zlJ)}));
            }
        }
        if (this.zlK == 3) {
            this.zlO.setText(R.l.epT);
            Bitmap a2 = j.a(new d(this.zlS, this.zlS));
            if (a2 != null) {
                this.hxJ.setImageBitmap(a2);
            } else {
                this.hxJ.setImageResource(R.k.bBC);
            }
            button.setVisibility(8);
        }
        this.zlO.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                final String string;
                switch (InviteFriendUI.this.zlK) {
                    case 0:
                        new g(InviteFriendUI.this, new g.a() {
                            public final void o(boolean z, String str) {
                                if (z) {
                                    InviteFriendUI.this.finish();
                                }
                            }
                        }).q(new int[]{o.bY(InviteFriendUI.this.zlJ)});
                        return;
                    case 1:
                        as.Hm();
                        String str = (String) c.Db().get(42, (Object) "");
                        if (str == null || str.length() == 0) {
                            as.Hm();
                            str = (String) c.Db().get(2, (Object) "");
                        }
                        string = InviteFriendUI.this.getString(R.l.eqg, new Object[]{str});
                        final Uri parse = Uri.parse("smsto:" + InviteFriendUI.this.zlJ);
                        Intent intent = new Intent("android.intent.action.SENDTO", parse);
                        intent.putExtra("sms_body", string);
                        final PackageManager packageManager = InviteFriendUI.this.getPackageManager();
                        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
                        final HashMap hashMap = new HashMap();
                        for (ResolveInfo resolveInfo : queryIntentActivities) {
                            if (!resolveInfo.activityInfo.packageName.equals("com.whatsapp")) {
                                hashMap.put(resolveInfo.activityInfo.name, resolveInfo);
                            }
                        }
                        if (hashMap.size() == 1) {
                            Iterator it = hashMap.keySet().iterator();
                            if (it.hasNext()) {
                                str = (String) it.next();
                                Intent intent2 = new Intent();
                                intent2.setComponent(new ComponentName(((ResolveInfo) hashMap.get(str)).activityInfo.packageName, ((ResolveInfo) hashMap.get(str)).activityInfo.name));
                                intent2.setAction("android.intent.action.SENDTO");
                                intent2.setData(parse);
                                intent2.putExtra("sms_body", string);
                                InviteFriendUI.this.startActivity(intent2);
                                InviteFriendUI.c(InviteFriendUI.this);
                                return;
                            }
                            return;
                        } else if (hashMap.size() > 1) {
                            l lVar = new l(InviteFriendUI.this);
                            lVar.zux = new p.a() {
                                public final void a(ImageView imageView, MenuItem menuItem) {
                                    imageView.setImageDrawable(((ResolveInfo) hashMap.get(menuItem.getTitle())).loadIcon(packageManager));
                                }
                            };
                            lVar.zuy = new p.b() {
                                public final void a(TextView textView, MenuItem menuItem) {
                                    textView.setText(((ResolveInfo) hashMap.get(menuItem.getTitle())).loadLabel(packageManager).toString());
                                }
                            };
                            lVar.rQF = new p.c() {
                                public final void a(com.tencent.mm.ui.base.n nVar) {
                                    for (CharSequence add : hashMap.keySet()) {
                                        nVar.add(add);
                                    }
                                }
                            };
                            lVar.rQG = new p.d() {
                                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                                    String str = menuItem.getTitle();
                                    Intent intent = new Intent();
                                    intent.setComponent(new ComponentName(((ResolveInfo) hashMap.get(str)).activityInfo.packageName, ((ResolveInfo) hashMap.get(str)).activityInfo.name));
                                    intent.setAction("android.intent.action.SENDTO");
                                    intent.setData(parse);
                                    intent.putExtra("sms_body", string);
                                    InviteFriendUI.this.startActivity(intent);
                                }
                            };
                            lVar.bCH();
                            InviteFriendUI.c(InviteFriendUI.this);
                            return;
                        } else {
                            Toast.makeText(InviteFriendUI.this, R.l.eJJ, 1).show();
                            return;
                        }
                    case 2:
                        e hVar = new h(InviteFriendUI.this, new h.a() {
                            public final void nt(boolean z) {
                                if (z) {
                                    af.OR().M(InviteFriendUI.this.zlN, 1);
                                }
                            }
                        });
                        String e = InviteFriendUI.this.zlM;
                        string = InviteFriendUI.this.zlJ;
                        as.CN().a(489, hVar);
                        Cursor lc = af.OR().lc(e);
                        if (lc == null || lc.getCount() <= 1) {
                            hVar.aaw(string);
                        } else {
                            hVar.n(lc);
                        }
                        if (lc != null) {
                            lc.close();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        });
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.sdk.b.b mbVar = new mb();
                mbVar.fEt.opType = 0;
                mbVar.fEt.fEv = InviteFriendUI.this.zlJ + "@qqim";
                mbVar.fEt.fEw = InviteFriendUI.this.zlL;
                com.tencent.mm.sdk.b.a.xmy.m(mbVar);
                if (mbVar.fEu.fqR) {
                    com.tencent.mm.plugin.c.a.ihN.e(new Intent().putExtra("Chat_User", InviteFriendUI.this.zlJ + "@qqim"), InviteFriendUI.this);
                }
                InviteFriendUI.this.finish();
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                InviteFriendUI.this.finish();
                return true;
            }
        });
    }

    public final void jk(String str) {
        if (this.zlJ != null && !this.zlJ.equals("")) {
            long iW = com.tencent.mm.ac.b.iW(str);
            if (iW > 0 && this.zlJ.equals(String.valueOf(iW)) && this.zlK == 0) {
                this.hxJ.setImageBitmap(com.tencent.mm.ac.b.a(str, false, -1));
            }
        }
    }
}
