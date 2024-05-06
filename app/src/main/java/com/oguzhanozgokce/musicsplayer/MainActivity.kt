package com.oguzhanozgokce.musicsplayer

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}