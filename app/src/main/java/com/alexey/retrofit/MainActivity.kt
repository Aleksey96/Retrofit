package com.alexey.retrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.alexey.retrofit.registration.RegistrationAccountFragment
import com.alexey.retrofit.signin.SignInFragment
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private var lat: String = "53.19553757"
    private var lon: String = " 50.10178375"
    private val lang: String = "ru_RU"

    companion object {
        val fragmentRegistration = RegistrationAccountFragment()
        val fragmentSignIn = SignInFragment()
    }

    private fun createFragment(fragmentName: String) {
        lateinit var fragmentManagerApp: FragmentTransaction
        when (fragmentName) {
            "Registration" -> {
                fragmentManagerApp = supportFragmentManager.beginTransaction()
                fragmentManagerApp.replace(R.id.container, fragmentRegistration)
            }
            "SignIn" -> {
                fragmentManagerApp = supportFragmentManager.beginTransaction()
                fragmentManagerApp.replace(R.id.container, fragmentSignIn)
            }
        }
        fragmentManagerApp
            .addToBackStack(null)
            .commit()
    }

    private fun createRetrofit(client: OkHttpClient, url: String): ServiceApi =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(url)
            .client(client)
            .build()
            .create(ServiceApi::class.java)

    private fun createHeader(lat: String, lon: String, lang: String, key: String): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {
                    val original = chain.request()
                    val request = original.newBuilder()
                        .header("lat", lat)
                        .header("lon", lon)
                        .header("lang", lang)
                        .header("X-Yandex-API-Key", key)
                        .method(original.method(), original.body())
                        .build()
                    return chain.proceed(request)
                }
            })
            .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_register.setOnClickListener {
            createFragment(resources.getString(R.string.fragment_registration))
        }
        btn_sign_in.setOnClickListener {
            createFragment(resources.getString(R.string.fragment_sign_in))
        }

    }
}
//val header = createHeader(lat, lon, lang, getString(R.string.KEY))
//val serverApi = createRetrofit(header, resources.getString(R.string.URL))
//val response = serverApi.getWeatherCity()

/*call.enqueue(object : Callback<Result> {

    override fun onResponse(call: Call<Result>, response: retrofit2.Response<Result>) {
        if (response.isSuccessful) {
            TODO()
        } else {
            when (response.code()) {
                400 -> {
                    showErrorOnScreen(R.string.Error400)
                }
                403 -> {
                    showErrorOnScreen(R.string.Error403)
                }
                404 -> {
                    showErrorOnScreen(R.string.Error404)
                }
                500 -> {
                    showErrorOnScreen(R.string.Error500)
                }
                502 -> {
                    showErrorOnScreen(R.string.Error502)
                }
                503 -> {
                    showErrorOnScreen(R.string.Error503)
                }
                505 -> {
                    showErrorOnScreen(R.string.Error500)
                }
            }
        }
    }

    override fun onFailure(call: Call<Result>, t: Throwable) {
        println(t.printStackTrace())
        Toast.makeText(this@MainActivity, "Извини,братан,типа fail!", Toast.LENGTH_SHORT)
            .show()
    }
})*/

