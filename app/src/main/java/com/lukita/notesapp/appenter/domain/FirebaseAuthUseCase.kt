package com.lukita.notesapp.appenter.domain

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.lukita.notesapp.appenter.registration.data.UserRegistrationInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject

sealed class FirebaseResult<out T> {
    data class Success<out T>(val data: T) : FirebaseResult<T>()
    data class Failure(val error: Throwable) : FirebaseResult<Nothing>()
}

class FirebaseAuthUseCase @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) {

    suspend fun loginUser(email: String, password: String): FirebaseResult<FirebaseUser?> = withContext(Dispatchers.IO){
        return@withContext try {
            val authResult = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            FirebaseResult.Success(authResult.user)
        } catch (e: Exception) {
            FirebaseResult.Failure(e)
        }
    }

    suspend fun registerUserOnFirebase(user: UserRegistrationInfo): FirebaseResult<FirebaseUser?> = withContext(Dispatchers.IO) {
        return@withContext try {
            val authResult = firebaseAuth.createUserWithEmailAndPassword(user.email, user.password).await()
            FirebaseResult.Success(authResult.user)
        } catch (e: Exception) {
            FirebaseResult.Failure(e)
        }
    }

    fun logOutUser() {
        firebaseAuth.signOut()
    }
}