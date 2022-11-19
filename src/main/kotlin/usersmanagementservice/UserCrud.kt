package usersmanagementservice

import org.springframework.data.jpa.repository.JpaRepository

interface UserCrud:JpaRepository<UserEntity,Long> {
}