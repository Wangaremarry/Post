package mary.dev.mypost


data class Post(
    var userIdval :Int,
    var id:Int,
    var title:String,
    var body:String
)
 data class Comment(
    var postId :Int,
    var id:Int,
    var title:String,
    var email:String,
    var body:String
)
//fun <T>compareIds(item1:T,item2: T):T{
//    var output =(item1.toString()+ item2.toString())
//    println(output)
//    return item1
//}
//
//fun stage(){
//    var post1=Post(1,2,"abc","der")
//    var post2=Post(3,1"erf","qwe")
//    compareIds(post1,post2)
//
//}


