package com.oguzhanozgokce.musicsplayer

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.oguzhanozgokce.musicsplayer.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

// BU projde Rapid Api sitesinde deezer api kullanılmıştır.
// Müzik uygulaması olucaktır ve projede MVVM mimarisi kullanılıcaktır
// Proje yapısı şu şekilde olucaktır:
// 1- Model: Verilerin tutulduğu sınıflar
// 2- View: Kullanıcı arayüzüne ait sınıflar
// 3- ViewModel: Model ve View arasındaki bağlantıyı sağlayan sınıflar
// 4- Repository: Verilerin alındığı ve işlendiği sınıflar
// 5- Service: Verilerin alındığı sınıflar
// 6- Adapter: RecyclerView için adapter sınıflar
// 7- Util: Yardımcı sınıflar
// 8- Di: Dependency Injection sınıfları
// 9- Di/Module: Dependency Injection modülleri
// 10- Di/Scope: Dependency Injection scope sınıfları

// Uygulamanın paket yapısı şu şekilde olucaktır:
// 1- data: Verilerin alındığı ve işlendiği sınıflar : Model, Repository, Service
// 2- di: Dependency Injection sınıfları : Di, Di/Module, Di/Scope
// 3- ui: Kullanıcı arayüzüne ait sınıflar : View, ViewModel, Adapter
// 4- util: Yardımcı sınıflar : Util


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        window.statusBarColor = resources.getColor(R.color.dark_blue)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

    }
}