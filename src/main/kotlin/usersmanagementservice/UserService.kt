package usersmanagementservice

import org.springframework.stereotype.Repository

@Repository
interface UserService {

    fun createUser(userBoundary: UserBoundary):UserBoundary
    fun getUserByEmail(email:String): UserBoundary
    fun login(email:String,password:String):UserBoundary
    fun updateUser(email:String): UserBoundary
    fun deleteUsers()
    fun getAllUsers(size: Int, page: Int, sortBy: String, order: String):ArrayList<UserBoundary>
}