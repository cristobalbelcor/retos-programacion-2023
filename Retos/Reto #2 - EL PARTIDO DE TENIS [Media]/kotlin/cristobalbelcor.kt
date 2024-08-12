/*
 * Escribe un programa que muestre cómo transcurre un juego de tenis y quién lo ha ganado.
 * El programa recibirá una secuencia formada por "P1" (Player 1) o "P2" (Player 2), según quien
 * gane cada punto del juego.
 *
 * - Las puntuaciones de un juego son "Love" (cero), 15, 30, 40, "Deuce" (empate), ventaja.
 * - Ante la secuencia [P1, P1, P2, P2, P1, P2, P1, P1], el programa mostraría lo siguiente:
 *   15 - Love
 *   30 - Love
 *   30 - 15
 *   30 - 30
 *   40 - 30
 *   Deuce
 *   Ventaja P1
 *   Ha ganado el P1
 * - Si quieres, puedes controlar errores en la entrada de datos.
 * - Consulta las reglas del juego si tienes dudas sobre el sistema de puntos.
 */
import kotlin.math.abs

fun main() {
    // Secuencia de ejemplo
    val points1 = arrayOf("P1", "P1", "P2", "P2", "P1", "P2", "P1", "P1")
    val points2 = arrayOf("P1", "P1", "P2", "P2", "P1", "P2", "P1", "P1", "P2", "P1")
    val points3 = arrayOf("P1", "P1", "P1", "P1", "P1", "P1")
    val points4 = arrayOf("P1", "P1")
    val points5 = arrayOf("P2", "P2", "P1", "P1", "P2", "P2", "P2") // Ejemplo en el que gana P2

    // Llamada a la función para mostrar el progreso del juego
    tenisGame(points1)
    println()
    tenisGame(points2)
    println()
    tenisGame(points3)
    println()
    tenisGame(points4)
    println()
    tenisGame(points5) // Nueva prueba
}

private fun tenisGame(points: Array<String>) {
    val game = arrayOf("Love", "15", "30", "40")
    var p1Points = 0
    var p2Points = 0
    var finished = false
    var error = false

    points.forEach { player ->
        error = finished

        when (player) {
            "P1" -> p1Points += 1
            "P2" -> p2Points += 1
            else -> {
                println("Entrada inválida: $player")
                return
            }
        }

        if (p1Points >= 3 && p2Points >= 3) {
            if (abs(p1Points - p2Points) == 0) {
                println("Deuce")
            } else if (abs(p1Points - p2Points) == 1) {
                println(if (p1Points > p2Points) "Ventaja P1" else "Ventaja P2")
            } else {
                finished = true
                return println(if (p1Points > p2Points) "Ha ganado el P1" else "Ha ganado el P2")
            }
        } else {
            if (p1Points < 4 && p2Points < 4) {
                println("${game[p1Points]} - ${game[p2Points]}")
            } else {
                finished = true
                return println(if (p1Points > p2Points) "Ha ganado el P1" else "Ha ganado el P2")
            }
        }
    }

    if (!error && !finished) {
        println(if (p1Points > p2Points) "Ha ganado el P1" else "Ha ganado el P2")
    } else if (error) {
        println("Los puntos jugados no son correctos")
    }
}
