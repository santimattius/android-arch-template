package com.santimattius.template.presentation.activities

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SdkSuppress
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.*
import org.hamcrest.Matchers.notNullValue

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

private const val LAUNCH_TIMEOUT = 8000
const val APP_PACKAGE_NAME = "com.santimattius.template"

@RunWith(AndroidJUnit4::class)
@SdkSuppress(minSdkVersion = 18)
class MainActivityTest {
    lateinit var mDevice: UiDevice

    @Before
    fun setUp() {
        mDevice = UiDevice.getInstance(getInstrumentation())
        mDevice.pressHome()

        val launcherPackage = getLauncherPackageName()
        assertThat(launcherPackage, notNullValue())

        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT.toLong())

        val context: Context = getApplicationContext()
        val intent: Intent? = context.packageManager
            .getLaunchIntentForPackage(APP_PACKAGE_NAME)
        intent?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(intent)

        mDevice.wait(
            Until.hasObject(By.pkg(APP_PACKAGE_NAME).depth(0)),
            LAUNCH_TIMEOUT.toLong(),
        )
    }

    @Test
    @Throws(Exception::class)
    fun validateIsItemPresent() {
        val list = UiScrollable(UiSelector()
            .resourceId(resourceId("home_pictures")))
        for (itemIndex in 0 until list.childCount) {
            val selector = UiSelector()
                .resourceId(resourceId("author"))
                .enabled(true).instance(itemIndex)
            val uiItem = list.getChild(selector)
            assertThat(uiItem, notNullValue())
        }
    }

    private fun getLauncherPackageName(): String {
        val intent = Intent(Intent.ACTION_MAIN).apply {
            addCategory(Intent.CATEGORY_HOME)
        }
        val packageManager = getApplicationContext<Context>().packageManager
        val resolveInfo = packageManager.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY)
        return resolveInfo!!.activityInfo.packageName
    }

    private fun resourceId(resourceId: String): String? {
        return "$APP_PACKAGE_NAME:id/$resourceId"
    }
}