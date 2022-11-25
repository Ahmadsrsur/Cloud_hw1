package usersmanagementservice

import org.springframework.data.jpa.repository.JpaRepository

interface UserCrud:JpaRepository<UserEntity,String> {  // the id in email so its String
}