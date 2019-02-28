package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ba.c;
import com.tencent.mm.ba.c.a;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;

public class ContactRemarkInfoViewUI extends MMActivity {
    private String bgp;
    private String fXt;
    private String hMh;
    private x jQP;
    private int pnn;
    private String username;
    private TextView zaB;
    private TextView zaC;
    private ImageView zaF;
    private boolean zaL = false;
    private View zbd;
    private View zbe;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pnn = getIntent().getIntExtra("Contact_Scene", 9);
        this.username = getIntent().getStringExtra("Contact_User");
        if (t.oN(this.username)) {
            finish();
            return;
        }
        Xc();
        initView();
    }

    public void onResume() {
        super.onResume();
        Xc();
        this.zaB.setText(i.b(this, t.oM(this.bgp), this.zaB.getTextSize()));
        if (t.oN(this.fXt)) {
            this.zbd.setVisibility(8);
        } else {
            this.zbd.setVisibility(0);
            this.zaC.setText(t.oM(this.fXt));
        }
        if (t.oN(this.hMh)) {
            this.zbe.setVisibility(8);
            return;
        }
        this.zbe.setVisibility(0);
        c.QS();
        if (c.lS(this.username)) {
            cwE();
        } else {
            c.QS().a(this.username, this.hMh, new a() {
                public final void bS(final boolean z) {
                    ContactRemarkInfoViewUI.this.zaF.post(new Runnable() {
                        public final void run() {
                            if (z) {
                                ContactRemarkInfoViewUI.this.cwE();
                            } else {
                                h.bu(ContactRemarkInfoViewUI.this, ContactRemarkInfoViewUI.this.getString(R.l.dFa));
                            }
                        }
                    });
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dfd;
    }

    private void Xc() {
        as.Hm();
        this.jQP = com.tencent.mm.y.c.Ff().Xv(this.username);
        this.bgp = this.jQP.AX();
        this.fXt = this.jQP.fXt;
        this.hMh = this.jQP.fXu;
    }

    protected final void initView() {
        this.zaB = (TextView) findViewById(R.h.bXR);
        this.zaC = (TextView) findViewById(R.h.bXP);
        this.zaF = (ImageView) findViewById(R.h.cHI);
        this.zbd = findViewById(R.h.bYq);
        this.zbe = findViewById(R.h.bYr);
        setMMTitle(R.l.dVR);
        this.zaF.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (ContactRemarkInfoViewUI.this.zaL) {
                    Intent intent = new Intent(ContactRemarkInfoViewUI.this, ContactRemarkImagePreviewUI.class);
                    intent.putExtra("Contact_User", ContactRemarkInfoViewUI.this.username);
                    c.QS();
                    intent.putExtra("remark_image_path", c.lR(ContactRemarkInfoViewUI.this.username));
                    intent.putExtra("view_only", true);
                    ContactRemarkInfoViewUI.this.startActivity(intent);
                }
            }
        });
        addTextOptionMenu(0, getString(R.l.dEQ), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.setClass(ContactRemarkInfoViewUI.this.mController.xRr, ContactRemarkInfoModUI.class);
                intent.putExtra("Contact_Scene", ContactRemarkInfoViewUI.this.pnn);
                intent.putExtra("Contact_User", ContactRemarkInfoViewUI.this.jQP.field_username);
                ContactRemarkInfoViewUI.this.startActivity(intent);
                return false;
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ContactRemarkInfoViewUI.this.finish();
                return true;
            }
        });
    }

    private void cwE() {
        Bitmap lU = c.QS().lU(this.username);
        if (lU != null) {
            this.zaF.setImageBitmap(lU);
            this.zaL = true;
        }
    }
}
