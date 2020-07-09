import com.enums.SocialNetwork
import com.utils.DateUtilities

class MainApplication {

    static void main(String[] args) {
        println("Hello world!")

        println(SocialNetwork.getSocialNetworkData("Facebook"))
        println(SocialNetwork.getSocialNetworkData(SocialNetwork.GITHUB.value))
        println(DateUtilities.getFirstDayOfYear(2019).withTimeAtStartOfDay())
        println(DateUtilities.getLastDayOfYear(2019).withTime(23,59,59,0))
    }
    
}
