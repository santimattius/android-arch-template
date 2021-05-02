package com.santimattius.template.core.presentation

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.santimattius.template.core.presentation.AlertDialog.Companion.alertDialog

fun Fragment.openLink(url: String) {
    if (!url.startsWith("http://") && !url.startsWith("https://")) return
    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    this.startActivity(browserIntent)
}

fun Fragment.showDialog(
    message: String,
    positiveAction: DialogAction,
    negativeAction: DialogAction
) = requireContext().showDialog(message, positiveAction, negativeAction)

fun Context.showDialog(
    message: String,
    positiveAction: DialogAction,
    negativeAction: DialogAction
) = alertDialog(context = this) {
    message(message)
    positiveAction(positiveAction)
    negativeAction(negativeAction)
}

fun ImageView.load(url: String) {
    Glide.with(context).load(url).into(this)
}