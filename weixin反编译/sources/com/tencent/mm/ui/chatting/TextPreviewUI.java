package com.tencent.mm.ui.chatting;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bw.g;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.base.z;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.i;

@a(3)
public class TextPreviewUI extends MMActivity {
    private TextView kO = null;
    private CharSequence text = null;
    private TextView yCo = null;
    private final int yGA = 2;
    private z yGu;
    private i yGv;
    private CharSequence yGw;
    private View yGx;
    private final int yGy = 0;
    private final int yGz = 1;

    static /* synthetic */ void b(Context context, CharSequence charSequence) {
        Intent intent = new Intent(context, MsgRetransmitUI.class);
        intent.putExtra("Retr_Msg_content", charSequence);
        intent.putExtra("Retr_Msg_Type", 4);
        context.startActivity(intent);
    }

    protected final int getLayoutId() {
        return R.i.ddK;
    }

    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        if (d.fN(19)) {
            getWindow().setFlags(201327616, 201327616);
        } else {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        this.yGx = findViewById(R.h.cQJ);
        this.text = getIntent().getCharSequenceExtra("key_chat_text");
        this.kO = (TextView) findViewById(R.h.ckq);
        this.yCo = (TextView) findViewById(R.h.ckr);
        CharSequence charSequence = this.text;
        TextView textView = this.yCo;
        if (charSequence instanceof SpannableString) {
            textView.setText(((SpannableString) charSequence).toString());
            com.tencent.mm.pluginsdk.ui.d.i.f(textView, 1);
            charSequence = textView.getText();
        }
        this.text = charSequence;
        this.kO.setText(g.chT().a(this.mController.xRr, this.text, this.kO.getTextSize()));
        this.yGv = new i(this.mController.xRr, this.kO);
        this.yGv.zDs = true;
        this.yGv.zDq = new OnCreateContextMenuListener() {
            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                contextMenu.clear();
                contextMenu.add(0, 0, 0, TextPreviewUI.this.getResources().getString(R.l.dED));
                contextMenu.add(1, 1, 0, TextPreviewUI.this.getResources().getString(R.l.evl));
                contextMenu.add(1, 2, 0, TextPreviewUI.this.getResources().getString(R.l.evk));
            }
        };
        this.yGv.rQG = new p.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 0:
                        ((ClipboardManager) TextPreviewUI.this.mController.xRr.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(TextPreviewUI.this.yGw, TextPreviewUI.this.yGw));
                        if (TextPreviewUI.this.yGu != null) {
                            TextPreviewUI.this.yGu.cqR();
                            TextPreviewUI.this.yGu.cqQ();
                        }
                        Toast.makeText(TextPreviewUI.this.mController.xRr, TextPreviewUI.this.mController.xRr.getString(R.l.dEE), 0).show();
                        return;
                    case 1:
                        if (TextPreviewUI.this.yGu != null) {
                            TextPreviewUI.this.yGu.cqQ();
                            z b = TextPreviewUI.this.yGu;
                            b.fKg = true;
                            if (b.ypr != null) {
                                b.ypr.ypL.dismiss();
                            }
                            if (b.yps != null) {
                                b.yps.ypL.dismiss();
                            }
                            TextPreviewUI.this.yGu.eX(0, TextPreviewUI.this.kO.getText().length());
                            TextPreviewUI.this.yGu.fKg = false;
                            b = TextPreviewUI.this.yGu;
                            b.a(b.ypr);
                            b.a(b.yps);
                        }
                        ah.h(new Runnable() {
                            public final void run() {
                                if (TextPreviewUI.this.yGu != null) {
                                    TextPreviewUI.this.yGu.cqS();
                                }
                            }
                        }, 100);
                        return;
                    case 2:
                        TextPreviewUI.b(TextPreviewUI.this.mController.xRr, TextPreviewUI.this.yGw);
                        return;
                    default:
                        return;
                }
            }
        };
        if (this.yGu == null) {
            z.a aVar = new z.a(this.kO, this.yGv);
            aVar.ypz = R.e.btI;
            aVar.ypK = 18.0f;
            aVar.ypA = R.e.brU;
            this.yGu = new z(aVar);
        }
        this.yGu.ypu = new w() {
            public final void S(CharSequence charSequence) {
                TextPreviewUI.this.yGw = charSequence;
            }
        };
        this.yGx.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (TextPreviewUI.this.yGu == null) {
                    return;
                }
                if (TextPreviewUI.this.yGu.fKg) {
                    TextPreviewUI.this.finish();
                    return;
                }
                TextPreviewUI.this.yGu.cqR();
                TextPreviewUI.this.yGu.cqQ();
            }
        });
        this.kO.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (TextPreviewUI.this.yGu == null) {
                    return;
                }
                if (TextPreviewUI.this.yGu.fKg) {
                    TextPreviewUI.this.finish();
                    return;
                }
                TextPreviewUI.this.yGu.cqR();
                TextPreviewUI.this.yGu.cqQ();
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                TextPreviewUI.this.finish();
                return true;
            }
        });
    }

    protected void onResume() {
        super.onResume();
        if (this.yGu != null && !this.yGu.fKg) {
            this.yGu.cqS();
        }
    }

    public void onBackPressed() {
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
