fun main(args: Array<String>) {

    // --------- VARS ----------

    var coffeeSupplies = arrayOf("Coffee Grounds (in lbs.)", "Creamer (in gallons)", "Sugar (in lbs.)", "Coffee Filters", "Takeaway Cups", "Takeaway Lids","Cup Sleeves", "Napkins" )
    var quantity = arrayOf("50", "5", "10", "500", "1000", "1000", "750", "50" )
    var itemNumber = 1
    var bothArrays = arrayOf<Array<String>>(coffeeSupplies, quantity)


    // --------- MENU ---------

    println("ITEM #: ITEM  :  QUANTITY\n")

    var count = bothArrays[0].size -1
    for (i in 0 .. count){
        var item = bothArrays[0][i]
        var itemQty = bothArrays[1][i]

        println("$itemNumber: $item  :  $itemQty")
        itemNumber ++
    }

    println("\nEnter Item Number to Update Quantity: ")
    var choice = readln().toInt()

    //var quantityEdit = bothArrays[1][choice -1]


    if (choice in 1 .. bothArrays[0].count()) {

        var currentQuantity = bothArrays[1][choice - 1].toInt()
        println("Update: ${bothArrays[0][choice - 1]} : ${bothArrays[1][choice - 1]}")

        //---------- ADD or SUBTRACT ----------

        println("1: Add")
        println("2: Subtract")

        var choice2 = readln().toInt()

        if (choice2 == 1) {
            println("Enter amount to ADD")
            var addAmount = readln().toInt()
            var newQuantity = currentQuantity + addAmount
            quantity[choice - 1] = newQuantity.toString()
            println("Old Quantity for ${bothArrays[0][choice - 1]}: $currentQuantity")
            println("New Quantity for ${bothArrays[0][choice - 1]}: $newQuantity")


        } else if (choice2 == 2) {
            println("Enter amount to SUBTRACT")
            var subtractAmount = readln().toInt()
            var newQuantity = currentQuantity - subtractAmount


            if (newQuantity < 0) {
                println("ERROR: less than zero\nEnter New Amount")
                newQuantity += subtractAmount
                subtractAmount = readln().toInt()
                newQuantity -= subtractAmount

                quantity[choice - 1] = newQuantity.toString()
                println("Old Quantity for ${bothArrays[0][choice - 1]}: $currentQuantity")
                println("New Quantity for ${bothArrays[0][choice - 1]}: $newQuantity")

            } else {
                quantity[choice - 1] = currentQuantity.toString()
                println("Old Quantity for ${bothArrays[0][choice - 1]}: $currentQuantity")
                println("New Quantity for ${bothArrays[0][choice - 1]}: $newQuantity")
            }

        }
    }else
        println("Error: Choice Out of Range")

}