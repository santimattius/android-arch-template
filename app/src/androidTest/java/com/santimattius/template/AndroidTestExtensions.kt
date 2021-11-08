package com.santimattius.template

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.testing.launchFragmentInContainer


inline fun <reified F : Fragment> launchFragment(init: Bundle.() -> Unit = {}) {
    val args = Bundle()
    args.init()
    launchFragmentInContainer<F>(args, R.style.Theme_Androidarchtemplate)
}