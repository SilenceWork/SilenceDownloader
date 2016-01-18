package com.silencework.silencedownloader.api;

import com.silencework.silencedownloader.core.DownloadTask;

/**
 * Created by mayongsheng on 16-1-18.
 *
 * the callback to notify client update it`s ui,every task`state like running,pause,progress...
 * store in DownloadTask
 */
public interface TaskListener {
    void onDownloadStarted(DownloadTask task);
    void onDownloadPaused(DownloadTask task);
    void onDownloadCanceled(DownloadTask task);
    void onDownloadResumed(DownloadTask task);
    void onDownloadError(DownloadTask task);
    void onDownloadPregrossChanged(DownloadTask task);
}
