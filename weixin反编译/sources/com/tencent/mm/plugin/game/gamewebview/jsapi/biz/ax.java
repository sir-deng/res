package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Base64;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.u;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.io.File;
import org.json.JSONObject;

public final class ax extends a {
    public static final int CTRL_BYTE = 275;
    public static final int DO_IN_ENV = 2;
    public static final String NAME = "shareEmoticon";

    public final void a(final Context context, String str, final GameJsApiMMTask.a aVar) {
        x.i("MicroMsg.GameJsApiShareEmotion", "invoke");
        JSONObject sx = d.sx(str);
        if (sx == null) {
            x.e("MicroMsg.GameJsApiShareEmotion", "data is null");
            aVar.sE(a.e("shareEmoticon:fail_null_data", null));
            return;
        }
        String optString = sx.optString("base64DataString");
        final String optString2 = sx.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        String I;
        if (bi.oN(optString)) {
            x.i("MicroMsg.GameJsApiShareEmotion", "doShareEmoticon use url:%s", optString2);
            File file = new File(context.getCacheDir(), g.s(optString2.getBytes()));
            if (file.exists()) {
                optString2 = g.i(file);
                as.Hm();
                I = EmojiLogic.I(c.Fw(), "", optString2);
                if (!FileOp.bO(I)) {
                    FileOp.x(file.getAbsolutePath(), I);
                }
                b(context, optString2, aVar);
                return;
            }
            com.tencent.mm.ap.a.a.c.a aVar2 = new com.tencent.mm.ap.a.a.c.a();
            aVar2.hFl = true;
            aVar2.hFn = file.getAbsolutePath();
            aVar2.hFO = new Object[]{file.getAbsolutePath()};
            i.aBL().a(optString2, null, aVar2.PQ(), new com.tencent.mm.ap.a.c.i() {
                public final void a(String str, Bitmap bitmap, Object... objArr) {
                    x.i("MicroMsg.GameJsApiShareEmotion", "imageLoaderListener onImageLoadComplete %s", str);
                    GameJsApiMMTask.a aVar;
                    ax axVar;
                    if (bitmap == null || objArr == null || objArr.length <= 0) {
                        aVar = aVar;
                        axVar = ax.this;
                        aVar.sE(a.e("shareEmoticon:fail", null));
                    } else if (objArr[0] == null || !(objArr[0] instanceof String)) {
                        aVar = aVar;
                        axVar = ax.this;
                        aVar.sE(a.e("shareEmoticon:fail", null));
                    } else if (str.equals(optString2)) {
                        File file = new File(objArr[0].toString());
                        if (file.exists()) {
                            String i = g.i(file);
                            as.Hm();
                            FileOp.x(file.getAbsolutePath(), EmojiLogic.I(c.Fw(), "", i));
                            ax.this.b(context, i, aVar);
                            return;
                        }
                        aVar = aVar;
                        axVar = ax.this;
                        aVar.sE(a.e("shareEmoticon:fail", null));
                    } else {
                        aVar = aVar;
                        axVar = ax.this;
                        aVar.sE(a.e("shareEmoticon:fail", null));
                    }
                }
            });
            return;
        }
        x.i("MicroMsg.GameJsApiShareEmotion", "use base64DataString");
        int indexOf = optString.indexOf(";base64,");
        optString2 = "";
        if (indexOf != -1) {
            optString2 = optString.substring(indexOf + 8, optString.length());
        }
        try {
            byte[] decode = Base64.decode(optString2, 0);
            if (bi.by(decode)) {
                aVar.sE(a.e("shareEmoticon:fail", null));
                return;
            }
            optString = g.s(decode);
            as.Hm();
            I = EmojiLogic.I(c.Fw(), "", optString);
            if (!(e.bO(I) && g.bV(I).equalsIgnoreCase(optString))) {
                e.b(I, decode, decode.length);
            }
            b(context, optString, aVar);
        } catch (Exception e) {
            x.e("MicroMsg.GameJsApiShareEmotion", "doShareEmoticon error:" + e.getMessage());
            aVar.sE(a.e("shareEmoticon:fail_base64_decode_fail", null));
        }
    }

    final void b(Context context, String str, final GameJsApiMMTask.a aVar) {
        Intent intent = new Intent();
        intent.putExtra("scene_from", 4);
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 5);
        intent.putExtra("Retr_Msg_thumb_path", str);
        intent.putExtra(u.FLAG_OVERRIDE_ENTER_ANIMATION, R.a.bpZ);
        if (context instanceof MMActivity) {
            ((MMActivity) context).jCj = new MMActivity.a() {
                public final void b(int i, int i2, Intent intent) {
                    x.i("MicroMsg.GameJsApiShareEmotion", "mmOnActivityResult, %d", Integer.valueOf(i));
                    if (i == (ax.this.hashCode() & 65535)) {
                        x.i("MicroMsg.GameJsApiShareEmotion", "share emmotion resultCode: %d", Integer.valueOf(i2));
                        GameJsApiMMTask.a aVar;
                        ax axVar;
                        switch (i2) {
                            case -1:
                                EmojiInfo b;
                                String aD = bi.aD(intent.getStringExtra("Select_Conv_User"), "");
                                String aD2 = bi.aD(intent.getStringExtra("emoji_thumb_path"), "");
                                EmojiInfo YB = i.aCl().lCw.YB(aD2);
                                if (YB == null) {
                                    as.Hm();
                                    String I = EmojiLogic.I(c.Fw(), "", aD2);
                                    if (e.bO(I)) {
                                        b = i.aCl().lCw.b(aD2, "", EmojiInfo.xIH, p.Vw(I) ? EmojiInfo.xIP : EmojiInfo.xIO, e.bN(I), "");
                                        for (String str : bi.F(bi.aD(aD, "").split(","))) {
                                            if (b != null) {
                                                i.aCh().a(str, b, null);
                                            }
                                        }
                                        aVar = aVar;
                                        axVar = ax.this;
                                        aVar.sE(a.e("shareEmoticon:ok", null));
                                        return;
                                    }
                                }
                                b = YB;
                                for (String str2 : bi.F(bi.aD(aD, "").split(","))) {
                                    if (b != null) {
                                        i.aCh().a(str2, b, null);
                                    }
                                }
                                aVar = aVar;
                                axVar = ax.this;
                                aVar.sE(a.e("shareEmoticon:ok", null));
                                return;
                            case 0:
                                aVar = aVar;
                                axVar = ax.this;
                                aVar.sE(a.e("shareEmoticon:ok", null));
                                return;
                            default:
                                aVar = aVar;
                                axVar = ax.this;
                                aVar.sE(a.e("shareEmoticon:ok", null));
                                return;
                        }
                    }
                }
            };
            com.tencent.mm.bl.d.a(context, ".ui.transmit.SelectConversationUI", intent, hashCode() & 65535);
        }
    }
}
