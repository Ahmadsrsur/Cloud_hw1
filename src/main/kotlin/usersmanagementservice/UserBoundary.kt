package usersmanagementservice

import java.util.Date

class UserBoundary {

    var id:String? = null
    var email:String? = null
    var name:Map<String,String>? =null
    var birthdate:String? = null
    var roles:ArrayList<String>? = null

    override fun toString(): String {
        return "userBoundary(id=$id, email=$email, name=$name, birthdate=$birthdate, roles=$roles)"
    }


}
