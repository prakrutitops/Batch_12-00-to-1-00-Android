package tops.tech.retrofitdata;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


public interface Apiinterface
{

    @Multipart
    @POST("uploaddata.php")
    Call<ResponseBody> uploaddata
            (
            @Part("emp_name") RequestBody emp_name,
            @Part("emp_mobile") RequestBody emp_mobile,
            @Part("emp_email") RequestBody emp_email,
            @Part("emp_pass") RequestBody emp_pass,
            @Part MultipartBody.Part file
    );


}
