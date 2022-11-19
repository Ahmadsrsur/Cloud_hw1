package usersmanagementservice

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Lob
import javax.persistence.Table
import kotlin.collections.ArrayList

@Entity
@Table(name = "USERS")
class UserEntity() {


    @Id @GeneratedValue var id:Long? = null
    var email:String? = null
    var firstName:String? = null
    var lastName:String? = null
    var birthdate: Date? = null
    @Lob var roles:String? =null


}
