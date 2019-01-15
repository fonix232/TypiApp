package me.fonix232.tipyapp.ui.activity

import me.fonix232.common.ui.activity.BaseActivity
import me.fonix232.tipyapp.R
import me.fonix232.tipyapp.bindings.MainActivityBinding
import me.fonix232.tipyapp.viewmodel.MainViewModel

class MainActivity : BaseActivity<MainViewModel, MainActivityBinding>(MainViewModel::class, R.layout.activity_main) {

}