package com.softdesign.school.utils;

import android.util.Log;

/**
 * Обертка для стандартного {@link android.util.Log}.
 * Позволяет указывать префикс для тега, форматировать вывод сообщений
 * (смотреть {@link #helper(Integer, String, String)}).
 */
public class Lg {

    /**
     * Префикс сообщений в логе.
     */
    private static final String PREFIX = "SCHOOL ";

    /**
     * Максимальная длина логгируемого сообщения.
     * При превышении значения имитируется перенос строки.
     */
    public static final int LOGCAT_BUFFER_SIZE = 3000;

    private Lg() {
    }

    /**
     * Проверяет включено ли логгирование.
     *
     * @return Boolean
     */
    private static boolean shouldLog() {
        // TODO: Раскомментировать когда будет доступен класс с конфигом
        // return BuildConfig.IS_LOGCAT_LOGGER_ENABLED;
        return true;
    }

    /**
     * Отправляет в лог сообщение с уровнем {@link android.util.Log#VERBOSE}.
     *
     * @param tag Используется для идентификации источника сообщения.
     * @param msg Сообщение которое нужно залогировать.
     */
    public static void v(String tag, String msg) {
        helper(Log.VERBOSE, tag, msg);
    }

    /**
     * Отправляет в лог сообщение с уровнем {@link android.util.Log#DEBUG}.
     *
     * @param tag Используется для идентификации источника сообщения.
     * @param msg Сообщение которое нужно залогировать.
     */
    public static void d(String tag, String msg) {
        helper(Log.DEBUG, tag, msg);
    }

    /**
     * Отправляет в лог сообщение с уровнем {@link android.util.Log#INFO}.
     *
     * @param tag Используется для идентификации источника сообщения.
     * @param msg Сообщение которое нужно залогировать.
     */
    public static void i(String tag, String msg) {
        helper(Log.INFO, tag, msg);
    }

    /**
     * Отправляет в лог сообщение с уровнем {@link android.util.Log#WARN}.
     *
     * @param tag Используется для идентификации источника сообщения.
     * @param msg Сообщение которое нужно залогировать.
     */
    public static void w(String tag, String msg) {
        helper(Log.WARN, tag, msg);
    }

    /**
     * Отправляет в лог сообщение с уровнем {@link android.util.Log#ERROR}.
     *
     * @param tag Используется для идентификации источника сообщения.
     * @param msg Сообщение которое нужно залогировать.
     */
    public static void e(String tag, String msg) {
        helper(Log.ERROR, tag, msg);
    }

    /**
     * Отправляет в лог сообщение с уровнем {@link android.util.Log#ASSERT}.
     *
     * @param tag Используется для идентификации источника сообщения.
     * @param msg Сообщение которое нужно залогировать.
     */
    public static void a(String tag, String msg) {
        helper(Log.ASSERT, tag, msg);
    }

    /**
     * Обертка для логгера.
     * Выполняет задачи:
     * – Проверка на необходимость логгирования (подробнее: {@link #shouldLog()}).
     * – Форматирование вывода (подробнее: {@link #LOGCAT_BUFFER_SIZE}).
     *
     * @param level Константа определяющая приоритет логгируемого сообщения.
     *              Используются константы из пакета {@link android.util.Log},
     *              например {@link android.util.Log#VERBOSE}
     * @param tag   Используется для идентификации источника сообщения.
     * @param msg   Сообщение которое нужно залогировать.
     */
    private static void helper(Integer level, String tag, String msg) {
        if (shouldLog()) {
            String str = msg;

            while (str.length() > LOGCAT_BUFFER_SIZE) {
                String substr = str.substring(0, LOGCAT_BUFFER_SIZE);
                str = substr.substring(LOGCAT_BUFFER_SIZE);
                log(level, PREFIX + tag, substr);
            }

            log(level, PREFIX + tag, str);
        }
    }

    /**
     * Вызывает метод класса {@link android.util.Log} соответствующий уровню приоритета,
     * например {@link android.util.Log#w(String, String)}.
     *
     * @param level Константа определяющая приоритет логгируемого сообщения.
     *              Используются константы из пакета {@link android.util.Log},
     *              например {@link android.util.Log#VERBOSE}
     * @param tag   Используется для идентификации источника сообщения.
     * @param msg   Сообщение которое нужно залогировать.
     */
    private static void log(Integer level, String tag, String msg) {
        switch (level) {
            case Log.VERBOSE:
                Log.v(tag, msg);
                break;
            case Log.DEBUG:
                Log.d(tag, msg);
                break;
            case Log.INFO:
                Log.i(tag, msg);
                break;
            case Log.WARN:
                Log.w(tag, msg);
                break;
            case Log.ERROR:
                Log.e(tag, msg);
                break;
            case Log.ASSERT:
                Log.println(Log.ASSERT, tag, msg);
                break;
        }
    }
}
