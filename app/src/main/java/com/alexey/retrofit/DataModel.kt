package com.alexey.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ServerResponse(
    @SerializedName("now")
    @Expose
    var now: Long,
    @SerializedName("now_dt")
    @Expose
    var now_dt: String,
    @SerializedName("info")
    @Expose
    var info: Info,
    @SerializedName("fact")
    @Expose
    var fact: Fact,
    @SerializedName("forecasts")
    @Expose
    var forecasts: List<Forecasts>
)

data class Info(
    @SerializedName("lat")
    @Expose
    var lat: Double,
    @SerializedName("lon")
    @Expose
    var lon: Double,
    @SerializedName("tzinfo")
    @Expose
    var tzinfo: TzInfo,
    @SerializedName("def_pressure_mm")
    @Expose
    var def_pressure_mm: Double,
    @SerializedName("def_pressure_pa")
    @Expose
    var def_pressure_pa: Double,
    @SerializedName("url")
    @Expose
    var url: String
)

data class TzInfo(
    @SerializedName("offset")
    @Expose
    var offset: Long,
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("abbr")
    @Expose
    var abbr: String,
    @SerializedName("dst")
    @Expose
    var dst: Boolean
)

data class Fact(
    @SerializedName("temp")
    @Expose
    var temp: Double,
    @SerializedName("feels_like")
    @Expose
    var feels_like: Double,
    @SerializedName("temp_water")
    @Expose
    var temp_water: Double,
    @SerializedName("icon")
    @Expose
    var icon: String,
    @SerializedName("condition")
    @Expose
    var condition: String,
    @SerializedName("wind_speed")
    @Expose
    var wind_speed: Double,
    @SerializedName("wind_qust")
    @Expose
    var wind_gust: Double,
    @SerializedName("wind_dir")
    @Expose
    var wind_dir: String,
    @SerializedName("pressure_mm")
    @Expose
    var pressure_mm: Double,
    @SerializedName("pressure_pa")
    @Expose
    var pressure_pa: Double,
    @SerializedName("humidity")
    @Expose
    var humidity: Double,
    @SerializedName("daytime")
    @Expose
    var daytime: String,
    @SerializedName("polar")
    @Expose
    var polar: Boolean,
    @SerializedName("season")
    @Expose
    var season: String,
    @SerializedName("obs_time")
    @Expose
    var obs_time: Long,
    @SerializedName("prec_type")
    @Expose
    var prec_type: Int,
    @SerializedName("prec_strength")
    @Expose
    var prec_strength: Double,
    @SerializedName("cloudness")
    @Expose
    var cloudness: Double,
    @SerializedName("phenom_icon")
    @Expose
    var phenom_icon: String,
    @SerializedName("phenom_condition")
    @Expose
    var phenom_condition: String
)

data class Forecasts(
    @SerializedName("date")
    @Expose
    var date: String,
    @SerializedName("date_ts")
    @Expose
    var date_ts: Long,
    @SerializedName("week")
    @Expose
    var week: Int,
    @SerializedName("sunrise")
    @Expose
    var sunrise: String,
    @SerializedName("sunset")
    @Expose
    var sunset: String,
    @SerializedName("moon_code")
    @Expose
    var moon_code: Int,
    @SerializedName("moon_text")
    @Expose
    var moon_text: String,
    @SerializedName("parts")
    @Expose
    var parts: Parts,
    @SerializedName("hours")
    @Expose
    var hours: List<Hour>
)

data class Parts(
    @SerializedName("night")
    @Expose
    var night: DayTime,
    @SerializedName("morning")
    @Expose
    var morning: DayTime,
    @SerializedName("day")
    @Expose
    var day: DayTime,
    @SerializedName("evening")
    @Expose
    var evening: DayTime,
    @SerializedName("night_short")
    @Expose
    var night_short: NightShort,
    @SerializedName("day_short")
    @Expose
    var day_short: DayShort
)


data class DayTime(
    @SerializedName("temp_max")
    @Expose
    var temp_max: Double,
    @SerializedName("temp_min")
    @Expose
    var temp_min: Double,
    @SerializedName("temp_avg")
    @Expose
    var temp_avg: Double,
    @SerializedName("feels_like")
    @Expose
    var feels_like: Double,
    @SerializedName("icon")
    @Expose
    var icon: String,
    @SerializedName("condition")
    @Expose
    var condition: String,
    @SerializedName("daytime")
    @Expose
    var daytime: String,
    @SerializedName("polar")
    @Expose
    var polar: Boolean,
    @SerializedName("wind_speed")
    @Expose
    var wind_speed: Double,
    @SerializedName("wind_gust")
    @Expose
    var wind_gust: Double,
    @SerializedName("wind_dir")
    @Expose
    var wind_dir: Double,
    @SerializedName("pressure_mm")
    @Expose
    var pressure_mm: Double,
    @SerializedName("pressure_pa")
    @Expose
    var pressure_pa: Double,
    @SerializedName("humidity")
    @Expose
    var humidity: Double,
    @SerializedName("prec_mm")
    @Expose
    var prec_mm: Double,
    @SerializedName("prec_type")
    @Expose
    var prec_type: Int,
    @SerializedName("prec_period")
    @Expose
    var prec_period: Double,
    @SerializedName("prec_strength")
    @Expose
    var prec_strength: Double,
    @SerializedName("cloudness")
    @Expose
    var cloudness: Double
)

data class NightShort(
    @SerializedName("temp")
    @Expose
    var temp: Double,
    @SerializedName("feels_like")
    @Expose
    var feels_ike: Double,
    @SerializedName("icon")
    @Expose
    var icon: String,
    @SerializedName("condition")
    @Expose
    var condition: String,
    @SerializedName("wind_speed")
    @Expose
    var wind_speed: Double,
    @SerializedName("wind_gust")
    @Expose
    var wind_gust: Double,
    @SerializedName("wind_dir")
    @Expose
    var wind_dir: Double,
    @SerializedName("pressure_mm")
    @Expose
    var pressure_mm: Double,
    @SerializedName("pressure_pa")
    @Expose
    var pressure_pa: Double,
    @SerializedName("humidity")
    @Expose
    var humidity: Double,
    @SerializedName("prec_type")
    @Expose
    var prec_type: Int,
    @SerializedName("prec_strength")
    @Expose
    var prec_strength: Double,
    @SerializedName("cloudness")
    @Expose
    var cloudness: Double
)

data class DayShort(
    @SerializedName("temp")
    @Expose
    var temp: Double,
    @SerializedName("temp_min")
    @Expose
    var temp_min: Double,
    @SerializedName("feels_like")
    @Expose
    var feels_ike: Double,
    @SerializedName("icon")
    @Expose
    var icon: String,
    @SerializedName("condition")
    @Expose
    var condition: String,
    @SerializedName("wind_speed")
    @Expose
    var wind_speed: Double,
    @SerializedName("wind_gust")
    @Expose
    var wind_gust: Double,
    @SerializedName("wind_dir")
    @Expose
    var wind_dir: Double,
    @SerializedName("pressure_mm")
    @Expose
    var pressure_mm: Double,
    @SerializedName("pressure_pa")
    @Expose
    var pressure_pa: Double,
    @SerializedName("humidity")
    @Expose
    var humidity: Double,
    @SerializedName("prec_type")
    @Expose
    var prec_type: Int,
    @SerializedName("prec_strength")
    @Expose
    var prec_strength: Double,
    @SerializedName("cloudness")
    @Expose
    var cloudness: Double
)

data class Hour(
    @SerializedName("hour")
    @Expose
    var hour: String,
    @SerializedName("hour_ts")
    @Expose
    var hour_ts: Long,
    @SerializedName("temp")
    @Expose
    var temp: Double,
    @SerializedName("feels_like")
    @Expose
    var feels_ike: Double,
    @SerializedName("icon")
    @Expose
    var icon: String,
    @SerializedName("condition")
    @Expose
    var condition: String,
    @SerializedName("wind_speed")
    @Expose
    var wind_speed: Double,
    @SerializedName("wind_gust")
    @Expose
    var wind_gust: Double,
    @SerializedName("wind_dir")
    @Expose
    var wind_dir: Double,
    @SerializedName("pressure_mm")
    @Expose
    var pressure_mm: Double,
    @SerializedName("pressure_pa")
    @Expose
    var pressure_pa: Double,
    @SerializedName("humidity")
    @Expose
    var humidity: Double,
    @SerializedName("prec_mm")
    @Expose
    var prec_mm: Double,
    @SerializedName("prec_type")
    @Expose
    var prec_type: Int,
    @SerializedName("prec_period")
    @Expose
    var prec_period: Double,
    @SerializedName("prec_strength")
    @Expose
    var prec_strength: Double,
    @SerializedName("is_thunder")
    @Expose
    var is_thunder: Boolean,
    @SerializedName("cloudness")
    @Expose
    var cloudness: Double
)




