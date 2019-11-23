package come.texi.recyclerviewsimplified.network

import come.texi.recyclerviewsimplified.utils.ApiException
import retrofit2.Response

abstract class SafeApiRequest {
    suspend fun<T:Any> apiRequset(call:suspend ()->Response<T>):T
    {
        val response=call.invoke()
        if(response.isSuccessful)
        {
            return  response.body()!!
        }else
        {
        throw ApiException(response.code().toString())
        }
    }
}