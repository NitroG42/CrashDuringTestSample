package com.nitro.crashduringtestsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.nitro.crashduringtestsample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.launchIn

//Without an android entry point, no crashes
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val db: MyDatabase by lazy { MyDatabase.databaseBuilder(applicationContext) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Without binding inflation no crash, even if not used
        ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        val dao = db.userDao()
        //Without watching a flow no crash
        dao.watchCurrentUser().filterNotNull().launchIn(lifecycleScope)
    }
}