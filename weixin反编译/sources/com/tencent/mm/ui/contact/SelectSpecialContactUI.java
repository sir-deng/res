package com.tencent.mm.ui.contact;

import android.content.Intent;
import com.tencent.mm.bl.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.a.a;

public class SelectSpecialContactUI extends MMBaseSelectContactUI {
    private int ljb;
    private String title;

    protected final void Xc() {
        super.Xc();
        this.title = getIntent().getStringExtra("titile");
        this.ljb = getIntent().getIntExtra("list_attr", 0);
    }

    public final void jd(int i) {
        a GF = cwP().GF(i);
        if (GF != null && GF.jQP != null) {
            String str = GF.jQP.field_username;
            x.i("MicroMsg.SelectSpecialContactUI", "ClickUser=%s", str);
            Intent intent = new Intent();
            if (s.fd(this.ljb, 16384)) {
                intent.putExtra("Select_Contact", str);
                setResult(-1, intent);
                finish();
            } else if (s.fd(this.ljb, WXMediaMessage.THUMB_LENGTH_LIMIT)) {
                intent.putExtra("Contact_User", str);
                d.b(this, "profile", ".ui.ContactInfoUI", intent);
                finish();
            } else {
                intent.setClass(this, ChattingUI.class);
                intent.putExtra("Chat_User", str);
                intent.putExtra("finish_direct", true);
                startActivity(intent);
                finish();
            }
        }
    }

    protected final boolean Xd() {
        return false;
    }

    protected final boolean Xe() {
        return false;
    }

    protected final String Xf() {
        return this.title;
    }

    protected final o Xg() {
        return new z(this, getIntent().getStringExtra("filter_type"));
    }

    protected final m Xh() {
        return null;
    }
}
