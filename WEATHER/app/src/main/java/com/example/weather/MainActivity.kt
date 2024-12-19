package com.example.weather

import android.os.Bundle
import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.weather.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.DayOfWeek
import android.location.Geocoder
import android.location.Address

//a386a1997730026cd442d2d5835bd99f

class MainActivity : AppCompatActivity() {
    // Check if permission is granted
    private fun isLocationPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }


    private fun fetchWeatherDataByCoordinates(latitude: Double, longitude: Double) {
        val geocoder = Geocoder(this, Locale.getDefault())

        // Use Geocoder to get the city name
        val addresses = geocoder.getFromLocation(latitude, longitude, 1)
        var cityname = "Unknown city"
        if (!addresses.isNullOrEmpty()) {
            cityname = addresses[0].locality;
        }

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .build().create(ApiInterface::class.java)

        val response = retrofit.getWeatherDataByCoordinates(
            latitude,
            longitude,
            "a386a1997730026cd442d2d5835bd99f",
            "metric"
        )
        response.enqueue(object : Callback<WeatherApp> {
            override fun onResponse(call: Call<WeatherApp>, response: Response<WeatherApp>) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    val temperature = responseBody.main.temp
                    val humidity = responseBody.main.humidity
                    val windspeed = responseBody.wind.speed
                    var sunrise = responseBody.sys.sunrise
                    val fsunrise = convertUnixToNormalTime(sunrise.toLong())
                    val sunset = responseBody.sys.sunset
                    val fsunset = convertUnixToNormalTime(sunset.toLong())
                    val sealevel = responseBody.main.pressure
                    val condition = responseBody.weather.firstOrNull()?.main ?: "unknown"
                    val mintemp = responseBody.main.temp_min
                    val maxtemp = responseBody.main.temp_max

                    //Log.d("mainactivity", "onResponse: $temperature")
                    binding.temperature.text = "${temperature.roundToInt()} °C"
                    binding.weather.text = condition
                    binding.minTemp.text = "Min: " + mintemp.toString() + " °C"
                    binding.maxTemp.text = "Max: " + maxtemp.toString() + "°C"
                    binding.humidity.text = humidity.toString() + " %"
                    binding.windspeed.text = windspeed.toString() + " m/s"
                    binding.textView17.text = condition
                    changelottie(condition)
                    binding.sunrise.text = fsunrise
                    binding.sunset.text = fsunset
                    binding.sea.text = sealevel.toString() + " hPa"
                    binding.day.text = getCurrentDay()
                    binding.date.text = getCurrentDate()
                    binding.cityname.text = cityname.lowercase()
                        .replaceFirstChar { it.uppercase() } + ", " + responseBody.sys.country


                } else {
                    // If city not found (404 error), display a toast or error message
                    Toast.makeText(
                        applicationContext,
                        "City not found! Please try again.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<WeatherApp>, t: Throwable) {
                Toast.makeText(applicationContext, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }


        })
    }


    private fun fetchCurrentLocationWeather() {
        fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
            if (location != null) {
                // Use the location to fetch weather data
                val latitude = location.latitude
                val longitude = location.longitude
                fetchWeatherDataByCoordinates(latitude, longitude)
            } else {
                Toast.makeText(this, "Unable to get current location", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                fetchCurrentLocationWeather()
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
            }
        }

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        if (isLocationPermissionGranted()) {
            // Permission is already granted, fetch weather data
            fetchCurrentLocationWeather()
        } else {
            // Request permission if not granted
            requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }

        // Get reference to SearchView
        val searchView = binding.searchViewm

        // Set the listener for query text changes
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Handle the query when the user submits it
                if (!query.isNullOrEmpty()) {
                    fetchWeatherData(query)
                    searchView.setQuery("", false)  // Clear the query text
                    searchView.clearFocus()  // Remove focus to close the keyboard
                } else {
                    // No query entered, fetch weather by location
                    fetchCurrentLocationWeather()
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        // fetchWeatherData()

    }

    private fun changelottie(condi: String) {
        when (condi.lowercase()) {
            "snow" -> {
                binding.lottieAnimationView.setAnimation(R.raw.snow)
                binding.root.setBackgroundResource(R.drawable.snow_background)
            }

            "rain" -> {
                binding.lottieAnimationView.setAnimation(R.raw.rain)
                binding.root.setBackgroundResource(R.drawable.rain_background)
            }

            "clouds" -> {
                binding.lottieAnimationView.setAnimation(R.raw.cloud)
                binding.root.setBackgroundResource(R.drawable.colud_background)
            }

            else -> {
                binding.lottieAnimationView.setAnimation(R.raw.sunny)
                binding.root.setBackgroundResource(R.drawable.sunny_background)
            }

        }
    }

    fun convertUnixToNormalTime(unixTimestamp: Long): String {
        // Multiply by 1000 to convert seconds to milliseconds
        val date = Date(unixTimestamp * 1000)
        // Format date into human-readable form
        val formatter = SimpleDateFormat("HH:mm", Locale.getDefault())
        formatter.timeZone = TimeZone.getDefault() // Use the device's local timezone
        return formatter.format(date)
    }


    // Function to get the current date in a specific format
    fun getCurrentDate(): String {
        val currentDate = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")  // Customize the format if needed
        return currentDate.format(formatter)
    }

    // Function to get the current day of the week
    fun getCurrentDay(): String {
        val currentDate = LocalDate.now()
        val dayOfWeek: DayOfWeek = currentDate.dayOfWeek
        return dayOfWeek.name.lowercase()
            .replaceFirstChar { it.uppercase() }  // Converts to "Monday", "Tuesday", etc.
    }


    private fun fetchWeatherData(cityname: String) {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .build().create(ApiInterface::class.java)

        val response =
            retrofit.getWeatherData(cityname, "a386a1997730026cd442d2d5835bd99f", "metric")
        response.enqueue(object : Callback<WeatherApp> {
            override fun onResponse(call: Call<WeatherApp>, response: Response<WeatherApp>) {
                val responseBody = response.body()
                if (response.isSuccessful && responseBody != null) {
                    val temperature = responseBody.main.temp
                    val humidity = responseBody.main.humidity
                    val windspeed = responseBody.wind.speed
                    var sunrise = responseBody.sys.sunrise
                    val fsunrise = convertUnixToNormalTime(sunrise.toLong())
                    val sunset = responseBody.sys.sunset
                    val fsunset = convertUnixToNormalTime(sunset.toLong())
                    val sealevel = responseBody.main.pressure
                    val condition = responseBody.weather.firstOrNull()?.main ?: "unknown"
                    val mintemp = responseBody.main.temp_min
                    val maxtemp = responseBody.main.temp_max

                    //Log.d("mainactivity", "onResponse: $temperature")
                    binding.temperature.text = "${temperature.roundToInt()} °C"
                    binding.weather.text = condition
                    binding.minTemp.text = "Min: " + mintemp.toString() + " °C"
                    binding.maxTemp.text = "Max: " + maxtemp.toString() + "°C"
                    binding.humidity.text = humidity.toString() + " %"
                    binding.windspeed.text = windspeed.toString() + " m/s"
                    binding.textView17.text = condition
                    changelottie(condition)
                    binding.sunrise.text = fsunrise
                    binding.sunset.text = fsunset
                    binding.sea.text = sealevel.toString() + " hPa"
                    binding.day.text = getCurrentDay()
                    binding.date.text = getCurrentDate()
                    binding.cityname.text = cityname.lowercase()
                        .replaceFirstChar { it.uppercase() } + ", " + responseBody.sys.country


                } else {
                    // If city not found (404 error), display a toast or error message
                    Toast.makeText(
                        applicationContext,
                        "City not found! Please try again.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<WeatherApp>, t: Throwable) {
                Toast.makeText(applicationContext, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }


        })
    }
}