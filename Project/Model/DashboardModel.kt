package tops.tech.batchproject_morning.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class DashboardModel
{
    @Expose
    @SerializedName("id")
    var id = 0

    @Expose
    @SerializedName("name")
    var name: String? = null

    @Expose
    @SerializedName("url")
    var url: String? = null


}