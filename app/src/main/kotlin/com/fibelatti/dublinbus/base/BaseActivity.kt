package com.fibelatti.dublinbus.base

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.fibelatti.dublinbus.R

fun AppCompatActivity.toast(message: String, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, duration).show()
}

fun AppCompatActivity.hideKeyboard() {
    val view = this.currentFocus
    if (view != null) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

abstract class BaseActivity : AppCompatActivity(), BaseView {
    lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        progressDialog = ProgressDialog(this@BaseActivity)
    }

    override fun setContentView(@LayoutRes layoutResID: Int) {
        super.setContentView(layoutResID)
    }

    override fun setTitle(@StringRes stringResId: Int) {
        super.setTitle(stringResId)
    }

    override fun showProgress() {
        runOnUiThread {
            if (!progressDialog.isShowing) {
                progressDialog.setMessage(getString(R.string.hint_loading))
                progressDialog.setCancelable(false)
                progressDialog.show()
            }
        }
    }

    override fun hideProgress() {
        runOnUiThread {
            if (progressDialog.isShowing) {
                progressDialog.dismiss()
            }
        }
    }

    override fun getContentView(): View {
        return window.decorView
    }
}
