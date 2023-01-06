import java.util.Scanner

fun main() {
    val sizeInEmpty = '-'
    val cross = 'X'
    val zeiro = 'O'
    val sizeFieldield: Int = 2
    var crossBarTurn: Boolean = true
    var field = arrayOf<Array<Char>>()

    for (i in 0..sizeFieldield) {
        var array = arrayOf<Char>()
        for (j in 0..sizeFieldield) {
            array += sizeInEmpty
        }
        field += array
    }
    fun printField() {
        for (array in field) {
            for (a in array) {
                print("$a ")
            }
            println()
        }
    }

    fun isWin(arrays: Array<Array<Char>>, c: Char): Boolean {
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c)
            return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c)
            return true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c)
            return true;

        if (field[0][0] == c && field[1][0] == c && field[2][0] == c)
            return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c)
            return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c)
            return true;

        if (field[0][0] == c && field[1][1] == c && field[2][2] == c)
            return true;
        if (field[2][0] == c && field[1][1] == c && field[0][2] == c)
            return true;

        return false;
    }

    while (true) {
        println("Now  turn  is " + (if (crossBarTurn) "Cross" else "Zero"))
        printField()
        val next = Scanner(System.`in`).nextLine()
        val charsplit = next.split(" ").map { it.toInt() }
        val x = charsplit[0] - 1
        val y = charsplit[1] - 1


        if (field[x][y] != sizeInEmpty) {
            println("you can't go here")
            continue
        }
        field[x][y] = if (crossBarTurn) cross else zeiro
        if (isWin(field, if (crossBarTurn) cross else zeiro)) {
            println("_________________________________________________")
            println("Win is " + (if (crossBarTurn) "Cross" else "Zero"))
            printField()
            println("_________________________________________________")
            break
        } else {
            crossBarTurn = !crossBarTurn

        }


    }


}