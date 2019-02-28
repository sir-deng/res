package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.j.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask.a;
import com.tencent.mm.plugin.webview.stub.WebviewScanImageActivity;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.h;
import com.tencent.wcdb.database.SQLiteDatabase;

public class CommonActivityTask extends GameProcessActivityTask {
    public static final Creator<CommonActivityTask> CREATOR = new Creator<CommonActivityTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CommonActivityTask(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CommonActivityTask[i];
        }
    };
    public Bundle mym;
    public int type;

    /* synthetic */ CommonActivityTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public final void a(Context context, final a aVar) {
        String string;
        String string2;
        switch (this.type) {
            case 1:
                string = this.mym.getString("result");
                if (!bi.oN(string)) {
                    string2 = this.mym.getString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    int i = this.mym.getInt("codeType");
                    int i2 = this.mym.getInt("codeVersion");
                    Intent intent = new Intent();
                    intent.setClass(context, WebviewScanImageActivity.class);
                    intent.setFlags(603979776);
                    intent.putExtra("key_string_for_scan", string);
                    intent.putExtra("key_string_for_url", string2);
                    intent.putExtra("key_codetype_for_scan", i);
                    intent.putExtra("key_codeversion_for_scan", i2);
                    context.startActivity(intent);
                    aVar.afx();
                    return;
                }
                return;
            case 2:
                string2 = this.mym.getString("img_path");
                if (p.Vw(string2)) {
                    EmojiInfo yI = ((c) g.k(c.class)).getEmojiMgr().yI(com.tencent.mm.a.g.bV(string2));
                    EmojiInfo yI2 = (yI == null || !yI.clh()) ? ((c) g.k(c.class)).getEmojiMgr().yI(((c) g.k(c.class)).getEmojiMgr().yJ(string2)) : yI;
                    boolean bN = yI2 == null ? false : e.bN(yI2.clq());
                    string = yI2 == null ? string2 : yI2.clq();
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    boolean z = (d.decodeFile(string, options) != null && options.outHeight > b.zL()) || options.outWidth > b.zL();
                    if (bN > b.zM() || z) {
                        h.a(context, context.getString(R.l.dZW), "", context.getString(R.l.epx), null);
                        h.a(context, context.getString(R.l.dZW), "", context.getString(R.l.epx), "", false, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                aVar.afx();
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                aVar.afx();
                            }
                        });
                        return;
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra("Retr_File_Name", yI2 != null ? yI2.Nx() : "");
                    intent2.putExtra("Retr_Msg_Type", 5);
                    intent2.putExtra("Retr_MsgImgScene", 1);
                    com.tencent.mm.plugin.webview.a.a.ihN.l(intent2, context);
                    aVar.afx();
                    return;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("Retr_File_Name", string2);
                intent3.putExtra("Retr_Compress_Type", 0);
                intent3.putExtra("Retr_Msg_Type", 0);
                intent3.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                com.tencent.mm.plugin.webview.a.a.ihN.l(intent3, context);
                aVar.afx();
                return;
            default:
                return;
        }
    }

    public final void YB() {
    }

    public final void f(Parcel parcel) {
        this.type = parcel.readInt();
        this.mym = parcel.readBundle(getClass().getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeBundle(this.mym);
    }

    public CommonActivityTask(Context context) {
        super(context);
        this.mym = new Bundle();
    }

    private CommonActivityTask(Parcel parcel) {
        this.mym = new Bundle();
        f(parcel);
    }
}
