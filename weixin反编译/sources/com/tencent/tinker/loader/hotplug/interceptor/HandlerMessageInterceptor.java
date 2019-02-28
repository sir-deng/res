package com.tencent.tinker.loader.hotplug.interceptor;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.reflect.Field;

public class HandlerMessageInterceptor extends Interceptor<Callback> {
    private static Field Atu;
    private final Handler Ats;
    private final MessageHandler Att;

    public interface MessageHandler {
        boolean handleMessage(Message message);
    }

    private static class CallbackWrapper implements Callback, ITinkerHotplugProxy {
        private final MessageHandler Att;
        private final Callback Atv;
        private volatile boolean Atw = false;

        CallbackWrapper(MessageHandler messageHandler, Callback callback) {
            this.Att = messageHandler;
            this.Atv = callback;
        }

        public boolean handleMessage(Message message) {
            if (this.Atw) {
                return false;
            }
            boolean handleMessage;
            this.Atw = true;
            this.Att.handleMessage(message);
            if (this.Atv != null) {
                handleMessage = this.Atv.handleMessage(message);
            } else {
                handleMessage = false;
            }
            this.Atw = false;
            return handleMessage;
        }
    }

    protected final /* synthetic */ void cB(Object obj) {
        Atu.set(this.Ats, (Callback) obj);
    }

    protected final /* synthetic */ Object cC(Object obj) {
        Callback callback = (Callback) obj;
        return (callback == null || !ITinkerHotplugProxy.class.isAssignableFrom(callback.getClass())) ? new CallbackWrapper(this.Att, callback) : callback;
    }

    protected final /* synthetic */ Object cHW() {
        return (Callback) Atu.get(this.Ats);
    }

    static {
        Atu = null;
        synchronized (HandlerMessageInterceptor.class) {
            if (Atu == null) {
                try {
                    Atu = ShareReflectUtil.d(Handler.class, "mCallback");
                } catch (Throwable th) {
                }
            }
        }
    }

    public HandlerMessageInterceptor(Handler handler, MessageHandler messageHandler) {
        this.Ats = handler;
        this.Att = messageHandler;
    }
}
