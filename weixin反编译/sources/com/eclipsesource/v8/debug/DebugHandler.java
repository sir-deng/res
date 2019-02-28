package com.eclipsesource.v8.debug;

import com.eclipsesource.v8.JavaVoidCallback;
import com.eclipsesource.v8.Releasable;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8Value;
import java.util.ArrayList;
import java.util.List;

public class DebugHandler implements Releasable {
    private static final String CHANGE_BREAK_POINT_CONDITION = "changeBreakPointCondition";
    private static final String CLEAR_BREAK_POINT = "clearBreakPoint";
    private static final String DEBUG_BREAK_HANDLER = "__j2v8_debug_handler";
    public static String DEBUG_OBJECT_NAME = "__j2v8_Debug";
    private static final String DISABLE_ALL_BREAK_POINTS = "disableAllBreakPoints";
    private static final String DISABLE_SCRIPT_BREAK_POINT = "disableScriptBreakPoint";
    private static final String ENABLE_SCRIPT_BREAK_POINT = "enableScriptBreakPoint";
    private static final String FIND_SCRIPT_BREAK_POINT = "findScriptBreakPoint";
    private static final String NUMBER = "number";
    private static final String SCRIPT_BREAK_POINTS = "scriptBreakPoints";
    private static final String SET_BREAK_POINT = "setBreakPoint";
    private static final String SET_LISTENER = "setListener";
    private static final String SET_SCRIPT_BREAK_POINT_BY_NAME = "setScriptBreakPointByName";
    private static final String V8_DEBUG_OBJECT = "Debug";
    private List<BreakHandler> breakHandlers = new ArrayList();
    private V8Object debugObject;
    private V8 runtime;

    private class BreakpointHandler implements JavaVoidCallback {
        private BreakpointHandler() {
        }

        public void invoke(V8Object v8Object, V8Array v8Array) {
            if (v8Array != null && !v8Array.isUndefined()) {
                int integer = v8Array.getInteger(0);
                for (BreakHandler invokeHandler : DebugHandler.this.breakHandlers) {
                    invokeHandler(v8Array, integer, invokeHandler);
                }
            }
        }

        private void invokeHandler(V8Array v8Array, int i, BreakHandler breakHandler) {
            Releasable object;
            Releasable object2;
            Releasable object3;
            Throwable th;
            Releasable releasable;
            Releasable releasable2 = null;
            try {
                object = v8Array.getObject(1);
                try {
                    object2 = v8Array.getObject(2);
                    try {
                        object3 = v8Array.getObject(3);
                    } catch (Throwable th2) {
                        th = th2;
                        releasable = null;
                        object3 = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    releasable = null;
                    object3 = null;
                    object2 = null;
                    safeRelease(object);
                    safeRelease(object2);
                    safeRelease(object3);
                    safeRelease(releasable);
                    safeRelease(releasable2);
                    throw th;
                }
                try {
                    releasable = new ExecutionState(object);
                    try {
                        DebugEvent debugEvent = DebugEvent.values()[i];
                        releasable2 = createDebugEvent(debugEvent, object2);
                        breakHandler.onBreak(debugEvent, releasable, releasable2, object3);
                        safeRelease(object);
                        safeRelease(object2);
                        safeRelease(object3);
                        safeRelease(releasable);
                        safeRelease(releasable2);
                    } catch (Throwable th4) {
                        th = th4;
                        safeRelease(object);
                        safeRelease(object2);
                        safeRelease(object3);
                        safeRelease(releasable);
                        safeRelease(releasable2);
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    releasable = null;
                    safeRelease(object);
                    safeRelease(object2);
                    safeRelease(object3);
                    safeRelease(releasable);
                    safeRelease(releasable2);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                releasable = null;
                object3 = null;
                object2 = null;
                object = null;
                safeRelease(object);
                safeRelease(object2);
                safeRelease(object3);
                safeRelease(releasable);
                safeRelease(releasable2);
                throw th;
            }
        }

        private EventData createDebugEvent(DebugEvent debugEvent, V8Object v8Object) {
            switch (debugEvent) {
                case Break:
                    return new BreakEvent(v8Object);
                case BeforeCompile:
                    return new CompileEvent(v8Object);
                case AfterCompile:
                    return new CompileEvent(v8Object);
                case Exception:
                    return new ExceptionEvent(v8Object);
                default:
                    return new EventData(v8Object);
            }
        }

        private void safeRelease(Releasable releasable) {
            if (releasable != null) {
                releasable.release();
            }
        }
    }

    public enum DebugEvent {
        Undefined(0),
        Break(1),
        Exception(2),
        NewFunction(3),
        BeforeCompile(4),
        AfterCompile(5),
        CompileError(6),
        PromiseError(7),
        AsyncTaskEvent(8);
        
        int index;

        private DebugEvent(int i) {
            this.index = i;
        }
    }

    public DebugHandler(V8 v8) {
        this.runtime = v8;
        setupDebugObject(v8);
        setupBreakpointHandler();
    }

    public void addBreakHandler(BreakHandler breakHandler) {
        this.runtime.getLocker().checkThread();
        this.breakHandlers.add(breakHandler);
    }

    public void removeBreakHandler(BreakHandler breakHandler) {
        this.runtime.getLocker().checkThread();
        this.breakHandlers.remove(breakHandler);
    }

    public int setBreakpoint(V8Function v8Function) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push((V8Value) v8Function);
        try {
            int executeIntegerFunction = this.debugObject.executeIntegerFunction(SET_BREAK_POINT, v8Array);
            return executeIntegerFunction;
        } finally {
            v8Array.release();
        }
    }

    public int setScriptBreakpoint(String str, int i) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(str);
        v8Array.push(i);
        try {
            int executeIntegerFunction = this.debugObject.executeIntegerFunction(SET_SCRIPT_BREAK_POINT_BY_NAME, v8Array);
            return executeIntegerFunction;
        } finally {
            v8Array.release();
        }
    }

    public void enableScriptBreakPoint(int i) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i);
        try {
            this.debugObject.executeVoidFunction(ENABLE_SCRIPT_BREAK_POINT, v8Array);
        } finally {
            v8Array.release();
        }
    }

    public void disableScriptBreakPoint(int i) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i);
        try {
            this.debugObject.executeVoidFunction(DISABLE_SCRIPT_BREAK_POINT, v8Array);
        } finally {
            v8Array.release();
        }
    }

    public void clearBreakPoint(int i) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i);
        try {
            this.debugObject.executeVoidFunction(CLEAR_BREAK_POINT, v8Array);
        } finally {
            v8Array.release();
        }
    }

    public void disableAllBreakPoints() {
        this.debugObject.executeVoidFunction(DISABLE_ALL_BREAK_POINTS, null);
    }

    public int getScriptBreakPointCount() {
        V8Array executeArrayFunction = this.debugObject.executeArrayFunction(SCRIPT_BREAK_POINTS, null);
        try {
            int length = executeArrayFunction.length();
            return length;
        } finally {
            executeArrayFunction.release();
        }
    }

    public int[] getScriptBreakPointIDs() {
        V8Array executeArrayFunction = this.debugObject.executeArrayFunction(SCRIPT_BREAK_POINTS, null);
        int[] iArr = new int[executeArrayFunction.length()];
        int i = 0;
        while (i < executeArrayFunction.length()) {
            V8Object object = executeArrayFunction.getObject(i);
            try {
                iArr[i] = object.executeIntegerFunction(NUMBER, null);
                object.release();
                i++;
            } catch (Throwable th) {
                executeArrayFunction.release();
            }
        }
        executeArrayFunction.release();
        return iArr;
    }

    public ScriptBreakPoint getScriptBreakPoint(int i) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i);
        v8Array.push(false);
        V8Object v8Object = null;
        try {
            v8Object = this.debugObject.executeObjectFunction(FIND_SCRIPT_BREAK_POINT, v8Array);
            ScriptBreakPoint scriptBreakPoint = new ScriptBreakPoint(v8Object);
            return scriptBreakPoint;
        } finally {
            v8Array.release();
            if (v8Object != null) {
                v8Object.release();
            }
        }
    }

    public void changeBreakPointCondition(int i, String str) {
        V8Array v8Array = new V8Array(this.runtime);
        v8Array.push(i);
        v8Array.push(str);
        try {
            this.debugObject.executeVoidFunction(CHANGE_BREAK_POINT_CONDITION, v8Array);
        } finally {
            v8Array.release();
        }
    }

    public void release() {
        this.debugObject.release();
    }

    private void setupDebugObject(V8 v8) {
        V8Object object = v8.getObject(DEBUG_OBJECT_NAME);
        try {
            this.debugObject = object.getObject(V8_DEBUG_OBJECT);
        } finally {
            object.release();
        }
    }

    private void setupBreakpointHandler() {
        Throwable th;
        V8Value v8Value;
        Throwable th2;
        V8Array v8Array;
        V8Object v8Value2 = null;
        this.debugObject.registerJavaMethod(new BreakpointHandler(), DEBUG_BREAK_HANDLER);
        try {
            V8Array push;
            V8Value v8Value3 = (V8Function) this.debugObject.getObject(DEBUG_BREAK_HANDLER);
            try {
                push = new V8Array(this.runtime).push(v8Value3);
            } catch (Throwable th3) {
                th = th3;
                V8Object v8Array2 = v8Value2;
                v8Value2 = v8Value3;
                th2 = th;
            }
            try {
                this.debugObject.executeFunction(SET_LISTENER, push);
                if (!(v8Value3 == null || v8Value3.isReleased())) {
                    v8Value3.release();
                }
                if (push != null && !push.isReleased()) {
                    push.release();
                }
            } catch (Throwable th32) {
                th = th32;
                v8Array2 = push;
                v8Value2 = v8Value3;
                th2 = th;
                if (!(v8Value2 == null || v8Value2.isReleased())) {
                    v8Value2.release();
                }
                if (!(v8Array2 == null || v8Array2.isReleased())) {
                    v8Array2.release();
                }
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            v8Array2 = v8Value2;
            v8Value2.release();
            v8Array2.release();
            throw th2;
        }
    }
}
