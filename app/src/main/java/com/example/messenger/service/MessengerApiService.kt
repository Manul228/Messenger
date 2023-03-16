package com.example.messenger.service

import com.example.messenger.data.remote.request.LoginRequestObject
import com.example.messenger.data.remote.request.MessagerRequestObject
import com.example.messenger.data.remote.request.StatusUpdateRequestObject
import com.example.messenger.data.remote.request.UserRequestObject
import com.example.messenger.data.vo.*
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.*

interface MessengerApiService {
    @POST("login")
    @Headers("Content-Type: application/json")
    fun login(@Body user: LoginRequestObject): Observable<retrofit2.Response<ResponseBody>>

    @POST("users/registrations")
    fun createUser(@Body user: UserRequestObject): Observable<UserVO>

    @GET("users")
    fun listUsers(@Header("Authorization") authorization: String): Observable<UserListVO>

    @PUT("users")
    fun updateUserStatus(
        @Body request: StatusUpdateRequestObject,
        @Header("Authorization") authorization: String
    ): Observable<UserVO>

    @GET("users/{userId}")
    fun showUser(
        @Path("userId") userId: Long,
        @Header("Authorization") authorization: String
    ): Observable<UserVO>

    @GET("users/details")
    fun echoDetails(
        @Header("Authorization") authorization: String
    ): Observable<UserVO>

    @POST("messages")
    fun createMessage(
        @Body messageRequestObject: MessagerRequestObject,
        @Header("Authorization") authorization: String
    ): Observable<MessageVO>

    @GET("conversations")
    fun listConversations(
        @Header("Authorization") authorization: String
    ): Observable<ConversationListVO>

    @GET("conversations/{conversationId}")
    fun showConversation(
        @Path("conversationId") conversationId: Long,
        @Header("Authorization") authorization: String
    ): Observable<ConversationVO>

    companion object Factory {
        private var service: MessengerApiService? = null
    }
}