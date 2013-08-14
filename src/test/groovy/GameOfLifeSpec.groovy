import spock.lang.Specification

import static GameOfLife.nextGeneration

class GameOfLifeSpec extends Specification {

    def "dead field stays dead"() {
        expect:
        nextGeneration([]) == [] as Set
        nextGeneration() == [] as Set
    }

    def "living cell with no living neighbours will die"() {
        expect:
        nextGeneration([[1, 1]]) == [] as Set
    }

    def "living cell with one living neighbours will die"() {
        expect:
        nextGeneration([[1, 1], [1, 2]]) == [] as Set
    }

    def "living cell with two living neighbours will survive"() {
        expect:
        nextGeneration([[1, 1], [1, 2], [2, 1]]).contains([1, 1])
    }

    def "living cell with three living neighbours will survive"() {
        expect:
        nextGeneration([[1, 1], [1, 2], [2, 1], [2, 2]]).contains([1, 1])
    }

    def "living cell with four living neighbours will die"() {
        expect:
        !nextGeneration([[0, 0], [1, 1], [1, 2], [2, 1], [2, 2]]).contains([1, 1])
    }

    def "living cell with five living neighbours will die"() {
        expect:
        !nextGeneration([[0, 0], [0, 1], [1, 1], [1, 2], [2, 1], [2, 2]]).contains([1, 1])
    }

    def "living cell with six living neighbours will die"() {
        expect:
        !nextGeneration([[0, 0], [0, 1], [0, 2], [1, 1], [1, 2], [2, 1], [2, 2]]).contains([1, 1])
    }

    def "living cell with seven living neighbours will die"() {
        expect:
        !nextGeneration([[0, 0], [0, 1], [0, 2], [1, 0], [1, 1], [1, 2], [2, 1], [2, 2]]).contains([1, 1])
    }

    def "living cell with eight living neighbours will die"() {
        expect:
        !nextGeneration([[0, 0], [0, 1], [0, 2], [1, 0], [1, 1], [1, 2], [2, 0], [2, 1], [2, 2]]).contains([1, 1])
    }

    def "dead cell with one living neighbour will stay dead"() {
        expect:
        !nextGeneration([[0, 0]]).contains([1, 1])
    }

    def "dead cell with two living neighbours will stay dead"() {
        expect:
        !nextGeneration([[0, 0], [0, 2]]).contains([1, 1])
    }

    def "dead cell with three living neighbours will live"() {
        expect:
        nextGeneration([[0, 0], [0, 2], [2, 2]]) == [[1, 1]] as Set
    }

    def "dead cell with four living neighbours will stay dead"() {
        expect:
        !nextGeneration([[0, 0], [0, 2], [2, 0], [2, 2]]).contains([1, 1])
    }

}
