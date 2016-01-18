package com.silencework.silencedownloader.core;

import android.app.Application;

import com.silencework.silencedownloader.R;
import com.silencework.silencedownloader.core.exception.UnableCreateDirException;

import java.io.File;
import java.io.IOException;

/**
 * Created by mayongsheng on 16-1-18.
 */
public class DownloadThread extends Thread{

    private DownloadTask mTask;
    private Application mApp;
    public DownloadThread(DownloadTask task,Application app){
        this.mTask = task;
        this.mApp = app;
    }

    @Override
    public void run() {

    }

    /**
     * make directory,init download status
     */
    private void prepareForDownload() throws UnableCreateDirException {
        File rootDir = new File(this.mTask.getRootDirectory());
        if(!rootDir.exists()){
            if(!rootDir.mkdirs()){
                throw new UnableCreateDirException(this.mApp.getResources().getString(R.string.downloaderror_unablecreatedir,rootDir.getAbsolutePath()));
            }
        }
        File fullDir = new File(this.mTask.getRootDirectory(),this.mTask.getSubDirectory());
        if(!fullDir.exists()){
            if(!fullDir.mkdirs()){
                throw new UnableCreateDirException(this.mApp.getResources().getString(R.string.downloaderror_unablecreatedir,fullDir.getAbsolutePath()));
            }
        }
        File targetFile = new File(fullDir,this.mTask.getFileName());
        if(!targetFile.exists()){
            try {
                if(!targetFile.createNewFile()){
                    throw new UnableCreateDirException(this.mApp.getResources().getString(R.string.downloaderror_unablecreatedir,targetFile.getAbsolutePath()));
                }
            } catch (IOException e) {
                throw new UnableCreateDirException(this.mApp.getResources().getString(R.string.downloaderror_unablecreatedir,targetFile.getAbsolutePath()));
            }
        }
    }
}
