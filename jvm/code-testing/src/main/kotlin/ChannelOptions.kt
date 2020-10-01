fun main(args: Array<String>) {

    val channelType = try {
        ChannelType.valueOf("OTAS")
    } catch (e: IllegalArgumentException) {
        null
    }

    println(channelType)
}
