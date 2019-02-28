package com.tencent.mm.plugin.wear.model.e;

import android.content.Intent;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public final class f extends a {
    public final List<Integer> bPu() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_ERROR_NET_RECONNECT));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_ERROR_READ_FAILED));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_ERROR_WRITE_FAILED));
        return arrayList;
    }

    protected final byte[] n(int i, byte[] bArr) {
        String str;
        String str2 = "";
        try {
            str = new String(bArr, "utf8");
        } catch (UnsupportedEncodingException e) {
            str = str2;
        }
        if (bi.oN(str)) {
            x.i("MicroMsg.Wear.HttpFriendServer", "error to get username");
        } else {
            x.i("MicroMsg.Wear.HttpFriendServer", "handle friend request %s", str);
            Intent intent;
            if (i == TXCStreamUploader.TXE_UPLOAD_ERROR_NET_RECONNECT) {
                intent = new Intent();
                intent.setClassName(ad.getPackageName(), ad.getPackageName() + ".plugin.subapp.ui.friend.FMessageTransferUI");
                intent.putExtra("friend_message_transfer_username", str);
                intent.setAction("friend_message_accept_" + str);
                intent.setFlags(335544320);
                ad.getContext().startActivity(intent);
            } else if (i == TXCStreamUploader.TXE_UPLOAD_ERROR_READ_FAILED) {
                intent = new Intent();
                intent.setClassName(ad.getPackageName(), ad.getPackageName() + ".plugin.subapp.ui.friend.FMessageTransferUI");
                intent.putExtra("friend_message_transfer_username", str);
                intent.setAction("friend_message_ignore_" + str);
                intent.setFlags(335544320);
                ad.getContext().startActivity(intent);
            } else if (i == TXCStreamUploader.TXE_UPLOAD_ERROR_WRITE_FAILED) {
                Intent intent2 = new Intent();
                intent2.setClassName(ad.getPackageName(), ad.getPackageName() + ".plugin.subapp.ui.friend.FMessageConversationUI");
                intent2.setFlags(335544320);
                ad.getContext().startActivity(intent2);
            }
        }
        return null;
    }
}
