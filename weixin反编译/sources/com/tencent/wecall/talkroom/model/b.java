package com.tencent.wecall.talkroom.model;

import com.tencent.mm.plugin.multi.talk;
import com.tencent.pb.common.a.a;
import com.tencent.pb.common.c.c;
import java.util.concurrent.atomic.AtomicInteger;

public final class b {
    talk Awk = new talk();

    public b() {
        c.d("simon:TalkRoomContext", "construct");
    }

    public final int uninitLive() {
        if (!a.zUT) {
            return 0;
        }
        int uninit;
        try {
            uninit = this.Awk.uninit();
        } catch (Throwable th) {
            c.m("simon:TalkRoomContext", "uninitLive ", th);
            uninit = 0;
        }
        c.d("simon:TalkRoomContext", "uninitLive ret: ", Integer.valueOf(uninit));
        return uninit;
    }

    public final int Close() {
        if (!a.zUT) {
            return 0;
        }
        int close;
        try {
            close = this.Awk.close();
        } catch (Throwable th) {
            c.m("simon:TalkRoomContext", "Close ", th);
            close = 0;
        }
        c.d("simon:TalkRoomContext", "Close ret: ", Integer.valueOf(close));
        return close;
    }

    public final void OnMembersChanged(int[] iArr) {
        if (a.zUT) {
            this.Awk.OnMembersChanged(iArr);
        }
    }

    public final byte[] cIy() {
        if (a.zUT) {
            return this.Awk.field_capInfo;
        }
        return new byte[0];
    }

    public final int cIz() {
        try {
            if (!a.zUT) {
                return 0;
            }
            AtomicInteger atomicInteger = new AtomicInteger();
            AtomicInteger atomicInteger2 = new AtomicInteger();
            this.Awk.getChannelBytes(atomicInteger, atomicInteger2);
            return atomicInteger2.get();
        } catch (Throwable th) {
            c.m("simon:TalkRoomContext", "getTotalWWANBytes: ", th);
            return 0;
        }
    }
}
