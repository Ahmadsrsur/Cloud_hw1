package usersmanagementservice

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    @Autowired val userService: UserService
) {

    @RequestMapping(
        path = ["/users"],
        method = [RequestMethod.POST],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createUser(@RequestBody userBoundary:UserBoundary):UserBoundary{
        return this.userService.createUser(userBoundary)
    }

    @RequestMapping(
        path = ["/users/byEmail/{email}"],
        method = [RequestMethod.GET],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getUserByEmail(@RequestParam email:String):UserBoundary{
        return this.userService.getUserByEmail(email)
    }

    @RequestMapping(
        path = ["/users/login/{email}?password={password}"],
        method = [RequestMethod.GET],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun login(@PathVariable("email") email:String ,@PathVariable("password") password:String):UserBoundary{
        return this.userService.login(email,password)
    }

    @RequestMapping(
        path = ["/users/{email}"],
        method = [RequestMethod.PUT],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun updateUser(@PathVariable("email") email:String):UserBoundary{
        return this.userService.updateUser(email)
    }

    @RequestMapping(
        path = ["/users"],
        method = [RequestMethod.DELETE])
    fun deleteUsers(){
        return this.userService.deleteUsers()
    }


  //  @RequestParam -- when you have a ?
    // @PathVariable -- if you have a parameter in URL like " /hello/{messageid} "
    @RequestMapping(
        path = ["/users/search?size={size}&page={page} &sortBy={sortAttribute}&sortOrder={order}"],
        method = [RequestMethod.GET],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllUsers(@RequestParam("size") size:Int ,
                    @RequestParam("page") page:Int,
                    @RequestParam("sortAttribute") sortBy:String,
                    @RequestParam("order") order:String):ArrayList<UserBoundary>?{
        var alist: ArrayList<UserBoundary>? = userService.getAllUsers(size,page,sortBy,order)
        return alist
    }

    // GET /users/search?criteriaType=byEmailDomain&criteriaValue={value}&size={size}&page={page}&sortBy={sortAttribute}&sortOrder={order}
    // for example in the mail srsurahmad@gmail.com , if I sorted byEmailDomain so the criteriaValue = gmail.com

    @RequestMapping(
        path = ["/users/search?criteriaType=byEmailDomain&criteriaValue={value}&size={size}&page={page}&sortBy={sortAttribute}&sortOrder={order}"],
        method = [RequestMethod.GET],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllUsersByEmailDomain(@RequestParam("value") domain:String ,
                    @RequestParam("size") size:Int,
                    @RequestParam("page") page:Int,
                    @RequestParam("sortAttribute") sortBy: String,
                    @RequestParam("order") order :String):ArrayList<UserBoundary>?{
        var alist: ArrayList<UserBoundary>? = userService.getAllUsers(size,page,sortBy,order)
        return alist


    }








}