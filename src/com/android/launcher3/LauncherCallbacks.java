/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.launcher3;

import android.os.Bundle;

import com.aospextended.launcher.qsb.QsbAnimationController;

import com.google.android.libraries.gsa.launcherclient.LauncherClient;

import java.io.FileDescriptor;
import java.io.PrintWriter;

/**
 * LauncherCallbacks is an interface used to extend the Launcher activity. It includes many hooks
 * in order to add additional functionality. Some of these are very general, and give extending
 * classes the ability to react to Activity life-cycle or specific user interactions. Others
 * are more specific and relate to replacing parts of the application, for example, the search
 * interface or the wallpaper picker.
 */
public interface LauncherCallbacks {

    /*
     * Activity life-cycle methods. These methods are triggered after
     * the code in the corresponding Launcher method is executed.
     */
    void onCreate(Bundle savedInstanceState);
    void dump(String prefix, FileDescriptor fd, PrintWriter w, String[] args);
    void onHomeIntent(boolean internalStateHandled);

    /**
     * Starts a search with {@param initialQuery}. Return false if search was not started.
     */
    boolean startSearch(
            String initialQuery, boolean selectInitialQuery, Bundle appSearchData);

    /*
     * Retrieves the current Launcher Client
     */
    LauncherClient getClient();

    /*
     * Retrieves the QSB Animation Controller
     */
    QsbAnimationController getQsbController();
}
