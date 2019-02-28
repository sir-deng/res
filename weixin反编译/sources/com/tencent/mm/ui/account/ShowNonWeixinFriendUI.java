package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ac.b;
import com.tencent.mm.ac.d.a;
import com.tencent.mm.ac.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.f.a.c;
import com.tencent.mm.ui.f.a.d;

public class ShowNonWeixinFriendUI extends MMActivity implements a {
    private long ybm = 0;
    private String ybn = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.epU);
        this.ybm = getIntent().getLongExtra("Contact_KFacebookId", 0);
        this.ybn = getIntent().getStringExtra("Contact_KFacebookName");
        initView();
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
        return R.i.dhu;
    }

    protected final void initView() {
        ImageView imageView = (ImageView) findViewById(R.h.cqa);
        TextView textView = (TextView) findViewById(R.h.cqe);
        TextView textView2 = (TextView) findViewById(R.h.cqf);
        imageView.setBackgroundDrawable(com.tencent.mm.bu.a.b(this, R.k.dyy));
        imageView.setImageBitmap(b.iU(this.ybm));
        textView.setText(this.ybn);
        textView2.setText(getString(R.l.cqf, new Object[]{this.ybn}));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ShowNonWeixinFriendUI.this.aWY();
                ShowNonWeixinFriendUI.this.finish();
                return true;
            }
        });
        ((Button) findViewById(R.h.cqd)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                c cVar = new c("290293790992170");
                Bundle bundle = new Bundle();
                bundle.putString("message", ShowNonWeixinFriendUI.this.getString(R.l.eeA));
                bundle.putString("to", Long.toString(ShowNonWeixinFriendUI.this.ybm));
                cVar.a(ShowNonWeixinFriendUI.this, "apprequests", bundle, new c.a() {
                    public final void a(d dVar) {
                        x.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite error");
                    }

                    public final void a(com.tencent.mm.ui.f.a.b bVar) {
                        x.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite error");
                    }

                    public final void k(Bundle bundle) {
                        x.i("MicroMsg.ShowNonWeixinFriendUI", "fbinvite oncomplete");
                        h.a(ShowNonWeixinFriendUI.this.mController.xRr, R.l.eeF, R.l.dGZ, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                ShowNonWeixinFriendUI.this.finish();
                            }
                        });
                    }

                    public final void onCancel() {
                        x.e("MicroMsg.ShowNonWeixinFriendUI", "fbinvite cancle");
                    }
                });
            }
        });
    }

    public final void jk(String str) {
        initView();
    }
}
