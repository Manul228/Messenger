package com.example.messenger.data.remote.repository

import com.example.messenger.data.vo.ConversationListVO
import com.example.messenger.data.vo.ConversationVO
import io.reactivex.Observable

interface ConversationRepository {
    fun findConversationById(id: Long): Observable<ConversationVO>
    fun all(): Observable<ConversationListVO>
}